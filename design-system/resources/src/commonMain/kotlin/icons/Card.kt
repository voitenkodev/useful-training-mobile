package icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

internal val Card: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF1C274C)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(14f, 4f)
                horizontalLineTo(10f)
                curveTo(6.2288f, 4f, 4.3431f, 4f, 3.1716f, 5.1716f)
                curveTo(2.328f, 6.0151f, 2.0918f, 7.2288f, 2.0257f, 9.25f)
                horizontalLineTo(21.9743f)
                curveTo(21.9082f, 7.2288f, 21.672f, 6.0151f, 20.8284f, 5.1716f)
                curveTo(19.6569f, 4f, 17.7712f, 4f, 14f, 4f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1C274C)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10f, 20f)
                horizontalLineTo(14f)
                curveTo(17.7712f, 20f, 19.6569f, 20f, 20.8284f, 18.8284f)
                curveTo(22f, 17.6569f, 22f, 15.7712f, 22f, 12f)
                curveTo(22f, 11.5581f, 22f, 11.142f, 21.9981f, 10.75f)
                horizontalLineTo(2.00189f)
                curveTo(2f, 11.142f, 2f, 11.5581f, 2f, 12f)
                curveTo(2f, 15.7712f, 2f, 17.6569f, 3.1716f, 18.8284f)
                curveTo(4.3431f, 20f, 6.2288f, 20f, 10f, 20f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(5.25f, 16f)
                curveTo(5.25f, 15.5858f, 5.5858f, 15.25f, 6f, 15.25f)
                horizontalLineTo(10f)
                curveTo(10.4142f, 15.25f, 10.75f, 15.5858f, 10.75f, 16f)
                curveTo(10.75f, 16.4142f, 10.4142f, 16.75f, 10f, 16.75f)
                horizontalLineTo(6f)
                curveTo(5.5858f, 16.75f, 5.25f, 16.4142f, 5.25f, 16f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(11.75f, 16f)
                curveTo(11.75f, 15.5858f, 12.0858f, 15.25f, 12.5f, 15.25f)
                horizontalLineTo(14f)
                curveTo(14.4142f, 15.25f, 14.75f, 15.5858f, 14.75f, 16f)
                curveTo(14.75f, 16.4142f, 14.4142f, 16.75f, 14f, 16.75f)
                horizontalLineTo(12.5f)
                curveTo(12.0858f, 16.75f, 11.75f, 16.4142f, 11.75f, 16f)
                close()
            }
        }.build()
        return _vector!!
    }

