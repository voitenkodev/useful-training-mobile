package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val EyeOff: ImageVector
    get() {
        if (_Eyeoff != null) {
            return _Eyeoff!!
        }
        _Eyeoff = ImageVector.Builder(
            name = "Eyeoff",
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
                    moveTo(33.22f, 13.52f)
                    curveTo(47.71f, 6.93f, 65.39f, 9.59f, 77.33f, 21.52f)
                    lineTo(92.08f, 36.28f)
                    curveTo(92.23f, 36.43f, 92.38f, 36.57f, 92.52f, 36.72f)
                    curveTo(94.53f, 38.71f, 96.25f, 40.44f, 97.3f, 42.4f)
                    curveTo(99.6f, 46.73f, 99.6f, 51.93f, 97.3f, 56.26f)
                    curveTo(96.25f, 58.22f, 94.53f, 59.95f, 92.52f, 61.94f)
                    curveTo(92.38f, 62.09f, 92.23f, 62.24f, 92.08f, 62.38f)
                    lineTo(91.83f, 62.64f)
                    curveTo(89.91f, 64.56f, 86.79f, 64.56f, 84.88f, 62.64f)
                    curveTo(82.95f, 60.72f, 82.95f, 57.61f, 84.88f, 55.69f)
                    lineTo(85.13f, 55.43f)
                    curveTo(87.83f, 52.73f, 88.36f, 52.12f, 88.62f, 51.64f)
                    curveTo(89.39f, 50.2f, 89.39f, 48.47f, 88.62f, 47.02f)
                    curveTo(88.36f, 46.54f, 87.83f, 45.93f, 85.13f, 43.23f)
                    lineTo(70.37f, 28.47f)
                    curveTo(61.43f, 19.53f, 48.18f, 17.52f, 37.29f, 22.47f)
                    curveTo(34.82f, 23.6f, 31.91f, 22.5f, 30.78f, 20.03f)
                    curveTo(29.66f, 17.56f, 30.75f, 14.65f, 33.22f, 13.52f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(2.72f, 12.54f)
                    curveTo(4.39f, 10.39f, 7.48f, 10.01f, 9.62f, 11.67f)
                    lineTo(98.12f, 80.5f)
                    curveTo(100.26f, 82.17f, 100.65f, 85.26f, 98.98f, 87.4f)
                    curveTo(97.31f, 89.55f, 94.22f, 89.93f, 92.08f, 88.27f)
                    lineTo(77.52f, 76.94f)
                    lineTo(77.32f, 77.14f)
                    curveTo(61.97f, 92.5f, 37.06f, 92.5f, 21.7f, 77.14f)
                    lineTo(11.04f, 66.48f)
                    curveTo(7.96f, 63.4f, 5.31f, 60.75f, 3.47f, 58.34f)
                    curveTo(1.49f, 55.75f, 0f, 52.87f, 0f, 49.33f)
                    curveTo(0f, 45.79f, 1.49f, 42.91f, 3.47f, 40.33f)
                    curveTo(5.31f, 37.91f, 7.96f, 35.26f, 11.04f, 32.18f)
                    lineTo(14.95f, 28.27f)
                    lineTo(3.59f, 19.44f)
                    curveTo(1.44f, 17.77f, 1.06f, 14.68f, 2.72f, 12.54f)
                    close()
                    moveTo(53.73f, 58.44f)
                    lineTo(62.03f, 64.89f)
                    curveTo(58.71f, 67.47f, 54.54f, 69f, 50.01f, 69f)
                    curveTo(39.15f, 69f, 30.34f, 60.19f, 30.34f, 49.33f)
                    curveTo(30.34f, 46.55f, 30.92f, 43.9f, 31.96f, 41.51f)
                    lineTo(40.27f, 47.97f)
                    curveTo(40.21f, 48.41f, 40.18f, 48.87f, 40.18f, 49.33f)
                    curveTo(40.18f, 54.76f, 44.58f, 59.16f, 50.01f, 59.16f)
                    curveTo(51.33f, 59.16f, 52.58f, 58.9f, 53.73f, 58.44f)
                    close()
                }
            }
        }.build()

        return _Eyeoff!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeoff: ImageVector? = null
