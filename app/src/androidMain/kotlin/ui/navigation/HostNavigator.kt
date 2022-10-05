package ui.navigation

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel
import redux.Direction
import ui.auth.AuthScreen
import ui.review.ReviewScreen
import ui.training.TrainingScreen
import ui.trainings.TrainingsScreen

@Composable
fun GlobalGraph(it: Direction) = when (it) {

    Direction.Auth -> AuthScreen(viewModel = koinViewModel())

    Direction.Review -> ReviewScreen(viewModel = koinViewModel())

    Direction.Training -> TrainingScreen(viewModel = koinViewModel())

    Direction.Trainings -> TrainingsScreen(viewModel = koinViewModel())
}