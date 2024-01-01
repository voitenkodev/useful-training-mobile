package weighthistory.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class WeightHistory(
    val id: String,
    val weight: Double,
    val createdAt: String
)
