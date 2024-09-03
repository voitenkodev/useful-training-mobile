package models

public enum class ForceTypeEnum(private val key: String) {
    PULL(key = "pull"),
    PUSH(key = "push"),
    HINGE(key = "hinge"),
    UNKNOWN(key = "UNKNOWN");


    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): ForceTypeEnum {
            return ForceTypeEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}