package graph

import RoutedContent
import Router
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import rememberRouter

@Parcelize
internal sealed class BottomMenuRouter : Parcelable {
    data object Trainings : BottomMenuRouter()
    data object Statistic : BottomMenuRouter()
}

@Composable
internal fun BottomMenuGraph() {

    val router: Router<BottomMenuRouter> = rememberRouter(BottomMenuRouter::class, listOf(BottomMenuRouter.Trainings))

    RoutedContent(
        router = router,
        animation = stackAnimation()
    ) { child ->
        when (child) {
            BottomMenuRouter.Statistic -> {}
            BottomMenuRouter.Trainings -> TrainingsGraph()
        }
    }
}