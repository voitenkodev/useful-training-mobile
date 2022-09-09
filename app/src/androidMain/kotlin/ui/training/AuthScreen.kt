package ui.training

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import training.TrainingContent
import ui.auth.AuthViewModel

@Composable
fun TrainingScreen(
    navController: NavController,
    viewModel: TrainingViewModel
) {

    val state = viewModel.trainingState.collectAsState()

    TrainingContent(
        training = state.value,
        save = viewModel::save
    )
}