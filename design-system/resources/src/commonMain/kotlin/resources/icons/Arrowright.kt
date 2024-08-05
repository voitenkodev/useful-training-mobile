package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val ArrowRight: ImageVector
    get() {
        if (_Arrowright != null) {
            return _Arrowright!!
        }
        _Arrowright = ImageVector.Builder(
            name = "Arrowright",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(22.51f, 94.72f)
                curveTo(20.5f, 92.71f, 20.5f, 89.46f, 22.51f, 87.45f)
                lineTo(60.02f, 49.93f)
                lineTo(22.51f, 12.42f)
                curveTo(20.5f, 10.41f, 20.5f, 7.15f, 22.51f, 5.14f)
                lineTo(26.14f, 1.51f)
                curveTo(28.15f, -0.5f, 31.41f, -0.5f, 33.42f, 1.51f)
                lineTo(76.39f, 44.48f)
                curveTo(79.4f, 47.49f, 79.4f, 52.38f, 76.39f, 55.39f)
                lineTo(33.42f, 98.36f)
                curveTo(31.41f, 100.37f, 28.15f, 100.37f, 26.14f, 98.36f)
                lineTo(22.51f, 94.72f)
                close()
            }
        }.build()

        return _Arrowright!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowright: ImageVector? = null
