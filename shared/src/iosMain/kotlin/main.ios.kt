import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.uikit.OnFocusBehavior
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.PredictiveBackGestureIcon
import com.arkivanov.decompose.extensions.compose.jetbrains.PredictiveBackGestureOverlay
import com.arkivanov.essenty.backhandler.BackDispatcher
import com.seiko.imageloader.LocalImageLoader
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import platform.UIKit.UIViewController

/*
* See: https://github.com/xxfast/Decompose-Router/tree/main
* How to implement router in Swift / Objective C
* */
@OptIn(ExperimentalDecomposeApi::class)
public fun MainUIController(routerContext: RouterContext): UIViewController = ComposeUIViewController(
    configure = { onFocusBehavior = OnFocusBehavior.DoNothing }
) {
    CompositionLocalProvider(
        // Navigation
        LocalRouterContext provides routerContext,

        // Cache image
        LocalImageLoader provides remember { generateImageLoader() },
    ) {

        PredictiveBackGestureOverlay(
            modifier = Modifier.fillMaxSize(),
            backDispatcher = routerContext.backHandler as BackDispatcher, // Use the same BackDispatcher as above
            backIcon = { progress, _ ->
                PredictiveBackGestureIcon(
                    imageVector = Icons.Default.ArrowBack,
                    progress = progress
                )
            },
            content = { Main() }
        )
    }
}