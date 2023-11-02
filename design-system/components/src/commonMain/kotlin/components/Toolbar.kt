package components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import icons.ArrowLeft
import molecule.ButtonIconToolbar
import molecule.PaddingS
import molecule.TextH1

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