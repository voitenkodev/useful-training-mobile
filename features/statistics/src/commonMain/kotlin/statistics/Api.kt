package statistics

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import statistics.screen.StatisticsContent
import statistics.screen.StatisticsViewModel

@Serializable
public sealed class StatisticsRouter {
    @Serializable
    public data object Main : StatisticsRouter()
}

@Composable
public fun StatisticsGraph() {

    val router: Router<StatisticsRouter> = rememberRouter(StatisticsRouter::class) {
        listOf(StatisticsRouter.Main)
    }

    RoutedContent(router = router) { child ->
        when (child) {
            StatisticsRouter.Main -> {

                val vm = rememberOnRoute(StatisticsViewModel::class) {
                    StatisticsViewModel()
                }

                StatisticsContent(
                    vm = vm
                )
            }
        }
    }
}