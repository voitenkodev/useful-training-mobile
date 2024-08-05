package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val ArrowUp: ImageVector
    get() {
        if (_Arrowup != null) {
            return _Arrowup!!
        }
        _Arrowup = ImageVector.Builder(
            name = "Arrowup",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(94.72f, 77.49f)
                curveTo(92.71f, 79.5f, 89.46f, 79.5f, 87.45f, 77.49f)
                lineTo(49.93f, 39.98f)
                lineTo(12.42f, 77.49f)
                curveTo(10.41f, 79.5f, 7.15f, 79.5f, 5.14f, 77.49f)
                lineTo(1.51f, 73.86f)
                curveTo(-0.5f, 71.85f, -0.5f, 68.59f, 1.51f, 66.58f)
                lineTo(44.48f, 23.61f)
                curveTo(47.49f, 20.6f, 52.38f, 20.6f, 55.39f, 23.61f)
                lineTo(98.36f, 66.58f)
                curveTo(100.37f, 68.59f, 100.37f, 71.85f, 98.36f, 73.86f)
                lineTo(94.72f, 77.49f)
                close()
            }
        }.build()

        return _Arrowup!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowup: ImageVector? = null
