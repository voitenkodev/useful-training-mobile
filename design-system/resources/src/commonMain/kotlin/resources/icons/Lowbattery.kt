package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Suppress

internal val LowBattery: ImageVector
    get() {
        if (_Lowbattery != null) {
            return _Lowbattery!!
        }
        _Lowbattery = ImageVector.Builder(
            name = "Lowbattery",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 100f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFFF54949))) {
                    moveTo(9.09f, 54.55f)
                    curveTo(4.05f, 54.55f, 0f, 58.59f, 0f, 63.64f)
                    verticalLineTo(90.91f)
                    curveTo(0f, 95.95f, 4.05f, 100f, 9.09f, 100f)
                    horizontalLineTo(18.18f)
                    curveTo(23.22f, 100f, 27.27f, 95.95f, 27.27f, 90.91f)
                    verticalLineTo(63.64f)
                    curveTo(27.27f, 58.59f, 23.22f, 54.55f, 18.18f, 54.55f)
                    horizontalLineTo(9.09f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFFFFFF)),
                    fillAlpha = 0.1f
                ) {
                    moveTo(81.82f, 0f)
                    curveTo(76.78f, 0f, 72.73f, 4.05f, 72.73f, 9.09f)
                    verticalLineTo(90.91f)
                    curveTo(72.73f, 95.95f, 76.78f, 100f, 81.82f, 100f)
                    horizontalLineTo(90.91f)
                    curveTo(95.95f, 100f, 100f, 95.95f, 100f, 90.91f)
                    verticalLineTo(9.09f)
                    curveTo(100f, 4.05f, 95.95f, 0f, 90.91f, 0f)
                    horizontalLineTo(81.82f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFFFFFF)),
                    fillAlpha = 0.1f
                ) {
                    moveTo(36.36f, 36.36f)
                    curveTo(36.36f, 31.32f, 40.41f, 27.27f, 45.45f, 27.27f)
                    horizontalLineTo(54.55f)
                    curveTo(59.59f, 27.27f, 63.64f, 31.32f, 63.64f, 36.36f)
                    verticalLineTo(90.91f)
                    curveTo(63.64f, 95.95f, 59.59f, 100f, 54.55f, 100f)
                    horizontalLineTo(45.45f)
                    curveTo(40.41f, 100f, 36.36f, 95.95f, 36.36f, 90.91f)
                    verticalLineTo(36.36f)
                    close()
                }
            }
        }.build()

        return _Lowbattery!!
    }

@Suppress("ObjectPropertyName")
private var _Lowbattery: ImageVector? = null
