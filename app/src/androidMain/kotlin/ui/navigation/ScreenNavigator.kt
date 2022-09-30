package ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ScreenNavigator(event: Flow<Router>, navigate: (Router) -> Unit) {
    LaunchedEffect(key1 = Unit) { event.collectLatest { value: Router -> navigate.invoke(value) } }
}