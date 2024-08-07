package resources.icon.experience

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val FitnessCircle: ImageVector
    get() {
        if (_Fitnescircle != null) {
            return _Fitnescircle!!
        }
        _Fitnescircle = ImageVector.Builder(
            name = "Fitnescircle",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f
            ) {
                moveTo(50f, 2f)
                curveTo(23.53f, 2f, 2f, 23.53f, 2f, 50f)
                curveTo(2f, 76.47f, 23.53f, 98f, 50f, 98f)
                curveTo(76.47f, 98f, 98f, 76.47f, 98f, 50f)
                curveTo(98f, 23.53f, 76.47f, 2f, 50f, 2f)
                close()
                moveTo(50f, 91.52f)
                curveTo(27.1f, 91.52f, 8.48f, 72.89f, 8.48f, 50f)
                curveTo(8.48f, 27.11f, 27.1f, 8.48f, 50f, 8.48f)
                curveTo(72.9f, 8.48f, 91.52f, 27.11f, 91.52f, 50f)
                curveTo(91.52f, 72.89f, 72.9f, 91.52f, 50f, 91.52f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(64.3f, 45.35f)
                horizontalLineTo(35.7f)
                verticalLineTo(55.3f)
                horizontalLineTo(64.3f)
                verticalLineTo(45.35f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(16.43f, 42.55f)
                verticalLineTo(43.56f)
                curveTo(16.06f, 43.33f, 15.65f, 43.18f, 15.18f, 43.18f)
                curveTo(13.81f, 43.18f, 12.7f, 44.29f, 12.7f, 45.66f)
                verticalLineTo(54.99f)
                curveTo(12.7f, 56.36f, 13.81f, 57.47f, 15.18f, 57.47f)
                curveTo(15.65f, 57.47f, 16.06f, 57.32f, 16.43f, 57.09f)
                verticalLineTo(58.1f)
                curveTo(16.43f, 60.63f, 18.33f, 62.7f, 20.78f, 63.01f)
                verticalLineTo(37.64f)
                curveTo(18.33f, 37.95f, 16.43f, 40.02f, 16.43f, 42.55f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(84.82f, 43.18f)
                curveTo(84.35f, 43.18f, 83.94f, 43.33f, 83.57f, 43.56f)
                verticalLineTo(42.55f)
                curveTo(83.57f, 40.02f, 81.67f, 37.95f, 79.22f, 37.64f)
                verticalLineTo(63.01f)
                curveTo(81.67f, 62.7f, 83.57f, 60.64f, 83.57f, 58.1f)
                verticalLineTo(57.09f)
                curveTo(83.94f, 57.32f, 84.35f, 57.48f, 84.82f, 57.48f)
                curveTo(86.19f, 57.48f, 87.3f, 56.36f, 87.3f, 54.99f)
                verticalLineTo(45.66f)
                curveTo(87.3f, 44.29f, 86.19f, 43.18f, 84.82f, 43.18f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(28.24f, 29.82f)
                curveTo(25.5f, 29.82f, 23.27f, 32.04f, 23.27f, 34.79f)
                verticalLineTo(65.86f)
                curveTo(23.27f, 68.61f, 25.5f, 70.84f, 28.24f, 70.84f)
                curveTo(30.99f, 70.84f, 33.22f, 68.61f, 33.22f, 65.86f)
                verticalLineTo(34.79f)
                curveTo(33.22f, 32.04f, 30.99f, 29.82f, 28.24f, 29.82f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(71.76f, 29.82f)
                curveTo(69.01f, 29.82f, 66.78f, 32.04f, 66.78f, 34.79f)
                verticalLineTo(65.86f)
                curveTo(66.78f, 68.61f, 69.01f, 70.84f, 71.76f, 70.84f)
                curveTo(74.5f, 70.84f, 76.73f, 68.61f, 76.73f, 65.86f)
                verticalLineTo(34.79f)
                curveTo(76.73f, 32.04f, 74.5f, 29.82f, 71.76f, 29.82f)
                close()
            }
        }.build()

        return _Fitnescircle!!
    }

@Suppress("ObjectPropertyName")
private var _Fitnescircle: ImageVector? = null
