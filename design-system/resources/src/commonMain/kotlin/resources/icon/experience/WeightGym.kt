package resources.icon.experience

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val WeightGym: ImageVector
    get() {
        if (_Weightgym != null) {
            return _Weightgym!!
        }
        _Weightgym = ImageVector.Builder(
            name = "Weightgym",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(50f, 0f)
                    curveTo(22.39f, 0f, 0f, 22.39f, 0f, 50f)
                    curveTo(0f, 77.61f, 22.39f, 100f, 50f, 100f)
                    curveTo(77.61f, 100f, 100f, 77.61f, 100f, 50f)
                    curveTo(100f, 22.39f, 77.61f, 0f, 50f, 0f)
                    close()
                    moveTo(50f, 91.67f)
                    curveTo(26.99f, 91.67f, 8.33f, 73.01f, 8.33f, 50f)
                    curveTo(8.33f, 26.99f, 26.99f, 8.33f, 50f, 8.33f)
                    curveTo(73.01f, 8.33f, 91.67f, 26.99f, 91.67f, 50f)
                    curveTo(91.67f, 73.01f, 73.01f, 91.67f, 50f, 91.67f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(73.78f, 26.22f)
                    curveTo(72.15f, 24.59f, 69.51f, 24.59f, 67.89f, 26.22f)
                    lineTo(58.46f, 35.64f)
                    curveTo(55.98f, 34.18f, 53.09f, 33.33f, 50f, 33.33f)
                    curveTo(46.91f, 33.33f, 44.02f, 34.18f, 41.54f, 35.64f)
                    lineTo(32.11f, 26.22f)
                    curveTo(30.49f, 24.59f, 27.85f, 24.59f, 26.22f, 26.22f)
                    curveTo(24.59f, 27.85f, 24.59f, 30.49f, 26.22f, 32.11f)
                    lineTo(35.64f, 41.54f)
                    curveTo(34.18f, 44.02f, 33.33f, 46.91f, 33.33f, 50f)
                    curveTo(33.33f, 53.09f, 34.18f, 55.98f, 35.64f, 58.46f)
                    lineTo(26.22f, 67.89f)
                    curveTo(24.59f, 69.51f, 24.59f, 72.15f, 26.22f, 73.78f)
                    curveTo(27.85f, 75.41f, 30.49f, 75.41f, 32.11f, 73.78f)
                    lineTo(41.54f, 64.36f)
                    curveTo(44.02f, 65.82f, 46.91f, 66.67f, 50f, 66.67f)
                    curveTo(53.09f, 66.67f, 55.98f, 65.82f, 58.46f, 64.36f)
                    lineTo(67.89f, 73.78f)
                    curveTo(69.51f, 75.41f, 72.15f, 75.41f, 73.78f, 73.78f)
                    curveTo(75.41f, 72.15f, 75.41f, 69.51f, 73.78f, 67.89f)
                    lineTo(64.36f, 58.46f)
                    curveTo(65.82f, 55.98f, 66.67f, 53.09f, 66.67f, 50f)
                    curveTo(66.67f, 46.91f, 65.82f, 44.02f, 64.36f, 41.54f)
                    lineTo(73.78f, 32.11f)
                    curveTo(75.41f, 30.49f, 75.41f, 27.85f, 73.78f, 26.22f)
                    close()
                    moveTo(45.65f, 57.11f)
                    curveTo(45.45f, 56.48f, 45.11f, 55.88f, 44.61f, 55.39f)
                    curveTo(44.11f, 54.89f, 43.52f, 54.55f, 42.89f, 54.35f)
                    curveTo(42.12f, 53.09f, 41.67f, 51.6f, 41.67f, 50f)
                    curveTo(41.67f, 48.4f, 42.12f, 46.91f, 42.89f, 45.65f)
                    curveTo(43.52f, 45.45f, 44.11f, 45.11f, 44.61f, 44.61f)
                    curveTo(45.11f, 44.11f, 45.45f, 43.52f, 45.65f, 42.89f)
                    curveTo(46.91f, 42.12f, 48.4f, 41.67f, 50f, 41.67f)
                    curveTo(51.6f, 41.67f, 53.09f, 42.12f, 54.35f, 42.89f)
                    curveTo(54.55f, 43.52f, 54.89f, 44.11f, 55.39f, 44.61f)
                    curveTo(55.89f, 45.11f, 56.48f, 45.45f, 57.11f, 45.65f)
                    curveTo(57.88f, 46.91f, 58.33f, 48.4f, 58.33f, 50f)
                    curveTo(58.33f, 51.6f, 57.88f, 53.09f, 57.11f, 54.35f)
                    curveTo(56.48f, 54.55f, 55.89f, 54.89f, 55.39f, 55.39f)
                    curveTo(54.89f, 55.88f, 54.55f, 56.48f, 54.35f, 57.11f)
                    curveTo(53.09f, 57.88f, 51.6f, 58.33f, 50f, 58.33f)
                    curveTo(48.4f, 58.33f, 46.91f, 57.88f, 45.65f, 57.11f)
                    close()
                }
            }
        }.build()

        return _Weightgym!!
    }

@Suppress("ObjectPropertyName")
private var _Weightgym: ImageVector? = null
