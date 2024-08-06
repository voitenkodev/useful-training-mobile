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
                moveTo(14.28f, 79.17f)
                lineTo(42.99f, 50.5f)
                lineTo(14.28f, 21.83f)
                curveTo(13.45f, 20.97f, 12.99f, 19.82f, 13f, 18.63f)
                curveTo(13.01f, 17.43f, 13.49f, 16.29f, 14.34f, 15.45f)
                curveTo(15.18f, 14.6f, 16.33f, 14.12f, 17.52f, 14.11f)
                curveTo(18.72f, 14.1f, 19.87f, 14.56f, 20.73f, 15.39f)
                lineTo(49.44f, 44.06f)
                lineTo(78.16f, 15.39f)
                curveTo(78.58f, 14.96f, 79.08f, 14.61f, 79.64f, 14.37f)
                curveTo(80.19f, 14.13f, 80.79f, 14.01f, 81.4f, 14f)
                curveTo(82f, 13.99f, 82.6f, 14.11f, 83.17f, 14.34f)
                curveTo(83.73f, 14.57f, 84.24f, 14.91f, 84.66f, 15.33f)
                curveTo(85.09f, 15.76f, 85.43f, 16.27f, 85.66f, 16.83f)
                curveTo(85.89f, 17.39f, 86.01f, 17.99f, 86f, 18.6f)
                curveTo(85.99f, 19.2f, 85.87f, 19.8f, 85.63f, 20.35f)
                curveTo(85.39f, 20.91f, 85.04f, 21.41f, 84.61f, 21.83f)
                lineTo(55.9f, 50.5f)
                lineTo(84.61f, 79.17f)
                curveTo(85.04f, 79.59f, 85.39f, 80.09f, 85.63f, 80.65f)
                curveTo(85.87f, 81.2f, 85.99f, 81.8f, 86f, 82.4f)
                curveTo(86.01f, 83.01f, 85.89f, 83.61f, 85.66f, 84.17f)
                curveTo(85.43f, 84.73f, 85.09f, 85.24f, 84.66f, 85.67f)
                curveTo(84.24f, 86.09f, 83.73f, 86.43f, 83.17f, 86.66f)
                curveTo(82.6f, 86.89f, 82f, 87.01f, 81.4f, 87f)
                curveTo(80.79f, 86.99f, 80.19f, 86.87f, 79.64f, 86.63f)
                curveTo(79.08f, 86.39f, 78.58f, 86.04f, 78.16f, 85.61f)
                lineTo(49.44f, 56.94f)
                lineTo(20.73f, 85.61f)
                curveTo(19.87f, 86.44f, 18.72f, 86.9f, 17.52f, 86.89f)
                curveTo(16.33f, 86.88f, 15.18f, 86.4f, 14.34f, 85.55f)
                curveTo(13.49f, 84.71f, 13.01f, 83.57f, 13f, 82.37f)
                curveTo(12.99f, 81.18f, 13.45f, 80.03f, 14.28f, 79.17f)
                close()
            }
        }.build()

        return _Close!!
    }

@Suppress("ObjectPropertyName")
private var _Close: ImageVector? = null
