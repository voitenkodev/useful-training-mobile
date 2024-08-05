package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Dumbbell: ImageVector
    get() {
        if (_Dumbbell != null) {
            return _Dumbbell!!
        }
        _Dumbbell = ImageVector.Builder(
            name = "Dumbbell",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(25f, 39.58f)
                verticalLineTo(35.42f)
                horizontalLineTo(66.67f)
                verticalLineTo(39.58f)
                curveTo(66.67f, 41.88f, 68.53f, 43.75f, 70.83f, 43.75f)
                horizontalLineTo(87.5f)
                curveTo(89.8f, 43.75f, 91.67f, 41.88f, 91.67f, 39.58f)
                verticalLineTo(6.25f)
                curveTo(91.67f, 3.95f, 89.8f, 2.08f, 87.5f, 2.08f)
                horizontalLineTo(70.83f)
                curveTo(68.53f, 2.08f, 66.67f, 3.95f, 66.67f, 6.25f)
                verticalLineTo(10.42f)
                horizontalLineTo(25f)
                verticalLineTo(6.25f)
                curveTo(25f, 3.95f, 23.14f, 2.08f, 20.83f, 2.08f)
                horizontalLineTo(4.17f)
                curveTo(1.86f, 2.08f, 0f, 3.95f, 0f, 6.25f)
                verticalLineTo(39.58f)
                curveTo(0f, 41.88f, 1.86f, 43.75f, 4.17f, 43.75f)
                horizontalLineTo(20.83f)
                curveTo(23.14f, 43.75f, 25f, 41.88f, 25f, 39.58f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(95.83f, 56.25f)
                horizontalLineTo(79.17f)
                curveTo(76.86f, 56.25f, 75f, 58.12f, 75f, 60.42f)
                verticalLineTo(64.58f)
                horizontalLineTo(33.33f)
                verticalLineTo(60.42f)
                curveTo(33.33f, 58.12f, 31.47f, 56.25f, 29.17f, 56.25f)
                horizontalLineTo(12.5f)
                curveTo(10.2f, 56.25f, 8.33f, 58.12f, 8.33f, 60.42f)
                verticalLineTo(93.75f)
                curveTo(8.33f, 96.05f, 10.2f, 97.92f, 12.5f, 97.92f)
                horizontalLineTo(29.17f)
                curveTo(31.47f, 97.92f, 33.33f, 96.05f, 33.33f, 93.75f)
                verticalLineTo(89.58f)
                horizontalLineTo(75f)
                verticalLineTo(93.75f)
                curveTo(75f, 96.05f, 76.86f, 97.92f, 79.17f, 97.92f)
                horizontalLineTo(95.83f)
                curveTo(98.14f, 97.92f, 100f, 96.05f, 100f, 93.75f)
                verticalLineTo(60.42f)
                curveTo(100f, 58.12f, 98.14f, 56.25f, 95.83f, 56.25f)
                close()
            }
        }.build()

        return _Dumbbell!!
    }

@Suppress("ObjectPropertyName")
private var _Dumbbell: ImageVector? = null
