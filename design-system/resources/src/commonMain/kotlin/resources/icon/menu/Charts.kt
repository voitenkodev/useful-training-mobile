package resources.icon.menu

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Charts: ImageVector
    get() {
        if (_Charts != null) {
            return _Charts!!
        }
        _Charts = ImageVector.Builder(
            name = "Charts",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(85.04f, -0.05f)
                    horizontalLineTo(14.97f)
                    curveTo(6.46f, -0.05f, -0.05f, 6.46f, -0.05f, 14.97f)
                    verticalLineTo(85.04f)
                    curveTo(-0.05f, 93.54f, 6.46f, 100.05f, 14.97f, 100.05f)
                    horizontalLineTo(85.04f)
                    curveTo(93.54f, 100.05f, 100.05f, 93.54f, 100.05f, 85.04f)
                    verticalLineTo(14.97f)
                    curveTo(100.05f, 6.46f, 93.54f, -0.05f, 85.04f, -0.05f)
                    close()
                    moveTo(29.98f, 75.03f)
                    curveTo(29.98f, 78.03f, 27.98f, 80.03f, 24.98f, 80.03f)
                    curveTo(21.97f, 80.03f, 19.97f, 78.03f, 19.97f, 75.03f)
                    verticalLineTo(55.01f)
                    curveTo(19.97f, 52f, 21.97f, 50f, 24.98f, 50f)
                    curveTo(27.98f, 50f, 29.98f, 52f, 29.98f, 55.01f)
                    verticalLineTo(75.03f)
                    close()
                    moveTo(55.01f, 75.03f)
                    curveTo(55.01f, 78.03f, 53f, 80.03f, 50f, 80.03f)
                    curveTo(47f, 80.03f, 44.99f, 78.03f, 44.99f, 75.03f)
                    verticalLineTo(24.98f)
                    curveTo(44.99f, 21.97f, 47f, 19.97f, 50f, 19.97f)
                    curveTo(53f, 19.97f, 55.01f, 21.97f, 55.01f, 24.98f)
                    verticalLineTo(75.03f)
                    close()
                    moveTo(80.03f, 75.03f)
                    curveTo(80.03f, 78.03f, 78.03f, 80.03f, 75.03f, 80.03f)
                    curveTo(72.02f, 80.03f, 70.02f, 78.03f, 70.02f, 75.03f)
                    verticalLineTo(44.99f)
                    curveTo(70.02f, 41.99f, 72.02f, 39.99f, 75.03f, 39.99f)
                    curveTo(78.03f, 39.99f, 80.03f, 41.99f, 80.03f, 44.99f)
                    verticalLineTo(75.03f)
                    close()
                }
            }
        }.build()

        return _Charts!!
    }

@Suppress("ObjectPropertyName")
private var _Charts: ImageVector? = null
