package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

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
                    moveTo(9.66f, 70.9f)
                    lineTo(7.64f, 89.47f)
                    curveTo(7.46f, 91.1f, 8.84f, 92.48f, 10.47f, 92.3f)
                    lineTo(29.04f, 90.28f)
                    curveTo(30.78f, 90.09f, 32.41f, 89.31f, 33.65f, 88.07f)
                    lineTo(90.07f, 31.64f)
                    curveTo(93.08f, 28.64f, 93.08f, 23.76f, 90.07f, 20.75f)
                    lineTo(79.18f, 9.87f)
                    curveTo(76.18f, 6.86f, 71.3f, 6.86f, 68.29f, 9.87f)
                    lineTo(11.87f, 66.29f)
                    curveTo(10.63f, 67.53f, 9.85f, 69.15f, 9.66f, 70.9f)
                    close()
                    moveTo(84.63f, 4.42f)
                    lineTo(95.52f, 15.31f)
                    curveTo(101.53f, 21.32f, 101.53f, 31.07f, 95.52f, 37.09f)
                    lineTo(39.1f, 93.51f)
                    curveTo(36.61f, 95.99f, 33.36f, 97.55f, 29.87f, 97.93f)
                    lineTo(11.3f, 99.95f)
                    curveTo(4.78f, 100.66f, -0.73f, 95.16f, -0.02f, 88.64f)
                    lineTo(2.01f, 70.06f)
                    curveTo(2.39f, 66.58f, 3.95f, 63.32f, 6.43f, 60.84f)
                    lineTo(62.85f, 4.42f)
                    curveTo(68.86f, -1.59f, 78.61f, -1.59f, 84.63f, 4.42f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(90.07f, 20.75f)
                    lineTo(79.18f, 9.87f)
                    curveTo(76.18f, 6.86f, 71.3f, 6.86f, 68.29f, 9.87f)
                    lineTo(61.76f, 16.4f)
                    lineTo(83.54f, 38.18f)
                    lineTo(90.07f, 31.64f)
                    curveTo(93.08f, 28.64f, 93.08f, 23.76f, 90.07f, 20.75f)
                    close()
                    moveTo(83.54f, 49.07f)
                    lineTo(50.87f, 16.4f)
                    lineTo(62.85f, 4.42f)
                    curveTo(68.86f, -1.59f, 78.61f, -1.59f, 84.63f, 4.42f)
                    lineTo(95.52f, 15.31f)
                    curveTo(101.53f, 21.32f, 101.53f, 31.07f, 95.52f, 37.09f)
                    lineTo(83.54f, 49.07f)
                    close()
                }
            }
        }.build()

        return _Edit!!
    }

@Suppress("ObjectPropertyName")
private var _Edit: ImageVector? = null
