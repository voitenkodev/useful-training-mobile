package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val VBar: ImageVector
    get() {
        if (_Vbar != null) {
            return _Vbar!!
        }
        _Vbar = ImageVector.Builder(
            name = "Vbar",
            defaultWidth = 195.dp,
            defaultHeight = 124.dp,
            viewportWidth = 195f,
            viewportHeight = 124f
        ).apply {
            path(fill = SolidColor(Color(0xFFD9D9D9))) {
                moveTo(169.67f, 104.07f)
                lineTo(124.45f, 49.81f)
                lineTo(68.25f, 48.75f)
                lineTo(24.93f, 101.24f)
                curveTo(19.04f, 100.99f, 13.01f, 99.24f, 14.17f, 93.65f)
                lineTo(65.2f, 34.65f)
                lineTo(126.61f, 34.66f)
                lineTo(182.41f, 97.03f)
                lineTo(169.67f, 104.07f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(135.48f, 61.86f)
                curveTo(136.58f, 56.56f, 140.87f, 55.45f, 143.71f, 54.9f)
                lineTo(170.95f, 85.27f)
                curveTo(166.2f, 85.27f, 162.61f, 89.94f, 161.32f, 92.72f)
                lineTo(135.48f, 61.86f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(56.98f, 61.23f)
                curveTo(55.67f, 55.98f, 51.61f, 55.33f, 48.75f, 54.9f)
                lineTo(21.53f, 86.53f)
                curveTo(26.35f, 86.26f, 30.26f, 89.5f, 31.66f, 92.23f)
                lineTo(56.98f, 61.23f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0A0A0))) {
                moveTo(67.75f, 47.94f)
                curveTo(66.23f, 44.15f, 64.18f, 37.15f, 65.21f, 34.65f)
                curveTo(69.6f, 31.07f, 85.87f, 31.07f, 90.97f, 31.14f)
                curveTo(83.55f, 22.95f, 84.9f, 8.94f, 93.6f, 5.83f)
                curveTo(97.89f, 4.29f, 99.8f, 11.8f, 99.8f, 11.8f)
                curveTo(84.49f, 11.59f, 90.43f, 24.93f, 95.23f, 24.45f)
                lineTo(98.96f, 32.51f)
                curveTo(97.24f, 34.62f, 117.39f, 46.19f, 117.81f, 49.57f)
                curveTo(101.41f, 50.44f, 69.26f, 51.73f, 67.75f, 47.94f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0A0A0))) {
                moveTo(124.09f, 49.84f)
                curveTo(127.94f, 49.08f, 126.62f, 37.19f, 126.62f, 34.66f)
                curveTo(122.34f, 30.96f, 106.16f, 31.61f, 101.43f, 30.43f)
                curveTo(108.39f, 20.8f, 102.28f, 3.21f, 93.6f, 5.83f)
                curveTo(91.04f, 6.6f, 93.03f, 12.65f, 93.03f, 12.65f)
                curveTo(102.88f, 10.83f, 101.19f, 24.77f, 95.23f, 24.45f)
                curveTo(88.99f, 24.12f, 93.91f, 40.37f, 93.91f, 40.37f)
                lineTo(92.9f, 50.32f)
                curveTo(109.94f, 51.03f, 117.76f, 51.11f, 124.09f, 49.84f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeLineWidth = 0.2f
            ) {
                moveTo(12.35f, 96.02f)
                curveTo(10.6f, 101.19f, 13.77f, 106.9f, 19.07f, 108.17f)
                curveTo(23.97f, 109.35f, 28.8f, 106.68f, 30.41f, 101.91f)
                curveTo(32.15f, 96.75f, 28.98f, 91.03f, 23.68f, 89.76f)
                curveTo(18.78f, 88.58f, 13.95f, 91.25f, 12.35f, 96.02f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeLineWidth = 0.2f
            ) {
                moveTo(164.1f, 96.02f)
                curveTo(162.36f, 101.19f, 165.52f, 106.9f, 170.83f, 108.18f)
                curveTo(175.72f, 109.35f, 180.55f, 106.68f, 182.16f, 101.91f)
                curveTo(183.9f, 96.75f, 180.74f, 91.03f, 175.43f, 89.76f)
                curveTo(170.54f, 88.58f, 165.71f, 91.25f, 164.1f, 96.02f)
                close()
            }
        }.build()

        return _Vbar!!
    }

@Suppress("ObjectPropertyName")
private var _Vbar: ImageVector? = null