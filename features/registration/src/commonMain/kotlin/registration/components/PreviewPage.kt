package registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import atom.Design
import brandartifacts.Alien
import brandartifacts.Planet1
import components.inputs.InputName
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextBody1
import molecule.TextH1
import molecule.TextH2

@Composable
internal fun NamePage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Design.dp.paddingM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        Planet1()

        PaddingM()

        TextH1(provideText = { "Nice to meet you." })

        TextBody1(provideText = { "How can we call you?" }, fontWeight = FontWeight.Medium)

        PaddingL()

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