package trainingbuilder.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.roots.PopupRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.Shadow
import trainingbuilder.popups.components.ExerciseExamples
import trainingbuilder.popups.components.Muscles
import trainingbuilder.state.ExerciseExample
import trainingbuilder.state.Muscle

@Composable
internal fun FindExercisePopup(
    close: () -> Unit,
    selectedMuscle: Muscle?,
    muscles: ImmutableList<Muscle>,
    exerciseExamples: ImmutableList<ExerciseExample>,
    setMuscleTarget: (id: String) -> Unit,
    createExercise: () -> Unit,
    selectExercise: () -> Unit
) {
    PopupRoot(title = "Add Exercise") {

        PaddingM()

        if (muscles.isNotEmpty()) {

            Muscles(
                list = muscles,
                setMuscleTarget = setMuscleTarget,
                selectedMuscle = selectedMuscle
            )

            PaddingL()
        }

        ExerciseExamples(
            list = exerciseExamples
        )

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "Create Custom",
                onClick = {
                    createExercise.invoke()
                    close.invoke()
                }
            )
        }
    }
}
