package trainingbuilder.training_builder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import components.BottomButtons
import components.Error
import components.roots.ScreenRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PopupSheet
import molecule.TextBody4
import resources.Icons
import trainingbuilder.training_builder.components.Exercise
import trainingbuilder.training_builder.components.Header
import trainingbuilder.training_builder.models.BuildExercise
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

        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            userScrollEnabled = false
        ) {

            when (it) {
                0 -> Content(
                    loading = state.loading,
                    fullFront = state.fullFrontImageVector,
                    fullBack = state.fullBackImageVector,
                    volume = state.buildTraining.volume,
                    startDateMillis = state.buildTraining.startDateTime,
                    intensity = state.buildTraining.intensity,
                    addExercise = vm::openFindExercisePopup,
                    buildExercises = state.buildTraining.buildExercises,
                    selectExercise = vm::openAddExercise,
                    finish = { vm.saveTraining { close.invoke() } }
                )

                1 -> {
                    val popupState = (state.setExerciseState as? SetExerciseState.Opened)

                    val selectedExercise =
                        remember(popupState?.index, state.buildTraining.buildExercises) {
                            state.buildTraining.buildExercises.getOrNull(popupState?.index ?: -1)
                        }

                    SetExerciseContent(
                        close = vm::closeSetExercise,
                        selectedBuildExercise = selectedExercise,
                        exerciseExample = popupState?.exerciseExample,
                        save = vm::saveExercise,
                        toExerciseExampleDetails = { id ->
                            toExerciseExampleDetails.invoke(id, false)
                        }
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
    intensity: Double,
    startDateMillis: Long,
    buildExercises: ImmutableList<BuildExercise>,
    addExercise: () -> Unit,
    selectExercise: (index: Int) -> Unit,
    finish: () -> Unit,
    fullFront: ImageVector,
    fullBack: ImageVector
) {

    Column(modifier = Modifier.fillMaxSize()) {

        Header(
            finish = finish,
            finishEnabled = buildExercises.isNotEmpty(),
            volume = volume,
            startDateMillis = startDateMillis,
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(
                vertical = Design.dp.paddingS,
                horizontal = Design.dp.paddingL
            ),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            item("exercise_title") {
                TextBody4(
                    provideText = { "EXERCISES" }
                )
            }

            itemsIndexed(buildExercises) { index, item ->
                Exercise(
                    number = index + 1,
                    buildExercise = item,
                    onClick = { selectExercise.invoke(index) }
                )
            }
        }

        BottomButtons(
            modifier = Modifier.fillMaxWidth(),
            first = {
                ButtonSecondary(
                    text = "Overview",
                    onClick = {},

                    )
            },
            second = {
                ButtonPrimary(
                    modifier = Modifier.weight(1f),
                    leadingIcon = Icons.add,
                    text = "Add Exercise",
                    onClick = addExercise,
                )
            }
        )
    }
}