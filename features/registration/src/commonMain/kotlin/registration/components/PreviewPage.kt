package registration.components

import Design
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.inputs.InputName
import molecular.ButtonPrimary
import molecular.ButtonSmall
import molecular.PaddingL
import molecular.PaddingS
import molecular.PaddingWeight
import molecular.TextBody1
import molecular.TextH2

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