import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import authentication.AuthenticationContent
import authentication.AuthenticationViewModel
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import trainingbuilder.screen.TrainingContent
import trainingbuilder.screen.TrainingViewModel
import splash.SplashContent
import splash.SplashViewModel
import trainings.screen.TrainingsContent
import trainings.screen.TrainingsViewModel

@Composable
internal fun Main(modifier: Modifier = Modifier) {

    DesignTheme(modifier = modifier) {

        val router: Router<Graph> = rememberRouter(Graph::class, listOf(Graph.Splash))

        RoutedContent(
            router = router,
            animation = stackAnimation()
        ) { screen ->
            when (screen) {
                Graph.Splash -> {

                    val vm = rememberViewModel(SplashViewModel::class) { SplashViewModel() }

                    SplashContent(
                        vm = vm,
                        toAuthentication = { router.replaceAll(Graph.Auth) },
                        toTrainings = { router.replaceAll(Graph.Trainings) }
                    )
                }

                Graph.Auth -> {
                    val vm = rememberViewModel(AuthenticationViewModel::class) { AuthenticationViewModel() }

                    AuthenticationContent(
                        vm = vm,
                        toTrainings = { router.replaceAll(Graph.Trainings) },
                        back = router::pop
                    )
                }

                is Graph.Training -> {
                    val vm = rememberViewModel(TrainingViewModel::class) { TrainingViewModel() }

                    TrainingContent(
                        vm = vm,
                        trainingId = screen.id,
                        toReview = { id -> router.push(Graph.Review(id)) },
                        back = router::pop
                    )
                }

                Graph.Trainings -> {
                    val vm = rememberViewModel(TrainingsViewModel::class) { TrainingsViewModel() }

                    TrainingsContent(
                        vm = vm,
                        toTrainingById = { id -> router.push(Graph.Review(id)) },
                        toNewTraining = { router.push(Graph.Training(null)) },
                        addTrainingWithTemplate = { id -> router.push(Graph.Training(id)) },
                        toAuth = { router.replaceAll(Graph.Auth) },
                        back = router::pop,
                    )
                }

                is Graph.Review -> {
                }
            }
        }
    }
}


