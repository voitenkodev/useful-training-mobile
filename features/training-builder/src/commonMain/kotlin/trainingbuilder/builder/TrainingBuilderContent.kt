package trainingbuilder.builder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PopupSheet
import molecule.TextLabel
import molecule.primaryBackground
import trainingbuilder.builder.components.Exercise
import trainingbuilder.builder.components.Header
import trainingbuilder.builder.components.TrainingOverview
import trainingbuilder.builder.popups.FindExercisePopup
import trainingbuilder.builder.popups.SetExercisePopup
import trainingbuilder.builder.state.Exercise
import trainingbuilder.builder.state.SetExercisePopupState

@Composable
internal fun TrainingBuilderContent(
    vm: TrainingBuilderViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    if (state.findExercisePopupIsVisibleIndex) PopupSheet(
        onDismiss = vm::closeFindExercisePopup,
        content = { hideLambda ->
            FindExercisePopup(
                close = hideLambda,
                exerciseExamples = state.exerciseExamples,
                muscles = state.muscles,
                setMuscleTarget = vm::setMuscleTarget,
                selectedMuscle = state.selectedMuscle,
                selectExercise = vm::openAddExercisePopup,
                createExercise = vm::openAddExercisePopup
            )
        }
    )

    (state.setExercisePopupState as? SetExercisePopupState.Opened)?.let { popupState ->
        PopupSheet(
            onDismiss = vm::closeSetExercisePopup,
            content = { hideLambda ->

                val selectedExercise = remember(
                    popupState.index,
                    state.training.exercises
                ) { state.training.exercises.getOrNull(popupState.index) }

                SetExercisePopup(
                    close = hideLambda,
                    index = popupState.index,
                    selectedExercise = selectedExercise,
                    exerciseExample = popupState.exerciseExample,
                    save = vm::saveExercise,
                    openExerciseExampleDetails = {}
                )
            }
        )
    }

    Content(
        error = state.error,
        clearError = vm::clearError,
        addExercise = vm::openFindExercisePopup,
        exercises = state.training.exercises,
        selectExercise = vm::openAddExercisePopup,
        finish = { vm.saveTraining { close.invoke() } }
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    exercises: ImmutableList<Exercise>,
    addExercise: () -> Unit,
    selectExercise: (index: Int) -> Unit,
    finish: () -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Header(
                finish = finish,
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

                    TrainingOverview()
                }

                item("exercise_title") {

                    TextLabel(provideText = { "Exercises" })
                }

                itemsIndexed(exercises) { index, item ->
                    Exercise(
                        number = index + 1,
                        exercise = item,
                        onClick = { selectExercise.invoke(index) }
                    )
                }

                item("add_exercise") {
                    ButtonPrimary(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Add Exercise",
                        textColor = Design.colors.primary,
                        backgroundColor = Design.colors.toxic,
                        onClick = addExercise
                    )
                }
            }
        }
    }
}