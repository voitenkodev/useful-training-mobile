package models

public enum class WeightTypeEnum(private val key: String) {
    FREE(key = "free"),
    FIXED(key = "fixed"),
    BODY_WEIGHT(key = "body_weight"),
    UNKNOWN(key = "UNKNOWN");


    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): WeightTypeEnum {
            return WeightTypeEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}