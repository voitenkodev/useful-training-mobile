package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val ArrowLeft: ImageVector
    get() {
        if (_Arrowleft != null) {
            return _Arrowleft!!
        }
        _Arrowleft = ImageVector.Builder(
            name = "Arrowleft",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(77.49f, 5.28f)
                    curveTo(79.5f, 7.29f, 79.5f, 10.54f, 77.49f, 12.55f)
                    lineTo(39.98f, 50.07f)
                    lineTo(77.49f, 87.58f)
                    curveTo(79.5f, 89.59f, 79.5f, 92.85f, 77.49f, 94.86f)
                    lineTo(73.86f, 98.49f)
                    curveTo(71.85f, 100.5f, 68.59f, 100.5f, 66.58f, 98.49f)
                    lineTo(23.61f, 55.52f)
                    curveTo(20.6f, 52.51f, 20.6f, 47.62f, 23.61f, 44.61f)
                    lineTo(66.58f, 1.64f)
                    curveTo(68.59f, -0.37f, 71.85f, -0.37f, 73.86f, 1.64f)
                    lineTo(77.49f, 5.28f)
                    close()
                }
            }
        }.build()

        return _Arrowleft!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowleft: ImageVector? = null
