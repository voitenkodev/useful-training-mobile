import androidx.compose.runtime.Composable
import presentation.auth.AuthContent
import presentation.review.ReviewContent
import presentation.training.TrainingContent
import presentation.trainings.TrainingsContent

sealed class Graph(link: String) : Screen(link) {
    object Auth : Graph("auth_screen")

    object Trainings : Graph("trainings_screen")

    object Training : Graph("training_screen")

    object Review : Graph("review_screen")
}

@Composable
fun Navigator.GlobalGraph(screen: Screen?) = when (screen as? Graph) {

    Graph.Auth -> AuthContent(navigator = this)

    Graph.Review -> ReviewContent(navigator = this)

    Graph.Training -> TrainingContent(navigator = this)

    Graph.Trainings -> TrainingsContent(navigator = this)

    else -> Unit
}