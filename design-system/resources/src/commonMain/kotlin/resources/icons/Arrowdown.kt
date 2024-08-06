package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val ArrowDown: ImageVector
    get() {
        if (_Arrowdown != null) {
            return _Arrowdown!!
        }
        _Arrowdown = ImageVector.Builder(
            name = "Arrowdown",
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
                moveTo(52.47f, 72.66f)
                lineTo(52.48f, 72.65f)
                lineTo(52.49f, 72.64f)
                lineTo(89.38f, 32.15f)
                curveTo(90.88f, 30.63f, 90.87f, 28.17f, 89.37f, 26.64f)
                lineTo(89.37f, 26.64f)
                lineTo(89.37f, 26.64f)
                curveTo(87.86f, 25.12f, 85.38f, 25.12f, 83.87f, 26.64f)
                lineTo(83.86f, 26.65f)
                lineTo(83.86f, 26.66f)
                lineTo(49.55f, 64.31f)
                lineTo(15.22f, 26.66f)
                lineTo(15.21f, 26.65f)
                lineTo(15.2f, 26.64f)
                curveTo(13.69f, 25.12f, 11.25f, 25.12f, 9.71f, 26.64f)
                lineTo(9.71f, 26.64f)
                lineTo(9.7f, 26.64f)
                curveTo(8.2f, 28.17f, 8.2f, 30.63f, 9.7f, 32.15f)
                lineTo(46.59f, 72.64f)
                lineTo(46.59f, 72.65f)
                lineTo(46.6f, 72.66f)
                curveTo(47.42f, 73.47f, 48.49f, 73.81f, 49.55f, 73.77f)
                curveTo(50.58f, 73.81f, 51.66f, 73.47f, 52.47f, 72.66f)
                close()
            }
        }.build()

        return _Arrowdown!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowdown: ImageVector? = null
