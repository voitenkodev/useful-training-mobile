package resources.icon.menu

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Profile: ImageVector
    get() {
        if (_Profile != null) {
            return _Profile!!
        }
        _Profile = ImageVector.Builder(
            name = "Profile",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(50f, 50f)
                curveTo(63.81f, 50f, 75f, 38.81f, 75f, 25f)
                curveTo(75f, 11.19f, 63.81f, 0f, 50f, 0f)
                curveTo(36.19f, 0f, 25f, 11.19f, 25f, 25f)
                curveTo(25f, 38.81f, 36.19f, 50f, 50f, 50f)
                close()
                moveTo(67.5f, 56.25f)
                horizontalLineTo(64.24f)
                curveTo(59.9f, 58.24f, 55.08f, 59.38f, 50f, 59.38f)
                curveTo(44.92f, 59.38f, 40.12f, 58.24f, 35.76f, 56.25f)
                horizontalLineTo(32.5f)
                curveTo(18.01f, 56.25f, 6.25f, 68.01f, 6.25f, 82.5f)
                verticalLineTo(90.63f)
                curveTo(6.25f, 95.8f, 10.45f, 100f, 15.63f, 100f)
                horizontalLineTo(84.38f)
                curveTo(89.55f, 100f, 93.75f, 95.8f, 93.75f, 90.63f)
                verticalLineTo(82.5f)
                curveTo(93.75f, 68.01f, 81.99f, 56.25f, 67.5f, 56.25f)
                close()
            }
        }.build()

        return _Profile!!
    }

@Suppress("ObjectPropertyName")
private var _Profile: ImageVector? = null
