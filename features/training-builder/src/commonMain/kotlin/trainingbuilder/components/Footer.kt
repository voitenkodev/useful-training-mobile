package trainingbuilder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import molecule.ButtonPrimary
import molecule.Shadow
import molecule.secondaryRoundBackground
import platformBottomInset

@Composable
internal fun Footer(addExercise: () -> Unit) {

    Column(modifier = Modifier.fillMaxWidth().secondaryRoundBackground()) {

        Shadow()

        Row(
            modifier = Modifier
                .padding(Design.dp.paddingM)
                .platformBottomInset(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = "Add Exercise",
                onClick = addExercise
            )
        }
    }
}