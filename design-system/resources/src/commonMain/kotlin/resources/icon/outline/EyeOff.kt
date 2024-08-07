package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val EyeOff: ImageVector
    get() {
        if (_EyeOff != null) {
            return _EyeOff!!
        }
        _EyeOff = ImageVector.Builder(
            name = "EyeOff",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(
                    stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 7f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round
                ) {
                    moveTo(74.75f, 74.75f)
                    curveTo(67.63f, 80.18f, 58.95f, 83.19f, 50f, 83.33f)
                    curveTo(20.83f, 83.33f, 4.17f, 50f, 4.17f, 50f)
                    curveTo(9.35f, 40.34f, 16.54f, 31.9f, 25.25f, 25.25f)
                    moveTo(41.25f, 17.67f)
                    curveTo(44.12f, 17f, 47.05f, 16.66f, 50f, 16.67f)
                    curveTo(79.17f, 16.67f, 95.83f, 50f, 95.83f, 50f)
                    curveTo(93.3f, 54.73f, 90.29f, 59.19f, 86.83f, 63.29f)
                    moveTo(58.83f, 58.83f)
                    curveTo(57.69f, 60.06f, 56.31f, 61.05f, 54.78f, 61.73f)
                    curveTo(53.24f, 62.41f, 51.59f, 62.78f, 49.91f, 62.81f)
                    curveTo(48.23f, 62.84f, 46.56f, 62.53f, 45.01f, 61.9f)
                    curveTo(43.45f, 61.27f, 42.04f, 60.34f, 40.85f, 59.15f)
                    curveTo(39.66f, 57.96f, 38.73f, 56.55f, 38.1f, 54.99f)
                    curveTo(37.47f, 53.44f, 37.16f, 51.77f, 37.19f, 50.09f)
                    curveTo(37.22f, 48.41f, 37.59f, 46.76f, 38.27f, 45.22f)
                    curveTo(38.95f, 43.69f, 39.94f, 42.31f, 41.17f, 41.17f)
                }
                path(
                    stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 7f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round
                ) {
                    moveTo(4.17f, 4.17f)
                    lineTo(95.83f, 95.83f)
                }
            }
        }.build()

        return _EyeOff!!
    }

@Suppress("ObjectPropertyName")
private var _EyeOff: ImageVector? = null
