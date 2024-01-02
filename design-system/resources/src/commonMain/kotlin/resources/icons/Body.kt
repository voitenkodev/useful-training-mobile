package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _MusculousArmSilhouetteSvgrepoCom: ImageVector? = null

public val Biceps: ImageVector
    get() {
        if (_MusculousArmSilhouetteSvgrepoCom != null) {
            return _MusculousArmSilhouetteSvgrepoCom!!
        }
        _MusculousArmSilhouetteSvgrepoCom = ImageVector.Builder(
            name = "MusculousArmSilhouetteSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 471.787f,
            viewportHeight = 471.787f
        ).apply {
            group {
                group {
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
                        moveTo(360.852f, 35.142f)
                        curveToRelative(-15.477f, -18.056f, -102.336f, -61.626f, -149.625f, -12.615f)
                        curveToRelative(-47.29f, 49.01f, 2.952f, 83.636f, 21.012f, 91.97f)
                        curveToRelative(18.057f, 8.334f, 69.647f, 21.066f, 88.354f, -11.607f)
                        curveToRelative(4.99f, 12.785f, 1.623f, 119.131f, -27.865f, 146.17f)
                        curveToRelative(-14.942f, -14.246f, -36.51f, -23.19f, -60.488f, -23.19f)
                        curveToRelative(-19.689f, 0f, -37.746f, 6.031f, -51.85f, 16.073f)
                        curveToRelative(-18.619f, -29.884f, -53.845f, -50.062f, -94.271f, -50.062f)
                        curveToRelative(-19.383f, 0f, -37.563f, 4.659f, -53.308f, 12.782f)
                        verticalLineToRelative(10.448f)
                        curveToRelative(-0.013f, -0.003f, -0.056f, -0.013f, -0.056f, -0.013f)
                        verticalLineToRelative(256.662f)
                        curveToRelative(0f, 0f, 74.807f, 3.87f, 80.791f, -82.544f)
                        curveToRelative(-0.002f, -0.005f, -0.005f, -0.01f, -0.005f, -0.015f)
                        curveToRelative(18.198f, 26.427f, 76.18f, 46.541f, 111.909f, 45.355f)
                        curveToRelative(56.121f, -1.861f, 130.693f, -4.321f, 193.865f, -64.881f)
                        curveToRelative(5.838f, -5.809f, 10.52f, -12.669f, 13.701f, -20.259f)
                        curveToRelative(0f, -0.002f, 0f, -0.002f, 0f, -0.004f)
                        curveTo(462.242f, 288.615f, 376.328f, 53.198f, 360.852f, 35.142f)
                        close()
                    }
                }
            }
        }.build()
        return _MusculousArmSilhouetteSvgrepoCom!!
    }