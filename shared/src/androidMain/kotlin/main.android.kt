import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import io.github.xxfast.decompose.router.LocalRouterContext
import io.github.xxfast.decompose.router.RouterContext
import io.github.xxfast.decompose.router.defaultRouterContext

public fun ComponentActivity.main() {
    val rootComponentContext: RouterContext = defaultRouterContext()

    setContent {
        CompositionLocalProvider(
            // Navigation
            LocalRouterContext provides rootComponentContext,

            // Cache image
//            LocalImageLoader provides remember { generateImageLoader(this.applicationContext) },
        ) {
            Main()
        }
    }
}