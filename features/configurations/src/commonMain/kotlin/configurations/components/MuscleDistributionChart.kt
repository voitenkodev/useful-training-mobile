package configurations.components

import Design
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import molecular.MultiRangeSlider
import molecular.ThumbRangeSliderState

@Composable
public fun MuscleRangeSlider() {
    val list = remember {
        mutableStateOf(
            listOf(
                ThumbRangeSliderState(
                    id = "as",
                    positionInRange = 20,
                    color = Color.Red
                ),
                ThumbRangeSliderState(
                    id = "asd",
                    positionInRange = 30,
                    color = Color.Cyan
                ),
                ThumbRangeSliderState(
                    id = "ast",
                    positionInRange = 50,
                    color = Color.Green
                ),
            )
        )
    }
    MultiRangeSlider(
        range = 0..100,
        thumbs = list.value,
        lineColor = Design.colors.caption,
        onValueChange = { list.value = it }
    )
}