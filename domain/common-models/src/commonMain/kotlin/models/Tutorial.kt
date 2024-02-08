package models

public data class Tutorial(
    val id: String,
    val title: String,
    val language: String,
    val resource: String,
    val resourceType: ResourceTypeEnum,
)