import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import co.touchlab.kermit.Logger

@Composable
fun Main(
    modifier: Modifier = Modifier,
    finalize: () -> Unit
) {
    DesignTheme(modifier = modifier.background(Color.White)) {
        StoreProvider(
            globalReducer = globalReducer,
            globalState = GlobalState(),
            logging = { if (it is Action) Logger.i { "reduxLogger::DISPATCHED => \"${it.group}/${it.action}\"" } }
        ) {
//            navigation.NavigatorRoot(
//                graph = { GlobalGraph(direction = it) },
//                finalize = finalize
//            )

            RootController(
                initial = ScreenA1(),
                finalize = {},
                content = {
                    val controller = this
                    val state: State<NavController> = controller.state.collectAsState()

                    when (state.value.current) {
                        is ScreenA1 -> ScreenA { controller.direct(ScreenB1()) }
                        is ScreenB1 -> ScreenB { controller.back() }
                    }
                }
            )

        }
    }
}

class ScreenA1 : Screen(link = "ScreenA1")
class ScreenB1 : Screen(link = "ScreenB1")

@Composable
fun ScreenA(click: () -> Unit) {
    Box(Modifier.fillMaxSize().background(Color.White).clickable { click.invoke() }){
        Text(modifier =Modifier.align(Alignment.Center), text = "Screen A", color = Color.Black)
    }

}

@Composable
fun ScreenB(click: () -> Unit) {
    Box(Modifier.fillMaxSize().background(Color.Black).clickable { click.invoke() }){
        Text(modifier =Modifier.align(Alignment.Center), text = "Screen A", color =Color.White)
    }
}