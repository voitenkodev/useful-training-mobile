package navigation

import androidx.compose.runtime.Composable
import redux.Direction
import redux.NavigatorAction

//
//@Composable
//fun GlobalGraph(it: Direction) = when (it) {
//    Direction.Auth -> AuthScreen(
//        viewModel = koinViewModel(),
//        navigate = { dispatcher(NavigatorAction.NAVIGATE(it.mapRoute())) }
//    )
//
//    Direction.Review -> ReviewScreen(
//        viewModel = koinViewModel(),
//        navigate = { dispatcher(NavigatorAction.NAVIGATE(it.mapRoute())) }
//    )
//
//    Direction.Training -> TrainingScreen(
//        viewModel = koinViewModel(),
//        navigate = { dispatcher(NavigatorAction.NAVIGATE(it.mapRoute())) }
//    )
//
//    Direction.Trainings -> TrainingsScreen(
//        viewModel = koinViewModel(),
//        navigate = { dispatcher(NavigatorAction.NAVIGATE(it.mapRoute())) }
//    )
//}