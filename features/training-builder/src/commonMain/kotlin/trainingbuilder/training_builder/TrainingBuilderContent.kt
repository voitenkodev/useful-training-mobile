package trainingbuilder.training_builder

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import components.Error
import components.overlay.BottomShadow
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import molecule.ButtonPrimary
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXS
import molecule.PopupSheet
import molecule.TextBody1
import molecule.TextH3
import molecule.TextLabel
import molecule.primaryBackground
import trainingbuilder.training_builder.components.Exercise
import trainingbuilder.training_builder.components.Header
import trainingbuilder.training_builder.components.TrainingOverview
import trainingbuilder.training_builder.popups.FindExercisePopup
import trainingbuilder.training_builder.popups.SetExercisePopup
import trainingbuilder.training_builder.state.Exercise
import trainingbuilder.training_builder.state.SetExercisePopupState

@Composable
internal fun TrainingBuilderContent(
    vm: TrainingBuilderViewModel,
    close: (trainingId: String) -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit,

    toSearchExerciseExample: () -> Unit,
    searchExerciseExampleId: Flow<String>
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        searchExerciseExampleId
            .onEach { delay(POPUP_ANIM_DURATION_MS) }
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

    (state.setExercisePopupState as? SetExercisePopupState.Opened)?.let { popupState ->
        PopupSheet(
            onDismiss = vm::closeSetExercisePopup,
            cancelable = false,
            content = { hideLambda ->

                val selectedExercise = remember(popupState.index, state.training.exercises) {
                    state.training.exercises.getOrNull(popupState.index)
                }

                SetExercisePopup(
                    close = hideLambda,
                    index = popupState.index,
                    selectedExercise = selectedExercise,
                    exerciseExample = popupState.exerciseExample,
                    save = vm::saveExercise,
                    toExerciseExampleDetails = toExerciseExampleDetails
                )
            }
        )
    }

    Content(
        error = state.error,
        loading = state.loading,
        fullFront = state.fullFrontImageVector,
        fullBack = state.fullBackImageVector,
        volume = state.training.volume,
        clearError = vm::clearError,
        addExercise = vm::openFindExercisePopup,
        exercises = state.training.exercises,
        selectExercise = vm::openAddExercisePopup,
        finish = { vm.saveTraining(close) }
    )
}

@Composable
private fun Content(
    error: String?,
    loading: Boolean,
    volume: Double,
    clearError: () -> Unit,
    exercises: ImmutableList<Exercise>,
    addExercise: () -> Unit,
    selectExercise: (index: Int) -> Unit,
    finish: () -> Unit,

    fullFront: ImageVector,
    fullBack: ImageVector
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

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
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    shape = Design.shape.default,
                                    color = Design.colors.caption
                                ).padding(Design.dp.paddingL),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            TextH3(
                                provideText = { "Let's start workout" },
                                color = Design.colors.content
                            )

                            PaddingXS()

                            TextBody1(
                                provideText = { "Add your first exercise" },
                                color = Design.colors.content
                            )

                            PaddingL()

                            ButtonPrimary(
                                modifier = Modifier.padding(horizontal = Design.dp.paddingXL),
                                text = "New exercise",
                                textColor = Design.colors.primary,
                                backgroundColor = Design.colors.toxic,
                                onClick = addExercise
                            )
                        }
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