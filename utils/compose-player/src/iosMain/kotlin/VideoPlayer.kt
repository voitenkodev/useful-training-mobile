import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerLayer
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
    allowControls: Boolean
) {

    val player = remember { AVPlayer(uRL = nativeLocalResource.url) }
    val playerLayer = remember { AVPlayerLayer() }
    val avPlayerViewController = remember { AVPlayerViewController() }
    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = allowControls

    playerLayer.player = player
    // Use a UIKitView to integrate with your existing UIKit views
    UIKitView(
        factory = {
            // Create a UIView to hold the AVPlayerLayer
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            // Return the playerContainer as the root UIView
            playerContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            playerLayer.setFrame(rect)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()

            /*
             val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            playerContainer.translatesAutoresizingMaskIntoConstraints = false
            avPlayerViewController.view.translatesAutoresizingMaskIntoConstraints = false

            // Add constraints to make the AVPlayerViewController fill its parent view
            avPlayerViewController.view.leadingAnchor.constraintEqualToAnchor(playerContainer.leadingAnchor).isActive = true
            avPlayerViewController.view.trailingAnchor.constraintEqualToAnchor(playerContainer.trailingAnchor).isActive = true
            avPlayerViewController.view.topAnchor.constraintEqualToAnchor(playerContainer.topAnchor).isActive = true
            avPlayerViewController.view.bottomAnchor.constraintEqualToAnchor(playerContainer.bottomAnchor).isActive = true

            // Return the playerContainer as the root UIView
            playerContainer
            * */
        },
        update = { view ->
            player.play()
            avPlayerViewController.player!!.play()
        },
        modifier = modifier
    )
}