package icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _time: ImageVector? = null

public val Time: ImageVector
    get() {
        if (_time != null) {
            return _time!!
        }
        _time = ImageVector.Builder(
            name = "vector",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(13.148f, 20.139f)
                lineToRelative(1.426f, -1.426f)
                curveToRelative(0.197f, -0.197f, 0.516f, -0.197f, 0.713f, 0f)
                curveToRelative(0.197f, 0.197f, 0.197f, 0.516f, 0f, 0.713f)
                lineToRelative(-1.426f, 1.426f)
                curveToRelative(-0.197f, 0.197f, -0.516f, 0.197f, -0.713f, 0f)
                curveTo(12.951f, 20.655f, 12.951f, 20.336f, 13.148f, 20.139f)
                close()
                moveTo(16.713f, 17.287f)
                curveToRelative(0.197f, 0.197f, 0.516f, 0.197f, 0.713f, 0f)
                lineToRelative(1.426f, -1.426f)
                curveToRelative(0.197f, -0.197f, 0.197f, -0.516f, 0f, -0.713f)
                curveToRelative(-0.197f, -0.197f, -0.516f, -0.197f, -0.713f, 0f)
                lineToRelative(-1.426f, 1.426f)
                curveTo(16.516f, 16.771f, 16.516f, 17.09f, 16.713f, 17.287f)
                close()
                moveTo(18.852f, 20.852f)
                curveToRelative(0.197f, -0.197f, 0.197f, -0.516f, 0f, -0.713f)
                lineToRelative(-1.426f, -1.426f)
                curveToRelative(-0.197f, -0.197f, -0.516f, -0.197f, -0.713f, 0f)
                reflectiveCurveToRelative(-0.197f, 0.516f, 0f, 0.713f)
                lineToRelative(1.426f, 1.426f)
                curveTo(18.336f, 21.049f, 18.655f, 21.049f, 18.852f, 20.852f)
                close()
                moveTo(15.287f, 17.287f)
                curveToRelative(0.197f, -0.197f, 0.197f, -0.516f, 0f, -0.713f)
                lineToRelative(-1.426f, -1.426f)
                curveToRelative(-0.197f, -0.197f, -0.516f, -0.197f, -0.713f, 0f)
                curveToRelative(-0.197f, 0.197f, -0.197f, 0.516f, 0f, 0.713f)
                lineToRelative(1.426f, 1.426f)
                curveTo(14.771f, 17.484f, 15.09f, 17.484f, 15.287f, 17.287f)
                close()
                moveTo(25.529f, 23.067f)
                curveToRelative(-0.116f, -0.145f, -0.146f, -0.35f, -0.06f, -0.528f)
                curveToRelative(0.271f, -0.564f, 0.492f, -1.156f, 0.657f, -1.762f)
                curveToRelative(0.073f, -0.266f, 0.347f, -0.424f, 0.614f, -0.35f)
                curveToRelative(0.266f, 0.071f, 0.423f, 0.346f, 0.351f, 0.613f)
                curveToRelative(-0.181f, 0.665f, -0.423f, 1.314f, -0.72f, 1.932f)
                curveToRelative(-0.12f, 0.249f, -0.419f, 0.354f, -0.667f, 0.234f)
                curveTo(25.633f, 23.173f, 25.575f, 23.125f, 25.529f, 23.067f)
                close()
                moveTo(16.093f, 7.321f)
                curveToRelative(-0.072f, -0.091f, -0.114f, -0.208f, -0.109f, -0.333f)
                curveToRelative(0.013f, -0.276f, 0.245f, -0.49f, 0.522f, -0.478f)
                curveToRelative(0.687f, 0.03f, 1.374f, 0.122f, 2.043f, 0.273f)
                curveToRelative(0.268f, 0.06f, 0.437f, 0.328f, 0.377f, 0.598f)
                curveToRelative(-0.061f, 0.269f, -0.329f, 0.438f, -0.598f, 0.377f)
                curveToRelative(-0.611f, -0.138f, -1.238f, -0.222f, -1.865f, -0.25f)
                curveTo(16.312f, 7.503f, 16.18f, 7.431f, 16.093f, 7.321f)
                close()
                moveTo(26.607f, 18.295f)
                curveToRelative(-0.068f, -0.086f, -0.109f, -0.193f, -0.109f, -0.31f)
                curveToRelative(-0.001f, -0.626f, -0.059f, -1.257f, -0.171f, -1.875f)
                curveToRelative(-0.05f, -0.271f, 0.13f, -0.532f, 0.402f, -0.581f)
                curveToRelative(0.272f, -0.05f, 0.533f, 0.131f, 0.581f, 0.402f)
                curveToRelative(0.123f, 0.676f, 0.187f, 1.367f, 0.188f, 2.052f)
                curveToRelative(0.001f, 0.276f, -0.223f, 0.501f, -0.499f, 0.501f)
                curveTo(26.841f, 18.483f, 26.699f, 18.41f, 26.607f, 18.295f)
                close()
                moveTo(20.812f, 8.617f)
                curveToRelative(-0.12f, -0.151f, -0.147f, -0.366f, -0.049f, -0.549f)
                curveToRelative(0.131f, -0.243f, 0.434f, -0.334f, 0.677f, -0.203f)
                curveToRelative(0.604f, 0.325f, 1.183f, 0.707f, 1.721f, 1.136f)
                curveToRelative(0.222f, 0.172f, 0.251f, 0.487f, 0.079f, 0.703f)
                curveToRelative(-0.172f, 0.216f, -0.486f, 0.251f, -0.702f, 0.079f)
                curveToRelative(-0.491f, -0.392f, -1.02f, -0.741f, -1.57f, -1.037f)
                curveTo(20.904f, 8.713f, 20.853f, 8.669f, 20.812f, 8.617f)
                close()
                moveTo(25.514f, 13.524f)
                curveToRelative(-0.023f, -0.028f, -0.043f, -0.06f, -0.06f, -0.095f)
                curveToRelative(-0.271f, -0.564f, -0.597f, -1.107f, -0.966f, -1.613f)
                curveToRelative(-0.163f, -0.223f, -0.114f, -0.536f, 0.108f, -0.699f)
                curveToRelative(0.223f, -0.162f, 0.546f, -0.133f, 0.699f, 0.109f)
                curveToRelative(0.406f, 0.556f, 0.762f, 1.151f, 1.061f, 1.769f)
                curveToRelative(0.119f, 0.248f, 0.015f, 0.548f, -0.234f, 0.667f)
                curveTo(25.907f, 13.766f, 25.656f, 13.703f, 25.514f, 13.524f)
                close()
                moveTo(27.378f, 9.864f)
                lineToRelative(1.817f, -1.817f)
                curveToRelative(0.195f, -0.195f, 0.195f, -0.512f, 0f, -0.707f)
                lineTo(25.66f, 3.805f)
                curveToRelative(-0.195f, -0.195f, -0.512f, -0.195f, -0.707f, 0f)
                lineToRelative(-2.034f, 2.034f)
                curveTo(21.712f, 5.151f, 20.397f, 4.636f, 19f, 4.33f)
                verticalLineTo(1.5f)
                curveTo(19f, 1.224f, 18.776f, 1f, 18.5f, 1f)
                horizontalLineToRelative(-5f)
                curveTo(13.224f, 1f, 13f, 1.224f, 13f, 1.5f)
                verticalLineToRelative(2.83f)
                curveTo(6.711f, 5.705f, 2f, 11.299f, 2f, 18f)
                curveToRelative(0f, 7.732f, 6.268f, 14f, 14f, 14f)
                reflectiveCurveToRelative(14f, -6.268f, 14f, -14f)
                curveTo(30f, 14.962f, 29.022f, 12.159f, 27.378f, 9.864f)
                close()
                moveTo(25.307f, 4.865f)
                lineToRelative(2.828f, 2.829f)
                lineTo(26.77f, 9.058f)
                curveToRelative(-0.856f, -1.03f, -1.857f, -1.936f, -2.972f, -2.685f)
                lineTo(25.307f, 4.865f)
                close()
                moveTo(14f, 2f)
                horizontalLineToRelative(4f)
                verticalLineToRelative(2.159f)
                curveTo(17.345f, 4.065f, 16.681f, 4f, 16f, 4f)
                reflectiveCurveToRelative(-1.345f, 0.065f, -2f, 0.159f)
                verticalLineTo(2f)
                close()
                moveTo(16f, 31f)
                curveTo(8.832f, 31f, 3f, 25.168f, 3f, 18f)
                reflectiveCurveTo(8.832f, 5f, 16f, 5f)
                reflectiveCurveToRelative(13f, 5.832f, 13f, 13f)
                reflectiveCurveTo(23.168f, 31f, 16f, 31f)
                close()
            }
        }.build()
        return _time!!
    }

