package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val EyeOn: ImageVector
    get() {
        if (_Eyeon != null) {
            return _Eyeon!!
        }
        _Eyeon = ImageVector.Builder(
            name = "Eyeon",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(32.22f, 15.52f)
                curveTo(46.71f, 8.93f, 64.39f, 11.59f, 76.32f, 23.52f)
                lineTo(91.08f, 38.28f)
                curveTo(91.23f, 38.43f, 91.38f, 38.57f, 91.52f, 38.72f)
                curveTo(93.53f, 40.71f, 95.25f, 42.44f, 96.3f, 44.4f)
                curveTo(98.6f, 48.73f, 98.6f, 53.93f, 96.3f, 58.26f)
                curveTo(95.25f, 60.22f, 93.53f, 61.95f, 91.52f, 63.94f)
                curveTo(91.38f, 64.09f, 91.23f, 64.24f, 91.08f, 64.38f)
                lineTo(81f, 74.5f)
                lineTo(68f, 84.5f)
                curveTo(65f, 85f, 63.42f, 78.42f, 61.5f, 76.5f)
                curveTo(66.5f, 74.5f, 81.95f, 59.61f, 83.87f, 57.69f)
                lineTo(84.13f, 57.43f)
                curveTo(86.83f, 54.73f, 87.36f, 54.12f, 87.62f, 53.64f)
                curveTo(88.39f, 52.2f, 88.39f, 50.47f, 87.62f, 49.02f)
                curveTo(87.36f, 48.54f, 86.83f, 47.93f, 84.13f, 45.23f)
                lineTo(69.37f, 30.47f)
                curveTo(60.43f, 21.53f, 47.18f, 19.52f, 36.29f, 24.47f)
                curveTo(33.82f, 25.6f, 30.91f, 24.5f, 29.78f, 22.03f)
                curveTo(28.66f, 19.56f, 29.75f, 16.65f, 32.22f, 15.52f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(66.8f, 85.01f)
                curveTo(52.31f, 91.6f, 34.63f, 88.94f, 22.7f, 77.01f)
                lineTo(7.94f, 62.25f)
                curveTo(7.8f, 62.1f, 7.65f, 61.96f, 7.5f, 61.81f)
                curveTo(5.5f, 59.82f, 3.77f, 58.09f, 2.73f, 56.13f)
                curveTo(0.42f, 51.8f, 0.42f, 46.6f, 2.73f, 42.27f)
                curveTo(3.77f, 40.31f, 5.5f, 38.58f, 7.5f, 36.59f)
                curveTo(7.65f, 36.44f, 7.8f, 36.29f, 7.94f, 36.15f)
                curveTo(7.94f, 36.15f, 17.06f, 27.06f, 18.03f, 26.03f)
                curveTo(19f, 25f, 31.5f, 16f, 31.5f, 16f)
                curveTo(34f, 16.5f, 35.58f, 22.08f, 37.5f, 24f)
                curveTo(32.5f, 26f, 17.07f, 40.92f, 15.15f, 42.84f)
                lineTo(14.9f, 43.1f)
                curveTo(12.2f, 45.79f, 11.67f, 46.4f, 11.41f, 46.89f)
                curveTo(10.64f, 48.33f, 10.64f, 50.06f, 11.41f, 51.51f)
                curveTo(11.67f, 51.99f, 12.2f, 52.6f, 14.9f, 55.3f)
                lineTo(29.65f, 70.06f)
                curveTo(38.59f, 79f, 51.85f, 81.01f, 62.73f, 76.06f)
                curveTo(65.21f, 74.93f, 69.38f, 77.03f, 70.5f, 79.5f)
                curveTo(71.62f, 81.97f, 69.28f, 83.88f, 66.8f, 85.01f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(49.5f, 51.5f)
                moveToRelative(-9.5f, 0f)
                arcToRelative(9.5f, 9.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 19f, 0f)
                arcToRelative(9.5f, 9.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -19f, 0f)
            }
        }.build()

        return _Eyeon!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeon: ImageVector? = null
