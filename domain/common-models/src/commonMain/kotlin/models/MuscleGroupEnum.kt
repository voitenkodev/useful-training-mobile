package models

public enum class MuscleGroupEnum(private val key: String) {
    CHEST_MUSCLES("chest_muscles"),
    BACK_MUSCLES("back_muscles"),
    ABDOMINAL_MUSCLES("abdominal_muscles"),
    LEGS("legs"),
    ARMS_AND_FOREARMS("arms_and_forearms"),
    SHOULDER_MUSCLES("shoulder_muscles"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String): MuscleGroupEnum {
            return entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}