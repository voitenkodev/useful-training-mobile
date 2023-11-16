package musclepickerpicker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun bodyBack(
    outlineColor: Color,

    rhomboids: Color,
    latissimus: Color,
    trapezius: Color,
    triceps: Color,
    forearm: Color,

    posteriorDeltoid: Color,
    lateralDeltoid: Color,

    other: Color

): ImageVector {
    return ImageVector.Builder(
        name = "vector",
        defaultWidth = 411.dp,
        defaultHeight = 430.dp,
        viewportWidth = 411f,
        viewportHeight = 430f
    ).apply {
        path(
            fill = null,
            fillAlpha = 1.0f,
            stroke = SolidColor(outlineColor),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(182.585f, 86.7665f)
            verticalLineTo(93.7665f)
            moveTo(182.585f, 93.7665f)
            verticalLineTo(104.766f)
            curveTo(178.751f, 110.933f, 163.385f, 124.466f, 132.585f, 129.266f)
            curveTo(101.785f, 134.066f, 101.085f, 172.266f, 104.585f, 190.766f)
            curveTo(94.1845f, 213.166f, 91.9179f, 241.766f, 92.0845f, 253.266f)
            curveTo(84.5845f, 260.1f, 68.4845f, 279.566f, 64.0845f, 302.766f)
            curveTo(59.6845f, 325.966f, 43.9179f, 348.433f, 36.5845f, 356.766f)
            curveTo(32.1845f, 356.766f, 29.4179f, 358.1f, 28.5845f, 358.766f)
            curveTo(20.2512f, 364.6f, 3.2845f, 376.366f, 2.0846f, 376.766f)
            curveTo(0.8845f, 377.166f, 0.9179f, 378.266f, 1.0845f, 378.766f)
            curveTo(2.6846f, 385.166f, 9.7512f, 383.433f, 13.0845f, 381.766f)
            curveTo(16.5845f, 379.1f, 23.5845f, 374.166f, 23.5845f, 375.766f)
            curveTo(23.5845f, 377.766f, 12.5845f, 405.766f, 9.0845f, 414.266f)
            curveTo(6.2845f, 421.066f, 11.2512f, 420.433f, 14.0845f, 419.266f)
            lineTo(25.0845f, 394.766f)
            curveTo(22.7512f, 399.933f, 17.1845f, 412.466f, 13.5845f, 421.266f)
            curveTo(9.9846f, 430.066f, 15.7512f, 429.6f, 19.0845f, 428.266f)
            lineTo(31.0845f, 400.266f)
            lineTo(21.0845f, 424.266f)
            curveTo(20.6845f, 431.866f, 25.5845f, 429.1f, 28.0845f, 426.766f)
            curveTo(30.5845f, 420.266f, 35.9846f, 406.466f, 37.5846f, 403.266f)
            curveTo(39.1846f, 400.066f, 39.5846f, 401.933f, 39.5845f, 403.266f)
            lineTo(34.0846f, 417.766f)
            curveTo(32.8846f, 424.166f, 35.9179f, 422.766f, 37.5846f, 421.266f)
            curveTo(44.7846f, 412.866f, 51.5846f, 390.433f, 54.0846f, 380.266f)
            lineTo(62.0846f, 358.266f)
            curveTo(112.485f, 299.066f, 121.751f, 270.266f, 120.085f, 263.266f)
            curveTo(126.885f, 257.666f, 133.585f, 234.933f, 136.085f, 224.266f)
            lineTo(154.585f, 266.266f)
            lineTo(154.085f, 305.267f)
            lineTo(152.585f, 309.767f)
            curveTo(149.721f, 315.207f, 147.84f, 320.383f, 146.643f, 325f)
            curveTo(156.9f, 335.833f, 178.632f, 360.6f, 183.5f, 373f)
            curveTo(191f, 377.089f, 209.9f, 383.166f, 225.5f, 374.766f)
            curveTo(235.042f, 360.678f, 256.312f, 331.4f, 265.062f, 327f)
            curveTo(262.472f, 315.529f, 259.492f, 307.015f, 257.585f, 302.766f)
            lineTo(257.085f, 264.766f)
            curveTo(263.885f, 259.166f, 272.585f, 233.433f, 276.085f, 221.266f)
            curveTo(277.285f, 236.866f, 287.251f, 256.766f, 292.085f, 264.766f)
            curveTo(289.685f, 277.166f, 304.418f, 300.933f, 312.085f, 311.266f)
            lineTo(352.085f, 361.766f)
            lineTo(352.585f, 365.266f)
            curveTo(354.185f, 380.066f, 367.585f, 408.766f, 374.085f, 421.266f)
            curveTo(377.685f, 424.466f, 377.585f, 420.6f, 377.085f, 418.266f)
            curveTo(375.918f, 414.433f, 373.385f, 406.166f, 372.585f, 403.766f)
            curveTo(371.785f, 401.366f, 373.251f, 402.433f, 374.085f, 403.266f)
            lineTo(383.085f, 426.766f)
            curveTo(389.085f, 431.966f, 390.251f, 426.933f, 390.085f, 423.766f)
            lineTo(379.085f, 397.266f)
            lineTo(391.085f, 425.266f)
            curveTo(398.685f, 432.066f, 397.585f, 422.766f, 396.085f, 417.266f)
            lineTo(384.085f, 390.766f)
            lineTo(397.085f, 418.266f)
            curveTo(402.685f, 423.066f, 403.085f, 417.933f, 402.585f, 414.766f)
            lineTo(387.585f, 374.766f)
            curveTo(390.751f, 376.933f, 398.585f, 381.466f, 404.585f, 382.266f)
            curveTo(410.585f, 383.066f, 410.085f, 378.933f, 409.085f, 376.766f)
            lineTo(390.085f, 364.266f)
            curveTo(382.885f, 355.866f, 376.418f, 354.766f, 374.085f, 355.266f)
            curveTo(362.885f, 346.866f, 354.085f, 325.1f, 351.085f, 315.266f)
            curveTo(343.885f, 283.666f, 326.418f, 259.1f, 318.585f, 250.766f)
            curveTo(320.985f, 235.966f, 311.918f, 204.6f, 307.085f, 190.766f)
            curveTo(314.285f, 144.366f, 290.418f, 129.766f, 277.585f, 128.266f)
            curveTo(256.385f, 129.066f, 238.085f, 112.933f, 231.585f, 104.766f)
            verticalLineTo(88.2665f)
            verticalLineTo(93.7665f)
            horizontalLineTo(233.585f)
            lineTo(238.085f, 71.7665f)
            horizontalLineTo(241.085f)
            curveTo(242.418f, 66.9331f, 245.285f, 56.6665f, 246.085f, 54.2665f)
            curveTo(246.885f, 51.8665f, 242.418f, 49.5998f, 240.085f, 48.7665f)
            curveTo(241.751f, 31.4331f, 236.985f, -2.3335f, 204.585f, 1.2665f)
            curveTo(172.185f, 4.8665f, 170.085f, 36.0998f, 173.085f, 51.2665f)
            curveTo(167.485f, 51.2665f, 166.751f, 53.2665f, 167.085f, 54.2665f)
            lineTo(173.085f, 72.7665f)
            horizontalLineTo(174.585f)
            lineTo(180.085f, 92.7665f)
            lineTo(182.585f, 93.7665f)
            close()
        }
        path(
            fill = SolidColor(rhomboids),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(235.606f, 300.914f)
            curveTo(235.206f, 304.914f, 219.439f, 322.58f, 211.606f, 330.914f)
            curveTo(207.606f, 325.414f, 210.606f, 265.414f, 211.606f, 268.914f)
            curveTo(212.406f, 271.714f, 227.939f, 291.414f, 235.606f, 300.914f)
            close()
        }
        path(
            fill = SolidColor(rhomboids),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(173.584f, 301.266f)
            curveTo(173.984f, 305.266f, 189.751f, 322.933f, 197.584f, 331.266f)
            curveTo(201.584f, 325.766f, 198.584f, 265.766f, 197.584f, 269.266f)
            curveTo(196.784f, 272.066f, 181.251f, 291.766f, 173.584f, 301.266f)
            close()
        }
        path(
            fill = SolidColor(latissimus),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(149.584f, 245.766f)
            curveTo(162.784f, 266.566f, 169.084f, 285.766f, 170.584f, 292.766f)
            curveTo(199.784f, 269.166f, 202.084f, 236.6f, 199.585f, 223.266f)
            curveTo(191.085f, 217.266f, 173.585f, 204.366f, 171.585f, 200.766f)
            curveTo(169.585f, 197.166f, 165.418f, 195.266f, 163.585f, 194.766f)
            lineTo(133.084f, 191.266f)
            curveTo(132.084f, 197.266f, 133.084f, 219.766f, 149.584f, 245.766f)
            close()
        }
        path(
            fill = SolidColor(latissimus),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(260.339f, 245.266f)
            curveTo(247.139f, 266.066f, 240.839f, 285.266f, 239.339f, 292.266f)
            curveTo(210.139f, 268.666f, 207.839f, 236.1f, 210.339f, 222.766f)
            curveTo(218.839f, 216.766f, 236.339f, 203.866f, 238.339f, 200.266f)
            curveTo(240.339f, 196.666f, 244.506f, 194.766f, 246.339f, 194.266f)
            lineTo(276.839f, 190.766f)
            curveTo(277.839f, 196.766f, 276.839f, 219.266f, 260.339f, 245.266f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(136.084f, 134.266f)
            curveTo(136.405f, 134.189f, 136.75f, 134.134f, 137.118f, 134.105f)
            lineTo(152.084f, 131.766f)
            curveTo(167.418f, 133.6f, 198.784f, 139.766f, 201.584f, 149.766f)
            curveTo(204.384f, 159.766f, 201.751f, 198.6f, 200.084f, 216.766f)
            curveTo(187.284f, 211.566f, 174.418f, 189.933f, 169.584f, 179.766f)
            curveTo(158.208f, 141.845f, 143.836f, 133.583f, 137.118f, 134.105f)
            lineTo(136.084f, 134.266f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(200.084f, 137.766f)
            curveTo(198.884f, 134.966f, 173.918f, 129.6f, 161.584f, 127.266f)
            horizontalLineTo(160.584f)
            curveTo(196.984f, 107.266f, 203.084f, 80.9331f, 201.584f, 70.2665f)
            lineTo(205.584f, 71.7665f)
            curveTo(203.084f, 78.7665f, 201.584f, 141.266f, 200.084f, 137.766f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(278.084f, 134.766f)
            curveTo(277.845f, 134.708f, 277.58f, 134.667f, 277.292f, 134.643f)
            lineTo(262.084f, 132.266f)
            curveTo(246.751f, 134.1f, 213.384f, 138.266f, 210.584f, 148.266f)
            curveTo(207.784f, 158.266f, 208.918f, 197.6f, 210.584f, 215.766f)
            curveTo(223.384f, 210.566f, 237.251f, 190.433f, 242.084f, 180.266f)
            curveTo(248.332f, 144.221f, 270.133f, 134.045f, 277.292f, 134.643f)
            lineTo(278.084f, 134.766f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(214.084f, 138.266f)
            curveTo(215.284f, 135.466f, 240.251f, 130.1f, 252.584f, 127.766f)
            horizontalLineTo(253.584f)
            curveTo(217.184f, 107.766f, 211.084f, 81.4331f, 212.584f, 70.7665f)
            lineTo(208.584f, 72.2665f)
            curveTo(211.084f, 79.2665f, 212.584f, 141.766f, 214.084f, 138.266f)
            close()
        }
        path(
            fill = SolidColor(lateralDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(111.085f, 186.266f)
            curveTo(117.885f, 183.066f, 138.918f, 157.266f, 148.585f, 144.766f)
            curveTo(147.085f, 142.266f, 120.085f, 135.266f, 112.085f, 149.766f)
            curveTo(105.685f, 161.366f, 108.751f, 178.933f, 111.085f, 186.266f)
            close()
        }
        path(
            fill = SolidColor(posteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(151.585f, 152.766f)
            curveTo(145.585f, 154.366f, 134.418f, 171.433f, 129.585f, 179.766f)
            curveTo(135.985f, 186.966f, 156.585f, 187.766f, 166.085f, 187.266f)
            curveTo(163.751f, 175.1f, 157.585f, 151.166f, 151.585f, 152.766f)
            close()
        }
        path(
            fill = SolidColor(lateralDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(300.585f, 186.163f)
            curveTo(293.785f, 182.963f, 272.751f, 157.163f, 263.085f, 144.663f)
            curveTo(264.585f, 142.163f, 291.585f, 135.163f, 299.585f, 149.663f)
            curveTo(305.985f, 161.263f, 302.918f, 178.83f, 300.585f, 186.163f)
            close()
        }
        path(
            fill = SolidColor(posteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(260.085f, 152.663f)
            curveTo(266.085f, 154.263f, 277.251f, 171.33f, 282.085f, 179.663f)
            curveTo(275.685f, 186.863f, 255.085f, 187.663f, 245.585f, 187.163f)
            curveTo(247.918f, 174.996f, 254.085f, 151.063f, 260.085f, 152.663f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(116.085f, 235.766f)
            curveTo(110.085f, 196.966f, 121.251f, 182.266f, 127.585f, 179.766f)
            curveTo(126.785f, 182.566f, 128.585f, 193.933f, 129.585f, 199.266f)
            curveTo(130.418f, 204.766f, 132.085f, 217.966f, 132.085f, 226.766f)
            curveTo(132.085f, 237.766f, 113.585f, 264.266f, 116.085f, 257.766f)
            curveTo(118.085f, 252.566f, 116.918f, 240.933f, 116.085f, 235.766f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(105.585f, 244.766f)
            curveTo(105.585f, 241.966f, 108.251f, 224.6f, 109.585f, 216.266f)
            lineTo(111.085f, 244.766f)
            curveTo(108.685f, 257.966f, 106.418f, 250.266f, 105.585f, 244.766f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(295.585f, 235.766f)
            curveTo(301.585f, 196.966f, 290.418f, 182.266f, 284.085f, 179.766f)
            curveTo(284.885f, 182.566f, 283.085f, 193.933f, 282.085f, 199.266f)
            curveTo(281.251f, 204.766f, 279.585f, 217.966f, 279.585f, 226.766f)
            curveTo(279.585f, 237.766f, 298.085f, 264.266f, 295.585f, 257.766f)
            curveTo(293.585f, 252.566f, 294.751f, 240.933f, 295.585f, 235.766f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(306.085f, 244.766f)
            curveTo(306.085f, 241.966f, 303.418f, 224.6f, 302.085f, 216.266f)
            lineTo(300.585f, 244.766f)
            curveTo(302.985f, 257.966f, 305.251f, 250.266f, 306.085f, 244.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(308.585f, 280.266f)
            curveTo(303.785f, 280.666f, 297.918f, 278.1f, 295.585f, 276.766f)
            curveTo(302.785f, 299.566f, 327.251f, 327.6f, 338.585f, 338.766f)
            lineTo(332.085f, 326.266f)
            curveTo(326.251f, 310.766f, 313.385f, 279.866f, 308.585f, 280.266f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(322.085f, 269.766f)
            curveTo(324.251f, 287.433f, 332.085f, 326.266f, 346.085f, 340.266f)
            curveTo(345.085f, 329.266f, 338.885f, 299.766f, 322.085f, 269.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(353.585f, 353.766f)
            curveTo(353.585f, 346.166f, 337.251f, 292.266f, 329.085f, 266.266f)
            curveTo(330.085f, 266.266f, 357.585f, 339.766f, 360.085f, 347.766f)
            curveTo(362.085f, 354.166f, 356.585f, 354.433f, 353.585f, 353.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(103.512f, 280.766f)
            curveTo(108.312f, 281.166f, 114.179f, 278.6f, 116.512f, 277.266f)
            curveTo(109.312f, 300.066f, 84.8454f, 328.1f, 73.5121f, 339.266f)
            lineTo(80.0121f, 326.766f)
            curveTo(85.8454f, 311.266f, 98.7121f, 280.366f, 103.512f, 280.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(90.0121f, 270.266f)
            curveTo(87.8454f, 287.933f, 80.0121f, 326.766f, 66.0121f, 340.766f)
            curveTo(67.0121f, 329.766f, 73.2121f, 300.266f, 90.0121f, 270.266f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(58.5121f, 354.266f)
            curveTo(58.5121f, 346.666f, 74.8454f, 292.766f, 83.0121f, 266.766f)
            curveTo(82.0121f, 266.766f, 54.5121f, 340.266f, 52.0121f, 348.266f)
            curveTo(50.0121f, 354.666f, 55.5121f, 354.933f, 58.5121f, 354.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(158.585f, 308.266f)
            verticalLineTo(275.266f)
            curveTo(161.785f, 275.266f, 167.251f, 292.933f, 169.585f, 301.766f)
            lineTo(158.585f, 308.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(250.585f, 275.266f)
            curveTo(246.185f, 279.666f, 242.418f, 293.766f, 241.085f, 300.266f)
            curveTo(241.085f, 303.466f, 247.418f, 306.933f, 250.585f, 308.266f)
            verticalLineTo(275.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(152.221f, 331.5f)
            curveTo(160.272f, 305.234f, 177.714f, 316.893f, 186.585f, 327.766f)
            curveTo(175.138f, 327.766f, 165.459f, 332.709f, 158.585f, 338.08f)
            lineTo(152.221f, 331.5f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(223.085f, 327.766f)
            curveTo(243.735f, 305.901f, 253.588f, 318.005f, 257.5f, 333.271f)
            lineTo(252f, 339.206f)
            curveTo(242.539f, 331.551f, 229.687f, 328.401f, 223.085f, 327.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(300.085f, 263.766f)
            curveTo(300.085f, 264.966f, 309.418f, 275.266f, 314.085f, 280.266f)
            curveTo(315.085f, 276.1f, 315.585f, 266.166f, 309.585f, 259.766f)
            curveTo(302.085f, 251.766f, 300.085f, 262.266f, 300.085f, 263.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(111.085f, 265.266f)
            lineTo(97.0845f, 279.766f)
            lineTo(100.085f, 263.766f)
            curveTo(100.918f, 261.433f, 103.985f, 256.866f, 109.585f, 257.266f)
            curveTo(115.185f, 257.666f, 112.918f, 262.766f, 111.085f, 265.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(41.5845f, 357.266f)
            lineTo(26.5845f, 380.766f)
            curveTo(27.0845f, 381.933f, 29.6845f, 385.766f, 36.0845f, 391.766f)
            curveTo(42.4845f, 397.766f, 44.7512f, 396.6f, 45.0845f, 395.266f)
            curveTo(55.4845f, 384.466f, 54.7512f, 365.433f, 53.0845f, 357.266f)
            horizontalLineTo(41.5845f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(44.5845f, 401.766f)
            curveTo(44.9845f, 399.766f, 43.7512f, 399.933f, 43.0845f, 400.266f)
            curveTo(42.5845f, 401.266f, 37.5845f, 410.766f, 36.5845f, 414.266f)
            curveTo(35.7845f, 417.066f, 37.9178f, 416.433f, 39.0845f, 415.766f)
            lineTo(41.0845f, 412.766f)
            curveTo(42.0845f, 409.933f, 44.1845f, 403.766f, 44.5845f, 401.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(36.5845f, 400.766f)
            curveTo(37.7845f, 396.766f, 35.0845f, 397.433f, 33.5845f, 398.266f)
            curveTo(32.7845f, 398.621f, 27.2512f, 413.081f, 24.5845f, 420.266f)
            curveTo(24.5845f, 424.266f, 26.9178f, 422.933f, 28.0845f, 421.766f)
            curveTo(30.4178f, 416.433f, 35.3845f, 404.766f, 36.5845f, 400.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(27.0845f, 394.266f)
            lineTo(16.5845f, 420.266f)
            curveTo(16.5845f, 424.666f, 18.9178f, 424.433f, 20.0845f, 423.766f)
            curveTo(23.2512f, 416.433f, 29.8845f, 400.666f, 31.0845f, 396.266f)
            curveTo(32.2845f, 391.866f, 28.9178f, 393.1f, 27.0845f, 394.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(14.5845f, 413.766f)
            curveTo(12.5845f, 416.966f, 12.0845f, 413.433f, 12.0845f, 411.266f)
            curveTo(14.2512f, 404.433f, 19.2845f, 389.966f, 22.0845f, 386.766f)
            curveTo(24.8845f, 383.566f, 25.5845f, 387.1f, 25.5845f, 389.266f)
            curveTo(22.7512f, 396.1f, 16.5845f, 410.566f, 14.5845f, 413.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(31.0845f, 360.266f)
            lineTo(11.0845f, 371.766f)
            curveTo(10.0845f, 372.6f, 7.1845f, 374.766f, 3.5845f, 376.766f)
            curveTo(-0.0155f, 378.766f, 4.0845f, 379.933f, 6.5845f, 380.266f)
            horizontalLineTo(11.5845f)
            lineTo(17.5845f, 377.266f)
            curveTo(22.0845f, 373.933f, 31.7845f, 366.366f, 34.5845f, 362.766f)
            curveTo(37.3845f, 359.166f, 33.4178f, 359.6f, 31.0845f, 360.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(365.585f, 396.266f)
            curveTo(357.185f, 383.866f, 357.085f, 365.766f, 358.085f, 358.266f)
            curveTo(360.751f, 356.933f, 366.885f, 354.966f, 370.085f, 357.766f)
            curveTo(373.285f, 360.566f, 381.085f, 373.266f, 384.585f, 379.266f)
            curveTo(385.418f, 380.1f, 386.285f, 382.266f, 383.085f, 384.266f)
            curveTo(379.885f, 386.266f, 377.751f, 388.766f, 377.085f, 389.766f)
            curveTo(373.485f, 396.166f, 367.918f, 396.766f, 365.585f, 396.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(369.585f, 401.266f)
            curveTo(367.185f, 397.666f, 366.585f, 400.1f, 366.585f, 401.766f)
            curveTo(367.751f, 404.933f, 370.485f, 412.066f, 372.085f, 415.266f)
            curveTo(373.685f, 418.466f, 374.751f, 415.933f, 375.085f, 414.266f)
            curveTo(374.251f, 411.433f, 371.985f, 404.866f, 369.585f, 401.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(378.585f, 398.766f)
            curveTo(375.785f, 393.166f, 374.751f, 398.1f, 374.585f, 401.266f)
            lineTo(383.085f, 421.266f)
            curveTo(387.085f, 424.866f, 387.085f, 421.1f, 386.585f, 418.766f)
            curveTo(385.085f, 414.433f, 381.385f, 404.366f, 378.585f, 398.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(384.585f, 395.266f)
            curveTo(380.985f, 389.266f, 380.085f, 394.433f, 380.085f, 397.766f)
            lineTo(391.585f, 423.266f)
            curveTo(395.185f, 427.666f, 395.085f, 421.433f, 394.585f, 417.766f)
            curveTo(392.751f, 412.766f, 388.185f, 401.266f, 384.585f, 395.266f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(390.585f, 387.766f)
            curveTo(388.185f, 382.566f, 386.251f, 386.933f, 385.585f, 389.766f)
            lineTo(396.085f, 413.766f)
            curveTo(399.685f, 417.766f, 399.918f, 412.1f, 399.585f, 408.766f)
            curveTo(397.585f, 403.933f, 392.985f, 392.966f, 390.585f, 387.766f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(403.585f, 380.266f)
            curveTo(395.985f, 379.866f, 383.085f, 369.433f, 377.585f, 364.266f)
            curveTo(376.918f, 362.933f, 375.985f, 360.166f, 377.585f, 359.766f)
            curveTo(379.185f, 359.366f, 381.251f, 360.6f, 382.085f, 361.266f)
            lineTo(395.085f, 369.266f)
            lineTo(407.085f, 376.266f)
            curveTo(409.085f, 377.766f, 411.185f, 380.666f, 403.585f, 380.266f)
            close()
        }
    }.build()
}