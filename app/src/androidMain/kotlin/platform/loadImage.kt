package platform

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import io.ktor.client.call.*
import io.ktor.client.request.*
import ktorClient

actual suspend fun loadImage(url: String): ImageBitmap {
    val response = ktorClient.get(url).body<ByteArray>()
    val bitmap = BitmapFactory.decodeByteArray(response, 0, response.size)
    return bitmap.asImageBitmap()
}