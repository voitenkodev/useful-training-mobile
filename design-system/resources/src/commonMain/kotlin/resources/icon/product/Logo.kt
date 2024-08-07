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
            defaultWidth = 160.dp,
            defaultHeight = 133.dp,
            viewportWidth = 160f,
            viewportHeight = 133f
        ).apply {
            path(fill = SolidColor(Color(0xFF2A2A3F))) {
                moveTo(143.84f, 74.06f)
                curveTo(139.57f, 109.47f, 107.41f, 134.73f, 72f, 130.47f)
                curveTo(36.59f, 126.21f, 11.33f, 94.05f, 15.59f, 58.63f)
                curveTo(19.85f, 23.22f, 52.01f, -2.03f, 87.43f, 2.23f)
                curveTo(122.84f, 6.49f, 148.1f, 38.65f, 143.84f, 74.06f)
                close()
            }
            path(fill = SolidColor(Color(0xFF151522))) {
                moveTo(139.56f, 54.39f)
                curveTo(84.2f, 82.79f, 51.45f, 74.23f, 19.83f, 67.49f)
                curveTo(21.68f, 105.76f, 45.86f, 122.62f, 69.03f, 126.46f)
                curveTo(88.51f, 129.68f, 101.69f, 124.16f, 108.02f, 120.78f)
                curveTo(138.79f, 104.32f, 143.8f, 73.78f, 139.56f, 54.39f)
                close()
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(91.71f, 22.75f)
                arcToRelative(
                    11.94f,
                    11.25f,
                    116.93f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    20.06f,
                    10.19f
                )
                arcToRelative(
                    11.94f,
                    11.25f,
                    116.93f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -20.06f,
                    -10.19f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(75.54f, 21.13f)
                arcToRelative(
                    4.93f,
                    4.65f,
                    72.51f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    8.86f,
                    -2.79f
                )
                arcToRelative(
                    4.93f,
                    4.65f,
                    72.51f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -8.86f,
                    2.79f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(80.31f, 33.85f)
                arcToRelative(
                    3.19f,
                    3.01f,
                    116.08f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    5.4f,
                    2.64f
                )
                arcToRelative(
                    3.19f,
                    3.01f,
                    116.08f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -5.4f,
                    -2.64f
                )
                close()
            }
            path(
                fillAlpha = 0.4f,
                stroke = SolidColor(Color(0xFF373751)),
                strokeAlpha = 0.4f,
                strokeLineWidth = 4f
            ) {
                moveTo(141.85f, 73.82f)
                curveTo(137.72f, 108.14f, 106.56f, 132.61f, 72.24f, 128.48f)
                curveTo(37.92f, 124.35f, 13.45f, 93.19f, 17.58f, 58.87f)
                curveTo(21.71f, 24.56f, 52.87f, 0.08f, 87.19f, 4.21f)
                curveTo(121.5f, 8.34f, 145.98f, 39.5f, 141.85f, 73.82f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 22f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(18.98f, 48.54f)
                lineTo(18.98f, 86.67f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 22f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(36f, 43.1f)
                verticalLineTo(92.8f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 22f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(142.2f, 48.54f)
                verticalLineTo(86.67f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 22f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(124.5f, 43.1f)
                verticalLineTo(92.8f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 16f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(9.45f, 68.97f)
                horizontalLineTo(150.37f)
            }
        }.build()

        return _Logo!!
    }

@Suppress("ObjectPropertyName")
private var _Logo: ImageVector? = null
