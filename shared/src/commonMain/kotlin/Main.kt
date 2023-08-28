import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import navigation.Animation
import navigation.RootController
import navigation.findNavigator
import presentation.auth.AuthContent
import presentation.auth.AuthViewModel
import presentation.review.ReviewContent
import presentation.review.ReviewViewModel
import presentation.splash.SplashContent
import presentation.splash.SplashViewModel
import presentation.summary.SummaryContent
import presentation.summary.SummaryViewModel
import presentation.training.TrainingContent
import presentation.training.TrainingViewModel
import presentation.trainings.TrainingsContent
import presentation.trainings.TrainingsViewModel

internal enum class Graph(val link: String) {
    Splash("splash_screen"),
    Auth("auth_screen"),
    Trainings("trainings_screen"),
    Training("training_screen"),
    Review("review_screen"),
    Summary("summary_screen")
}

@Composable
internal fun Main(modifier: Modifier = Modifier) {

    DesignTheme(modifier = modifier) {

        RootController(startScreen = Graph.Splash.link) {

            screen(key = Graph.Splash.link, animation = Animation.None) { store ->
                val navigator = findNavigator()
                val viewModel = store.getOrCreate(
                    key = Graph.Splash.link,
                    factory = { SplashViewModel(navigator) },
                    clear = { (it as? SplashViewModel)?.clear() }
                )
                SplashContent(viewModel)
            }

            screen(key = Graph.Auth.link, animation = Animation.None) { store ->
                val navigator = findNavigator()
                val viewModel = store.getOrCreate(
                    key = Graph.Auth.link,
                    factory = { AuthViewModel(navigator) },
                    clear = { (it as? AuthViewModel)?.clear() }
                )
                AuthContent(viewModel)
            }

            screen(key = Graph.Trainings.link, animation = Animation.Present(500)) { store ->
                val navigator = findNavigator()
                val viewModel = store.getOrCreate(
                    key = Graph.Trainings.link,
                    factory = { TrainingsViewModel(navigator) },
                    clear = { (it as? TrainingsViewModel)?.clear() }
                )
                TrainingsContent(viewModel)
            }

            screen(key = Graph.Training.link, animation = Animation.Push(300)) { store ->
                val navigator = findNavigator()
                val trainingId = store.args.getOrElse("trainingId") { null } as? String
                val viewModel = store.getOrCreate(
                    key = Graph.Training.link,
                    factory = { TrainingViewModel(navigator) },
                    clear = { (it as? TrainingViewModel)?.clear() }
                )
                TrainingContent(viewModel, trainingId)
            }

            screen(key = Graph.Review.link, animation = Animation.Present(500)) { store ->
                val navigator = findNavigator()
                val trainingId = store.args.getOrElse("trainingId") { "" } as String
                val viewModel = store.getOrCreate(
                    key = Graph.Review.link,
                    factory = { ReviewViewModel(navigator) },
                    clear = { (it as? ReviewViewModel)?.clear() }
                )
                ReviewContent(viewModel, trainingId)
            }

            screen(key = Graph.Summary.link, animation = Animation.Present(500)) { store ->
                val navigator = findNavigator()
                val viewModel = store.getOrCreate(
                    key = Graph.Summary.link,
                    factory = { SummaryViewModel(navigator) },
                    clear = { (it as? SummaryViewModel)?.clear() }
                )
                SummaryContent(viewModel)
            }
        }
    }
}