package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Weight: ImageVector
    get() {
        if (_Weight != null) {
            return _Weight!!
        }
        _Weight = ImageVector.Builder(
            name = "Weight",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(72.22f, -0.05f)
                    horizontalLineTo(27.78f)
                    curveTo(11.11f, -0.05f, 0f, 9.96f, 0f, 24.98f)
                    verticalLineTo(75.03f)
                    curveTo(0f, 90.04f, 11.11f, 100.05f, 27.78f, 100.05f)
                    horizontalLineTo(72.22f)
                    curveTo(88.89f, 100.05f, 100f, 90.04f, 100f, 75.03f)
                    verticalLineTo(24.98f)
                    curveTo(100f, 9.96f, 88.89f, -0.05f, 72.22f, -0.05f)
                    close()
                    moveTo(80.94f, 32.38f)
                    lineTo(68.83f, 49.9f)
                    curveTo(68.5f, 50.35f, 67.94f, 50.7f, 67.39f, 50.75f)
                    curveTo(67.28f, 50.75f, 67.17f, 50.75f, 67.11f, 50.75f)
                    curveTo(66.61f, 50.75f, 66.11f, 50.6f, 65.72f, 50.3f)
                    curveTo(56.78f, 43.14f, 43.33f, 43.14f, 34.39f, 50.3f)
                    curveTo(33.94f, 50.65f, 33.33f, 50.85f, 32.72f, 50.75f)
                    curveTo(32.11f, 50.65f, 31.56f, 50.35f, 31.28f, 49.9f)
                    lineTo(19.17f, 32.38f)
                    curveTo(18.5f, 31.63f, 18.67f, 30.63f, 19.44f, 29.98f)
                    curveTo(36.83f, 16.02f, 63.11f, 16.02f, 80.56f, 29.98f)
                    curveTo(81.33f, 30.63f, 81.5f, 31.63f, 80.94f, 32.38f)
                    close()
                }
            }
        }.build()

        return _Weight!!
    }

@Suppress("ObjectPropertyName")
private var _Weight: ImageVector? = null
