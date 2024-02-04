package searchexercise.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class FilterMuscle(
    val id: String,
    val name: String,
    val status: StatusEnum,
    val type: MuscleEnum
)

