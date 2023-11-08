package bottommenu

import androidx.compose.runtime.Composable
import bottommenu.screen.BottomMenuContent
import bottommenu.screen.BottomMenuViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun BottomMenuFeature(
    selectedIndex: Int,
    menuItemClick: (index: Int) -> Unit,
    toAuthentication: () -> Unit,
    screen: @Composable () -> Unit
) {

    val vm: BottomMenuViewModel = rememberOnRoute(BottomMenuViewModel::class) {
        BottomMenuViewModel()
    }

    BottomMenuContent(
        vm = vm,
        selectedIndex = selectedIndex,
        menuItemClick = menuItemClick,
        toAuthentication = toAuthentication,
        screen = screen
    )
}
