package trainingbuilder.builder.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.roots.PopupScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import trainingbuilder.builder.components.EditExercise
import trainingbuilder.builder.state.Iteration

@Composable
internal fun SetExercisePopup(
    close: () -> Unit,
    number: () -> Int,
    iterations: () -> ImmutableList<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit
) {

    PopupScreenRoot(title = "Add Exercise") {

        EditExercise(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()),
            number = number,
            name = name,
            updateName = updateName,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat,
            iterations = iterations
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
                text = "Set",
                onClick = {
                    close.invoke()
                }
            )
        }
    }
}
