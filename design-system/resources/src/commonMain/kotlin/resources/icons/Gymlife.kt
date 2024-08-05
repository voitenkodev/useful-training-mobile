package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val GymLife: ImageVector
    get() {
        if (_Gymlife != null) {
            return _Gymlife!!
        }
        _Gymlife = ImageVector.Builder(
            name = "Gymlife",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(92.86f, 14.96f)
                    curveTo(86f, 7.78f, 78.41f, 4.14f, 70.31f, 4.14f)
                    curveTo(62.29f, 4.14f, 54.98f, 8.18f, 49.99f, 15.06f)
                    curveTo(45.02f, 8.18f, 37.76f, 4.14f, 29.81f, 4.14f)
                    curveTo(21.75f, 4.14f, 14.38f, 7.66f, 7.29f, 14.92f)
                    curveTo(2.64f, 19.68f, -0.09f, 27.03f, 0f, 34.58f)
                    curveTo(0.07f, 40.55f, 1.9f, 49.36f, 10.2f, 57.46f)
                    curveTo(16.66f, 63.76f, 46.79f, 94.31f, 47.09f, 94.62f)
                    curveTo(47.87f, 95.42f, 48.94f, 95.86f, 50.06f, 95.86f)
                    curveTo(51.17f, 95.86f, 52.25f, 95.42f, 53.03f, 94.62f)
                    curveTo(53.33f, 94.31f, 83.47f, 63.76f, 89.92f, 57.46f)
                    curveTo(104.64f, 43.1f, 101.09f, 23.54f, 92.86f, 14.96f)
                    close()
                    moveTo(70.88f, 50f)
                    curveTo(70.88f, 52.3f, 69.02f, 54.17f, 66.71f, 54.17f)
                    curveTo(64.4f, 54.17f, 62.54f, 52.3f, 62.54f, 50f)
                    verticalLineTo(45.83f)
                    horizontalLineTo(37.52f)
                    verticalLineTo(50f)
                    curveTo(37.52f, 52.3f, 35.66f, 54.17f, 33.35f, 54.17f)
                    curveTo(31.05f, 54.17f, 29.18f, 52.3f, 29.18f, 50f)
                    verticalLineTo(33.32f)
                    curveTo(29.18f, 31.02f, 31.05f, 29.15f, 33.35f, 29.15f)
                    curveTo(35.66f, 29.15f, 37.52f, 31.02f, 37.52f, 33.32f)
                    verticalLineTo(37.49f)
                    horizontalLineTo(62.54f)
                    verticalLineTo(33.32f)
                    curveTo(62.54f, 31.02f, 64.4f, 29.15f, 66.71f, 29.15f)
                    curveTo(69.02f, 29.15f, 70.88f, 31.02f, 70.88f, 33.32f)
                    verticalLineTo(50f)
                    close()
                }
            }
        }.build()

        return _Gymlife!!
    }

@Suppress("ObjectPropertyName")
private var _Gymlife: ImageVector? = null
