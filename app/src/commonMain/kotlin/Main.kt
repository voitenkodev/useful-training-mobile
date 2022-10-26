import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import presentation.auth.AuthContent
import presentation.auth.AuthViewModel
import presentation.review.ReviewContent
import presentation.review.ReviewViewModel
import presentation.training.TrainingContent
import presentation.training.TrainingViewModel
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

                screen(
                    key = Graph.Auth.link,
                    animation = Animation.Present(500)
                ) { store ->

                    val navigator = findNavigator()
                    val dispatcher = rememberDispatcher()

                    val viewModel = store.getOrCreate(
                        key = Graph.Auth.link,
                        factory = { AuthViewModel(dispatcher, navigator) },
                        clear = { (it as? AuthViewModel)?.clear() }
                    )
                    AuthContent(viewModel)

                }
                screen(
                    key = Graph.Review.link,
                    animation = Animation.Present(500)
                ) { store ->

                    val navigator = findNavigator()
                    val dispatcher = rememberDispatcher()

                    val viewModel = store.getOrCreate(
                        key = Graph.Review.link,
                        factory = { ReviewViewModel(dispatcher, navigator) },
                        clear = { (it as? ReviewViewModel)?.clear() }
                    )

                    ReviewContent(viewModel)
                }

                screen(
                    key = Graph.Training.link,
                    animation = Animation.Push(300)
                ) { store ->

                    val navigator = findNavigator()
                    val dispatcher = rememberDispatcher()

                    val viewModel = store.getOrCreate(
                        key = Graph.Training.link,
                        factory = { TrainingViewModel(dispatcher, navigator) },
                        clear = { (it as? TrainingViewModel)?.clear() }
                    )

                    TrainingContent(viewModel)
                }

                screen(
                    key = Graph.Trainings.link,
                    animation = Animation.Present(500)
                ) { store ->

                    val navigator = findNavigator()
                    val dispatcher = rememberDispatcher()

                    val viewModel = store.getOrCreate(
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