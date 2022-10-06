package designsystem.atomic

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _eye: ImageVector? = null
val Eye: ImageVector
    get() {
        if (_eye != null) {
            return _eye!!
        }
        _eye = ImageVector.Builder(
            name = "Eye", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp, viewportWidth
            = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(1.0f, 12.0f)
                reflectiveCurveToRelative(4.0f, -8.0f, 11.0f, -8.0f)
                reflectiveCurveToRelative(11.0f, 8.0f, 11.0f, 8.0f)
                reflectiveCurveToRelative(-4.0f, 8.0f, -11.0f, 8.0f)
                reflectiveCurveToRelative(-11.0f, -8.0f, -11.0f, -8.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(12.0f, 12.0f)
                moveToRelative(-3.0f, 0.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, true, true, 6.0f, 0.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, true, true, -6.0f, 0.0f)
            }
        }
            .build()
        return _eye!!
    }


private var _eyeOff: ImageVector? = null
val EyeOff: ImageVector
    get() {
        if (_eyeOff != null) {
            return _eyeOff!!
        }
        _eyeOff = ImageVector.Builder(
            name = "EyeOff", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(17.94f, 17.94f)
                arcTo(10.07f, 10.07f, 0.0f, false, true, 12.0f, 20.0f)
                curveToRelative(-7.0f, 0.0f, -11.0f, -8.0f, -11.0f, -8.0f)
                arcToRelative(18.45f, 18.45f, 0.0f, false, true, 5.06f, -5.94f)
                moveTo(9.9f, 4.24f)
                arcTo(9.12f, 9.12f, 0.0f, false, true, 12.0f, 4.0f)
                curveToRelative(7.0f, 0.0f, 11.0f, 8.0f, 11.0f, 8.0f)
                arcToRelative(18.5f, 18.5f, 0.0f, false, true, -2.16f, 3.19f)
                moveToRelative(-6.72f, -1.07f)
                arcToRelative(3.0f, 3.0f, 0.0f, true, true, -4.24f, -4.24f)
            }
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(1.0f, 1.0f)
                lineTo(23.0f, 23.0f)
            }
        }
            .build()
        return _eyeOff!!
    }

private var _save: ImageVector? = null
public val Save: ImageVector
    get() {
        if (_save != null) {
            return _save!!
        }
        _save = ImageVector.Builder(
            name = "Save", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.0f, 21.0f)
                horizontalLineTo(5.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, false, true, -2.0f, -2.0f)
                verticalLineTo(5.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, false, true, 2.0f, -2.0f)
                horizontalLineToRelative(11.0f)
                lineToRelative(5.0f, 5.0f)
                verticalLineToRelative(11.0f)
                arcToRelative(2.0f, 2.0f, 0.0f, false, true, -2.0f, 2.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(17.0f, 21.0f)
                lineToRelative(0.0f, -8.0f)
                lineToRelative(-10.0f, 0.0f)
                lineToRelative(0.0f, 8.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(7.0f, 3.0f)
                lineToRelative(0.0f, 5.0f)
                lineToRelative(8.0f, 0.0f)
            }
        }
            .build()
        return _save!!
    }


private var _barChart: ImageVector? = null
public val BarChart: ImageVector
    get() {
        if (_barChart != null) {
            return _barChart!!
        }
        _barChart = ImageVector.Builder(
            name = "BarChart", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.0f, 20.0f)
                lineTo(12.0f, 10.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.0f, 20.0f)
                lineTo(18.0f, 4.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.0f, 20.0f)
                lineTo(6.0f, 16.0f)
            }
        }
            .build()
        return _barChart!!
    }