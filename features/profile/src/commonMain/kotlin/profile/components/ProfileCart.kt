package profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import atom.Design
import molecule.ButtonSmall
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXS
import molecule.TextBody2
import molecule.TextH3
import molecule.accentSecondaryDefaultBackground

@Composable
public fun ProfileCart(
    visibility: Boolean,
    onClose: () -> Unit
) {

    Column(
        modifier = Modifier
            .accentSecondaryDefaultBackground()
            .padding(vertical = Design.dp.paddingM, horizontal = Design.dp.paddingXL)
            .fillMaxWidth()
    ) {
        TextH3(
            provideText = { "Max Voitenko" },
            color = Design.colors.primary
        )

        PaddingS()

        TextBody2(
            provideText = { "weight: ${82}kg" },
            color = Design.colors.primary
        )

        PaddingXS()

        TextBody2(
            provideText = { "height: ${179}cm" },
            color = Design.colors.primary
        )

        PaddingM()

        ButtonSmall(
            text = "Update",
            onClick = {},
            backgroundColor = Design.colors.primary
        )
    }
}