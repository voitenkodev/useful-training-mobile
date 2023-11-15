package icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

internal val Legs: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 301.dp,
            defaultHeight = 452.dp,
            viewportWidth = 301f,
            viewportHeight = 452f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFA6A6A6)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(31.9568f, 419f)
                lineTo(34.9568f, 406.5f)
                lineTo(33.9568f, 377f)
                curveTo(30.4568f, 356.333f, 22.4568f, 319f, 14.4568f, 303f)
                curveTo(7.0898f, 288.266f, 12.1235f, 242.667f, 16.4568f, 224.5f)
                lineTo(12.4568f, 193f)
                curveTo(-6.7432f, 137.4f, 2.4568f, 43.1667f, 9.4568f, 3f)
                lineTo(126.957f, 1f)
                curveTo(128.957f, 9.3333f, 133.557f, 39.1f, 135.957f, 91.5f)
                curveTo(138.357f, 143.9f, 128.957f, 184f, 123.957f, 197.5f)
                curveTo(119.157f, 221.1f, 120.29f, 231.667f, 121.457f, 234f)
                curveTo(129.857f, 256.4f, 126.623f, 284f, 123.957f, 295f)
                curveTo(121.123f, 304.5f, 115.257f, 323.8f, 114.457f, 325f)
                curveTo(113.457f, 326.5f, 103.957f, 376.5f, 101.957f, 380f)
                curveTo(100.357f, 382.8f, 101.29f, 394.5f, 101.957f, 400f)
                lineTo(102.957f, 406.5f)
                lineTo(103.957f, 416f)
                lineTo(121.457f, 440f)
                lineTo(126.457f, 445f)
                verticalLineTo(448.5f)
                lineTo(122.957f, 450.079f)
                lineTo(86.4568f, 451f)
                lineTo(80.4568f, 445f)
                lineTo(81.4568f, 431f)
                lineTo(82.9568f, 416f)
                curveTo(83.7901f, 405.667f, 84.9568f, 381.5f, 82.9568f, 367.5f)
                curveTo(80.4568f, 350f, 76.4568f, 304.5f, 75.4568f, 295f)
                curveTo(74.6568f, 287.4f, 81.7901f, 248.5f, 85.4568f, 230f)
                curveTo(85.6235f, 223.333f, 85.8568f, 209.7f, 85.4568f, 208.5f)
                curveTo(85.0568f, 207.3f, 78.2901f, 150.333f, 74.9568f, 122f)
                curveTo(73.7901f, 106f, 70.6568f, 75.1f, 67.4568f, 79.5f)
                curveTo(64.2568f, 83.9f, 57.7901f, 152.667f, 54.9568f, 186.5f)
                curveTo(49.3568f, 200.5f, 50.6235f, 222.667f, 51.9568f, 232f)
                curveTo(60.3568f, 265.2f, 61.7901f, 293.167f, 61.4568f, 303f)
                curveTo(60.1235f, 318.333f, 56.8568f, 349.8f, 54.4568f, 353f)
                curveTo(52.0568f, 356.2f, 53.4568f, 378.667f, 54.4568f, 389.5f)
                verticalLineTo(419f)
                lineTo(57.4568f, 442f)
                lineTo(54.4568f, 449f)
                curveTo(51.9568f, 449.5f, 43.4568f, 450f, 37.4568f, 450f)
                curveTo(14.2258f, 450f, 12.4568f, 447.167f, 14.4568f, 445f)
                lineTo(31.9568f, 419f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(40.9568f, 433f)
                lineTo(31.9568f, 425f)
                curveTo(26.1234f, 431.333f, 14.9568f, 444.5f, 16.9568f, 446.5f)
                curveTo(18.9568f, 448.5f, 32.1234f, 448.333f, 38.4568f, 448f)
                lineTo(40.9568f, 433f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(42.4568f, 448f)
                lineTo(43.4568f, 437f)
                curveTo(44.2568f, 433.8f, 46.4568f, 435.667f, 47.4568f, 437f)
                lineTo(50.9568f, 442f)
                verticalLineTo(448f)
                horizontalLineTo(42.4568f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(86.4568f, 440.5f)
                verticalLineTo(446.5f)
                verticalLineTo(448f)
                horizontalLineTo(93.9568f)
                verticalLineTo(438.5f)
                curveTo(91.5568f, 430.9f, 87.9568f, 436.667f, 86.4568f, 440.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(98.4568f, 448f)
                curveTo(97.2568f, 445.2f, 96.6235f, 436.833f, 96.4568f, 433f)
                verticalLineTo(432f)
                lineTo(105.957f, 425f)
                curveTo(120.357f, 440.6f, 121.623f, 445.833f, 120.457f, 446.5f)
                lineTo(98.4568f, 448f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(51.4568f, 438f)
                curveTo(49.4568f, 432.4f, 38.9568f, 423.667f, 33.9568f, 420f)
                curveTo(34.6235f, 417f, 36.0568f, 409.3f, 36.4568f, 402.5f)
                curveTo(36.8568f, 395.7f, 38.6235f, 395.333f, 39.4568f, 396f)
                curveTo(47.4568f, 404f, 51.7901f, 415.333f, 52.9568f, 420f)
                curveTo(53.2901f, 428.333f, 53.4568f, 443.6f, 51.4568f, 438f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(83.9568f, 434.5f)
                lineTo(84.4568f, 421f)
                curveTo(91.2568f, 398.6f, 96.9568f, 395.333f, 98.9568f, 396.5f)
                lineTo(101.457f, 410.5f)
                lineTo(102.457f, 421f)
                curveTo(99.6235f, 421.5f, 92.9568f, 424.4f, 88.9568f, 432f)
                curveTo(84.9568f, 439.6f, 83.9568f, 436.833f, 83.9568f, 434.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(86.4568f, 404.5f)
                verticalLineTo(389f)
                lineTo(95.4568f, 382.5f)
                curveTo(96.6235f, 383.833f, 98.5568f, 386.8f, 96.9568f, 388f)
                curveTo(95.3568f, 389.2f, 89.2901f, 399.5f, 86.4568f, 404.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(49.9568f, 404.5f)
                lineTo(39.4568f, 387f)
                curveTo(39.0568f, 384.6f, 41.2901f, 383f, 42.4568f, 382.5f)
                lineTo(50.4568f, 389.5f)
                curveTo(51.6568f, 396.7f, 50.6235f, 402.5f, 49.9568f, 404.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(40.9568f, 433f)
                lineTo(31.9568f, 425f)
                curveTo(26.1234f, 431.333f, 14.9568f, 444.5f, 16.9568f, 446.5f)
                curveTo(18.9568f, 448.5f, 32.1234f, 448.333f, 38.4568f, 448f)
                lineTo(40.9568f, 433f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(42.4568f, 448f)
                lineTo(43.4568f, 437f)
                curveTo(44.2568f, 433.8f, 46.4568f, 435.667f, 47.4568f, 437f)
                lineTo(50.9568f, 442f)
                verticalLineTo(448f)
                horizontalLineTo(42.4568f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(86.4568f, 440.5f)
                verticalLineTo(446.5f)
                verticalLineTo(448f)
                horizontalLineTo(93.9568f)
                verticalLineTo(438.5f)
                curveTo(91.5568f, 430.9f, 87.9568f, 436.667f, 86.4568f, 440.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(98.4568f, 448f)
                curveTo(97.2568f, 445.2f, 96.6235f, 436.833f, 96.4568f, 433f)
                verticalLineTo(432f)
                lineTo(105.957f, 425f)
                curveTo(120.357f, 440.6f, 121.623f, 445.833f, 120.457f, 446.5f)
                lineTo(98.4568f, 448f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(51.4568f, 438f)
                curveTo(49.4568f, 432.4f, 38.9568f, 423.667f, 33.9568f, 420f)
                curveTo(34.6235f, 417f, 36.0568f, 409.3f, 36.4568f, 402.5f)
                curveTo(36.8568f, 395.7f, 38.6235f, 395.333f, 39.4568f, 396f)
                curveTo(47.4568f, 404f, 51.7901f, 415.333f, 52.9568f, 420f)
                curveTo(53.2901f, 428.333f, 53.4568f, 443.6f, 51.4568f, 438f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(83.9568f, 434.5f)
                lineTo(84.4568f, 421f)
                curveTo(91.2568f, 398.6f, 96.9568f, 395.333f, 98.9568f, 396.5f)
                lineTo(101.457f, 410.5f)
                lineTo(102.457f, 421f)
                curveTo(99.6235f, 421.5f, 92.9568f, 424.4f, 88.9568f, 432f)
                curveTo(84.9568f, 439.6f, 83.9568f, 436.833f, 83.9568f, 434.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(86.4568f, 404.5f)
                verticalLineTo(389f)
                lineTo(95.4568f, 382.5f)
                curveTo(96.6235f, 383.833f, 98.5568f, 386.8f, 96.9568f, 388f)
                curveTo(95.3568f, 389.2f, 89.2901f, 399.5f, 86.4568f, 404.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(49.9568f, 404.5f)
                lineTo(39.4568f, 387f)
                curveTo(39.0568f, 384.6f, 41.2901f, 383f, 42.4568f, 382.5f)
                lineTo(50.4568f, 389.5f)
                curveTo(51.6568f, 396.7f, 50.6235f, 402.5f, 49.9568f, 404.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(47.9568f, 369f)
                curveTo(55.7901f, 341.667f, 67.4568f, 280.6f, 51.4568f, 255f)
                curveTo(45.1235f, 260.667f, 35.5568f, 291.4f, 47.9568f, 369f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(40.4568f, 342.5f)
                curveTo(40.4568f, 301.3f, 25.4568f, 255.333f, 17.9568f, 237.5f)
                lineTo(16.9568f, 255f)
                curveTo(17.9568f, 262.5f, 21.3568f, 281.3f, 26.9568f, 296.5f)
                curveTo(32.5568f, 311.7f, 35.6235f, 333.5f, 36.4568f, 342.5f)
                curveTo(38.9568f, 354f, 40.4568f, 356.5f, 42.9568f, 372f)
                curveTo(44.9568f, 384.4f, 47.1235f, 382.833f, 47.9568f, 380.5f)
                curveTo(44.7568f, 374.9f, 41.6235f, 352.833f, 40.4568f, 342.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(28.9568f, 314f)
                curveTo(28.9568f, 310.8f, 19.6235f, 277.667f, 14.9568f, 261.5f)
                curveTo(13.1282f, 270.7f, 15.5282f, 288.667f, 16.9568f, 296.5f)
                lineTo(21.9568f, 317f)
                lineTo(29.9568f, 346f)
                curveTo(31.4568f, 352.167f, 35.1568f, 366.3f, 37.9568f, 373.5f)
                curveTo(41.4568f, 382.5f, 41.9568f, 375f, 40.4568f, 373.5f)
                curveTo(39.2568f, 372.3f, 35.2901f, 351.333f, 33.4568f, 341f)
                curveTo(31.9568f, 333.333f, 28.9568f, 317.2f, 28.9568f, 314f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(85.9568f, 253f)
                curveTo(91.9568f, 265f, 101.057f, 305f, 89.4568f, 369f)
                curveTo(81.7901f, 344.167f, 70.3568f, 286.2f, 85.9568f, 253f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(107.457f, 308f)
                curveTo(119.457f, 274.709f, 120.123f, 247.129f, 118.957f, 237.5f)
                curveTo(113.79f, 250.5f, 102.957f, 283.8f, 100.957f, 313f)
                curveTo(98.9568f, 342.2f, 92.7901f, 367.167f, 89.9568f, 376f)
                curveTo(89.5568f, 383.6f, 91.7901f, 382.167f, 92.9568f, 380.5f)
                lineTo(107.457f, 308f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(121.457f, 296.5f)
                lineTo(122.957f, 262f)
                lineTo(111.957f, 301.5f)
                curveTo(109.623f, 310.167f, 104.957f, 329.6f, 104.957f, 338f)
                curveTo(104.957f, 346.4f, 99.2901f, 364.167f, 96.4568f, 372f)
                lineTo(97.4568f, 376f)
                curveTo(100.79f, 369.5f, 107.457f, 354.2f, 107.457f, 345f)
                curveTo(107.457f, 335.8f, 116.79f, 308.833f, 121.457f, 296.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(97.4568f, 261.5f)
                curveTo(98.6568f, 256.3f, 92.2901f, 223f, 88.9568f, 207f)
                lineTo(87.4568f, 231f)
                curveTo(90.2901f, 243.333f, 96.2568f, 266.7f, 97.4568f, 261.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(47.9568f, 217f)
                curveTo(43.5568f, 226.2f, 40.4568f, 250.5f, 39.4568f, 261.5f)
                curveTo(52.2568f, 233.5f, 50.4568f, 213.5f, 47.9568f, 207f)
                verticalLineTo(217f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(47.9568f, 369f)
                curveTo(55.7901f, 341.667f, 67.4568f, 280.6f, 51.4568f, 255f)
                curveTo(45.1235f, 260.667f, 35.5568f, 291.4f, 47.9568f, 369f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(40.4568f, 342.5f)
                curveTo(40.4568f, 301.3f, 25.4568f, 255.333f, 17.9568f, 237.5f)
                lineTo(16.9568f, 255f)
                curveTo(17.9568f, 262.5f, 21.3568f, 281.3f, 26.9568f, 296.5f)
                curveTo(32.5568f, 311.7f, 35.6235f, 333.5f, 36.4568f, 342.5f)
                curveTo(38.9568f, 354f, 40.4568f, 356.5f, 42.9568f, 372f)
                curveTo(44.9568f, 384.4f, 47.1235f, 382.833f, 47.9568f, 380.5f)
                curveTo(44.7568f, 374.9f, 41.6235f, 352.833f, 40.4568f, 342.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(28.9568f, 314f)
                curveTo(28.9568f, 310.8f, 19.6235f, 277.667f, 14.9568f, 261.5f)
                curveTo(13.1282f, 270.7f, 15.5282f, 288.667f, 16.9568f, 296.5f)
                lineTo(21.9568f, 317f)
                lineTo(29.9568f, 346f)
                curveTo(31.4568f, 352.167f, 35.1568f, 366.3f, 37.9568f, 373.5f)
                curveTo(41.4568f, 382.5f, 41.9568f, 375f, 40.4568f, 373.5f)
                curveTo(39.2568f, 372.3f, 35.2901f, 351.333f, 33.4568f, 341f)
                curveTo(31.9568f, 333.333f, 28.9568f, 317.2f, 28.9568f, 314f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(85.9568f, 253f)
                curveTo(91.9568f, 265f, 101.057f, 305f, 89.4568f, 369f)
                curveTo(81.7901f, 344.167f, 70.3568f, 286.2f, 85.9568f, 253f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(107.457f, 308f)
                curveTo(119.457f, 274.709f, 120.123f, 247.129f, 118.957f, 237.5f)
                curveTo(113.79f, 250.5f, 102.957f, 283.8f, 100.957f, 313f)
                curveTo(98.9568f, 342.2f, 92.7901f, 367.167f, 89.9568f, 376f)
                curveTo(89.5568f, 383.6f, 91.7901f, 382.167f, 92.9568f, 380.5f)
                lineTo(107.457f, 308f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(121.457f, 296.5f)
                lineTo(122.957f, 262f)
                lineTo(111.957f, 301.5f)
                curveTo(109.623f, 310.167f, 104.957f, 329.6f, 104.957f, 338f)
                curveTo(104.957f, 346.4f, 99.2901f, 364.167f, 96.4568f, 372f)
                lineTo(97.4568f, 376f)
                curveTo(100.79f, 369.5f, 107.457f, 354.2f, 107.457f, 345f)
                curveTo(107.457f, 335.8f, 116.79f, 308.833f, 121.457f, 296.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(97.4568f, 261.5f)
                curveTo(98.6568f, 256.3f, 92.2901f, 223f, 88.9568f, 207f)
                lineTo(87.4568f, 231f)
                curveTo(90.2901f, 243.333f, 96.2568f, 266.7f, 97.4568f, 261.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(47.9568f, 217f)
                curveTo(43.5568f, 226.2f, 40.4568f, 250.5f, 39.4568f, 261.5f)
                curveTo(52.2568f, 233.5f, 50.4568f, 213.5f, 47.9568f, 207f)
                verticalLineTo(217f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(22.4568f, 199.5f)
                curveTo(12.7901f, 169.5f, -4.3432f, 103.1f, 4.4568f, 77.5f)
                curveTo(14.6235f, 115.5f, 32.4568f, 193.1f, 22.4568f, 199.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(39.4568f, 107f)
                curveTo(45.0568f, 116.2f, 38.7901f, 170.167f, 34.9568f, 196f)
                curveTo(32.9568f, 196.667f, 29.3568f, 196.2f, 30.9568f, 189f)
                curveTo(32.5568f, 181.8f, 31.6235f, 164.667f, 30.9568f, 157f)
                curveTo(4.5568f, 106.2f, 6.6235f, 43.8333f, 10.9568f, 19f)
                curveTo(18.1235f, 44.5f, 33.8568f, 97.8f, 39.4568f, 107f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(44.4568f, 159.5f)
                curveTo(41.2568f, 182.7f, 43.1235f, 196.833f, 44.4568f, 201f)
                curveTo(53.6568f, 207f, 55.2901f, 177.5f, 54.9568f, 162f)
                curveTo(53.6235f, 155.833f, 50.3568f, 140.8f, 47.9568f, 130f)
                curveTo(45.5568f, 119.2f, 44.6235f, 120.167f, 44.4568f, 122f)
                curveTo(45.7901f, 124.833f, 47.6568f, 136.3f, 44.4568f, 159.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(44.4568f, 105.5f)
                curveTo(31.2568f, 82.3f, 21.6235f, 36.5f, 18.4568f, 16.5f)
                curveTo(19.4272f, 21.8333f, 24.0857f, 35.8f, 34.9568f, 49f)
                curveTo(45.8279f, 62.2f, 52.8198f, 93.1667f, 54.9568f, 107f)
                curveTo(55.6235f, 121.833f, 56.7568f, 149.5f, 55.9568f, 141.5f)
                curveTo(55.1568f, 133.5f, 47.9568f, 114.167f, 44.4568f, 105.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(44.4568f, 53.5f)
                lineTo(26.4568f, 19f)
                curveTo(31.6568f, 21f, 50.9568f, 39.8333f, 59.9568f, 49f)
                curveTo(52.7568f, 67.8f, 48.9568f, 71.1667f, 47.9568f, 70.5f)
                lineTo(44.4568f, 53.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(110.957f, 19f)
                lineTo(77.4568f, 47.5f)
                curveTo(81.2901f, 58.1667f, 89.0568f, 77.7f, 89.4568f, 70.5f)
                curveTo(89.9568f, 61.5f, 92.4568f, 53.5f, 93.4568f, 53.5f)
                curveTo(94.2568f, 53.5f, 105.457f, 30.5f, 110.957f, 19f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(94.9568f, 62.5f)
                curveTo(97.7568f, 60.5f, 111.79f, 31f, 118.457f, 16.5f)
                curveTo(122.857f, 21.3f, 103.623f, 76.5f, 93.4568f, 103.5f)
                lineTo(79.9568f, 144f)
                lineTo(82.4568f, 107f)
                curveTo(85.4568f, 93f, 92.1568f, 64.5f, 94.9568f, 62.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(103.957f, 88.5f)
                lineTo(126.457f, 19f)
                curveTo(129.257f, 21f, 130.29f, 49.5f, 130.457f, 63.5f)
                curveTo(128.123f, 83.6667f, 122.157f, 125.4f, 116.957f, 131f)
                curveTo(111.757f, 136.6f, 107.123f, 156.333f, 105.457f, 165.5f)
                verticalLineTo(193f)
                curveTo(105.457f, 199.8f, 101.123f, 197.833f, 98.9568f, 196f)
                verticalLineTo(187f)
                curveTo(98.1235f, 176f, 96.4568f, 149.2f, 96.4568f, 130f)
                curveTo(96.4568f, 110.8f, 101.457f, 94.3333f, 103.957f, 88.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(111.957f, 161f)
                curveTo(113.957f, 160.2f, 126.123f, 105f, 131.957f, 77.5f)
                curveTo(133.457f, 92.8333f, 135.757f, 127.5f, 132.957f, 143.5f)
                curveTo(130.157f, 159.5f, 117.79f, 187.5f, 111.957f, 199.5f)
                curveTo(111.123f, 187f, 109.957f, 161.8f, 111.957f, 161f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(84.9568f, 194.5f)
                curveTo(79.3568f, 162.1f, 86.9568f, 132.667f, 91.4568f, 122f)
                curveTo(91.7839f, 121.2f, 92.2597f, 150f, 92.4568f, 164.5f)
                lineTo(94.9568f, 192f)
                curveTo(91.7568f, 209.6f, 86.9568f, 201f, 84.9568f, 194.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(83.4568f, 85.5f)
                curveTo(87.4568f, 78.7f, 77.4568f, 60f, 71.9568f, 51.5f)
                curveTo(71.9568f, 60.5f, 72.4568f, 81.1f, 74.4568f, 91.5f)
                curveTo(76.4568f, 101.9f, 79.6235f, 104.167f, 80.9568f, 104f)
                curveTo(80.1235f, 100.667f, 79.4568f, 92.3f, 83.4568f, 85.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(57.9568f, 103.5f)
                curveTo(63.5568f, 97.9f, 65.2901f, 66.6667f, 64.9568f, 51.5f)
                curveTo(54.4568f, 73.5f, 49.9568f, 79f, 53.9568f, 85.5f)
                curveTo(57.1568f, 90.7f, 56.6235f, 96.6667f, 55.9568f, 99f)
                curveTo(56.7568f, 105f, 57.6235f, 104.5f, 57.9568f, 103.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(22.4568f, 199.5f)
                curveTo(12.7901f, 169.5f, -4.3432f, 103.1f, 4.4568f, 77.5f)
                curveTo(14.6235f, 115.5f, 32.4568f, 193.1f, 22.4568f, 199.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(39.4568f, 107f)
                curveTo(45.0568f, 116.2f, 38.7901f, 170.167f, 34.9568f, 196f)
                curveTo(32.9568f, 196.667f, 29.3568f, 196.2f, 30.9568f, 189f)
                curveTo(32.5568f, 181.8f, 31.6235f, 164.667f, 30.9568f, 157f)
                curveTo(4.5568f, 106.2f, 6.6235f, 43.8333f, 10.9568f, 19f)
                curveTo(18.1235f, 44.5f, 33.8568f, 97.8f, 39.4568f, 107f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(44.4568f, 159.5f)
                curveTo(41.2568f, 182.7f, 43.1235f, 196.833f, 44.4568f, 201f)
                curveTo(53.6568f, 207f, 55.2901f, 177.5f, 54.9568f, 162f)
                curveTo(53.6235f, 155.833f, 50.3568f, 140.8f, 47.9568f, 130f)
                curveTo(45.5568f, 119.2f, 44.6235f, 120.167f, 44.4568f, 122f)
                curveTo(45.7901f, 124.833f, 47.6568f, 136.3f, 44.4568f, 159.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(44.4568f, 105.5f)
                curveTo(31.2568f, 82.3f, 21.6235f, 36.5f, 18.4568f, 16.5f)
                curveTo(19.4272f, 21.8333f, 24.0857f, 35.8f, 34.9568f, 49f)
                curveTo(45.8279f, 62.2f, 52.8198f, 93.1667f, 54.9568f, 107f)
                curveTo(55.6235f, 121.833f, 56.7568f, 149.5f, 55.9568f, 141.5f)
                curveTo(55.1568f, 133.5f, 47.9568f, 114.167f, 44.4568f, 105.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(44.4568f, 53.5f)
                lineTo(26.4568f, 19f)
                curveTo(31.6568f, 21f, 50.9568f, 39.8333f, 59.9568f, 49f)
                curveTo(52.7568f, 67.8f, 48.9568f, 71.1667f, 47.9568f, 70.5f)
                lineTo(44.4568f, 53.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(110.957f, 19f)
                lineTo(77.4568f, 47.5f)
                curveTo(81.2901f, 58.1667f, 89.0568f, 77.7f, 89.4568f, 70.5f)
                curveTo(89.9568f, 61.5f, 92.4568f, 53.5f, 93.4568f, 53.5f)
                curveTo(94.2568f, 53.5f, 105.457f, 30.5f, 110.957f, 19f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(94.9568f, 62.5f)
                curveTo(97.7568f, 60.5f, 111.79f, 31f, 118.457f, 16.5f)
                curveTo(122.857f, 21.3f, 103.623f, 76.5f, 93.4568f, 103.5f)
                lineTo(79.9568f, 144f)
                lineTo(82.4568f, 107f)
                curveTo(85.4568f, 93f, 92.1568f, 64.5f, 94.9568f, 62.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(103.957f, 88.5f)
                lineTo(126.457f, 19f)
                curveTo(129.257f, 21f, 130.29f, 49.5f, 130.457f, 63.5f)
                curveTo(128.123f, 83.6667f, 122.157f, 125.4f, 116.957f, 131f)
                curveTo(111.757f, 136.6f, 107.123f, 156.333f, 105.457f, 165.5f)
                verticalLineTo(193f)
                curveTo(105.457f, 199.8f, 101.123f, 197.833f, 98.9568f, 196f)
                verticalLineTo(187f)
                curveTo(98.1235f, 176f, 96.4568f, 149.2f, 96.4568f, 130f)
                curveTo(96.4568f, 110.8f, 101.457f, 94.3333f, 103.957f, 88.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(111.957f, 161f)
                curveTo(113.957f, 160.2f, 126.123f, 105f, 131.957f, 77.5f)
                curveTo(133.457f, 92.8333f, 135.757f, 127.5f, 132.957f, 143.5f)
                curveTo(130.157f, 159.5f, 117.79f, 187.5f, 111.957f, 199.5f)
                curveTo(111.123f, 187f, 109.957f, 161.8f, 111.957f, 161f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(84.9568f, 194.5f)
                curveTo(79.3568f, 162.1f, 86.9568f, 132.667f, 91.4568f, 122f)
                curveTo(91.7839f, 121.2f, 92.2597f, 150f, 92.4568f, 164.5f)
                lineTo(94.9568f, 192f)
                curveTo(91.7568f, 209.6f, 86.9568f, 201f, 84.9568f, 194.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(83.4568f, 85.5f)
                curveTo(87.4568f, 78.7f, 77.4568f, 60f, 71.9568f, 51.5f)
                curveTo(71.9568f, 60.5f, 72.4568f, 81.1f, 74.4568f, 91.5f)
                curveTo(76.4568f, 101.9f, 79.6235f, 104.167f, 80.9568f, 104f)
                curveTo(80.1235f, 100.667f, 79.4568f, 92.3f, 83.4568f, 85.5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(57.9568f, 103.5f)
                curveTo(63.5568f, 97.9f, 65.2901f, 66.6667f, 64.9568f, 51.5f)
                curveTo(54.4568f, 73.5f, 49.9568f, 79f, 53.9568f, 85.5f)
                curveTo(57.1568f, 90.7f, 56.6235f, 96.6667f, 55.9568f, 99f)
                curveTo(56.7568f, 105f, 57.6235f, 104.5f, 57.9568f, 103.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFA6A6A6)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(292.949f, 1f)
                horizontalLineTo(171.449f)
                curveTo(171.449f, 3.4434f, 168.783f, 33.918f, 167.449f, 48.8499f)
                lineTo(165.449f, 122.152f)
                curveTo(162.649f, 142.921f, 173.616f, 183.067f, 179.449f, 200.544f)
                curveTo(177.849f, 207.467f, 180.116f, 217.003f, 181.449f, 220.906f)
                curveTo(182.249f, 223.35f, 178.449f, 237.535f, 176.449f, 244.322f)
                curveTo(172.449f, 254.503f, 174.116f, 274.695f, 175.449f, 283.518f)
                curveTo(174.949f, 285.554f, 185.949f, 326.278f, 186.949f, 327.805f)
                curveTo(187.749f, 329.027f, 193.616f, 354.445f, 196.449f, 367.001f)
                curveTo(198.949f, 370.564f, 199.449f, 395.507f, 199.449f, 398.053f)
                curveTo(199.449f, 400.598f, 197.949f, 401.616f, 196.949f, 404.161f)
                curveTo(196.149f, 406.197f, 196.616f, 412.136f, 196.949f, 414.851f)
                curveTo(192.449f, 422.147f, 183.049f, 437.249f, 181.449f, 439.285f)
                curveTo(179.849f, 441.321f, 177.783f, 442.17f, 176.949f, 442.339f)
                curveTo(174.149f, 444.375f, 175.783f, 448.618f, 176.949f, 450.484f)
                curveTo(189.449f, 451.163f, 215.149f, 452.113f, 217.949f, 450.484f)
                curveTo(221.449f, 448.448f, 221.449f, 437.249f, 220.449f, 432.668f)
                curveTo(219.649f, 429.002f, 218.449f, 417.227f, 217.949f, 411.797f)
                curveTo(218.749f, 408.539f, 217.616f, 402.973f, 216.949f, 400.598f)
                lineTo(219.449f, 349.185f)
                curveTo(223.449f, 336.968f, 225.949f, 296.753f, 225.949f, 290.136f)
                curveTo(225.949f, 284.842f, 221.283f, 257.387f, 218.949f, 244.322f)
                curveTo(217.949f, 236.347f, 215.849f, 219.684f, 215.449f, 216.834f)
                curveTo(214.949f, 213.27f, 216.949f, 194.436f, 217.449f, 191.891f)
                curveTo(217.849f, 189.855f, 223.616f, 137.084f, 226.449f, 110.953f)
                curveTo(227.116f, 104.166f, 228.949f, 88.3516f, 230.949f, 79.3925f)
                curveTo(233.449f, 68.1935f, 232.449f, 73.284f, 233.449f, 73.284f)
                curveTo(234.249f, 73.284f, 239.449f, 116.722f, 241.949f, 138.441f)
                curveTo(243.783f, 157.276f, 247.649f, 195.352f, 248.449f, 196.981f)
                curveTo(249.449f, 199.017f, 250.949f, 222.433f, 249.449f, 227.524f)
                curveTo(248.249f, 231.596f, 242.949f, 267.908f, 240.449f, 285.554f)
                curveTo(240.116f, 296.414f, 239.949f, 319.355f, 241.949f, 324.242f)
                curveTo(244.449f, 330.35f, 246.449f, 361.402f, 246.949f, 362.42f)
                curveTo(247.349f, 363.234f, 247.783f, 388.89f, 247.949f, 401.616f)
                curveTo(247.283f, 402.973f, 246.149f, 406.91f, 246.949f, 411.797f)
                curveTo(247.749f, 416.684f, 245.949f, 425.371f, 244.949f, 429.104f)
                curveTo(241.349f, 445.801f, 246.449f, 450.314f, 249.449f, 450.484f)
                curveTo(259.949f, 450.993f, 282.249f, 451.706f, 287.449f, 450.484f)
                curveTo(292.649f, 449.262f, 290.616f, 444.545f, 288.949f, 442.339f)
                curveTo(285.949f, 442f, 279.749f, 439.896f, 278.949f, 434.195f)
                curveTo(278.149f, 428.493f, 271.949f, 418.245f, 268.949f, 413.833f)
                curveTo(268.549f, 403.652f, 266.783f, 400.768f, 265.949f, 400.598f)
                verticalLineTo(387.872f)
                curveTo(265.616f, 382.103f, 267.249f, 363.641f, 276.449f, 335.95f)
                curveTo(287.949f, 301.335f, 290.449f, 278.428f, 290.949f, 272.828f)
                curveTo(291.349f, 268.349f, 286.783f, 236.686f, 284.449f, 221.415f)
                curveTo(286.449f, 216.121f, 286.616f, 205.295f, 286.449f, 200.544f)
                curveTo(307.249f, 150.047f, 299.449f, 46.4744f, 292.949f, 1f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(189.949f, 447.939f)
                curveTo(189.149f, 445.903f, 195.616f, 427.407f, 198.949f, 418.414f)
                verticalLineTo(439.794f)
                curveTo(199.616f, 442f, 202.049f, 445.597f, 206.449f, 442.339f)
                curveTo(211.949f, 438.267f, 208.449f, 412.306f, 213.449f, 420.96f)
                curveTo(217.449f, 427.883f, 216.783f, 441.83f, 215.949f, 447.939f)
                curveTo(207.616f, 448.787f, 190.749f, 449.975f, 189.949f, 447.939f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(249.449f, 447.939f)
                curveTo(247.849f, 445.088f, 251.116f, 428.765f, 252.949f, 420.96f)
                curveTo(253.949f, 429.274f, 257.249f, 445.597f, 262.449f, 444.376f)
                curveTo(267.649f, 443.154f, 266.283f, 426.559f, 264.949f, 418.414f)
                curveTo(269.349f, 420.858f, 273.783f, 439.115f, 275.449f, 447.939f)
                curveTo(267.449f, 449.127f, 251.049f, 450.789f, 249.449f, 447.939f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(189.949f, 447.939f)
                curveTo(189.149f, 445.903f, 195.616f, 427.407f, 198.949f, 418.414f)
                verticalLineTo(439.794f)
                curveTo(199.616f, 442f, 202.049f, 445.597f, 206.449f, 442.339f)
                curveTo(211.949f, 438.267f, 208.449f, 412.306f, 213.449f, 420.96f)
                curveTo(217.449f, 427.883f, 216.783f, 441.83f, 215.949f, 447.939f)
                curveTo(207.616f, 448.787f, 190.749f, 449.975f, 189.949f, 447.939f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(249.449f, 447.939f)
                curveTo(247.849f, 445.088f, 251.116f, 428.765f, 252.949f, 420.96f)
                curveTo(253.949f, 429.274f, 257.249f, 445.597f, 262.449f, 444.376f)
                curveTo(267.649f, 443.154f, 266.283f, 426.559f, 264.949f, 418.414f)
                curveTo(269.349f, 420.858f, 273.783f, 439.115f, 275.449f, 447.939f)
                curveTo(267.449f, 449.127f, 251.049f, 450.789f, 249.449f, 447.939f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(193.449f, 340.022f)
                curveTo(199.449f, 351.425f, 202.949f, 389.908f, 203.949f, 407.725f)
                curveTo(208.449f, 413.833f, 206.949f, 407.725f, 207.449f, 405.179f)
                curveTo(207.849f, 403.143f, 205.283f, 372.431f, 203.949f, 357.329f)
                curveTo(202.116f, 349.863f, 197.849f, 331.572f, 195.449f, 318.133f)
                curveTo(193.049f, 304.694f, 189.783f, 307.443f, 188.449f, 310.498f)
                curveTo(187.616f, 315.588f, 187.449f, 328.619f, 193.449f, 340.022f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(213.949f, 406.706f)
                curveTo(212.749f, 411.593f, 211.449f, 408.403f, 210.949f, 406.197f)
                lineTo(212.949f, 375.655f)
                lineTo(214.949f, 341.04f)
                lineTo(215.949f, 320.169f)
                curveTo(216.783f, 315.927f, 218.749f, 307.749f, 219.949f, 308.97f)
                curveTo(221.149f, 310.192f, 220.449f, 323.054f, 219.949f, 329.332f)
                curveTo(219.116f, 336.459f, 217.349f, 351.323f, 216.949f, 353.766f)
                curveTo(216.549f, 356.21f, 215.116f, 374.128f, 214.449f, 382.781f)
                lineTo(213.949f, 406.706f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(252.949f, 406.706f)
                curveTo(252.149f, 410.779f, 251.283f, 409.082f, 250.949f, 407.725f)
                verticalLineTo(400.598f)
                curveTo(250.949f, 399.376f, 248.616f, 367.171f, 247.449f, 351.221f)
                curveTo(246.649f, 348.777f, 245.116f, 335.95f, 244.449f, 329.841f)
                lineTo(243.449f, 316.606f)
                curveTo(243.849f, 308.054f, 244.616f, 306.934f, 244.949f, 307.443f)
                lineTo(248.949f, 323.733f)
                curveTo(249.116f, 325.599f, 249.349f, 329.841f, 248.949f, 331.877f)
                curveTo(248.549f, 333.913f, 249.783f, 354.445f, 250.449f, 364.456f)
                lineTo(252.949f, 406.706f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(260.449f, 405.179f)
                curveTo(257.649f, 413.324f, 256.616f, 409.252f, 256.449f, 406.197f)
                curveTo(256.949f, 399.071f, 257.949f, 384.207f, 257.949f, 381.763f)
                curveTo(257.949f, 379.32f, 260.616f, 361.062f, 261.949f, 352.239f)
                curveTo(264.116f, 340.87f, 268.649f, 317.319f, 269.449f, 314.061f)
                curveTo(270.449f, 309.988f, 271.949f, 307.443f, 275.449f, 307.952f)
                curveTo(278.249f, 308.36f, 277.283f, 318.642f, 276.449f, 323.733f)
                curveTo(273.616f, 333.744f, 267.349f, 354.784f, 264.949f, 358.857f)
                curveTo(262.549f, 362.929f, 260.949f, 391.435f, 260.449f, 405.179f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(254.449f, 302.353f)
                curveTo(247.249f, 311.312f, 245.116f, 306.086f, 244.949f, 302.353f)
                curveTo(244.949f, 296.075f, 244.649f, 280.057f, 243.449f, 266.211f)
                curveTo(242.249f, 252.365f, 259.283f, 212.252f, 267.949f, 193.927f)
                verticalLineTo(232.614f)
                curveTo(266.949f, 239.571f, 264.949f, 257.048f, 264.949f, 271.301f)
                curveTo(264.949f, 285.554f, 262.949f, 292.511f, 261.949f, 294.208f)
                curveTo(262.449f, 293.19f, 261.649f, 293.394f, 254.449f, 302.353f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(266.949f, 294.208f)
                curveTo(272.549f, 283.62f, 272.616f, 221.924f, 271.949f, 192.4f)
                curveTo(276.749f, 184.662f, 278.616f, 189.176f, 278.949f, 192.4f)
                lineTo(283.449f, 223.451f)
                curveTo(285.116f, 237.026f, 288.449f, 265.6f, 288.449f, 271.301f)
                curveTo(288.449f, 277.003f, 278.449f, 295.396f, 273.449f, 303.88f)
                lineTo(266.949f, 294.208f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(196.949f, 225.488f)
                lineTo(197.949f, 194.945f)
                curveTo(211.949f, 216.936f, 219.116f, 249.922f, 220.949f, 263.666f)
                curveTo(221.449f, 273.847f, 222.149f, 295.837f, 220.949f, 302.353f)
                curveTo(219.749f, 308.869f, 213.783f, 306.086f, 210.949f, 303.88f)
                curveTo(207.616f, 300.656f, 201.149f, 293.699f, 201.949f, 291.663f)
                curveTo(202.749f, 289.627f, 198.949f, 246.698f, 196.949f, 225.488f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(193.449f, 192.4f)
                curveTo(188.649f, 185.477f, 187.449f, 188.837f, 187.449f, 191.382f)
                lineTo(183.449f, 216.834f)
                curveTo(181.283f, 230.917f, 176.849f, 260.815f, 176.449f, 267.738f)
                curveTo(176.049f, 274.661f, 186.283f, 294.717f, 191.449f, 303.88f)
                lineTo(197.949f, 294.208f)
                curveTo(192.349f, 284.435f, 192.616f, 222.264f, 193.449f, 192.4f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(193.449f, 340.022f)
                curveTo(199.449f, 351.425f, 202.949f, 389.908f, 203.949f, 407.725f)
                curveTo(208.449f, 413.833f, 206.949f, 407.725f, 207.449f, 405.179f)
                curveTo(207.849f, 403.143f, 205.283f, 372.431f, 203.949f, 357.329f)
                curveTo(202.116f, 349.863f, 197.849f, 331.572f, 195.449f, 318.133f)
                curveTo(193.049f, 304.694f, 189.783f, 307.443f, 188.449f, 310.498f)
                curveTo(187.616f, 315.588f, 187.449f, 328.619f, 193.449f, 340.022f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(213.949f, 406.706f)
                curveTo(212.749f, 411.593f, 211.449f, 408.403f, 210.949f, 406.197f)
                lineTo(212.949f, 375.655f)
                lineTo(214.949f, 341.04f)
                lineTo(215.949f, 320.169f)
                curveTo(216.783f, 315.927f, 218.749f, 307.749f, 219.949f, 308.97f)
                curveTo(221.149f, 310.192f, 220.449f, 323.054f, 219.949f, 329.332f)
                curveTo(219.116f, 336.459f, 217.349f, 351.323f, 216.949f, 353.766f)
                curveTo(216.549f, 356.21f, 215.116f, 374.128f, 214.449f, 382.781f)
                lineTo(213.949f, 406.706f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(252.949f, 406.706f)
                curveTo(252.149f, 410.779f, 251.283f, 409.082f, 250.949f, 407.725f)
                verticalLineTo(400.598f)
                curveTo(250.949f, 399.376f, 248.616f, 367.171f, 247.449f, 351.221f)
                curveTo(246.649f, 348.777f, 245.116f, 335.95f, 244.449f, 329.841f)
                lineTo(243.449f, 316.606f)
                curveTo(243.849f, 308.054f, 244.616f, 306.934f, 244.949f, 307.443f)
                lineTo(248.949f, 323.733f)
                curveTo(249.116f, 325.599f, 249.349f, 329.841f, 248.949f, 331.877f)
                curveTo(248.549f, 333.913f, 249.783f, 354.445f, 250.449f, 364.456f)
                lineTo(252.949f, 406.706f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(260.449f, 405.179f)
                curveTo(257.649f, 413.324f, 256.616f, 409.252f, 256.449f, 406.197f)
                curveTo(256.949f, 399.071f, 257.949f, 384.207f, 257.949f, 381.763f)
                curveTo(257.949f, 379.32f, 260.616f, 361.062f, 261.949f, 352.239f)
                curveTo(264.116f, 340.87f, 268.649f, 317.319f, 269.449f, 314.061f)
                curveTo(270.449f, 309.988f, 271.949f, 307.443f, 275.449f, 307.952f)
                curveTo(278.249f, 308.36f, 277.283f, 318.642f, 276.449f, 323.733f)
                curveTo(273.616f, 333.744f, 267.349f, 354.784f, 264.949f, 358.857f)
                curveTo(262.549f, 362.929f, 260.949f, 391.435f, 260.449f, 405.179f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(254.449f, 302.353f)
                curveTo(247.249f, 311.312f, 245.116f, 306.086f, 244.949f, 302.353f)
                curveTo(244.949f, 296.075f, 244.649f, 280.057f, 243.449f, 266.211f)
                curveTo(242.249f, 252.365f, 259.283f, 212.252f, 267.949f, 193.927f)
                verticalLineTo(232.614f)
                curveTo(266.949f, 239.571f, 264.949f, 257.048f, 264.949f, 271.301f)
                curveTo(264.949f, 285.554f, 262.949f, 292.511f, 261.949f, 294.208f)
                curveTo(262.449f, 293.19f, 261.649f, 293.394f, 254.449f, 302.353f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(266.949f, 294.208f)
                curveTo(272.549f, 283.62f, 272.616f, 221.924f, 271.949f, 192.4f)
                curveTo(276.749f, 184.662f, 278.616f, 189.176f, 278.949f, 192.4f)
                lineTo(283.449f, 223.451f)
                curveTo(285.116f, 237.026f, 288.449f, 265.6f, 288.449f, 271.301f)
                curveTo(288.449f, 277.003f, 278.449f, 295.396f, 273.449f, 303.88f)
                lineTo(266.949f, 294.208f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(196.949f, 225.488f)
                lineTo(197.949f, 194.945f)
                curveTo(211.949f, 216.936f, 219.116f, 249.922f, 220.949f, 263.666f)
                curveTo(221.449f, 273.847f, 222.149f, 295.837f, 220.949f, 302.353f)
                curveTo(219.749f, 308.869f, 213.783f, 306.086f, 210.949f, 303.88f)
                curveTo(207.616f, 300.656f, 201.149f, 293.699f, 201.949f, 291.663f)
                curveTo(202.749f, 289.627f, 198.949f, 246.698f, 196.949f, 225.488f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(193.449f, 192.4f)
                curveTo(188.649f, 185.477f, 187.449f, 188.837f, 187.449f, 191.382f)
                lineTo(183.449f, 216.834f)
                curveTo(181.283f, 230.917f, 176.849f, 260.815f, 176.449f, 267.738f)
                curveTo(176.049f, 274.661f, 186.283f, 294.717f, 191.449f, 303.88f)
                lineTo(197.949f, 294.208f)
                curveTo(192.349f, 284.435f, 192.616f, 222.264f, 193.449f, 192.4f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(187.949f, 176.11f)
                lineTo(179.449f, 195.454f)
                lineTo(173.949f, 154.222f)
                curveTo(173.116f, 139.459f, 172.549f, 107.492f, 176.949f, 97.718f)
                curveTo(181.349f, 87.9444f, 189.783f, 82.4467f, 193.449f, 80.9196f)
                curveTo(179.849f, 114.313f, 184.116f, 158.294f, 187.949f, 176.11f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(205.449f, 171.529f)
                curveTo(203.849f, 174.787f, 204.783f, 193.927f, 205.449f, 203.09f)
                curveTo(185.949f, 175.092f, 189.949f, 154.222f, 187.949f, 137.932f)
                curveTo(186.349f, 124.901f, 195.949f, 90.4217f, 200.949f, 74.8111f)
                curveTo(202.949f, 75.6256f, 205.783f, 104.675f, 206.949f, 119.098f)
                curveTo(207.116f, 135.217f, 207.049f, 168.271f, 205.449f, 171.529f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(209.449f, 210.725f)
                curveTo(209.783f, 186.291f, 210.649f, 136.1f, 211.449f, 130.806f)
                curveTo(214.949f, 155.749f, 219.449f, 206.653f, 209.449f, 210.725f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(217.27f, 155.143f)
                curveTo(217.33f, 155.52f, 217.39f, 155.891f, 217.449f, 156.258f)
                curveTo(217.37f, 155.935f, 217.311f, 155.562f, 217.27f, 155.143f)
                curveTo(212.895f, 127.973f, 204.977f, 75.0776f, 206.949f, 72.2659f)
                curveTo(208.949f, 69.4153f, 219.116f, 62.9335f, 223.949f, 60.0489f)
                curveTo(226.809f, 71.7569f, 230.312f, 101.587f, 221.449f, 127.242f)
                curveTo(219.737f, 134.374f, 216.688f, 149.231f, 217.27f, 155.143f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(257.949f, 72.2659f)
                lineTo(240.949f, 60.0489f)
                curveTo(234.549f, 82.0395f, 243.616f, 133.351f, 248.949f, 156.258f)
                curveTo(247.749f, 150.964f, 252.449f, 122.491f, 254.949f, 108.917f)
                curveTo(259.749f, 88.148f, 258.949f, 75.8292f, 257.949f, 72.2659f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(257.949f, 167.457f)
                curveTo(254.349f, 140.579f, 261.116f, 94.4941f, 264.949f, 74.8111f)
                curveTo(287.749f, 146.484f, 271.116f, 190.194f, 259.949f, 203.09f)
                curveTo(262.749f, 196.981f, 259.783f, 176.789f, 257.949f, 167.457f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(276.949f, 176.11f)
                curveTo(288.549f, 144.753f, 278.116f, 99.5845f, 271.449f, 80.9196f)
                curveTo(274.949f, 80.2409f, 283.549f, 84.3811f, 289.949f, 106.372f)
                curveTo(296.349f, 128.362f, 288.949f, 174.923f, 284.449f, 195.454f)
                lineTo(276.949f, 176.11f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(248.949f, 189.346f)
                lineTo(253.949f, 130.806f)
                curveTo(255.389f, 135.285f, 255.216f, 185.952f, 254.949f, 210.725f)
                curveTo(252.549f, 210.725f, 249.949f, 196.472f, 248.949f, 189.346f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(289.949f, 93.1366f)
                curveTo(291.109f, 86.2136f, 294.766f, 72.6053f, 296.449f, 66.6664f)
                verticalLineTo(117.062f)
                lineTo(289.949f, 93.1366f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(168.949f, 117.062f)
                verticalLineTo(66.6664f)
                curveTo(171.749f, 69.9243f, 174.783f, 86.3494f, 175.949f, 94.1547f)
                lineTo(168.949f, 117.062f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(179.449f, 195.454f)
                lineTo(187.949f, 176.11f)
                curveTo(184.116f, 158.294f, 179.849f, 114.313f, 193.449f, 80.9196f)
                curveTo(189.783f, 82.4467f, 181.349f, 87.9444f, 176.949f, 97.718f)
                curveTo(172.549f, 107.492f, 173.116f, 139.459f, 173.949f, 154.222f)
                lineTo(179.449f, 195.454f)
                close()
                moveTo(205.449f, 203.09f)
                curveTo(204.783f, 193.927f, 203.849f, 174.787f, 205.449f, 171.529f)
                curveTo(207.049f, 168.271f, 207.116f, 135.217f, 206.949f, 119.098f)
                curveTo(205.783f, 104.675f, 202.949f, 75.6256f, 200.949f, 74.8111f)
                curveTo(195.949f, 90.4217f, 186.349f, 124.901f, 187.949f, 137.932f)
                curveTo(189.949f, 154.222f, 185.949f, 175.092f, 205.449f, 203.09f)
                close()
                moveTo(209.449f, 210.725f)
                curveTo(209.783f, 186.291f, 210.649f, 136.1f, 211.449f, 130.806f)
                curveTo(214.949f, 155.749f, 219.449f, 206.653f, 209.449f, 210.725f)
                close()
                moveTo(217.449f, 156.258f)
                curveTo(213.116f, 129.448f, 204.949f, 75.1165f, 206.949f, 72.2659f)
                curveTo(208.949f, 69.4153f, 219.116f, 62.9335f, 223.949f, 60.0489f)
                curveTo(226.809f, 71.7569f, 230.312f, 101.587f, 221.449f, 127.242f)
                curveTo(219.616f, 134.878f, 216.249f, 151.371f, 217.449f, 156.258f)
                close()
                moveTo(240.949f, 60.0489f)
                lineTo(257.949f, 72.2659f)
                curveTo(258.949f, 75.8292f, 259.749f, 88.148f, 254.949f, 108.917f)
                curveTo(252.449f, 122.491f, 247.749f, 150.964f, 248.949f, 156.258f)
                curveTo(243.616f, 133.351f, 234.549f, 82.0395f, 240.949f, 60.0489f)
                close()
                moveTo(264.949f, 74.8111f)
                curveTo(261.116f, 94.4941f, 254.349f, 140.579f, 257.949f, 167.457f)
                curveTo(259.783f, 176.789f, 262.749f, 196.981f, 259.949f, 203.09f)
                curveTo(271.116f, 190.194f, 287.749f, 146.484f, 264.949f, 74.8111f)
                close()
                moveTo(271.449f, 80.9196f)
                curveTo(278.116f, 99.5845f, 288.549f, 144.753f, 276.949f, 176.11f)
                lineTo(284.449f, 195.454f)
                curveTo(288.949f, 174.923f, 296.349f, 128.362f, 289.949f, 106.372f)
                curveTo(283.549f, 84.3811f, 274.949f, 80.2409f, 271.449f, 80.9196f)
                close()
                moveTo(253.949f, 130.806f)
                lineTo(248.949f, 189.346f)
                curveTo(249.949f, 196.472f, 252.549f, 210.725f, 254.949f, 210.725f)
                curveTo(255.216f, 185.952f, 255.389f, 135.285f, 253.949f, 130.806f)
                close()
                moveTo(296.449f, 66.6664f)
                curveTo(294.766f, 72.6053f, 291.109f, 86.2136f, 289.949f, 93.1366f)
                lineTo(296.449f, 117.062f)
                verticalLineTo(66.6664f)
                close()
                moveTo(168.949f, 66.6664f)
                verticalLineTo(117.062f)
                lineTo(175.949f, 94.1547f)
                curveTo(174.783f, 86.3494f, 171.749f, 69.9243f, 168.949f, 66.6664f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(177.949f, 81.9377f)
                curveTo(171.149f, 67.6845f, 172.783f, 40.3659f, 174.449f, 28.4883f)
                curveTo(186.449f, 6.5995f, 225.449f, 6.5995f, 228.449f, 8.1266f)
                curveTo(230.849f, 9.3483f, 229.449f, 32.3909f, 228.449f, 43.7595f)
                lineTo(220.949f, 53.9404f)
                curveTo(215.949f, 57.1643f, 203.449f, 64.6303f, 193.449f, 68.7026f)
                curveTo(183.449f, 72.7749f, 178.949f, 79.2228f, 177.949f, 81.9377f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDE5D5D)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(234.949f, 43.7595f)
                verticalLineTo(8.12661f)
                curveTo(255.949f, 5.5814f, 282.449f, 16.2713f, 288.949f, 28.4883f)
                curveTo(294.149f, 38.2619f, 288.449f, 68.1936f, 284.949f, 81.9377f)
                curveTo(284.616f, 79.7318f, 280.949f, 73.9966f, 268.949f, 68.7026f)
                curveTo(256.949f, 63.4086f, 246.283f, 56.6553f, 242.449f, 53.9404f)
                lineTo(234.949f, 43.7595f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(177.949f, 81.9377f)
                curveTo(171.149f, 67.6845f, 172.783f, 40.3659f, 174.449f, 28.4883f)
                curveTo(186.449f, 6.5995f, 225.449f, 6.5995f, 228.449f, 8.1266f)
                curveTo(230.849f, 9.3483f, 229.449f, 32.3909f, 228.449f, 43.7595f)
                lineTo(220.949f, 53.9404f)
                curveTo(215.949f, 57.1643f, 203.449f, 64.6303f, 193.449f, 68.7026f)
                curveTo(183.449f, 72.7749f, 178.949f, 79.2228f, 177.949f, 81.9377f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(234.949f, 43.7595f)
                verticalLineTo(8.12661f)
                curveTo(255.949f, 5.5814f, 282.449f, 16.2713f, 288.949f, 28.4883f)
                curveTo(294.149f, 38.2619f, 288.449f, 68.1936f, 284.949f, 81.9377f)
                curveTo(284.616f, 79.7318f, 280.949f, 73.9966f, 268.949f, 68.7026f)
                curveTo(256.949f, 63.4086f, 246.283f, 56.6553f, 242.449f, 53.9404f)
                lineTo(234.949f, 43.7595f)
                close()
            }
        }.build()
        return _vector!!
    }

