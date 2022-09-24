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
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import state.TrainingState
import ui.auth.AuthScreen
import ui.auth.AuthViewModel
import ui.review.ReviewScreen
import ui.review.ReviewViewModel
import ui.training.TrainingScreen
import ui.training.TrainingViewModel
import ui.trainings.TrainingsScreen
import ui.trainings.TrainingsViewModel

@Composable
fun ComposeNavigator(navController: NavHostController) = AnimatedNavHost(
    navController = navController,
    startDestination = Router.Auth.route
) {

    screen(
        route = Router.Auth.route,
        content = {
            val viewModel = koinViewModel<AuthViewModel> { parametersOf(SavedStateHandle()) }
            AuthScreen(
                viewModel = viewModel,
                navigate = { navController.routeTo(route = it) }
            )
        }
    )

    screen(
        route = Router.Training.ID,
        content = {
            val arg = it.arguments?.get(Router.Training.ARG) as? TrainingState
            val params = mapOf(Router.Training.ARG to arg)
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
            val arg = it.arguments?.get(Router.Review.ARG) as? TrainingState
            val params = mapOf(Router.Review.ARG to arg)
            val viewModel = koinViewModel<ReviewViewModel> { parametersOf(SavedStateHandle(params)) }
            ReviewScreen(
                viewModel = viewModel,
                navigate = { navController.routeTo(route = it) }
            )
        }
    )

    screen(
        route = Router.Trainings.route,
        content = {
            val viewModel = koinViewModel<TrainingsViewModel> { parametersOf(SavedStateHandle(mapOf())) }
            TrainingsScreen(
                viewModel = viewModel,
                navigate = { navController.routeTo(route = it) }
            )
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