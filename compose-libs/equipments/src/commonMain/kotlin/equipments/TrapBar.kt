package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _TrapBar: ImageVector? = null

public val TrapBar: ImageVector
    get() {
        if (_TrapBar != null) {
            return _TrapBar!!
        }
        _TrapBar = ImageVector.Builder(
            name = "TrapBar",
            defaultWidth = 299.dp,
            defaultHeight = 204.dp,
            viewportWidth = 299f,
            viewportHeight = 204f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFAAAAAA)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7F7F)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(11.604f, 21.1781f)
                lineTo(19.42f, 26.5751f)
                lineTo(15.3103f, 33.7348f)
                lineTo(7.14485f, 28.1418f)
                curveTo(6.375f, 23.2249f, 9.7968f, 21.4506f, 11.604f, 21.1781f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(52.6237f, 30.321f)
                curveTo(55.9804f, -11.4855f, 24.3219f, 4.7838f, 13.1406f, 20.4015f)
                curveTo(4.6876f, 30.4158f, 4.5799f, 45.2187f, 4.5865f, 51.1563f)
                curveTo(5.6234f, 84.7932f, 29.7181f, 69.845f, 40.7251f, 58.219f)
                curveTo(49.9553f, 48.5304f, 52.1422f, 35.5392f, 52.6237f, 30.321f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(58.0439f, 33.2408f)
                curveTo(61.663f, -10.7098f, 29.8793f, 6.5825f, 18.5924f, 23.0629f)
                curveTo(10.0707f, 33.6383f, 9.871f, 49.1937f, 9.8407f, 55.4328f)
                curveTo(10.6693f, 90.7716f, 34.8752f, 74.9144f, 45.9629f, 62.6296f)
                curveTo(55.2603f, 52.3916f, 57.5296f, 38.727f, 58.0439f, 33.2408f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(65.4174f, 35.9359f)
                curveTo(69.2236f, -9.617f, 37.1974f, 8.421f, 25.7851f, 25.54f)
                curveTo(17.1758f, 36.53f, 16.9158f, 52.6484f, 16.8616f, 59.1131f)
                curveTo(17.5606f, 95.726f, 41.9615f, 79.2038f, 53.1575f, 66.4328f)
                curveTo(62.5456f, 55.7894f, 64.8794f, 41.6223f, 65.4174f, 35.9359f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(73.6816f, 39.2243f)
                curveTo(77.5402f, -6.684f, 45.6422f, 11.5424f, 34.259f, 28.8105f)
                curveTo(25.6746f, 39.8983f, 25.3908f, 56.1407f, 25.3267f, 62.6551f)
                curveTo(25.9652f, 99.5478f, 50.2727f, 82.8607f, 61.434f, 69.9743f)
                curveTo(70.7928f, 59.2347f, 73.1373f, 44.9552f, 73.6816f, 39.2243f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(66.2481f, 40.6025f)
                curveTo(65.8125f, 45.0853f, 63.2362f, 56.1669f, 56.4164f, 64.6312f)
                curveTo(48.2825f, 74.787f, 31.9704f, 87.8921f, 31.7929f, 59.0662f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(32.2127f, 55.6963f)
                curveTo(32.6727f, 50.972f, 35.379f, 39.2921f, 42.5247f, 30.3664f)
                curveTo(51.0473f, 19.6572f, 68.1326f, 5.8328f, 68.293f, 36.2091f)
            }
            path(
                fill = SolidColor(Color(0xFFAAAAAA)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(54.5421f, 40.0002f)
                curveTo(45.1437f, 41.0974f, 45.3699f, 49.9292f, 46.6231f, 53.7387f)
                lineTo(53.1324f, 56.0002f)
                lineTo(62.0609f, 45.0288f)
                lineTo(63.0007f, 44.1145f)
                lineTo(54.5421f, 40.0002f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(46.6231f, 53.7387f)
                curveTo(45.3699f, 49.9292f, 45.1437f, 41.0974f, 54.5421f, 40.0002f)
                lineTo(63.0007f, 44.1145f)
                lineTo(62.0609f, 45.0288f)
                lineTo(53.1324f, 56.0002f)
                lineTo(46.5535f, 53.7145f)
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
                moveTo(38.0008f, 113.501f)
                lineTo(46.5008f, 54.5006f)
                lineTo(53.5007f, 57.0006f)
                curveTo(51.5007f, 54.0002f, 50.9007f, 46.5006f, 56.5007f, 44.5006f)
                curveTo(62.1007f, 42.5006f, 66.0007f, 46.8336f, 66.5007f, 49.0002f)
                curveTo(66.8341f, 50.1669f, 67.001f, 54.8006f, 63.0007f, 58.0002f)
                curveTo(60.5007f, 59.9999f, 55.6674f, 59.3339f, 53.5007f, 57.0006f)
                lineTo(45.0007f, 109.001f)
                curveTo(43.8007f, 113.001f, 45.5007f, 116.334f, 46.5008f, 117.501f)
                curveTo(67.5008f, 131.834f, 110.401f, 161.001f, 114.001f, 163.001f)
                curveTo(117.601f, 165.001f, 121.501f, 165.501f, 123.001f, 165.501f)
                lineTo(235.501f, 157.501f)
                lineTo(256.001f, 148.001f)
                lineTo(241.001f, 165.501f)
                lineTo(126.001f, 173.001f)
                curveTo(119.201f, 173.801f, 112.167f, 171.667f, 109.501f, 170.501f)
                curveTo(88.5007f, 155.834f, 45.5008f, 125.801f, 41.5008f, 123.001f)
                curveTo(37.5008f, 120.201f, 37.5008f, 115.501f, 38.0008f, 113.501f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(53.5007f, 57.0006f)
                lineTo(45.0007f, 109.001f)
                curveTo(43.8007f, 113.001f, 45.5007f, 116.334f, 46.5008f, 117.501f)
                curveTo(67.5008f, 131.834f, 110.401f, 161.001f, 114.001f, 163.001f)
                curveTo(117.601f, 165.001f, 121.501f, 165.501f, 123.001f, 165.501f)
                lineTo(235.501f, 157.501f)
                lineTo(256.001f, 148.001f)
                lineTo(241.001f, 165.501f)
                lineTo(126.001f, 173.001f)
                curveTo(119.201f, 173.801f, 112.167f, 171.667f, 109.501f, 170.501f)
                curveTo(88.5007f, 155.834f, 45.5008f, 125.801f, 41.5008f, 123.001f)
                curveTo(37.5008f, 120.201f, 37.5008f, 115.501f, 38.0008f, 113.501f)
                lineTo(46.5008f, 54.5006f)
                lineTo(53.5007f, 57.0006f)
                close()
                moveTo(53.5007f, 57.0006f)
                curveTo(55.6674f, 59.3339f, 60.5007f, 59.9999f, 63.0007f, 58.0002f)
                curveTo(67.001f, 54.8006f, 66.8341f, 50.1669f, 66.5007f, 49.0002f)
                curveTo(66.0007f, 46.8336f, 62.1007f, 42.5006f, 56.5007f, 44.5006f)
                curveTo(50.9007f, 46.5006f, 51.5007f, 54.0002f, 53.5007f, 57.0006f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(152.001f, 48.0002f)
                lineTo(67.5007f, 50.0002f)
                lineTo(64.0007f, 44.5002f)
                curveTo(92.5007f, 43.6669f, 147.201f, 42.0002f, 152.001f, 42.0002f)
                curveTo(156.801f, 42.0002f, 161.001f, 43.6669f, 162.501f, 44.5002f)
                curveTo(181.501f, 53.5002f, 220.601f, 71.9002f, 225.001f, 73.5002f)
                curveTo(229.401f, 75.1002f, 231.834f, 79.8336f, 232.501f, 82.0002f)
                lineTo(256.001f, 148f)
                lineTo(245.001f, 140f)
                curveTo(239.167f, 123f, 227.301f, 88.3002f, 226.501f, 85.5002f)
                curveTo(225.701f, 82.7002f, 223.834f, 81.0002f, 223.001f, 80.5002f)
                curveTo(202.001f, 70.3336f, 159.301f, 49.8002f, 156.501f, 49.0002f)
                curveTo(153.701f, 48.2002f, 152.334f, 48.0002f, 152.001f, 48.0002f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(110.501f, 49.0002f)
                lineTo(48.5007f, 87.0002f)
                lineTo(50.5007f, 77.0002f)
                lineTo(98.0007f, 49.5002f)
                lineTo(110.501f, 49.0002f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(189.501f, 160.5f)
                lineTo(174.501f, 161.5f)
                lineTo(234.001f, 108f)
                lineTo(236.501f, 115.5f)
                lineTo(189.501f, 160.5f)
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
                moveTo(184.501f, 165f)
                lineTo(193.501f, 156f)
                lineTo(180.001f, 157f)
                lineTo(173.501f, 163f)
                lineTo(184.501f, 162.5f)
                verticalLineTo(165f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(177.001f, 149f)
                verticalLineTo(164.501f)
                curveTo(180.601f, 167.7f, 183.834f, 165.167f, 185.001f, 163.501f)
                curveTo(185.167f, 161.834f, 185.401f, 156.901f, 185.001f, 150.501f)
                curveTo(184.601f, 144.101f, 187.501f, 140.501f, 189.001f, 139.501f)
                lineTo(234.501f, 97.5007f)
                verticalLineTo(108.501f)
                horizontalLineTo(240.501f)
                lineTo(242.001f, 92.5005f)
                curveTo(240.401f, 86.1005f, 235.001f, 87.5005f, 232.501f, 89.0005f)
                lineTo(184.001f, 133f)
                curveTo(178.801f, 137.401f, 177.167f, 145.5f, 177.001f, 149f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(230.001f, 101f)
                curveTo(229.774f, 96.7277f, 227.655f, 96.2631f, 225.501f, 95.5002f)
                lineTo(189.001f, 128.5f)
                curveTo(192.742f, 129.007f, 193.641f, 132.125f, 194.311f, 134.447f)
                lineTo(194.333f, 134.523f)
                lineTo(230.001f, 101f)
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
                moveTo(179.135f, 163.968f)
                lineTo(176.847f, 166.628f)
                lineTo(183.256f, 166.926f)
                lineTo(188.359f, 160f)
                lineTo(179.135f, 163.968f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF9F9D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(41.1253f, 67.9043f)
                lineTo(44.1253f, 81.9043f)
                curveTo(48.1253f, 83.5044f, 49.4586f, 80.5709f, 49.6252f, 78.9041f)
                lineTo(47.6252f, 67.9043f)
                curveTo(46.8252f, 63.5044f, 49.6252f, 61.7375f, 51.1252f, 61.4041f)
                lineTo(100.125f, 33.4041f)
                curveTo(102.925f, 31.4041f, 103.959f, 32.5707f, 104.125f, 33.4041f)
                lineTo(105.125f, 45.4041f)
                curveTo(107.525f, 48.6041f, 109.792f, 46.0707f, 110.625f, 44.4041f)
                lineTo(109.625f, 31.9043f)
                curveTo(108.025f, 24.7043f, 101.625f, 25.5709f, 98.6252f, 26.9043f)
                lineTo(44.1253f, 58.4043f)
                curveTo(40.9253f, 60.4043f, 40.792f, 65.5709f, 41.1253f, 67.9043f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(97.9937f, 34.2665f)
                curveTo(98.668f, 30.0414f, 97.5079f, 29.6699f, 95.5618f, 28.4724f)
                lineTo(53.5007f, 53.0002f)
                curveTo(57.0918f, 54.2945f, 56.3318f, 55.5816f, 56.5007f, 58.0002f)
                lineTo(97.9937f, 34.2665f)
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
                moveTo(44.0007f, 75.5002f)
                lineTo(43.0007f, 82.5002f)
                verticalLineTo(89.5002f)
                lineTo(50.0007f, 85.5002f)
                lineTo(54.0007f, 75.5002f)
                lineTo(49.0007f, 78.5002f)
                lineTo(48.5007f, 75.5002f)
                horizontalLineTo(44.0007f)
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
                moveTo(111.501f, 48.0002f)
                lineTo(114.501f, 43.5002f)
                horizontalLineTo(107.001f)
                lineTo(103.501f, 45.0002f)
                lineTo(101.001f, 48.0002f)
                lineTo(96.5007f, 51.0002f)
                lineTo(99.0007f, 55.5002f)
                lineTo(111.501f, 48.0002f)
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
                moveTo(236.501f, 106.5f)
                lineTo(232.501f, 110f)
                lineTo(233.501f, 117.5f)
                lineTo(240.001f, 112f)
                lineTo(243.001f, 113f)
                lineTo(240.001f, 104.5f)
                lineTo(236.501f, 106.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(276.389f, 140.569f)
                curveTo(283.255f, 91.2749f, 244.444f, 114.265f, 237.77f, 123.213f)
                curveTo(229.506f, 130.921f, 218.166f, 156.507f, 220.252f, 177.599f)
                curveTo(223.506f, 210.512f, 245.387f, 196.704f, 259.895f, 177.599f)
                curveTo(271.052f, 162.907f, 276.285f, 147.992f, 276.389f, 140.569f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(283.347f, 145.853f)
                curveTo(289.907f, 98.6132f, 252.827f, 120.646f, 246.451f, 129.22f)
                curveTo(238.555f, 136.607f, 227.721f, 161.127f, 229.713f, 181.341f)
                curveTo(232.823f, 212.883f, 253.728f, 199.649f, 267.589f, 181.341f)
                curveTo(278.248f, 167.261f, 283.248f, 152.967f, 283.347f, 145.853f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(289.233f, 150.263f)
                curveTo(295.312f, 105.899f, 260.951f, 126.59f, 255.042f, 134.643f)
                curveTo(247.726f, 141.58f, 237.686f, 164.607f, 239.533f, 183.59f)
                curveTo(242.414f, 213.212f, 261.786f, 200.784f, 274.631f, 183.59f)
                curveTo(284.508f, 170.367f, 289.141f, 156.944f, 289.233f, 150.263f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(294.385f, 155.385f)
                curveTo(300.027f, 114.512f, 268.138f, 133.575f, 262.654f, 140.994f)
                curveTo(255.864f, 147.385f, 246.547f, 168.6f, 248.26f, 186.089f)
                curveTo(250.934f, 213.38f, 268.913f, 201.93f, 280.833f, 186.089f)
                curveTo(290f, 173.907f, 294.3f, 161.54f, 294.385f, 155.385f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF262C31)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(287.85f, 159.147f)
                curveTo(291.533f, 130.321f, 270.716f, 143.766f, 267.137f, 148.998f)
                curveTo(262.704f, 153.505f, 256.622f, 168.468f, 257.741f, 180.802f)
                curveTo(259.486f, 200.049f, 271.222f, 191.974f, 279.004f, 180.802f)
                curveTo(284.988f, 172.21f, 287.795f, 163.488f, 287.85f, 159.147f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFAAAAAA)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7F7F)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(277.956f, 175.396f)
                horizontalLineTo(280.506f)
                lineTo(285.243f, 166.106f)
                lineTo(284.696f, 163.92f)
                lineTo(277.956f, 159.913f)
                curveTo(271.252f, 161.516f, 271.277f, 168.717f, 272.127f, 172.117f)
                lineTo(277.956f, 175.396f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFFA09D9D)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(277.774f, 175.032f)
                curveTo(276.195f, 171.51f, 275.296f, 164.394f, 284.332f, 164.103f)
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7F7F)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(296.691f, 172.664f)
                lineTo(285.215f, 166.288f)
                curveTo(279.532f, 167.308f, 279.689f, 172.543f, 280.479f, 175.032f)
                lineTo(292.319f, 180.861f)
                curveTo(291.882f, 175.178f, 295.052f, 173.028f, 296.691f, 172.664f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD9D9D9)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFFA0A0A0)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(293.282f, 176.553f)
                lineTo(293.374f, 176.439f)
                lineTo(293.429f, 176.303f)
                curveTo(293.676f, 175.69f, 294.17f, 175.035f, 294.777f, 174.519f)
                curveTo(295.397f, 173.992f, 296.015f, 173.708f, 296.461f, 173.669f)
                curveTo(296.667f, 173.65f, 296.804f, 173.686f, 296.899f, 173.739f)
                curveTo(296.99f, 173.789f, 297.115f, 173.895f, 297.233f, 174.145f)
                curveTo(297.49f, 174.689f, 297.652f, 175.791f, 297.342f, 177.779f)
                curveTo(297.291f, 178.111f, 297.065f, 178.979f, 296.271f, 179.985f)
                curveTo(296.168f, 180.115f, 295.893f, 180.364f, 295.495f, 180.59f)
                curveTo(295.103f, 180.812f, 294.686f, 180.958f, 294.321f, 180.98f)
                curveTo(293.983f, 181.001f, 293.714f, 180.918f, 293.486f, 180.697f)
                curveTo(293.242f, 180.461f, 292.945f, 179.97f, 292.778f, 178.979f)
                curveTo(292.805f, 178.617f, 292.864f, 178.091f, 292.962f, 177.591f)
                curveTo(293.016f, 177.316f, 293.078f, 177.067f, 293.145f, 176.867f)
                curveTo(293.179f, 176.768f, 293.21f, 176.69f, 293.238f, 176.632f)
                curveTo(293.264f, 176.579f, 293.28f, 176.557f, 293.282f, 176.554f)
                curveTo(293.282f, 176.553f, 293.282f, 176.553f, 293.282f, 176.553f)
                close()
            }
        }.build()
        return _TrapBar!!
    }

