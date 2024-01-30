package models

public enum class CategoryEnum(private val key: String) {
    COMPOUND(key = "compound"),
    ISOLATION(key = "isolation"),
    UNKNOWN(key = "UNKNOWN");


    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): CategoryEnum {
            return CategoryEnum.entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}