package models

public enum class EquipmentStatusEnum(private val key: String) {
    INCLUDED("included"),
    EXCLUDED("excluded"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): EquipmentStatusEnum {
            return EquipmentStatusEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}