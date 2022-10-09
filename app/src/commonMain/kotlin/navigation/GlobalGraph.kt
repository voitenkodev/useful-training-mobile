package navigation

import androidx.compose.runtime.Composable
import presentation.AuthContent
import presentation.ReviewContent
import presentation.TrainingContent
import presentation.TrainingsContent
import redux.Direction

@Composable
fun GlobalGraph(direction: Direction) = when (direction) {

    Direction.Auth -> AuthContent()

    Direction.Review -> ReviewContent()

    Direction.Training -> TrainingContent()

    Direction.Trainings -> TrainingsContent()
}