package musclepickerpicker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun bodyFront(
    outlineColor: Color = Colors.outline,
    biceps: Color = Colors.defaultFront,
    forearm: Color = Colors.defaultFront,

    lateralDeltoid: Color = Colors.defaultFront,
    anteriorDeltoid: Color = Colors.defaultFront,

    rectusAbdominis: Color = Colors.defaultFront,
    obliquesAbdominis: Color = Colors.defaultFront,

    pectoralisMajor: Color = Colors.defaultFront,
    pectoralisMinor: Color = Colors.defaultFront,

    other: Color = Colors.defaultFront,

    backgroundFront: Color = Colors.backgroundFront
): ImageVector {
    return ImageVector.Builder(
        name = "vector",
        defaultWidth = 411.dp,
        defaultHeight = 431.dp,
        viewportWidth = 411f,
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
            moveTo(265f, 326.943f)
            lineTo(257.187f, 300.709f)
            lineTo(257.687f, 263.709f)
            curveTo(272.687f, 243.709f, 274.687f, 214.709f, 275.187f, 222.709f)
            curveTo(275.587f, 229.109f, 286.02f, 252.042f, 291.187f, 262.709f)
            curveTo(290.787f, 273.109f, 300.687f, 293.376f, 305.687f, 302.209f)
            curveTo(314.687f, 314.042f, 334.087f, 339.109f, 339.687f, 344.709f)
            curveTo(346.687f, 351.709f, 354.687f, 368.709f, 355.687f, 375.709f)
            curveTo(353.374f, 379.918f, 371f, 418.709f, 373.187f, 422.209f)
            curveTo(374.936f, 425.009f, 377.791f, 422.236f, 379f, 420.5f)
            lineTo(373.187f, 404f)
            lineTo(383.687f, 426.209f)
            curveTo(387.687f, 430.209f, 389.687f, 426.542f, 390.187f, 424.209f)
            lineTo(381.5f, 404f)
            lineTo(392.187f, 426.709f)
            curveTo(397.387f, 430.309f, 398.353f, 425.209f, 398.187f, 422.209f)
            lineTo(384.187f, 391.209f)
            curveTo(387.687f, 399.709f, 395.587f, 417.109f, 399.187f, 418.709f)
            curveTo(402.787f, 420.309f, 403.02f, 416.709f, 402.687f, 414.709f)
            lineTo(388.187f, 374.209f)
            curveTo(391.853f, 376.709f, 400.487f, 381.709f, 405.687f, 381.709f)
            curveTo(410.887f, 381.709f, 410.52f, 377.709f, 409.687f, 375.709f)
            curveTo(405.853f, 374.376f, 396.687f, 370.009f, 390.687f, 363.209f)
            curveTo(384.687f, 356.409f, 376.52f, 354.376f, 373.187f, 354.209f)
            curveTo(363.187f, 345.409f, 354.353f, 323.542f, 351.187f, 313.709f)
            curveTo(347.987f, 292.109f, 328.187f, 261.709f, 318.687f, 249.209f)
            curveTo(321.487f, 231.209f, 312.52f, 203.376f, 307.687f, 191.709f)
            verticalLineTo(156.709f)
            curveTo(301.187f, 123.709f, 259.687f, 124.209f, 257.187f, 124.209f)
            curveTo(254.687f, 124.209f, 238.187f, 112.709f, 233.187f, 107.209f)
            curveTo(229.187f, 102.809f, 229.52f, 97.3757f, 230.187f, 95.209f)
            lineTo(234.187f, 89.709f)
            lineTo(235.687f, 82.209f)
            lineTo(236.187f, 74.709f)
            curveTo(237.387f, 75.109f, 238.02f, 74.209f, 238.187f, 73.709f)
            curveTo(239.52f, 69.5424f, 242.487f, 60.609f, 243.687f, 58.209f)
            curveTo(244.887f, 55.809f, 240.853f, 53.5424f, 238.687f, 52.709f)
            curveTo(243.187f, 15.709f, 220.187f, -6.291f, 194.187f, 3.209f)
            curveTo(173.387f, 10.809f, 170.853f, 40.0424f, 172.187f, 53.709f)
            curveTo(166.987f, 54.909f, 166.353f, 56.5424f, 166.687f, 57.209f)
            curveTo(167.52f, 59.709f, 169.587f, 65.909f, 171.187f, 70.709f)
            curveTo(172.787f, 75.509f, 174.52f, 76.0424f, 175.187f, 75.709f)
            lineTo(176.687f, 89.709f)
            lineTo(182.187f, 95.209f)
            curveTo(183.02f, 97.5424f, 183.787f, 103.209f, 180.187f, 107.209f)
            curveTo(176.587f, 111.209f, 160.687f, 120.209f, 153.187f, 124.209f)
            curveTo(116.387f, 126.209f, 104.52f, 146.376f, 103.187f, 156.209f)
            verticalLineTo(191.709f)
            curveTo(96.3868f, 198.909f, 93.0202f, 234.042f, 92.1868f, 250.709f)
            curveTo(90.3535f, 253.209f, 84.7868f, 260.709f, 77.1868f, 270.709f)
            curveTo(67.6868f, 283.209f, 65.1868f, 296.209f, 59.1868f, 316.209f)
            curveTo(54.3868f, 332.209f, 42.1868f, 349.209f, 36.6868f, 355.709f)
            curveTo(33.4868f, 355.309f, 30.0201f, 356.209f, 28.6868f, 356.709f)
            lineTo(1.18684f, 375.709f)
            curveTo(0.6868f, 378.209f, 0.8868f, 383.009f, 5.6868f, 382.209f)
            curveTo(11.6868f, 381.209f, 21.6868f, 374.209f, 23.1868f, 373.709f)
            curveTo(24.3869f, 373.309f, 24.0202f, 373.876f, 23.6868f, 374.209f)
            lineTo(19.6868f, 384.709f)
            curveTo(16.6868f, 392.209f, 10.2868f, 408.609f, 8.6868f, 414.209f)
            curveTo(7.0868f, 419.809f, 10.6868f, 419.209f, 12.6868f, 418.209f)
            lineTo(24.1868f, 395.209f)
            curveTo(25.7868f, 393.209f, 26.1868f, 394.709f, 26.1868f, 395.709f)
            curveTo(22.5201f, 403.209f, 14.6868f, 419.309f, 12.6868f, 423.709f)
            curveTo(10.6868f, 428.109f, 15.5201f, 428.209f, 18.1868f, 427.709f)
            lineTo(30.1868f, 401.209f)
            curveTo(32.5868f, 398.409f, 32.1868f, 400.709f, 31.6868f, 402.209f)
            curveTo(28.8535f, 409.209f, 22.8868f, 423.509f, 21.6868f, 424.709f)
            curveTo(20.1868f, 426.209f, 23.1868f, 431.709f, 26.1868f, 428.709f)
            curveTo(28.5868f, 426.309f, 34.1868f, 411.709f, 36.6868f, 404.709f)
            curveTo(38.2868f, 402.709f, 38.6868f, 403.876f, 38.6868f, 404.709f)
            curveTo(38.8534f, 405.042f, 38.2868f, 407.709f, 34.6868f, 415.709f)
            curveTo(31.0868f, 423.709f, 35.5201f, 422.709f, 38.1868f, 421.209f)
            curveTo(48.5868f, 407.209f, 53.5201f, 384.709f, 54.6868f, 375.209f)
            lineTo(61.1868f, 357.709f)
            curveTo(61.6868f, 356.376f, 68.1868f, 347.409f, 90.1868f, 322.209f)
            curveTo(112.187f, 297.009f, 119.02f, 271.376f, 119.687f, 261.709f)
            curveTo(126.487f, 256.509f, 132.853f, 234.209f, 135.187f, 223.709f)
            curveTo(134.787f, 226.909f, 147.687f, 252.042f, 154.187f, 264.209f)
            curveTo(154.187f, 270.709f, 154.187f, 285.909f, 154.187f, 294.709f)
            curveTo(154.187f, 303.509f, 149.187f, 318.042f, 146.687f, 324.209f)
            curveTo(158.125f, 335.798f, 181.5f, 361.922f, 183.5f, 373.709f)
            curveTo(190.333f, 377.209f, 208.5f, 382.109f, 226.5f, 373.709f)
            curveTo(235.396f, 359.376f, 256.2f, 333.743f, 265f, 326.943f)
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
            moveTo(174.687f, 291.709f)
            curveTo(174.287f, 320.109f, 185.52f, 347.542f, 191.187f, 357.709f)
            curveTo(196.387f, 361.709f, 199.354f, 357.709f, 200.187f, 355.209f)
            lineTo(198.687f, 302.709f)
            curveTo(193.887f, 289.509f, 180.687f, 289.876f, 174.687f, 291.709f)
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
            moveTo(172.687f, 281.209f)
            verticalLineTo(268.209f)
            curveTo(189.887f, 257.009f, 198.187f, 262.542f, 200.187f, 266.709f)
            curveTo(200.687f, 274.209f, 201.387f, 288.909f, 200.187f, 287.709f)
            curveTo(198.987f, 286.509f, 192.02f, 284.542f, 188.687f, 283.709f)
            curveTo(178.287f, 284.109f, 173.687f, 282.209f, 172.687f, 281.209f)
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
            moveTo(173.687f, 256.709f)
            lineTo(172.687f, 245.709f)
            curveTo(181.087f, 230.109f, 195.187f, 230.876f, 201.187f, 233.209f)
            curveTo(201.187f, 238.409f, 199.52f, 249.709f, 198.687f, 254.709f)
            curveTo(184.287f, 253.109f, 176.02f, 255.376f, 173.687f, 256.709f)
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
            moveTo(188.687f, 209.209f)
            curveTo(173.887f, 212.009f, 171.854f, 226.376f, 172.687f, 233.209f)
            curveTo(182.287f, 224.809f, 195.02f, 223.709f, 200.187f, 224.209f)
            curveTo(201.02f, 219.876f, 202.187f, 210.809f, 200.187f, 209.209f)
            curveTo(198.187f, 207.609f, 191.687f, 208.542f, 188.687f, 209.209f)
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
            moveTo(156.687f, 271.209f)
            curveTo(154.687f, 276.009f, 155.854f, 310.376f, 156.687f, 327.709f)
            curveTo(157.887f, 330.109f, 164.854f, 332.376f, 168.187f, 333.209f)
            lineTo(169.687f, 327.709f)
            lineTo(166.187f, 278.709f)
            curveTo(163.854f, 273.709f, 158.687f, 266.409f, 156.687f, 271.209f)
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
            moveTo(162.687f, 251.709f)
            lineTo(162.187f, 262.709f)
            curveTo(158.987f, 264.309f, 153.187f, 258.042f, 150.687f, 254.709f)
            curveTo(149.02f, 247.876f, 146.287f, 235.209f, 148.687f, 239.209f)
            curveTo(151.087f, 243.209f, 159.02f, 249.209f, 162.687f, 251.709f)
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
            moveTo(159.187f, 241.709f)
            lineTo(149.687f, 229.209f)
            verticalLineTo(224.709f)
            curveTo(152.087f, 223.909f, 158.687f, 228.709f, 161.687f, 231.209f)
            curveTo(161.687f, 233.376f, 161.587f, 238.309f, 161.187f, 240.709f)
            curveTo(160.787f, 243.109f, 159.687f, 242.376f, 159.187f, 241.709f)
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
            moveTo(159.187f, 224.709f)
            lineTo(150.187f, 214.209f)
            curveTo(149.187f, 211.209f, 151.687f, 211.709f, 154.687f, 211.709f)
            curveTo(157.087f, 211.709f, 161.353f, 214.042f, 163.187f, 215.209f)
            curveTo(163.853f, 216.542f, 165.087f, 220.009f, 164.687f, 223.209f)
            curveTo(164.287f, 226.409f, 160.853f, 225.542f, 159.187f, 224.709f)
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
            moveTo(163.687f, 210.209f)
            lineTo(149.687f, 200.209f)
            curveTo(148.687f, 196.209f, 152.687f, 197.209f, 155.687f, 197.709f)
            curveTo(158.087f, 198.109f, 164.353f, 200.542f, 167.187f, 201.709f)
            curveTo(168.187f, 201.876f, 169.887f, 203.109f, 168.687f, 206.709f)
            curveTo(167.487f, 210.309f, 164.853f, 210.542f, 163.687f, 210.209f)
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
            moveTo(237.291f, 292.197f)
            curveTo(237.691f, 320.597f, 226.458f, 348.031f, 220.791f, 358.197f)
            curveTo(215.591f, 362.197f, 212.624f, 358.197f, 211.791f, 355.697f)
            lineTo(213.291f, 303.197f)
            curveTo(218.091f, 289.997f, 231.291f, 290.364f, 237.291f, 292.197f)
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
            moveTo(239.291f, 281.697f)
            verticalLineTo(268.697f)
            curveTo(222.091f, 257.497f, 213.791f, 263.031f, 211.791f, 267.197f)
            curveTo(211.291f, 274.697f, 210.591f, 289.397f, 211.791f, 288.197f)
            curveTo(212.991f, 286.997f, 219.958f, 285.031f, 223.291f, 284.197f)
            curveTo(233.691f, 284.597f, 238.291f, 282.697f, 239.291f, 281.697f)
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
            moveTo(238.291f, 257.197f)
            lineTo(239.291f, 246.197f)
            curveTo(230.891f, 230.597f, 216.791f, 231.364f, 210.791f, 233.697f)
            curveTo(210.791f, 238.897f, 212.458f, 250.197f, 213.291f, 255.197f)
            curveTo(227.691f, 253.597f, 235.958f, 255.864f, 238.291f, 257.197f)
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
            moveTo(223.291f, 209.697f)
            curveTo(238.091f, 212.497f, 240.124f, 226.864f, 239.291f, 233.697f)
            curveTo(229.691f, 225.297f, 216.958f, 224.197f, 211.791f, 224.697f)
            curveTo(210.958f, 220.364f, 209.791f, 211.297f, 211.791f, 209.697f)
            curveTo(213.791f, 208.097f, 220.291f, 209.031f, 223.291f, 209.697f)
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
            moveTo(255.291f, 271.697f)
            curveTo(257.291f, 276.497f, 256.124f, 310.864f, 255.291f, 328.197f)
            curveTo(254.091f, 330.597f, 247.124f, 332.864f, 243.791f, 333.697f)
            lineTo(242.291f, 328.197f)
            lineTo(245.791f, 279.197f)
            curveTo(248.124f, 274.197f, 253.291f, 266.897f, 255.291f, 271.697f)
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
            moveTo(249.291f, 252.197f)
            lineTo(249.791f, 263.197f)
            curveTo(252.991f, 264.797f, 258.791f, 258.531f, 261.291f, 255.197f)
            curveTo(262.958f, 248.364f, 265.691f, 235.697f, 263.291f, 239.697f)
            curveTo(260.891f, 243.697f, 252.958f, 249.697f, 249.291f, 252.197f)
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
            moveTo(252.791f, 242.197f)
            lineTo(262.291f, 229.697f)
            verticalLineTo(225.197f)
            curveTo(259.891f, 224.397f, 253.291f, 229.197f, 250.291f, 231.697f)
            curveTo(250.291f, 233.864f, 250.391f, 238.797f, 250.791f, 241.197f)
            curveTo(251.191f, 243.597f, 252.291f, 242.864f, 252.791f, 242.197f)
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
            moveTo(252.791f, 225.197f)
            lineTo(261.791f, 214.697f)
            curveTo(262.791f, 211.697f, 260.291f, 212.197f, 257.291f, 212.197f)
            curveTo(254.891f, 212.197f, 250.624f, 214.531f, 248.791f, 215.697f)
            curveTo(248.124f, 217.031f, 246.891f, 220.497f, 247.291f, 223.697f)
            curveTo(247.691f, 226.897f, 251.124f, 226.031f, 252.791f, 225.197f)
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
            moveTo(248.291f, 210.697f)
            lineTo(262.291f, 200.697f)
            curveTo(263.291f, 196.697f, 259.291f, 197.697f, 256.291f, 198.197f)
            curveTo(253.891f, 198.597f, 247.624f, 201.031f, 244.791f, 202.197f)
            curveTo(243.791f, 202.364f, 242.091f, 203.597f, 243.291f, 207.197f)
            curveTo(244.491f, 210.797f, 247.124f, 211.031f, 248.291f, 210.697f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(202.187f, 196.209f)
            curveTo(189.787f, 213.809f, 154.687f, 195.876f, 138.687f, 184.709f)
            curveTo(163.887f, 155.909f, 191.52f, 157.709f, 202.187f, 162.209f)
            verticalLineTo(196.209f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMinor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(202.187f, 150.709f)
            curveTo(168.587f, 121.509f, 145.02f, 158.709f, 137.687f, 181.209f)
            verticalLineTo(183.209f)
            curveTo(161.287f, 153.609f, 190.353f, 155.542f, 202.187f, 160.209f)
            verticalLineTo(150.709f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(207.687f, 195.945f)
            curveTo(220.087f, 213.545f, 255.187f, 195.612f, 271.187f, 184.445f)
            curveTo(245.987f, 155.645f, 218.353f, 157.445f, 207.687f, 161.945f)
            verticalLineTo(195.945f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMinor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(207.687f, 150.445f)
            curveTo(241.287f, 121.245f, 264.853f, 158.445f, 272.187f, 180.945f)
            verticalLineTo(182.945f)
            curveTo(248.587f, 153.345f, 219.52f, 155.278f, 207.687f, 159.945f)
            verticalLineTo(150.445f)
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
            moveTo(137.687f, 132.709f)
            curveTo(108.487f, 130.709f, 105.52f, 160.209f, 107.687f, 175.209f)
            lineTo(108.687f, 176.709f)
            curveTo(109.487f, 163.509f, 128.353f, 141.876f, 137.687f, 132.709f)
            close()
        }
        path(
            fill = SolidColor(anteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(113.187f, 180.709f)
            curveTo(116.687f, 167.542f, 129.687f, 140.109f, 153.687f, 135.709f)
            curveTo(151.353f, 148.876f, 139.987f, 176.309f, 113.187f, 180.709f)
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
            moveTo(273.687f, 132.806f)
            curveTo(302.887f, 130.806f, 305.853f, 160.306f, 303.687f, 175.306f)
            lineTo(302.687f, 176.806f)
            curveTo(301.887f, 163.606f, 283.02f, 141.972f, 273.687f, 132.806f)
            close()
        }
        path(
            fill = SolidColor(anteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(298.187f, 180.806f)
            curveTo(294.687f, 167.639f, 281.687f, 140.206f, 257.687f, 135.806f)
            curveTo(260.02f, 148.972f, 271.387f, 176.406f, 298.187f, 180.806f)
            close()
        }
        path(
            fill = SolidColor(biceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(311.187f, 251.209f)
            curveTo(276.787f, 226.009f, 277.187f, 196.376f, 281.687f, 184.709f)
            curveTo(304.687f, 181.709f, 313.187f, 205.209f, 313.187f, 214.209f)
            curveTo(313.187f, 221.409f, 314.187f, 232.209f, 314.687f, 236.709f)
            curveTo(317.487f, 248.709f, 313.52f, 251.376f, 311.187f, 251.209f)
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
            moveTo(346.687f, 311.709f)
            curveTo(336.287f, 273.309f, 321.02f, 259.042f, 314.687f, 256.709f)
            curveTo(313.887f, 261.109f, 315.687f, 270.542f, 316.687f, 274.709f)
            curveTo(320.854f, 283.376f, 330.087f, 301.309f, 333.687f, 303.709f)
            curveTo(338.187f, 306.709f, 358.187f, 343.209f, 359.687f, 346.209f)
            curveTo(360.887f, 348.609f, 361.187f, 347.209f, 361.187f, 346.209f)
            lineTo(346.687f, 311.709f)
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
            moveTo(299.687f, 281.709f)
            verticalLineTo(268.709f)
            curveTo(300.487f, 266.309f, 302.354f, 267.376f, 303.187f, 268.209f)
            curveTo(309.187f, 274.709f, 319.187f, 286.709f, 321.687f, 291.709f)
            curveTo(323.687f, 295.709f, 321.187f, 295.376f, 319.687f, 294.709f)
            curveTo(314.854f, 291.542f, 304.587f, 285.109f, 302.187f, 284.709f)
            curveTo(299.787f, 284.309f, 299.52f, 282.542f, 299.687f, 281.709f)
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
            moveTo(355.687f, 347.709f)
            curveTo(353.287f, 344.509f, 328.02f, 313.042f, 315.687f, 297.709f)
            curveTo(315.02f, 296.709f, 315.687f, 296.009f, 323.687f, 301.209f)
            curveTo(331.687f, 306.409f, 348.354f, 332.376f, 355.687f, 344.709f)
            curveTo(356.687f, 347.042f, 358.087f, 350.909f, 355.687f, 347.709f)
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
            moveTo(351.687f, 346.209f)
            curveTo(333.687f, 331.809f, 314.52f, 306.209f, 307.187f, 295.209f)
            curveTo(305.187f, 294.009f, 306.354f, 297.376f, 307.187f, 299.209f)
            curveTo(319.687f, 323.209f, 346.687f, 344.709f, 350.187f, 346.709f)
            curveTo(352.987f, 348.309f, 352.354f, 347.042f, 351.687f, 346.209f)
            close()
        }
        path(
            fill = SolidColor(biceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(101.687f, 250.472f)
            curveTo(136.087f, 225.272f, 135.687f, 195.638f, 131.187f, 183.972f)
            curveTo(108.187f, 180.972f, 99.6869f, 204.472f, 99.6869f, 213.472f)
            curveTo(99.6869f, 220.672f, 98.6869f, 231.472f, 98.1869f, 235.972f)
            curveTo(95.3869f, 247.972f, 99.3535f, 250.638f, 101.687f, 250.472f)
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
            moveTo(66.1869f, 310.972f)
            curveTo(76.5869f, 272.572f, 91.8536f, 258.305f, 98.1869f, 255.972f)
            curveTo(98.9869f, 260.372f, 97.1869f, 269.805f, 96.1869f, 273.972f)
            curveTo(92.0203f, 282.638f, 82.7869f, 300.572f, 79.1869f, 302.972f)
            curveTo(74.6869f, 305.972f, 54.6869f, 342.472f, 53.1869f, 345.472f)
            curveTo(51.9869f, 347.872f, 51.6869f, 346.472f, 51.6869f, 345.472f)
            lineTo(66.1869f, 310.972f)
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
            moveTo(113.187f, 280.972f)
            verticalLineTo(267.972f)
            curveTo(112.387f, 265.572f, 110.52f, 266.638f, 109.687f, 267.472f)
            curveTo(103.687f, 273.972f, 93.6869f, 285.972f, 91.1869f, 290.972f)
            curveTo(89.1869f, 294.972f, 91.6869f, 294.638f, 93.1869f, 293.972f)
            curveTo(98.0203f, 290.805f, 108.287f, 284.372f, 110.687f, 283.972f)
            curveTo(113.087f, 283.572f, 113.354f, 281.805f, 113.187f, 280.972f)
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
            moveTo(57.1869f, 346.972f)
            curveTo(59.5869f, 343.772f, 84.8536f, 312.305f, 97.1869f, 296.972f)
            curveTo(97.8536f, 295.972f, 97.1869f, 295.272f, 89.1869f, 300.472f)
            curveTo(81.1869f, 305.672f, 64.5203f, 331.638f, 57.1869f, 343.972f)
            curveTo(56.1869f, 346.305f, 54.7869f, 350.172f, 57.1869f, 346.972f)
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
            moveTo(61.1869f, 345.472f)
            curveTo(79.1869f, 331.072f, 98.3536f, 305.472f, 105.687f, 294.472f)
            curveTo(107.687f, 293.272f, 106.52f, 296.638f, 105.687f, 298.472f)
            curveTo(93.1869f, 322.472f, 66.1869f, 343.972f, 62.6869f, 345.972f)
            curveTo(59.8869f, 347.572f, 60.5203f, 346.305f, 61.1869f, 345.472f)
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
            moveTo(40.1869f, 396.209f)
            lineTo(28.1869f, 383.209f)
            curveTo(26.5869f, 382.009f, 26.5202f, 380.043f, 26.6869f, 379.209f)
            lineTo(33.6869f, 368.209f)
            curveTo(39.5202f, 361.209f, 51.7869f, 349.809f, 54.1869f, 360.209f)
            curveTo(57.1869f, 373.209f, 49.1869f, 388.209f, 47.1869f, 394.209f)
            curveTo(45.5869f, 399.009f, 41.8535f, 397.543f, 40.1869f, 396.209f)
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
            moveTo(35.6868f, 362.209f)
            curveTo(18.0868f, 376.209f, 6.6868f, 378.709f, 3.1868f, 378.209f)
            curveTo(2.7868f, 377.009f, 3.6868f, 376.376f, 4.1868f, 376.209f)
            lineTo(31.6868f, 358.209f)
            curveTo(37.6868f, 356.609f, 36.8535f, 360.209f, 35.6868f, 362.209f)
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
            moveTo(11.6869f, 410.209f)
            lineTo(22.6869f, 386.209f)
            curveTo(24.0202f, 385.876f, 26.6869f, 385.809f, 26.6869f, 388.209f)
            curveTo(26.6869f, 391.209f, 16.6869f, 408.209f, 14.1869f, 413.709f)
            curveTo(12.1869f, 418.109f, 11.6869f, 413.209f, 11.6869f, 410.209f)
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
            moveTo(30.1869f, 398.709f)
            curveTo(31.7869f, 392.709f, 29.1869f, 393.543f, 27.6869f, 394.709f)
            curveTo(26.919f, 395.209f, 17.6869f, 418.209f, 16.6869f, 421.709f)
            curveTo(15.8869f, 424.509f, 18.3536f, 424.876f, 19.6869f, 424.709f)
            curveTo(22.5202f, 418.543f, 28.5869f, 404.709f, 30.1869f, 398.709f)
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
            moveTo(36.6869f, 403.709f)
            curveTo(37.8869f, 400.909f, 35.5202f, 399.543f, 34.1869f, 399.209f)
            lineTo(32.6869f, 400.209f)
            curveTo(30.1869f, 405.709f, 25.0869f, 417.509f, 24.6869f, 420.709f)
            curveTo(24.2869f, 423.909f, 26.8535f, 423.709f, 28.1869f, 423.209f)
            curveTo(30.5202f, 417.876f, 35.4869f, 406.509f, 36.6869f, 403.709f)
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
            moveTo(36.6869f, 413.209f)
            lineTo(42.6869f, 401.709f)
            curveTo(45.4869f, 400.109f, 45.5202f, 403.376f, 45.1869f, 405.209f)
            curveTo(44.3536f, 407.376f, 42.0869f, 412.609f, 39.6869f, 416.209f)
            curveTo(37.2869f, 419.809f, 36.6869f, 415.709f, 36.6869f, 413.209f)
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
            moveTo(129.187f, 230.709f)
            curveTo(123.987f, 240.709f, 109.687f, 253.876f, 103.187f, 259.209f)
            curveTo(103.187f, 262.009f, 105.52f, 261.376f, 106.687f, 260.709f)
            curveTo(113.02f, 256.542f, 126.387f, 246.409f, 129.187f, 239.209f)
            curveTo(131.987f, 232.009f, 130.354f, 230.542f, 129.187f, 230.709f)
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
            moveTo(372.352f, 396.896f)
            lineTo(384.352f, 383.896f)
            curveTo(385.952f, 382.696f, 386.019f, 380.729f, 385.852f, 379.896f)
            lineTo(378.852f, 368.896f)
            curveTo(373.019f, 361.896f, 360.752f, 350.496f, 358.352f, 360.896f)
            curveTo(355.352f, 373.896f, 363.352f, 388.896f, 365.352f, 394.896f)
            curveTo(366.952f, 399.696f, 370.686f, 398.229f, 372.352f, 396.896f)
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
            moveTo(376.852f, 362.896f)
            curveTo(394.452f, 376.896f, 405.852f, 379.396f, 409.352f, 378.896f)
            curveTo(409.752f, 377.696f, 408.852f, 377.063f, 408.352f, 376.896f)
            lineTo(380.852f, 358.896f)
            curveTo(374.852f, 357.296f, 375.686f, 360.896f, 376.852f, 362.896f)
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
            moveTo(400.852f, 410.896f)
            lineTo(389.852f, 386.896f)
            curveTo(388.519f, 386.563f, 385.852f, 386.496f, 385.852f, 388.896f)
            curveTo(385.852f, 391.896f, 395.852f, 408.896f, 398.352f, 414.396f)
            curveTo(400.352f, 418.796f, 400.852f, 413.896f, 400.852f, 410.896f)
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
            moveTo(382.352f, 399.396f)
            curveTo(380.752f, 393.396f, 383.352f, 394.229f, 384.852f, 395.396f)
            curveTo(385.62f, 395.896f, 394.852f, 418.896f, 395.852f, 422.396f)
            curveTo(396.652f, 425.196f, 394.186f, 425.563f, 392.852f, 425.396f)
            curveTo(390.019f, 419.229f, 383.952f, 405.396f, 382.352f, 399.396f)
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
            moveTo(375.852f, 404.396f)
            curveTo(374.652f, 401.596f, 377.019f, 400.229f, 378.352f, 399.896f)
            lineTo(379.852f, 400.896f)
            curveTo(382.352f, 406.396f, 387.452f, 418.196f, 387.852f, 421.396f)
            curveTo(388.252f, 424.596f, 385.686f, 424.396f, 384.352f, 423.896f)
            curveTo(382.019f, 418.563f, 377.052f, 407.196f, 375.852f, 404.396f)
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
            moveTo(375.852f, 413.896f)
            lineTo(369.852f, 402.396f)
            curveTo(367.052f, 400.796f, 367.019f, 404.063f, 367.352f, 405.896f)
            curveTo(368.186f, 408.063f, 370.452f, 413.296f, 372.852f, 416.896f)
            curveTo(375.252f, 420.496f, 375.852f, 416.396f, 375.852f, 413.896f)
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
            moveTo(308.187f, 259.209f)
            curveTo(301.387f, 255.609f, 288.687f, 239.042f, 283.187f, 231.209f)
            curveTo(279.987f, 228.009f, 280.52f, 233.209f, 281.187f, 236.209f)
            curveTo(283.987f, 243.809f, 298.687f, 255.709f, 305.687f, 260.709f)
            curveTo(308.487f, 261.909f, 308.52f, 260.209f, 308.187f, 259.209f)
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
            moveTo(139.187f, 222.209f)
            lineTo(137.687f, 195.709f)
            curveTo(137.187f, 193.376f, 137.087f, 190.109f, 140.687f, 195.709f)
            curveTo(144.287f, 201.309f, 146.187f, 211.709f, 146.687f, 216.209f)
            curveTo(146.687f, 223.209f, 146.187f, 236.709f, 144.187f, 234.709f)
            curveTo(142.187f, 232.709f, 140.02f, 225.542f, 139.187f, 222.209f)
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
            moveTo(200.187f, 143.209f)
            lineTo(184.687f, 112.709f)
            curveTo(184.287f, 101.509f, 185.187f, 98.709f, 185.687f, 98.709f)
            curveTo(188.487f, 101.509f, 197.854f, 122.209f, 202.187f, 132.209f)
            curveTo(202.587f, 140.209f, 201.02f, 142.876f, 200.187f, 143.209f)
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
            moveTo(184.187f, 124.709f)
            lineTo(178.687f, 132.209f)
            curveTo(183.087f, 135.809f, 186.52f, 134.376f, 187.687f, 133.209f)
            lineTo(184.187f, 124.709f)
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
            moveTo(179.687f, 119.209f)
            lineTo(167.187f, 131.209f)
            curveTo(163.687f, 131.209f, 155.987f, 131.109f, 153.187f, 130.709f)
            curveTo(150.387f, 130.309f, 151.354f, 128.876f, 152.187f, 128.209f)
            curveTo(158.187f, 124.376f, 171.587f, 116.309f, 177.187f, 114.709f)
            curveTo(182.787f, 113.109f, 181.187f, 117.042f, 179.687f, 119.209f)
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
            moveTo(206.187f, 129.709f)
            lineTo(198.687f, 105.709f)
            horizontalLineTo(214.687f)
            lineTo(206.187f, 129.709f)
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
            moveTo(209.187f, 132.209f)
            curveTo(210.387f, 128.209f, 220.83f, 108.209f, 225.901f, 98.709f)
            curveTo(227.272f, 97.509f, 226.33f, 108.876f, 225.687f, 114.709f)
            lineTo(209.687f, 143.209f)
            curveTo(209.02f, 141.209f, 207.987f, 136.209f, 209.187f, 132.209f)
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
            moveTo(221.687f, 133.209f)
            lineTo(226.187f, 124.709f)
            curveTo(229.387f, 127.109f, 230.52f, 131.376f, 230.687f, 133.209f)
            curveTo(229.087f, 135.209f, 224.02f, 134.042f, 221.687f, 133.209f)
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
            moveTo(241.687f, 130.209f)
            lineTo(228.687f, 118.209f)
            curveTo(227.487f, 113.009f, 232.52f, 114.376f, 235.187f, 115.709f)
            curveTo(243.52f, 119.542f, 259.842f, 127.709f, 258.464f, 129.709f)
            curveTo(257.087f, 131.709f, 246.705f, 130.876f, 241.687f, 130.209f)
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
            moveTo(265.687f, 232.709f)
            verticalLineTo(211.709f)
            lineTo(274.687f, 191.709f)
            lineTo(274.187f, 213.209f)
            curveTo(273.854f, 216.709f, 272.587f, 225.409f, 270.187f, 232.209f)
            curveTo(267.787f, 239.009f, 266.187f, 235.376f, 265.687f, 232.709f)
            close()
        }
    }.build()
}