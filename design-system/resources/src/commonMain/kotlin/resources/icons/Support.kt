package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _vector: ImageVector? = null

internal val Support: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 56f,
            viewportHeight = 56f
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
                moveTo(26.8867f, 37.5039f)
                curveTo(28.5039f, 37.5039f, 29.2539f, 36.3789f, 29.2539f, 34.8789f)
                lineTo(29.2539f, 34.082f)
                curveTo(29.3008f, 30.9883f, 30.4258f, 29.6992f, 34.1758f, 27.1211f)
                curveTo(38.1836f, 24.4023f, 40.7383f, 21.2617f, 40.7383f, 16.7383f)
                curveTo(40.7383f, 9.707f, 35.0195f, 5.6758f, 27.918f, 5.6758f)
                curveTo(22.6211f, 5.6758f, 17.957f, 8.1836f, 15.9648f, 12.707f)
                curveTo(15.4726f, 13.8086f, 15.2617f, 14.8867f, 15.2617f, 15.7774f)
                curveTo(15.2617f, 17.1133f, 16.0352f, 18.0508f, 17.4648f, 18.0508f)
                curveTo(18.6601f, 18.0508f, 19.457f, 17.3477f, 19.8086f, 16.1992f)
                curveTo(21.0274f, 11.7461f, 23.957f, 10.0586f, 27.7539f, 10.0586f)
                curveTo(32.3242f, 10.0586f, 35.8867f, 12.6367f, 35.8867f, 16.7148f)
                curveTo(35.8867f, 20.0664f, 33.8008f, 21.9414f, 30.8008f, 24.0508f)
                curveTo(27.1211f, 26.6055f, 24.4258f, 29.3477f, 24.4258f, 33.4726f)
                lineTo(24.4258f, 34.9492f)
                curveTo(24.4258f, 36.4492f, 25.2461f, 37.5039f, 26.8867f, 37.5039f)
                close()
                moveTo(26.8867f, 50.3242f)
                curveTo(28.7383f, 50.3242f, 30.2148f, 48.8242f, 30.2148f, 46.9961f)
                curveTo(30.2148f, 45.1445f, 28.7383f, 43.668f, 26.8867f, 43.668f)
                curveTo(25.0586f, 43.668f, 23.5352f, 45.1445f, 23.5352f, 46.9961f)
                curveTo(23.5352f, 48.8242f, 25.0586f, 50.3242f, 26.8867f, 50.3242f)
                close()
            }
        }.build()
        return _vector!!
    }

