package models

public enum class ExperienceEnum(private val key: String) {
    BEGINNER(key = "beginner"),
    INTERMEDIATE(key = "intermediate"),
    ADVANCED(key = "advanced"),
    PRO(key = "pro"),
    UNKNOWN(key = "UNKNOWN");


    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String): ExperienceEnum {
            return ExperienceEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}