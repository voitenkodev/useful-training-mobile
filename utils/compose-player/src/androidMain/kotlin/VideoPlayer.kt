import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    nativeLocalResource: NativeLocalResource,
    allowControls: Boolean
) {

    AndroidView(
        modifier = modifier,
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(Uri.parse(nativeLocalResource.url))
                val mediaController = MediaController(context)
                if (allowControls.not()) {
                    mediaController.hide()
                } else {
                    mediaController.setAnchorView(this)
                    setMediaController(mediaController)
                }
                start()

            }
        },
        update = {}
    )
}