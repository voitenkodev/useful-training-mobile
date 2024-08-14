package authentication.register.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import components.BottomButtons
import grToKg
import heightpicker.HeightPicker
import heightpicker.HeightPickerStyle
import kg
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.Label
import molecule.PaddingL
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody2
import molecule.TextH1
import molecule.TextH2
import resources.Icons

@Composable
internal fun WeightPage(
    weight: Int,
    updateWeight: (Int) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingL()

        TextH2(provideText = { "Weight" }, textAlign = TextAlign.Center)

        PaddingXS()

        TextBody2(
            provideText = { "Enter your current weight!" },
            textAlign = TextAlign.Center,
            color = Design.colors.label
        )

        PaddingWeight()

        TextH1(provideText = { weight.grToKg().kg(true) })

        PaddingWeight()

        Label(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = Design.dp.paddingM),
            provideText = { "Roll to change" },
        )

        PaddingS()

        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = Design.dp.paddingM)
                .clip(shape = Design.shape.default)
                .background(
                    color = Design.colors.secondary,
//                    brush = Brush.horizontalGradient(
//                        colors = listOf(
//                            Color(0xFF4868d2),
//                            Color(0xFF60ACD4)
//                        )
//                    ),
                    shape = Design.shape.default
                )
                .padding(
                    vertical = Design.dp.paddingM,
                    horizontal = Design.dp.paddingS
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(
                Modifier
                    .size(24.dp)
                    .background(
                        shape = Design.shape.circleShape,
                        color = Design.colors.green
                    )
            )

            Spacer(
                Modifier
                    .size(width = 2.dp, height = 12.dp)
                    .background(color = Design.colors.green)
            )

            HeightPicker(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Design.shape.default)
                    .clipToBounds(),
                stringProvider = { it.grToKg().toInt().toString() },
                pickerStyle = HeightPickerStyle(
                    tenStepLineColor = Design.colors.white30,
                    fiveStepLineColor = Design.colors.white30,
                    normalLineColor = Design.colors.white30,
                    strokeWidth = 2.dp
                ),
                initial = weight,
                minimal = 300,
                maximum = 3000,
                onValueChange = updateWeight
            )
        }

        PaddingXXL()

        PaddingXXL()

        Column(
            modifier = Modifier
                .fillMaxWidth(),
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