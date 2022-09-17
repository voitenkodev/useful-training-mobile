package ui.trainings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
        trainings = state.value,
        get = viewModel::get
    )
}