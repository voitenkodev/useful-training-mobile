package configurations.components

import Design
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import molecular.MultiThumbRangeSlider

@Composable
public fun MuscleRangeSlider() {
    val thumbs = remember { mutableStateOf(listOf(10, 20, 50, 80)) }
    var trackColor by remember { mutableStateOf(Color.Gray) }

    MultiThumbRangeSlider(
        thumbs = listOf(
            "as" to 40f,
            "asd" to 55f,
            "ewq" to 90f
        ),
        lineColor = Design.colors.caption
    )
}