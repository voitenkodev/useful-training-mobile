package resources.icon.outline

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val EmptyTraining: ImageVector
    get() {
        if (_Emptytraining != null) {
            return _Emptytraining!!
        }
        _Emptytraining = ImageVector.Builder(
            name = "Emptytraining",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(96.96f, 42.74f)
                    lineTo(57.26f, 3.03f)
                    curveTo(53.21f, -1.01f, 46.64f, -1.01f, 42.6f, 3.03f)
                    lineTo(3.13f, 42.49f)
                    curveTo(-0.99f, 46.62f, -0.99f, 53.32f, 3.13f, 57.44f)
                    lineTo(42.7f, 97.01f)
                    curveTo(44.63f, 98.94f, 47.2f, 100f, 49.93f, 100f)
                    curveTo(52.66f, 100f, 55.22f, 98.94f, 57.15f, 97.01f)
                    lineTo(96.96f, 57.2f)
                    curveTo(98.89f, 55.27f, 99.96f, 52.7f, 99.96f, 49.97f)
                    curveTo(99.96f, 47.24f, 98.89f, 44.67f, 96.96f, 42.74f)
                    close()
                    moveTo(82.04f, 54.43f)
                    curveTo(82.04f, 57.87f, 79.24f, 60.67f, 75.8f, 60.67f)
                    curveTo(74.71f, 60.67f, 73.7f, 60.37f, 72.8f, 59.87f)
                    curveTo(72f, 62.4f, 69.66f, 64.24f, 66.88f, 64.24f)
                    curveTo(63.43f, 64.24f, 60.63f, 61.44f, 60.63f, 58f)
                    verticalLineTo(55.32f)
                    horizontalLineTo(39.22f)
                    verticalLineTo(58f)
                    curveTo(39.22f, 61.44f, 36.42f, 64.24f, 32.97f, 64.24f)
                    curveTo(30.19f, 64.24f, 27.85f, 62.4f, 27.05f, 59.87f)
                    curveTo(26.16f, 60.37f, 25.15f, 60.67f, 24.05f, 60.67f)
                    curveTo(20.61f, 60.67f, 17.81f, 57.87f, 17.81f, 54.43f)
                    verticalLineTo(45.51f)
                    curveTo(17.81f, 42.06f, 20.61f, 39.26f, 24.05f, 39.26f)
                    curveTo(25.15f, 39.26f, 26.16f, 39.57f, 27.05f, 40.06f)
                    curveTo(27.85f, 37.54f, 30.19f, 35.69f, 32.97f, 35.69f)
                    curveTo(36.42f, 35.69f, 39.22f, 38.49f, 39.22f, 41.94f)
                    verticalLineTo(44.62f)
                    horizontalLineTo(60.63f)
                    verticalLineTo(41.94f)
                    curveTo(60.63f, 38.49f, 63.43f, 35.69f, 66.88f, 35.69f)
                    curveTo(69.66f, 35.69f, 72f, 37.54f, 72.8f, 40.06f)
                    curveTo(73.7f, 39.57f, 74.71f, 39.26f, 75.8f, 39.26f)
                    curveTo(79.24f, 39.26f, 82.04f, 42.06f, 82.04f, 45.51f)
                    verticalLineTo(54.43f)
                    horizontalLineTo(82.04f)
                    close()
                }
            }
        }.build()

        return _Emptytraining!!
    }

@Suppress("ObjectPropertyName")
private var _Emptytraining: ImageVector? = null
