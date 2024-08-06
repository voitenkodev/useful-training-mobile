package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Baby: ImageVector
    get() {
        if (_Baby != null) {
            return _Baby!!
        }
        _Baby = ImageVector.Builder(
            name = "Baby",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF0F0F0F))) {
                    moveTo(41.67f, 54.17f)
                    curveTo(43.97f, 54.17f, 45.83f, 52.3f, 45.83f, 50f)
                    curveTo(45.83f, 47.7f, 43.97f, 45.83f, 41.67f, 45.83f)
                    curveTo(39.37f, 45.83f, 37.5f, 47.7f, 37.5f, 50f)
                    curveTo(37.5f, 52.3f, 39.37f, 54.17f, 41.67f, 54.17f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0F0F0F))) {
                    moveTo(62.5f, 50f)
                    curveTo(62.5f, 52.3f, 60.63f, 54.17f, 58.33f, 54.17f)
                    curveTo(56.03f, 54.17f, 54.17f, 52.3f, 54.17f, 50f)
                    curveTo(54.17f, 47.7f, 56.03f, 45.83f, 58.33f, 45.83f)
                    curveTo(60.63f, 45.83f, 62.5f, 47.7f, 62.5f, 50f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0F0F0F))) {
                    moveTo(34.55f, 63.72f)
                    curveTo(36.17f, 62.11f, 38.77f, 62.09f, 40.4f, 63.68f)
                    curveTo(41.02f, 64.23f, 41.75f, 64.66f, 42.49f, 65.02f)
                    curveTo(44.06f, 65.81f, 46.55f, 66.67f, 50f, 66.67f)
                    curveTo(53.45f, 66.67f, 55.94f, 65.81f, 57.51f, 65.02f)
                    curveTo(58.25f, 64.66f, 58.98f, 64.23f, 59.6f, 63.68f)
                    curveTo(61.23f, 62.09f, 63.83f, 62.11f, 65.45f, 63.72f)
                    curveTo(67.07f, 65.35f, 67.07f, 67.99f, 65.45f, 69.61f)
                    curveTo(65.13f, 69.93f, 64.8f, 70.22f, 64.22f, 70.65f)
                    curveTo(63.52f, 71.18f, 62.53f, 71.83f, 61.24f, 72.48f)
                    curveTo(58.65f, 73.77f, 54.89f, 75f, 50f, 75f)
                    curveTo(45.11f, 75f, 41.35f, 73.77f, 38.76f, 72.48f)
                    curveTo(37.47f, 71.83f, 36.48f, 71.18f, 35.78f, 70.65f)
                    curveTo(35.2f, 70.22f, 34.88f, 69.93f, 34.56f, 69.62f)
                    curveTo(32.93f, 67.99f, 32.93f, 65.35f, 34.55f, 63.72f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF0F0F0F)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(54.71f, 11.68f)
                    curveTo(55.4f, 12.9f, 55.85f, 14.66f, 54.99f, 16.96f)
                    curveTo(53.35f, 16.77f, 51.69f, 16.67f, 50f, 16.67f)
                    curveTo(31.66f, 16.67f, 16.08f, 28.52f, 10.52f, 44.98f)
                    curveTo(4.48f, 46.44f, 0f, 51.88f, 0f, 58.36f)
                    curveTo(0f, 64.85f, 4.49f, 70.29f, 10.54f, 71.74f)
                    curveTo(16.12f, 88.18f, 31.68f, 100f, 50f, 100f)
                    curveTo(68.32f, 100f, 83.88f, 88.18f, 89.46f, 71.74f)
                    curveTo(95.51f, 70.29f, 100f, 64.85f, 100f, 58.36f)
                    curveTo(100f, 51.88f, 95.52f, 46.44f, 89.48f, 44.98f)
                    curveTo(85.31f, 32.65f, 75.52f, 22.9f, 63.16f, 18.79f)
                    curveTo(64.37f, 14.72f, 63.8f, 10.84f, 61.97f, 7.59f)
                    curveTo(59.43f, 3.09f, 54.5f, 0f, 50f, 0f)
                    curveTo(46.11f, 0f, 43.17f, 1.47f, 41.25f, 2.92f)
                    curveTo(40.29f, 3.64f, 39.57f, 4.36f, 39.07f, 4.92f)
                    curveTo(38.82f, 5.2f, 38.62f, 5.44f, 38.48f, 5.63f)
                    curveTo(37.02f, 7.56f, 37.26f, 10.41f, 39.36f, 11.8f)
                    curveTo(41.59f, 13.29f, 43.74f, 12.21f, 45.3f, 10.45f)
                    curveTo(45.5f, 10.23f, 45.82f, 9.91f, 46.25f, 9.58f)
                    curveTo(47.1f, 8.95f, 48.32f, 8.33f, 50f, 8.33f)
                    curveTo(51.07f, 8.33f, 53.43f, 9.41f, 54.71f, 11.68f)
                    close()
                    moveTo(83.05f, 64.71f)
                    lineTo(87.52f, 63.64f)
                    curveTo(89.9f, 63.07f, 91.67f, 60.91f, 91.67f, 58.36f)
                    curveTo(91.67f, 55.81f, 89.91f, 53.66f, 87.52f, 53.08f)
                    lineTo(83.06f, 52f)
                    lineTo(81.59f, 47.65f)
                    curveTo(77.13f, 34.47f, 64.66f, 25f, 50f, 25f)
                    curveTo(35.34f, 25f, 22.87f, 34.47f, 18.41f, 47.65f)
                    lineTo(16.94f, 52f)
                    lineTo(12.48f, 53.08f)
                    curveTo(10.09f, 53.66f, 8.33f, 55.81f, 8.33f, 58.36f)
                    curveTo(8.33f, 60.91f, 10.1f, 63.07f, 12.48f, 63.64f)
                    lineTo(16.95f, 64.71f)
                    lineTo(18.43f, 69.06f)
                    curveTo(22.9f, 82.22f, 35.36f, 91.67f, 50f, 91.67f)
                    curveTo(64.64f, 91.67f, 77.1f, 82.22f, 81.57f, 69.06f)
                    lineTo(83.05f, 64.71f)
                    close()
                }
            }
        }.build()

        return _Baby!!
    }

@Suppress("ObjectPropertyName")
private var _Baby: ImageVector? = null
