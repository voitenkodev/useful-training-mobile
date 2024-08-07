package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Loading: ImageVector
    get() {
        if (_Loading != null) {
            return _Loading!!
        }
        _Loading = ImageVector.Builder(
            name = "Loading",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 8f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(50f, 8f)
                verticalLineTo(22f)
                moveTo(20.32f, 20.32f)
                lineTo(30.21f, 30.21f)
                moveTo(8f, 50f)
                horizontalLineTo(22f)
                moveTo(20.32f, 79.68f)
                lineTo(30.21f, 69.79f)
                moveTo(50f, 78f)
                verticalLineTo(92f)
                moveTo(79.68f, 79.68f)
                lineTo(69.79f, 69.79f)
                moveTo(92f, 50f)
                horizontalLineTo(78f)
                moveTo(79.68f, 20.32f)
                lineTo(69.79f, 30.21f)
            }
        }.build()

        return _Loading!!
    }

@Suppress("ObjectPropertyName")
private var _Loading: ImageVector? = null
