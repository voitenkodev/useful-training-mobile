package trainingbuilder.training_builder.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.inputs.InputSearch
import components.roots.PopupRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.SmallToolbar
import resources.Icons
import trainingbuilder.training_builder.popups.components.ExerciseExamples
import trainingbuilder.training_builder.popups.components.Muscles
import trainingbuilder.training_builder.state.ExerciseExample
import trainingbuilder.training_builder.state.Muscle

@Composable
internal fun FindExercisePopup(
    close: () -> Unit,
    selectedMuscle: Muscle?,
    muscles: ImmutableList<Muscle>,
    exerciseExamples: ImmutableList<ExerciseExample>,
    setMuscleTarget: (id: String) -> Unit,
    createExercise: () -> Unit,
    selectExercise: (ExerciseExample) -> Unit
) {
    PopupRoot {

        PaddingS()

        SmallToolbar(
            title = "Find Exercise",
            icon = Icons.close to close
        )

        Shadow()

        PaddingM()

        InputSearch(
            provideName = { "" },
            update = {}
        )

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
            list = exerciseExamples,
            select = { selectExercise.invoke(it); close.invoke() }
        )

        PaddingM()

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "Create by own",
                onClick = { createExercise.invoke(); close.invoke() }
            )
        }
    }
}
