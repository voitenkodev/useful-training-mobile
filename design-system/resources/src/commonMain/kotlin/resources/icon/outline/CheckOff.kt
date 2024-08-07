package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val CheckOff: ImageVector
    get() {
        if (_Checkoff != null) {
            return _Checkoff!!
        }
        _Checkoff = ImageVector.Builder(
            name = "Checkoff",
            defaultWidth = 106.dp,
            defaultHeight = 107.dp,
            viewportWidth = 106f,
            viewportHeight = 107f
        ).apply {
            path(
                stroke = SolidColor(Color(0x4DFCFBFA)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(53f, 94.79f)
                curveTo(77.74f, 94.79f, 97.79f, 74.74f, 97.79f, 50f)
                curveTo(97.79f, 25.26f, 77.74f, 5.21f, 53f, 5.21f)
                curveTo(28.26f, 5.21f, 8.21f, 25.26f, 8.21f, 50f)
                curveTo(8.21f, 74.74f, 28.26f, 94.79f, 53f, 94.79f)
                close()
            }
        }.build()

        return _Checkoff!!
    }

@Suppress("ObjectPropertyName")
private var _Checkoff: ImageVector? = null
