package resources.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val MaleGym: ImageVector
    get() {
        if (_Malegym != null) {
            return _Malegym!!
        }
        _Malegym = ImageVector.Builder(
            name = "Malegym",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(80.82f, 49.75f)
                curveTo(80.82f, 51.42f, 79.47f, 52.78f, 77.79f, 52.78f)
                horizontalLineTo(67.67f)
                curveTo(65.99f, 52.78f, 64.64f, 51.42f, 64.64f, 49.75f)
                curveTo(64.64f, 48.08f, 65.99f, 46.72f, 67.67f, 46.72f)
                horizontalLineTo(77.79f)
                curveTo(79.47f, 46.72f, 80.82f, 48.07f, 80.82f, 49.75f)
                close()
                moveTo(67.67f, 13.89f)
                horizontalLineTo(77.79f)
                curveTo(79.47f, 13.89f, 80.82f, 12.53f, 80.82f, 10.86f)
                curveTo(80.82f, 9.19f, 79.47f, 7.83f, 77.79f, 7.83f)
                horizontalLineTo(67.67f)
                curveTo(65.99f, 7.83f, 64.64f, 9.19f, 64.64f, 10.86f)
                curveTo(64.64f, 12.53f, 65.99f, 13.89f, 67.67f, 13.89f)
                close()
                moveTo(81.23f, 38.45f)
                horizontalLineTo(75.76f)
                verticalLineTo(35.81f)
                curveTo(78.83f, 35.51f, 81.23f, 32.95f, 81.23f, 29.81f)
                curveTo(81.23f, 26.66f, 78.83f, 24.11f, 75.76f, 23.81f)
                verticalLineTo(22.16f)
                horizontalLineTo(81.23f)
                curveTo(82.9f, 22.16f, 84.26f, 20.8f, 84.26f, 19.13f)
                curveTo(84.26f, 17.45f, 82.9f, 16.09f, 81.23f, 16.09f)
                lineTo(64.23f, 16.1f)
                curveTo(62.56f, 16.1f, 61.2f, 17.45f, 61.2f, 19.13f)
                curveTo(61.2f, 20.8f, 62.56f, 22.16f, 64.23f, 22.16f)
                horizontalLineTo(69.7f)
                verticalLineTo(23.75f)
                horizontalLineTo(51.05f)
                curveTo(54.4f, 21.38f, 56.6f, 17.5f, 56.6f, 13.08f)
                curveTo(56.6f, 5.86f, 50.74f, 0f, 43.51f, 0f)
                curveTo(36.29f, 0f, 30.43f, 5.86f, 30.43f, 13.08f)
                curveTo(30.43f, 17.5f, 32.64f, 21.38f, 35.98f, 23.75f)
                horizontalLineTo(35.72f)
                curveTo(24.7f, 23.75f, 15.73f, 33.4f, 15.73f, 45.25f)
                verticalLineTo(54.91f)
                curveTo(15.73f, 58.25f, 18.45f, 60.97f, 21.79f, 60.97f)
                curveTo(25.14f, 60.97f, 27.85f, 58.25f, 27.85f, 54.91f)
                verticalLineTo(45.25f)
                curveTo(27.85f, 42.95f, 28.58f, 40.87f, 29.74f, 39.24f)
                verticalLineTo(93.94f)
                curveTo(29.74f, 97.28f, 32.45f, 100f, 35.8f, 100f)
                curveTo(39.14f, 100f, 41.86f, 97.28f, 41.86f, 93.94f)
                verticalLineTo(69.06f)
                horizontalLineTo(45.18f)
                verticalLineTo(93.94f)
                curveTo(45.18f, 97.28f, 47.9f, 100f, 51.24f, 100f)
                curveTo(54.59f, 100f, 57.3f, 97.28f, 57.3f, 93.94f)
                verticalLineTo(35.87f)
                horizontalLineTo(69.71f)
                verticalLineTo(38.45f)
                horizontalLineTo(64.24f)
                curveTo(62.57f, 38.45f, 61.21f, 39.8f, 61.21f, 41.48f)
                curveTo(61.21f, 43.15f, 62.57f, 44.51f, 64.24f, 44.51f)
                horizontalLineTo(81.24f)
                curveTo(82.91f, 44.51f, 84.27f, 43.15f, 84.27f, 41.48f)
                curveTo(84.27f, 39.81f, 82.9f, 38.45f, 81.23f, 38.45f)
                close()
            }
        }.build()

        return _Malegym!!
    }

@Suppress("ObjectPropertyName")
private var _Malegym: ImageVector? = null
