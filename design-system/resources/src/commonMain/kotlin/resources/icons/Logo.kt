package resources.icons

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
            defaultWidth = 118.dp,
            defaultHeight = 96.dp,
            viewportWidth = 118f,
            viewportHeight = 96f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF2A2A3F)),
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 3f
            ) {
                moveTo(104.21f, 53.56f)
                curveTo(101.18f, 78.75f, 78.31f, 96.71f, 53.12f, 93.68f)
                curveTo(27.94f, 90.65f, 9.97f, 67.78f, 13f, 42.59f)
                curveTo(16.03f, 17.4f, 38.91f, -0.56f, 64.09f, 2.47f)
                curveTo(89.28f, 5.5f, 107.24f, 28.37f, 104.21f, 53.56f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFC5E0F))) {
                moveTo(102.56f, 39.29f)
                curveTo(61.9f, 60.15f, 37.85f, 53.86f, 14.63f, 48.92f)
                curveTo(15.98f, 77.02f, 33.75f, 89.41f, 50.76f, 92.22f)
                curveTo(65.07f, 94.59f, 74.75f, 90.54f, 79.4f, 88.05f)
                curveTo(101.99f, 75.96f, 105.68f, 53.53f, 102.56f, 39.29f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 2f
            ) {
                moveTo(104.71f, 53.62f)
                curveTo(101.65f, 79.08f, 78.52f, 97.24f, 53.06f, 94.17f)
                curveTo(27.6f, 91.11f, 9.45f, 67.99f, 12.51f, 42.53f)
                curveTo(15.57f, 17.07f, 38.69f, -1.09f, 64.15f, 1.97f)
                curveTo(89.61f, 5.04f, 107.77f, 28.16f, 104.71f, 53.62f)
                close()
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(52.69f, 12.31f)
                arcToRelative(12.49f, 11.77f, 116.93f, true, false, 20.98f, 10.66f)
                arcToRelative(12.49f, 11.77f, 116.93f, true, false, -20.98f, -10.66f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFCFBFA)),
                fillAlpha = 0.3f
            ) {
                moveTo(47.83f, 86.35f)
                arcToRelative(12.01f, 8.76f, 60.7f, true, false, 15.29f, -8.58f)
                arcToRelative(12.01f, 8.76f, 60.7f, true, false, -15.29f, 8.58f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2AFA2D))) {
                moveTo(16.18f, 14.73f)
                moveToRelative(-1.97f, -0.34f)
                arcToRelative(2f, 2f, 52.53f, true, true, 3.94f, 0.68f)
                arcToRelative(2f, 2f, 52.53f, true, true, -3.94f, -0.68f)
            }
            path(fill = SolidColor(Color(0xFF2AFA2D))) {
                moveTo(6.58f, 24.85f)
                moveToRelative(-2.96f, -0.51f)
                arcToRelative(3f, 3f, 48.38f, true, true, 5.91f, 1.02f)
                arcToRelative(3f, 3f, 48.38f, true, true, -5.91f, -1.02f)
            }
            path(fill = SolidColor(Color(0xFF2AFA2D))) {
                moveTo(101.72f, 80.48f)
                moveToRelative(1.98f, -0.26f)
                arcToRelative(2f, 2f, 94.81f, true, true, -3.97f, 0.53f)
                arcToRelative(2f, 2f, 94.81f, true, true, 3.97f, -0.53f)
            }
            path(fill = SolidColor(Color(0xFF2AFA2D))) {
                moveTo(111.87f, 73.54f)
                moveToRelative(2.97f, -0.39f)
                arcToRelative(3f, 3f, 129.95f, true, true, -5.95f, 0.79f)
                arcToRelative(3f, 3f, 129.95f, true, true, 5.95f, -0.79f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 3f
            ) {
                moveTo(104.21f, 53.56f)
                curveTo(101.18f, 78.75f, 78.31f, 96.71f, 53.12f, 93.68f)
                curveTo(27.94f, 90.65f, 9.97f, 67.78f, 13f, 42.59f)
                curveTo(16.03f, 17.4f, 38.91f, -0.56f, 64.09f, 2.47f)
                curveTo(89.28f, 5.5f, 107.24f, 28.37f, 104.21f, 53.56f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 13f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(14f, 35f)
                lineTo(14f, 63f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 17f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(26.5f, 31f)
                lineTo(26.5f, 67.5f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 13f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(104.5f, 35f)
                verticalLineTo(63f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 17f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(91.5f, 31f)
                verticalLineTo(67.5f)
            }
            path(
                stroke = SolidColor(Color(0xFFFCFBFA)),
                strokeLineWidth = 12f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(7f, 50f)
                horizontalLineTo(110.5f)
            }
        }.build()

        return _Logo!!
    }

private var _Logo: ImageVector? = null
