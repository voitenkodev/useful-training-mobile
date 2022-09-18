package ui.training

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import content.TrainingContent
import ui.navigation.LocalNavigator
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
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        state = state.value,
        update = viewModel::update,
        save = viewModel::save,
    )
}