package ui.trainings

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import presentation.TrainingsContent
import ui.navigation.ScreenNavigator

@Composable
fun TrainingsScreen(
    viewModel: TrainingsViewModel
) {

    val fetch = viewModel.trainingState.collectAsState()

    ScreenNavigator(viewModel.event)

    TrainingsContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
        fetch = fetch.value,
        edit = viewModel::get,
        add = viewModel::add,
        review = viewModel::show
    )
}