package ui.training

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import training.TrainingContent

@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel
) {

    val state = viewModel.trainingState.collectAsState()

    TrainingContent(
        training = state.value,
        update = viewModel::update,
        save = viewModel::save,
    )
}