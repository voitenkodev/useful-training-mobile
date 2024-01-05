package models

public enum class MuscleEnum(private val key: String) {
    // Chest
    PECTORALIS_MAJOR("pectoralis_major"),
    PECTORALIS_MINOR("pectoralis_minor"),

    // Back
    TRAPEZIUS("trapezius"),
    LATISSIMUS_DORSI("latissimus_dorsi"),
    RHOMBOIDS("rhomboids"),
    TERES_MAJOR("teres_major"),

    // Abdominal
    RECTUS_ABDOMINIS("rectus_abdominis"),
    OBLIQUES("obliques"),

    // Legs
    CALF("calf"),
    GLUTEAL("gluteal"),
    HAMSTRINGS("hamstrings"),
    QUADRICEPS("quadriceps"),

    // Shoulder
    ANTERIOR_DELTOID("anterior_deltoid"),
    LATERAL_DELTOID("lateral_deltoid"),
    POSTERIOR_DELTOID("posterior_deltoid"),

    // Arms
    BICEPS("biceps"),
    TRICEPS("triceps"),
    FOREARM("forearm"),

    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String): MuscleEnum {
            return entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}