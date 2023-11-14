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

internal val Chart: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = ImageVector.Builder(
            name = "vector",
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
                moveTo(3.46447f, 3.46447f)
                curveTo(2f, 4.9289f, 2f, 7.2859f, 2f, 12f)
                curveTo(2f, 16.714f, 2f, 19.0711f, 3.4645f, 20.5355f)
                curveTo(4.9289f, 22f, 7.2859f, 22f, 12f, 22f)
                curveTo(16.714f, 22f, 19.0711f, 22f, 20.5355f, 20.5355f)
                curveTo(22f, 19.0711f, 22f, 16.714f, 22f, 12f)
                curveTo(22f, 7.2859f, 22f, 4.9289f, 20.5355f, 3.4645f)
                curveTo(19.0711f, 2f, 16.714f, 2f, 12f, 2f)
                curveTo(7.2859f, 2f, 4.9289f, 2f, 3.4645f, 3.4645f)
                close()
                moveTo(17f, 12.25f)
                curveTo(17.4142f, 12.25f, 17.75f, 12.5858f, 17.75f, 13f)
                verticalLineTo(18f)
                curveTo(17.75f, 18.4142f, 17.4142f, 18.75f, 17f, 18.75f)
                curveTo(16.5858f, 18.75f, 16.25f, 18.4142f, 16.25f, 18f)
                verticalLineTo(13f)
                curveTo(16.25f, 12.5858f, 16.5858f, 12.25f, 17f, 12.25f)
                close()
                moveTo(12.75f, 6f)
                curveTo(12.75f, 5.5858f, 12.4142f, 5.25f, 12f, 5.25f)
                curveTo(11.5858f, 5.25f, 11.25f, 5.5858f, 11.25f, 6f)
                verticalLineTo(18f)
                curveTo(11.25f, 18.4142f, 11.5858f, 18.75f, 12f, 18.75f)
                curveTo(12.4142f, 18.75f, 12.75f, 18.4142f, 12.75f, 18f)
                verticalLineTo(6f)
                close()
                moveTo(7f, 8.25f)
                curveTo(7.4142f, 8.25f, 7.75f, 8.5858f, 7.75f, 9f)
                verticalLineTo(18f)
                curveTo(7.75f, 18.4142f, 7.4142f, 18.75f, 7f, 18.75f)
                curveTo(6.5858f, 18.75f, 6.25f, 18.4142f, 6.25f, 18f)
                verticalLineTo(9f)
                curveTo(6.25f, 8.5858f, 6.5858f, 8.25f, 7f, 8.25f)
                close()
            }
        }.build()
        return _vector!!
    }

