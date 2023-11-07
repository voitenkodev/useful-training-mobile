package user.models

public data class UserDao(
    val id: String,
    val name: String,
    val email: String,
    val weight: Int,
    val height: Int,
    val createdAt: String,
    val updatedAt: String
)