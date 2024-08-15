package components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import heightpicker.HeightPicker
import heightpicker.HeightPickerStyle
import molecule.Icon
import molecule.Label
import molecule.PaddingM
import molecule.TextH1

@Composable
public fun MetricPickerCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    value: Int,
    provideTitle: (Int) -> String,
    providePickerTitle: (Int) -> String,
    updateValue: (Int) -> Unit,
    minimal: Int = 110,
    maximum: Int = 250,
) {

    Column(
        modifier = modifier
            .clip(shape = Design.shape.default)
            .background(color = Design.colors.secondary)
            .padding(Design.dp.paddingL)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier.size(Design.dp.iconM),
                imageVector = icon,
                color = Design.colors.label
            )

            Label(
                provideText = { title },
            )
        }

        PaddingM()

        val valueProvider = remember(value) {
            {
                provideTitle.invoke(value)
            }
        }

        TextH1(
            provideText = valueProvider
        )

        PaddingM()

        HeightPicker(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Design.dp.paddingXS)
                .clipToBounds(),
            stringProvider = providePickerTitle,
            pickerStyle = HeightPickerStyle(
                tenStepLineColor = Design.colors.label,
                fiveStepLineColor = Design.colors.label,
                normalLineColor = Design.colors.label,
                strokeWidth = 2.dp,
                radius = 6.dp
            ),
            initial = value,
            minimal = minimal,
            maximum = maximum,
            onValueChange = updateValue
        )
    }
}