package atomic.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var innerSave: ImageVector? = null
val Save: ImageVector
    get() {
        if (innerSave != null) {
            return innerSave!!
        }
        innerSave = ImageVector.Builder(
            name = "Save", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(19.0f, 21.0f)
                horizontalLineTo(5.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, isMoreThanHalf = false, isPositiveArc = true, dx1 = -2.0f, dy1 = -2.0f)
                verticalLineTo(5.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, isMoreThanHalf = false, isPositiveArc = true, dx1 = 2.0f, dy1 = -2.0f)
                horizontalLineToRelative(11.0f)
                lineToRelative(5.0f, 5.0f)
                verticalLineToRelative(11.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, false, isPositiveArc = true, dx1 = -2.0f, dy1 = 2.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(17.0f, 21.0f)
                lineToRelative(0.0f, -8.0f)
                lineToRelative(-10.0f, 0.0f)
                lineToRelative(0.0f, 8.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = PathFillType.NonZero
            ) {
                moveTo(7.0f, 3.0f)
                lineToRelative(0.0f, 5.0f)
                lineToRelative(8.0f, 0.0f)
            }
        }
            .build()
        return innerSave!!
    }
