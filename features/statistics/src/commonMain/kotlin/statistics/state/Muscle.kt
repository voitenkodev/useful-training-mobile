package statistics.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class Muscle(
    val id: String,
    val name: String = "",
    val isSelected: Boolean = false
)