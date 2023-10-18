import android.content.Context
import androidx.media3.common.C
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun Context.createExoPlayer(uri: String): ExoPlayer {

    val player = ExoPlayer.Builder(this)
        .build()

    val defaultDataSourceFactory = DefaultDataSource
        .Factory(this@createExoPlayer)
    val dataSourceFactory: DataSource.Factory = DefaultDataSource
        .Factory(this@createExoPlayer, defaultDataSourceFactory)

    val source = ProgressiveMediaSource
        .Factory(dataSourceFactory)
        .createMediaSource(androidx.media3.common.MediaItem.fromUri(uri))

    player.setMediaSource(source)
    player.prepare()

    player.playWhenReady = true
    player.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    player.repeatMode = Player.REPEAT_MODE_ONE

    return player
}