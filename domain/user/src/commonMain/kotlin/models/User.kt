package models

public data class User(
    val id: String,
    val name: String,
    val email: String,
    val experience: ExperienceEnum,
    val weight: Double,
    val height: Double
)