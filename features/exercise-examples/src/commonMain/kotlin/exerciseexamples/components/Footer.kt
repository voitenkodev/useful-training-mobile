package exerciseexamples.components

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
import molecule.secondaryBackground
import platformBottomInset

@Composable
internal fun Footer(addNewClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().secondaryBackground()) {
        Shadow()
        Row(
            modifier = Modifier
                .padding(Design.dp.paddingM)
                .platformBottomInset(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonPrimary(
                modifier = Modifier.fillMaxWidth(),
                text = "Add New",
                onClick = addNewClick
            )
        }
    }
}