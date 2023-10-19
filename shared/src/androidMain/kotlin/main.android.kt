import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext

public fun ComponentActivity.main() {
    val rootComponentContext: DefaultComponentContext = defaultComponentContext()

    setContent {
        CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
            Main()
        }
    }
}