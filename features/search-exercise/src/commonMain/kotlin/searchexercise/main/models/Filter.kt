package searchexercise.main.models

import androidx.compose.runtime.Immutable

@Immutable
internal data class Filter(
    val value: String,
    val isSelected: Boolean
)