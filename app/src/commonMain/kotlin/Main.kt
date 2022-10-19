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

        StoreProvider(store = store) {

            CsRootController(
                startScreen = Graph.Auth.link
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
