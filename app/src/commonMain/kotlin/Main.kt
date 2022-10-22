import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.auth.AuthContent
import presentation.review.ReviewContent
import presentation.training.TrainingContent
import presentation.trainings.TrainingsContent

@Composable
fun Main(
    modifier: Modifier = Modifier,
    finalize: () -> Unit
) {
    DesignTheme(modifier = modifier) {

        ReduxStoreProvider(GlobalState(), globalReducer) {

            RootController(
                startScreen = Graph.Auth.link,
            ) {
                screen(Graph.Auth.link) {
                    AuthContent()
                }
                screen(Graph.Review.link) {
                    ReviewContent()
                }
                screen(Graph.Training.link) {
                    TrainingContent()
                }
                screen(Graph.Trainings.link) {
                    TrainingsContent()
                }
            }
        }
    }
}

enum class Graph(val link: String) {
    Auth("auth_screen"),
    Trainings("trainings_screen"),
    Training("training_screen"),
    Review("review_screen")
}