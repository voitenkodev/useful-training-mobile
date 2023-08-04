import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import platform.AVFoundation.AVLayerVideoGravity
import platform.AVFoundation.AVLayerVideoGravityResizeAspect
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.AVVideoScalingModeResizeAspect
import platform.AVFoundation.play
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.QuartzCore.CALayerContentsGravity
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIColor
import platform.UIKit.UIView

@Composable
actual fun VideoPlayer(
    modifier: Modifier,
    nativeLocalResource: NativeLocalResource,
) {

    val player = remember { AVPlayer(uRL = nativeLocalResource.url) }
    val playerLayer = remember {
        AVPlayerLayer().apply {
            setVideoGravity(AVLayerVideoGravityResizeAspect)
            setContentsGravity(AVVideoScalingModeResizeAspect)
        }
    }
    val avPlayerViewController = remember { AVPlayerViewController() }

    avPlayerViewController.player = player
    playerLayer.player = player
    playerLayer.videoGravity = "1"

    UIKitView(
        modifier = modifier,
        factory = {
            val playerContainer = UIView().apply { backgroundColor = UIColor.blueColor }
            playerContainer.addSubview(avPlayerViewController.view)
            playerContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()
        },
        update = { view ->
            player.play()
            avPlayerViewController.player!!.play()
        },
    )
}