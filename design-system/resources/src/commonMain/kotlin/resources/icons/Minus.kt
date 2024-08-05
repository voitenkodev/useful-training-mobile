package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Minus: ImageVector
    get() {
        if (_Minus != null) {
            return _Minus!!
        }
        _Minus = ImageVector.Builder(
            name = "Minus",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(50f, -0.2f)
                    curveTo(40.1f, -0.2f, 30.42f, 2.74f, 22.19f, 8.25f)
                    curveTo(13.96f, 13.76f, 7.55f, 21.58f, 3.76f, 30.74f)
                    curveTo(-0.03f, 39.9f, -1.02f, 49.98f, 0.91f, 59.7f)
                    curveTo(2.84f, 69.43f, 7.61f, 78.36f, 14.61f, 85.37f)
                    curveTo(21.61f, 92.38f, 30.53f, 97.15f, 40.24f, 99.09f)
                    curveTo(49.94f, 101.02f, 60.01f, 100.03f, 69.15f, 96.23f)
                    curveTo(78.3f, 92.44f, 86.12f, 86.02f, 91.61f, 77.77f)
                    curveTo(97.11f, 69.53f, 100.05f, 59.84f, 100.05f, 49.92f)
                    curveTo(100.05f, 43.34f, 98.76f, 36.82f, 96.24f, 30.74f)
                    curveTo(93.72f, 24.66f, 90.04f, 19.14f, 85.39f, 14.48f)
                    curveTo(80.74f, 9.83f, 75.23f, 6.13f, 69.15f, 3.62f)
                    curveTo(63.08f, 1.1f, 56.57f, -0.2f, 50f, -0.2f)
                    close()
                    moveTo(70.02f, 54.94f)
                    horizontalLineTo(29.98f)
                    curveTo(28.65f, 54.94f, 27.38f, 54.41f, 26.44f, 53.47f)
                    curveTo(25.5f, 52.53f, 24.97f, 51.25f, 24.97f, 49.92f)
                    curveTo(24.97f, 48.6f, 25.5f, 47.32f, 26.44f, 46.38f)
                    curveTo(27.38f, 45.44f, 28.65f, 44.91f, 29.98f, 44.91f)
                    horizontalLineTo(70.02f)
                    curveTo(71.35f, 44.91f, 72.62f, 45.44f, 73.56f, 46.38f)
                    curveTo(74.5f, 47.32f, 75.02f, 48.6f, 75.02f, 49.92f)
                    curveTo(75.02f, 51.25f, 74.5f, 52.53f, 73.56f, 53.47f)
                    curveTo(72.62f, 54.41f, 71.35f, 54.94f, 70.02f, 54.94f)
                    close()
                }
            }
        }.build()

        return _Minus!!
    }

@Suppress("ObjectPropertyName")
private var _Minus: ImageVector? = null
