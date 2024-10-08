package bottommenu.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import bottommenu.main.components.MenuItem
import bottommenu.main.state.Menu
import bottommenu.main.state.TokenStatus
import kotlinx.collections.immutable.ImmutableList
import molecule.Shadow
import molecule.secondaryBackground

@Composable
internal fun BottomMenuContent(
    vm: BottomMenuViewModel,
    selectedIndex: Int,
    menuItemClick: (index: Int) -> Unit,
    toAuthentication: () -> Unit,
    screen: @Composable BoxScope.() -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(state.tokenStatus) {
        if (state.tokenStatus == TokenStatus.Unavailable) toAuthentication.invoke()
    }

    Content(
        menu = state.menu,
        selectedIndex = selectedIndex,
        onClick = menuItemClick,
        screen = screen
    )
}

@Composable
private fun Content(
    menu: ImmutableList<Menu>,
    selectedIndex: Int,
    onClick: (index: Int) -> Unit,
    screen: @Composable BoxScope.() -> Unit
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.weight(1f),
            content = screen
        )

        Column(
            modifier = Modifier
                .secondaryBackground()
                .navigationBarsPadding()
                .fillMaxWidth()
        ) {

            Shadow()

            Row(
                modifier = Modifier
                    .padding(Design.dp.paddingS)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                repeat(menu.size) {
                    MenuItem(
                        modifier = Modifier
                            .requiredHeight(Design.dp.componentS)
                            .weight(1f),
                        icon = menu[it].icon,
                        isSelected = selectedIndex == it,
                        onClick = { onClick.invoke(it) }
                    )
                }
            }
        }
    }
}