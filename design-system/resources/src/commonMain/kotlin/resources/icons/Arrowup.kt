package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val ArrowUp: ImageVector
    get() {
        if (_Arrowup != null) {
            return _Arrowup!!
        }
        _Arrowup = ImageVector.Builder(
            name = "Arrowup",
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
                moveTo(52.47f, 27.34f)
                lineTo(52.48f, 27.35f)
                lineTo(52.49f, 27.36f)
                lineTo(89.38f, 67.85f)
                curveTo(90.88f, 69.37f, 90.87f, 71.83f, 89.37f, 73.36f)
                lineTo(89.37f, 73.36f)
                lineTo(89.37f, 73.36f)
                curveTo(87.86f, 74.88f, 85.38f, 74.88f, 83.87f, 73.36f)
                lineTo(83.86f, 73.35f)
                lineTo(83.86f, 73.34f)
                lineTo(49.55f, 35.69f)
                lineTo(15.22f, 73.34f)
                lineTo(15.21f, 73.35f)
                lineTo(15.2f, 73.36f)
                curveTo(13.69f, 74.88f, 11.25f, 74.88f, 9.71f, 73.36f)
                lineTo(9.71f, 73.36f)
                lineTo(9.7f, 73.36f)
                curveTo(8.2f, 71.83f, 8.2f, 69.37f, 9.7f, 67.85f)
                lineTo(46.59f, 27.36f)
                lineTo(46.59f, 27.35f)
                lineTo(46.6f, 27.34f)
                curveTo(47.42f, 26.53f, 48.49f, 26.19f, 49.55f, 26.23f)
                curveTo(50.58f, 26.19f, 51.66f, 26.53f, 52.47f, 27.34f)
                close()
            }
        }.build()

        return _Arrowup!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowup: ImageVector? = null
