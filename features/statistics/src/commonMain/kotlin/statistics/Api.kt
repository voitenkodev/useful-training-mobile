package statistics

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import statistics.screen.StatisticsContent
import statistics.screen.StatisticsViewModel

// TODO ADD GRAPH !!!

@Composable
public fun StatisticGraph() {

    val vm = rememberOnRoute(StatisticsViewModel::class) {
        StatisticsViewModel()
    }

    StatisticsContent(
        vm = vm
    )
}