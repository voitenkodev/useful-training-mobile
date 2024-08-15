package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Height: ImageVector
    get() {
        if (_Height != null) {
            return _Height!!
        }
        _Height = ImageVector.Builder(
            name = "Height",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(56.35f, 22.82f)
                curveTo(54.97f, 21.43f, 54.84f, 19.26f, 55.97f, 17.73f)
                lineTo(56.35f, 17.29f)
                lineTo(68.68f, 4.95f)
                curveTo(69.34f, 3.86f, 70.64f, 3.13f, 72.14f, 3.13f)
                curveTo(73.45f, 3.13f, 74.61f, 3.69f, 75.32f, 4.56f)
                lineTo(75.6f, 4.95f)
                lineTo(87.93f, 17.29f)
                lineTo(88.3f, 17.73f)
                curveTo(89.31f, 19.09f, 89.33f, 20.96f, 88.34f, 22.33f)
                lineTo(87.93f, 22.82f)
                lineTo(87.49f, 23.2f)
                curveTo(86.13f, 24.21f, 84.26f, 24.22f, 82.89f, 23.23f)
                lineTo(82.4f, 22.82f)
                lineTo(76.04f, 16.46f)
                verticalLineTo(36.17f)
                lineTo(76.01f, 36.63f)
                curveTo(75.75f, 38.3f, 74.11f, 39.58f, 72.13f, 39.58f)
                curveTo(70.16f, 39.58f, 68.52f, 38.3f, 68.26f, 36.63f)
                lineTo(68.23f, 36.16f)
                verticalLineTo(16.46f)
                lineTo(61.88f, 22.82f)
                lineTo(61.44f, 23.2f)
                curveTo(59.91f, 24.33f, 57.74f, 24.21f, 56.35f, 22.82f)
                close()
            }
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(56.37f, 77.18f)
                curveTo(57.75f, 75.79f, 59.92f, 75.67f, 61.45f, 76.8f)
                lineTo(61.89f, 77.18f)
                lineTo(68.24f, 83.54f)
                verticalLineTo(63.83f)
                curveTo(68.24f, 61.95f, 69.99f, 60.42f, 72.15f, 60.42f)
                curveTo(74.13f, 60.42f, 75.76f, 61.7f, 76.02f, 63.37f)
                lineTo(76.06f, 63.83f)
                verticalLineTo(83.54f)
                lineTo(82.42f, 77.18f)
                curveTo(83.8f, 75.79f, 85.98f, 75.67f, 87.5f, 76.8f)
                lineTo(87.94f, 77.18f)
                curveTo(89.33f, 78.57f, 89.46f, 80.74f, 88.32f, 82.27f)
                lineTo(87.94f, 82.71f)
                lineTo(75.61f, 95.05f)
                curveTo(74.96f, 96.13f, 73.66f, 96.88f, 72.16f, 96.88f)
                curveTo(70.66f, 96.88f, 69.35f, 96.14f, 68.7f, 95.05f)
                lineTo(56.37f, 82.71f)
                curveTo(54.84f, 81.18f, 54.84f, 78.71f, 56.37f, 77.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(20.05f, 8.29f)
                curveTo(13.58f, 8.29f, 8.33f, 13.54f, 8.33f, 20.01f)
                verticalLineTo(79.91f)
                curveTo(8.33f, 86.38f, 13.58f, 91.63f, 20.05f, 91.63f)
                horizontalLineTo(40.89f)
                curveTo(43.04f, 91.63f, 44.79f, 89.88f, 44.79f, 87.72f)
                curveTo(44.79f, 85.56f, 43.04f, 83.81f, 40.89f, 83.81f)
                horizontalLineTo(20.05f)
                curveTo(17.89f, 83.81f, 16.15f, 82.06f, 16.15f, 79.91f)
                verticalLineTo(20.01f)
                curveTo(16.15f, 17.85f, 17.89f, 16.11f, 20.05f, 16.11f)
                horizontalLineTo(40.89f)
                curveTo(43.04f, 16.11f, 44.79f, 14.36f, 44.79f, 12.2f)
                curveTo(44.79f, 10.04f, 43.04f, 8.29f, 40.89f, 8.29f)
                horizontalLineTo(20.05f)
                close()
            }
        }.build()

        return _Height!!
    }

@Suppress("ObjectPropertyName")
private var _Height: ImageVector? = null
