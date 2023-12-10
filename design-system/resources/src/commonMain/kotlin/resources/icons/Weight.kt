package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

internal val Weight: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 177.dp,
            defaultHeight = 207.dp,
            viewportWidth = 177f,
            viewportHeight = 207f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF5F6A78)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(70.5f, 3f)
                curveTo(34.5f, 12.6f, 31.8333f, 46.3333f, 35f, 62f)
                curveTo(42.5f, 68.8333f, 57f, 77.9f, 55f, 59.5f)
                curveTo(53f, 41.1f, 58.5f, 31.1667f, 61.5f, 28.5f)
                curveTo(60.8333f, 26.5f, 65.9f, 22.2f, 91.5f, 21f)
                curveTo(117.1f, 19.8f, 121.833f, 38.1667f, 121f, 47.5f)
                curveTo(125.333f, 68.6667f, 135.6f, 101.2f, 142f, 62f)
                curveTo(148.4f, 22.8f, 121.333f, 6.3333f, 107f, 3f)
                horizontalLineTo(70.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5F6A78)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(1.16465f, 147.5f)
                curveTo(-5.6353f, 113.1f, 20.3333f, 78.8333f, 33.5f, 64.5f)
                curveTo(39.8333f, 57.1667f, 59.1f, 42f, 85.5f, 40f)
                curveTo(111.9f, 38f, 135.61f, 53.5f, 144.165f, 61.5f)
                curveTo(164.965f, 88.7f, 172.831f, 107.833f, 174.165f, 114f)
                curveTo(179.665f, 131.167f, 180.865f, 170.8f, 141.665f, 192f)
                curveTo(102.465f, 213.2f, 61.9979f, 205.833f, 46.6645f, 199.5f)
                curveTo(34.3312f, 196.5f, 7.9646f, 181.9f, 1.1646f, 147.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF475572)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(71.6646f, 18f)
                curveTo(54.8646f, 18.8f, 49.9979f, 38f, 49.6646f, 47.5f)
                lineTo(54.6646f, 46.5909f)
                curveTo(53.8646f, 43.8637f, 56.6646f, 36.0606f, 58.1646f, 32.5f)
                curveTo(63.3646f, 24.5f, 71.3312f, 22.5f, 74.6646f, 22.5f)
                curveTo(75.4646f, 21.7f, 87.6646f, 21.5f, 93.6646f, 21.5f)
                curveTo(98.1646f, 21.1667f, 108.665f, 22.1f, 114.665f, 28.5f)
                curveTo(120.665f, 34.9f, 122.165f, 43.5f, 122.165f, 47f)
                lineTo(127.665f, 49f)
                verticalLineTo(46f)
                curveTo(126.065f, 26.4f, 112.998f, 19.1667f, 106.665f, 18f)
                curveTo(101.998f, 17.6667f, 88.4646f, 17.2f, 71.6646f, 18f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF485674)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(34.1646f, 163f)
                curveTo(58.9646f, 191f, 103.165f, 199.333f, 122.165f, 200f)
                curveTo(88.9646f, 207.6f, 57.6646f, 201.5f, 46.1646f, 197.5f)
                curveTo(33.4979f, 193.833f, 7.0646f, 178f, 2.6646f, 144f)
                curveTo(-1.7354f, 110f, 21.1646f, 76.5f, 33.1646f, 64f)
                lineTo(35.1646f, 58.5f)
                curveTo(29.9646f, 24.5f, 49.9979f, 8.6667f, 60.6646f, 5f)
                curveTo(53.1646f, 15.6667f, 38.8646f, 39f, 41.6646f, 47f)
                curveTo(44.4646f, 55f, 42.1646f, 60.3333f, 40.6646f, 62f)
                lineTo(26.6646f, 83f)
                curveTo(18.8312f, 98f, 9.3646f, 135f, 34.1646f, 163f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF14296C)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(71.6645f, 23f)
                curveTo(56.8645f, 25.8f, 54.4978f, 40.8333f, 55.1645f, 48f)
                curveTo(83.1645f, 32.8f, 111.165f, 41.6667f, 121.665f, 48f)
                curveTo(121.265f, 30.8f, 110.498f, 24.1667f, 105.165f, 23f)
                curveTo(100.165f, 21.8333f, 86.4645f, 20.2f, 71.6645f, 23f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF475572)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(112.165f, 67f)
                horizontalLineTo(67.1645f)
                curveTo(59.1645f, 65f, 67.4979f, 60.5f, 72.6645f, 58.5f)
                curveTo(80.6645f, 57.1667f, 98.9645f, 55.5f, 108.165f, 59.5f)
                curveTo(117.365f, 63.5f, 114.665f, 66.1667f, 112.165f, 67f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF7F8893)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(145.665f, 104f)
                curveTo(134.865f, 87.6f, 133.165f, 95.5f, 133.665f, 101.5f)
                curveTo(135.998f, 110f, 141.265f, 130.2f, 143.665f, 143f)
                curveTo(146.065f, 155.8f, 150.998f, 147.667f, 153.165f, 142f)
                curveTo(155.165f, 136.167f, 156.465f, 120.4f, 145.665f, 104f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFAFB4BC)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(167.165f, 134.5f)
                curveTo(172.765f, 159.3f, 146.498f, 184.5f, 132.665f, 194f)
                curveTo(165.865f, 174.8f, 173.498f, 157f, 173.165f, 150.5f)
                curveTo(174.831f, 145.167f, 176.865f, 130.1f, 171.665f, 112.5f)
                curveTo(166.465f, 94.9f, 150.165f, 71.5f, 142.665f, 62f)
                curveTo(145.865f, 48.4f, 141.331f, 31f, 138.665f, 24f)
                curveTo(122.265f, 2f, 105.165f, 0.5f, 98.6646f, 2.5f)
                curveTo(125.165f, 5.5f, 139.165f, 40f, 135.165f, 51.5f)
                curveTo(131.965f, 60.7f, 135.165f, 67.3333f, 137.165f, 69.5f)
                lineTo(149.665f, 86f)
                curveTo(153.165f, 91.8333f, 161.565f, 109.7f, 167.165f, 134.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF14296C)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 5f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(34.0058f, 63.1912f)
                lineTo(34.7663f, 62.3633f)
                lineTo(34.6516f, 61.2449f)
                curveTo(32.3123f, 38.4365f, 38.4156f, 24.0676f, 46.6284f, 15.2823f)
                curveTo(54.8872f, 6.4478f, 65.5329f, 2.9855f, 72.7468f, 2.5f)
                horizontalLineTo(107.785f)
                curveTo(124.98f, 7.8988f, 134.129f, 18.672f, 138.684f, 29.9489f)
                curveTo(143.315f, 41.4139f, 143.219f, 53.4811f, 141.713f, 61.0097f)
                lineTo(141.491f, 62.1196f)
                lineTo(142.179f, 63.0186f)
                curveTo(162.879f, 90.0883f, 170.499f, 108.878f, 171.721f, 114.528f)
                lineTo(171.747f, 114.647f)
                lineTo(171.784f, 114.763f)
                curveTo(177.09f, 131.325f, 178.186f, 169.406f, 140.475f, 189.801f)
                curveTo(102.093f, 210.559f, 62.4407f, 203.311f, 47.6189f, 197.189f)
                lineTo(47.4417f, 197.116f)
                lineTo(47.2554f, 197.071f)
                curveTo(35.6282f, 194.243f, 10.1847f, 180.239f, 3.6172f, 147.015f)
                curveTo(0.3581f, 130.528f, 4.6112f, 113.169f, 11.4558f, 98.0034f)
                curveTo(18.2906f, 82.8596f, 27.5859f, 70.18f, 34.0058f, 63.1912f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF485674)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(53.2886f, 146.347f)
                lineTo(51.7551f, 106.376f)
                lineTo(60.2059f, 106.052f)
                lineTo(60.8821f, 123.676f)
                lineTo(61.409f, 123.656f)
                lineTo(75.1168f, 105.48f)
                lineTo(85.2461f, 105.091f)
                lineTo(71.0999f, 123.557f)
                lineTo(86.9552f, 145.055f)
                lineTo(76.8455f, 145.443f)
                lineTo(65.266f, 129.43f)
                lineTo(61.3036f, 134.664f)
                lineTo(61.7394f, 146.023f)
                lineTo(53.2886f, 146.347f)
                close()
                moveTo(114.393f, 116.912f)
                curveTo(114.083f, 115.973f, 113.667f, 115.148f, 113.144f, 114.439f)
                curveTo(112.622f, 113.716f, 111.993f, 113.115f, 111.258f, 112.635f)
                curveTo(110.535f, 112.141f, 109.713f, 111.775f, 108.792f, 111.537f)
                curveTo(107.884f, 111.298f, 106.883f, 111.2f, 105.79f, 111.242f)
                curveTo(103.747f, 111.32f, 101.971f, 111.897f, 100.462f, 112.971f)
                curveTo(98.9653f, 114.045f, 97.8249f, 115.567f, 97.0406f, 117.539f)
                curveTo(96.2557f, 119.498f, 95.9167f, 121.869f, 96.0235f, 124.653f)
                curveTo(96.1303f, 127.438f, 96.644f, 129.79f, 97.5647f, 131.709f)
                curveTo(98.4853f, 133.628f, 99.7395f, 135.072f, 101.327f, 136.041f)
                curveTo(102.915f, 136.996f, 104.762f, 137.433f, 106.87f, 137.352f)
                curveTo(108.783f, 137.279f, 110.402f, 136.878f, 111.73f, 136.15f)
                curveTo(113.069f, 135.408f, 114.073f, 134.398f, 114.741f, 133.122f)
                curveTo(115.422f, 131.845f, 115.729f, 130.354f, 115.664f, 128.65f)
                lineTo(117.391f, 128.837f)
                lineTo(107.086f, 129.233f)
                lineTo(106.842f, 122.87f)
                lineTo(123.568f, 122.229f)
                lineTo(123.761f, 127.264f)
                curveTo(123.896f, 130.777f, 123.27f, 133.824f, 121.884f, 136.405f)
                curveTo(120.497f, 138.973f, 118.528f, 140.99f, 115.978f, 142.456f)
                curveTo(113.428f, 143.909f, 110.475f, 144.7f, 107.118f, 144.829f)
                curveTo(103.37f, 144.973f, 100.047f, 144.273f, 97.147f, 142.729f)
                curveTo(94.2466f, 141.173f, 91.9441f, 138.896f, 90.2394f, 135.899f)
                curveTo(88.5473f, 132.889f, 87.6203f, 129.276f, 87.4586f, 125.06f)
                curveTo(87.3343f, 121.82f, 87.6919f, 118.914f, 88.5313f, 116.341f)
                curveTo(89.3833f, 113.754f, 90.6276f, 111.543f, 92.2642f, 109.708f)
                curveTo(93.9008f, 107.874f, 95.8333f, 106.451f, 98.0619f, 105.44f)
                curveTo(100.29f, 104.429f, 102.725f, 103.873f, 105.367f, 103.772f)
                curveTo(107.631f, 103.685f, 109.751f, 103.936f, 111.728f, 104.525f)
                curveTo(113.705f, 105.101f, 115.471f, 105.958f, 117.026f, 107.097f)
                curveTo(118.594f, 108.236f, 119.892f, 109.613f, 120.918f, 111.228f)
                curveTo(121.943f, 112.831f, 122.631f, 114.616f, 122.98f, 116.583f)
                lineTo(114.393f, 116.912f)
                close()
            }
        }.build()
        return _vector!!
    }

