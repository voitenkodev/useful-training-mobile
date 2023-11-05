package registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import cm
import heightpicker.HeightPicker
import molecule.ButtonPrimary
import molecule.PaddingXL
import molecule.TextBody1
import molecule.TextH1
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

        PaddingXL()

        TextH1(provideText = { height.cm() })

        HeightPicker(
            dates = buildList { repeat(30) { add(it.toString()) } },
            value = 15f,
            onValueChange = {}
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clipToBounds()
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
