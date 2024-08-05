package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Timer: ImageVector
    get() {
        if (_Timer != null) {
            return _Timer!!
        }
        _Timer = ImageVector.Builder(
            name = "Timer",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(56.5f, 16.2f)
                    verticalLineTo(8.44f)
                    horizontalLineTo(60.04f)
                    curveTo(62.37f, 8.44f, 64.26f, 6.55f, 64.26f, 4.22f)
                    curveTo(64.26f, 1.89f, 62.37f, 0f, 60.04f, 0f)
                    horizontalLineTo(39.96f)
                    curveTo(37.63f, 0f, 35.74f, 1.89f, 35.74f, 4.22f)
                    curveTo(35.74f, 6.55f, 37.63f, 8.44f, 39.96f, 8.44f)
                    horizontalLineTo(43.5f)
                    verticalLineTo(16.2f)
                    curveTo(23.34f, 19.34f, 7.85f, 36.82f, 7.85f, 57.85f)
                    curveTo(7.85f, 81.09f, 26.76f, 100f, 50f, 100f)
                    curveTo(73.24f, 100f, 92.15f, 81.09f, 92.15f, 57.85f)
                    curveTo(92.15f, 36.82f, 76.66f, 19.34f, 56.5f, 16.2f)
                    close()
                    moveTo(64.31f, 72.1f)
                    curveTo(63.49f, 72.93f, 62.41f, 73.35f, 61.32f, 73.35f)
                    curveTo(60.25f, 73.35f, 59.17f, 72.94f, 58.35f, 72.12f)
                    lineTo(47.02f, 60.84f)
                    curveTo(46.23f, 60.05f, 45.78f, 58.97f, 45.78f, 57.85f)
                    verticalLineTo(36.22f)
                    curveTo(45.78f, 33.89f, 47.67f, 32f, 50f, 32f)
                    curveTo(52.33f, 32f, 54.22f, 33.89f, 54.22f, 36.22f)
                    verticalLineTo(56.1f)
                    lineTo(64.3f, 66.14f)
                    curveTo(65.95f, 67.78f, 65.96f, 70.45f, 64.31f, 72.1f)
                    close()
                }
            }
        }.build()

        return _Timer!!
    }

@Suppress("ObjectPropertyName")
private var _Timer: ImageVector? = null
