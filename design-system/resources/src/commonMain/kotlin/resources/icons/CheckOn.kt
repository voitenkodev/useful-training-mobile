package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val CheckOn: ImageVector
    get() {
        if (_Checkon != null) {
            return _Checkon!!
        }
        _Checkon = ImageVector.Builder(
            name = "Checkon",
            defaultWidth = 666.dp,
            defaultHeight = 666.dp,
            viewportWidth = 666f,
            viewportHeight = 666f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xff2afa2d))) {
                    moveTo(333f, 666.33f)
                    curveTo(148.9f, 666.33f, -0.33f, 517.1f, -0.33f, 333f)
                    curveTo(-0.33f, 148.9f, 148.9f, -0.33f, 333f, -0.33f)
                    curveTo(517.1f, -0.33f, 666.33f, 148.9f, 666.33f, 333f)
                    curveTo(666.33f, 517.1f, 517.1f, 666.33f, 333f, 666.33f)
                    close()
                    moveTo(299.77f, 466.33f)
                    lineTo(535.43f, 230.63f)
                    lineTo(488.3f, 183.5f)
                    lineTo(299.77f, 372.07f)
                    lineTo(205.47f, 277.77f)
                    lineTo(158.33f, 324.9f)
                    lineTo(299.77f, 466.33f)
                    close()
                }
            }
        }.build()

        return _Checkon!!
    }

@Suppress("ObjectPropertyName")
private var _Checkon: ImageVector? = null
