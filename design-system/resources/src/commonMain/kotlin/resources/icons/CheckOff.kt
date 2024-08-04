package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val CheckOff: ImageVector
    get() {
        if (_CircleThinSvgrepoCom != null) {
            return _CircleThinSvgrepoCom!!
        }
        _CircleThinSvgrepoCom = ImageVector.Builder(
            name = "CircleThinSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color(0x4Dffffff))) {
                moveTo(16f, 32f)
                arcTo(16f, 16f, 0f, isMoreThanHalf = true, isPositiveArc = false, 0f, 16f)
                arcTo(16f, 16f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 32f)
                close()
                moveTo(16f, 2f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = true, isPositiveArc = true, 2f, 16f)
                arcTo(14f, 14f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16f, 2f)
                close()
            }
        }.build()

        return _CircleThinSvgrepoCom!!
    }

@Suppress("ObjectPropertyName")
private var _CircleThinSvgrepoCom: ImageVector? = null
