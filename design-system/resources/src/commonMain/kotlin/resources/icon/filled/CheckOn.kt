package resources.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val CheckOn: ImageVector
    get() {
        if (_Checkon != null) {
            return _Checkon!!
        }
        _Checkon = ImageVector.Builder(
            name = "Checkon",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xff2afa2d))) {
                    moveTo(50f, 0f)
                    curveTo(63.26f, 0f, 75.98f, 5.27f, 85.36f, 14.64f)
                    curveTo(94.73f, 24.02f, 100f, 36.74f, 100f, 50f)
                    curveTo(100f, 63.26f, 94.73f, 75.98f, 85.36f, 85.36f)
                    curveTo(75.98f, 94.73f, 63.26f, 100f, 50f, 100f)
                    curveTo(36.74f, 100f, 24.02f, 94.73f, 14.64f, 85.36f)
                    curveTo(5.27f, 75.98f, 0f, 63.26f, 0f, 50f)
                    curveTo(0f, 36.74f, 5.27f, 24.02f, 14.64f, 14.64f)
                    curveTo(24.02f, 5.27f, 36.74f, 0f, 50f, 0f)
                    close()
                    moveTo(43.77f, 59.86f)
                    lineTo(32.66f, 48.75f)
                    curveTo(32.27f, 48.35f, 31.79f, 48.04f, 31.27f, 47.82f)
                    curveTo(30.75f, 47.6f, 30.2f, 47.49f, 29.63f, 47.49f)
                    curveTo(29.07f, 47.49f, 28.51f, 47.6f, 27.99f, 47.82f)
                    curveTo(27.47f, 48.04f, 27f, 48.35f, 26.6f, 48.75f)
                    curveTo(25.8f, 49.55f, 25.34f, 50.64f, 25.34f, 51.78f)
                    curveTo(25.34f, 52.92f, 25.8f, 54.01f, 26.6f, 54.81f)
                    lineTo(40.74f, 68.96f)
                    curveTo(41.14f, 69.36f, 41.61f, 69.67f, 42.13f, 69.89f)
                    curveTo(42.65f, 70.11f, 43.21f, 70.22f, 43.78f, 70.22f)
                    curveTo(44.34f, 70.22f, 44.9f, 70.11f, 45.42f, 69.89f)
                    curveTo(45.94f, 69.67f, 46.41f, 69.36f, 46.81f, 68.96f)
                    lineTo(76.09f, 39.66f)
                    curveTo(76.5f, 39.27f, 76.82f, 38.8f, 77.04f, 38.27f)
                    curveTo(77.26f, 37.75f, 77.37f, 37.19f, 77.37f, 36.63f)
                    curveTo(77.38f, 36.06f, 77.27f, 35.5f, 77.05f, 34.98f)
                    curveTo(76.84f, 34.45f, 76.52f, 33.98f, 76.12f, 33.58f)
                    curveTo(75.72f, 33.18f, 75.25f, 32.86f, 74.72f, 32.65f)
                    curveTo(74.2f, 32.43f, 73.64f, 32.32f, 73.07f, 32.32f)
                    curveTo(72.51f, 32.32f, 71.95f, 32.44f, 71.43f, 32.66f)
                    curveTo(70.91f, 32.88f, 70.43f, 33.2f, 70.04f, 33.6f)
                    lineTo(43.77f, 59.86f)
                    close()
                }
            }
        }.build()

        return _Checkon!!
    }

@Suppress("ObjectPropertyName")
private var _Checkon: ImageVector? = null
