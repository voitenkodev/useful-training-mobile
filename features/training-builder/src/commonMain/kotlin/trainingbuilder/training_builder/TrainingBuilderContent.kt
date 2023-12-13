package trainingbuilder.training_builder

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PopupSheet
import trainingbuilder.training_builder.components.ExercisesPage
import trainingbuilder.training_builder.components.SetExercisePage
import trainingbuilder.training_builder.popups.FindExercisePopup
import trainingbuilder.training_builder.state.SetExerciseState

@Composable
internal fun TrainingBuilderContent(
    vm: TrainingBuilderViewModel,
    close: () -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit,
    toSearchExerciseExample: () -> Unit,
    searchExerciseExampleId: Flow<String>
) {

    val state by vm.state.collectAsState()

    val backHandler = LocalRouterContext.current.backHandler
    val pagerState = rememberPagerState(pageCount = { 2 })
    backHandler.register(BackCallback { if (pagerState.currentPage == 1) vm.closeSetExercise() else close.invoke() })
    LaunchedEffect(state.setExerciseState) { pagerState.animateScrollToPage(page = if (state.setExerciseState is SetExerciseState.Opened) 1 else 0) }

    LaunchedEffect(Unit) {
        searchExerciseExampleId.onEach { delay(POPUP_ANIM_DURATION_MS) }
            .collectLatest(vm::getExerciseExampleById)
    }

    if (state.findExercisePopupIsVisibleIndex) PopupSheet(
        onDismiss = vm::closeFindExercisePopup,
        content = { hideLambda ->
            FindExercisePopup(
                close = hideLambda,
                exerciseExamples = state.exerciseExamples,
                muscles = state.muscles,
                loading = state.recommendationsLoading,
                selectedMuscle = state.selectedMuscle,
                setMuscleTarget = vm::setMuscleTarget,
                selectExercise = vm::openAddExercisePopup,
                createExercise = vm::openAddExercisePopup,
                search = toSearchExerciseExample,
                toExerciseExampleDetails = toExerciseExampleDetails
            )
        }
    )

    ScreenRoot(error = { Error(message = { state.error }, close = vm::clearError) }) {

        VerticalPager(modifier = Modifier.fillMaxSize(), state = pagerState, userScrollEnabled = false) {

            when (it) {
                0 -> ExercisesPage(
                    loading = state.loading,
                    fullFront = state.fullFrontImageVector,
                    fullBack = state.fullBackImageVector,
                    volume = state.training.volume,
                    addExercise = vm::openFindExercisePopup,
                    exercises = state.training.exercises,
                    selectExercise = vm::openAddExercisePopup,
                    finish = { vm.saveTraining { close.invoke() } }
                )

                1 -> {
                    val popupState = (state.setExerciseState as? SetExerciseState.Opened)

                    val selectedExercise = remember(popupState?.index, state.training.exercises) {
                        state.training.exercises.getOrNull(popupState?.index ?: -1)
                    }

                    SetExercisePage(
                        close = vm::closeSetExercise,
                        selectedExercise = selectedExercise,
                        exerciseExample = popupState?.exerciseExample,
                        save = vm::saveExercise,
                        toExerciseExampleDetails = toExerciseExampleDetails
                    )
                }
            }
        }
    }
}