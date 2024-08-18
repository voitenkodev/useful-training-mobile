package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val UserWeight: ImageVector
    get() {
        if (_UserWeight != null) {
            return _UserWeight!!
        }
        _UserWeight = ImageVector.Builder(
            name = "UserWeight",
            defaultWidth = 84.dp,
            defaultHeight = 94.dp,
            viewportWidth = 84f,
            viewportHeight = 94f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF292D32)),
                strokeLineWidth = 6f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(33.667f, 88.667f)
                horizontalLineTo(50.333f)
                curveTo(71.167f, 88.667f, 79.5f, 80.333f, 79.5f, 59.5f)
                verticalLineTo(34.5f)
                curveTo(79.5f, 13.667f, 71.167f, 5.333f, 50.333f, 5.333f)
                horizontalLineTo(33.667f)
                curveTo(12.833f, 5.333f, 4.5f, 13.667f, 4.5f, 34.5f)
                verticalLineTo(59.5f)
                curveTo(4.5f, 80.333f, 12.833f, 88.667f, 33.667f, 88.667f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF292D32)),
                strokeLineWidth = 6f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(63.875f, 31.542f)
                curveTo(51.417f, 20.458f, 32.583f, 20.458f, 20.125f, 31.542f)
                lineTo(29.208f, 46.125f)
                curveTo(36.5f, 39.625f, 47.5f, 39.625f, 54.792f, 46.125f)
                lineTo(63.875f, 31.542f)
                close()
            }
        }.build()

        return _UserWeight!!
    }

@Suppress("ObjectPropertyName")
private var _UserWeight: ImageVector? = null
