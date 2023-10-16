package mappers

import models.Token
import models.TokenDto

fun TokenDto.toDomain(): Token {
    return Token(
        token = token
    )
}