package authentication.register.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import cmToM
import components.BottomButtons
import components.cards.MetricPickerCard
import grToKg
import kg
import meter
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingL
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.PaddingXXL
import molecule.TextBody1
import molecule.TextH1
import resources.Icons

@Composable
internal fun WeightPage(
    weight: Int,
    updateWeight: (Int) -> Unit,
    height: Int,
    updateHeight: (Int) -> Unit,
    confirm: () -> Unit,
    back: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {

        PaddingL()

        TextH1(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideText = { "Weight & Height" },
            textAlign = TextAlign.Center
        )

        PaddingXS()

        TextBody1(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideText = { "Enter your current weight and height!" },
            textAlign = TextAlign.Center,
            color = Design.colors.label
        )

        PaddingXXL()

        MetricPickerCard(
            title = "Weight",
            icon = Icons.weight,
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            value = weight,
            provideTitle = { it.grToKg().kg(true) },
            providePickerTitle = { it.grToKg().toInt().toString() },
            updateValue = updateWeight,
            minimal = 300,
            maximum = 3000,
            spaceInterval = 18,
        )

        PaddingL()

        MetricPickerCard(
            title = "Height",
            icon = Icons.height,
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            value = height,
            provideTitle = { it.cmToM().meter(true) },
            providePickerTitle = { it.cmToM().meter(false) },
            updateValue = updateHeight,
            minimal = 110,
            maximum = 250,
            spaceInterval = 30
        )

        PaddingWeight()

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