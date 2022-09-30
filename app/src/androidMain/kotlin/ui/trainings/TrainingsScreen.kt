package ui.trainings

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import content.TrainingsContent
import ui.navigation.ScreenNavigator
import ui.navigation.Router

@Composable
fun TrainingsScreen(
    viewModel: TrainingsViewModel,
    navigate: (Router) -> Unit
) {

    val state = viewModel.trainingState.collectAsState()

    ScreenNavigator(
        viewModel.event,
        navigate = navigate
    )

    TrainingsContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        state = state.value,
        get = viewModel::get,
        add = viewModel::add,
        show = viewModel::show
    )
}