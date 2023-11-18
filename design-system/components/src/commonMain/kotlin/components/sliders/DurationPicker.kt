package components.sliders

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
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
    label: String,
    onValueChange: (Float) -> Unit,
    range: ClosedFloatingPointRange<Float>,
    steps: Int
) {
    val sliderPosition = remember { mutableStateOf(0f) }

    val interactionSource = MutableInteractionSource()

    Slider(
        value = sliderPosition.value,
        onValueChange = {
            sliderPosition.value = it
            onValueChange(it)
        },
        valueRange = range,
        steps = steps,
        interactionSource = interactionSource,
        onValueChangeFinished = {},
        thumb = {
            Chip(
//                modifier = Modifier.width(90.dp),
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