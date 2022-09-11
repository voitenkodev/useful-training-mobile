package ui.training

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ui.navigation.LocalNavigator
import training.TrainingContent
import ui.navigation.Router

@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel,
    navigate: (Router) -> Unit
) {

    val state = viewModel.trainingState.collectAsState()

    LocalNavigator(
        viewModel.event,
        navigate = navigate
    )


    TrainingContent(
        state = state.value,
        update = viewModel::update,
        save = viewModel::save
    )
}