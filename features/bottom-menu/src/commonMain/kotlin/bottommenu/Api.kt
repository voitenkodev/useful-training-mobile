package bottommenu

import androidx.compose.runtime.Composable
import bottommenu.screen.BottomMenuContent
import bottommenu.screen.BottomMenuViewModel
import io.github.xxfast.decompose.router.rememberOnRoute

@Composable
public fun BottomMenuFeature(
    selectedIndex: Int,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {

    val vm: BottomMenuViewModel = rememberOnRoute(BottomMenuViewModel::class) {
        BottomMenuViewModel()
    }

    BottomMenuContent(
        vm = vm,
        selectedIndex = selectedIndex,
        onClick = onClick,
        screen = screen
    )
}
