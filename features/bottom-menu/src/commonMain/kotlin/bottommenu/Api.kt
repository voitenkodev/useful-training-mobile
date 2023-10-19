package bottommenu

import androidx.compose.runtime.Composable
import bottommenu.screen.BottomMenuContent
import bottommenu.screen.BottomMenuViewModel
import rememberViewModel

@Composable
public fun BottomMenuFeature() {
    val vm = rememberViewModel(BottomMenuViewModel::class) { BottomMenuViewModel() }

    BottomMenuContent(
        vm = vm,
    )
}
