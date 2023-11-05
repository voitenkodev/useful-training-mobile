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
import cm
import heightpicker.HeightPicker
import heightpicker.HeightPickerStyle
import molecule.ButtonPrimary
import molecule.PaddingWeight
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH1
import molecule.secondaryRoundBackground
import platformBottomInset

@Composable
internal fun HeightPage(
    height: Int,
    updateHeight: (Int) -> Unit,
    confirm: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().platformBottomInset(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PaddingXL()

        TextH1(provideText = { "Your height?" })

        TextBody1(provideText = { "Also helpful info for us!" }, fontWeight = FontWeight.Medium)

        PaddingWeight()

        TextH1(provideText = { height.cm() })

        PaddingWeight()

        HeightPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            pickerStyle = HeightPickerStyle(
                backgroundColor = Design.colors.secondary,
                tenStepLineColor = Design.colors.content,
                fiveStepLineColor = Design.colors.accentPrimary,
                normalLineColor = Design.colors.caption,
                indicatorColor = Design.colors.accentSecondary
            ),
            initial = height,
            onValueChange = updateHeight
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .secondaryRoundBackground()
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