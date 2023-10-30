package configurations.state

import ColorUtils
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal data class MuscleExerciseBundle(
    val id: String? = null,
    val value: Int = 0,
    val muscle: Muscle,
    val color: Color = ColorUtils.randomColor()
)