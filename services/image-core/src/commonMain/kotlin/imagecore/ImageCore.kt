package imagecore

import coil3.ComponentRegistry
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.annotation.ExperimentalCoilApi
import coil3.disk.DiskCache
import coil3.util.DebugLogger
import io.ktor.client.HttpClient

@OptIn(ExperimentalCoilApi::class)
public fun initCoil3(context: PlatformContext, debug: Boolean): ImageLoader {
    return ImageLoader.Builder(context)
        .components {
//            add(coil3.fetch.NetworkFetcher.Factory(lazy { imageHttpClient() }))
            add(coil3.fetch.NetworkFetcher.Factory())
            addPlatformComponents()
        }
//        .configureDefaultCache()
        .apply {
            if (debug) logger(DebugLogger())
        }.build()
}

internal val defaultHeaders: Map<String, String>
    get() = mapOf(
        "x-app-version" to "", // PlatformInfo.getAppVersion(),
        "x-os-name" to "" // PlatformInfo.getOsName().name
    )

internal fun ImageLoader.Builder.configureDefaultCache() = diskCache(
    DiskCache.Builder()
//    .directory(PathProducer.produceCachePath("image_cache").toPath())
        .maxSizeBytes(1024 * 1024 * 1024L) // 1GB
        .build()
)

internal expect fun imageHttpClient(): HttpClient
internal expect fun ComponentRegistry.Builder.addPlatformComponents()