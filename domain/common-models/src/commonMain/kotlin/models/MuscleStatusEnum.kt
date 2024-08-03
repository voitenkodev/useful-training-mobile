package models

public enum class MuscleStatusEnum(private val key: String) {
    INCLUDED("included"),
    EXCLUDED("excluded"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): MuscleStatusEnum {
            return MuscleStatusEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}