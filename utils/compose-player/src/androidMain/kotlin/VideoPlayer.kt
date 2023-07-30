import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    url: String,
    allowControls: Boolean
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            VideoView(context).apply {
                setVideoPath(url)
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