package registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.inputs.InputName
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextBody1
import molecule.TextH2

@Composable
internal fun PreviewPage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Design.dp.paddingM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingL()

        TextH2(provideText = { "Nice to meet you." })

        PaddingL()

        TextBody1(provideText = { "How can we call you?" })

        PaddingS()

        InputName(
            onValueChange = {},
            provideValue = { "" }
        )

        PaddingWeight()

        ButtonPrimary(
            text = "Submit",
            onClick = {},
            enabled = false
        )

        PaddingL()
    }
}