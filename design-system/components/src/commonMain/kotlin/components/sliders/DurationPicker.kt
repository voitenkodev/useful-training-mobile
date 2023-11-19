package components.sliders

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.chips.Chip
import components.chips.ChipState

@Composable
public fun DurationPicker(
    modifier: Modifier = Modifier,
    label: String,
    onValueChange: (Float) -> Unit,
    range: ClosedFloatingPointRange<Float>,
    initial: Float,
    steps: Int
) {
    val sliderPosition = remember { mutableStateOf(initial) }

    Slider(
        modifier = modifier,
        value = sliderPosition.value,
        onValueChange = {
            sliderPosition.value = it
            onValueChange(it)
        },
        colors = SliderDefaults.colors(
            activeTrackColor = Design.colors.toxic,
            inactiveTrackColor = Design.colors.caption
        ),
        valueRange = range,
        steps = steps,
        onValueChangeFinished = {},
        thumb = {
            Chip(
                modifier = Modifier.width(92.dp),
                chipState = ChipState.Colored(
                    backgroundColor = Design.colors.orange,
                    borderColor = Design.colors.orange,
                    contentColor = Design.colors.content
                ),
                text = label
            )
        }
    )
}