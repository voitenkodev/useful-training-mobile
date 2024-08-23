package models

public data class Tutorial(
    val id: String,
    val title: String,
    val value: String,
    val language: String,
    val author: String?,
    val resourceType: ResourceTypeEnum,
)