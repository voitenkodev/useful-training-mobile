package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _StraightBar: ImageVector? = null

public val StraightBar: ImageVector
    get() {
        if (_StraightBar != null) {
            return _StraightBar!!
        }
        _StraightBar = ImageVector.Builder(
            name = "StraightBar",
            defaultWidth = 183.dp,
            defaultHeight = 113.dp,
            viewportWidth = 183f,
            viewportHeight = 113f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF262C31)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 0.2f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(3.38511f, 3.01258f)
                curveTo(0.205f, 5.9196f, 0.205f, 11.0803f, 3.3851f, 13.9874f)
                curveTo(6.3206f, 16.6709f, 10.6794f, 16.6709f, 13.6149f, 13.9874f)
                curveTo(16.795f, 11.0803f, 16.795f, 5.9196f, 13.6149f, 3.0126f)
                curveTo(10.6794f, 0.3291f, 6.3206f, 0.3291f, 3.3851f, 3.0126f)
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
                moveTo(177.394f, 100.902f)
                lineTo(14.1741f, 5.87061f)
                curveTo(7.4992f, 6.9999f, 8f, 10.9999f, 8.4918f, 14.688f)
                lineTo(172.299f, 109.328f)
                lineTo(177.394f, 100.902f)
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
                moveTo(22.5f, 22f)
                curveTo(21.873f, 17.7677f, 25.6539f, 15.2352f, 27.6133f, 14.0596f)
                lineTo(54.8493f, 29.9309f)
                curveTo(51.2439f, 31.1849f, 49.6959f, 35.5834f, 49.5f, 38f)
                lineTo(22.5f, 22f)
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
                moveTo(122.5f, 80.5f)
                curveTo(121.873f, 76.2677f, 125.363f, 73.295f, 127.322f, 72.1194f)
                lineTo(154.558f, 87.9907f)
                curveTo(150.953f, 89.2447f, 150.196f, 93.5834f, 150f, 96f)
                lineTo(122.5f, 80.5f)
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
                moveTo(66.0002f, 46.9998f)
                curveTo(66.4002f, 43.7998f, 69.8335f, 40.3331f, 71.5002f, 38.9998f)
                curveTo(75.9002f, 38.1998f, 85.5001f, 42.9999f, 89f, 44.9999f)
                curveTo(87f, 36.4999f, 93.2982f, 27.3283f, 100.5f, 28.4998f)
                curveTo(104.054f, 29.0779f, 102.5f, 34.9999f, 102.5f, 34.9999f)
                curveTo(92f, 28.9999f, 91f, 40.4999f, 94.5f, 41.9999f)
                lineTo(94f, 48.9999f)
                curveTo(92f, 49.7999f, 101.5f, 65.4998f, 100.5f, 67.9998f)
                curveTo(88.8335f, 62.3331f, 65.6002f, 50.1998f, 66.0002f, 46.9998f)
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
                moveTo(106.498f, 69.9297f)
                curveTo(107.5f, 67f, 108f, 63.5f, 110.497f, 62.0015f)
                curveTo(108.954f, 57.8038f, 99.317f, 51.1233f, 96.4975f, 48.5015f)
                curveTo(104.997f, 44.5015f, 107.5f, 29.9999f, 100.5f, 28.5f)
                curveTo(98.4343f, 28.0574f, 97.4985f, 33.0007f, 97.4985f, 33.0007f)
                curveTo(105f, 35.4999f, 98.498f, 44.5011f, 94.498f, 42.0011f)
                curveTo(90.3186f, 39.3889f, 87.4968f, 52.5015f, 87.4968f, 52.5015f)
                lineTo(82.998f, 59.0011f)
                curveTo(94.4989f, 66.0004f, 105.455f, 72.9811f, 106.498f, 69.9297f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 0.2f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(169.385f, 99.0126f)
                curveTo(166.205f, 101.92f, 166.205f, 107.08f, 169.385f, 109.987f)
                curveTo(172.321f, 112.671f, 176.679f, 112.671f, 179.615f, 109.987f)
                curveTo(182.795f, 107.08f, 182.795f, 101.92f, 179.615f, 99.0126f)
                curveTo(176.679f, 96.3291f, 172.321f, 96.3291f, 169.385f, 99.0126f)
                close()
            }
        }.build()
        return _StraightBar!!
    }