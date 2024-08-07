package resources.icon.filled

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Logout: ImageVector
    get() {
        if (_Logout != null) {
            return _Logout!!
        }
        _Logout = ImageVector.Builder(
            name = "Logout",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(100.64f, 50f)
                    curveTo(100.64f, 77.97f, 77.97f, 100.64f, 50f, 100.64f)
                    curveTo(23.99f, 100.64f, 2.56f, 81.03f, -0.31f, 55.79f)
                    lineTo(41.82f, 55.79f)
                    lineTo(34.33f, 63.27f)
                    curveTo(32.07f, 65.53f, 32.07f, 69.19f, 34.33f, 71.45f)
                    curveTo(36.59f, 73.71f, 40.26f, 73.71f, 42.52f, 71.45f)
                    lineTo(59.88f, 54.09f)
                    curveTo(62.14f, 51.83f, 62.14f, 48.17f, 59.88f, 45.91f)
                    lineTo(42.52f, 28.55f)
                    curveTo(40.26f, 26.29f, 36.59f, 26.29f, 34.33f, 28.55f)
                    curveTo(32.07f, 30.81f, 32.07f, 34.47f, 34.33f, 36.73f)
                    lineTo(41.82f, 44.21f)
                    lineTo(-0.31f, 44.21f)
                    curveTo(2.56f, 18.97f, 23.99f, -0.64f, 50f, -0.64f)
                    curveTo(77.97f, -0.64f, 100.64f, 22.03f, 100.64f, 50f)
                    close()
                }
            }
        }.build()

        return _Logout!!
    }

@Suppress("ObjectPropertyName")
private var _Logout: ImageVector? = null
