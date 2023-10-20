package statistic

import androidx.compose.runtime.Composable
import io.github.xxfast.decompose.router.rememberOnRoute
import statistic.screen.StatisticContent
import statistic.screen.StatisticViewModel

@Composable
public fun StatisticFeature() {
    val vm = rememberOnRoute(StatisticViewModel::class) { StatisticViewModel() }

    StatisticContent(
        vm = vm,
    )
}