package graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import atomic.icons.HandWeight
import atomic.icons.Weight
import bottommenu.BottomMenuFeature
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter
import statistic.StatisticFeature

@Parcelize
internal sealed class BottomMenuRouter : Parcelable {
    data object Trainings : BottomMenuRouter()
    data object Statistic : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph() {

    val router: Router<BottomMenuRouter> = rememberRouter(BottomMenuRouter::class) {
        listOf(BottomMenuRouter.Trainings)
    }

    val menu = listOf(
        Weight to "Trainings",
        HandWeight to "Statistic",
    )
    val selected = remember {
        mutableStateOf(menu.first())
    }

    LaunchedEffect(router.stack.value.active.configuration) {
        when (router.stack.value.active.configuration) {
            BottomMenuRouter.Trainings -> selected.value = menu[0]
            BottomMenuRouter.Statistic -> selected.value = menu[1]
        }
    }

    BottomMenuFeature(
        items = menu,
        selected = selected.value,
        onClick = {
            val newRoute = when (it) {
                0 -> BottomMenuRouter.Trainings
                else -> BottomMenuRouter.Statistic
            }
            router.bringToFront(newRoute)
        },
        screen = {
            RoutedContent(
                router = router,
            ) { child ->

                when (child) {
                    BottomMenuRouter.Trainings -> TrainingsGraph()
                    BottomMenuRouter.Statistic -> StatisticFeature()
                }
            }
        }
    )
}