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
                moveTo(32.22f, 13.52f)
                curveTo(46.71f, 6.93f, 64.39f, 9.59f, 76.33f, 21.52f)
                lineTo(91.08f, 36.28f)
                curveTo(91.23f, 36.43f, 91.38f, 36.57f, 91.52f, 36.72f)
                curveTo(93.53f, 38.71f, 95.25f, 40.44f, 96.3f, 42.4f)
                curveTo(98.6f, 46.73f, 98.6f, 51.93f, 96.3f, 56.26f)
                curveTo(95.25f, 58.22f, 93.53f, 59.95f, 91.52f, 61.94f)
                curveTo(91.38f, 62.09f, 91.23f, 62.24f, 91.08f, 62.38f)
                lineTo(90.83f, 62.64f)
                curveTo(88.91f, 64.56f, 85.79f, 64.56f, 83.88f, 62.64f)
                curveTo(81.95f, 60.72f, 81.95f, 57.61f, 83.88f, 55.69f)
                lineTo(84.13f, 55.43f)
                curveTo(86.83f, 52.73f, 87.36f, 52.12f, 87.62f, 51.64f)
                curveTo(88.39f, 50.2f, 88.39f, 48.47f, 87.62f, 47.02f)
                curveTo(87.36f, 46.54f, 86.83f, 45.93f, 84.13f, 43.23f)
                lineTo(69.37f, 28.47f)
                curveTo(60.43f, 19.53f, 47.18f, 17.52f, 36.29f, 22.47f)
                curveTo(33.82f, 23.6f, 30.91f, 22.5f, 29.78f, 20.03f)
                curveTo(28.66f, 17.56f, 29.75f, 14.65f, 32.22f, 13.52f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(68.8f, 81.56f)
                curveTo(54.31f, 88.15f, 36.63f, 85.49f, 24.7f, 73.56f)
                lineTo(9.94f, 58.8f)
                curveTo(9.8f, 58.65f, 9.65f, 58.51f, 9.5f, 58.36f)
                curveTo(7.5f, 56.37f, 5.77f, 54.64f, 4.73f, 52.68f)
                curveTo(2.42f, 48.35f, 2.42f, 43.15f, 4.73f, 38.82f)
                curveTo(5.77f, 36.86f, 7.5f, 35.13f, 9.5f, 33.14f)
                curveTo(9.65f, 32.99f, 9.8f, 32.84f, 9.94f, 32.7f)
                lineTo(10.2f, 32.44f)
                curveTo(12.12f, 30.52f, 15.23f, 30.52f, 17.15f, 32.44f)
                curveTo(19.07f, 34.36f, 19.07f, 37.47f, 17.15f, 39.39f)
                lineTo(16.9f, 39.65f)
                curveTo(14.2f, 42.35f, 13.67f, 42.96f, 13.41f, 43.44f)
                curveTo(12.64f, 44.88f, 12.64f, 46.61f, 13.41f, 48.06f)
                curveTo(13.67f, 48.54f, 14.2f, 49.15f, 16.9f, 51.85f)
                lineTo(31.66f, 66.61f)
                curveTo(40.59f, 75.55f, 53.85f, 77.56f, 64.73f, 72.61f)
                curveTo(67.21f, 71.48f, 70.12f, 72.58f, 71.24f, 75.05f)
                curveTo(72.37f, 77.52f, 71.28f, 80.43f, 68.8f, 81.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(49.5f, 49.5f)
                moveToRelative(-9.5f, 0f)
                arcToRelative(9.5f, 9.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, 19f, 0f)
                arcToRelative(9.5f, 9.5f, 0f, isMoreThanHalf = true, isPositiveArc = true, -19f, 0f)
            }
        }.build()

        return _Eyeon!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeon: ImageVector? = null
