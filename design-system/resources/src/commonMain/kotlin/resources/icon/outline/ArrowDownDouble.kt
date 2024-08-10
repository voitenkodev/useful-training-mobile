package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val ArrowDownDouble: ImageVector
    get() {
        if (_ArrowDownDouble != null) {
            return _ArrowDownDouble!!
        }
        _ArrowDownDouble = ImageVector.Builder(
            name = "ArrowDownDouble",
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
                moveTo(52.47f, 52.66f)
                lineTo(52.48f, 52.65f)
                lineTo(52.49f, 52.64f)
                lineTo(89.38f, 12.15f)
                curveTo(90.88f, 10.63f, 90.87f, 8.17f, 89.37f, 6.64f)
                lineTo(89.37f, 6.64f)
                lineTo(89.37f, 6.64f)
                curveTo(87.86f, 5.12f, 85.38f, 5.12f, 83.87f, 6.64f)
                lineTo(83.86f, 6.65f)
                lineTo(83.86f, 6.66f)
                lineTo(49.55f, 44.31f)
                lineTo(15.22f, 6.66f)
                lineTo(15.21f, 6.65f)
                lineTo(15.2f, 6.64f)
                curveTo(13.69f, 5.12f, 11.25f, 5.12f, 9.71f, 6.64f)
                lineTo(9.71f, 6.64f)
                lineTo(9.7f, 6.64f)
                curveTo(8.2f, 8.17f, 8.2f, 10.63f, 9.7f, 12.15f)
                lineTo(46.59f, 52.64f)
                lineTo(46.59f, 52.65f)
                lineTo(46.6f, 52.66f)
                curveTo(47.42f, 53.47f, 48.49f, 53.81f, 49.55f, 53.77f)
                curveTo(50.58f, 53.81f, 51.66f, 53.47f, 52.47f, 52.66f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f
            ) {
                moveTo(52.47f, 92.66f)
                lineTo(52.48f, 92.65f)
                lineTo(52.49f, 92.64f)
                lineTo(89.38f, 52.15f)
                curveTo(90.88f, 50.63f, 90.87f, 48.17f, 89.37f, 46.64f)
                lineTo(89.37f, 46.64f)
                lineTo(89.37f, 46.64f)
                curveTo(87.86f, 45.12f, 85.38f, 45.12f, 83.87f, 46.64f)
                lineTo(83.86f, 46.65f)
                lineTo(83.86f, 46.66f)
                lineTo(49.55f, 84.31f)
                lineTo(15.22f, 46.66f)
                lineTo(15.21f, 46.65f)
                lineTo(15.2f, 46.64f)
                curveTo(13.69f, 45.12f, 11.25f, 45.12f, 9.71f, 46.64f)
                lineTo(9.71f, 46.64f)
                lineTo(9.7f, 46.64f)
                curveTo(8.2f, 48.17f, 8.2f, 50.63f, 9.7f, 52.15f)
                lineTo(46.59f, 92.64f)
                lineTo(46.59f, 92.65f)
                lineTo(46.6f, 92.66f)
                curveTo(47.42f, 93.47f, 48.49f, 93.81f, 49.55f, 93.77f)
                curveTo(50.58f, 93.81f, 51.66f, 93.47f, 52.47f, 92.66f)
                close()
            }
        }.build()

        return _ArrowDownDouble!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowDownDouble: ImageVector? = null
