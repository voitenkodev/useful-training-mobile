import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import authentication.AuthenticationContent
import authentication.AuthenticationViewModel
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import decompose.AppGraph
import decompose.RoutedContent
import decompose.Router
import decompose.rememberRouter
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

        val router: Router<AppGraph> = rememberRouter(AppGraph::class, listOf(AppGraph.Splash))

        RoutedContent(
            router = router,
            animation = stackAnimation()
        ) { screen ->
            when (screen) {
                AppGraph.Splash -> {
                    val vm = SplashViewModel()

                    SplashContent(
                        vm = vm,
                        toAuthentication = { router.replaceAll(AppGraph.Auth) },
                        toTrainings = { router.replaceAll(AppGraph.Trainings) }
                    )
                }

                AppGraph.Auth -> {
                    val vm = AuthenticationViewModel()

                    AuthenticationContent(
                        vm = vm,
                        toTrainings = { router.replaceAll(AppGraph.Trainings) },
                        back = router::pop
                    )
                }

                is AppGraph.Training -> {
                    val vm = TrainingViewModel()

                    TrainingContent(
                        vm = vm,
                        trainingId = screen.id,
                        toReview = { id -> router.push(AppGraph.Review(id)) },
                        back = router::pop
                    )
                }

                AppGraph.Trainings -> {
                    val vm = TrainingsViewModel()

                    TrainingsContent(
                        vm = vm,
                        toTrainingById = { id -> router.push(AppGraph.Review(id)) },
                        toNewTraining = { router.push(AppGraph.Training(null)) },
                        toAuth = { router.replaceAll(AppGraph.Auth) },
                        back = router::pop
                    )
                }

                is AppGraph.Review -> {
                    val vm = ReviewViewModel()

                    ReviewContent(
                        vm = vm,
                        trainingId = screen.id,
                        back = router::pop,
                        toEditTrainingById = { id -> router.push(AppGraph.Training(id)) }
                    )
                }
            }
        }
    }
}


