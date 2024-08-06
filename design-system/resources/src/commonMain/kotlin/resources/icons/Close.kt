package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Close: ImageVector
    get() {
        if (_Close != null) {
            return _Close!!
        }
        _Close = ImageVector.Builder(
            name = "Close",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(11.05f, 81.68f)
                lineTo(42.79f, 50f)
                lineTo(11.05f, 18.32f)
                curveTo(10.14f, 17.37f, 9.63f, 16.1f, 9.64f, 14.78f)
                curveTo(9.65f, 13.46f, 10.18f, 12.2f, 11.12f, 11.26f)
                curveTo(12.05f, 10.33f, 13.32f, 9.8f, 14.64f, 9.79f)
                curveTo(15.96f, 9.78f, 17.23f, 10.29f, 18.19f, 11.2f)
                lineTo(49.92f, 42.88f)
                lineTo(81.66f, 11.2f)
                curveTo(82.13f, 10.72f, 82.68f, 10.34f, 83.3f, 10.07f)
                curveTo(83.92f, 9.81f, 84.58f, 9.67f, 85.25f, 9.67f)
                curveTo(85.92f, 9.66f, 86.58f, 9.79f, 87.2f, 10.04f)
                curveTo(87.82f, 10.29f, 88.38f, 10.67f, 88.86f, 11.14f)
                curveTo(89.33f, 11.61f, 89.71f, 12.18f, 89.96f, 12.79f)
                curveTo(90.21f, 13.41f, 90.34f, 14.08f, 90.33f, 14.74f)
                curveTo(90.33f, 15.41f, 90.19f, 16.07f, 89.92f, 16.69f)
                curveTo(89.66f, 17.3f, 89.28f, 17.86f, 88.79f, 18.32f)
                lineTo(57.06f, 50f)
                lineTo(88.79f, 81.68f)
                curveTo(89.28f, 82.14f, 89.66f, 82.7f, 89.92f, 83.31f)
                curveTo(90.19f, 83.93f, 90.33f, 84.59f, 90.33f, 85.26f)
                curveTo(90.34f, 85.92f, 90.21f, 86.59f, 89.96f, 87.21f)
                curveTo(89.71f, 87.82f, 89.33f, 88.39f, 88.86f, 88.86f)
                curveTo(88.38f, 89.33f, 87.82f, 89.71f, 87.2f, 89.96f)
                curveTo(86.58f, 90.21f, 85.92f, 90.34f, 85.25f, 90.33f)
                curveTo(84.58f, 90.33f, 83.92f, 90.19f, 83.3f, 89.93f)
                curveTo(82.68f, 89.66f, 82.13f, 89.28f, 81.66f, 88.8f)
                lineTo(49.92f, 57.12f)
                lineTo(18.19f, 88.8f)
                curveTo(17.23f, 89.71f, 15.96f, 90.22f, 14.64f, 90.21f)
                curveTo(13.32f, 90.2f, 12.05f, 89.67f, 11.12f, 88.74f)
                curveTo(10.18f, 87.8f, 9.65f, 86.54f, 9.64f, 85.22f)
                curveTo(9.63f, 83.9f, 10.14f, 82.63f, 11.05f, 81.68f)
                close()
            }
        }.build()

        return _Close!!
    }

@Suppress("ObjectPropertyName")
private var _Close: ImageVector? = null
