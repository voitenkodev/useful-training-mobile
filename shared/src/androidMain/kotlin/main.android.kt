import android.content.Context
import androidx.compose.runtime.Composable

@Composable
fun MainView(appContext: Context) {
    platformAppContext = appContext
    Main()
}