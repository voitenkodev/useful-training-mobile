package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val CheckOff: ImageVector
    get() {
        if (_Checkoff != null) {
            return _Checkoff!!
        }
        _Checkoff = ImageVector.Builder(
            name = "Checkoff",
            defaultWidth = 101.dp,
            defaultHeight = 100.dp,
            viewportWidth = 101f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(50.07f, 9f)
                    curveTo(58.16f, 9f, 66.08f, 11.4f, 72.81f, 15.9f)
                    curveTo(79.54f, 20.4f, 84.78f, 26.79f, 87.88f, 34.27f)
                    curveTo(90.98f, 41.75f, 91.79f, 49.98f, 90.21f, 57.92f)
                    curveTo(88.63f, 65.86f, 84.73f, 73.15f, 79.01f, 78.87f)
                    curveTo(73.28f, 84.6f, 65.99f, 88.49f, 58.05f, 90.07f)
                    curveTo(50.11f, 91.65f, 41.88f, 90.84f, 34.41f, 87.74f)
                    curveTo(26.93f, 84.65f, 20.54f, 79.4f, 16.04f, 72.67f)
                    curveTo(11.54f, 65.94f, 9.14f, 58.03f, 9.14f, 49.93f)
                    curveTo(9.2f, 39.1f, 13.53f, 28.72f, 21.19f, 21.06f)
                    curveTo(28.86f, 13.4f, 39.23f, 9.06f, 50.07f, 9f)
                    close()
                    moveTo(50.07f, -0.09f)
                    curveTo(40.17f, -0.09f, 30.5f, 2.84f, 22.28f, 8.34f)
                    curveTo(14.05f, 13.84f, 7.64f, 21.65f, 3.85f, 30.79f)
                    curveTo(0.07f, 39.93f, -0.92f, 49.99f, 1.01f, 59.69f)
                    curveTo(2.94f, 69.39f, 7.7f, 78.31f, 14.7f, 85.3f)
                    curveTo(21.69f, 92.3f, 30.61f, 97.06f, 40.31f, 98.99f)
                    curveTo(50.01f, 100.92f, 60.07f, 99.93f, 69.21f, 96.15f)
                    curveTo(78.35f, 92.36f, 86.16f, 85.95f, 91.66f, 77.72f)
                    curveTo(97.16f, 69.5f, 100.09f, 59.83f, 100.09f, 49.93f)
                    curveTo(100.12f, 43.35f, 98.85f, 36.84f, 96.34f, 30.75f)
                    curveTo(93.84f, 24.67f, 90.16f, 19.14f, 85.51f, 14.49f)
                    curveTo(80.86f, 9.84f, 75.33f, 6.16f, 69.25f, 3.66f)
                    curveTo(63.16f, 1.15f, 56.65f, -0.12f, 50.07f, -0.09f)
                    close()
                }
            }
        }.build()

        return _Checkoff!!
    }

@Suppress("ObjectPropertyName")
private var _Checkoff: ImageVector? = null
