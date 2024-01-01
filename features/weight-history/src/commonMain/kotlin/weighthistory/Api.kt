package weighthistory

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberOnRoute
import io.github.xxfast.decompose.router.rememberRouter
import weighthistory.main.WeightHistoryContent
import weighthistory.main.WeightHistoryViewModel

@Parcelize
public sealed class WeightHistoryFeature : Parcelable {
    public data object Main : WeightHistoryFeature()
}

@Composable
public fun WeightHistoryGraph(close: () -> Unit) {

    val router: Router<WeightHistoryFeature> = rememberRouter(WeightHistoryFeature::class) {
        listOf(WeightHistoryFeature.Main)
    }

    RoutedContent(router = router, animation = stackAnimation(slide(orientation = Orientation.Horizontal))) { child ->
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
