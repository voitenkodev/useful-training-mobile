package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _DipBar: ImageVector? = null

public val DipBar: ImageVector
    get() {
        if (_DipBar != null) {
            return _DipBar!!
        }
        _DipBar = ImageVector.Builder(
            name = "DipBar",
            defaultWidth = 285.dp,
            defaultHeight = 247.dp,
            viewportWidth = 285f,
            viewportHeight = 247f
        ).apply {
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
                moveTo(86.2459f, 166.925f)
                lineTo(2.0083f, 190.697f)
                curveTo(9.8636f, 188.63f, 8.3821f, 199.827f, 6.6595f, 205.684f)
                lineTo(87.7963f, 181.912f)
                curveTo(92.3441f, 176.124f, 88.6577f, 169.509f, 86.2459f, 166.925f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(2.00847f, 190.698f)
                curveTo(0.4581f, 195.349f, -0.0587f, 203.617f, 6.1429f, 205.684f)
                curveTo(8.21f, 200.517f, 10.2772f, 190.285f, 2.0085f, 190.698f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12.3441f, 188.114f)
                lineTo(2.0083f, 190.698f)
                curveTo(9.0367f, 189.044f, 8.2098f, 202.584f, 6.6595f, 205.685f)
                lineTo(13.8944f, 203.617f)
                curveTo(20.096f, 196.589f, 14.7558f, 189.836f, 12.3441f, 188.114f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(86.2459f, 167.442f)
                lineTo(76.9436f, 170.026f)
                curveTo(83.972f, 168.372f, 82.1116f, 181.912f, 81.0779f, 183.462f)
                lineTo(87.7963f, 181.395f)
                curveTo(92.4474f, 174.16f, 88.6576f, 169.164f, 86.2459f, 167.442f)
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
                moveTo(176.305f, 198.745f)
                lineTo(89.6913f, 230.339f)
                curveTo(97.7799f, 227.55f, 97.1043f, 239.428f, 95.7554f, 245.716f)
                lineTo(179.112f, 214.365f)
                curveTo(183.434f, 207.928f, 179.041f, 201.269f, 176.305f, 198.745f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(89.6914f, 230.34f)
                curveTo(88.4286f, 235.347f, 88.5359f, 244.073f, 95.2125f, 245.756f)
                curveTo(96.9775f, 240.165f, 98.3443f, 229.255f, 89.6914f, 230.34f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(100.345f, 226.812f)
                lineTo(89.6915f, 230.339f)
                curveTo(96.944f, 228.049f, 97.1402f, 242.337f, 95.7555f, 245.716f)
                lineTo(103.193f, 242.976f)
                curveTo(109.154f, 235.105f, 103.014f, 228.432f, 100.345f, 226.812f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(176.346f, 199.288f)
                lineTo(166.778f, 202.733f)
                curveTo(174.03f, 200.443f, 173.141f, 214.812f, 172.177f, 216.522f)
                lineTo(179.071f, 213.822f)
                curveTo(183.388f, 205.857f, 179.014f, 200.907f, 176.346f, 199.288f)
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
                moveTo(202.92f, 136.434f)
                lineTo(132.056f, 156.433f)
                curveTo(138.664f, 154.694f, 137.418f, 164.113f, 135.968f, 169.04f)
                lineTo(204.224f, 149.042f)
                curveTo(208.05f, 144.173f, 204.949f, 138.608f, 202.92f, 136.434f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(132.056f, 156.433f)
                curveTo(130.751f, 160.346f, 130.317f, 167.301f, 135.534f, 169.04f)
                curveTo(137.273f, 164.693f, 139.012f, 156.085f, 132.056f, 156.433f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(140.751f, 154.259f)
                lineTo(132.056f, 156.433f)
                curveTo(137.968f, 155.041f, 137.273f, 166.432f, 135.968f, 169.04f)
                lineTo(142.055f, 167.301f)
                curveTo(147.272f, 161.389f, 142.779f, 155.708f, 140.751f, 154.259f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(202.92f, 136.869f)
                lineTo(195.094f, 139.042f)
                curveTo(201.007f, 137.651f, 199.442f, 149.042f, 198.572f, 150.346f)
                lineTo(204.224f, 148.607f)
                curveTo(208.137f, 142.52f, 204.949f, 138.318f, 202.92f, 136.869f)
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
                moveTo(278.682f, 163.202f)
                lineTo(205.819f, 189.781f)
                curveTo(212.623f, 187.435f, 212.055f, 197.427f, 210.92f, 202.716f)
                lineTo(281.043f, 176.343f)
                curveTo(284.679f, 170.927f, 280.984f, 165.326f, 278.682f, 163.202f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFBEBEBE)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(205.819f, 189.781f)
                curveTo(204.756f, 193.994f, 204.847f, 201.334f, 210.463f, 202.751f)
                curveTo(211.948f, 198.047f, 213.098f, 188.869f, 205.819f, 189.781f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(214.781f, 186.814f)
                lineTo(205.819f, 189.781f)
                curveTo(211.92f, 187.855f, 212.085f, 199.874f, 210.92f, 202.716f)
                lineTo(217.176f, 200.411f)
                curveTo(222.191f, 193.79f, 217.026f, 188.177f, 214.781f, 186.814f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(278.716f, 163.659f)
                lineTo(270.667f, 166.557f)
                curveTo(276.768f, 164.631f, 276.02f, 176.719f, 275.209f, 178.157f)
                lineTo(281.009f, 175.886f)
                curveTo(284.64f, 169.185f, 280.961f, 165.021f, 278.716f, 163.659f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(40.2705f, 29.4083f)
                lineTo(40.2676f, 29.4378f)
                lineTo(40.2682f, 29.4674f)
                lineTo(43.3689f, 178.821f)
                lineTo(43.3752f, 179.123f)
                lineTo(43.6452f, 179.258f)
                curveTo(47.4113f, 181.141f, 49.9249f, 181.269f, 51.5354f, 180.459f)
                curveTo(53.1603f, 179.642f, 53.6712f, 177.973f, 53.6713f, 176.744f)
                lineTo(53.671f, 176.733f)
                lineTo(50.5711f, 29.4865f)
                curveTo(52.6258f, 14.781f, 59.8731f, 12.0769f, 62.9405f, 12.3837f)
                lineTo(62.9697f, 12.3866f)
                lineTo(62.999f, 12.3861f)
                curveTo(72.8176f, 12.2139f, 96.0634f, 11.9729f, 110.521f, 12.386f)
                curveTo(117.521f, 12.586f, 122.08f, 16.7802f, 124.955f, 22.0357f)
                curveTo(127.835f, 27.301f, 128.986f, 33.5735f, 129.157f, 37.7404f)
                curveTo(129.157f, 37.7424f, 129.157f, 37.7444f, 129.157f, 37.7464f)
                lineTo(132.258f, 215.512f)
                lineTo(132.26f, 215.626f)
                lineTo(132.31f, 215.727f)
                curveTo(133.951f, 219.009f, 136.612f, 220.084f, 139.041f, 219.679f)
                curveTo(141.418f, 219.283f, 143.529f, 217.469f, 144.097f, 215.103f)
                lineTo(144.111f, 215.041f)
                lineTo(144.11f, 214.977f)
                curveTo(143.249f, 168.638f, 141.423f, 65.0043f, 141.01f, 37.7184f)
                curveTo(140.801f, 23.971f, 136.588f, 15.0588f, 131.351f, 9.5144f)
                curveTo(126.124f, 3.9801f, 119.906f, 1.8341f, 115.735f, 1.5679f)
                lineTo(115.726f, 1.56734f)
                lineTo(115.717f, 1.56709f)
                curveTo(102.974f, 1.2227f, 74.0451f, 0.7394f, 60.376f, 1.5678f)
                curveTo(53.3094f, 1.9961f, 48.4916f, 6.8189f, 45.3555f, 12.5371f)
                curveTo(42.2183f, 18.2573f, 40.7058f, 24.9677f, 40.2705f, 29.4083f)
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
                moveTo(140.51f, 37.7263f)
                curveTo(140.199f, 17.2582f, 130.953f, 7.7235f, 122.933f, 4.0182f)
                curveTo(129.866f, 11.9409f, 129.385f, 31.0544f, 129.657f, 37.7263f)
                lineTo(132.758f, 215.504f)
                curveTo(135.858f, 221.705f, 142.577f, 219.294f, 143.61f, 214.987f)
                curveTo(142.749f, 168.648f, 140.923f, 65.0131f, 140.51f, 37.7263f)
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
                moveTo(43.8688f, 178.811f)
                lineTo(40.7681f, 29.4573f)
                curveTo(41.5808f, 21.1672f, 48.4983f, 13.6135f, 60.7389f, 12.0933f)
                curveTo(61.5852f, 11.8742f, 62.3551f, 11.823f, 62.9903f, 11.8865f)
                curveTo(62.2209f, 11.9331f, 61.4704f, 12.0024f, 60.7389f, 12.0933f)
                curveTo(56.9951f, 13.0626f, 51.7564f, 17.3175f, 50.0704f, 29.4573f)
                lineTo(53.1712f, 176.744f)
                curveTo(53.1712f, 178.983f, 51.3107f, 182.532f, 43.8688f, 178.811f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(40.2705f, 29.4083f)
                lineTo(40.2676f, 29.4378f)
                lineTo(40.2682f, 29.4674f)
                lineTo(43.3689f, 178.821f)
                lineTo(43.3752f, 179.123f)
                lineTo(43.6452f, 179.258f)
                curveTo(47.4113f, 181.141f, 49.9249f, 181.269f, 51.5354f, 180.459f)
                curveTo(53.1603f, 179.642f, 53.6712f, 177.973f, 53.6713f, 176.744f)
                lineTo(53.671f, 176.733f)
                lineTo(50.5711f, 29.4865f)
                curveTo(52.6258f, 14.781f, 59.8731f, 12.0769f, 62.9405f, 12.3837f)
                lineTo(62.9697f, 12.3866f)
                lineTo(62.999f, 12.3861f)
                curveTo(72.8176f, 12.2139f, 96.0634f, 11.9729f, 110.521f, 12.386f)
                curveTo(117.521f, 12.586f, 122.08f, 16.7802f, 124.955f, 22.0357f)
                curveTo(127.835f, 27.301f, 128.986f, 33.5735f, 129.157f, 37.7404f)
                curveTo(129.157f, 37.7424f, 129.157f, 37.7444f, 129.157f, 37.7464f)
                lineTo(132.258f, 215.512f)
                lineTo(132.26f, 215.626f)
                lineTo(132.31f, 215.727f)
                curveTo(133.951f, 219.009f, 136.612f, 220.084f, 139.041f, 219.679f)
                curveTo(141.418f, 219.283f, 143.529f, 217.469f, 144.097f, 215.103f)
                lineTo(144.111f, 215.041f)
                lineTo(144.11f, 214.977f)
                curveTo(143.249f, 168.638f, 141.423f, 65.0043f, 141.01f, 37.7184f)
                curveTo(140.801f, 23.971f, 136.588f, 15.0588f, 131.351f, 9.5144f)
                curveTo(126.124f, 3.9801f, 119.906f, 1.8341f, 115.735f, 1.5679f)
                lineTo(115.726f, 1.56734f)
                lineTo(115.717f, 1.56709f)
                curveTo(102.974f, 1.2227f, 74.0451f, 0.7394f, 60.376f, 1.5678f)
                curveTo(53.3094f, 1.9961f, 48.4916f, 6.8189f, 45.3555f, 12.5371f)
                curveTo(42.2183f, 18.2573f, 40.7058f, 24.9677f, 40.2705f, 29.4083f)
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
                moveTo(140.51f, 37.7263f)
                curveTo(140.199f, 17.2582f, 130.953f, 7.7235f, 122.933f, 4.0182f)
                curveTo(129.866f, 11.9409f, 129.385f, 31.0544f, 129.657f, 37.7263f)
                lineTo(132.758f, 215.504f)
                curveTo(135.858f, 221.705f, 142.577f, 219.294f, 143.61f, 214.987f)
                curveTo(142.749f, 168.648f, 140.923f, 65.0131f, 140.51f, 37.7263f)
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
                moveTo(43.8688f, 178.811f)
                lineTo(40.7681f, 29.4573f)
                curveTo(41.5808f, 21.1672f, 48.4983f, 13.6135f, 60.7389f, 12.0933f)
                curveTo(61.5852f, 11.8742f, 62.3551f, 11.823f, 62.9903f, 11.8865f)
                curveTo(62.2209f, 11.9331f, 61.4704f, 12.0024f, 60.7389f, 12.0933f)
                curveTo(56.9951f, 13.0626f, 51.7564f, 17.3175f, 50.0704f, 29.4573f)
                lineTo(53.1712f, 176.744f)
                curveTo(53.1712f, 178.983f, 51.3107f, 182.532f, 43.8688f, 178.811f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF101317)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(105.884f, 12.9199f)
                horizontalLineTo(72.8093f)
                curveTo(72.8093f, 12.9199f, 70.9506f, 9.1043f, 71f, 6.5f)
                curveTo(71.0463f, 4.0594f, 72.8093f, 0.5168f, 72.8093f, 0.5168f)
                horizontalLineTo(105.884f)
                curveTo(105.884f, 0.5168f, 104.048f, 4.0508f, 104f, 6.5f)
                curveTo(103.949f, 9.1124f, 105.884f, 12.9199f, 105.884f, 12.9199f)
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
                moveTo(103.3f, 12.9199f)
                horizontalLineTo(75.91f)
                curveTo(75.91f, 12.9199f, 73.5467f, 9.3761f, 73.5f, 7f)
                curveTo(73.449f, 4.4095f, 75.91f, 0.5168f, 75.91f, 0.5168f)
                horizontalLineTo(103.3f)
                curveTo(103.3f, 0.5168f, 101.546f, 4.0604f, 101.5f, 6.5f)
                curveTo(101.451f, 9.1034f, 103.3f, 12.9199f, 103.3f, 12.9199f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA0A0A0)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF7F7E7E)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(155.516f, 28.1644f)
                lineTo(155.513f, 28.1898f)
                lineTo(155.513f, 28.2153f)
                lineTo(156.03f, 150.906f)
                lineTo(156.032f, 151.214f)
                lineTo(156.307f, 151.351f)
                curveTo(159.979f, 153.187f, 162.434f, 153.315f, 164.01f, 152.522f)
                curveTo(165.6f, 151.722f, 166.099f, 150.09f, 166.099f, 148.889f)
                lineTo(166.099f, 148.887f)
                lineTo(165.582f, 28.2468f)
                curveTo(167.584f, 13.9117f, 174.646f, 11.2831f, 177.628f, 11.5813f)
                lineTo(177.657f, 11.5843f)
                lineTo(177.686f, 11.5837f)
                curveTo(187.258f, 11.4158f, 209.919f, 11.1809f, 224.014f, 11.5836f)
                curveTo(230.832f, 11.7784f, 235.272f, 15.8634f, 238.074f, 20.9844f)
                curveTo(240.881f, 26.1152f, 242.002f, 32.2282f, 242.169f, 36.289f)
                curveTo(242.169f, 36.2909f, 242.169f, 36.2928f, 242.169f, 36.2947f)
                lineTo(244.675f, 174.673f)
                lineTo(244.677f, 174.786f)
                lineTo(244.728f, 174.887f)
                curveTo(246.33f, 178.091f, 248.929f, 179.142f, 251.303f, 178.746f)
                curveTo(253.625f, 178.359f, 255.686f, 176.588f, 256.241f, 174.277f)
                lineTo(256.256f, 174.214f)
                lineTo(256.255f, 174.151f)
                curveTo(256.081f, 164.772f, 255.888f, 154.491f, 255.689f, 143.849f)
                curveTo(254.928f, 103.229f, 254.068f, 57.3446f, 253.749f, 36.2668f)
                curveTo(253.546f, 22.8621f, 249.438f, 14.1707f, 244.33f, 8.763f)
                curveTo(239.231f, 3.3653f, 233.166f, 1.272f, 229.098f, 1.0123f)
                lineTo(229.089f, 1.01168f)
                lineTo(229.079f, 1.01143f)
                curveTo(216.656f, 0.6757f, 188.454f, 0.2045f, 175.128f, 1.0122f)
                curveTo(168.233f, 1.4301f, 163.533f, 6.136f, 160.475f, 11.7123f)
                curveTo(157.415f, 17.2906f, 155.94f, 23.8342f, 155.516f, 28.1644f)
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
                moveTo(253.249f, 36.2745f)
                curveTo(252.946f, 16.3208f, 243.932f, 7.0256f, 236.114f, 3.4134f)
                curveTo(242.872f, 11.1371f, 242.403f, 29.7703f, 242.669f, 36.2745f)
                lineTo(244.902f, 174.677f)
                curveTo(247.925f, 180.723f, 254.475f, 178.371f, 255.482f, 174.173f)
                curveTo(254.643f, 128.998f, 253.652f, 62.8757f, 253.249f, 36.2745f)
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
                moveTo(156.764f, 150.852f)
                lineTo(156.013f, 28.2131f)
                curveTo(156.806f, 20.1313f, 163.549f, 12.7674f, 175.483f, 11.2854f)
                curveTo(176.308f, 11.0718f, 177.058f, 11.0219f, 177.677f, 11.0838f)
                curveTo(176.927f, 11.1293f, 176.196f, 11.1968f, 175.483f, 11.2854f)
                curveTo(171.833f, 12.2303f, 166.726f, 16.3784f, 165.082f, 28.2131f)
                lineTo(165.833f, 148.837f)
                curveTo(165.833f, 151.02f, 164.019f, 154.479f, 156.764f, 150.852f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF101317)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(219.494f, 12.0915f)
                horizontalLineTo(187.25f)
                curveTo(187.25f, 12.0915f, 185.49f, 8.475f, 185.5f, 6f)
                curveTo(185.51f, 3.5593f, 187.25f, 0f, 187.25f, 0f)
                horizontalLineTo(219.494f)
                curveTo(219.494f, 0f, 218.009f, 3.5854f, 218f, 6f)
                curveTo(217.991f, 8.4493f, 219.494f, 12.0915f, 219.494f, 12.0915f)
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
                moveTo(216.974f, 12.0915f)
                horizontalLineTo(190.272f)
                curveTo(190.272f, 12.0915f, 188.49f, 8.4775f, 188.5f, 6f)
                curveTo(188.51f, 3.5568f, 190.272f, 0f, 190.272f, 0f)
                horizontalLineTo(216.974f)
                curveTo(216.974f, 0f, 215.011f, 3.5333f, 215f, 6f)
                curveTo(214.989f, 8.5007f, 216.974f, 12.0915f, 216.974f, 12.0915f)
                close()
            }
        }.build()
        return _DipBar!!
    }

