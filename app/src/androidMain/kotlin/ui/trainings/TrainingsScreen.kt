package ui.trainings

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import ui.navigation.LocalNavigator
import content.TrainingsContent
import ui.navigation.Router

@Composable
fun TrainingsScreen(
    viewModel: TrainingsViewModel,
    navigate: (Router) -> Unit
) {

    val state = viewModel.trainingState.collectAsState()

    LocalNavigator(
        viewModel.event,
        navigate = navigate
    )

    TrainingsContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        state = state.value,
        get = viewModel::get,
        add = viewModel::add
    )
}