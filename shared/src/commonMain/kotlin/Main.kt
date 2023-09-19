import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import authentication.AuthenticationContent
import authentication.AuthenticationViewModel
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import rememberViewModel
import review.ReviewContent
import review.ReviewViewModel
import splash.SplashContent
import splash.SplashViewModel
import training.TrainingContent
import training.TrainingViewModel
import trainings.TrainingsContent
import trainings.TrainingsViewModel

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
                        toAuth = { router.replaceAll(Graph.Auth) },
                        back = router::pop
                    )
                }

                is Graph.Review -> {
                    val vm = rememberViewModel(ReviewViewModel::class) { ReviewViewModel() }

                    ReviewContent(
                        vm = vm,
                        trainingId = screen.id,
                        back = router::pop,
                        toEditTrainingById = { id -> router.push(Graph.Training(id)) }
                    )
                }
            }
        }
    }
}


