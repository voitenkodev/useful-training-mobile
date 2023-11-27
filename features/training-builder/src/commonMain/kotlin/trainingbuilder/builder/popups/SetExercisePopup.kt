package trainingbuilder.builder.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.roots.PopupScreenRoot
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.primaryBackground
import trainingbuilder.builder.components.EditExercise
import trainingbuilder.builder.state.Exercise
import trainingbuilder.builder.state.ExerciseExample

@Composable
internal fun SetExercisePopup(
    exerciseExample: ExerciseExample?,
    selectedExercise: Exercise? = null,
    close: () -> Unit,
    save: (exercise: Exercise)-> Unit
) {

    val exercise = remember(selectedExercise) {
        mutableStateOf(selectedExercise ?: Exercise())
    }

    val updateName = remember {
        { value: String ->
            exercise.value = exercise.value.copy(name = value)
        }
    }

    val updateWeight = remember {
        { index: Int, value: String ->

        }
    }
    val updateRepeat = remember {
        { index: Int, value: String ->

        }
    }

    PopupScreenRoot(title = "Exercise") {

        EditExercise(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .primaryBackground()
                .verticalScroll(rememberScrollState()),
            name = { exercise.value.name },
            updateName = updateName,
            iterations = exercise.value.iterations,
            addIteration = {},
            updateIteration = {index, iteration ->  }
        )

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "cancel",
                onClick = close
            )

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                enabled = exercise.value.name.isNotBlank() && exercise.value.iterations.isNotEmpty(),
                text = "Save",
                onClick = {
                    save.invoke(exercise.value)
                    close.invoke()
                }
            )
        }
    }
}
