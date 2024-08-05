package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Search: ImageVector
    get() {
        if (_Search != null) {
            return _Search!!
        }
        _Search = ImageVector.Builder(
            name = "Search",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(96.71f, 80.82f)
                    lineTo(86.42f, 70.53f)
                    curveTo(90.85f, 63.17f, 93.13f, 54.85f, 93.12f, 46.56f)
                    curveTo(93.13f, 34.67f, 88.56f, 22.71f, 79.48f, 13.64f)
                    curveTo(70.41f, 4.56f, 58.45f, -0.01f, 46.56f, 0f)
                    curveTo(34.67f, -0.01f, 22.71f, 4.56f, 13.64f, 13.64f)
                    curveTo(4.56f, 22.71f, -0.01f, 34.67f, -0f, 46.56f)
                    curveTo(-0.01f, 58.44f, 4.56f, 70.41f, 13.64f, 79.48f)
                    curveTo(22.7f, 88.56f, 34.67f, 93.13f, 46.56f, 93.12f)
                    curveTo(54.85f, 93.13f, 63.17f, 90.85f, 70.53f, 86.42f)
                    lineTo(80.82f, 96.7f)
                    curveTo(85.21f, 101.09f, 92.32f, 101.09f, 96.71f, 96.7f)
                    curveTo(101.1f, 92.32f, 101.1f, 85.21f, 96.71f, 80.82f)
                    close()
                    moveTo(66.77f, 66.77f)
                    curveTo(61.17f, 72.37f, 53.91f, 75.14f, 46.56f, 75.14f)
                    curveTo(39.21f, 75.14f, 31.96f, 72.37f, 26.35f, 66.77f)
                    curveTo(20.75f, 61.16f, 17.99f, 53.9f, 17.98f, 46.56f)
                    curveTo(17.99f, 39.21f, 20.75f, 31.95f, 26.35f, 26.35f)
                    curveTo(31.95f, 20.75f, 39.21f, 17.99f, 46.56f, 17.98f)
                    curveTo(53.91f, 17.99f, 61.17f, 20.75f, 66.77f, 26.35f)
                    curveTo(72.37f, 31.95f, 75.13f, 39.21f, 75.15f, 46.56f)
                    curveTo(75.13f, 53.9f, 72.37f, 61.16f, 66.77f, 66.77f)
                    close()
                }
            }
        }.build()

        return _Search!!
    }

@Suppress("ObjectPropertyName")
private var _Search: ImageVector? = null
