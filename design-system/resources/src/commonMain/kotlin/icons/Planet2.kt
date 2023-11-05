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

public val Planet2: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 390.dp,
            defaultHeight = 243.dp,
            viewportWidth = 390f,
            viewportHeight = 243f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFE45568)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(317.093f, 120.866f)
                arcTo(120.866f, 120.866f, 0f, isMoreThanHalf = false, isPositiveArc = true, 196.227f, 241.732f)
                arcTo(120.866f, 120.866f, 0f, isMoreThanHalf = false, isPositiveArc = true, 75.361f, 120.866f)
                arcTo(120.866f, 120.866f, 0f, isMoreThanHalf = false, isPositiveArc = true, 317.093f, 120.866f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF535353)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(130.895f, 117.599f)
                curveTo(109.117f, 121.083f, 85.1615f, 131.391f, 76.4505f, 136.11f)
                curveTo(72.095f, 114.332f, 78.2661f, 90.74f, 81.8957f, 81.666f)
                curveTo(123.273f, 59.8884f, 199.494f, 70.7772f, 237.605f, 68.5994f)
                curveTo(268.094f, 66.8572f, 285.516f, 51.9033f, 289.872f, 44.6441f)
                curveTo(296.405f, 52.2662f, 308.6f, 70.3416f, 309.471f, 81.666f)
                curveTo(310.343f, 92.9903f, 306.205f, 100.903f, 304.027f, 103.444f)
                curveTo(304.39f, 104.895f, 296.622f, 110.195f, 262.649f, 119.777f)
                curveTo(228.676f, 129.359f, 196.228f, 123.769f, 184.25f, 119.777f)
                curveTo(175.539f, 117.599f, 152.673f, 114.115f, 130.895f, 117.599f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF535353)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(82.5517f, 162.243f)
                lineTo(82.5483f, 162.243f)
                lineTo(92.7839f, 185.11f)
                curveTo(113.11f, 188.013f, 156.375f, 190.336f, 158.117f, 176.398f)
                curveTo(159.859f, 162.461f, 150.858f, 161.154f, 146.139f, 162.243f)
                curveTo(141.784f, 164.058f, 129.153f, 167.252f, 113.473f, 165.51f)
                curveTo(97.7975f, 163.768f, 86.185f, 162.607f, 82.5517f, 162.243f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF535353)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(278.739f, 145.836f)
                curveTo(290.993f, 148.158f, 307.067f, 146.25f, 313.573f, 145.006f)
                curveTo(310.38f, 157.281f, 306.109f, 166.967f, 304.373f, 170.276f)
                curveTo(276.407f, 169.854f, 224.534f, 165.644f, 240.768f, 152.187f)
                curveTo(261.062f, 135.365f, 263.421f, 142.933f, 278.739f, 145.836f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF535353)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF535353)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(223.45f, 39.1997f)
                curveTo(248.712f, 37.4575f, 258.439f, 25.4072f, 260.254f, 19.5998f)
                lineTo(265.916f, 22.8665f)
                lineTo(270.925f, 27.222f)
                curveTo(269.473f, 29.0368f, 263.085f, 34.1908f, 251.76f, 44.6441f)
                curveTo(240.436f, 55.0973f, 217.279f, 56.9847f, 207.117f, 56.6217f)
                curveTo(198.405f, 56.2588f, 182.072f, 53.7906f, 186.428f, 46.8218f)
                curveTo(191.872f, 38.1108f, 199.494f, 39.1997f, 201.672f, 39.1997f)
                horizontalLineTo(223.45f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF535353)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF535353)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(171.183f, 23.9554f)
                curveTo(156.375f, 18.7288f, 140.332f, 18.148f, 134.161f, 18.511f)
                curveTo(176.845f, -7.6222f, 223.45f, 1.8148f, 240.872f, 9.7999f)
                curveTo(234.774f, 15.0266f, 227.079f, 18.511f, 224.538f, 19.5999f)
                curveTo(212.924f, 23.2295f, 185.992f, 29.182f, 171.183f, 23.9554f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFE98777)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(118f, 33f)
                curveTo(102.4f, 46.2f, 105.833f, 59.1667f, 109.5f, 64f)
                curveTo(113.9f, 68f, 121f, 68.3333f, 124f, 68f)
                curveTo(131.167f, 67.3333f, 148f, 62f, 158f, 46f)
                curveTo(168f, 30f, 159.833f, 23f, 154.5f, 21.5f)
                curveTo(148.833f, 19.8333f, 133.6f, 19.8f, 118f, 33f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFC32B67)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(311.649f, 86.0215f)
                curveTo(279.418f, 169.647f, 153.035f, 187.287f, 92.7839f, 181.843f)
                curveTo(142.437f, 255.887f, 211.472f, 245.724f, 239.783f, 234.109f)
                curveTo(323.409f, 198.394f, 321.812f, 119.777f, 311.649f, 86.0215f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFE45568)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(263.738f, 81.666f)
                curveTo(248.058f, 91.2481f, 228.894f, 88.5622f, 221.272f, 86.0215f)
                curveTo(213.65f, 86.0215f, 199.276f, 88.417f, 202.761f, 97.9991f)
                curveTo(207.116f, 109.977f, 226.716f, 108.888f, 235.427f, 108.888f)
                curveTo(244.138f, 108.888f, 261.56f, 104.532f, 275.716f, 97.9991f)
                curveTo(287.04f, 92.7725f, 287.693f, 84.9326f, 286.605f, 81.666f)
                curveTo(285.516f, 77.6734f, 279.418f, 72.0838f, 263.738f, 81.666f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF81FBE5)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFFFFFFFF)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(28.9029f, 115.765f)
                curveTo(35.3212f, 108.99f, 54.2653f, 91.8745f, 83.2154f, 77.2128f)
                lineTo(77.122f, 95.4931f)
                curveTo(68.3864f, 100.985f, 57.1922f, 110.74f, 50.7519f, 122.31f)
                curveTo(47.5102f, 128.134f, 45.4606f, 134.441f, 45.5575f, 140.909f)
                curveTo(45.6546f, 147.385f, 47.9043f, 153.986f, 53.1992f, 160.384f)
                curveTo(63.7656f, 173.152f, 82.0574f, 180.168f, 100.528f, 183.776f)
                curveTo(119.013f, 187.388f, 137.782f, 187.607f, 149.435f, 186.698f)
                curveTo(176.364f, 185.604f, 244.757f, 174.044f, 303.208f, 136.531f)
                curveTo(332.444f, 117.767f, 340.906f, 100.645f, 339.34f, 86.7549f)
                curveTo(337.78f, 72.9146f, 326.285f, 62.5683f, 316.245f, 57.2723f)
                curveTo(313.668f, 55.8006f, 306.632f, 52.2537f, 294.495f, 49.6348f)
                lineTo(281.17f, 34.2593f)
                curveTo(295.309f, 34.3607f, 316.601f, 36.4199f, 336.387f, 42.2923f)
                curveTo(356.72f, 48.327f, 375.322f, 58.3464f, 383.065f, 74.2626f)
                curveTo(390.834f, 90.2312f, 389.578f, 105.42f, 384.844f, 117.939f)
                curveTo(380.105f, 130.472f, 371.884f, 140.313f, 365.768f, 145.529f)
                lineTo(365.752f, 145.544f)
                lineTo(365.736f, 145.559f)
                curveTo(341.852f, 169.806f, 269.659f, 220.118f, 172.236f, 227.077f)
                curveTo(123.488f, 230.559f, 88.509f, 227.837f, 64.5987f, 223.03f)
                curveTo(52.6434f, 220.626f, 43.4613f, 217.702f, 36.7114f, 214.775f)
                curveTo(29.9514f, 211.844f, 25.6633f, 208.924f, 23.4624f, 206.547f)
                lineTo(23.4286f, 206.511f)
                lineTo(23.3882f, 206.482f)
                curveTo(16.9148f, 201.807f, 3.3108f, 187.902f, 0.724f, 169.795f)
                curveTo(-0.5564f, 160.832f, 3.8051f, 149.984f, 9.8844f, 139.99f)
                curveTo(15.9486f, 130.022f, 23.6531f, 121.015f, 28.8934f, 115.775f)
                lineTo(28.8936f, 115.775f)
                lineTo(28.9029f, 115.765f)
                close()
            }
        }.build()
        return _vector!!
    }

