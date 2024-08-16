package resources.icon.product

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Logo: ImageVector
    get() {
        if (_Logo != null) {
            return _Logo!!
        }
        _Logo = ImageVector.Builder(
            name = "Logo",
            defaultWidth = 616.dp,
            defaultHeight = 616.dp,
            viewportWidth = 616f,
            viewportHeight = 616f
        ).apply {
            group {
                path(fill = SolidColor(Color(0xFF2A2A3F))) {
                    moveTo(559.56f, 338.49f)
                    curveTo(542.86f, 477.28f, 416.82f, 576.25f, 278.03f, 559.56f)
                    curveTo(139.24f, 542.86f, 40.26f, 416.82f, 56.95f, 278.03f)
                    curveTo(73.65f, 139.24f, 199.7f, 40.26f, 338.49f, 56.95f)
                    curveTo(477.28f, 73.65f, 576.25f, 199.7f, 559.56f, 338.49f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF151522))) {
                    moveTo(542.8f, 261.38f)
                    curveTo(325.83f, 372.71f, 197.47f, 339.14f, 73.55f, 312.75f)
                    curveTo(80.79f, 462.72f, 175.59f, 528.81f, 266.39f, 543.84f)
                    curveTo(342.73f, 556.48f, 394.38f, 534.84f, 419.18f, 521.58f)
                    curveTo(539.77f, 457.08f, 559.42f, 337.37f, 542.8f, 261.38f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF373751))) {
                    moveTo(359.2f, 121.72f)
                    arcToRelative(
                        46.8f,
                        44.09f,
                        116.93f,
                        isMoreThanHalf = true,
                        isPositiveArc = false,
                        78.62f,
                        39.94f
                    )
                    arcToRelative(
                        46.8f,
                        44.09f,
                        116.93f,
                        isMoreThanHalf = true,
                        isPositiveArc = false,
                        -78.62f,
                        -39.94f
                    )
                    close()
                }
                path(fill = SolidColor(Color(0xFF373751))) {
                    moveTo(295.81f, 115.37f)
                    arcToRelative(
                        19.32f,
                        18.21f,
                        72.51f,
                        isMoreThanHalf = true,
                        isPositiveArc = false,
                        34.73f,
                        -10.94f
                    )
                    arcToRelative(
                        19.32f,
                        18.21f,
                        72.51f,
                        isMoreThanHalf = true,
                        isPositiveArc = false,
                        -34.73f,
                        10.94f
                    )
                    close()
                }
                path(fill = SolidColor(Color(0xFF373751))) {
                    moveTo(314.5f, 165.23f)
                    arcToRelative(
                        12.5f,
                        11.78f,
                        116.08f,
                        isMoreThanHalf = true,
                        isPositiveArc = false,
                        21.16f,
                        10.35f
                    )
                    arcToRelative(
                        12.5f,
                        11.78f,
                        116.08f,
                        isMoreThanHalf = true,
                        isPositiveArc = false,
                        -21.16f,
                        -10.35f
                    )
                    close()
                }
                path(
                    stroke = SolidColor(Color(0xFF373751)),
                    strokeLineWidth = 16f
                ) {
                    moveTo(551.61f, 337.53f)
                    curveTo(535.45f, 471.93f, 413.38f, 567.78f, 278.98f, 551.61f)
                    curveTo(144.58f, 535.45f, 48.73f, 413.39f, 64.9f, 278.98f)
                    curveTo(81.06f, 144.58f, 203.13f, 48.73f, 337.53f, 64.9f)
                    curveTo(471.93f, 81.06f, 567.78f, 203.13f, 551.61f, 337.53f)
                    close()
                }
                path(
                    stroke = SolidColor(Color(0xFFFCFBFA)),
                    strokeLineWidth = 69.3715f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(90.21f, 238.49f)
                    lineTo(90.21f, 387.9f)
                }
                path(
                    stroke = SolidColor(Color(0xFFFCFBFA)),
                    strokeLineWidth = 90.7166f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(156.92f, 217.14f)
                    verticalLineTo(411.92f)
                }
                path(
                    stroke = SolidColor(Color(0xFFFCFBFA)),
                    strokeLineWidth = 69.3715f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(533.15f, 238.49f)
                    verticalLineTo(387.9f)
                }
                path(
                    stroke = SolidColor(Color(0xFFFCFBFA)),
                    strokeLineWidth = 90.7166f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(463.77f, 217.14f)
                    verticalLineTo(411.92f)
                }
                path(
                    stroke = SolidColor(Color(0xFFFCFBFA)),
                    strokeLineWidth = 64.0353f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(32.86f, 318.53f)
                    horizontalLineTo(585.16f)
                }
            }
        }.build()

        return _Logo!!
    }

@Suppress("ObjectPropertyName")
private var _Logo: ImageVector? = null
