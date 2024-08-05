package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

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
                    moveTo(85.6f, 18.29f)
                    curveTo(87.4f, 16.49f, 87.4f, 13.57f, 85.6f, 11.77f)
                    curveTo(83.8f, 9.97f, 80.88f, 9.97f, 79.08f, 11.77f)
                    lineTo(59.44f, 31.41f)
                    curveTo(56.69f, 29.79f, 53.49f, 28.86f, 50.07f, 28.86f)
                    curveTo(39.88f, 28.86f, 31.63f, 37.12f, 31.63f, 47.3f)
                    curveTo(31.63f, 50.72f, 32.56f, 53.93f, 34.18f, 56.67f)
                    lineTo(14.54f, 76.32f)
                    curveTo(12.74f, 78.12f, 12.74f, 81.04f, 14.54f, 82.84f)
                    curveTo(16.34f, 84.64f, 19.26f, 84.64f, 21.06f, 82.84f)
                    lineTo(40.7f, 63.19f)
                    curveTo(43.45f, 64.81f, 46.65f, 65.74f, 50.07f, 65.74f)
                    curveTo(60.25f, 65.74f, 68.51f, 57.49f, 68.51f, 47.3f)
                    curveTo(68.51f, 43.88f, 67.58f, 40.68f, 65.96f, 37.93f)
                    lineTo(85.6f, 18.29f)
                    close()
                    moveTo(52.46f, 38.39f)
                    curveTo(51.7f, 38.19f, 50.89f, 38.08f, 50.07f, 38.08f)
                    curveTo(44.98f, 38.08f, 40.85f, 42.21f, 40.85f, 47.3f)
                    curveTo(40.85f, 48.13f, 40.96f, 48.93f, 41.16f, 49.69f)
                    lineTo(52.46f, 38.39f)
                    close()
                    moveTo(47.68f, 56.21f)
                    lineTo(58.98f, 44.91f)
                    curveTo(59.18f, 45.68f, 59.29f, 46.48f, 59.29f, 47.3f)
                    curveTo(59.29f, 52.4f, 55.16f, 56.52f, 50.07f, 56.52f)
                    curveTo(49.24f, 56.52f, 48.44f, 56.41f, 47.68f, 56.21f)
                    close()
                    moveTo(67.43f, 14.2f)
                    curveTo(62.19f, 11.9f, 56.37f, 10.42f, 50.07f, 10.42f)
                    curveTo(36.92f, 10.42f, 25.9f, 16.85f, 17.79f, 23.82f)
                    curveTo(9.65f, 30.81f, 4f, 38.72f, 1.49f, 42.55f)
                    curveTo(-0.4f, 45.45f, -0.4f, 49.15f, 1.49f, 52.05f)
                    curveTo(3.61f, 55.29f, 7.96f, 61.43f, 14.16f, 67.47f)
                    lineTo(20.68f, 60.95f)
                    curveTo(15.29f, 55.71f, 11.39f, 50.31f, 9.4f, 47.3f)
                    curveTo(11.76f, 43.74f, 16.77f, 36.84f, 23.8f, 30.81f)
                    curveTo(31.05f, 24.58f, 40f, 19.64f, 50.07f, 19.64f)
                    curveTo(53.63f, 19.64f, 57.05f, 20.26f, 60.3f, 21.33f)
                    lineTo(67.43f, 14.2f)
                    close()
                    moveTo(50.07f, 74.97f)
                    curveTo(46.51f, 74.97f, 43.09f, 74.35f, 39.84f, 73.28f)
                    lineTo(32.71f, 80.4f)
                    curveTo(37.95f, 82.71f, 43.76f, 84.19f, 50.07f, 84.19f)
                    curveTo(63.22f, 84.19f, 74.24f, 77.76f, 82.35f, 70.79f)
                    curveTo(90.49f, 63.8f, 96.14f, 55.89f, 98.64f, 52.05f)
                    curveTo(100.54f, 49.15f, 100.54f, 45.45f, 98.64f, 42.55f)
                    curveTo(96.53f, 39.31f, 92.18f, 33.18f, 85.98f, 27.14f)
                    lineTo(79.45f, 33.66f)
                    curveTo(84.85f, 38.9f, 88.74f, 44.29f, 90.73f, 47.3f)
                    curveTo(88.38f, 50.86f, 83.36f, 57.76f, 76.34f, 63.79f)
                    curveTo(69.09f, 70.02f, 60.14f, 74.97f, 50.07f, 74.97f)
                    close()
                }
            }
        }.build()

        return _Eyeoff!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeoff: ImageVector? = null
