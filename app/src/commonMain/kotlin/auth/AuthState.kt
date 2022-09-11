package auth

data class AuthState(
    val email: String,
    val password: String
){
    companion object{
        val EMPTY = AuthState(
            email = "voitenko.dev@gmail.com",
            password = "qwerty123"
        )
    }
}