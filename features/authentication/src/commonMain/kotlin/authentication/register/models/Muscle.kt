package authentication.register.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class Muscle(
    val id: String,
    val name: String,
    val loading: Boolean,
    val status: StatusEnum,
    val type: MuscleEnum
)

