import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import dev.icerock.moko.resources.FileResource

@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    fileResource: FileResource,
    allowControls: Boolean
) {

    val uri = "android.resource://com.voitenko.usefultraining/${fileResource.rawResId}"

    AndroidView(
        modifier = modifier,
        factory = { context ->
            VideoView(context).apply {
                setVideoURI(Uri.parse(uri))
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