package user

import androidx.compose.runtime.Immutable

@Immutable
public data class WeightHistory(
    val id: String,
    val weight: Double,
    val createdAt: String
)
