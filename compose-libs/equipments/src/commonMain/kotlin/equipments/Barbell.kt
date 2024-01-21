package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _Barbell: ImageVector? = null

public val Barbell: ImageVector
    get() {
        if (_Barbell != null) {
            return _Barbell!!
        }
        _Barbell = ImageVector.Builder(
            name = "Barbell",
            defaultWidth = 281.dp,
            defaultHeight = 200.dp,
            viewportWidth = 281f,
            viewportHeight = 200f
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
                moveTo(5.50557f, 15.762f)
                lineTo(13.943f, 21.0119f)
                lineTo(10.0055f, 28.6994f)
                lineTo(1.19309f, 23.2619f)
                curveTo(0.1431f, 18.162f, 3.6306f, 16.137f, 5.5056f, 15.762f)
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
                moveTo(52.136f, 25.9172f)
                curveTo(50.1903f, -16.2212f, 20.8664f, 4.1894f, 10.6169f, 21.1437f)
                curveTo(2.6258f, 32.1719f, 1.8151f, 46.328f, 2.6258f, 52.2537f)
                curveTo(8.3238f, 85.7011f, 30.9422f, 68.1653f, 41.5391f, 55.2165f)
                curveTo(50.4335f, 44.4186f, 52.3097f, 31.1845f, 52.136f, 25.9172f)
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
                moveTo(60.7219f, 28.5078f)
                curveTo(58.6255f, -16.7433f, 27.0299f, 5.1749f, 15.9864f, 23.3817f)
                curveTo(8.4086f, 35.8748f, 6.5028f, 50.4263f, 7.3763f, 56.7897f)
                curveTo(13.5157f, 92.7077f, 37.8862f, 73.8767f, 49.3041f, 59.9714f)
                curveTo(58.8876f, 48.3758f, 60.9091f, 34.1642f, 60.7219f, 28.5078f)
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
                moveTo(68.4209f, 32.3125f)
                curveTo(66.3209f, -15.6873f, 34.671f, 7.5623f, 23.6086f, 26.875f)
                curveTo(14.9836f, 39.4372f, 13.2517f, 54.508f, 14.1267f, 61.258f)
                curveTo(20.2766f, 99.3578f, 44.689f, 79.3829f, 56.1265f, 64.633f)
                curveTo(65.7264f, 52.333f, 68.6084f, 38.3124f, 68.4209f, 32.3125f)
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
                moveTo(74.7958f, 36.0627f)
                curveTo(72.6959f, -11.9371f, 41.046f, 11.3125f, 29.9835f, 30.6252f)
                curveTo(21.3586f, 43.1874f, 21.7961f, 59.3126f, 22.6711f, 66.0625f)
                curveTo(28.8211f, 104.162f, 53.2335f, 84.1874f, 64.6709f, 69.4375f)
                curveTo(74.2709f, 57.1375f, 74.9833f, 42.0626f, 74.7958f, 36.0627f)
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
                moveTo(70.4745f, 37.7499f)
                curveTo(70.6205f, 42.7289f, 69.0435f, 55.2386f, 61.5672f, 65.4455f)
                curveTo(52.66f, 77.6856f, 33.6481f, 94.2615f, 28.8586f, 62.6448f)
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
                moveTo(28.8676f, 58.3748f)
                curveTo(28.7215f, 53.3958f, 30.2986f, 40.8861f, 37.7748f, 30.6791f)
                curveTo(46.6821f, 18.4391f, 65.6939f, 1.8631f, 70.4834f, 33.4798f)
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
                moveTo(53.5126f, 56.2557f)
                horizontalLineTo(56.2558f)
                lineTo(61.3503f, 46.2626f)
                lineTo(60.7624f, 43.9113f)
                lineTo(53.5126f, 39.6006f)
                curveTo(46.3019f, 41.3249f, 46.3281f, 49.0711f, 47.2425f, 52.7287f)
                lineTo(53.5126f, 56.2557f)
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
                moveTo(53.3167f, 55.8638f)
                curveTo(51.6185f, 52.0756f, 50.6519f, 44.4208f, 60.3706f, 44.1073f)
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
                moveTo(223.394f, 140.903f)
                lineTo(60.1745f, 45.8707f)
                curveTo(52.9638f, 45.8707f, 53.3818f, 51.749f, 54.4922f, 54.6881f)
                lineTo(218.3f, 149.328f)
                lineTo(223.394f, 140.903f)
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
                moveTo(72.5188f, 64.8771f)
                curveTo(71.8918f, 60.6447f, 75.6539f, 57.2353f, 77.6133f, 56.0597f)
                lineTo(104.849f, 71.931f)
                curveTo(101.244f, 73.185f, 99.9507f, 78.3318f, 99.7548f, 80.7484f)
                lineTo(72.5188f, 64.8771f)
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
                moveTo(167.229f, 119.937f)
                curveTo(166.602f, 115.704f, 170.364f, 112.295f, 172.323f, 111.119f)
                lineTo(199.559f, 126.991f)
                curveTo(195.954f, 128.245f, 194.66f, 133.391f, 194.465f, 135.808f)
                lineTo(167.229f, 119.937f)
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
                moveTo(257.204f, 132.244f)
                curveTo(264.589f, 79.2212f, 222.842f, 103.951f, 215.664f, 113.575f)
                curveTo(206.775f, 121.866f, 194.577f, 149.387f, 196.82f, 172.075f)
                curveTo(200.321f, 207.478f, 223.857f, 192.625f, 239.462f, 172.075f)
                curveTo(251.463f, 156.272f, 257.092f, 140.228f, 257.204f, 132.244f)
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
                moveTo(264.688f, 137.928f)
                curveTo(271.745f, 87.1144f, 231.859f, 110.813f, 225.001f, 120.037f)
                curveTo(216.508f, 127.982f, 204.854f, 154.357f, 206.997f, 176.1f)
                curveTo(210.342f, 210.028f, 232.828f, 195.793f, 247.738f, 176.1f)
                curveTo(259.204f, 160.955f, 264.581f, 145.58f, 264.688f, 137.928f)
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
                moveTo(271.02f, 142.672f)
                curveTo(277.559f, 94.9513f, 240.598f, 117.208f, 234.242f, 125.87f)
                curveTo(226.372f, 133.332f, 215.573f, 158.101f, 217.559f, 178.52f)
                curveTo(220.659f, 210.383f, 241.496f, 197.015f, 255.312f, 178.52f)
                curveTo(265.937f, 164.297f, 270.921f, 149.858f, 271.02f, 142.672f)
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
                moveTo(276.562f, 148.18f)
                curveTo(282.63f, 104.216f, 248.328f, 124.72f, 242.43f, 132.701f)
                curveTo(235.126f, 139.575f, 225.104f, 162.395f, 226.947f, 181.207f)
                curveTo(229.823f, 210.562f, 249.162f, 198.246f, 261.984f, 181.207f)
                curveTo(271.845f, 168.103f, 276.47f, 154.801f, 276.562f, 148.18f)
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
                moveTo(269.532f, 152.228f)
                curveTo(273.494f, 121.221f, 251.102f, 135.683f, 247.252f, 141.311f)
                curveTo(242.484f, 146.159f, 235.942f, 162.253f, 237.145f, 175.521f)
                curveTo(239.023f, 196.224f, 251.646f, 187.538f, 260.016f, 175.521f)
                curveTo(266.453f, 166.279f, 269.472f, 156.897f, 269.532f, 152.228f)
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
                moveTo(258.889f, 169.706f)
                horizontalLineTo(261.633f)
                lineTo(266.727f, 159.713f)
                lineTo(266.139f, 157.362f)
                lineTo(258.889f, 153.051f)
                curveTo(251.679f, 154.775f, 251.705f, 162.522f, 252.619f, 166.179f)
                lineTo(258.889f, 169.706f)
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
                moveTo(258.693f, 169.314f)
                curveTo(256.995f, 165.526f, 256.029f, 157.871f, 265.747f, 157.558f)
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
                moveTo(279.042f, 166.767f)
                lineTo(266.697f, 159.909f)
                curveTo(260.584f, 161.006f, 260.754f, 166.636f, 261.603f, 169.314f)
                lineTo(274.339f, 175.584f)
                curveTo(273.869f, 169.471f, 277.278f, 167.159f, 279.042f, 166.767f)
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
                moveTo(275.316f, 170.903f)
                lineTo(275.407f, 170.789f)
                lineTo(275.462f, 170.653f)
                curveTo(275.734f, 169.981f, 276.274f, 169.266f, 276.934f, 168.704f)
                curveTo(277.607f, 168.132f, 278.287f, 167.817f, 278.787f, 167.772f)
                curveTo(279.021f, 167.752f, 279.184f, 167.792f, 279.302f, 167.857f)
                curveTo(279.416f, 167.92f, 279.56f, 168.046f, 279.693f, 168.327f)
                curveTo(279.98f, 168.934f, 280.15f, 170.138f, 279.817f, 172.28f)
                curveTo(279.76f, 172.649f, 279.512f, 173.595f, 278.649f, 174.688f)
                curveTo(278.531f, 174.838f, 278.226f, 175.112f, 277.792f, 175.358f)
                curveTo(277.365f, 175.601f, 276.905f, 175.763f, 276.497f, 175.788f)
                curveTo(276.116f, 175.811f, 275.805f, 175.717f, 275.542f, 175.462f)
                curveTo(275.263f, 175.192f, 274.938f, 174.644f, 274.757f, 173.564f)
                curveTo(274.785f, 173.171f, 274.849f, 172.597f, 274.956f, 172.053f)
                curveTo(275.014f, 171.754f, 275.082f, 171.483f, 275.156f, 171.264f)
                curveTo(275.192f, 171.155f, 275.228f, 171.068f, 275.259f, 171.003f)
                curveTo(275.275f, 170.97f, 275.288f, 170.946f, 275.299f, 170.929f)
                curveTo(275.304f, 170.92f, 275.308f, 170.914f, 275.311f, 170.909f)
                curveTo(275.314f, 170.905f, 275.316f, 170.903f, 275.316f, 170.903f)
                close()
            }
        }.build()
        return _Barbell!!
    }

