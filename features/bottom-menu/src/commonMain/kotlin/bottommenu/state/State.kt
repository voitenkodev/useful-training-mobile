package bottommenu.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class State(
    val tokenStatus: TokenStatus = TokenStatus.Available,
    val menu: ImmutableList<Menu> = Menu.entries.toList().toImmutableList()
)