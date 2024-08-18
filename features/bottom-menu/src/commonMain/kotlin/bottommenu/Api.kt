package bottommenu

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import bottommenu.main.BottomMenuContent
import bottommenu.main.BottomMenuViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun BottomMenuFeature(
    selectedIndex: Int,
    menuItemClick: (index: Int) -> Unit,
    toAuthentication: () -> Unit,
    screen: @Composable BoxScope.() -> Unit
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
