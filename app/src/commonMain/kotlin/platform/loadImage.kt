package platform

import androidx.compose.ui.graphics.ImageBitmap

expect suspend fun loadImage(url: String): ImageBitmap