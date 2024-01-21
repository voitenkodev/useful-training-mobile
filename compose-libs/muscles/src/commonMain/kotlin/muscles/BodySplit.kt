package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun bodySplit(
    outlineColor: Color = Colors.outline,

    teresMajor: Color = Colors.defaultBack,
    rhomboids: Color = Colors.defaultBack,
    latissimus: Color = Colors.defaultBack,
    trapezius: Color = Colors.defaultBack,

    triceps: Color = Colors.defaultBack,
    biceps: Color = Colors.defaultFront,
    forearmFront: Color = Colors.defaultFront,
    forearmBack: Color = Colors.defaultBack,

    posteriorDeltoid: Color = Colors.defaultBack,
    lateralDeltoidFront: Color = Colors.defaultFront,
    anteriorDeltoid: Color = Colors.defaultFront,

    rectusAbdominis: Color = Colors.defaultFront,
    obliquesAbdominis: Color = Colors.defaultFront,

    pectoralisMajor: Color = Colors.defaultFront,
    pectoralisMinor: Color = Colors.defaultFront,

    otherFront: Color = Colors.defaultFront,
    otherBack: Color = Colors.defaultBack,

    backgroundFront: Color = Colors.backgroundFront,
    backgroundBack: Color = Colors.backgroundBack
): ImageVector {


    return ImageVector.Builder(
        name = "vector",
        defaultWidth = 421.dp,
        defaultHeight = 431.dp,
        viewportWidth = 421f,
        viewportHeight = 431f
    ).apply {
        path(
            fill = SolidColor(backgroundFront),
            fillAlpha = 1.0f,
            stroke = SolidColor(outlineColor),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(238f, 87.5f)
            verticalLineTo(94.5f)
            moveTo(238f, 94.5f)
            verticalLineTo(105.5f)
            curveTo(241.833f, 111.667f, 257.2f, 125.2f, 288f, 130f)
            curveTo(318.8f, 134.8f, 319.5f, 173f, 316f, 191.5f)
            curveTo(326.4f, 213.9f, 328.667f, 242.5f, 328.5f, 254f)
            curveTo(336f, 260.833f, 352.1f, 280.3f, 356.5f, 303.5f)
            curveTo(360.9f, 326.7f, 376.667f, 349.167f, 384f, 357.5f)
            curveTo(388.4f, 357.5f, 391.167f, 358.833f, 392f, 359.5f)
            curveTo(400.333f, 365.333f, 417.3f, 377.1f, 418.5f, 377.5f)
            curveTo(419.7f, 377.9f, 419.667f, 379f, 419.5f, 379.5f)
            curveTo(417.9f, 385.9f, 410.833f, 384.167f, 407.5f, 382.5f)
            curveTo(404f, 379.833f, 397f, 374.9f, 397f, 376.5f)
            curveTo(397f, 378.5f, 408f, 406.5f, 411.5f, 415f)
            curveTo(414.3f, 421.8f, 409.333f, 421.167f, 406.5f, 420f)
            lineTo(395.5f, 395.5f)
            curveTo(397.833f, 400.667f, 403.4f, 413.2f, 407f, 422f)
            curveTo(410.6f, 430.8f, 404.833f, 430.333f, 401.5f, 429f)
            lineTo(389.5f, 401f)
            lineTo(399.5f, 425f)
            curveTo(399.9f, 432.6f, 395f, 429.833f, 392.5f, 427.5f)
            curveTo(390f, 421f, 384.6f, 407.2f, 383f, 404f)
            curveTo(381.4f, 400.8f, 381f, 402.667f, 381f, 404f)
            lineTo(386.5f, 418.5f)
            curveTo(387.7f, 424.9f, 384.667f, 423.5f, 383f, 422f)
            curveTo(375.8f, 413.6f, 369f, 391.167f, 366.5f, 381f)
            lineTo(358.5f, 359f)
            curveTo(308.1f, 299.8f, 298.833f, 271f, 300.5f, 264f)
            curveTo(293.7f, 258.4f, 287f, 235.667f, 284.5f, 225f)
            lineTo(266f, 267f)
            lineTo(266.5f, 306f)
            lineTo(268f, 310.5f)
            curveTo(276f, 325.7f, 276.333f, 338.833f, 275.5f, 343.5f)
            lineTo(279.5f, 369.5f)
            curveTo(245.813f, 376.267f, 237.187f, 401f, 232.687f, 406.234f)
            curveTo(229.087f, 410.42f, 220.062f, 410.311f, 216f, 409.734f)
            verticalLineTo(2f)
            curveTo(248.4f, 5.6f, 250.5f, 36.8333f, 247.5f, 52f)
            curveTo(253.1f, 52f, 253.833f, 54f, 253.5f, 55f)
            lineTo(247.5f, 73.5f)
            horizontalLineTo(246f)
            lineTo(240.5f, 93.5f)
            lineTo(238f, 94.5f)
            close()
        }
        path(
            fill = SolidColor(rhomboids),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(247f, 302f)
            curveTo(246.6f, 306f, 230.833f, 323.667f, 223f, 332f)
            curveTo(219f, 326.5f, 222f, 266.5f, 223f, 270f)
            curveTo(223.8f, 272.8f, 239.333f, 292.5f, 247f, 302f)
            close()
        }
        path(
            fill = SolidColor(latissimus),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(271f, 246.5f)
            curveTo(257.8f, 267.3f, 251.5f, 286.5f, 250f, 293.5f)
            curveTo(220.8f, 269.9f, 218.5f, 237.333f, 221f, 224f)
            curveTo(229.5f, 218f, 247f, 205.1f, 249f, 201.5f)
            curveTo(251f, 197.9f, 255.167f, 196f, 257f, 195.5f)
            lineTo(287.5f, 192f)
            curveTo(288.5f, 198f, 287.5f, 220.5f, 271f, 246.5f)
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
            moveTo(284.5f, 135f)
            curveTo(284.18f, 134.922f, 283.834f, 134.867f, 283.466f, 134.838f)
            lineTo(268.5f, 132.5f)
            curveTo(253.167f, 134.333f, 221.8f, 140.5f, 219f, 150.5f)
            curveTo(216.2f, 160.5f, 218.833f, 199.333f, 220.5f, 217.5f)
            curveTo(233.3f, 212.3f, 246.167f, 190.667f, 251f, 180.5f)
            curveTo(262.376f, 142.579f, 276.749f, 134.317f, 283.466f, 134.838f)
            lineTo(284.5f, 135f)
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
            moveTo(220.5f, 138.5f)
            curveTo(221.7f, 135.7f, 246.667f, 130.333f, 259f, 128f)
            horizontalLineTo(260f)
            curveTo(223.6f, 108f, 217.5f, 81.6667f, 219f, 71f)
            lineTo(215f, 72.5f)
            curveTo(217.5f, 79.5f, 219f, 142f, 220.5f, 138.5f)
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
            moveTo(309.5f, 187f)
            curveTo(302.7f, 183.8f, 281.667f, 158f, 272f, 145.5f)
            curveTo(273.5f, 143f, 300.5f, 136f, 308.5f, 150.5f)
            curveTo(314.9f, 162.1f, 311.833f, 179.667f, 309.5f, 187f)
            close()
        }
        path(
            fill = SolidColor(teresMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(269f, 153.5f)
            curveTo(275f, 155.1f, 286.167f, 172.167f, 291f, 180.5f)
            curveTo(284.6f, 187.7f, 264f, 188.5f, 254.5f, 188f)
            curveTo(256.833f, 175.833f, 263f, 151.9f, 269f, 153.5f)
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
            moveTo(304.5f, 236.5f)
            curveTo(310.5f, 197.7f, 299.333f, 183f, 293f, 180.5f)
            curveTo(293.8f, 183.3f, 292f, 194.667f, 291f, 200f)
            curveTo(290.167f, 205.5f, 288.5f, 218.7f, 288.5f, 227.5f)
            curveTo(288.5f, 238.5f, 307f, 265f, 304.5f, 258.5f)
            curveTo(302.5f, 253.3f, 303.667f, 241.667f, 304.5f, 236.5f)
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
            moveTo(315f, 245.5f)
            curveTo(315f, 242.7f, 312.333f, 225.333f, 311f, 217f)
            lineTo(309.5f, 245.5f)
            curveTo(311.9f, 258.7f, 314.167f, 251f, 315f, 245.5f)
            close()
        }

        path(
            fill = SolidColor(forearmBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(317.072f, 281.5f)
            curveTo(312.272f, 281.9f, 306.406f, 279.333f, 304.072f, 278f)
            curveTo(311.272f, 300.8f, 335.739f, 328.833f, 347.072f, 340f)
            lineTo(340.572f, 327.5f)
            curveTo(334.739f, 312f, 321.872f, 281.1f, 317.072f, 281.5f)
            close()
        }
        path(
            fill = SolidColor(forearmBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(330.572f, 271f)
            curveTo(332.739f, 288.667f, 340.572f, 327.5f, 354.572f, 341.5f)
            curveTo(353.572f, 330.5f, 347.372f, 301f, 330.572f, 271f)
            close()
        }
        path(
            fill = SolidColor(forearmBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(362.072f, 355f)
            curveTo(362.072f, 347.4f, 345.739f, 293.5f, 337.572f, 267.5f)
            curveTo(338.572f, 267.5f, 366.072f, 341f, 368.572f, 349f)
            curveTo(370.572f, 355.4f, 365.072f, 355.667f, 362.072f, 355f)
            close()
        }

        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(271.5f, 348.5f)
            curveTo(266.833f, 341.833f, 252.8f, 328.5f, 234f, 328.5f)
            curveTo(244.333f, 315.833f, 266.3f, 302.1f, 271.5f, 348.5f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(262f, 309f)
            verticalLineTo(276f)
            curveTo(258.8f, 276f, 253.333f, 293.667f, 251f, 302.5f)
            lineTo(262f, 309f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(309.5f, 266f)
            lineTo(323.5f, 280.5f)
            lineTo(320.5f, 264.5f)
            curveTo(319.667f, 262.167f, 316.6f, 257.6f, 311f, 258f)
            curveTo(305.4f, 258.4f, 307.667f, 263.5f, 309.5f, 266f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(379f, 358f)
            lineTo(394f, 381.5f)
            curveTo(393.5f, 382.667f, 390.9f, 386.5f, 384.5f, 392.5f)
            curveTo(378.1f, 398.5f, 375.833f, 397.333f, 375.5f, 396f)
            curveTo(365.1f, 385.2f, 365.833f, 366.167f, 367.5f, 358f)
            horizontalLineTo(379f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(376f, 402.5f)
            curveTo(375.6f, 400.5f, 376.833f, 400.667f, 377.5f, 401f)
            curveTo(378f, 402f, 383f, 411.5f, 384f, 415f)
            curveTo(384.8f, 417.8f, 382.667f, 417.167f, 381.5f, 416.5f)
            lineTo(379.5f, 413.5f)
            curveTo(378.5f, 410.667f, 376.4f, 404.5f, 376f, 402.5f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(384f, 401.5f)
            curveTo(382.8f, 397.5f, 385.5f, 398.167f, 387f, 399f)
            curveTo(387.8f, 399.354f, 393.333f, 413.814f, 396f, 421f)
            curveTo(396f, 425f, 393.667f, 423.667f, 392.5f, 422.5f)
            curveTo(390.167f, 417.167f, 385.2f, 405.5f, 384f, 401.5f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(393.5f, 395f)
            lineTo(404f, 421f)
            curveTo(404f, 425.4f, 401.667f, 425.167f, 400.5f, 424.5f)
            curveTo(397.333f, 417.167f, 390.7f, 401.4f, 389.5f, 397f)
            curveTo(388.3f, 392.6f, 391.667f, 393.833f, 393.5f, 395f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(406f, 414.5f)
            curveTo(408f, 417.7f, 408.5f, 414.167f, 408.5f, 412f)
            curveTo(406.333f, 405.167f, 401.3f, 390.7f, 398.5f, 387.5f)
            curveTo(395.7f, 384.3f, 395f, 387.833f, 395f, 390f)
            curveTo(397.833f, 396.833f, 404f, 411.3f, 406f, 414.5f)
            close()
        }
        path(
            fill = SolidColor(otherBack),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(389.5f, 361f)
            lineTo(409.5f, 372.5f)
            curveTo(410.5f, 373.333f, 413.4f, 375.5f, 417f, 377.5f)
            curveTo(420.6f, 379.5f, 416.5f, 380.667f, 414f, 381f)
            horizontalLineTo(409f)
            lineTo(403f, 378f)
            curveTo(398.5f, 374.667f, 388.8f, 367.1f, 386f, 363.5f)
            curveTo(383.2f, 359.9f, 387.167f, 360.333f, 389.5f, 361f)
            close()
        }
        path(
            fill = SolidColor(backgroundBack),
            fillAlpha = 1.0f,
            stroke = SolidColor(outlineColor),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(154.187f, 294.666f)
            curveTo(154.187f, 303.466f, 149.187f, 318f, 146.687f, 324.166f)
            lineTo(141f, 369.957f)
            curveTo(149.667f, 370.957f, 169.9f, 377.657f, 181.5f, 396.457f)
            lineTo(186.5f, 404.457f)
            curveTo(187.5f, 406.791f, 192.5f, 411.157f, 204.5f, 409.957f)
            verticalLineTo(1f)
            curveTo(201.157f, 1.1743f, 197.699f, 1.8828f, 194.187f, 3.1662f)
            curveTo(173.387f, 10.7662f, 170.854f, 39.9996f, 172.187f, 53.6662f)
            curveTo(166.987f, 54.8662f, 166.354f, 56.4996f, 166.687f, 57.1662f)
            lineTo(171.187f, 70.6662f)
            curveTo(172.787f, 75.4662f, 174.52f, 75.9996f, 175.187f, 75.6662f)
            lineTo(176.687f, 89.6662f)
            lineTo(182.187f, 95.1662f)
            curveTo(183.02f, 97.4996f, 183.787f, 103.166f, 180.187f, 107.166f)
            curveTo(176.587f, 111.166f, 160.687f, 120.166f, 153.187f, 124.166f)
            curveTo(116.387f, 126.166f, 104.52f, 146.333f, 103.187f, 156.166f)
            verticalLineTo(191.666f)
            curveTo(96.3868f, 198.866f, 93.0202f, 234f, 92.1868f, 250.666f)
            curveTo(90.3535f, 253.166f, 84.7868f, 260.666f, 77.1868f, 270.666f)
            curveTo(67.6868f, 283.166f, 65.1868f, 296.166f, 59.1868f, 316.166f)
            curveTo(54.3868f, 332.166f, 42.1868f, 349.166f, 36.6868f, 355.666f)
            curveTo(33.4868f, 355.266f, 30.0201f, 356.166f, 28.6868f, 356.666f)
            lineTo(1.18684f, 375.666f)
            curveTo(0.6868f, 378.166f, 0.8868f, 382.966f, 5.6868f, 382.166f)
            curveTo(11.6868f, 381.166f, 21.6868f, 374.166f, 23.1868f, 373.666f)
            curveTo(24.3869f, 373.266f, 24.0202f, 373.833f, 23.6868f, 374.166f)
            lineTo(19.6868f, 384.666f)
            curveTo(16.6868f, 392.166f, 10.2868f, 408.566f, 8.6868f, 414.166f)
            curveTo(7.0868f, 419.766f, 10.6868f, 419.166f, 12.6868f, 418.166f)
            lineTo(24.1868f, 395.166f)
            curveTo(25.7868f, 393.166f, 26.1868f, 394.666f, 26.1868f, 395.666f)
            curveTo(22.5201f, 403.166f, 14.6868f, 419.266f, 12.6868f, 423.666f)
            curveTo(10.6868f, 428.066f, 15.5201f, 428.166f, 18.1868f, 427.666f)
            lineTo(30.1868f, 401.166f)
            curveTo(32.5868f, 398.366f, 32.1868f, 400.666f, 31.6868f, 402.166f)
            curveTo(28.8535f, 409.166f, 22.8868f, 423.466f, 21.6868f, 424.666f)
            curveTo(20.1868f, 426.166f, 23.1868f, 431.666f, 26.1868f, 428.666f)
            curveTo(28.5868f, 426.266f, 34.1868f, 411.666f, 36.6868f, 404.666f)
            curveTo(38.2868f, 402.666f, 38.6868f, 403.833f, 38.6868f, 404.666f)
            curveTo(38.8535f, 405f, 38.2868f, 407.666f, 34.6868f, 415.666f)
            curveTo(31.0868f, 423.666f, 35.5201f, 422.666f, 38.1868f, 421.166f)
            curveTo(48.5868f, 407.166f, 53.5201f, 384.666f, 54.6868f, 375.166f)
            lineTo(61.1868f, 357.666f)
            curveTo(61.6868f, 356.333f, 68.1868f, 347.366f, 90.1868f, 322.166f)
            curveTo(112.187f, 296.966f, 119.02f, 271.333f, 119.687f, 261.666f)
            curveTo(126.487f, 256.466f, 132.853f, 234.166f, 135.187f, 223.666f)
            curveTo(134.787f, 226.866f, 147.687f, 252f, 154.187f, 264.166f)
            verticalLineTo(294.666f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(174.687f, 291.666f)
            curveTo(174.287f, 320.066f, 185.52f, 347.5f, 191.187f, 357.666f)
            curveTo(196.387f, 361.666f, 199.353f, 357.666f, 200.187f, 355.166f)
            lineTo(198.687f, 302.666f)
            curveTo(193.887f, 289.466f, 180.687f, 289.833f, 174.687f, 291.666f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(172.687f, 281.166f)
            verticalLineTo(268.166f)
            curveTo(189.887f, 256.966f, 198.187f, 262.5f, 200.187f, 266.666f)
            curveTo(200.687f, 274.166f, 201.387f, 288.866f, 200.187f, 287.666f)
            curveTo(198.987f, 286.466f, 192.02f, 284.5f, 188.687f, 283.666f)
            curveTo(178.287f, 284.066f, 173.687f, 282.166f, 172.687f, 281.166f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(173.687f, 256.666f)
            lineTo(172.687f, 245.666f)
            curveTo(181.087f, 230.066f, 195.187f, 230.833f, 201.187f, 233.166f)
            curveTo(201.187f, 238.366f, 199.52f, 249.666f, 198.687f, 254.666f)
            curveTo(184.287f, 253.066f, 176.02f, 255.333f, 173.687f, 256.666f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(188.687f, 209.166f)
            curveTo(173.887f, 211.966f, 171.853f, 226.333f, 172.687f, 233.166f)
            curveTo(182.287f, 224.766f, 195.02f, 223.666f, 200.187f, 224.166f)
            curveTo(201.02f, 219.833f, 202.187f, 210.766f, 200.187f, 209.166f)
            curveTo(198.187f, 207.566f, 191.687f, 208.5f, 188.687f, 209.166f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(156.687f, 271.166f)
            curveTo(154.687f, 275.966f, 155.854f, 310.333f, 156.687f, 327.666f)
            curveTo(157.887f, 330.066f, 164.854f, 332.333f, 168.187f, 333.166f)
            lineTo(169.687f, 327.666f)
            lineTo(166.187f, 278.666f)
            curveTo(163.854f, 273.666f, 158.687f, 266.366f, 156.687f, 271.166f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(162.687f, 251.666f)
            lineTo(162.187f, 262.666f)
            curveTo(158.987f, 264.266f, 153.187f, 258f, 150.687f, 254.666f)
            curveTo(149.02f, 247.833f, 146.287f, 235.166f, 148.687f, 239.166f)
            curveTo(151.087f, 243.166f, 159.02f, 249.166f, 162.687f, 251.666f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(159.187f, 241.666f)
            lineTo(149.687f, 229.166f)
            verticalLineTo(224.666f)
            curveTo(152.087f, 223.866f, 158.687f, 228.666f, 161.687f, 231.166f)
            curveTo(161.687f, 233.333f, 161.587f, 238.266f, 161.187f, 240.666f)
            curveTo(160.787f, 243.066f, 159.687f, 242.333f, 159.187f, 241.666f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(159.187f, 224.666f)
            lineTo(150.187f, 214.166f)
            curveTo(149.187f, 211.166f, 151.687f, 211.666f, 154.687f, 211.666f)
            curveTo(157.087f, 211.666f, 161.353f, 214f, 163.187f, 215.166f)
            curveTo(163.853f, 216.5f, 165.087f, 219.966f, 164.687f, 223.166f)
            curveTo(164.287f, 226.366f, 160.853f, 225.5f, 159.187f, 224.666f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(163.687f, 210.166f)
            lineTo(149.687f, 200.166f)
            curveTo(148.687f, 196.166f, 152.687f, 197.166f, 155.687f, 197.666f)
            curveTo(158.087f, 198.066f, 164.353f, 200.5f, 167.187f, 201.666f)
            curveTo(168.187f, 201.833f, 169.887f, 203.066f, 168.687f, 206.666f)
            curveTo(167.487f, 210.266f, 164.853f, 210.5f, 163.687f, 210.166f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMajor),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(202.187f, 196.166f)
            curveTo(189.787f, 213.766f, 154.687f, 195.833f, 138.687f, 184.666f)
            curveTo(163.887f, 155.866f, 191.52f, 157.666f, 202.187f, 162.166f)
            verticalLineTo(196.166f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMinor),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(202.187f, 150.666f)
            curveTo(168.587f, 121.466f, 145.02f, 158.666f, 137.687f, 181.166f)
            verticalLineTo(183.166f)
            curveTo(161.287f, 153.566f, 190.353f, 155.5f, 202.187f, 160.166f)
            verticalLineTo(150.666f)
            close()
        }
        path(
            fill = SolidColor(lateralDeltoidFront),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(137.687f, 132.666f)
            curveTo(108.487f, 130.666f, 105.52f, 160.166f, 107.687f, 175.166f)
            lineTo(108.687f, 176.666f)
            curveTo(109.487f, 163.466f, 128.353f, 141.833f, 137.687f, 132.666f)
            close()
        }
        path(
            fill = SolidColor(anteriorDeltoid),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(113.187f, 180.666f)
            curveTo(116.687f, 167.5f, 129.687f, 140.066f, 153.687f, 135.666f)
            curveTo(151.353f, 148.833f, 139.987f, 176.266f, 113.187f, 180.666f)
            close()
        }
        path(
            fill = SolidColor(biceps),
            fillAlpha = 1.0f,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(101.687f, 250.429f)
            curveTo(136.087f, 225.229f, 135.687f, 195.596f, 131.187f, 183.929f)
            curveTo(108.187f, 180.929f, 99.6869f, 204.429f, 99.6869f, 213.429f)
            curveTo(99.6869f, 220.629f, 98.6869f, 231.429f, 98.1869f, 235.929f)
            curveTo(95.3869f, 247.929f, 99.3535f, 250.596f, 101.687f, 250.429f)
            close()
        }
        path(
            fill = SolidColor(forearmFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(66.1869f, 310.929f)
            curveTo(76.5869f, 272.529f, 91.8536f, 258.262f, 98.1869f, 255.929f)
            curveTo(98.9869f, 260.329f, 97.1869f, 269.762f, 96.1869f, 273.929f)
            curveTo(92.0203f, 282.596f, 82.7869f, 300.529f, 79.1869f, 302.929f)
            curveTo(74.6869f, 305.929f, 54.6869f, 342.429f, 53.1869f, 345.429f)
            curveTo(51.9869f, 347.829f, 51.6869f, 346.429f, 51.6869f, 345.429f)
            lineTo(66.1869f, 310.929f)
            close()
        }
        path(
            fill = SolidColor(forearmFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(113.187f, 280.929f)
            verticalLineTo(267.929f)
            curveTo(112.387f, 265.529f, 110.52f, 266.596f, 109.687f, 267.429f)
            curveTo(103.687f, 273.929f, 93.6869f, 285.929f, 91.1869f, 290.929f)
            curveTo(89.1869f, 294.929f, 91.6869f, 294.596f, 93.1869f, 293.929f)
            curveTo(98.0203f, 290.762f, 108.287f, 284.329f, 110.687f, 283.929f)
            curveTo(113.087f, 283.529f, 113.354f, 281.762f, 113.187f, 280.929f)
            close()
        }
        path(
            fill = SolidColor(forearmFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(57.1869f, 346.929f)
            curveTo(59.5869f, 343.729f, 84.8536f, 312.262f, 97.1869f, 296.929f)
            curveTo(97.8536f, 295.929f, 97.1869f, 295.229f, 89.1869f, 300.429f)
            curveTo(81.1869f, 305.629f, 64.5203f, 331.596f, 57.1869f, 343.929f)
            curveTo(56.1869f, 346.262f, 54.7869f, 350.129f, 57.1869f, 346.929f)
            close()
        }
        path(
            fill = SolidColor(forearmFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(61.1869f, 345.429f)
            curveTo(79.1869f, 331.029f, 98.3536f, 305.429f, 105.687f, 294.429f)
            curveTo(107.687f, 293.229f, 106.52f, 296.596f, 105.687f, 298.429f)
            curveTo(93.1869f, 322.429f, 66.1869f, 343.929f, 62.6869f, 345.929f)
            curveTo(59.8869f, 347.529f, 60.5203f, 346.262f, 61.1869f, 345.429f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(40.1869f, 396.166f)
            lineTo(28.1869f, 383.166f)
            curveTo(26.5869f, 381.966f, 26.5202f, 380f, 26.6869f, 379.166f)
            lineTo(33.6869f, 368.166f)
            curveTo(39.5202f, 361.166f, 51.7869f, 349.766f, 54.1869f, 360.166f)
            curveTo(57.1869f, 373.166f, 49.1869f, 388.166f, 47.1869f, 394.166f)
            curveTo(45.5869f, 398.966f, 41.8535f, 397.5f, 40.1869f, 396.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(35.6868f, 362.166f)
            curveTo(18.0868f, 376.166f, 6.6868f, 378.666f, 3.1868f, 378.166f)
            curveTo(2.7868f, 376.966f, 3.6868f, 376.333f, 4.1868f, 376.166f)
            lineTo(31.6868f, 358.166f)
            curveTo(37.6868f, 356.566f, 36.8535f, 360.166f, 35.6868f, 362.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(11.6869f, 410.166f)
            lineTo(22.6869f, 386.166f)
            curveTo(24.0202f, 385.833f, 26.6869f, 385.766f, 26.6869f, 388.166f)
            curveTo(26.6869f, 391.166f, 16.6869f, 408.166f, 14.1869f, 413.666f)
            curveTo(12.1869f, 418.066f, 11.6869f, 413.166f, 11.6869f, 410.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(30.1869f, 398.666f)
            curveTo(31.7869f, 392.666f, 29.1869f, 393.5f, 27.6869f, 394.666f)
            curveTo(26.919f, 395.166f, 17.6869f, 418.166f, 16.6869f, 421.666f)
            curveTo(15.8869f, 424.466f, 18.3536f, 424.833f, 19.6869f, 424.666f)
            curveTo(22.5202f, 418.5f, 28.5869f, 404.666f, 30.1869f, 398.666f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(36.6869f, 403.666f)
            curveTo(37.8869f, 400.866f, 35.5202f, 399.5f, 34.1869f, 399.166f)
            lineTo(32.6869f, 400.166f)
            curveTo(30.1869f, 405.666f, 25.0869f, 417.466f, 24.6869f, 420.666f)
            curveTo(24.2869f, 423.866f, 26.8535f, 423.666f, 28.1869f, 423.166f)
            curveTo(30.5202f, 417.833f, 35.4869f, 406.466f, 36.6869f, 403.666f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(36.6869f, 413.166f)
            lineTo(42.6869f, 401.666f)
            curveTo(45.4869f, 400.066f, 45.5202f, 403.333f, 45.1869f, 405.166f)
            curveTo(44.3536f, 407.333f, 42.0869f, 412.566f, 39.6869f, 416.166f)
            curveTo(37.2869f, 419.766f, 36.6869f, 415.666f, 36.6869f, 413.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(129.187f, 230.666f)
            curveTo(123.987f, 240.666f, 109.687f, 253.833f, 103.187f, 259.166f)
            curveTo(103.187f, 261.966f, 105.52f, 261.333f, 106.687f, 260.666f)
            curveTo(113.02f, 256.5f, 126.387f, 246.366f, 129.187f, 239.166f)
            curveTo(131.987f, 231.966f, 130.354f, 230.5f, 129.187f, 230.666f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(139.187f, 222.166f)
            lineTo(137.687f, 195.666f)
            curveTo(137.187f, 193.333f, 137.087f, 190.066f, 140.687f, 195.666f)
            curveTo(144.287f, 201.266f, 146.187f, 211.666f, 146.687f, 216.166f)
            curveTo(146.687f, 223.166f, 146.187f, 236.666f, 144.187f, 234.666f)
            curveTo(142.187f, 232.666f, 140.02f, 225.5f, 139.187f, 222.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(200.187f, 143.166f)
            lineTo(184.687f, 112.666f)
            curveTo(184.287f, 101.466f, 185.187f, 98.6662f, 185.687f, 98.6662f)
            curveTo(188.487f, 101.466f, 197.854f, 122.166f, 202.187f, 132.166f)
            curveTo(202.587f, 140.166f, 201.02f, 142.833f, 200.187f, 143.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(184.187f, 124.666f)
            lineTo(178.687f, 132.166f)
            curveTo(183.087f, 135.766f, 186.52f, 134.333f, 187.687f, 133.166f)
            lineTo(184.187f, 124.666f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(179.687f, 119.166f)
            lineTo(167.187f, 131.166f)
            curveTo(163.687f, 131.166f, 155.987f, 131.066f, 153.187f, 130.666f)
            curveTo(150.387f, 130.266f, 151.354f, 128.833f, 152.187f, 128.166f)
            curveTo(158.187f, 124.333f, 171.587f, 116.266f, 177.187f, 114.666f)
            curveTo(182.787f, 113.066f, 181.187f, 117f, 179.687f, 119.166f)
            close()
        }
        path(
            fill = SolidColor(otherFront),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(204.5f, 129.5f)
            lineTo(198.687f, 105.666f)
            horizontalLineTo(204.5f)
            verticalLineTo(129.5f)
            close()
        }
    }.build()
}
