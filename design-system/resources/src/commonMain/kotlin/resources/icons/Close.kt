package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Close: ImageVector
    get() {
        if (_Close != null) {
            return _Close!!
        }
        _Close = ImageVector.Builder(
            name = "Close",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(2.77f, 2.77f)
                    curveTo(4.56f, 0.98f, 6.98f, -0.03f, 9.51f, -0.03f)
                    curveTo(12.04f, -0.03f, 14.47f, 0.98f, 16.26f, 2.77f)
                    lineTo(50f, 36.51f)
                    lineTo(83.74f, 2.77f)
                    curveTo(85.54f, 1.03f, 87.95f, 0.07f, 90.45f, 0.09f)
                    curveTo(92.95f, 0.11f, 95.35f, 1.11f, 97.12f, 2.88f)
                    curveTo(98.89f, 4.65f, 99.89f, 7.05f, 99.91f, 9.55f)
                    curveTo(99.93f, 12.05f, 98.97f, 14.46f, 97.23f, 16.26f)
                    lineTo(63.49f, 50f)
                    lineTo(97.23f, 83.74f)
                    curveTo(98.97f, 85.54f, 99.93f, 87.95f, 99.91f, 90.45f)
                    curveTo(99.89f, 92.95f, 98.89f, 95.35f, 97.12f, 97.12f)
                    curveTo(95.35f, 98.89f, 92.95f, 99.89f, 90.45f, 99.91f)
                    curveTo(87.95f, 99.93f, 85.54f, 98.97f, 83.74f, 97.23f)
                    lineTo(50f, 63.49f)
                    lineTo(16.26f, 97.23f)
                    curveTo(14.46f, 98.97f, 12.05f, 99.93f, 9.55f, 99.91f)
                    curveTo(7.05f, 99.89f, 4.65f, 98.89f, 2.88f, 97.12f)
                    curveTo(1.11f, 95.35f, 0.11f, 92.95f, 0.09f, 90.45f)
                    curveTo(0.07f, 87.95f, 1.03f, 85.54f, 2.77f, 83.74f)
                    lineTo(36.51f, 50f)
                    lineTo(2.77f, 16.26f)
                    curveTo(0.98f, 14.47f, -0.03f, 12.04f, -0.03f, 9.51f)
                    curveTo(-0.03f, 6.98f, 0.98f, 4.56f, 2.77f, 2.77f)
                    close()
                }
            }
        }.build()

        return _Close!!
    }

@Suppress("ObjectPropertyName")
private var _Close: ImageVector? = null
