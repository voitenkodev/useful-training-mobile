package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Youtube: ImageVector
    get() {
        if (_Youtube != null) {
            return _Youtube!!
        }
        _Youtube = ImageVector.Builder(
            name = "Youtube",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 5f
            ) {
                moveTo(41.41f, 62.31f)
                verticalLineTo(37.69f)
                curveTo(41.41f, 37.59f, 41.44f, 37.49f, 41.49f, 37.4f)
                curveTo(41.54f, 37.31f, 41.62f, 37.24f, 41.7f, 37.19f)
                curveTo(41.79f, 37.14f, 41.89f, 37.12f, 41.99f, 37.12f)
                curveTo(42.1f, 37.12f, 42.19f, 37.15f, 42.28f, 37.2f)
                lineTo(61.66f, 49.52f)
                curveTo(61.74f, 49.57f, 61.81f, 49.64f, 61.86f, 49.72f)
                curveTo(61.91f, 49.81f, 61.93f, 49.9f, 61.93f, 50f)
                curveTo(61.93f, 50.1f, 61.91f, 50.19f, 61.86f, 50.28f)
                curveTo(61.81f, 50.36f, 61.74f, 50.43f, 61.66f, 50.48f)
                lineTo(42.28f, 62.8f)
                curveTo(42.19f, 62.85f, 42.1f, 62.88f, 41.99f, 62.88f)
                curveTo(41.89f, 62.88f, 41.79f, 62.86f, 41.7f, 62.81f)
                curveTo(41.62f, 62.76f, 41.54f, 62.69f, 41.49f, 62.6f)
                curveTo(41.44f, 62.51f, 41.41f, 62.41f, 41.41f, 62.31f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 5f
            ) {
                moveTo(75.77f, 22.53f)
                horizontalLineTo(24.25f)
                curveTo(16.43f, 22.53f, 10.09f, 28.87f, 10.09f, 36.69f)
                verticalLineTo(63.31f)
                curveTo(10.09f, 71.13f, 16.43f, 77.47f, 24.25f, 77.47f)
                horizontalLineTo(75.77f)
                curveTo(83.58f, 77.47f, 89.92f, 71.13f, 89.92f, 63.31f)
                verticalLineTo(36.69f)
                curveTo(89.92f, 28.87f, 83.58f, 22.53f, 75.77f, 22.53f)
                close()
            }
        }.build()

        return _Youtube!!
    }

@Suppress("ObjectPropertyName")
private var _Youtube: ImageVector? = null
