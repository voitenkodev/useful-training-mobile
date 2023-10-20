package bottommenu.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class State(
    val menu: List<Menu> = Menu.entries.toList(),
)