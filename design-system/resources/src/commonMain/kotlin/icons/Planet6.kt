import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

public val Planet6: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 102.dp,
            defaultHeight = 101.dp,
            viewportWidth = 102f,
            viewportHeight = 101f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF92D7D6)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(101f, 50.5f)
                arcTo(50.5f, 50.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 50.5f, 101f)
                arcTo(50.5f, 50.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 50.5f)
                arcTo(50.5f, 50.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 101f, 50.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF9DAB37)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(58.9999f, 86.5f)
                curveTo(54.1999f, 86.9f, 53.6666f, 80f, 53.9999f, 76.5f)
                curveTo(54.4998f, 70f, 51f, 68.5f, 50.5f, 67.5f)
                curveTo(50f, 66.5f, 50f, 64f, 53f, 61.5f)
                curveTo(55.4f, 59.5f, 58.6666f, 60.6667f, 60f, 61.5f)
                curveTo(61.8333f, 63.1667f, 64.9f, 67.2f, 62.5f, 70f)
                curveTo(60.1f, 72.8f, 62.5f, 77.1667f, 64f, 79f)
                curveTo(64.3333f, 81.3333f, 63.7999f, 86.1f, 58.9999f, 86.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF9DAB37)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(6.96281f, 42f)
                curveTo(6.1628f, 40f, 3.2961f, 37.8333f, 1.9628f, 37f)
                curveTo(-7.2372f, 71f, 18.1295f, 91.8333f, 31.9628f, 98f)
                curveTo(30.4628f, 97.1667f, 28.0628f, 93f, 30.4628f, 83f)
                curveTo(32.8628f, 73f, 29.4628f, 68.5f, 27.4628f, 67.5f)
                curveTo(25.4628f, 66.1667f, 21.5628f, 62.4f, 21.9628f, 58f)
                curveTo(22.3628f, 53.6f, 20.4628f, 51.5f, 19.4628f, 51f)
                curveTo(18.2961f, 50.5f, 15.6628f, 49.5f, 14.4628f, 49.5f)
                curveTo(13.2628f, 49.5f, 11.2961f, 47.8333f, 10.4628f, 47f)
                curveTo(9.6295f, 46.1667f, 7.7628f, 44f, 6.9628f, 42f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF9DAB37)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(82.2074f, 73.5f)
                curveTo(77.4074f, 79.1f, 81.5407f, 85.8333f, 84.2074f, 88.5f)
                curveTo(101.007f, 72.9f, 102.167f, 52.5f, 100.5f, 44.5f)
                curveTo(99.1667f, 46.6667f, 95.5074f, 51.8f, 92.7074f, 53f)
                curveTo(89.9074f, 54.2f, 88.5407f, 60.8333f, 88.2074f, 64f)
                curveTo(88.2074f, 64.8333f, 87.0074f, 67.9f, 82.2074f, 73.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF9DAB37)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(38.5f, 23.5855f)
                curveTo(42.1f, 11.5855f, 38.3333f, 4.5855f, 36f, 2.5855f)
                curveTo(51.2f, -3.4145f, 68f, 2.4189f, 74.5f, 6.0855f)
                curveTo(75.6667f, 11.0855f, 77.6f, 21.5855f, 76f, 23.5855f)
                curveTo(74.4f, 25.5855f, 74.3333f, 30.0855f, 74.5f, 32.0855f)
                curveTo(74.3333f, 33.5855f, 75.6f, 38.4855f, 82f, 46.0855f)
                curveTo(88.4f, 53.6855f, 81.3333f, 59.9189f, 77f, 62.0855f)
                curveTo(74f, 62.5855f, 68f, 61.7855f, 68f, 54.5855f)
                curveTo(68f, 47.3855f, 64f, 43.5855f, 62f, 42.5855f)
                curveTo(60.6667f, 41.4189f, 58.1f, 38.5855f, 58.5f, 36.5855f)
                curveTo(58.9f, 34.5855f, 57f, 32.7522f, 56f, 32.0855f)
                curveTo(54f, 30.5855f, 49.7f, 29.0855f, 48.5f, 35.0855f)
                curveTo(47.3f, 41.0855f, 43.3333f, 41.2522f, 41.5f, 40.5855f)
                curveTo(39f, 39.9189f, 34.9f, 35.5855f, 38.5f, 23.5855f)
                close()
            }
        }.build()
        return _vector!!
    }

