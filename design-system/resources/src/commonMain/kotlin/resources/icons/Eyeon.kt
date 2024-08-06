package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
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
            group {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(30.66f, 49.8f)
                    curveTo(30.66f, 38.81f, 39.56f, 29.9f, 50.53f, 29.9f)
                    curveTo(61.51f, 29.9f, 70.4f, 38.81f, 70.4f, 49.8f)
                    curveTo(70.4f, 60.79f, 61.51f, 69.7f, 50.53f, 69.7f)
                    curveTo(39.56f, 69.7f, 30.66f, 60.79f, 30.66f, 49.8f)
                    close()
                    moveTo(21.93f, 21.66f)
                    curveTo(37.45f, 6.11f, 62.61f, 6.11f, 78.13f, 21.66f)
                    lineTo(88.9f, 32.44f)
                    curveTo(92.02f, 35.56f, 94.7f, 38.25f, 96.56f, 40.69f)
                    curveTo(98.55f, 43.31f, 100.06f, 46.21f, 100.06f, 49.8f)
                    curveTo(100.06f, 53.39f, 98.55f, 56.3f, 96.56f, 58.91f)
                    curveTo(94.7f, 61.35f, 92.02f, 64.04f, 88.9f, 67.16f)
                    lineTo(78.13f, 77.94f)
                    curveTo(62.61f, 93.49f, 37.45f, 93.49f, 21.93f, 77.94f)
                    lineTo(11.16f, 67.16f)
                    curveTo(8.05f, 64.04f, 5.36f, 61.35f, 3.5f, 58.91f)
                    curveTo(1.51f, 56.3f, 0f, 53.39f, 0f, 49.8f)
                    curveTo(0f, 46.21f, 1.51f, 43.31f, 3.5f, 40.69f)
                    curveTo(5.36f, 38.25f, 8.05f, 35.56f, 11.16f, 32.44f)
                    curveTo(11.24f, 32.37f, 11.31f, 32.29f, 11.39f, 32.21f)
                    lineTo(21.93f, 21.66f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(50.53f, 39.81f)
                    curveTo(45.04f, 39.81f, 40.6f, 44.26f, 40.6f, 49.76f)
                    curveTo(40.6f, 55.25f, 45.04f, 59.71f, 50.53f, 59.71f)
                    curveTo(56.02f, 59.71f, 60.47f, 55.25f, 60.47f, 49.76f)
                    curveTo(60.47f, 44.26f, 56.02f, 39.81f, 50.53f, 39.81f)
                    close()
                }
            }
        }.build()

        return _Eyeon!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeon: ImageVector? = null
