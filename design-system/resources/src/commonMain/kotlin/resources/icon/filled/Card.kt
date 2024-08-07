package resources.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Card: ImageVector
    get() {
        if (_Card != null) {
            return _Card!!
        }
        _Card = ImageVector.Builder(
            name = "Card",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(100.1f, 27.77f)
                    curveTo(100.1f, 31.07f, 97.4f, 33.78f, 94.09f, 33.78f)
                    horizontalLineTo(6.01f)
                    curveTo(2.7f, 33.78f, 0f, 31.07f, 0f, 27.77f)
                    verticalLineTo(27.72f)
                    curveTo(0f, 16.26f, 9.26f, 7f, 20.72f, 7f)
                    horizontalLineTo(79.33f)
                    curveTo(90.79f, 7f, 100.1f, 16.31f, 100.1f, 27.77f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(0f, 47.3f)
                    verticalLineTo(72.37f)
                    curveTo(0f, 83.83f, 9.26f, 93.09f, 20.72f, 93.09f)
                    horizontalLineTo(79.33f)
                    curveTo(90.79f, 93.09f, 100.1f, 83.78f, 100.1f, 72.32f)
                    verticalLineTo(47.3f)
                    curveTo(100.1f, 43.99f, 97.4f, 41.29f, 94.09f, 41.29f)
                    horizontalLineTo(6.01f)
                    curveTo(2.7f, 41.29f, 0f, 43.99f, 0f, 47.3f)
                    close()
                    moveTo(30.03f, 76.33f)
                    horizontalLineTo(20.02f)
                    curveTo(17.97f, 76.33f, 16.27f, 74.63f, 16.27f, 72.57f)
                    curveTo(16.27f, 70.52f, 17.97f, 68.82f, 20.02f, 68.82f)
                    horizontalLineTo(30.03f)
                    curveTo(32.08f, 68.82f, 33.78f, 70.52f, 33.78f, 72.57f)
                    curveTo(33.78f, 74.63f, 32.08f, 76.33f, 30.03f, 76.33f)
                    close()
                    moveTo(62.56f, 76.33f)
                    horizontalLineTo(42.54f)
                    curveTo(40.49f, 76.33f, 38.79f, 74.63f, 38.79f, 72.57f)
                    curveTo(38.79f, 70.52f, 40.49f, 68.82f, 42.54f, 68.82f)
                    horizontalLineTo(62.56f)
                    curveTo(64.61f, 68.82f, 66.32f, 70.52f, 66.32f, 72.57f)
                    curveTo(66.32f, 74.63f, 64.61f, 76.33f, 62.56f, 76.33f)
                    close()
                }
            }
        }.build()

        return _Card!!
    }

@Suppress("ObjectPropertyName")
private var _Card: ImageVector? = null
