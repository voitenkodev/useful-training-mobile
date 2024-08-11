package trainingbuilder.training_builder.models

import androidx.compose.runtime.Immutable

@Deprecated("use from state")
@Immutable
internal data class Muscle(
    val id: String,
    val name: String,
    val type: MuscleEnum
)

// todo remove it (use from state)
@Deprecated("use from state")
@Immutable
internal enum class MuscleEnum {
    // Chest
    PECTORALIS_MAJOR,
    PECTORALIS_MINOR,

    // Back
    TRAPEZIUS,
    LATISSIMUS_DORSI,
    RHOMBOIDS,
    TERES_MAJOR,

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