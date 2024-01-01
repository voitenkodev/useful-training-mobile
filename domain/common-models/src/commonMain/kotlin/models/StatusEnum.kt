package models

public enum class StatusEnum(private val key: String) {
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): StatusEnum {
            return StatusEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}