package trainingbuilder.popups

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp
import atom.Design
import kg
import molecule.ButtonPrimary
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextH1
import molecule.secondaryBackground
import platformBottomInset
import weightpicker.WeightPicker
import weightpicker.WeightPickerStyle

@Composable
internal fun WeightPickerPopup(
    initialWeight: Int,
    close: () -> Unit,
    apply: (weight: Int) -> Unit
) {

    val weight = remember { mutableStateOf(initialWeight) }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingWeight()

        TextH1(provideText = { weight.value.kg() })

        PaddingWeight()

        WeightPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clipToBounds(),
            initial = weight.value,
            onValueChange = { weight.value = it },
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
                text = "Change",
                onClick = {
                    apply.invoke(weight.value)
                    close.invoke()
                }
            )

            PaddingXL()
        }
    }
}
