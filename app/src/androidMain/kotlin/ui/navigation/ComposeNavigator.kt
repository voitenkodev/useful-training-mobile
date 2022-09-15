package ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import state.AuthState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import state.MOCK_1
import state.MOCK_2
import state.MOCK_3
import state.TrainingState
import content.TrainingsContent
import ui.auth.AuthScreen
import ui.auth.AuthViewModel
import ui.review.ReviewScreen
import ui.training.TrainingScreen
import ui.training.TrainingViewModel

@Composable
fun ComposeNavigator(navController: NavHostController) = AnimatedNavHost(
    navController = navController,
    startDestination = Router.Auth.route
) {

    screen(
        route = Router.Auth.route,
        content = {
            val state = AuthState.EMPTY
            val params = mapOf("authState" to state)
            val viewModel = koinViewModel<AuthViewModel> { parametersOf(SavedStateHandle(params)) }
            AuthScreen(
                viewModel = viewModel,
                navigate = { navController.routeTo(route = it) }
            )
        }
    )

    screen(
        route = Router.Training.ID,
        content = {
            val state = TrainingState.empty(0.0)
            val params = mapOf("trainingState" to state)
            val viewModel = koinViewModel<TrainingViewModel> { parametersOf(SavedStateHandle(params)) }
            TrainingScreen(
                viewModel = viewModel,
                navigate = { navController.routeTo(route = it) }
            )
        }
    )

    screen(
        route = Router.Review.ID,
        content = {
            ReviewScreen()
        }
    )

    screen(
        route = Router.Trainings.route,
        content = {
            val list = listOf(MOCK_1, MOCK_2, MOCK_3)
            TrainingsContent(trainings = list)
        }
    )
}

private fun NavGraphBuilder.screen(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) = composable(
    route = route,
    arguments = arguments,
    enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)) },
    exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)) },
    popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)) },
    popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)) },
    content = content
)