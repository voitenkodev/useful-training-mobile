package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val EyeOn: ImageVector
    get() {
        if (_EyeOn != null) {
            return _EyeOn!!
        }
        _EyeOn = ImageVector.Builder(
            name = "EyeOn",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(4.17f, 50f)
                curveTo(4.17f, 50f, 20.83f, 16.67f, 50f, 16.67f)
                curveTo(79.17f, 16.67f, 95.83f, 50f, 95.83f, 50f)
                curveTo(95.83f, 50f, 79.17f, 83.33f, 50f, 83.33f)
                curveTo(20.83f, 83.33f, 4.17f, 50f, 4.17f, 50f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(50f, 62.5f)
                curveTo(56.9f, 62.5f, 62.5f, 56.9f, 62.5f, 50f)
                curveTo(62.5f, 43.1f, 56.9f, 37.5f, 50f, 37.5f)
                curveTo(43.1f, 37.5f, 37.5f, 43.1f, 37.5f, 50f)
                curveTo(37.5f, 56.9f, 43.1f, 62.5f, 50f, 62.5f)
                close()
            }
        }.build()

        return _EyeOn!!
    }

@Suppress("ObjectPropertyName")
private var _EyeOn: ImageVector? = null
