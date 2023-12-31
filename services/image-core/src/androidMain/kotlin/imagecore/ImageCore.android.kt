package imagecore

import android.os.Build
import coil3.ComponentRegistry
import coil3.decode.GifDecoder
import coil3.decode.ImageDecoderDecoder
import coil3.decode.SvgDecoder
import coil3.decode.VideoFrameDecoder
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

internal actual fun imageHttpClient(): HttpClient =
    HttpClient(OkHttp) {
        engine {
            addInterceptor { chain ->
                val builder = chain.request().newBuilder()
                defaultHeaders.entries.forEach { header ->
                    builder.addHeader(header.key, header.value)
                }
                chain.proceed(builder.build())
            }
        }
    }

internal actual fun ComponentRegistry.Builder.addPlatformComponents() {
    // GIFs
    if (Build.VERSION.SDK_INT >= 28) {
        add(ImageDecoderDecoder.Factory())
    } else {
        add(GifDecoder.Factory())
    }
    // SVGs
    add(SvgDecoder.Factory())
    // Video frames
    add(VideoFrameDecoder.Factory())
}