import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.auth.AuthContent
import presentation.auth.AuthViewModel
import presentation.review.ReviewContent
import presentation.training.TrainingContent
import presentation.trainings.TrainingsContent
import presentation.trainings.TrainingsViewModel

@Composable
fun Main(
    modifier: Modifier = Modifier,
    finalize: () -> Unit
) {
    DesignTheme(modifier = modifier) {

        ReduxStoreProvider(GlobalState(), globalReducer) {

            RootController(startScreen = Graph.Auth.link) {

                screen(Graph.Auth.link) { store ->

                    val navigator = findNavigator()
                    val dispatcher = rememberDispatcher()

                    val viewModel = store.provide(
                        key = Graph.Auth.link,
                        factory = { AuthViewModel(dispatcher, navigator) },
                        clear = { (it as? AuthViewModel)?.clear() }
                    )
                    AuthContent(viewModel)

                }
                screen(Graph.Review.link) {
                    ReviewContent()
                }

                screen(Graph.Training.link) {
                    TrainingContent()
                }

                screen(Graph.Trainings.link) { store ->

                    val navigator = findNavigator()
                    val dispatcher = rememberDispatcher()

                    val viewModel = store.provide(
                        key = Graph.Trainings.link,
                        factory = { TrainingsViewModel(dispatcher, navigator) },
                        clear = { (it as? TrainingsViewModel)?.clear() }
                    )
                    TrainingsContent(viewModel)
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