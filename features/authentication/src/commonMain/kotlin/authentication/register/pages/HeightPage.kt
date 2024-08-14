package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import cmToM
import components.BottomButtons
import heightpicker.HeightPicker
import heightpicker.HeightPickerStyle
import meter
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.TextBody2
import molecule.TextH1
import molecule.TextH2
import molecule.secondaryBackground
import resources.Icons

@Composable
internal fun HeightPage(
    height: Int,
    updateHeight: (Int) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingL()

        TextH2(provideText = { "Height" }, textAlign = TextAlign.Center)

        PaddingXS()

        TextBody2(
            provideText = { "Enter your current height!" },
            textAlign = TextAlign.Center,
            color = Design.colors.label
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
                tenStepLineColor = Design.colors.content,
                fiveStepLineColor = Design.colors.orange,
                normalLineColor = Design.colors.label,
            ),
            initial = height,
            onValueChange = updateHeight
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            BottomButtons(
                modifier = Modifier.fillMaxWidth(),
                first = {
                    ButtonSecondary(
                        modifier = Modifier.weight(1f),
                        leadingIcon = Icons.arrowLeft,
                        text = "Back",
                        onClick = back
                    )
                },
                second = {
                    ButtonPrimary(
                        modifier = Modifier.weight(1f),
                        trailingIcon = Icons.arrowRight,
                        text = "Next",
                        onClick = confirm,
                    )
                }
            )
        }
    }
}