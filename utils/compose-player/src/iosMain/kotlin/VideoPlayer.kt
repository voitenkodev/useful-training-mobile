import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryAmbient
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.play
import platform.AVFoundation.volume
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    nativeLocalResource: NativeLocalResource,
) {

    val audioSession = AVAudioSession.sharedInstance()
    try {
        audioSession.setCategory(AVAudioSessionCategoryAmbient, null)
    } catch (e: Exception) {
        // Handle any errors
    }

    val player = remember { AVPlayer(uRL = nativeLocalResource.url) }
    player.volume = 0f
    val avPlayerViewController = remember { AVPlayerViewController() }

    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = false
    avPlayerViewController.videoGravity = AVLayerVideoGravityResizeAspectFill

    UIKitView(
        factory = {
            avPlayerViewController.view
        }, onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.setFrame(rect)
            CATransaction.commit()
        }, update = { view ->
            avPlayerViewController.player?.play()
        }, modifier = modifier
    )
}