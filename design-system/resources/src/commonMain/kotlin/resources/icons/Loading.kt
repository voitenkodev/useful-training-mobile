package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val Loading: ImageVector
    get() {
        if (_Loading != null) {
            return _Loading!!
        }
        _Loading = ImageVector.Builder(
            name = "Loading",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(50f, 0f)
                    curveTo(45.44f, 0f, 41.74f, 3.7f, 41.74f, 8.26f)
                    curveTo(41.74f, 12.82f, 45.44f, 16.52f, 50f, 16.52f)
                    curveTo(54.56f, 16.52f, 58.26f, 12.82f, 58.26f, 8.26f)
                    curveTo(58.26f, 3.7f, 54.56f, 0f, 50f, 0f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(50f, 83.48f)
                    curveTo(45.44f, 83.48f, 41.74f, 87.18f, 41.74f, 91.74f)
                    curveTo(41.74f, 96.3f, 45.44f, 100f, 50f, 100f)
                    curveTo(54.56f, 100f, 58.26f, 96.3f, 58.26f, 91.74f)
                    curveTo(58.26f, 87.18f, 54.56f, 83.48f, 50f, 83.48f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(14.64f, 14.65f)
                    curveTo(11.42f, 17.87f, 11.42f, 23.1f, 14.64f, 26.33f)
                    curveTo(17.87f, 29.55f, 23.1f, 29.55f, 26.32f, 26.33f)
                    curveTo(29.55f, 23.1f, 29.55f, 17.87f, 26.32f, 14.65f)
                    curveTo(23.1f, 11.42f, 17.87f, 11.42f, 14.64f, 14.65f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(73.67f, 73.67f)
                    curveTo(70.45f, 76.9f, 70.45f, 82.13f, 73.67f, 85.36f)
                    curveTo(76.9f, 88.58f, 82.13f, 88.58f, 85.35f, 85.36f)
                    curveTo(88.58f, 82.13f, 88.58f, 76.9f, 85.35f, 73.67f)
                    curveTo(82.13f, 70.45f, 76.9f, 70.45f, 73.67f, 73.67f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(16.52f, 50f)
                    curveTo(16.52f, 45.44f, 12.82f, 41.74f, 8.26f, 41.74f)
                    curveTo(3.7f, 41.74f, -0f, 45.44f, 0f, 50f)
                    curveTo(-0f, 54.56f, 3.69f, 58.26f, 8.26f, 58.26f)
                    curveTo(12.82f, 58.26f, 16.52f, 54.56f, 16.52f, 50f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(91.74f, 41.74f)
                    curveTo(87.18f, 41.74f, 83.48f, 45.44f, 83.48f, 50f)
                    curveTo(83.48f, 54.56f, 87.18f, 58.26f, 91.74f, 58.26f)
                    curveTo(96.3f, 58.26f, 100f, 54.56f, 100f, 50f)
                    curveTo(100f, 45.44f, 96.3f, 41.74f, 91.74f, 41.74f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(14.65f, 73.68f)
                    curveTo(11.42f, 76.9f, 11.42f, 82.13f, 14.65f, 85.36f)
                    curveTo(17.87f, 88.58f, 23.1f, 88.58f, 26.32f, 85.36f)
                    curveTo(29.55f, 82.13f, 29.55f, 76.9f, 26.32f, 73.67f)
                    curveTo(23.1f, 70.45f, 17.87f, 70.45f, 14.65f, 73.68f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF000000))) {
                    moveTo(85.36f, 26.33f)
                    curveTo(88.58f, 23.1f, 88.58f, 17.87f, 85.36f, 14.64f)
                    curveTo(82.13f, 11.42f, 76.9f, 11.42f, 73.67f, 14.64f)
                    curveTo(70.45f, 17.87f, 70.45f, 23.1f, 73.67f, 26.33f)
                    curveTo(76.9f, 29.55f, 82.13f, 29.55f, 85.36f, 26.33f)
                    close()
                }
            }
        }.build()

        return _Loading!!
    }

@Suppress("ObjectPropertyName")
private var _Loading: ImageVector? = null
