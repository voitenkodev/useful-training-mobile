package configurations.components

import Design
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import molecular.MultiRangeSlider
import molecular.ThumbRangeSliderState

@Composable
public fun MuscleRangeSlider() {
    MultiRangeSlider(
        thumbs = listOf(
            ThumbRangeSliderState(
                id = "as",
                positionInRange = 40f,
                color = Color.Red
            ),
            ThumbRangeSliderState(
                id = "asd",
                positionInRange = 60f,
                color = Color.Cyan
            ),
            ThumbRangeSliderState(
                id = "ast",
                positionInRange = 70f,
                color = Color.Green
            ),
            ThumbRangeSliderState(
                id = "asy",
                positionInRange = 90f,
                color = Color.Black
            ),
        ),
        lineColor = Design.colors.caption
    )
}