package exerciseexamplebuilder.state

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
internal data class Muscle(
    val id: String,
    val name: String,
    val isSelected: Boolean,
    val type: MuscleEnum,
    val color: Color? = null
)

@Immutable
internal enum class MuscleEnum {
    // Chest
    PECTORALIS_MAJOR,
    PECTORALIS_MINOR,

    // Back
    TRAPEZIUS,
    LATISSIMUS_DORSI,
    RHOMBOIDS,

    // Abdominal
    RECTUS_ABDOMINIS,
    OBLIQUES,

    // Legs
    CALF,
    GLUTEAL,
    HAMSTRINGS,
    QUADRICEPS,

    // Shoulder
    ANTERIOR_DELTOID,
    LATERAL_DELTOID,
    POSTERIOR_DELTOID,

    // Arms
    BICEPS,
    TRICEPS,
    FOREARM
}