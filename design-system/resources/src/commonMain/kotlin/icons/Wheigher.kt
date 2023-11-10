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

public val Weigher: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF333333)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(40.2099f, 38.2219f)
                curveTo(40.0921f, 40.3416f, 38.339f, 42f, 36.2161f, 42f)
                lineTo(11.784f, 42f)
                curveTo(9.661f, 42f, 7.9079f, 40.3415f, 7.7901f, 38.2219f)
                lineTo(6.23456f, 10.2219f)
                curveTo(6.1072f, 7.9291f, 7.9321f, 6f, 10.2284f, 6f)
                lineTo(37.7716f, 6f)
                curveTo(40.068f, 6f, 41.8928f, 7.9291f, 41.7655f, 10.2219f)
                lineTo(40.2099f, 38.2219f)
                close()
                moveTo(34.2442f, 17.7786f)
                curveTo(35.064f, 17.2385f, 35.2702f, 16.1677f, 34.5974f, 15.471f)
                curveTo(33.4729f, 14.3066f, 32.139f, 13.3305f, 30.6524f, 12.5895f)
                curveTo(28.6303f, 11.5817f, 26.3828f, 11.0377f, 24.0939f, 11.0019f)
                curveTo(21.805f, 10.9661f, 19.5395f, 11.4396f, 17.4828f, 12.3837f)
                curveTo(15.9707f, 13.0778f, 14.603f, 14.0117f, 13.4379f, 15.1403f)
                curveTo(12.7407f, 15.8156f, 12.9089f, 16.8922f, 13.7092f, 17.4577f)
                lineTo(18.0211f, 20.5042f)
                curveTo(18.8214f, 21.0696f, 19.9487f, 20.8868f, 20.7779f, 20.3594f)
                curveTo(20.9902f, 20.2244f, 21.2129f, 20.1032f, 21.4445f, 19.9969f)
                curveTo(22.1757f, 19.6612f, 22.9766f, 19.4829f, 23.7891f, 19.4741f)
                lineTo(27.1821f, 15.5729f)
                curveTo(27.5445f, 15.1562f, 28.1761f, 15.1122f, 28.5929f, 15.4746f)
                curveTo(29.0096f, 15.837f, 29.0536f, 16.4687f, 28.6912f, 16.8854f)
                lineTo(26.0608f, 19.9098f)
                curveTo(26.1835f, 19.9605f, 26.3044f, 20.0155f, 26.4232f, 20.0747f)
                curveTo(26.6509f, 20.1882f, 26.8692f, 20.3163f, 27.0766f, 20.4579f)
                curveTo(27.8867f, 21.0108f, 29.0068f, 21.2288f, 29.8267f, 20.6887f)
                lineTo(34.2442f, 17.7786f)
                close()
            }
        }.build()
        return _vector!!
    }

