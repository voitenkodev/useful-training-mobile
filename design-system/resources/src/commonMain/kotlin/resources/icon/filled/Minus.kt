package resources.icon.filled

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
            defaultWidth = 101.dp,
            defaultHeight = 100.dp,
            viewportWidth = 101f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(50.14f, -0.2f)
                    curveTo(40.24f, -0.2f, 30.56f, 2.74f, 22.33f, 8.25f)
                    curveTo(14.1f, 13.76f, 7.68f, 21.58f, 3.9f, 30.74f)
                    curveTo(0.11f, 39.9f, -0.88f, 49.98f, 1.05f, 59.7f)
                    curveTo(2.98f, 69.43f, 7.75f, 78.36f, 14.75f, 85.37f)
                    curveTo(21.75f, 92.38f, 30.66f, 97.15f, 40.37f, 99.09f)
                    curveTo(50.08f, 101.02f, 60.14f, 100.03f, 69.29f, 96.23f)
                    curveTo(78.43f, 92.44f, 86.25f, 86.02f, 91.75f, 77.77f)
                    curveTo(97.25f, 69.53f, 100.19f, 59.84f, 100.19f, 49.92f)
                    curveTo(100.19f, 43.34f, 98.89f, 36.82f, 96.38f, 30.74f)
                    curveTo(93.86f, 24.66f, 90.17f, 19.14f, 85.53f, 14.48f)
                    curveTo(80.88f, 9.83f, 75.36f, 6.13f, 69.29f, 3.62f)
                    curveTo(63.22f, 1.1f, 56.71f, -0.2f, 50.14f, -0.2f)
                    close()
                    moveTo(70.16f, 54.94f)
                    horizontalLineTo(30.12f)
                    curveTo(28.79f, 54.94f, 27.52f, 54.41f, 26.58f, 53.47f)
                    curveTo(25.64f, 52.53f, 25.11f, 51.25f, 25.11f, 49.92f)
                    curveTo(25.11f, 48.6f, 25.64f, 47.32f, 26.58f, 46.38f)
                    curveTo(27.52f, 45.44f, 28.79f, 44.91f, 30.12f, 44.91f)
                    horizontalLineTo(70.16f)
                    curveTo(71.48f, 44.91f, 72.76f, 45.44f, 73.7f, 46.38f)
                    curveTo(74.63f, 47.32f, 75.16f, 48.6f, 75.16f, 49.92f)
                    curveTo(75.16f, 51.25f, 74.63f, 52.53f, 73.7f, 53.47f)
                    curveTo(72.76f, 54.41f, 71.48f, 54.94f, 70.16f, 54.94f)
                    close()
                }
            }
        }.build()

        return _Minus!!
    }

@Suppress("ObjectPropertyName")
private var _Minus: ImageVector? = null
