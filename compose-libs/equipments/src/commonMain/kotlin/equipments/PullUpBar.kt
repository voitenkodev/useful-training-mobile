package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _PullUpBar: ImageVector? = null

public val PullUpBar: ImageVector
    get() {
        if (_PullUpBar != null) {
            return _PullUpBar!!
        }
        _PullUpBar = ImageVector.Builder(
            name = "PullUpBar",
            defaultWidth = 261.dp,
            defaultHeight = 274.dp,
            viewportWidth = 261f,
            viewportHeight = 274f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF262C31)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(259.78f, 26.642f)
                curveTo(262.242f, 22.1655f, 256.283f, 17.2692f, 252.926f, 19.6474f)
                lineTo(213.196f, 42.31f)
                curveTo(218.68f, 42.9815f, 218.652f, 48.6518f, 217.952f, 51.403f)
                lineTo(259.78f, 26.642f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1B1F23)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(259.78f, 26.6422f)
                curveTo(260.34f, 25.8027f, 260.76f, 23.5645f, 259.78f, 22.1655f)
                lineTo(217.952f, 46.0871f)
                curveTo(218.232f, 47.4861f, 218.512f, 48.6052f, 217.952f, 51.4032f)
                lineTo(259.78f, 26.6422f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(140.592f, 15.2483f)
                verticalLineTo(7.41431f)
                lineTo(15.1084f, 81.2775f)
                verticalLineTo(88.9716f)
                lineTo(140.592f, 15.2483f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(140.872f, 0f)
                lineTo(0.279785f, 80.1584f)
                lineTo(8.53344f, 85.1945f)
                lineTo(147.027f, 3.49731f)
                lineTo(140.872f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(146.887f, 3.49707f)
                lineTo(140.452f, 7.27417f)
                lineTo(140.172f, 192.911f)
                lineTo(146.887f, 188.575f)
                verticalLineTo(3.49707f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(140.452f, 15.2483f)
                lineTo(132.478f, 19.8647f)
                verticalLineTo(188.715f)
                lineTo(140.312f, 192.912f)
                lineTo(140.452f, 15.2483f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(14.9685f, 81.8372f)
                lineTo(8.67334f, 85.0547f)
                lineTo(7.27441f, 273.49f)
                lineTo(14.9685f, 269.993f)
                verticalLineTo(81.8372f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0.279785f, 80.1584f)
                lineTo(0f, 268.873f)
                lineTo(7.27441f, 273.49f)
                lineTo(8.67333f, 85.1946f)
                lineTo(0.279785f, 80.1584f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(98.5121f, 89.5937f)
                curveTo(96.05f, 85.1171f, 102.009f, 80.2209f, 105.367f, 82.5991f)
                lineTo(127.582f, 95.6865f)
                curveTo(122.098f, 96.358f, 122.406f, 101.329f, 123.105f, 104.08f)
                lineTo(98.5121f, 89.5937f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1B1F23)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(98.5122f, 89.5937f)
                curveTo(97.9526f, 88.7541f, 97.5329f, 86.5159f, 98.5121f, 85.1169f)
                lineTo(122.546f, 97.9246f)
                curveTo(122.266f, 99.3235f, 121.986f, 100.443f, 122.546f, 103.241f)
                lineTo(98.5122f, 89.5937f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(143.837f, 63.0141f)
                curveTo(141.375f, 58.5376f, 147.335f, 53.6413f, 150.692f, 56.0195f)
                lineTo(172.907f, 69.1069f)
                curveTo(167.423f, 69.7784f, 167.731f, 74.7493f, 168.43f, 77.5005f)
                lineTo(143.837f, 63.0141f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1B1F23)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(143.837f, 63.0143f)
                curveTo(143.278f, 62.1748f, 142.858f, 59.9365f, 143.837f, 58.5376f)
                lineTo(167.871f, 71.3453f)
                curveTo(167.591f, 72.7442f, 167.311f, 73.8633f, 167.871f, 76.6613f)
                lineTo(143.837f, 63.0143f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(218.372f, 44.4858f)
                lineTo(78.3397f, 127.442f)
                lineTo(70.7855f, 122.266f)
                lineTo(211.937f, 40.8486f)
                lineTo(218.372f, 44.4858f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(218.372f, 51.2007f)
                verticalLineTo(44.4858f)
                lineTo(78.3398f, 127.162f)
                verticalLineTo(133.178f)
                lineTo(218.372f, 51.2007f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(15.1084f, 81.2776f)
                lineTo(8.39355f, 85.0547f)
                lineTo(78.4797f, 127.302f)
                lineTo(85.894f, 122.266f)
                lineTo(15.1084f, 81.2776f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(78.3398f, 133.178f)
                lineTo(78.4797f, 127.302f)
                lineTo(0.279785f, 80.1584f)
                verticalLineTo(87.8525f)
                lineTo(78.3398f, 133.178f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(147.027f, 3.35742f)
                lineTo(140.872f, 6.99463f)
                lineTo(211.797f, 48.4028f)
                lineTo(218.372f, 44.4858f)
                lineTo(147.027f, 3.35742f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(140.452f, 15.2483f)
                lineTo(140.732f, 6.99463f)
                lineTo(205.362f, 44.6257f)
                lineTo(198.927f, 48.4028f)
                lineTo(140.452f, 15.2483f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(77.3604f, 132.618f)
                curveTo(79.8225f, 128.142f, 73.8631f, 123.245f, 70.5057f, 125.623f)
                lineTo(30.7762f, 148.286f)
                curveTo(36.26f, 148.958f, 36.2321f, 154.628f, 35.5326f, 157.379f)
                lineTo(77.3604f, 132.618f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF1B1F23)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(77.3604f, 132.618f)
                curveTo(77.92f, 131.779f, 78.3397f, 129.54f, 77.3605f, 128.141f)
                lineTo(35.5326f, 152.063f)
                curveTo(35.8124f, 153.462f, 36.0922f, 154.581f, 35.5326f, 157.379f)
                lineTo(77.3604f, 132.618f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF101317)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(29.6572f, 151.364f)
                curveTo(29.6572f, 150.105f, 29.6572f, 148.985f, 30.9163f, 148.286f)
                curveTo(31.4758f, 148.146f, 32.3152f, 148.286f, 33.7141f, 149.265f)
                curveTo(35.818f, 150.738f, 36.0923f, 154.861f, 35.6726f, 156.819f)
                curveTo(35.3369f, 158.386f, 33.481f, 157.659f, 32.595f, 157.099f)
                curveTo(31.4758f, 156.167f, 29.6572f, 153.724f, 29.6572f, 151.364f)
                close()
            }
        }.build()
        return _PullUpBar!!
    }

