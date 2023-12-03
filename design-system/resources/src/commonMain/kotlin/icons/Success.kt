package icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _SuccessFilledSvgrepoCom: ImageVector? = null

internal val Success: ImageVector
    get() {
        if (_SuccessFilledSvgrepoCom != null) {
            return _SuccessFilledSvgrepoCom!!
        }
        _SuccessFilledSvgrepoCom = ImageVector.Builder(
            name = "SuccessFilledSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(512f, 64f)
                arcToRelative(448f, 448f, 0f, isMoreThanHalf = true, isPositiveArc = true, 0f, 896f)
                arcToRelative(448f, 448f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -896f)
                close()
                moveToRelative(-55.808f, 536.384f)
                lineToRelative(-99.52f, -99.584f)
                arcToRelative(38.4f, 38.4f, 0f, isMoreThanHalf = true, isPositiveArc = false, -54.336f, 54.336f)
                lineToRelative(126.72f, 126.72f)
                arcToRelative(38.272f, 38.272f, 0f, isMoreThanHalf = false, isPositiveArc = false, 54.336f, 0f)
                lineToRelative(262.4f, -262.464f)
                arcToRelative(38.4f, 38.4f, 0f, isMoreThanHalf = true, isPositiveArc = false, -54.272f, -54.336f)
                lineTo(456.192f, 600.384f)
                close()
            }
        }.build()
        return _SuccessFilledSvgrepoCom!!
    }


