package configurations.components

import Design
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import configurations.state.Muscle
import kotlinx.collections.immutable.ImmutableList
import molecular.RangeSlider
import molecular.ThumbRangeStateState

@Composable
internal fun MusclesRangeSlider(
    value: ImmutableList<Muscle>,
    onValueChange: (ImmutableList<Muscle>)-> Unit
) {

    val list = remember {
        mutableStateOf(
            listOf(
                ThumbRangeStateState(
                    id = "as",
                    positionInRange = 20,
                    color = Color.Red
                ),
                ThumbRangeStateState(
                    id = "asd",
                    positionInRange = 30,
                    color = Color.Cyan
                ),
                ThumbRangeStateState(
                    id = "ast",
                    positionInRange = 50,
                    color = Color.Green
                ),
            )
        )
    }
    RangeSlider(
        range = 0..100,
        thumbs = list.value,
        lineColor = Design.colors.caption,
        onValueChange = { list.value = it }
    )
}