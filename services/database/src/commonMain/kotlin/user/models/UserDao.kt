package user.models

public data class UserDao(
    val id: String,
    val name: String,
    val email: String,
    val weight: Double,
    val height: Double,
    val createdAt: String,
    val updatedAt: String
)