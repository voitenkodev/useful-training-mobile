package resources.icon.product

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Logo: ImageVector
    get() {
        if (_Logo != null) {
            return _Logo!!
        }
        _Logo = ImageVector.Builder(
            name = "Logo",
            defaultWidth = 111.dp,
            defaultHeight = 96.dp,
            viewportWidth = 111f,
            viewportHeight = 96f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF2A2A3F)),
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 3f
            ) {
                moveTo(101.21f, 53.56f)
                curveTo(98.18f, 78.75f, 75.31f, 96.71f, 50.12f, 93.68f)
                curveTo(24.94f, 90.65f, 6.97f, 67.78f, 10f, 42.59f)
                curveTo(13.03f, 17.4f, 35.91f, -0.56f, 61.09f, 2.47f)
                curveTo(86.28f, 5.5f, 104.24f, 28.37f, 101.21f, 53.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFC5E0F))) {
                moveTo(99.56f, 39.29f)
                curveTo(58.9f, 60.15f, 34.85f, 53.86f, 11.63f, 48.92f)
                curveTo(12.98f, 77.02f, 30.75f, 89.41f, 47.76f, 92.22f)
                curveTo(62.07f, 94.59f, 71.75f, 90.54f, 76.4f, 88.05f)
                curveTo(98.99f, 75.96f, 102.68f, 53.53f, 99.56f, 39.29f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 2f
            ) {
                moveTo(101.71f, 53.62f)
                curveTo(98.65f, 79.08f, 75.52f, 97.24f, 50.06f, 94.17f)
                curveTo(24.6f, 91.11f, 6.45f, 67.99f, 9.51f, 42.53f)
                curveTo(12.57f, 17.07f, 35.69f, -1.09f, 61.15f, 1.97f)
                curveTo(86.61f, 5.04f, 104.77f, 28.16f, 101.71f, 53.62f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 3f
            ) {
                moveTo(101.21f, 53.56f)
                curveTo(98.18f, 78.75f, 75.31f, 96.71f, 50.12f, 93.68f)
                curveTo(24.94f, 90.65f, 6.97f, 67.78f, 10f, 42.59f)
                curveTo(13.03f, 17.4f, 35.91f, -0.56f, 61.09f, 2.47f)
                curveTo(86.28f, 5.5f, 104.24f, 28.37f, 101.21f, 53.56f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 12f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(17.5f, 34f)
                verticalLineTo(62f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 14f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(29.5f, 31f)
                lineTo(29.5f, 67.5f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 12f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(94f, 34f)
                verticalLineTo(62f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 14f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(82f, 31f)
                verticalLineTo(67.5f)
            }
            path(
                stroke = SolidColor(Color(0xFFFAFCFA)),
                strokeLineWidth = 10f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(7.5f, 46f)
                curveTo(7.5f, 46f, 37f, 52.5f, 56.5f, 52.5f)
                curveTo(76f, 52.5f, 103.5f, 46f, 103.5f, 46f)
            }
        }.build()

        return _Logo!!
    }

@Suppress("ObjectPropertyName")
private var _Logo: ImageVector? = null
