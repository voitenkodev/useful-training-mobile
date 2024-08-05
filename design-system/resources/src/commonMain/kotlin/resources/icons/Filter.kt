package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Filter: ImageVector
    get() {
        if (_Filter != null) {
            return _Filter!!
        }
        _Filter = ImageVector.Builder(
            name = "Filter",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(12.52f, 23.05f)
                    curveTo(5.62f, 23.05f, 0.02f, 17.87f, 0.02f, 11.49f)
                    curveTo(0.02f, 5.11f, 5.62f, -0.06f, 12.52f, -0.06f)
                    horizontalLineTo(87.48f)
                    curveTo(94.39f, -0.06f, 99.98f, 5.11f, 99.98f, 11.49f)
                    curveTo(99.98f, 17.87f, 94.39f, 23.05f, 87.48f, 23.05f)
                    horizontalLineTo(12.52f)
                    close()
                    moveTo(29.18f, 61.55f)
                    curveTo(22.27f, 61.55f, 16.68f, 56.38f, 16.68f, 50f)
                    curveTo(16.68f, 43.62f, 22.27f, 38.45f, 29.18f, 38.45f)
                    horizontalLineTo(70.82f)
                    curveTo(77.73f, 38.45f, 83.32f, 43.62f, 83.32f, 50f)
                    curveTo(83.32f, 56.38f, 77.73f, 61.55f, 70.82f, 61.55f)
                    horizontalLineTo(29.18f)
                    close()
                    moveTo(45.84f, 100.06f)
                    curveTo(38.93f, 100.06f, 33.34f, 94.89f, 33.34f, 88.51f)
                    curveTo(33.34f, 82.13f, 38.93f, 76.95f, 45.84f, 76.95f)
                    horizontalLineTo(54.17f)
                    curveTo(61.07f, 76.95f, 66.66f, 82.13f, 66.66f, 88.51f)
                    curveTo(66.66f, 94.89f, 61.07f, 100.06f, 54.17f, 100.06f)
                    horizontalLineTo(45.84f)
                    close()
                }
            }
        }.build()

        return _Filter!!
    }

@Suppress("ObjectPropertyName")
private var _Filter: ImageVector? = null
