package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val ArrowRight: ImageVector
    get() {
        if (_ArrowRight != null) {
            return _ArrowRight!!
        }
        _ArrowRight = ImageVector.Builder(
            name = "ArrowRight",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f
            ) {
                moveTo(72.66f, 47.53f)
                lineTo(72.65f, 47.52f)
                lineTo(72.64f, 47.51f)
                lineTo(32.15f, 10.62f)
                curveTo(30.63f, 9.12f, 28.17f, 9.13f, 26.64f, 10.63f)
                lineTo(26.64f, 10.63f)
                lineTo(26.64f, 10.63f)
                curveTo(25.12f, 12.14f, 25.12f, 14.62f, 26.64f, 16.13f)
                lineTo(26.65f, 16.14f)
                lineTo(26.66f, 16.15f)
                lineTo(64.31f, 50.45f)
                lineTo(26.66f, 84.78f)
                lineTo(26.65f, 84.79f)
                lineTo(26.64f, 84.8f)
                curveTo(25.12f, 86.31f, 25.12f, 88.75f, 26.64f, 90.29f)
                lineTo(26.64f, 90.29f)
                lineTo(26.64f, 90.3f)
                curveTo(28.17f, 91.8f, 30.63f, 91.8f, 32.15f, 90.3f)
                lineTo(72.64f, 53.41f)
                lineTo(72.65f, 53.41f)
                lineTo(72.66f, 53.4f)
                curveTo(73.47f, 52.58f, 73.81f, 51.51f, 73.77f, 50.45f)
                curveTo(73.81f, 49.42f, 73.47f, 48.34f, 72.66f, 47.53f)
                close()
            }
        }.build()

        return _ArrowRight!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowRight: ImageVector? = null
