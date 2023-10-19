import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import authentication.AuthenticationFeature
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import splash.SplashFeature
import trainingbuilder.TrainingFeature
import trainings.TrainingsFeature

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
                    SplashFeature(
                        toAuthentication = { router.replaceAll(Graph.Auth) },
                        toTrainings = { router.replaceAll(Graph.Trainings) }
                    )
                }

                Graph.Auth -> {
                    AuthenticationFeature(
                        toTrainings = { router.replaceAll(Graph.Trainings) },
                        back = router::pop
                    )
                }

                is Graph.Training -> {
                    TrainingFeature(
                        trainingId = screen.id,
                        toReview = { id -> router.push(Graph.Review(id)) },
                        back = router::pop
                    )
                }

                Graph.Trainings -> {
                    TrainingsFeature(
                        toTrainingById = { id -> router.push(Graph.Review(id)) },
                        toNewTraining = { router.push(Graph.Training(null)) },
                        addTrainingWithTemplate = { id -> router.push(Graph.Training(id)) },
                        back = router::pop,
                    )
                }

                is Graph.Review -> {
                }
            }
        }
    }
}


