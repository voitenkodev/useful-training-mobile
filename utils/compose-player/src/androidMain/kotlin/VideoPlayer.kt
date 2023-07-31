import android.net.Uri
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

    val u = ResourceReader().readPath("intro.mp4")

    AndroidView(
        modifier = modifier,
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(Uri.parse(u))
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