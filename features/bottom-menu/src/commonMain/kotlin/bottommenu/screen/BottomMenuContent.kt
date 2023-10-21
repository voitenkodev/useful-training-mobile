package bottommenu.screen

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bottommenu.components.MenuItem
import bottommenu.state.Menu
import kotlinx.collections.immutable.ImmutableList
import platformBottomInset

@Composable
internal fun BottomMenuContent(
    vm: BottomMenuViewModel,
    selectedIndex: Int,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        menu = state.menu,
        selectedIndex = selectedIndex,
        onClick = onClick,
        screen = screen
    )
}

@Composable
private fun Content(
    menu: ImmutableList<Menu>,
    selectedIndex: Int,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.weight(1f),
            content = { screen.invoke() }
        )

        Column(
            modifier = Modifier
                .platformBottomInset()
                .background(color = Design.colors.tertiary)
                .fillMaxWidth(),
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Design.colors.white10)
            )

            Row(
                modifier = Modifier
                    .padding(Design.dp.paddingS)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                repeat(menu.size) {
                    MenuItem(
                        modifier = Modifier.weight(1f),
                        text = menu[it].text,
                        icon = menu[it].icon,
                        isSelected = selectedIndex == it,
                        onClick = { onClick.invoke(it) }
                    )
                }
            }
        }
    }
}