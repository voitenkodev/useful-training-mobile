package exerciseexample.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class MaxWeight(
    val createdAt: String,
    val exerciseExampleId: String,
    val exerciseId: String,
    val id: String,
    val weight: Double
)