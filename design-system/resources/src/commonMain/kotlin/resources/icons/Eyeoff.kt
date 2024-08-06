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
                    moveTo(69.8f, 81.56f)
                    curveTo(55.31f, 88.15f, 37.63f, 85.49f, 25.7f, 73.56f)
                    lineTo(10.94f, 58.8f)
                    curveTo(10.8f, 58.65f, 10.65f, 58.51f, 10.5f, 58.36f)
                    curveTo(8.5f, 56.37f, 6.77f, 54.64f, 5.73f, 52.68f)
                    curveTo(3.42f, 48.35f, 3.42f, 43.15f, 5.73f, 38.82f)
                    curveTo(6.77f, 36.86f, 8.5f, 35.13f, 10.5f, 33.14f)
                    curveTo(10.65f, 32.99f, 10.8f, 32.84f, 10.94f, 32.7f)
                    lineTo(11.2f, 32.44f)
                    curveTo(13.12f, 30.52f, 16.23f, 30.52f, 18.15f, 32.44f)
                    curveTo(20.07f, 34.36f, 20.07f, 37.47f, 18.15f, 39.39f)
                    lineTo(17.9f, 39.65f)
                    curveTo(15.2f, 42.35f, 14.67f, 42.96f, 14.41f, 43.44f)
                    curveTo(13.64f, 44.88f, 13.64f, 46.61f, 14.41f, 48.06f)
                    curveTo(14.67f, 48.54f, 15.2f, 49.15f, 17.9f, 51.85f)
                    lineTo(32.66f, 66.61f)
                    curveTo(41.59f, 75.55f, 54.85f, 77.56f, 65.73f, 72.61f)
                    curveTo(68.21f, 71.48f, 71.12f, 72.58f, 72.24f, 75.05f)
                    curveTo(73.37f, 77.52f, 72.28f, 80.43f, 69.8f, 81.56f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(9.62f, 11.67f)
                    curveTo(7.48f, 10.01f, 4.39f, 10.39f, 2.72f, 12.54f)
                    curveTo(1.06f, 14.68f, 1.44f, 17.77f, 3.59f, 19.44f)
                    lineTo(14.95f, 28.27f)
                    lineTo(31.96f, 41.51f)
                    lineTo(40.27f, 47.97f)
                    curveTo(40.21f, 48.41f, 40.18f, 48.87f, 40.18f, 49.33f)
                    curveTo(40.18f, 54.76f, 44.58f, 59.16f, 50.01f, 59.16f)
                    curveTo(51.33f, 59.16f, 52.58f, 58.9f, 53.73f, 58.44f)
                    lineTo(62.03f, 64.89f)
                    lineTo(92.08f, 88.27f)
                    curveTo(94.22f, 89.93f, 97.31f, 89.55f, 98.98f, 87.4f)
                    curveTo(100.65f, 85.26f, 100.26f, 82.17f, 98.12f, 80.5f)
                    lineTo(9.62f, 11.67f)
                    close()
                }
            }
        }.build()

        return _Eyeoff!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeoff: ImageVector? = null
