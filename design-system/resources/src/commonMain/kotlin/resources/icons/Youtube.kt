package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _YoutubeWithCircleSvgrepoCom: ImageVector? = null

internal val Youtube: ImageVector
    get() {
        if (_YoutubeWithCircleSvgrepoCom != null) {
            return _YoutubeWithCircleSvgrepoCom!!
        }
        _YoutubeWithCircleSvgrepoCom = ImageVector.Builder(
            name = "YoutubeWithCircleSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(11.603f, 9.833f)
                lineTo(9.357f, 8.785f)
                curveTo(9.161f, 8.694f, 9f, 8.796f, 9f, 9.013f)
                verticalLineToRelative(1.974f)
                curveToRelative(0f, 0.217f, 0.161f, 0.319f, 0.357f, 0.228f)
                lineToRelative(2.245f, -1.048f)
                curveToRelative(0.197f, -0.092f, 0.197f, -0.242f, 0.001f, -0.334f)
                close()
                moveTo(10f, 0.4f)
                curveTo(4.698f, 0.4f, 0.4f, 4.698f, 0.4f, 10f)
                reflectiveCurveToRelative(4.298f, 9.6f, 9.6f, 9.6f)
                reflectiveCurveToRelative(9.6f, -4.298f, 9.6f, -9.6f)
                reflectiveCurveTo(15.302f, 0.4f, 10f, 0.4f)
                close()
                moveToRelative(0f, 13.5f)
                curveToRelative(-4.914f, 0f, -5f, -0.443f, -5f, -3.9f)
                reflectiveCurveToRelative(0.086f, -3.9f, 5f, -3.9f)
                reflectiveCurveToRelative(5f, 0.443f, 5f, 3.9f)
                reflectiveCurveToRelative(-0.086f, 3.9f, -5f, 3.9f)
                close()
            }
        }.build()
        return _YoutubeWithCircleSvgrepoCom!!
    }