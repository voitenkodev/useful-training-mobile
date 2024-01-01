package weighthistory.main.popups

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp
import atom.Design
import grToKg
import kg
import molecule.ButtonPrimary
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextH1
import molecule.Toolbar
import molecule.secondaryBackground
import resources.Icons
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
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Toolbar(
            title = "",
            icon = Icons.close to close
        )

        PaddingWeight()

        TextH1(provideText = { weight.value.grToKg().kg(true) })

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
                backgroundColor = Design.colors.secondary,
                arrowColor = Design.colors.white5
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryBackground()
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ButtonPrimary(
                modifier = Modifier.width(Design.dp.componentXL),
                text = "apply",
                onClick = {
                    apply.invoke(weight.value)
                    close.invoke()
                }
            )

            PaddingXL()
        }
    }
}