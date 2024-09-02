package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun bodySplit(
    outlineColor: Color = Colors.outline,

    teresMajor: Color = Colors.defaultBack,
    rhomboids: Color = Colors.defaultBack,
    latissimus: Color = Colors.defaultBack,
    trapezius: Color = Colors.defaultBack,

    triceps: Color = Colors.defaultBack,
    biceps: Color = Colors.defaultFront,
    forearmFront: Color = Colors.defaultFront,
    forearmBack: Color = Colors.defaultBack,

    posteriorDeltoid: Color = Colors.defaultBack,
    lateralDeltoidFront: Color = Colors.defaultFront,
    anteriorDeltoid: Color = Colors.defaultFront,

    rectusAbdominis: Color = Colors.defaultFront,
    obliquesAbdominis: Color = Colors.defaultFront,

    pectoralisMajorAbdominal: Color = Colors.defaultFront,
    pectoralisMajorClavicular: Color = Colors.defaultFront,
    pectoralisMajorSternocostal: Color = Colors.defaultFront,

    other: Color = Colors.defaultFront,

    backgroundFront: Color = Colors.backgroundFront,
    backgroundBack: Color = Colors.backgroundBack
): ImageVector {

    return ImageVector.Builder(
        name = "Bodysplit",
        defaultWidth = 419.dp,
        defaultHeight = 430.dp,
        viewportWidth = 419f,
        viewportHeight = 430f
    ).apply {
        path(
            stroke = SolidColor(outlineColor),
            fill = SolidColor(backgroundFront),
            strokeLineWidth = 1f
        ) {
            moveTo(145.69f, 346.77f)
            lineTo(149.5f, 324.5f)
            curveTo(149.5f, 324.5f, 154.19f, 308.3f, 154.19f, 299.5f)
            verticalLineTo(262.27f)
            curveTo(147.69f, 250.1f, 134.79f, 224.97f, 135.19f, 221.77f)
            curveTo(132.85f, 232.27f, 126.49f, 254.57f, 119.69f, 259.77f)
            curveTo(119.02f, 269.43f, 112.19f, 295.07f, 90.19f, 320.27f)
            curveTo(68.19f, 345.47f, 61.69f, 354.43f, 61.19f, 355.77f)
            lineTo(54.69f, 373.27f)
            curveTo(53.52f, 382.77f, 48.59f, 405.27f, 38.19f, 419.27f)
            curveTo(35.52f, 420.77f, 31.09f, 421.77f, 34.69f, 413.77f)
            curveTo(38.29f, 405.77f, 38.85f, 403.1f, 38.69f, 402.77f)
            curveTo(38.69f, 401.93f, 38.29f, 400.77f, 36.69f, 402.77f)
            curveTo(34.19f, 409.77f, 28.59f, 424.37f, 26.19f, 426.77f)
            curveTo(23.19f, 429.77f, 20.19f, 424.27f, 21.69f, 422.77f)
            curveTo(22.89f, 421.57f, 28.85f, 407.27f, 31.69f, 400.27f)
            curveTo(32.19f, 398.77f, 32.59f, 396.47f, 30.19f, 399.27f)
            lineTo(18.19f, 425.77f)
            curveTo(15.52f, 426.27f, 10.69f, 426.17f, 12.69f, 421.77f)
            curveTo(14.69f, 417.37f, 22.52f, 401.27f, 26.19f, 393.77f)
            curveTo(26.19f, 392.77f, 25.79f, 391.27f, 24.19f, 393.27f)
            lineTo(12.69f, 416.27f)
            curveTo(10.69f, 417.27f, 7.09f, 417.87f, 8.69f, 412.27f)
            curveTo(10.29f, 406.67f, 16.69f, 390.27f, 19.69f, 382.77f)
            lineTo(23.69f, 372.27f)
            curveTo(24.02f, 371.93f, 24.39f, 371.37f, 23.19f, 371.77f)
            curveTo(21.69f, 372.27f, 11.69f, 379.27f, 5.69f, 380.27f)
            curveTo(0.89f, 381.07f, 0.69f, 376.27f, 1.19f, 373.77f)
            lineTo(28.69f, 354.77f)
            curveTo(30.02f, 354.27f, 33.49f, 353.37f, 36.69f, 353.77f)
            curveTo(42.19f, 347.27f, 54.39f, 330.27f, 59.19f, 314.27f)
            curveTo(65.19f, 294.27f, 67.69f, 281.27f, 77.19f, 268.77f)
            curveTo(84.79f, 258.77f, 90.35f, 251.27f, 92.19f, 248.77f)
            curveTo(93.02f, 232.1f, 96.39f, 196.97f, 103.19f, 189.77f)
            verticalLineTo(154.27f)
            curveTo(104.52f, 144.43f, 116.39f, 124.27f, 153.19f, 122.27f)
            curveTo(160.69f, 118.27f, 176.59f, 109.27f, 180.19f, 105.27f)
            curveTo(183.79f, 101.27f, 183.02f, 95.6f, 182.19f, 93.27f)
            lineTo(176.69f, 87.77f)
            lineTo(175.19f, 73.77f)
            curveTo(174.52f, 74.1f, 172.79f, 73.57f, 171.19f, 68.77f)
            lineTo(166.69f, 55.27f)
            curveTo(166.35f, 54.6f, 166.99f, 52.97f, 172.19f, 51.77f)
            curveTo(170.85f, 38.1f, 173.39f, 8.87f, 194.19f, 1.27f)
            horizontalLineTo(204.69f)
            verticalLineTo(370.5f)
            curveTo(185.24f, 372.5f, 156.92f, 352.51f, 145.69f, 346.77f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(174.69f, 289.77f)
            curveTo(174.29f, 318.17f, 185.52f, 345.6f, 191.19f, 355.77f)
            curveTo(196.39f, 359.77f, 199.35f, 355.77f, 200.19f, 353.27f)
            lineTo(198.69f, 300.77f)
            curveTo(193.89f, 287.57f, 180.69f, 287.93f, 174.69f, 289.77f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(172.69f, 279.27f)
            verticalLineTo(266.27f)
            curveTo(189.89f, 255.07f, 198.19f, 260.6f, 200.19f, 264.77f)
            curveTo(200.69f, 272.27f, 201.39f, 286.97f, 200.19f, 285.77f)
            curveTo(198.99f, 284.57f, 192.02f, 282.6f, 188.69f, 281.77f)
            curveTo(178.29f, 282.17f, 173.69f, 280.27f, 172.69f, 279.27f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(173.69f, 254.77f)
            lineTo(172.69f, 243.77f)
            curveTo(181.09f, 228.17f, 195.19f, 228.93f, 201.19f, 231.27f)
            curveTo(201.19f, 236.47f, 199.52f, 247.77f, 198.69f, 252.77f)
            curveTo(184.29f, 251.17f, 176.02f, 253.43f, 173.69f, 254.77f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(188.69f, 207.27f)
            curveTo(173.89f, 210.07f, 171.85f, 224.43f, 172.69f, 231.27f)
            curveTo(182.29f, 222.87f, 195.02f, 221.77f, 200.19f, 222.27f)
            curveTo(201.02f, 217.93f, 202.19f, 208.87f, 200.19f, 207.27f)
            curveTo(198.19f, 205.67f, 191.69f, 206.6f, 188.69f, 207.27f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(156.69f, 269.27f)
            curveTo(154.69f, 274.07f, 155.85f, 308.43f, 156.69f, 325.77f)
            curveTo(157.89f, 328.17f, 164.85f, 330.43f, 168.19f, 331.27f)
            lineTo(169.69f, 325.77f)
            lineTo(166.19f, 276.77f)
            curveTo(163.85f, 271.77f, 158.69f, 264.47f, 156.69f, 269.27f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(162.69f, 249.77f)
            lineTo(162.19f, 260.77f)
            curveTo(158.99f, 262.37f, 153.19f, 256.1f, 150.69f, 252.77f)
            curveTo(149.02f, 245.93f, 146.29f, 233.27f, 148.69f, 237.27f)
            curveTo(151.09f, 241.27f, 159.02f, 247.27f, 162.69f, 249.77f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(159.19f, 239.77f)
            lineTo(149.69f, 227.27f)
            verticalLineTo(222.77f)
            curveTo(152.09f, 221.97f, 158.69f, 226.77f, 161.69f, 229.27f)
            curveTo(161.69f, 231.43f, 161.59f, 236.37f, 161.19f, 238.77f)
            curveTo(160.79f, 241.17f, 159.69f, 240.43f, 159.19f, 239.77f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(159.19f, 222.77f)
            lineTo(150.19f, 212.27f)
            curveTo(149.19f, 209.27f, 151.69f, 209.77f, 154.69f, 209.77f)
            curveTo(157.09f, 209.77f, 161.35f, 212.1f, 163.19f, 213.27f)
            curveTo(163.85f, 214.6f, 165.09f, 218.07f, 164.69f, 221.27f)
            curveTo(164.29f, 224.47f, 160.85f, 223.6f, 159.19f, 222.77f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(163.69f, 208.27f)
            lineTo(149.69f, 198.27f)
            curveTo(148.69f, 194.27f, 152.69f, 195.27f, 155.69f, 195.77f)
            curveTo(158.09f, 196.17f, 164.35f, 198.6f, 167.19f, 199.77f)
            curveTo(168.19f, 199.93f, 169.89f, 201.17f, 168.69f, 204.77f)
            curveTo(167.49f, 208.37f, 164.85f, 208.6f, 163.69f, 208.27f)
            close()
        }
        path(fill = SolidColor(lateralDeltoidFront)) {
            moveTo(137.69f, 130.77f)
            curveTo(108.49f, 128.77f, 105.52f, 158.27f, 107.69f, 173.27f)
            lineTo(108.69f, 174.77f)
            curveTo(109.49f, 161.57f, 128.35f, 139.93f, 137.69f, 130.77f)
            close()
        }
        path(fill = SolidColor(anteriorDeltoid)) {
            moveTo(113.19f, 178.77f)
            curveTo(116.69f, 165.6f, 129.69f, 138.17f, 153.69f, 133.77f)
            curveTo(151.35f, 146.93f, 139.99f, 174.37f, 113.19f, 178.77f)
            close()
        }
        path(fill = SolidColor(biceps)) {
            moveTo(101.69f, 248.53f)
            curveTo(136.09f, 223.33f, 135.69f, 193.7f, 131.19f, 182.03f)
            curveTo(108.19f, 179.03f, 99.69f, 202.53f, 99.69f, 211.53f)
            curveTo(99.69f, 218.73f, 98.69f, 229.53f, 98.19f, 234.03f)
            curveTo(95.39f, 246.03f, 99.35f, 248.7f, 101.69f, 248.53f)
            close()
        }
        path(fill = SolidColor(forearmFront)) {
            moveTo(66.19f, 309.03f)
            curveTo(76.59f, 270.63f, 91.85f, 256.36f, 98.19f, 254.03f)
            curveTo(98.99f, 258.43f, 97.19f, 267.86f, 96.19f, 272.03f)
            curveTo(92.02f, 280.7f, 82.79f, 298.63f, 79.19f, 301.03f)
            curveTo(74.69f, 304.03f, 54.69f, 340.53f, 53.19f, 343.53f)
            curveTo(51.99f, 345.93f, 51.69f, 344.53f, 51.69f, 343.53f)
            lineTo(66.19f, 309.03f)
            close()
        }
        path(fill = SolidColor(forearmFront)) {
            moveTo(113.19f, 279.03f)
            verticalLineTo(266.03f)
            curveTo(112.39f, 263.63f, 110.52f, 264.7f, 109.69f, 265.53f)
            curveTo(103.69f, 272.03f, 93.69f, 284.03f, 91.19f, 289.03f)
            curveTo(89.19f, 293.03f, 91.69f, 292.7f, 93.19f, 292.03f)
            curveTo(98.02f, 288.86f, 108.29f, 282.43f, 110.69f, 282.03f)
            curveTo(113.09f, 281.63f, 113.35f, 279.86f, 113.19f, 279.03f)
            close()
        }
        path(fill = SolidColor(forearmFront)) {
            moveTo(57.19f, 345.03f)
            curveTo(59.59f, 341.83f, 84.85f, 310.36f, 97.19f, 295.03f)
            curveTo(97.85f, 294.03f, 97.19f, 293.33f, 89.19f, 298.53f)
            curveTo(81.19f, 303.73f, 64.52f, 329.7f, 57.19f, 342.03f)
            curveTo(56.19f, 344.36f, 54.79f, 348.23f, 57.19f, 345.03f)
            close()
        }
        path(fill = SolidColor(forearmFront)) {
            moveTo(61.19f, 343.53f)
            curveTo(79.19f, 329.13f, 98.35f, 303.53f, 105.69f, 292.53f)
            curveTo(107.69f, 291.33f, 106.52f, 294.7f, 105.69f, 296.53f)
            curveTo(93.19f, 320.53f, 66.19f, 342.03f, 62.69f, 344.03f)
            curveTo(59.89f, 345.63f, 60.52f, 344.36f, 61.19f, 343.53f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(40.19f, 394.27f)
            lineTo(28.19f, 381.27f)
            curveTo(26.59f, 380.07f, 26.52f, 378.1f, 26.69f, 377.27f)
            lineTo(33.69f, 366.27f)
            curveTo(39.52f, 359.27f, 51.79f, 347.87f, 54.19f, 358.27f)
            curveTo(57.19f, 371.27f, 49.19f, 386.27f, 47.19f, 392.27f)
            curveTo(45.59f, 397.07f, 41.85f, 395.6f, 40.19f, 394.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(35.69f, 360.27f)
            curveTo(18.09f, 374.27f, 6.69f, 376.77f, 3.19f, 376.27f)
            curveTo(2.79f, 375.07f, 3.69f, 374.43f, 4.19f, 374.27f)
            lineTo(31.69f, 356.27f)
            curveTo(37.69f, 354.67f, 36.85f, 358.27f, 35.69f, 360.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(11.69f, 408.27f)
            lineTo(22.69f, 384.27f)
            curveTo(24.02f, 383.93f, 26.69f, 383.87f, 26.69f, 386.27f)
            curveTo(26.69f, 389.27f, 16.69f, 406.27f, 14.19f, 411.77f)
            curveTo(12.19f, 416.17f, 11.69f, 411.27f, 11.69f, 408.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(30.19f, 396.77f)
            curveTo(31.79f, 390.77f, 29.19f, 391.6f, 27.69f, 392.77f)
            curveTo(26.92f, 393.27f, 17.69f, 416.27f, 16.69f, 419.77f)
            curveTo(15.89f, 422.57f, 18.35f, 422.93f, 19.69f, 422.77f)
            curveTo(22.52f, 416.6f, 28.59f, 402.77f, 30.19f, 396.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.69f, 401.77f)
            curveTo(37.89f, 398.97f, 35.52f, 397.6f, 34.19f, 397.27f)
            lineTo(32.69f, 398.27f)
            curveTo(30.19f, 403.77f, 25.09f, 415.57f, 24.69f, 418.77f)
            curveTo(24.29f, 421.97f, 26.85f, 421.77f, 28.19f, 421.27f)
            curveTo(30.52f, 415.93f, 35.49f, 404.57f, 36.69f, 401.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.69f, 411.27f)
            lineTo(42.69f, 399.77f)
            curveTo(45.49f, 398.17f, 45.52f, 401.43f, 45.19f, 403.27f)
            curveTo(44.35f, 405.43f, 42.09f, 410.67f, 39.69f, 414.27f)
            curveTo(37.29f, 417.87f, 36.69f, 413.77f, 36.69f, 411.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(129.19f, 228.77f)
            curveTo(123.99f, 238.77f, 109.69f, 251.93f, 103.19f, 257.27f)
            curveTo(103.19f, 260.07f, 105.52f, 259.43f, 106.69f, 258.77f)
            curveTo(113.02f, 254.6f, 126.39f, 244.47f, 129.19f, 237.27f)
            curveTo(131.99f, 230.07f, 130.35f, 228.6f, 129.19f, 228.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(139.19f, 220.27f)
            lineTo(137.69f, 193.77f)
            curveTo(137.19f, 191.43f, 137.09f, 188.17f, 140.69f, 193.77f)
            curveTo(144.29f, 199.37f, 146.19f, 209.77f, 146.69f, 214.27f)
            curveTo(146.69f, 221.27f, 146.19f, 234.77f, 144.19f, 232.77f)
            curveTo(142.19f, 230.77f, 140.02f, 223.6f, 139.19f, 220.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(200.19f, 141.27f)
            lineTo(184.69f, 110.77f)
            curveTo(184.29f, 99.57f, 185.19f, 96.77f, 185.69f, 96.77f)
            curveTo(188.49f, 99.57f, 197.85f, 120.27f, 202.19f, 130.27f)
            curveTo(202.59f, 138.27f, 201.02f, 140.93f, 200.19f, 141.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(184.19f, 122.77f)
            lineTo(178.69f, 130.27f)
            curveTo(183.09f, 133.87f, 186.52f, 132.43f, 187.69f, 131.27f)
            lineTo(184.19f, 122.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(179.69f, 117.27f)
            lineTo(167.19f, 129.27f)
            curveTo(163.69f, 129.27f, 155.99f, 129.17f, 153.19f, 128.77f)
            curveTo(150.39f, 128.37f, 151.35f, 126.93f, 152.19f, 126.27f)
            curveTo(158.19f, 122.43f, 171.59f, 114.37f, 177.19f, 112.77f)
            curveTo(182.79f, 111.17f, 181.19f, 115.1f, 179.69f, 117.27f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorSternocostal)) {
            moveTo(202.19f, 194f)
            curveTo(185.5f, 204.5f, 164f, 177.5f, 143f, 174.5f)
            curveTo(168.09f, 145.82f, 191.32f, 155.62f, 202.05f, 160.15f)
            lineTo(202.19f, 160.21f)
            verticalLineTo(194f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorAbdominal)) {
            moveTo(142.5f, 176f)
            curveTo(146f, 195f, 172.5f, 201.5f, 186f, 196.5f)
            curveTo(167.5f, 190.5f, 158f, 180f, 142.5f, 176f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorClavicular)) {
            moveTo(202.19f, 148.71f)
            curveTo(168.59f, 119.51f, 149.33f, 148.5f, 142f, 171f)
            verticalLineTo(173f)
            curveTo(165.6f, 143.4f, 190.35f, 153.54f, 202.19f, 158.21f)
            verticalLineTo(148.71f)
            close()
        }
        path(
            stroke = SolidColor(outlineColor),
            fill = SolidColor(backgroundBack),
            strokeLineWidth = 1f
        ) {
            moveTo(213f, 1.27f)
            curveTo(245.4f, -2.33f, 250.17f, 31.43f, 248.5f, 48.77f)
            curveTo(250.83f, 49.6f, 255.3f, 51.87f, 254.5f, 54.27f)
            curveTo(253.7f, 56.67f, 250.83f, 66.93f, 249.5f, 71.77f)
            horizontalLineTo(246.5f)
            lineTo(242f, 93.77f)
            horizontalLineTo(240f)
            verticalLineTo(88.27f)
            verticalLineTo(104.77f)
            curveTo(246.5f, 112.93f, 264.8f, 129.07f, 286f, 128.27f)
            curveTo(298.83f, 129.77f, 322.7f, 144.37f, 315.5f, 190.77f)
            curveTo(320.33f, 204.6f, 329.4f, 235.97f, 327f, 250.77f)
            curveTo(334.83f, 259.1f, 352.3f, 283.67f, 359.5f, 315.27f)
            curveTo(362.5f, 325.1f, 371.3f, 346.87f, 382.5f, 355.27f)
            curveTo(384.83f, 354.77f, 391.3f, 355.87f, 398.5f, 364.27f)
            lineTo(417.5f, 376.77f)
            curveTo(418.5f, 378.93f, 419f, 383.07f, 413f, 382.27f)
            curveTo(407f, 381.47f, 399.17f, 376.93f, 396f, 374.77f)
            lineTo(411f, 414.77f)
            curveTo(411.5f, 417.93f, 411.1f, 423.07f, 405.5f, 418.27f)
            lineTo(392.5f, 390.77f)
            lineTo(404.5f, 417.27f)
            curveTo(406f, 422.77f, 407.1f, 432.07f, 399.5f, 425.27f)
            lineTo(387.5f, 397.27f)
            lineTo(398.5f, 423.77f)
            curveTo(398.67f, 426.93f, 397.5f, 431.97f, 391.5f, 426.77f)
            lineTo(382.5f, 403.27f)
            curveTo(381.67f, 402.43f, 380.2f, 401.37f, 381f, 403.77f)
            curveTo(381.8f, 406.17f, 384.33f, 414.43f, 385.5f, 418.27f)
            curveTo(386f, 420.6f, 386.1f, 424.47f, 382.5f, 421.27f)
            curveTo(376f, 408.77f, 362.6f, 380.07f, 361f, 365.27f)
            lineTo(360.5f, 361.77f)
            lineTo(320.5f, 311.27f)
            curveTo(312.83f, 300.93f, 298.1f, 277.17f, 300.5f, 264.77f)
            curveTo(295.67f, 256.77f, 285.7f, 236.87f, 284.5f, 221.27f)
            curveTo(281f, 233.43f, 272.3f, 259.17f, 265.5f, 264.77f)
            lineTo(266f, 302.77f)
            curveTo(269.67f, 310.93f, 277.75f, 328f, 278.5f, 347f)
            curveTo(270.44f, 354.94f, 246.6f, 370.83f, 215.67f, 370.83f)
            curveTo(215.33f, 370f, 213f, 1.27f, 213f, 1.27f)
            close()
        }
        path(fill = SolidColor(rhomboids)) {
            moveTo(244.02f, 300.91f)
            curveTo(243.62f, 304.91f, 227.85f, 322.58f, 220.02f, 330.91f)
            curveTo(216.02f, 325.41f, 219.02f, 265.41f, 220.02f, 268.91f)
            curveTo(220.82f, 271.71f, 236.35f, 291.41f, 244.02f, 300.91f)
            close()
        }
        path(fill = SolidColor(latissimus)) {
            moveTo(268.76f, 245.27f)
            curveTo(255.55f, 266.07f, 249.26f, 285.27f, 247.76f, 292.27f)
            curveTo(218.55f, 268.67f, 216.26f, 236.1f, 218.76f, 222.77f)
            curveTo(227.26f, 216.77f, 244.76f, 203.87f, 246.76f, 200.27f)
            curveTo(248.76f, 196.67f, 252.92f, 194.77f, 254.76f, 194.27f)
            lineTo(285.26f, 190.77f)
            curveTo(286.26f, 196.77f, 285.26f, 219.27f, 268.76f, 245.27f)
            close()
        }
        path(fill = SolidColor(trapezius)) {
            moveTo(286.5f, 134.77f)
            curveTo(286.26f, 134.71f, 286f, 134.67f, 285.71f, 134.64f)
            lineTo(270.5f, 132.27f)
            curveTo(255.17f, 134.1f, 221.8f, 138.27f, 219f, 148.27f)
            curveTo(216.2f, 158.27f, 217.33f, 197.6f, 219f, 215.77f)
            curveTo(231.8f, 210.57f, 245.67f, 190.43f, 250.5f, 180.27f)
            curveTo(256.75f, 144.22f, 278.55f, 134.04f, 285.71f, 134.64f)
            lineTo(286.5f, 134.77f)
            close()
        }
        path(fill = SolidColor(trapezius)) {
            moveTo(222.5f, 138.27f)
            curveTo(223.7f, 135.47f, 248.67f, 130.1f, 261f, 127.77f)
            horizontalLineTo(262f)
            curveTo(225.6f, 107.77f, 219.5f, 81.43f, 221f, 70.77f)
            lineTo(217f, 72.27f)
            curveTo(219.5f, 79.27f, 221f, 141.77f, 222.5f, 138.27f)
            close()
        }
        path(fill = SolidColor(posteriorDeltoid)) {
            moveTo(309f, 186.16f)
            curveTo(302.2f, 182.96f, 281.17f, 157.16f, 271.5f, 144.66f)
            curveTo(273f, 142.16f, 300f, 135.16f, 308f, 149.66f)
            curveTo(314.4f, 161.26f, 311.33f, 178.83f, 309f, 186.16f)
            close()
        }
        path(fill = SolidColor(teresMajor)) {
            moveTo(268.5f, 152.66f)
            curveTo(274.5f, 154.26f, 285.67f, 171.33f, 290.5f, 179.66f)
            curveTo(284.1f, 186.86f, 263.5f, 187.66f, 254f, 187.16f)
            curveTo(256.33f, 175f, 262.5f, 151.06f, 268.5f, 152.66f)
            close()
        }
        path(fill = SolidColor(forearmBack)) {
            moveTo(317f, 280.27f)
            curveTo(312.2f, 280.67f, 306.33f, 278.1f, 304f, 276.77f)
            curveTo(311.2f, 299.57f, 335.67f, 327.6f, 347f, 338.77f)
            lineTo(340.5f, 326.27f)
            curveTo(334.67f, 310.77f, 321.8f, 279.87f, 317f, 280.27f)
            close()
        }
        path(fill = SolidColor(forearmBack)) {
            moveTo(330.5f, 269.77f)
            curveTo(332.67f, 287.43f, 340.5f, 326.27f, 354.5f, 340.27f)
            curveTo(353.5f, 329.27f, 347.3f, 299.77f, 330.5f, 269.77f)
            close()
        }
        path(fill = SolidColor(forearmBack)) {
            moveTo(362f, 353.77f)
            curveTo(362f, 346.17f, 345.67f, 292.27f, 337.5f, 266.27f)
            curveTo(338.5f, 266.27f, 366f, 339.77f, 368.5f, 347.77f)
            curveTo(370.5f, 354.17f, 365f, 354.43f, 362f, 353.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(259f, 275.27f)
            curveTo(254.6f, 279.67f, 250.83f, 293.77f, 249.5f, 300.27f)
            curveTo(249.5f, 303.47f, 255.83f, 306.93f, 259f, 308.27f)
            verticalLineTo(275.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(231.5f, 327.77f)
            curveTo(240.17f, 328.6f, 259.6f, 333.77f, 268f, 347.77f)
            curveTo(267.17f, 329.1f, 258.7f, 298.97f, 231.5f, 327.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(308.5f, 263.77f)
            curveTo(308.5f, 264.97f, 317.83f, 275.27f, 322.5f, 280.27f)
            curveTo(323.5f, 276.1f, 324f, 266.17f, 318f, 259.77f)
            curveTo(310.5f, 251.77f, 308.5f, 262.27f, 308.5f, 263.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(374f, 396.27f)
            curveTo(365.6f, 383.87f, 365.5f, 365.77f, 366.5f, 358.27f)
            curveTo(369.17f, 356.93f, 375.3f, 354.97f, 378.5f, 357.77f)
            curveTo(381.7f, 360.57f, 389.5f, 373.27f, 393f, 379.27f)
            curveTo(393.83f, 380.1f, 394.7f, 382.27f, 391.5f, 384.27f)
            curveTo(388.3f, 386.27f, 386.17f, 388.77f, 385.5f, 389.77f)
            curveTo(381.9f, 396.17f, 376.33f, 396.77f, 374f, 396.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(378f, 401.27f)
            curveTo(375.6f, 397.67f, 375f, 400.1f, 375f, 401.77f)
            curveTo(376.17f, 404.93f, 378.9f, 412.07f, 380.5f, 415.27f)
            curveTo(382.1f, 418.47f, 383.17f, 415.93f, 383.5f, 414.27f)
            curveTo(382.67f, 411.43f, 380.4f, 404.87f, 378f, 401.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(387f, 398.77f)
            curveTo(384.2f, 393.17f, 383.17f, 398.1f, 383f, 401.27f)
            lineTo(391.5f, 421.27f)
            curveTo(395.5f, 424.87f, 395.5f, 421.1f, 395f, 418.77f)
            curveTo(393.5f, 414.43f, 389.8f, 404.37f, 387f, 398.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(393f, 395.27f)
            curveTo(389.4f, 389.27f, 388.5f, 394.43f, 388.5f, 397.77f)
            lineTo(400f, 423.27f)
            curveTo(403.6f, 427.67f, 403.5f, 421.43f, 403f, 417.77f)
            curveTo(401.17f, 412.77f, 396.6f, 401.27f, 393f, 395.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(399f, 387.77f)
            curveTo(396.6f, 382.57f, 394.67f, 386.93f, 394f, 389.77f)
            lineTo(404.5f, 413.77f)
            curveTo(408.1f, 417.77f, 408.33f, 412.1f, 408f, 408.77f)
            curveTo(406f, 403.93f, 401.4f, 392.97f, 399f, 387.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(412f, 380.27f)
            curveTo(404.4f, 379.87f, 391.5f, 369.43f, 386f, 364.27f)
            curveTo(385.33f, 362.93f, 384.4f, 360.17f, 386f, 359.77f)
            curveTo(387.6f, 359.37f, 389.67f, 360.6f, 390.5f, 361.27f)
            lineTo(403.5f, 369.27f)
            lineTo(415.5f, 376.27f)
            curveTo(417.5f, 377.77f, 419.6f, 380.67f, 412f, 380.27f)
            close()
        }
        path(fill = SolidColor(triceps)) {
            moveTo(307f, 238f)
            curveTo(313f, 199.2f, 301.83f, 184.5f, 295.5f, 182f)
            curveTo(296.3f, 184.8f, 294.5f, 196.17f, 293.5f, 201.5f)
            curveTo(292.67f, 207f, 291f, 220.2f, 291f, 229f)
            curveTo(291f, 240f, 309.5f, 266.5f, 307f, 260f)
            curveTo(305f, 254.8f, 306.17f, 243.17f, 307f, 238f)
            close()
        }
        path(fill = SolidColor(triceps)) {
            moveTo(317.5f, 247f)
            curveTo(317.5f, 244.2f, 314.83f, 226.83f, 313.5f, 218.5f)
            lineTo(312f, 247f)
            curveTo(314.4f, 260.2f, 316.67f, 252.5f, 317.5f, 247f)
            close()
        }
    }.build()
}