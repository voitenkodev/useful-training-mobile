package resources.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Plus: ImageVector
    get() {
        if (_Plus != null) {
            return _Plus!!
        }
        _Plus = ImageVector.Builder(
            name = "Plus",
            defaultWidth = 101.dp,
            defaultHeight = 100.dp,
            viewportWidth = 101f,
            viewportHeight = 100f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(68.89f, 53.13f)
                    horizontalLineTo(53.26f)
                    verticalLineTo(68.75f)
                    curveTo(53.26f, 70.47f, 51.86f, 71.88f, 50.14f, 71.88f)
                    curveTo(48.41f, 71.88f, 47.01f, 70.47f, 47.01f, 68.75f)
                    verticalLineTo(53.13f)
                    horizontalLineTo(31.39f)
                    curveTo(29.66f, 53.13f, 28.26f, 51.72f, 28.26f, 50f)
                    curveTo(28.26f, 48.28f, 29.66f, 46.88f, 31.39f, 46.88f)
                    horizontalLineTo(47.01f)
                    verticalLineTo(31.25f)
                    curveTo(47.01f, 29.53f, 48.41f, 28.13f, 50.14f, 28.13f)
                    curveTo(51.86f, 28.13f, 53.26f, 29.53f, 53.26f, 31.25f)
                    verticalLineTo(46.88f)
                    horizontalLineTo(68.89f)
                    curveTo(70.61f, 46.88f, 72.01f, 48.28f, 72.01f, 50f)
                    curveTo(72.01f, 51.72f, 70.61f, 53.13f, 68.89f, 53.13f)
                    close()
                    moveTo(50.14f, 0f)
                    curveTo(22.52f, 0f, 0.14f, 22.38f, 0.14f, 50f)
                    curveTo(0.14f, 77.63f, 22.52f, 100f, 50.14f, 100f)
                    curveTo(77.75f, 100f, 100.14f, 77.63f, 100.14f, 50f)
                    curveTo(100.14f, 22.38f, 77.75f, 0f, 50.14f, 0f)
                    close()
                }
            }
        }.build()

        return _Plus!!
    }

@Suppress("ObjectPropertyName")
private var _Plus: ImageVector? = null
