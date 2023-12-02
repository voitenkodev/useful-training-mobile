package icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _PlayCircleSvgrepoCom: ImageVector? = null

public val Play: ImageVector
    get() {
        if (_PlayCircleSvgrepoCom != null) {
            return _PlayCircleSvgrepoCom!!
        }
        _PlayCircleSvgrepoCom = ImageVector.Builder(
            name = "PlayCircleSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF1C274C)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(12f, 22f)
                curveTo(17.5228f, 22f, 22f, 17.5228f, 22f, 12f)
                curveTo(22f, 6.4771f, 17.5228f, 2f, 12f, 2f)
                curveTo(6.4771f, 2f, 2f, 6.4771f, 2f, 12f)
                curveTo(2f, 17.5228f, 6.4771f, 22f, 12f, 22f)
                close()
                moveTo(10.6935f, 15.8458f)
                lineTo(15.4137f, 13.059f)
                curveTo(16.1954f, 12.5974f, 16.1954f, 11.4026f, 15.4137f, 10.941f)
                lineTo(10.6935f, 8.15419f)
                curveTo(9.9337f, 7.7056f, 9f, 8.2895f, 9f, 9.2132f)
                verticalLineTo(14.7868f)
                curveTo(9f, 15.7105f, 9.9337f, 16.2944f, 10.6935f, 15.8458f)
                close()
            }
        }.build()
        return _PlayCircleSvgrepoCom!!
    }

