package atomic.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var innerEye: ImageVector? = null
val Eye: ImageVector
    get() {
        if (innerEye != null) {
            return innerEye!!
        }
        innerEye = ImageVector.Builder(
            name = "Eye", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp, viewportWidth
            = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(1.0f, 12.0f)
                reflectiveCurveToRelative(4.0f, -8.0f, 11.0f, -8.0f)
                reflectiveCurveToRelative(11.0f, 8.0f, 11.0f, 8.0f)
                reflectiveCurveToRelative(-4.0f, 8.0f, -11.0f, 8.0f)
                reflectiveCurveToRelative(-11.0f, -8.0f, -11.0f, -8.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(12.0f, 12.0f)
                moveToRelative(-3.0f, 0.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, isMoreThanHalf = true, isPositiveArc = true, dx1 = 6.0f, dy1 = 0.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, isMoreThanHalf = true, isPositiveArc = true, dx1 = -6.0f, dy1 = 0.0f)
            }
        }
            .build()
        return innerEye!!
    }
