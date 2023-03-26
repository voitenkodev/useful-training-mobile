import androidx.compose.runtime.Composable
import data.source.datastore.createDataStore
import data.source.datastore.dataStoreFileName
import data.source.network.Client
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask


internal actual val platformModule = module {

    single {
        val engine = HttpClient(Darwin) { engine { configureRequest { setAllowsCellularAccess(true) } } }
        Client(get(), engine).address()
    }

    single {
        createDataStore(
            coroutineScope = CoroutineScope(Dispatchers.Default),
            producePath = {
                val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                    directory = NSDocumentDirectory,
                    inDomain = NSUserDomainMask,
                    appropriateForURL = null,
                    create = false,
                    error = null,
                )
                requireNotNull(documentDirectory).path + "/$dataStoreFileName"
            }
        )
    }
}

@Composable
internal actual fun BackHandler(action: () -> Unit) {
//    val triggerBackPressDragDistance = 40f
//    val dragDistance = remember { mutableStateOf(0f) }
//    val state = rememberDraggableState { dragDistance.value = min(dragDistance.value + it, triggerBackPressDragDistance * 2) }
//
//    Box(
//        modifier = Modifier.fillMaxHeight().widthIn(min = 20.dp)
//            .draggable(state = state, orientation = Orientation.Horizontal, onDragStopped = {
//                if (dragDistance.value > triggerBackPressDragDistance) {
//                    action.invoke()
//                    dragDistance.value = 0f
//                }
//            }), contentAlignment = Alignment.CenterStart
//    ) {
//
//        AnimatedVisibility(visible = dragDistance.value > triggerBackPressDragDistance,
//            enter = slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(durationMillis = 100)),
//            exit = slideOutHorizontally(targetOffsetX = { -it }),
//            content = {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = null,
//                    modifier = Modifier.size(40.dp),
//                    tint = Color.White,
//                )
//            }
//        )
//    }
}