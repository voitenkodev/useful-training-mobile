package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Filter: ImageVector
    get() {
        if (_Filter != null) {
            return _Filter!!
        }
        _Filter = ImageVector.Builder(
            name = "Filter",
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
                moveTo(16.67f, 29.17f)
                horizontalLineTo(83.33f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(29.17f, 50f)
                horizontalLineTo(70.83f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 7f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(45.83f, 70.83f)
                horizontalLineTo(54.17f)
            }
        }.build()

        return _Filter!!
    }

@Suppress("ObjectPropertyName")
private var _Filter: ImageVector? = null
