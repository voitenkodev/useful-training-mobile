package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Edit: ImageVector
    get() {
        if (_Edit != null) {
            return _Edit!!
        }
        _Edit = ImageVector.Builder(
            name = "Edit",
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
                    moveTo(84.67f, 4.47f)
                    lineTo(95.55f, 15.34f)
                    curveTo(101.56f, 21.35f, 101.56f, 31.09f, 95.55f, 37.1f)
                    lineTo(86.3f, 46.35f)
                    lineTo(53.67f, 13.71f)
                    lineTo(62.91f, 4.47f)
                    curveTo(68.92f, -1.54f, 78.66f, -1.54f, 84.67f, 4.47f)
                    close()
                    moveTo(48.23f, 19.15f)
                    lineTo(6.55f, 60.83f)
                    curveTo(4.07f, 63.31f, 2.51f, 66.56f, 2.13f, 70.04f)
                    lineTo(0.11f, 88.6f)
                    curveTo(-0.6f, 95.11f, 4.9f, 100.61f, 11.42f, 99.9f)
                    lineTo(29.97f, 97.88f)
                    curveTo(33.45f, 97.5f, 36.7f, 95.95f, 39.18f, 93.47f)
                    lineTo(80.86f, 51.79f)
                    lineTo(48.23f, 19.15f)
                    close()
                }
            }
        }.build()

        return _Edit!!
    }

@Suppress("ObjectPropertyName")
private var _Edit: ImageVector? = null
