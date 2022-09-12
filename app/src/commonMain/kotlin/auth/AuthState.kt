package auth

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize

@Parcelize
data class AuthState(
    val email: String,
    val password: String
) : Parcelable {
    companion object {
        val EMPTY = AuthState(
            email = "voitenko.dev@gmail.com",
            password = "qwerty123"
        )
    }
}