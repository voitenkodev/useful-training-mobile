package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val WideGripHandle: ImageVector
    get() {
        if (_WideGripHandle != null) {
            return _WideGripHandle!!
        }
        _WideGripHandle = ImageVector.Builder(
            name = "WideGripHandle",
            defaultWidth = 279.dp,
            defaultHeight = 181.dp,
            viewportWidth = 279f,
            viewportHeight = 181f
        ).apply {
            path(fill = SolidColor(Color(0xFFD9D9D9))) {
                moveTo(46.63f, 13f)
                lineTo(245.63f, 129.5f)
                lineTo(268.5f, 172f)
                curveTo(268.33f, 175.33f, 261.98f, 179.6f, 256.38f, 176f)
                lineTo(238f, 140.45f)
                lineTo(41.5f, 25.5f)
                lineTo(5.5f, 30f)
                curveTo(3f, 26f, 2.87f, 20.5f, 5.5f, 18f)
                lineTo(46.63f, 13f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(53.5f, 32f)
                curveTo(52.87f, 27.77f, 58.54f, 22.67f, 60.5f, 21.5f)
                lineTo(107.5f, 49.5f)
                curveTo(103.89f, 50.75f, 101.2f, 57.58f, 101f, 60f)
                lineTo(53.5f, 32f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(5.91f, 29.5f)
                curveTo(2.43f, 27.02f, 4.04f, 19.83f, 5.91f, 18.6f)
                lineTo(38.5f, 14.5f)
                curveTo(36.91f, 17.97f, 37.89f, 23.18f, 39.5f, 25f)
                lineTo(5.91f, 29.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(174f, 102.5f)
                curveTo(173.37f, 98.27f, 178.04f, 93.17f, 180f, 92f)
                lineTo(231.5f, 122f)
                curveTo(227.9f, 123.25f, 225.2f, 129.58f, 225f, 132f)
                lineTo(174f, 102.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(268.5f, 172.5f)
                curveTo(266.84f, 176.45f, 261f, 177.5f, 257.5f, 176.5f)
                lineTo(241f, 145f)
                curveTo(244.73f, 145.79f, 249.08f, 141.96f, 250.5f, 140f)
                lineTo(268.5f, 172.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0A0A0))) {
                moveTo(117.5f, 69.39f)
                curveTo(117.9f, 66.19f, 122.46f, 60.72f, 124.13f, 59.39f)
                curveTo(128.52f, 58.59f, 138.13f, 63.39f, 141.63f, 65.39f)
                curveTo(139.63f, 56.89f, 145.92f, 47.72f, 153.13f, 48.89f)
                curveTo(156.68f, 49.47f, 155.13f, 55.39f, 155.13f, 55.39f)
                curveTo(144.63f, 49.39f, 143.63f, 60.89f, 147.13f, 62.39f)
                lineTo(146.63f, 69.39f)
                curveTo(144.63f, 70.19f, 153f, 87.5f, 152f, 90f)
                curveTo(140.33f, 84.33f, 117.1f, 72.59f, 117.5f, 69.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0A0A0))) {
                moveTo(158f, 92.5f)
                curveTo(159f, 89.57f, 160.63f, 83.89f, 163.12f, 82.39f)
                curveTo(161.58f, 78.19f, 151.94f, 71.51f, 149.12f, 68.89f)
                curveTo(157.62f, 64.89f, 160.13f, 50.39f, 153.13f, 48.89f)
                curveTo(151.06f, 48.45f, 150.12f, 53.39f, 150.12f, 53.39f)
                curveTo(157.63f, 55.89f, 151.12f, 64.89f, 147.12f, 62.39f)
                curveTo(142.94f, 59.78f, 140.12f, 72.89f, 140.12f, 72.89f)
                lineTo(135.62f, 79.39f)
                curveTo(134.5f, 81f, 156.96f, 95.55f, 158f, 92.5f)
                close()
            }
        }.build()

        return _WideGripHandle!!
    }

@Suppress("ObjectPropertyName")
private var _WideGripHandle: ImageVector? = null
