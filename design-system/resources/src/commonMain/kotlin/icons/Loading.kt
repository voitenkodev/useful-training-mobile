import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _vector: ImageVector? = null

public val Loading: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(5f, 18f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, -2f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5f, 18f)
                    close()
                    moveToRelative(0f, -2f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(8.22f, 10.22f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.41f, -0.58f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -2.83f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.83f, 0f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 2.83f)
                    horizontalLineToRelative(0f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.22f, 10.22f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(18f, 5f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 7f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 5f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 5f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(23.78f, 10.22f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.42f, -0.58f)
                    horizontalLineToRelative(0f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2.83f, -2.83f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 2.83f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 23.78f, 10.22f)
                    close()
                    moveToRelative(0f, -2f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(27f, 18f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, -2f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 27f, 18f)
                    close()
                    moveToRelative(0f, -2f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(23.78f, 25.78f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.42f, -0.59f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -2.83f)
                    horizontalLineToRelative(0f)
                    arcToRelative(2.06f, 2.06f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.83f, 0f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.41f, 3.42f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(18f, 27f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 29f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 27f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 27f)
                    close()
                }
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(8.22f, 25.78f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.41f, -3.42f)
                    arcToRelative(2.06f, 2.06f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.83f, 0f)
                    horizontalLineToRelative(0f)
                    arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 2.83f)
                    arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.22f, 25.78f)
                    close()
                    moveToRelative(0f, -2f)
                    close()
                }
            }
        }.build()
        return _vector!!
    }

