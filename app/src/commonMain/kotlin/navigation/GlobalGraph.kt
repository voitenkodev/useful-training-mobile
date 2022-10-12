package navigation

import androidx.compose.runtime.Composable
import presentation.auth.AuthContent
import presentation.review.ReviewContent
import presentation.training.TrainingContent
import presentation.trainings.TrainingsContent
import Direction

@Composable
fun GlobalGraph(direction: Direction) = when (direction) {

    Direction.Auth -> AuthContent()

    Direction.Review -> ReviewContent()

    Direction.Training -> TrainingContent()

    Direction.Trainings -> TrainingsContent()
}