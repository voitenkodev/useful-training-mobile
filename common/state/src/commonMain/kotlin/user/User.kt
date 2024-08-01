package user

import androidx.compose.runtime.Immutable

@Immutable
public data class User(
    val name: String,
    val height: String,
    val weight: String,
    val email: String,
    val experience: ExperienceEnum,
)