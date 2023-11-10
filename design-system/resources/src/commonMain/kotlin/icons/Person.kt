package icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


private var _vector: ImageVector? = null

public val Person: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 512f,
            viewportHeight = 512f
        ).apply {
            group {
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
                    moveTo(458.159f, 404.216f)
                    curveToRelative(-18.93f, -33.65f, -49.934f, -71.764f, -100.409f, -93.431f)
                    curveToRelative(-28.868f, 20.196f, -63.938f, 32.087f, -101.745f, 32.087f)
                    curveToRelative(-37.828f, 0f, -72.898f, -11.89f, -101.767f, -32.087f)
                    curveToRelative(-50.474f, 21.667f, -81.479f, 59.782f, -100.398f, 93.431f)
                    curveTo(28.731f, 448.848f, 48.417f, 512f, 91.842f, 512f)
                    curveToRelative(43.426f, 0f, 164.164f, 0f, 164.164f, 0f)
                    reflectiveCurveToRelative(120.726f, 0f, 164.153f, 0f)
                    curveTo(463.583f, 512f, 483.269f, 448.848f, 458.159f, 404.216f)
                    close()
                }
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
                    moveTo(256.005f, 300.641f)
                    curveToRelative(74.144f, 0f, 134.231f, -60.108f, 134.231f, -134.242f)
                    verticalLineToRelative(-32.158f)
                    curveTo(390.236f, 60.108f, 330.149f, 0f, 256.005f, 0f)
                    curveToRelative(-74.155f, 0f, -134.252f, 60.108f, -134.252f, 134.242f)
                    verticalLineTo(166.4f)
                    curveTo(121.753f, 240.533f, 181.851f, 300.641f, 256.005f, 300.641f)
                    close()
                }
            }
        }.build()
        return _vector!!
    }
