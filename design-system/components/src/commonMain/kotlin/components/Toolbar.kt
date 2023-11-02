package components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import icons.ArrowLeft
import molecular.molecule.ButtonIconToolbar
import molecular.molecule.PaddingS
import molecular.molecule.TextH1

@Composable
public fun Toolbar(
    text: String,
    back: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        ButtonIconToolbar(imageVector = ArrowLeft, onClick = back)

        PaddingS()

        TextH1(provideText = { text })
    }
}