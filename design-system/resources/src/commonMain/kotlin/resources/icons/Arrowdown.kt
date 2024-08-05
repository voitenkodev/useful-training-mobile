package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val ArrowDown: ImageVector
    get() {
        if (_Arrowdown != null) {
            return _Arrowdown!!
        }
        _Arrowdown = ImageVector.Builder(
            name = "Arrowdown",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(5.28f, 22.51f)
                curveTo(7.29f, 20.5f, 10.54f, 20.5f, 12.55f, 22.51f)
                lineTo(50.07f, 60.02f)
                lineTo(87.58f, 22.51f)
                curveTo(89.59f, 20.5f, 92.85f, 20.5f, 94.86f, 22.51f)
                lineTo(98.49f, 26.14f)
                curveTo(100.5f, 28.15f, 100.5f, 31.41f, 98.49f, 33.42f)
                lineTo(55.52f, 76.39f)
                curveTo(52.51f, 79.4f, 47.62f, 79.4f, 44.61f, 76.39f)
                lineTo(1.64f, 33.42f)
                curveTo(-0.37f, 31.41f, -0.37f, 28.15f, 1.64f, 26.14f)
                lineTo(5.28f, 22.51f)
                close()
            }
        }.build()

        return _Arrowdown!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowdown: ImageVector? = null
