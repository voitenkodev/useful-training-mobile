package ui.navigation

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import redux.Direction
import ui.review.ReviewScreen
import ui.training.TrainingScreen
import ui.trainings.TrainingsScreen

@Composable
fun GlobalGraphAndroid(it: Direction) = when (it) {

    Direction.Review -> ReviewScreen(viewModel = koinViewModel())

    Direction.Training -> TrainingScreen(viewModel = koinViewModel())

    Direction.Trainings -> TrainingsScreen()

   else -> {}
}