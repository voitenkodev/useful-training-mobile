package exerciseexamplebuilder.main.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal data class Muscle(
    val id: String,
    val name: String,
    val percentage: Int,
    val color: Color,
    val status: StatusEnum,
    val type: MuscleEnum
)

