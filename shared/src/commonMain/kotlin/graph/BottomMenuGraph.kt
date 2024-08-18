package graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import bottommenu.BottomMenuFeature
import com.arkivanov.decompose.router.stack.bringToFront
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import profile.ProfileFeature
import profile.ProfileGraph
import trainings.TrainingsGraph

@Serializable
internal sealed class BottomMenuRouter {
    @Serializable
    data object Trainings : BottomMenuRouter()

    @Serializable
    data object Profile : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph(
    toTrainingBuilder: (id: String?) -> Unit,
    toTrainingDetails: (id: String) -> Unit,
    toExerciseExamples: () -> Unit,
    toAuthentication: () -> Unit,
    toMuscles: () -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit,
    toExerciseExampleBuilder: () -> Unit
) {

    val router: Router<BottomMenuRouter> = rememberRouter(BottomMenuRouter::class) {
        listOf(BottomMenuRouter.Trainings)
    }

    val selectedIndex = remember { mutableStateOf(0) }

    LaunchedEffect(router.stack.value.active.configuration) {
        when (router.stack.value.active.configuration) {
            BottomMenuRouter.Trainings -> selectedIndex.value = 0
            BottomMenuRouter.Profile -> selectedIndex.value = 1
        }
    }

    BottomMenuFeature(
        selectedIndex = selectedIndex.value,
        toAuthentication = toAuthentication,
        menuItemClick = {
            val newRoute = when (it) {
                0 -> BottomMenuRouter.Trainings
                else -> BottomMenuRouter.Profile
            }
            router.bringToFront(newRoute)
        },
        screen = {
            RoutedContent(router = router) { child ->
                when (child) {
                    BottomMenuRouter.Trainings -> TrainingsGraph(
                        toTrainingBuilder = toTrainingBuilder,
                        toTrainingDetails = toTrainingDetails
                    )

                    BottomMenuRouter.Profile -> ProfileGraph(
                        startDirection = ProfileFeature.Main,
                        toExerciseExamples = toExerciseExamples,
                        toWeightHistory = toWeightHistory,
                        toMuscles = toMuscles,
                        toEquipment = toEquipment,
                        toTraining = toTrainingBuilder,
                        toExerciseExampleBuilder = toExerciseExampleBuilder
                    )
                }
            }
        }
    )
}