package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val GymLifeOutline: ImageVector
    get() {
        if (_Gymlifeoutline != null) {
            return _Gymlifeoutline!!
        }
        _Gymlifeoutline = ImageVector.Builder(
            name = "Gymlifeoutline",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(66.65f, 29.18f)
                    curveTo(64.35f, 29.18f, 62.49f, 31.05f, 62.49f, 33.35f)
                    verticalLineTo(37.51f)
                    horizontalLineTo(37.51f)
                    verticalLineTo(33.35f)
                    curveTo(37.51f, 31.05f, 35.64f, 29.18f, 33.34f, 29.18f)
                    curveTo(31.04f, 29.18f, 29.18f, 31.05f, 29.18f, 33.35f)
                    verticalLineTo(50f)
                    curveTo(29.18f, 52.3f, 31.04f, 54.16f, 33.34f, 54.16f)
                    curveTo(35.64f, 54.16f, 37.51f, 52.3f, 37.51f, 50f)
                    verticalLineTo(45.84f)
                    horizontalLineTo(62.49f)
                    verticalLineTo(50f)
                    curveTo(62.49f, 52.3f, 64.35f, 54.16f, 66.65f, 54.16f)
                    curveTo(68.95f, 54.16f, 70.82f, 52.3f, 70.82f, 50f)
                    verticalLineTo(33.35f)
                    curveTo(70.82f, 31.05f, 68.95f, 29.18f, 66.65f, 29.18f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(92.77f, 15f)
                    curveTo(86.15f, 8.09f, 78.7f, 4.2f, 70.25f, 4.2f)
                    curveTo(62.11f, 4.2f, 54.86f, 8.4f, 49.96f, 15.13f)
                    curveTo(45.1f, 8.39f, 37.93f, 4.2f, 29.81f, 4.2f)
                    curveTo(21.41f, 4.2f, 14.08f, 8.05f, 7.31f, 14.97f)
                    curveTo(-2.86f, 25.38f, -2.9f, 44.65f, 10.22f, 57.45f)
                    curveTo(12.76f, 59.93f, 19.08f, 66.27f, 28f, 75.27f)
                    curveTo(32.28f, 79.6f, 36.72f, 84.08f, 41.15f, 88.57f)
                    curveTo(42.71f, 90.14f, 44.15f, 91.6f, 45.44f, 92.91f)
                    curveTo(46.77f, 94.26f, 46.77f, 94.26f, 47.06f, 94.56f)
                    curveTo(48.69f, 96.21f, 51.36f, 96.21f, 52.99f, 94.56f)
                    curveTo(53.28f, 94.26f, 53.28f, 94.26f, 54.61f, 92.91f)
                    curveTo(55.9f, 91.6f, 57.34f, 90.14f, 58.9f, 88.57f)
                    curveTo(63.33f, 84.08f, 67.77f, 79.6f, 71.92f, 75.41f)
                    curveTo(80.97f, 66.27f, 87.29f, 59.93f, 89.83f, 57.45f)
                    curveTo(102.9f, 44.7f, 102.81f, 25.49f, 92.77f, 15f)
                    close()
                    moveTo(84.01f, 51.49f)
                    curveTo(81.43f, 54.01f, 75.1f, 60.37f, 66.13f, 69.41f)
                    curveTo(61.85f, 73.74f, 57.41f, 78.23f, 52.97f, 82.72f)
                    curveTo(51.94f, 83.77f, 50.95f, 84.77f, 50.03f, 85.71f)
                    curveTo(49.1f, 84.77f, 48.11f, 83.77f, 47.08f, 82.72f)
                    curveTo(42.64f, 78.23f, 38.2f, 73.74f, 34.05f, 69.55f)
                    curveTo(24.96f, 60.37f, 18.63f, 54.02f, 16.04f, 51.49f)
                    curveTo(6.25f, 41.94f, 6.28f, 27.94f, 13.27f, 20.79f)
                    curveTo(18.6f, 15.34f, 23.95f, 12.53f, 29.81f, 12.53f)
                    curveTo(36.78f, 12.53f, 42.95f, 17.47f, 46.09f, 25.27f)
                    curveTo(47.49f, 28.75f, 52.41f, 28.75f, 53.81f, 25.27f)
                    curveTo(56.93f, 17.52f, 63.23f, 12.53f, 70.25f, 12.53f)
                    curveTo(76.16f, 12.53f, 81.58f, 15.36f, 86.76f, 20.76f)
                    curveTo(93.69f, 28.01f, 93.76f, 41.99f, 84.01f, 51.49f)
                    close()
                }
            }
        }.build()

        return _Gymlifeoutline!!
    }

@Suppress("ObjectPropertyName")
private var _Gymlifeoutline: ImageVector? = null
