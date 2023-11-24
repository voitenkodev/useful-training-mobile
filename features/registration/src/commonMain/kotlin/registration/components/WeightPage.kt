package registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp
import atom.Design
import kg
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH1
import molecule.TextH2
import molecule.secondaryBackground
import platformBottomInset
import weightpicker.WeightPicker
import weightpicker.WeightPickerStyle

@Composable
internal fun WeightPage(
    weight: Int,
    updateWeight: (Int) -> Unit,
    confirm: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingM()

        TextH2(provideText = { "Your weight" })

        TextBody2(provideText = { "Enter your current weight!" })

        PaddingWeight()

        TextH1(provideText = { weight.kg() })

        PaddingWeight()

        WeightPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clipToBounds(),
            initial = weight,
            onValueChange = updateWeight,
            pickerStyle = WeightPickerStyle(
                scaleWidth = 140.dp,
                tenStepLineColor = Design.colors.content,
                fiveStepLineColor = Design.colors.orange,
                normalLineColor = Design.colors.caption,
                indicatorColor = Design.colors.toxic,
                backgroundColor = Design.colors.secondary
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .platformBottomInset(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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
