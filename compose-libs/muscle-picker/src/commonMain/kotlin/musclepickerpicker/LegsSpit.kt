package musclepickerpicker

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import atom.Design

public fun legsSplit(
    outlineColor: Color = Design.palette.content,
    quadriceps: Color = Design.palette.caption,
    gluteal: Color = Design.palette.caption,
    hamstrings: Color = Design.palette.caption,
    calf: Color = Design.palette.caption,
    other: Color = Design.palette.caption
): ImageVector {
    return ImageVector.Builder(
        name = "vector",
        defaultWidth = 305.dp,
        defaultHeight = 457.dp,
        viewportWidth = 305f,
        viewportHeight = 457f
    ).apply {
        path(
            fill = null,
            fillAlpha = 1.0f,
            stroke = SolidColor(outlineColor),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(180.687f, 447.827f)
            curveTo(177.487f, 449.427f, 180.354f, 453.161f, 182.187f, 454.827f)
            curveTo(191.354f, 455.494f, 211.287f, 456.527f, 217.687f, 455.327f)
            curveTo(224.087f, 454.127f, 225.02f, 449.827f, 224.687f, 447.827f)
            verticalLineTo(436.827f)
            curveTo(223.52f, 433.327f, 221.387f, 424.927f, 222.187f, 419.327f)
            curveTo(222.987f, 413.727f, 221.854f, 408.327f, 221.187f, 406.327f)
            curveTo(220.787f, 401.927f, 222.354f, 377.161f, 223.187f, 365.327f)
            curveTo(229.687f, 310.827f, 229.187f, 313.827f, 229.687f, 294.327f)
            curveTo(230.187f, 274.827f, 219.187f, 228.827f, 219.187f, 226.827f)
            curveTo(219.187f, 225.227f, 220.187f, 214.827f, 220.687f, 209.827f)
            lineTo(223.687f, 185.827f)
            curveTo(227.354f, 154.994f, 234.887f, 92.0272f, 235.687f, 86.8272f)
            curveTo(236.487f, 81.6272f, 237.354f, 81.9939f, 237.687f, 82.8272f)
            lineTo(246.187f, 143.827f)
            curveTo(248.354f, 165.161f, 252.987f, 208.327f, 254.187f, 210.327f)
            curveTo(255.387f, 212.327f, 254.687f, 223.494f, 254.187f, 228.827f)
            lineTo(251.687f, 246.827f)
            lineTo(244.187f, 289.327f)
            curveTo(243.854f, 300.161f, 243.787f, 324.027f, 246.187f, 332.827f)
            curveTo(248.587f, 341.627f, 251.187f, 385.494f, 252.187f, 406.327f)
            curveTo(250.587f, 408.727f, 251.187f, 416.327f, 251.687f, 419.827f)
            curveTo(251.187f, 423.827f, 249.887f, 434.027f, 248.687f, 442.827f)
            curveTo(247.487f, 451.627f, 250.52f, 454.827f, 252.187f, 455.327f)
            curveTo(263.187f, 455.494f, 286.287f, 455.727f, 290.687f, 455.327f)
            curveTo(295.087f, 454.927f, 294.854f, 450.494f, 294.187f, 448.327f)
            curveTo(292.02f, 447.827f, 287.187f, 445.427f, 285.187f, 439.827f)
            curveTo(283.187f, 434.227f, 276.354f, 425.161f, 273.187f, 421.327f)
            verticalLineTo(417.827f)
            curveTo(273.587f, 412.627f, 271.687f, 407.327f, 270.687f, 405.327f)
            curveTo(270.52f, 402.327f, 270.287f, 394.327f, 270.687f, 386.327f)
            curveTo(271.087f, 378.327f, 278.52f, 348.994f, 282.187f, 335.327f)
            curveTo(283.687f, 332.661f, 287.887f, 321.927f, 292.687f, 300.327f)
            curveTo(297.487f, 278.727f, 291.687f, 243.661f, 288.187f, 228.827f)
            curveTo(290.587f, 225.227f, 291.187f, 216.994f, 291.187f, 213.327f)
            curveTo(295.987f, 201.727f, 301.52f, 162.827f, 303.687f, 144.827f)
            curveTo(303.354f, 125.161f, 302.387f, 78.2272f, 301.187f, 47.8272f)
            lineTo(297f, 25.3273f)
            curveTo(289.167f, 17.7384f, 265.937f, 2.2607f, 235.687f, 1.0607f)
            curveTo(205.436f, -0.1393f, 183.416f, 16.7384f, 176.187f, 25.3273f)
            lineTo(172.187f, 51.3273f)
            curveTo(171.52f, 71.1606f, 170.087f, 116.027f, 169.687f, 136.827f)
            curveTo(169.287f, 157.627f, 178.187f, 194.161f, 182.687f, 209.827f)
            curveTo(181.887f, 213.427f, 184.02f, 223.327f, 185.187f, 227.827f)
            curveTo(184.187f, 235.494f, 181.587f, 254.227f, 179.187f, 267.827f)
            curveTo(176.187f, 284.827f, 185.687f, 317.827f, 186.187f, 318.827f)
            curveTo(186.587f, 319.627f, 193.02f, 341.161f, 196.187f, 351.827f)
            curveTo(197.854f, 360.494f, 201.587f, 378.727f, 203.187f, 382.327f)
            curveTo(204.787f, 385.927f, 203.854f, 399.827f, 203.187f, 406.327f)
            curveTo(199.587f, 409.527f, 200.354f, 416.327f, 201.187f, 419.327f)
            curveTo(200.687f, 421.161f, 199.187f, 424.927f, 197.187f, 425.327f)
            curveTo(195.187f, 425.727f, 191.354f, 434.494f, 189.687f, 438.827f)
            curveTo(188.02f, 441.161f, 183.887f, 446.227f, 180.687f, 447.827f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(194.187f, 452.327f)
            curveTo(193.387f, 450.327f, 199.854f, 432.161f, 203.187f, 423.327f)
            verticalLineTo(444.327f)
            curveTo(203.854f, 446.494f, 206.287f, 450.027f, 210.687f, 446.827f)
            curveTo(216.187f, 442.827f, 212.687f, 417.327f, 217.687f, 425.827f)
            curveTo(221.687f, 432.627f, 221.02f, 446.327f, 220.187f, 452.327f)
            curveTo(211.854f, 453.161f, 194.987f, 454.327f, 194.187f, 452.327f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(253.687f, 452.327f)
            curveTo(252.087f, 449.527f, 255.354f, 433.494f, 257.187f, 425.827f)
            curveTo(258.187f, 433.994f, 261.487f, 450.027f, 266.687f, 448.827f)
            curveTo(271.887f, 447.627f, 270.52f, 431.327f, 269.187f, 423.327f)
            curveTo(273.587f, 425.727f, 278.02f, 443.661f, 279.687f, 452.327f)
            curveTo(271.687f, 453.494f, 255.287f, 455.127f, 253.687f, 452.327f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(197.687f, 346.327f)
            curveTo(203.687f, 357.527f, 207.187f, 395.327f, 208.187f, 412.827f)
            curveTo(212.687f, 418.827f, 211.187f, 412.827f, 211.687f, 410.327f)
            curveTo(212.087f, 408.327f, 209.52f, 378.161f, 208.187f, 363.327f)
            curveTo(206.354f, 355.994f, 202.087f, 338.027f, 199.687f, 324.827f)
            curveTo(197.287f, 311.627f, 194.02f, 314.327f, 192.687f, 317.327f)
            curveTo(191.854f, 322.327f, 191.687f, 335.127f, 197.687f, 346.327f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(218.187f, 411.827f)
            curveTo(216.987f, 416.627f, 215.687f, 413.494f, 215.187f, 411.327f)
            lineTo(217.187f, 381.327f)
            lineTo(219.187f, 347.327f)
            lineTo(220.187f, 326.827f)
            curveTo(221.02f, 322.661f, 222.987f, 314.627f, 224.187f, 315.827f)
            curveTo(225.387f, 317.027f, 224.687f, 329.661f, 224.187f, 335.827f)
            curveTo(223.354f, 342.827f, 221.587f, 357.427f, 221.187f, 359.827f)
            curveTo(220.787f, 362.227f, 219.354f, 379.827f, 218.687f, 388.327f)
            lineTo(218.187f, 411.827f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(257.187f, 411.827f)
            curveTo(256.387f, 415.827f, 255.52f, 414.161f, 255.187f, 412.827f)
            verticalLineTo(405.827f)
            curveTo(255.187f, 404.627f, 252.854f, 372.994f, 251.687f, 357.327f)
            curveTo(250.887f, 354.927f, 249.354f, 342.327f, 248.687f, 336.327f)
            lineTo(247.687f, 323.327f)
            curveTo(248.087f, 314.927f, 248.854f, 313.827f, 249.187f, 314.327f)
            lineTo(253.187f, 330.327f)
            curveTo(253.354f, 332.161f, 253.587f, 336.327f, 253.187f, 338.327f)
            curveTo(252.787f, 340.327f, 254.02f, 360.494f, 254.687f, 370.327f)
            lineTo(257.187f, 411.827f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(264.687f, 410.327f)
            curveTo(261.887f, 418.327f, 260.854f, 414.327f, 260.687f, 411.327f)
            curveTo(261.187f, 404.327f, 262.187f, 389.727f, 262.187f, 387.327f)
            curveTo(262.187f, 384.927f, 264.854f, 366.994f, 266.187f, 358.327f)
            curveTo(268.354f, 347.161f, 272.887f, 324.027f, 273.687f, 320.827f)
            curveTo(274.687f, 316.827f, 276.187f, 314.327f, 279.687f, 314.827f)
            curveTo(282.487f, 315.227f, 281.52f, 325.327f, 280.687f, 330.327f)
            curveTo(277.854f, 340.161f, 271.587f, 360.827f, 269.187f, 364.827f)
            curveTo(266.787f, 368.827f, 265.187f, 396.827f, 264.687f, 410.327f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(258.687f, 309.327f)
            curveTo(251.487f, 318.127f, 249.354f, 312.994f, 249.187f, 309.327f)
            curveTo(249.187f, 303.161f, 248.887f, 287.427f, 247.687f, 273.827f)
            curveTo(246.487f, 260.227f, 263.52f, 220.827f, 272.187f, 202.827f)
            verticalLineTo(240.827f)
            curveTo(271.187f, 247.661f, 269.187f, 264.827f, 269.187f, 278.827f)
            curveTo(269.187f, 292.827f, 267.187f, 299.661f, 266.187f, 301.327f)
            curveTo(266.687f, 300.327f, 265.887f, 300.527f, 258.687f, 309.327f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(271.187f, 301.327f)
            curveTo(276.787f, 290.927f, 276.854f, 230.327f, 276.187f, 201.327f)
            curveTo(280.987f, 193.727f, 282.854f, 198.161f, 283.187f, 201.327f)
            lineTo(287.687f, 231.827f)
            curveTo(289.354f, 245.161f, 292.687f, 273.227f, 292.687f, 278.827f)
            curveTo(292.687f, 284.427f, 282.687f, 302.494f, 277.687f, 310.827f)
            lineTo(271.187f, 301.327f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(201.187f, 233.827f)
            lineTo(202.187f, 203.827f)
            curveTo(216.187f, 225.427f, 223.354f, 257.827f, 225.187f, 271.327f)
            curveTo(225.687f, 281.327f, 226.387f, 302.927f, 225.187f, 309.327f)
            curveTo(223.987f, 315.727f, 218.02f, 312.994f, 215.187f, 310.827f)
            curveTo(211.854f, 307.661f, 205.387f, 300.827f, 206.187f, 298.827f)
            curveTo(206.987f, 296.827f, 203.187f, 254.661f, 201.187f, 233.827f)
            close()
        }
        path(
            fill = SolidColor(calf),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(197.687f, 201.327f)
            curveTo(192.887f, 194.527f, 191.687f, 197.827f, 191.687f, 200.327f)
            lineTo(187.687f, 225.327f)
            curveTo(185.52f, 239.161f, 181.087f, 268.527f, 180.687f, 275.327f)
            curveTo(180.287f, 282.127f, 190.52f, 301.827f, 195.687f, 310.827f)
            lineTo(202.187f, 301.327f)
            curveTo(196.587f, 291.727f, 196.854f, 230.661f, 197.687f, 201.327f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(192.187f, 185.327f)
            lineTo(183.687f, 204.327f)
            lineTo(178.187f, 163.827f)
            curveTo(177.354f, 149.327f, 176.787f, 117.927f, 181.187f, 108.327f)
            curveTo(185.587f, 98.7272f, 194.02f, 93.3272f, 197.687f, 91.8272f)
            curveTo(184.087f, 124.627f, 188.354f, 167.827f, 192.187f, 185.327f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(209.687f, 180.827f)
            curveTo(208.087f, 184.027f, 209.02f, 202.827f, 209.687f, 211.827f)
            curveTo(190.187f, 184.327f, 194.187f, 163.827f, 192.187f, 147.827f)
            curveTo(190.587f, 135.027f, 200.187f, 101.161f, 205.187f, 85.8272f)
            curveTo(207.187f, 86.6272f, 210.02f, 115.161f, 211.187f, 129.327f)
            curveTo(211.354f, 145.161f, 211.287f, 177.627f, 209.687f, 180.827f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(213.687f, 219.327f)
            curveTo(214.02f, 195.327f, 214.887f, 146.027f, 215.687f, 140.827f)
            curveTo(219.187f, 165.327f, 223.687f, 215.327f, 213.687f, 219.327f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(221.507f, 164.733f)
            curveTo(221.568f, 165.102f, 221.628f, 165.467f, 221.687f, 165.827f)
            curveTo(221.608f, 165.51f, 221.548f, 165.143f, 221.507f, 164.733f)
            curveTo(217.132f, 138.045f, 209.214f, 86.089f, 211.187f, 83.3272f)
            curveTo(213.187f, 80.5272f, 223.354f, 74.1606f, 228.187f, 71.3272f)
            curveTo(231.046f, 82.8272f, 234.549f, 112.127f, 225.687f, 137.327f)
            curveTo(223.975f, 144.332f, 220.925f, 158.925f, 221.507f, 164.733f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(262.187f, 83.3272f)
            lineTo(245.187f, 71.3272f)
            curveTo(238.787f, 92.9272f, 247.854f, 143.327f, 253.187f, 165.827f)
            curveTo(251.987f, 160.627f, 256.687f, 132.661f, 259.187f, 119.327f)
            curveTo(263.987f, 98.9272f, 263.187f, 86.8272f, 262.187f, 83.3272f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(262.187f, 176.827f)
            curveTo(258.587f, 150.427f, 265.354f, 105.161f, 269.187f, 85.8272f)
            curveTo(291.987f, 156.227f, 275.354f, 199.161f, 264.187f, 211.827f)
            curveTo(266.987f, 205.827f, 264.02f, 185.994f, 262.187f, 176.827f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(281.187f, 185.327f)
            curveTo(292.787f, 154.527f, 282.354f, 110.161f, 275.687f, 91.8272f)
            curveTo(279.187f, 91.1606f, 287.787f, 95.2272f, 294.187f, 116.827f)
            curveTo(300.587f, 138.427f, 293.187f, 184.161f, 288.687f, 204.327f)
            lineTo(281.187f, 185.327f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(253.187f, 198.327f)
            lineTo(258.187f, 140.827f)
            curveTo(259.626f, 145.227f, 259.453f, 194.994f, 259.187f, 219.327f)
            curveTo(256.787f, 219.327f, 254.187f, 205.327f, 253.187f, 198.327f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(294.187f, 103.827f)
            curveTo(295.347f, 97.0272f, 299.003f, 83.6606f, 300.687f, 77.8272f)
            verticalLineTo(127.327f)
            lineTo(294.187f, 103.827f)
            close()
        }
        path(
            fill = SolidColor(hamstrings),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(173.187f, 127.327f)
            verticalLineTo(77.8272f)
            curveTo(175.987f, 81.0272f, 179.02f, 97.1606f, 180.187f, 104.827f)
            lineTo(173.187f, 127.327f)
            close()
        }
        path(
            fill = SolidColor(gluteal),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(182.187f, 92.8272f)
            curveTo(175.387f, 78.8272f, 177.02f, 51.9939f, 178.687f, 40.3272f)
            curveTo(190.687f, 18.8272f, 229.687f, 18.8272f, 232.687f, 20.3272f)
            curveTo(235.087f, 21.5272f, 233.687f, 44.1606f, 232.687f, 55.3272f)
            lineTo(225.187f, 65.3272f)
            curveTo(220.187f, 68.4939f, 207.687f, 75.8272f, 197.687f, 79.8272f)
            curveTo(187.687f, 83.8272f, 183.187f, 90.1606f, 182.187f, 92.8272f)
            close()
        }
        path(
            fill = SolidColor(gluteal),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(239.187f, 55.3272f)
            verticalLineTo(20.3272f)
            curveTo(260.187f, 17.8272f, 286.687f, 28.3272f, 293.187f, 40.3272f)
            curveTo(298.387f, 49.9272f, 292.687f, 79.3272f, 289.187f, 92.8272f)
            curveTo(288.854f, 90.6606f, 285.187f, 85.0272f, 273.187f, 79.8272f)
            curveTo(261.187f, 74.6272f, 250.52f, 67.9939f, 246.687f, 65.3272f)
            lineTo(239.187f, 55.3272f)
            close()
        }
        path(
            fill = null,
            fillAlpha = 1.0f,
            stroke = SolidColor(Color(0xFFFFFFFF)),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(31.9568f, 423.549f)
            lineTo(34.9568f, 411.049f)
            lineTo(33.9568f, 381.549f)
            curveTo(30.4568f, 360.882f, 22.4568f, 323.549f, 14.4568f, 307.549f)
            curveTo(7.0898f, 292.815f, 12.1235f, 247.216f, 16.4568f, 229.049f)
            lineTo(12.4568f, 197.549f)
            curveTo(-4.1492f, 149.461f, 0.4893f, 72.4727f, 6.5746f, 26.5607f)
            curveTo(13.5498f, 18.7274f, 35.4914f, 2.7607f, 67.4568f, 1.5607f)
            curveTo(99.4222f, 0.3607f, 123.138f, 17.7274f, 131f, 26.5607f)
            curveTo(133f, 34.8941f, 133.557f, 43.6489f, 135.957f, 96.0489f)
            curveTo(138.357f, 148.449f, 128.957f, 188.549f, 123.957f, 202.049f)
            curveTo(119.157f, 225.649f, 120.29f, 236.216f, 121.457f, 238.549f)
            curveTo(129.857f, 260.949f, 126.623f, 288.549f, 123.957f, 299.549f)
            curveTo(121.123f, 309.049f, 115.257f, 328.349f, 114.457f, 329.549f)
            curveTo(113.457f, 331.049f, 103.957f, 381.049f, 101.957f, 384.549f)
            curveTo(100.357f, 387.349f, 101.29f, 399.049f, 101.957f, 404.549f)
            lineTo(102.957f, 411.049f)
            lineTo(103.957f, 420.549f)
            lineTo(121.457f, 444.549f)
            lineTo(126.457f, 449.549f)
            verticalLineTo(453.049f)
            lineTo(122.957f, 454.628f)
            lineTo(86.4568f, 455.549f)
            lineTo(80.4568f, 449.549f)
            lineTo(81.4568f, 435.549f)
            lineTo(82.9568f, 420.549f)
            curveTo(83.7901f, 410.216f, 84.9568f, 386.049f, 82.9568f, 372.049f)
            curveTo(80.4568f, 354.549f, 76.4568f, 309.049f, 75.4568f, 299.549f)
            curveTo(74.6568f, 291.949f, 81.7901f, 253.049f, 85.4568f, 234.549f)
            curveTo(85.6235f, 227.882f, 85.8568f, 214.249f, 85.4568f, 213.049f)
            curveTo(85.0568f, 211.849f, 78.2901f, 154.882f, 74.9568f, 126.549f)
            curveTo(73.7901f, 110.549f, 70.6568f, 79.6489f, 67.4568f, 84.0489f)
            curveTo(64.2568f, 88.4489f, 57.7901f, 157.216f, 54.9568f, 191.049f)
            curveTo(49.3568f, 205.049f, 50.6235f, 227.216f, 51.9568f, 236.549f)
            curveTo(60.3568f, 269.749f, 61.7901f, 297.716f, 61.4568f, 307.549f)
            curveTo(60.1235f, 322.882f, 56.8568f, 354.349f, 54.4568f, 357.549f)
            curveTo(52.0568f, 360.749f, 53.4568f, 383.216f, 54.4568f, 394.049f)
            verticalLineTo(423.549f)
            lineTo(57.4568f, 446.549f)
            lineTo(54.4568f, 453.549f)
            curveTo(51.9568f, 454.049f, 43.4568f, 454.549f, 37.4568f, 454.549f)
            curveTo(14.2258f, 454.549f, 12.4568f, 451.716f, 14.4568f, 449.549f)
            lineTo(31.9568f, 423.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(40.9568f, 437.549f)
            lineTo(31.9568f, 429.549f)
            curveTo(26.1234f, 435.882f, 14.9568f, 449.049f, 16.9568f, 451.049f)
            curveTo(18.9568f, 453.049f, 32.1234f, 452.882f, 38.4568f, 452.549f)
            lineTo(40.9568f, 437.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(42.4568f, 452.549f)
            lineTo(43.4568f, 441.549f)
            curveTo(44.2568f, 438.349f, 46.4568f, 440.216f, 47.4568f, 441.549f)
            lineTo(50.9568f, 446.549f)
            verticalLineTo(452.549f)
            horizontalLineTo(42.4568f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(86.4568f, 445.049f)
            verticalLineTo(451.049f)
            verticalLineTo(452.549f)
            horizontalLineTo(93.9568f)
            verticalLineTo(443.049f)
            curveTo(91.5568f, 435.449f, 87.9568f, 441.216f, 86.4568f, 445.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(98.4568f, 452.549f)
            curveTo(97.2568f, 449.749f, 96.6235f, 441.382f, 96.4568f, 437.549f)
            verticalLineTo(436.549f)
            lineTo(105.957f, 429.549f)
            curveTo(120.357f, 445.149f, 121.623f, 450.382f, 120.457f, 451.049f)
            lineTo(98.4568f, 452.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(51.4568f, 442.549f)
            curveTo(49.4568f, 436.949f, 38.9568f, 428.216f, 33.9568f, 424.549f)
            curveTo(34.6235f, 421.549f, 36.0568f, 413.849f, 36.4568f, 407.049f)
            curveTo(36.8568f, 400.249f, 38.6235f, 399.882f, 39.4568f, 400.549f)
            curveTo(47.4568f, 408.549f, 51.7901f, 419.882f, 52.9568f, 424.549f)
            curveTo(53.2901f, 432.882f, 53.4568f, 448.149f, 51.4568f, 442.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(83.9568f, 439.049f)
            lineTo(84.4568f, 425.549f)
            curveTo(91.2568f, 403.149f, 96.9568f, 399.882f, 98.9568f, 401.049f)
            lineTo(101.457f, 415.049f)
            lineTo(102.457f, 425.549f)
            curveTo(99.6235f, 426.049f, 92.9568f, 428.949f, 88.9568f, 436.549f)
            curveTo(84.9568f, 444.149f, 83.9568f, 441.382f, 83.9568f, 439.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(86.4568f, 409.049f)
            verticalLineTo(393.549f)
            lineTo(95.4568f, 387.049f)
            curveTo(96.6235f, 388.382f, 98.5568f, 391.349f, 96.9568f, 392.549f)
            curveTo(95.3568f, 393.749f, 89.2901f, 404.049f, 86.4568f, 409.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(49.9568f, 409.049f)
            lineTo(39.4568f, 391.549f)
            curveTo(39.0568f, 389.149f, 41.2901f, 387.549f, 42.4568f, 387.049f)
            lineTo(50.4568f, 394.049f)
            curveTo(51.6568f, 401.249f, 50.6235f, 407.049f, 49.9568f, 409.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(47.9569f, 373.549f)
            curveTo(55.7902f, 346.216f, 67.4569f, 285.149f, 51.4569f, 259.549f)
            curveTo(45.1235f, 265.216f, 35.5569f, 295.949f, 47.9569f, 373.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(40.4569f, 347.049f)
            curveTo(40.4569f, 305.849f, 25.4568f, 259.882f, 17.9568f, 242.049f)
            lineTo(16.9568f, 259.549f)
            curveTo(17.9568f, 267.049f, 21.3568f, 285.849f, 26.9568f, 301.049f)
            curveTo(32.5568f, 316.249f, 35.6235f, 338.049f, 36.4569f, 347.049f)
            curveTo(38.9569f, 358.549f, 40.4569f, 361.049f, 42.9569f, 376.549f)
            curveTo(44.9569f, 388.949f, 47.1235f, 387.382f, 47.9569f, 385.049f)
            curveTo(44.7569f, 379.449f, 41.6235f, 357.382f, 40.4569f, 347.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(28.9568f, 318.549f)
            curveTo(28.9568f, 315.349f, 19.6235f, 282.216f, 14.9568f, 266.049f)
            curveTo(13.1283f, 275.249f, 15.5283f, 293.216f, 16.9568f, 301.049f)
            lineTo(21.9568f, 321.549f)
            lineTo(29.9568f, 350.549f)
            curveTo(31.4568f, 356.716f, 35.1569f, 370.849f, 37.9569f, 378.049f)
            curveTo(41.4569f, 387.049f, 41.9569f, 379.549f, 40.4569f, 378.049f)
            curveTo(39.2568f, 376.849f, 35.2902f, 355.882f, 33.4569f, 345.549f)
            curveTo(31.9569f, 337.882f, 28.9568f, 321.749f, 28.9568f, 318.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(85.9568f, 257.549f)
            curveTo(91.9568f, 269.549f, 101.057f, 309.549f, 89.4568f, 373.549f)
            curveTo(81.7902f, 348.716f, 70.3568f, 290.749f, 85.9568f, 257.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(107.457f, 312.549f)
            curveTo(119.457f, 279.258f, 120.124f, 251.678f, 118.957f, 242.049f)
            curveTo(113.79f, 255.049f, 102.957f, 288.349f, 100.957f, 317.549f)
            curveTo(98.9568f, 346.749f, 92.7902f, 371.716f, 89.9568f, 380.549f)
            curveTo(89.5568f, 388.149f, 91.7902f, 386.716f, 92.9568f, 385.049f)
            lineTo(107.457f, 312.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(121.457f, 301.049f)
            lineTo(122.957f, 266.549f)
            lineTo(111.957f, 306.049f)
            curveTo(109.624f, 314.716f, 104.957f, 334.149f, 104.957f, 342.549f)
            curveTo(104.957f, 350.949f, 99.2902f, 368.716f, 96.4568f, 376.549f)
            lineTo(97.4568f, 380.549f)
            curveTo(100.79f, 374.049f, 107.457f, 358.749f, 107.457f, 349.549f)
            curveTo(107.457f, 340.349f, 116.79f, 313.382f, 121.457f, 301.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(97.4568f, 266.049f)
            curveTo(98.6568f, 260.849f, 92.2902f, 227.549f, 88.9568f, 211.549f)
            lineTo(87.4568f, 235.549f)
            curveTo(90.2902f, 247.882f, 96.2569f, 271.249f, 97.4568f, 266.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(47.9568f, 221.549f)
            curveTo(43.5568f, 230.749f, 40.4568f, 255.049f, 39.4568f, 266.049f)
            curveTo(52.2568f, 238.049f, 50.4568f, 218.049f, 47.9568f, 211.549f)
            verticalLineTo(221.549f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(22.4568f, 204.049f)
            curveTo(12.7901f, 174.049f, -4.3432f, 107.649f, 4.4568f, 82.0489f)
            curveTo(14.6235f, 120.049f, 32.4568f, 197.649f, 22.4568f, 204.049f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(39.4568f, 111.549f)
            curveTo(45.0568f, 120.749f, 38.7901f, 174.716f, 34.9568f, 200.549f)
            curveTo(32.9568f, 201.216f, 29.3568f, 200.749f, 30.9568f, 193.549f)
            curveTo(32.5568f, 186.349f, 31.6235f, 169.216f, 30.9568f, 161.549f)
            curveTo(4.5568f, 110.749f, 6.6235f, 48.3822f, 10.9568f, 23.5489f)
            curveTo(18.1235f, 49.0489f, 33.8568f, 102.349f, 39.4568f, 111.549f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(44.4568f, 164.049f)
            curveTo(41.2568f, 187.249f, 43.1235f, 201.382f, 44.4568f, 205.549f)
            curveTo(53.6568f, 211.549f, 55.2901f, 182.049f, 54.9568f, 166.549f)
            curveTo(53.6235f, 160.382f, 50.3568f, 145.349f, 47.9568f, 134.549f)
            curveTo(45.5568f, 123.749f, 44.6235f, 124.716f, 44.4568f, 126.549f)
            curveTo(45.7901f, 129.382f, 47.6568f, 140.849f, 44.4568f, 164.049f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(44.4568f, 110.049f)
            curveTo(31.2568f, 86.8489f, 21.6235f, 41.0489f, 18.4568f, 21.0489f)
            curveTo(19.4272f, 26.3822f, 24.0857f, 40.3489f, 34.9568f, 53.5489f)
            curveTo(45.8279f, 66.7489f, 52.8198f, 97.7156f, 54.9568f, 111.549f)
            curveTo(55.6235f, 126.382f, 56.7568f, 154.049f, 55.9568f, 146.049f)
            curveTo(55.1568f, 138.049f, 47.9568f, 118.716f, 44.4568f, 110.049f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(44.4568f, 58.0489f)
            lineTo(26.4568f, 23.5489f)
            curveTo(31.6568f, 25.5489f, 50.9568f, 44.3822f, 59.9568f, 53.5489f)
            curveTo(52.7568f, 72.3489f, 48.9568f, 75.7156f, 47.9568f, 75.0489f)
            lineTo(44.4568f, 58.0489f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(110.957f, 23.5489f)
            lineTo(77.4568f, 52.0489f)
            curveTo(81.2901f, 62.7156f, 89.0568f, 82.2489f, 89.4568f, 75.0489f)
            curveTo(89.9568f, 66.0489f, 92.4568f, 58.0489f, 93.4568f, 58.0489f)
            curveTo(94.2568f, 58.0489f, 105.457f, 35.0489f, 110.957f, 23.5489f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(94.9568f, 67.0489f)
            curveTo(97.7568f, 65.0489f, 111.79f, 35.5489f, 118.457f, 21.0489f)
            curveTo(122.857f, 25.8489f, 103.623f, 81.0489f, 93.4568f, 108.049f)
            lineTo(79.9568f, 148.549f)
            lineTo(82.4568f, 111.549f)
            curveTo(85.4568f, 97.5489f, 92.1568f, 69.0489f, 94.9568f, 67.0489f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(103.957f, 93.0489f)
            lineTo(126.457f, 23.5489f)
            curveTo(129.257f, 25.5489f, 130.29f, 54.0489f, 130.457f, 68.0489f)
            curveTo(128.123f, 88.2156f, 122.157f, 129.949f, 116.957f, 135.549f)
            curveTo(111.757f, 141.149f, 107.123f, 160.882f, 105.457f, 170.049f)
            verticalLineTo(197.549f)
            curveTo(105.457f, 204.349f, 101.123f, 202.382f, 98.9568f, 200.549f)
            verticalLineTo(191.549f)
            curveTo(98.1235f, 180.549f, 96.4568f, 153.749f, 96.4568f, 134.549f)
            curveTo(96.4568f, 115.349f, 101.457f, 98.8822f, 103.957f, 93.0489f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(111.957f, 165.549f)
            curveTo(113.957f, 164.749f, 126.123f, 109.549f, 131.957f, 82.0489f)
            curveTo(133.457f, 97.3822f, 135.757f, 132.049f, 132.957f, 148.049f)
            curveTo(130.157f, 164.049f, 117.79f, 192.049f, 111.957f, 204.049f)
            curveTo(111.123f, 191.549f, 109.957f, 166.349f, 111.957f, 165.549f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(84.9568f, 199.049f)
            curveTo(79.3568f, 166.649f, 86.9568f, 137.216f, 91.4568f, 126.549f)
            curveTo(91.7839f, 125.749f, 92.2597f, 154.549f, 92.4568f, 169.049f)
            lineTo(94.9568f, 196.549f)
            curveTo(91.7568f, 214.149f, 86.9568f, 205.549f, 84.9568f, 199.049f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(83.4568f, 90.0489f)
            curveTo(87.4568f, 83.2489f, 77.4568f, 64.5489f, 71.9568f, 56.0489f)
            curveTo(71.9568f, 65.0489f, 72.4568f, 85.6489f, 74.4568f, 96.0489f)
            curveTo(76.4568f, 106.449f, 79.6235f, 108.716f, 80.9568f, 108.549f)
            curveTo(80.1235f, 105.216f, 79.4568f, 96.8489f, 83.4568f, 90.0489f)
            close()
        }
        path(
            fill = SolidColor(quadriceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(57.9568f, 108.049f)
            curveTo(63.5568f, 102.449f, 65.2901f, 71.2156f, 64.9568f, 56.0489f)
            curveTo(54.4568f, 78.0489f, 49.9568f, 83.5489f, 53.9568f, 90.0489f)
            curveTo(57.1568f, 95.2489f, 56.6235f, 101.216f, 55.9568f, 103.549f)
            curveTo(56.7568f, 109.549f, 57.6235f, 109.049f, 57.9568f, 108.049f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(37.4568f, 235.549f)
            lineTo(29.9568f, 218.049f)
            verticalLineTo(214.049f)
            curveTo(37.9568f, 207.249f, 42.2901f, 213.216f, 43.4568f, 217.049f)
            lineTo(37.4568f, 235.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(28.4568f, 226.549f)
            lineTo(17.9568f, 201.049f)
            curveTo(17.9568f, 210.249f, 19.6235f, 226.216f, 20.4568f, 233.049f)
            curveTo(30.4568f, 239.449f, 31.9568f, 239.049f, 31.4568f, 238.049f)
            lineTo(28.4568f, 226.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(100.457f, 235.549f)
            lineTo(107.957f, 218.049f)
            verticalLineTo(214.049f)
            curveTo(99.9568f, 207.249f, 95.6235f, 213.216f, 94.4568f, 217.049f)
            lineTo(100.457f, 235.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(109.457f, 226.549f)
            lineTo(119.957f, 201.049f)
            curveTo(119.957f, 210.249f, 118.29f, 226.216f, 117.457f, 233.049f)
            curveTo(107.457f, 239.449f, 105.957f, 239.049f, 106.457f, 238.049f)
            lineTo(109.457f, 226.549f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(46f, 8.00002f)
            curveTo(48f, 29f, 48.2901f, 30.8822f, 53.9567f, 41.0489f)
            curveTo(59.1567f, 45.0489f, 62.1234f, 41.0489f, 62.9567f, 38.5489f)
            verticalLineTo(5.06075f)
            curveTo(53.9567f, 6.0607f, 51f, 6f, 46f, 8f)
            close()
        }
        path(
            fill = SolidColor(other),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(91f, 7.5f)
            curveTo(89f, 28.5f, 88.6667f, 30.3822f, 83f, 40.5489f)
            curveTo(77.8f, 44.5489f, 74.8334f, 40.5489f, 74f, 38.0489f)
            verticalLineTo(4.56073f)
            curveTo(83f, 5.5607f, 86f, 5.5f, 91f, 7.5f)
            close()
        }
    }.build()
}