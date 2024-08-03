package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import cmToM
import heightpicker.HeightPicker
import heightpicker.HeightPickerStyle
import meter
import molecule.ButtonPrimary
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody2
import molecule.TextH1
import molecule.TextH2
import molecule.secondaryBackground

@Composable
internal fun HeightPage(
    height: Int,
    updateHeight: (Int) -> Unit,
    confirm: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingXXL()

        TextH2(provideText = { "Your height" }, textAlign = TextAlign.Center)

        PaddingXS()

        TextBody2(
            provideText = { "Enter your current height!" },
            textAlign = TextAlign.Center,
            color = Design.colors.caption
        )

        PaddingWeight()

        TextH1(provideText = { height.cmToM().meter(true) })

        PaddingWeight()

        HeightPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .clipToBounds(),
            pickerStyle = HeightPickerStyle(
                backgroundColor = Design.colors.secondary,
                tenStepLineColor = Design.colors.content,
                fiveStepLineColor = Design.colors.orange,
                normalLineColor = Design.colors.caption,
                indicatorColor = Design.colors.toxic
            ),
            initial = height,
            onValueChange = updateHeight
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ButtonPrimary(
                modifier = Modifier.width(Design.dp.componentXXL),
                text = "Confirm",
                onClick = confirm,
                enabled = true
            )

            PaddingXL()
        }
    }
}