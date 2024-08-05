package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

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
                    moveTo(23.8f, 66.56f)
                    curveTo(16.77f, 60.53f, 11.76f, 53.63f, 9.4f, 50.07f)
                    curveTo(11.76f, 46.51f, 16.77f, 39.61f, 23.8f, 33.58f)
                    curveTo(31.05f, 27.35f, 40f, 22.41f, 50.07f, 22.41f)
                    curveTo(60.14f, 22.41f, 69.09f, 27.35f, 76.34f, 33.58f)
                    curveTo(83.36f, 39.61f, 88.38f, 46.51f, 90.73f, 50.07f)
                    curveTo(88.38f, 53.63f, 83.36f, 60.53f, 76.34f, 66.56f)
                    curveTo(69.09f, 72.79f, 60.14f, 77.73f, 50.07f, 77.73f)
                    curveTo(40f, 77.73f, 31.05f, 72.79f, 23.8f, 66.56f)
                    close()
                    moveTo(50.07f, 13.19f)
                    curveTo(36.92f, 13.19f, 25.9f, 19.62f, 17.79f, 26.58f)
                    curveTo(9.65f, 33.58f, 4f, 41.48f, 1.49f, 45.32f)
                    curveTo(-0.4f, 48.22f, -0.4f, 51.92f, 1.49f, 54.82f)
                    curveTo(4f, 58.66f, 9.65f, 66.56f, 17.79f, 73.56f)
                    curveTo(25.9f, 80.52f, 36.92f, 86.95f, 50.07f, 86.95f)
                    curveTo(63.22f, 86.95f, 74.24f, 80.52f, 82.35f, 73.56f)
                    curveTo(90.49f, 66.56f, 96.14f, 58.66f, 98.64f, 54.82f)
                    curveTo(100.54f, 51.92f, 100.54f, 48.22f, 98.64f, 45.32f)
                    curveTo(96.14f, 41.48f, 90.49f, 33.58f, 82.35f, 26.58f)
                    curveTo(74.24f, 19.62f, 63.22f, 13.19f, 50.07f, 13.19f)
                    close()
                    moveTo(40.85f, 50.07f)
                    curveTo(40.85f, 44.98f, 44.98f, 40.85f, 50.07f, 40.85f)
                    curveTo(55.16f, 40.85f, 59.29f, 44.98f, 59.29f, 50.07f)
                    curveTo(59.29f, 55.16f, 55.16f, 59.29f, 50.07f, 59.29f)
                    curveTo(44.98f, 59.29f, 40.85f, 55.16f, 40.85f, 50.07f)
                    close()
                    moveTo(50.07f, 31.63f)
                    curveTo(39.88f, 31.63f, 31.63f, 39.88f, 31.63f, 50.07f)
                    curveTo(31.63f, 60.25f, 39.88f, 68.51f, 50.07f, 68.51f)
                    curveTo(60.25f, 68.51f, 68.51f, 60.25f, 68.51f, 50.07f)
                    curveTo(68.51f, 39.88f, 60.25f, 31.63f, 50.07f, 31.63f)
                    close()
                }
            }
        }.build()

        return _Eyeon!!
    }

@Suppress("ObjectPropertyName")
private var _Eyeon: ImageVector? = null
