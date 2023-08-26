import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.play
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

    val player = remember { AVPlayer(uRL = nativeLocalResource.url) }
    val avPlayerViewController = remember { AVPlayerViewController() }

    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = false // You can customize this as needed
    avPlayerViewController.videoGravity = AVLayerVideoGravityResizeAspectFill // Set the videoGravity here

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