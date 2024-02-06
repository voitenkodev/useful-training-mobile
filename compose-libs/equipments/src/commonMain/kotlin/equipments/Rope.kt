package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _Rope: ImageVector? = null

public val Rope: ImageVector
    get() {
        if (_Rope != null) {
            return _Rope!!
        }
        _Rope = ImageVector.Builder(
            name = "Rope",
            defaultWidth = 126.dp,
            defaultHeight = 237.dp,
            viewportWidth = 126f,
            viewportHeight = 237f
        ).apply {
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
                moveTo(2.97534f, 201.955f)
                curveTo(8.6068f, 206.123f, 24.331f, 213.452f, 42.1762f, 209.415f)
                curveTo(38.3975f, 206.221f, 25.2672f, 200.258f, 2.9753f, 201.955f)
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
                moveTo(1.00068f, 220.093f)
                lineTo(2.75594f, 201.955f)
                curveTo(17.032f, 211.96f, 34.9358f, 211.097f, 42.1031f, 209.415f)
                curveTo(41.9812f, 210.926f, 41.518f, 215.573f, 40.6404f, 222.067f)
                curveTo(39.7627f, 228.562f, 35.8865f, 232.331f, 34.0581f, 233.403f)
                curveTo(31.8153f, 234.842f, 24.6821f, 237.133f, 14.092f, 234.793f)
                curveTo(3.5019f, 232.453f, 0.9519f, 224.017f, 1.0007f, 220.093f)
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
                moveTo(21.9907f, 74.9176f)
                curveTo(25.0331f, 47.126f, 41.2985f, 32.8157f, 49.0509f, 29.1345f)
                curveTo(53.2928f, 33.3033f, 59.2315f, 42.7671f, 49.0509f, 47.2722f)
                curveTo(38.8704f, 51.7774f, 35.4964f, 90.7393f, 35.082f, 109.657f)
                verticalLineTo(150.028f)
                curveTo(35.082f, 153.363f, 32.8879f, 189.838f, 31.7909f, 207.659f)
                curveTo(19.4455f, 211.93f, 15.3841f, 205.88f, 14.8965f, 202.32f)
                curveTo(19.0652f, 185.718f, 18.1876f, 109.657f, 21.9907f, 74.9176f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16.6519f, 193.91f)
                curveTo(21.5032f, 192.861f, 31.5277f, 190.209f, 32.8149f, 187.986f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(17.2368f, 183.524f)
                curveTo(22.0882f, 182.476f, 32.1127f, 179.824f, 33.3999f, 177.6f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(17.822f, 172.261f)
                curveTo(22.6734f, 171.213f, 32.6979f, 168.561f, 33.9851f, 166.337f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.407f, 162.754f)
                curveTo(23.2583f, 161.706f, 33.2828f, 159.053f, 34.57f, 156.83f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.8459f, 152.369f)
                curveTo(23.6973f, 151.32f, 33.7218f, 148.668f, 35.009f, 146.445f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.8459f, 141.106f)
                curveTo(23.6973f, 140.057f, 33.7218f, 137.405f, 35.009f, 135.182f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.6995f, 131.013f)
                curveTo(23.5508f, 129.964f, 33.5753f, 127.312f, 34.8625f, 125.089f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(19.4309f, 120.7f)
                curveTo(24.0408f, 119.691f, 33.5663f, 117.137f, 34.7894f, 114.996f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(19.7236f, 109.291f)
                curveTo(24.3774f, 108.334f, 33.9937f, 105.911f, 35.2284f, 103.879f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(20.6011f, 97.5896f)
                curveTo(25.1231f, 96.606f, 34.4672f, 94.1173f, 35.6671f, 92.0312f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(21.1863f, 87.4968f)
                curveTo(25.7962f, 86.4874f, 35.3217f, 83.9332f, 36.5448f, 81.7922f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(22.2102f, 76.3803f)
                curveTo(27.0835f, 75.3968f, 37.1534f, 72.9081f, 38.4464f, 70.822f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(23.6729f, 66.7262f)
                curveTo(28.8096f, 65.5874f, 39.4237f, 62.7058f, 40.7867f, 60.2903f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(26.8909f, 56.9261f)
                curveTo(32.2471f, 55.8907f, 43.3149f, 53.2711f, 44.736f, 51.0752f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(31.4253f, 46.5407f)
                curveTo(38.406f, 45.1689f, 52.8304f, 41.6979f, 54.6825f, 38.7883f)
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
                moveTo(123.356f, 201.955f)
                curveTo(117.725f, 206.123f, 102.001f, 213.452f, 84.1554f, 209.415f)
                curveTo(87.934f, 206.221f, 101.064f, 200.258f, 123.356f, 201.955f)
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
                moveTo(125.331f, 220.093f)
                lineTo(123.576f, 201.955f)
                curveTo(109.3f, 211.96f, 91.396f, 211.097f, 84.2287f, 209.415f)
                curveTo(84.3506f, 210.926f, 84.8138f, 215.573f, 85.6914f, 222.067f)
                curveTo(86.569f, 228.562f, 90.4452f, 232.331f, 92.2736f, 233.403f)
                curveTo(94.5165f, 234.842f, 101.65f, 237.133f, 112.24f, 234.793f)
                curveTo(122.83f, 232.453f, 125.38f, 224.017f, 125.331f, 220.093f)
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
                moveTo(104.341f, 74.9176f)
                curveTo(101.299f, 47.126f, 85.0332f, 32.8157f, 77.2808f, 29.1345f)
                curveTo(73.039f, 33.3033f, 67.1003f, 42.7671f, 77.2808f, 47.2722f)
                curveTo(87.4614f, 51.7774f, 90.8354f, 90.7393f, 91.2498f, 109.657f)
                verticalLineTo(150.028f)
                curveTo(91.2498f, 153.363f, 93.4439f, 189.838f, 94.5409f, 207.659f)
                curveTo(106.886f, 211.93f, 110.948f, 205.88f, 111.435f, 202.32f)
                curveTo(107.267f, 185.718f, 108.144f, 109.657f, 104.341f, 74.9176f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(109.68f, 193.91f)
                curveTo(104.829f, 192.861f, 94.8041f, 190.209f, 93.5169f, 187.986f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(109.095f, 183.524f)
                curveTo(104.244f, 182.476f, 94.2191f, 179.824f, 92.9319f, 177.6f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(108.51f, 172.261f)
                curveTo(103.658f, 171.213f, 93.6339f, 168.561f, 92.3467f, 166.337f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(107.925f, 162.754f)
                curveTo(103.073f, 161.706f, 93.049f, 159.053f, 91.7618f, 156.83f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(107.486f, 152.369f)
                curveTo(102.634f, 151.32f, 92.61f, 148.668f, 91.3228f, 146.445f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(107.486f, 141.106f)
                curveTo(102.634f, 140.057f, 92.61f, 137.405f, 91.3228f, 135.182f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(107.632f, 131.013f)
                curveTo(102.781f, 129.964f, 92.7562f, 127.312f, 91.469f, 125.089f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(106.901f, 120.7f)
                curveTo(102.291f, 119.691f, 92.7655f, 117.137f, 91.5423f, 114.996f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(106.608f, 109.291f)
                curveTo(101.954f, 108.334f, 92.3381f, 105.911f, 91.1033f, 103.879f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(105.731f, 97.5896f)
                curveTo(101.209f, 96.606f, 91.8645f, 94.1173f, 90.6647f, 92.0312f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(105.146f, 87.4968f)
                curveTo(100.536f, 86.4874f, 91.0101f, 83.9332f, 89.787f, 81.7922f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(104.122f, 76.3803f)
                curveTo(99.2483f, 75.3968f, 89.1784f, 72.9081f, 87.8854f, 70.822f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(102.659f, 66.7262f)
                curveTo(97.5222f, 65.5874f, 86.908f, 62.7058f, 85.5451f, 60.2903f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(99.4409f, 56.9261f)
                curveTo(94.0847f, 55.8907f, 83.0169f, 53.2711f, 81.5958f, 51.0752f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(94.9065f, 46.5407f)
                curveTo(87.9258f, 45.1689f, 73.5014f, 41.6979f, 71.6493f, 38.7883f)
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
                moveTo(75.2336f, 46.3947f)
                curveTo(67.2179f, 51.3094f, 55.3162f, 48.7351f, 50.3674f, 46.8335f)
                curveTo(60.3139f, 37.8378f, 48.9047f, 31.3287f, 48.6121f, 29.1346f)
                curveTo(48.3781f, 27.3794f, 54.1704f, 24.9903f, 57.0959f, 24.0151f)
                verticalLineTo(6.31623f)
                curveTo(57.1203f, 4.049f, 57.9004f, -0.383f, 60.8258f, 0.0265f)
                curveTo(63.7512f, 0.4361f, 65.1164f, 3.2201f, 65.4334f, 4.561f)
                lineTo(67.1886f, 24.7465f)
                curveTo(65.1408f, 24.9659f, 62.347f, 25.2731f, 67.5543f, 24.7465f)
                curveTo(72.7616f, 24.2199f, 76.1112f, 27.4525f, 77.1351f, 29.1346f)
                curveTo(69.3534f, 36.4482f, 72.6251f, 43.6887f, 75.2336f, 46.3947f)
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
                moveTo(60.8259f, 3.4639f)
                curveTo(61.8986f, 6.1699f, 63.4003f, 12.5913f, 60.8259f, 16.6284f)
                curveTo(57.608f, 21.6747f, 58.6319f, 0.6116f, 60.8259f, 3.4639f)
                close()
            }
        }.build()
        return _Rope!!
    }

