package profile.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class User(
    val name: String = "",
    val weight: String = "",
    val height: String = ""
)
