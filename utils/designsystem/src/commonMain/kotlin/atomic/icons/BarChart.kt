package atomic.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var innerBarChart: ImageVector? = null
val BarChart: ImageVector
    get() {
        if (innerBarChart != null) {
            return innerBarChart!!
        }
        innerBarChart = ImageVector.Builder(
            name = "BarChart", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(12.0f, 20.0f)
                lineTo(12.0f, 10.0f)
            }
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.0f, 20.0f)
                lineTo(18.0f, 4.0f)
            }
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(6.0f, 20.0f)
                lineTo(6.0f, 16.0f)
            }
        }
            .build()
        return innerBarChart!!
    }