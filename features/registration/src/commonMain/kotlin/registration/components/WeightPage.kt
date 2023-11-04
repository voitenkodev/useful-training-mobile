package registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atom.Design
import brandartifacts.Planet1
import kg
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH1
import platformBottomInset
import platformTopInset
import weightpicker.WeightPicker
import weightpicker.WeightPickerStyle

@Composable
internal fun WeightPage(
    weight: Int,
    updateWeight: (Int) -> Unit,
    confirm: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .platformTopInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingXL()

        Planet1()

        PaddingM()

        TextH1(provideText = { "Your weight?" })

        TextBody1(provideText = { "Helpful info for analysis!" }, fontWeight = FontWeight.Medium)

        PaddingWeight()

        TextH1(provideText = { weight.kg() })

        PaddingWeight()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clipToBounds()
                .platformBottomInset(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            WeightPicker(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                initialWeightGram = weight,
                onWeightChange = updateWeight,
                pickerStyle = WeightPickerStyle(
                    scaleWidth = 140.dp,
                    tenStepLineColor = Design.colors.content,
                    fiveStepLineColor = Design.colors.accentPrimary,
                    normalLineColor = Design.colors.caption,
                    scaleIndicatorColor = Design.colors.accentSecondary,
                    backgroundColor = Design.colors.secondary
                )
            )

            ButtonPrimary(
                modifier = Modifier,
                text = "Confirm",
                onClick = confirm,
                enabled = true
            )

            PaddingXL()
        }
    }
}
