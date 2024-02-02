package trainingbuilder.training_builder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.cards.ActionCard
import components.overlay.BottomShadow
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PopupSheet
import molecule.TextLabel
import molecule.primaryBackground
import trainingbuilder.training_builder.components.Exercise
import trainingbuilder.training_builder.components.Header
import trainingbuilder.training_builder.components.TrainingOverview
import trainingbuilder.training_builder.models.Exercise
import trainingbuilder.training_builder.models.SetExerciseState
import trainingbuilder.training_builder.pages.set_exercise.SetExerciseContent
import trainingbuilder.training_builder.popups.FindExercisePopup

@Composable
internal fun TrainingBuilderContent(
    vm: TrainingBuilderViewModel,
    close: () -> Unit,
    toExerciseExampleDetails: (id: String, isSelectable: Boolean) -> Unit,
    toSearchExerciseExample: () -> Unit,
    searchExerciseExampleId: String?
) {

    val state by vm.state.collectAsState()

    val backHandler = LocalRouterContext.current.backHandler
    val pagerState = rememberPagerState(pageCount = { 2 })
    backHandler.register(BackCallback { if (pagerState.currentPage == 1) vm.closeSetExercise() else close.invoke() })
    LaunchedEffect(state.setExerciseState) { pagerState.animateScrollToPage(page = if (state.setExerciseState is SetExerciseState.Opened) 1 else 0) }

    LaunchedEffect(searchExerciseExampleId) {
        if (searchExerciseExampleId != null) {
            vm.getExerciseExampleById(searchExerciseExampleId)
        }
//        searchExerciseExampleId.onEach { delay(POPUP_ANIM_DURATION_MS) }
//            .collectLatest(vm::getExerciseExampleById)
    }

    if (state.findExercisePopupIsVisible) PopupSheet(
        onDismiss = vm::closeFindExercisePopup,
        content = { hideLambda ->
            FindExercisePopup(
                close = hideLambda,
                exerciseExamples = state.exerciseExamples,
                muscles = state.muscles,
                loading = state.recommendationsLoading,
                selectedMuscle = state.selectedMuscle,
                setMuscleTarget = vm::setMuscleTarget,
                selectExercise = vm::openAddExercise,
                createExercise = vm::openAddExercise,
                search = toSearchExerciseExample,
                toExerciseExampleDetails = { id -> toExerciseExampleDetails.invoke(id, true) }
            )
        }
    )

    ScreenRoot(error = { Error(message = { state.error }, close = vm::clearError) }) {

        VerticalPager(modifier = Modifier.fillMaxSize(), state = pagerState, userScrollEnabled = false) {

            when (it) {
                0 -> Content(
                    loading = state.loading,
                    fullFront = state.fullFrontImageVector,
                    fullBack = state.fullBackImageVector,
                    volume = state.training.volume,
                    addExercise = vm::openFindExercisePopup,
                    exercises = state.training.exercises,
                    selectExercise = vm::openAddExercise,
                    finish = { vm.saveTraining { close.invoke() } }
                )

                1 -> {
                    val popupState = (state.setExerciseState as? SetExerciseState.Opened)

                    val selectedExercise = remember(popupState?.index, state.training.exercises) {
                        state.training.exercises.getOrNull(popupState?.index ?: -1)
                    }

                    SetExerciseContent(
                        close = vm::closeSetExercise,
                        selectedExercise = selectedExercise,
                        exerciseExample = popupState?.exerciseExample,
                        save = vm::saveExercise,
                        toExerciseExampleDetails = { id -> toExerciseExampleDetails.invoke(id, false) }
                    )
                }
            }
        }
    }
}

@Composable
internal fun Content(
    loading: Boolean,
    volume: Double,
    exercises: ImmutableList<Exercise>,
    addExercise: () -> Unit,
    selectExercise: (index: Int) -> Unit,
    finish: () -> Unit,
    fullFront: ImageVector,
    fullBack: ImageVector
) {
    Box {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(
                finish = finish,
                loading = loading,
                finishEnabled = exercises.isNotEmpty()
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f).primaryBackground(),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                item(key = "overview") {

                    TextLabel(provideText = { "Overview" })

                    PaddingM()

                    TrainingOverview(
                        fullFrontImage = fullFront,
                        fullBackImage = fullBack,
                        volume = volume
                    )
                }

                item("exercise_title") {
                    TextLabel(provideText = { "Exercises" })
                }

                if (exercises.isEmpty()) {
                    item {
                        ActionCard(
                            modifier = Modifier.fillMaxWidth(),
                            title = "Let's start workout",
                            description = "Add your first exercise",
                            btnText = "New exercise",
                            onClick = addExercise
                        )
                    }
                }

                itemsIndexed(exercises) { index, item ->
                    Exercise(
                        number = index + 1,
                        exercise = item,
                        onClick = { selectExercise.invoke(index) }
                    )
                }

                item("add_exercise") {
                    Spacer(
                        modifier = Modifier
                            .navigationBarsPadding()
                            .size(Design.dp.componentM + Design.dp.paddingS)
                    )
                }
            }
        }

        if (exercises.isNotEmpty()) {
            BottomShadow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                    .navigationBarsPadding()
                    .size(Design.dp.componentM + Design.dp.paddingM)
            )

            ButtonPrimary(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .navigationBarsPadding()
                    .padding(Design.dp.paddingM),
                text = "New exercise",
                textColor = Design.colors.primary,
                backgroundColor = Design.colors.toxic,
                onClick = addExercise
            )
        }
    }
}