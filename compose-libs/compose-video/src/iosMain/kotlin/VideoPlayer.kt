import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import kotlinx.cinterop.memScoped
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryAmbient
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.addPeriodicTimeObserverForInterval
import platform.AVFoundation.currentItem
import platform.AVFoundation.duration
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.seekToTime
import platform.AVFoundation.volume
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.CoreMedia.CMTimeMake
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

@Composable
public actual fun VideoPlayer(
    modifier: Modifier,
    url: String,
    onStart: () -> Unit
) {

    val loadingState = remember { mutableStateOf(true) }

    val player = remember { AVPlayer(uRL = NSURL.URLWithString(url)!!) }
    val avPlayerViewController = remember { AVPlayerViewController() }

    // Drop audio
    val audioSession = AVAudioSession.sharedInstance()
    audioSession.setCategory(AVAudioSessionCategoryAmbient, null)
    player.volume = 0f

    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = false
    avPlayerViewController.videoGravity = AVLayerVideoGravityResizeAspectFill

    // Repeat video Flow (Check every 1/30th of a second (adjust as needed))
    player.addPeriodicTimeObserverForInterval(CMTimeMake(1, 30), null) { time ->
        if (player.rate() == 1.0f) { loadingState.value = false }
        if (time == player.currentItem?.duration) {
            player.seekToTime(memScoped { return@memScoped CMTimeMake(0, 1) })
            player.play()
        }
    }

    LaunchedEffect(loadingState.value) {
        if (loadingState.value.not()) onStart.invoke()
    }

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