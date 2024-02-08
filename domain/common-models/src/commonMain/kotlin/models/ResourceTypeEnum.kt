package models

public enum class ResourceTypeEnum(private val key: String) {
    YOUTUBE_VIDEO("youtube_video"),
    VIDEO("video"),
    TEXT("text"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): ResourceTypeEnum {
            return entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}