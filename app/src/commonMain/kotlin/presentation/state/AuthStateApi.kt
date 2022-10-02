package presentation.state

fun AuthState.validate(): AuthState? {
    val emailAddressRegex = Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    val isEmailValid = this.email.matches(emailAddressRegex)
    val isPasswordValid = this.password.length > 5

    return if (isEmailValid && isPasswordValid) this
    else null
}
