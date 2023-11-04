package icons

import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _planet1: ImageVector? = null

public val Planet1: ImageVector
    get() {
        if (_planet1 != null) {
            return _planet1!!
        }
        _planet1 = ImageVector.Builder(
            name = "vector",
            defaultWidth = 442.dp,
            defaultHeight = 290.dp,
            viewportWidth = 442f,
            viewportHeight = 290f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFE69037)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(364f, 130.5f)
                arcTo(127f, 119.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 237f, 250f)
                arcTo(127f, 119.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 110f, 130.5f)
                arcTo(127f, 119.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 364f, 130.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFECAE40)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(163.166f, 92.1631f)
                curveTo(147.557f, 76.1667f, 162.237f, 43.6027f, 171.528f, 29.3202f)
                curveTo(171.064f, 27.4159f, 179.054f, 21.6077f, 214.732f, 13.6095f)
                curveTo(250.409f, 5.6113f, 285.343f, 17.8942f, 298.351f, 25.0354f)
                curveTo(301.138f, 28.368f, 301.417f, 36.1758f, 280.233f, 40.7462f)
                curveTo(259.05f, 45.3166f, 262.116f, 58.8373f, 266.297f, 65.0264f)
                curveTo(268.62f, 68.835f, 267.133f, 83.5936f, 242.605f, 112.159f)
                curveTo(218.077f, 140.724f, 233.314f, 138.343f, 243.998f, 133.582f)
                curveTo(248.644f, 132.154f, 262.395f, 121.014f, 280.233f, 87.8784f)
                curveTo(298.072f, 54.743f, 321.114f, 65.5025f, 330.405f, 75.0241f)
                curveTo(342.483f, 85.4979f, 366.082f, 111.302f, 363.852f, 130.726f)
                curveTo(361.065f, 155.006f, 358.277f, 187.856f, 319.255f, 222.134f)
                curveTo(288.038f, 249.556f, 242.14f, 251.651f, 223.094f, 249.27f)
                curveTo(241.676f, 234.988f, 269.363f, 209.565f, 231.456f, 222.134f)
                curveTo(193.548f, 234.702f, 179.426f, 225.466f, 177.103f, 219.277f)
                curveTo(172.457f, 204.043f, 175.152f, 176.715f, 223.094f, 189.284f)
                curveTo(271.036f, 201.853f, 287.666f, 197.377f, 289.989f, 193.569f)
                curveTo(297.886f, 184.523f, 312.287f, 158.434f, 306.713f, 126.441f)
                curveTo(301.138f, 94.4483f, 295.099f, 114.063f, 292.776f, 127.869f)
                lineTo(287.201f, 155.006f)
                curveTo(284.879f, 169.765f, 270.199f, 194.997f, 230.062f, 177.858f)
                curveTo(189.925f, 160.719f, 146.443f, 178.334f, 129.719f, 189.284f)
                curveTo(126.932f, 185.951f, 119.963f, 173.002f, 114.389f, 147.865f)
                curveTo(108.814f, 122.728f, 121.357f, 87.8784f, 128.325f, 73.5959f)
                curveTo(149.509f, 80.4515f, 148.301f, 95.4957f, 145.049f, 102.161f)
                curveTo(131.577f, 120.252f, 111.044f, 151.293f, 136.687f, 130.726f)
                curveTo(162.33f, 110.159f, 174.316f, 114.539f, 177.103f, 119.3f)
                curveTo(180.819f, 125.965f, 192.433f, 137.01f, 209.157f, 127.869f)
                curveTo(225.881f, 118.729f, 233.778f, 100.257f, 235.636f, 92.1631f)
                curveTo(237.03f, 77.8806f, 238.145f, 55.8856f, 231.455f, 82.1654f)
                curveTo(224.766f, 108.445f, 202.653f, 113.111f, 192.433f, 112.159f)
                curveTo(189.181f, 112.159f, 178.775f, 108.159f, 163.166f, 92.1631f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFEEBB59)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(212.3505f, 76.0125f)
                arcTo(16.0445f, 21.3927f, 0f, isMoreThanHalf = false, isPositiveArc = true, 196.306f, 97.40520000000001f)
                arcTo(16.0445f, 21.3927f, 0f, isMoreThanHalf = false, isPositiveArc = true, 180.2615f, 76.0125f)
                arcTo(16.0445f, 21.3927f, 0f, isMoreThanHalf = false, isPositiveArc = true, 212.3505f, 76.0125f)
                close()
            }
            path(
                fill = SolidColor(Color(0x26FFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(123.19f, 141.799f)
                curveTo(108.956f, 138.007f, 80.487f, 125.017f, 80.487f, 103.4f)
                curveTo(80.487f, 82.4808f, 107.145f, 79.4075f, 121.767f, 80.5193f)
                lineTo(128.884f, 65f)
                curveTo(94.2468f, 66.4222f, 24.4031f, 75.5243f, 22.1256f, 100.555f)
                curveTo(19.2787f, 131.844f, 64.829f, 158.866f, 143.119f, 184.465f)
                curveTo(205.75f, 204.945f, 277.397f, 206.273f, 305.392f, 204.376f)
                curveTo(347.621f, 202.954f, 432.648f, 192.999f, 434.925f, 164.555f)
                curveTo(437.203f, 136.11f, 386.528f, 110.037f, 360.906f, 100.555f)
                lineTo(363.753f, 114.777f)
                curveTo(389.944f, 134.119f, 389.85f, 145.592f, 386.528f, 148.91f)
                curveTo(387.952f, 156.021f, 373.148f, 171.097f, 302.545f, 174.51f)
                curveTo(231.942f, 177.923f, 153.557f, 154.125f, 123.19f, 141.799f)
                close()
            }
            path(
                fill = SolidColor(Color(0x40FFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(119.217f, 110.363f)
                curveTo(107.274f, 101.357f, 85.4451f, 78.3196f, 93.673f, 58.2193f)
                curveTo(101.635f, 38.7688f, 127.874f, 46.1733f, 141.202f, 52.8358f)
                lineTo(153.802f, 41.1456f)
                curveTo(120.687f, 29.1342f, 51.5404f, 10.7109f, 39.8715f, 33.1082f)
                curveTo(25.2854f, 61.1048f, 57.8369f, 103.765f, 121.718f, 157.706f)
                curveTo(172.823f, 200.858f, 239.696f, 229.673f, 266.744f, 238.687f)
                curveTo(306.999f, 253.621f, 390.749f, 277.095f, 403.717f, 251.524f)
                curveTo(416.685f, 225.954f, 378.954f, 182.202f, 358.467f, 163.523f)
                lineTo(355.731f, 177.843f)
                curveTo(373f, 205.91f, 368.544f, 216.541f, 364.158f, 218.348f)
                curveTo(362.79f, 225.507f, 343.13f, 233.826f, 275.435f, 209.821f)
                curveTo(207.739f, 185.816f, 143.083f, 133.513f, 119.217f, 110.363f)
                close()
            }
        }.build()
        return _planet1!!
    }

