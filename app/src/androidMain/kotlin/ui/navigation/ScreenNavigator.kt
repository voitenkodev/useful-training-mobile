package ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import redux.Direction
import redux.NavigatorAction
import redux.rememberDispatcher

@Composable
fun ScreenNavigator(event: Flow<Direction>) {
    val dispatcher = rememberDispatcher()
    LaunchedEffect(key1 = Unit) {
        event.collectLatest { value: Direction -> dispatcher(NavigatorAction.NAVIGATE(value)) }
    }
    BackHandler { dispatcher(NavigatorAction.BACK) }
}