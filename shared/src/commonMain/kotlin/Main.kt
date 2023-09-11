import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import authentication.AuthenticationContent
import authentication.AuthenticationViewModel
import navigation.Animation
import navigation.GraphBuilder
import navigation.RootController
import navigation.findNavigator
import splash.SplashContent
import splash.SplashViewModel
import training.TrainingContent
import training.TrainingViewModel
import trainings.TrainingsContent
import trainings.TrainingsViewModel

internal enum class Graph(val link: String) {
    Auth("auth_screen"),


    Splash("splash_screen"),
    Trainings("trainings_screen"),
    Training("training_screen"),
    Review("review_screen"),
    Summary("summary_screen")
}

@Composable
internal fun Main(modifier: Modifier = Modifier) {

    DesignTheme(modifier = modifier) {

        RootController(startScreen = Graph.Splash.link) {

            authenticationGraph()

            trainingsGraph()

//            screen(key = Graph.Review.link, animation = Animation.Present(500)) { store ->
//                val navigator = findNavigator()
//                val trainingId = store.args.getOrElse("trainingId") { "" } as String
//                val viewModel = store.getOrCreate(
//                    key = Graph.Review.link,
//                    factory = { ReviewViewModel(navigator) },
//                    clear = { (it as? ReviewViewModel)?.clear() }
//                )
//                ReviewContent(viewModel, trainingId)
//            }
//
//            screen(key = Graph.Summary.link, animation = Animation.Present(500)) { store ->
//                val navigator = findNavigator()
//                val viewModel = store.getOrCreate(
//                    key = Graph.Summary.link,
//                    factory = { SummaryViewModel(navigator) },
//                    clear = { (it as? SummaryViewModel)?.clear() }
//                )
//                SummaryContent(viewModel)
//            }
        }
    }
}

private fun GraphBuilder.trainingsGraph() {

    screen(key = Graph.Trainings.link, animation = Animation.Present(500)) { store ->
        val navigator = findNavigator()
        val viewModel = store.getOrCreate(
            key = Graph.Trainings.link,
            factory = { TrainingsViewModel() },
            clear = { (it as? TrainingsViewModel)?.clear() }
        )
        TrainingsContent(
            vm = viewModel,
            toTrainingById = { id ->
                navigator.navigate(Graph.Training.link, args = mapOf("trainingId" to id))
            },
            toNewTraining = {
                navigator.navigate(Graph.Training.link)
            },
            back = navigator::back
        )
    }

    screen(key = Graph.Training.link, animation = Animation.Push(300)) { store ->
        val navigator = findNavigator()
        val trainingId = store.args.getOrElse("trainingId") { null } as? String
        val viewModel = store.getOrCreate(
            key = Graph.Training.link,
            factory = { TrainingViewModel() },
            clear = { (it as? TrainingViewModel)?.clear() }
        )
        TrainingContent(
            vm = viewModel,
            trainingId = trainingId,
            toReview = {
                navigator.navigate(Graph.Review.link, popToInclusive = true, args = mapOf("trainingId" to it))
            },
            back = navigator::back
        )
    }
}

private fun GraphBuilder.authenticationGraph() {

    screen(key = Graph.Splash.link, animation = Animation.None) { store ->
        val navigator = findNavigator()

        val viewModel = store.getOrCreate(
            key = Graph.Splash.link,
            factory = { SplashViewModel() },
            clear = { (it as? SplashViewModel)?.clear() }
        )

        SplashContent(
            vm = viewModel,
            toAuthentication = {
                navigator.navigate(Graph.Auth.link, true)
            },
            toTrainings = {
                navigator.navigate(Graph.Trainings.link, true)
            }
        )
    }

    screen(key = Graph.Auth.link, animation = Animation.None) { store ->
        val navigator = findNavigator()
        val viewModel = store.getOrCreate(
            key = Graph.Auth.link,
            factory = { AuthenticationViewModel() },
            clear = { (it as? AuthenticationViewModel)?.clear() }
        )

        AuthenticationContent(
            viewModel,
            signIn = {},
            back = navigator::back
        )
    }
}