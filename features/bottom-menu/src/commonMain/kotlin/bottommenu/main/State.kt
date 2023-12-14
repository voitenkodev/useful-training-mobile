package bottommenu.main

import androidx.compose.runtime.Immutable
import bottommenu.main.state.Menu
import bottommenu.main.state.TokenStatus
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class State(
    val tokenStatus: TokenStatus = TokenStatus.Available,
    val menu: ImmutableList<Menu> = Menu.entries.toList().toImmutableList()
)