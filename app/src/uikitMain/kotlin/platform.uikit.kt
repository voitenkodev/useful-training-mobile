import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.stately.freeze
import com.seiko.imageloader.ImageLoaderBuilder
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberAsyncImagePainter
import data.dto.ShortTraining
import data.dto.Training
import data.dto.User
import data.source.AuthProtocol
import data.source.TrainingProtocol
import designsystem.common.DesignComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext
import kotlin.math.min

@Composable
actual fun BackHandler(action: () -> Unit) {
    val triggerBackPressDragDistance = 40f
    val dragDistance = remember { mutableStateOf(0f) }
    val state = rememberDraggableState { dragDistance.value = min(dragDistance.value + it, triggerBackPressDragDistance * 2) }

    Box(
        modifier = Modifier.fillMaxHeight().widthIn(min = 20.dp)
            .draggable(state = state, orientation = Orientation.Horizontal, onDragStopped = {
                if (dragDistance.value > triggerBackPressDragDistance) {
                    action.invoke()
                    dragDistance.value = 0f
                }
            }), contentAlignment = Alignment.CenterStart
    ) {

        AnimatedVisibility(visible = dragDistance.value > triggerBackPressDragDistance,
            enter = slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(durationMillis = 100)),
            exit = slideOutHorizontally(targetOffsetX = { -it }),
            content = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = DesignComponent.colors.content,
                )
            })
    }
}

@Composable
actual fun RemoteImage(imageUrl: String, modifier: Modifier, contentDescription: String?) {
    CompositionLocalProvider(
        LocalImageLoader provides ImageLoaderBuilder().build(),
    ) {
        val resource = rememberAsyncImagePainter(
            url = imageUrl,
            imageLoader = LocalImageLoader.current,
        )

        Image(
            painter = resource,
            contentDescription = contentDescription,
            modifier = modifier,
        )
    }
}

actual class AuthSource : AuthProtocol {

    override fun login(email: String, password: String): Flow<User> = flow {
        emit(User(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun registration(email: String, password: String): Flow<User> = flow {
        emit(User(uid = "123", displayName = "Test Name", email = "example@com.dev"))
    }

    override fun logout(): Flow<Unit> = flow { emit(Unit) }

    override val isAuthorized: Boolean = true

    override val user: User = User(uid = "123", displayName = "Test Name", email = "example@com.dev")
}

actual class TrainingSource : TrainingProtocol {
    override suspend fun setTraining(
        userId: String?,
        trainingId: String,
        training: Training
    ): Flow<Unit> = flow { emit(Unit)}

    override suspend fun removeTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit)}

    override suspend fun removeShortTraining(userId: String?, trainingId: String): Flow<Unit> = flow { emit(Unit)}

    override suspend fun getTrainings(
        userId: String?,
    ): Flow<List<Training>> = flow { emit(emptyList())}

    override suspend fun getShortTrainings(
        userId: String?,
    ): Flow<List<ShortTraining>> = flow { emit(emptyList())}

    override suspend fun setShortTraining(
        userId: String?,
        trainingId: String,
        training: ShortTraining
    ): Flow<Unit> = flow { emit(Unit)}
}

actual val defaultDispatcher: CoroutineContext = MainDispatcher

actual val uiDispatcher: CoroutineContext = MainDispatcher


@ThreadLocal
object MainDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            try {
                block.run().freeze()
            } catch (err: Throwable) {
                throw err
            }
        }
    }
}