package authentication.register.models

import androidx.compose.runtime.Immutable
import equipment.IncludedStatusEnum

@Immutable
internal data class Muscle(
    val id: String,
    val name: String,
    val status: IncludedStatusEnum,
    val type: MuscleEnum
)

