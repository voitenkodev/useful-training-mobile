package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _Vector: ImageVector? = null

public val MediumBattery: ImageVector
    get() {
        if (_Vector != null) {
            return _Vector!!
        }
        _Vector = ImageVector.Builder(
            name = "Vector",
            defaultWidth = 741.dp,
            defaultHeight = 692.dp,
            viewportWidth = 741f,
            viewportHeight = 692f
        ).apply {
            path(
                fill = SolidColor(Color(0xffffba00)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(277f, 251.875f)
                curveTo(277f, 216.999f, 304.906f, 189f, 339.667f, 189f)
                horizontalLineTo(402.333f)
                curveTo(437.094f, 189f, 465f, 216.999f, 465f, 251.875f)
                verticalLineTo(629.125f)
                curveTo(465f, 664.001f, 437.094f, 692f, 402.333f, 692f)
                horizontalLineTo(339.667f)
                curveTo(304.906f, 692f, 277f, 664.001f, 277f, 629.125f)
                verticalLineTo(251.875f)
                close()
            }
            path(
                fill = SolidColor(Color(0xffffba00)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(26f, 440.8f)
                curveTo(26f, 405.966f, 53.9062f, 378f, 88.6667f, 378f)
                horizontalLineTo(151.333f)
                curveTo(186.094f, 378f, 214f, 405.966f, 214f, 440.8f)
                verticalLineTo(629.2f)
                curveTo(214f, 664.034f, 186.094f, 692f, 151.333f, 692f)
                horizontalLineTo(88.6667f)
                curveTo(53.9062f, 692f, 26f, 664.034f, 26f, 629.2f)
                verticalLineTo(440.8f)
                close()
            }
            path(
                fill = SolidColor(Color(0x1Affffff)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(526f, 62.9091f)
                curveTo(526f, 28.0142f, 554.055f, 0f, 589f, 0f)
                horizontalLineTo(652f)
                curveTo(686.945f, 0f, 715f, 28.0142f, 715f, 62.9091f)
                verticalLineTo(629.091f)
                curveTo(715f, 663.986f, 686.945f, 692f, 652f, 692f)
                horizontalLineTo(589f)
                curveTo(554.055f, 692f, 526f, 663.986f, 526f, 629.091f)
                verticalLineTo(62.9091f)
                close()
            }
        }.build()
        return _Vector!!
    }


