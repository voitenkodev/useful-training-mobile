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

internal val Notifications: ImageVector
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
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(9.33497f, 4.72727f)
                verticalLineTo(5.25342f)
                curveTo(6.6452f, 6.3564f, 4.7659f, 9.9794f, 4.8341f, 13.1192f)
                lineTo(4.83409f, 14.8631f)
                curveTo(3.4571f, 16.6333f, 3.5381f, 19.2727f, 6.9735f, 19.2727f)
                horizontalLineTo(9.33497f)
                curveTo(9.335f, 19.996f, 9.6168f, 20.6897f, 10.1186f, 21.2012f)
                curveTo(10.6203f, 21.7127f, 11.3008f, 22f, 12.0104f, 22f)
                curveTo(12.72f, 22f, 13.4005f, 21.7127f, 13.9022f, 21.2012f)
                curveTo(14.404f, 20.6897f, 14.6858f, 19.996f, 14.6858f, 19.2727f)
                horizontalLineTo(17.0538f)
                curveTo(20.4826f, 19.2727f, 20.5323f, 16.6278f, 19.1555f, 14.8576f)
                lineTo(19.1938f, 13.1216f)
                curveTo(19.2631f, 9.9781f, 17.3803f, 6.3519f, 14.6858f, 5.2505f)
                verticalLineTo(4.72727f)
                curveTo(14.6858f, 4.004f, 14.404f, 3.3103f, 13.9022f, 2.7988f)
                curveTo(13.4005f, 2.2873f, 12.72f, 2f, 12.0104f, 2f)
                curveTo(11.3008f, 2f, 10.6203f, 2.2873f, 10.1186f, 2.7988f)
                curveTo(9.6168f, 3.3103f, 9.335f, 4.0039f, 9.335f, 4.7273f)
                close()
                moveTo(12.9022f, 4.72727f)
                curveTo(12.9022f, 4.7457f, 12.9017f, 4.7641f, 12.9006f, 4.7825f)
                curveTo(12.6101f, 4.746f, 12.3142f, 4.7273f, 12.014f, 4.7273f)
                curveTo(11.7113f, 4.7273f, 11.413f, 4.7463f, 11.1203f, 4.7834f)
                curveTo(11.1192f, 4.7647f, 11.1186f, 4.746f, 11.1186f, 4.7273f)
                curveTo(11.1186f, 4.4862f, 11.2126f, 4.2549f, 11.3798f, 4.0845f)
                curveTo(11.547f, 3.914f, 11.7739f, 3.8182f, 12.0104f, 3.8182f)
                curveTo(12.2469f, 3.8182f, 12.4738f, 3.914f, 12.641f, 4.0845f)
                curveTo(12.8083f, 4.2549f, 12.9022f, 4.4862f, 12.9022f, 4.7273f)
                close()
                moveTo(11.1186f, 19.2727f)
                curveTo(11.1186f, 19.5138f, 11.2126f, 19.7451f, 11.3798f, 19.9156f)
                curveTo(11.547f, 20.086f, 11.7739f, 20.1818f, 12.0104f, 20.1818f)
                curveTo(12.2469f, 20.1818f, 12.4738f, 20.086f, 12.641f, 19.9156f)
                curveTo(12.8083f, 19.7451f, 12.9022f, 19.5138f, 12.9022f, 19.2727f)
                horizontalLineTo(11.1186f)
                close()
                moveTo(17.0538f, 17.4545f)
                curveTo(17.8157f, 17.4545f, 18.2267f, 16.5435f, 17.7309f, 15.9538f)
                curveTo(17.49f, 15.6673f, 17.3616f, 15.3028f, 17.3699f, 14.9286f)
                lineTo(17.4106f, 13.0808f)
                curveTo(17.4787f, 9.9942f, 15.0427f, 6.5454f, 12.014f, 6.5454f)
                curveTo(8.986f, 6.5454f, 6.5503f, 9.993f, 6.6173f, 13.0789f)
                lineTo(6.65748f, 14.9289f)
                curveTo(6.6656f, 15.303f, 6.5373f, 15.6674f, 6.2964f, 15.9538f)
                curveTo(5.8005f, 16.5435f, 6.2116f, 17.4545f, 6.9735f, 17.4545f)
                horizontalLineTo(17.0538f)
                close()
            }
        }.build()
        return _vector!!
    }

