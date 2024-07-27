package weighthistory

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import weighthistory.main.WeightHistoryContent
import weighthistory.main.WeightHistoryViewModel

@Serializable
public sealed class WeightHistoryFeature {
    @Serializable
    public data object Main : WeightHistoryFeature()
}

@Composable
public fun WeightHistoryGraph(close: () -> Unit) {

    val router: Router<WeightHistoryFeature> = rememberRouter(WeightHistoryFeature::class) {
        listOf(WeightHistoryFeature.Main)
    }

    RoutedContent(
        router = router,
        animation = stackAnimation(slide(orientation = Orientation.Horizontal))
    ) { child ->
        when (child) {
            is WeightHistoryFeature.Main -> {
                val vm = rememberOnRoute(WeightHistoryViewModel::class) {
                    WeightHistoryViewModel()
                }

                WeightHistoryContent(
                    vm = vm,
                    close = close
                )
            }
        }
    }
}
