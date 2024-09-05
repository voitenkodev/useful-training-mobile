package equipments

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val StraightBar: ImageVector
    get() {
        if (_Straightbar != null) {
            return _Straightbar!!
        }
        _Straightbar = ImageVector.Builder(
            name = "Straightbar",
            defaultWidth = 183.dp,
            defaultHeight = 113.dp,
            viewportWidth = 183f,
            viewportHeight = 113f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF262C31)),
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeLineWidth = 0.2f
            ) {
                moveTo(3.39f, 3.01f)
                curveTo(0.2f, 5.92f, 0.2f, 11.08f, 3.39f, 13.99f)
                curveTo(6.32f, 16.67f, 10.68f, 16.67f, 13.61f, 13.99f)
                curveTo(16.8f, 11.08f, 16.8f, 5.92f, 13.61f, 3.01f)
                curveTo(10.68f, 0.33f, 6.32f, 0.33f, 3.39f, 3.01f)
                close()
            }
            path(fill = SolidColor(Color(0xFFD9D9D9))) {
                moveTo(177.39f, 100.9f)
                lineTo(14.17f, 5.87f)
                curveTo(7.5f, 7f, 8f, 11f, 8.49f, 14.69f)
                lineTo(172.3f, 109.33f)
                lineTo(177.39f, 100.9f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(22.5f, 22f)
                curveTo(21.87f, 17.77f, 25.65f, 15.24f, 27.61f, 14.06f)
                lineTo(54.85f, 29.93f)
                curveTo(51.24f, 31.18f, 49.7f, 35.58f, 49.5f, 38f)
                lineTo(22.5f, 22f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF424346)),
                stroke = SolidColor(Color(0xFFAAAAAA)),
                strokeLineWidth = 1f
            ) {
                moveTo(122.5f, 80.5f)
                curveTo(121.87f, 76.27f, 125.36f, 73.29f, 127.32f, 72.12f)
                lineTo(154.56f, 87.99f)
                curveTo(150.95f, 89.24f, 150.2f, 93.58f, 150f, 96f)
                lineTo(122.5f, 80.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0A0A0))) {
                moveTo(66f, 47f)
                curveTo(66.4f, 43.8f, 69.83f, 40.33f, 71.5f, 39f)
                curveTo(75.9f, 38.2f, 85.5f, 43f, 89f, 45f)
                curveTo(87f, 36.5f, 93.3f, 27.33f, 100.5f, 28.5f)
                curveTo(104.05f, 29.08f, 102.5f, 35f, 102.5f, 35f)
                curveTo(92f, 29f, 91f, 40.5f, 94.5f, 42f)
                lineTo(94f, 49f)
                curveTo(92f, 49.8f, 101.5f, 65.5f, 100.5f, 68f)
                curveTo(88.83f, 62.33f, 65.6f, 50.2f, 66f, 47f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA0A0A0))) {
                moveTo(106.5f, 69.93f)
                curveTo(107.5f, 67f, 108f, 63.5f, 110.5f, 62f)
                curveTo(108.95f, 57.8f, 99.32f, 51.12f, 96.5f, 48.5f)
                curveTo(105f, 44.5f, 107.5f, 30f, 100.5f, 28.5f)
                curveTo(98.43f, 28.06f, 97.5f, 33f, 97.5f, 33f)
                curveTo(105f, 35.5f, 98.5f, 44.5f, 94.5f, 42f)
                curveTo(90.32f, 39.39f, 87.5f, 52.5f, 87.5f, 52.5f)
                lineTo(83f, 59f)
                curveTo(94.5f, 66f, 105.46f, 72.98f, 106.5f, 69.93f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF262C31)),
                stroke = SolidColor(Color(0xFF1B1E20)),
                strokeLineWidth = 0.2f
            ) {
                moveTo(169.38f, 99.01f)
                curveTo(166.21f, 101.92f, 166.21f, 107.08f, 169.38f, 109.99f)
                curveTo(172.32f, 112.67f, 176.68f, 112.67f, 179.62f, 109.99f)
                curveTo(182.79f, 107.08f, 182.79f, 101.92f, 179.62f, 99.01f)
                curveTo(176.68f, 96.33f, 172.32f, 96.33f, 169.38f, 99.01f)
                close()
            }
        }.build()

        return _Straightbar!!
    }

@Suppress("ObjectPropertyName")
private var _Straightbar: ImageVector? = null