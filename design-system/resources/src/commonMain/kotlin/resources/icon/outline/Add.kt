package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Add: ImageVector
    get() {
        if (_Add != null) {
            return _Add!!
        }
        _Add = ImageVector.Builder(
            name = "Add",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 9f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(14.69f, 50f)
                horizontalLineTo(85.31f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 9f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(50f, 14.69f)
                verticalLineTo(85.31f)
            }
        }.build()

        return _Add!!
    }

@Suppress("ObjectPropertyName")
private var _Add: ImageVector? = null
