package graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import bottommenu.BottomMenuFeature
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import configurations.ConfigurationsFeature
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import statistics.StatisticFeature

@Parcelize
internal sealed class BottomMenuRouter : Parcelable {
    data object Trainings : BottomMenuRouter()
    data object Statistics : BottomMenuRouter()
    data object Configurations : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph(
    toTrainingBuilder: (id: String?) -> Unit,
    toTrainingDetails: (id: String) -> Unit,
    toExerciseExampleBuilder: (id: String?) -> Unit
) {

    val router: Router<BottomMenuRouter> = rememberRouter(BottomMenuRouter::class) {
        listOf(BottomMenuRouter.Trainings)
    }

    val selectedIndex = remember { mutableStateOf(0) }

    LaunchedEffect(router.stack.value.active.configuration) {
        when (router.stack.value.active.configuration) {
            BottomMenuRouter.Trainings -> selectedIndex.value = 0
            BottomMenuRouter.Statistics -> selectedIndex.value = 1
            BottomMenuRouter.Configurations -> selectedIndex.value = 2
        }
    }

    BottomMenuFeature(
        selectedIndex = selectedIndex.value,
        onClick = {
            val newRoute = when (it) {
                0 -> BottomMenuRouter.Trainings
                1 -> BottomMenuRouter.Statistics
                else -> BottomMenuRouter.Configurations
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

                    BottomMenuRouter.Configurations -> ConfigurationsFeature(
                        toExerciseExampleBuilder = toExerciseExampleBuilder
                    )

                    BottomMenuRouter.Statistics -> StatisticFeature()
                }
            }
        }
    )
}