package exercise.component

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal data class MuscleUi(
    val text: String,
    val color: Color
)