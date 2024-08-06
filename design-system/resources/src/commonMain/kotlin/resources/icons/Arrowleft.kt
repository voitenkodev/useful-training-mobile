package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val ArrowLeft: ImageVector
    get() {
        if (_Arrowleft != null) {
            return _Arrowleft!!
        }
        _Arrowleft = ImageVector.Builder(
            name = "Arrowleft",
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
                moveTo(27.34f, 47.53f)
                lineTo(27.35f, 47.52f)
                lineTo(27.36f, 47.51f)
                lineTo(67.85f, 10.62f)
                curveTo(69.37f, 9.12f, 71.83f, 9.13f, 73.36f, 10.63f)
                lineTo(73.36f, 10.63f)
                lineTo(73.36f, 10.63f)
                curveTo(74.88f, 12.14f, 74.88f, 14.62f, 73.36f, 16.13f)
                lineTo(73.35f, 16.14f)
                lineTo(73.34f, 16.15f)
                lineTo(35.69f, 50.45f)
                lineTo(73.34f, 84.78f)
                lineTo(73.35f, 84.79f)
                lineTo(73.36f, 84.8f)
                curveTo(74.88f, 86.31f, 74.88f, 88.75f, 73.36f, 90.29f)
                lineTo(73.36f, 90.29f)
                lineTo(73.36f, 90.3f)
                curveTo(71.83f, 91.8f, 69.37f, 91.8f, 67.85f, 90.3f)
                lineTo(27.36f, 53.41f)
                lineTo(27.35f, 53.41f)
                lineTo(27.34f, 53.4f)
                curveTo(26.53f, 52.58f, 26.19f, 51.51f, 26.23f, 50.45f)
                curveTo(26.19f, 49.42f, 26.53f, 48.34f, 27.34f, 47.53f)
                close()
            }
        }.build()

        return _Arrowleft!!
    }

@Suppress("ObjectPropertyName")
private var _Arrowleft: ImageVector? = null
