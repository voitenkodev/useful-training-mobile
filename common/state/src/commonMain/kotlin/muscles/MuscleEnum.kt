package muscles

import androidx.compose.runtime.Immutable

@Immutable
public enum class MuscleEnum {
    // Chest
    PECTORALIS_MAJOR_CLAVICULAR,
    PECTORALIS_MAJOR_STERNOCOSTAL,
    PECTORALIS_MAJOR_ABDOMINAL,


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
    ADDUCTORS,
    ABDUCTORS,

    // Shoulder
    ANTERIOR_DELTOID,
    LATERAL_DELTOID,
    POSTERIOR_DELTOID,

    // Arms
    BICEPS,
    TRICEPS,
    FOREARM
}