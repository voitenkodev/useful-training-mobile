package trainingbuilder.builder

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
import molecule.PopupSheet
import trainingbuilder.builder.components.Exercise
import trainingbuilder.builder.components.Footer
import trainingbuilder.builder.components.Header
import trainingbuilder.builder.popups.FindExercisePopup
import trainingbuilder.builder.popups.SetExercisePopup
import trainingbuilder.builder.state.Exercise

@Composable
internal fun TrainingBuilderContent(
    vm: TrainingBuilderViewModel,
    toSummary: (trainingId: String) -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    if (state.setExercisePopupVisibleIndex != -1) PopupSheet(
        onDismiss = vm::closeSetExercisePopup,
        content = { hideLambda ->

            val selectedExercise = remember(
                state.setExercisePopupVisibleIndex,
                state.training.exercises
            ) { state.training.exercises.getOrNull(state.setExercisePopupVisibleIndex) }

            SetExercisePopup(
                close = hideLambda,
                index = state.setExercisePopupVisibleIndex,
                selectedExercise = selectedExercise,
                exerciseExample = null,
                save = vm::saveExercise
            )
        }
    )

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

    Content(
        error = state.error,
        clearError = vm::clearError,
        addExercise = vm::openFindExercisePopup,
        exercises = state.training.exercises,
        selectExercise = vm::openSetExercisePopup
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,
    exercises: ImmutableList<Exercise>,
    addExercise: () -> Unit,
    selectExercise: (index: Int) -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Header()

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentPadding = PaddingValues(vertical = Design.dp.paddingM)
            ) {
                itemsIndexed(exercises) { index, item ->
                    Exercise(
                        number = index + 1,
                        exercise = item,
                        onClick = { selectExercise.invoke(index) }
                    )
                }
            }

            Footer(addExercise = addExercise)
        }
    }
}