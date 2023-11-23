package trainingbuilder.popups

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import components.roots.PopupRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.Shadow
import trainingbuilder.components.EditExercise
import trainingbuilder.popups.components.ExerciseExamples
import trainingbuilder.popups.components.Footer
import trainingbuilder.popups.components.Muscles
import trainingbuilder.state.ExerciseExample
import trainingbuilder.state.Iteration
import trainingbuilder.state.Muscle

@Composable
internal fun SetExercisePopup(
    // Common
    close: () -> Unit,

    // Exercise
    number: () -> Int,
    iterations: () -> ImmutableList<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit,

    // Muscles
    muscles: ImmutableList<Muscle>,

    // Exercise examples
    exerciseExamples: ImmutableList<ExerciseExample>
) {

    PopupRoot(
        modifier = Modifier.fillMaxHeight(0.9f),
        title = "Add Exercise",
        close = close
    ) {

        EditExercise(
            modifier = Modifier.weight(1f).verticalScroll(rememberScrollState()),
            number = number,
            name = name,
            updateName = updateName,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat,
            iterations = iterations,
            remove = remove
        )

        Shadow()

        PaddingM()

        Muscles(
            list = muscles
        )

        PaddingM()

        Shadow()

        PaddingM()

        ExerciseExamples(
            list = exerciseExamples
        )

        PaddingM()

        Footer(
            cancel = {},
            set = {}
        )
    }
}
