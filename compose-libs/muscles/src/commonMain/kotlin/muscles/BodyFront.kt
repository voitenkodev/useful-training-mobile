package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun bodyFront(
    outlineColor: Color = Colors.outline,
    biceps: Color = Colors.defaultFront,
    forearm: Color = Colors.defaultFront,

    lateralDeltoid: Color = Colors.defaultFront,
    anteriorDeltoid: Color = Colors.defaultFront,

    rectusAbdominis: Color = Colors.defaultFront,
    obliquesAbdominis: Color = Colors.defaultFront,

    pectoralisMajorAbdominal: Color = Colors.defaultFront,
    pectoralisMajorClavicular: Color = Colors.defaultFront,
    pectoralisMajorSternocostal: Color = Colors.defaultFront,

    other: Color = Colors.defaultFront,

    backgroundFront: Color = Colors.backgroundFront
): ImageVector {
    return ImageVector.Builder(
        name = "Bodyfront",
        defaultWidth = 411.dp,
        defaultHeight = 431.dp,
        viewportWidth = 411f,
        viewportHeight = 431f
    ).apply {
        path(
            stroke = SolidColor(outlineColor),
            fill = SolidColor(backgroundFront),
            strokeLineWidth = 1f
        ) {
            moveTo(262.5f, 330.44f)
            lineTo(257.19f, 300.71f)
            lineTo(257.69f, 263.71f)
            curveTo(272.69f, 243.71f, 274.69f, 214.71f, 275.19f, 222.71f)
            curveTo(275.59f, 229.11f, 286.02f, 252.04f, 291.19f, 262.71f)
            curveTo(290.79f, 273.11f, 300.69f, 293.38f, 305.69f, 302.21f)
            curveTo(314.69f, 314.04f, 334.09f, 339.11f, 339.69f, 344.71f)
            curveTo(346.69f, 351.71f, 354.69f, 368.71f, 355.69f, 375.71f)
            curveTo(356.69f, 382.71f, 361.69f, 394.71f, 362.19f, 397.71f)
            curveTo(362.69f, 400.71f, 371.69f, 418.21f, 374.19f, 421.21f)
            curveTo(376.19f, 423.61f, 377.69f, 421.54f, 378.19f, 420.21f)
            curveTo(376.52f, 415.71f, 373.09f, 406.21f, 372.69f, 404.21f)
            curveTo(372.29f, 402.21f, 373.19f, 402.71f, 373.69f, 403.21f)
            lineTo(383.69f, 426.21f)
            curveTo(387.69f, 430.21f, 389.69f, 426.54f, 390.19f, 424.21f)
            curveTo(386.35f, 415.71f, 378.59f, 398.41f, 378.19f, 397.21f)
            curveTo(377.79f, 396.01f, 378.35f, 396.38f, 378.69f, 396.71f)
            lineTo(392.19f, 426.71f)
            curveTo(397.39f, 430.31f, 398.35f, 425.21f, 398.19f, 422.21f)
            lineTo(384.19f, 391.21f)
            curveTo(387.69f, 399.71f, 395.59f, 417.11f, 399.19f, 418.71f)
            curveTo(402.79f, 420.31f, 403.02f, 416.71f, 402.69f, 414.71f)
            lineTo(388.19f, 374.21f)
            curveTo(391.85f, 376.71f, 400.49f, 381.71f, 405.69f, 381.71f)
            curveTo(410.89f, 381.71f, 410.52f, 377.71f, 409.69f, 375.71f)
            curveTo(405.85f, 374.38f, 396.69f, 370.01f, 390.69f, 363.21f)
            curveTo(384.69f, 356.41f, 376.52f, 354.38f, 373.19f, 354.21f)
            curveTo(363.19f, 345.41f, 354.35f, 323.54f, 351.19f, 313.71f)
            curveTo(347.99f, 292.11f, 328.19f, 261.71f, 318.69f, 249.21f)
            curveTo(321.49f, 231.21f, 312.52f, 203.38f, 307.69f, 191.71f)
            verticalLineTo(156.71f)
            curveTo(301.19f, 123.71f, 259.69f, 124.21f, 257.19f, 124.21f)
            curveTo(254.69f, 124.21f, 238.19f, 112.71f, 233.19f, 107.21f)
            curveTo(229.19f, 102.81f, 229.52f, 97.38f, 230.19f, 95.21f)
            lineTo(234.19f, 89.71f)
            lineTo(235.69f, 82.21f)
            lineTo(236.19f, 74.71f)
            curveTo(237.39f, 75.11f, 238.02f, 74.21f, 238.19f, 73.71f)
            curveTo(239.52f, 69.54f, 242.49f, 60.61f, 243.69f, 58.21f)
            curveTo(244.89f, 55.81f, 240.85f, 53.54f, 238.69f, 52.71f)
            curveTo(243.19f, 15.71f, 220.19f, -6.29f, 194.19f, 3.21f)
            curveTo(173.39f, 10.81f, 170.85f, 40.04f, 172.19f, 53.71f)
            curveTo(166.99f, 54.91f, 166.35f, 56.54f, 166.69f, 57.21f)
            curveTo(167.52f, 59.71f, 169.59f, 65.91f, 171.19f, 70.71f)
            curveTo(172.79f, 75.51f, 174.52f, 76.04f, 175.19f, 75.71f)
            lineTo(176.69f, 89.71f)
            lineTo(182.19f, 95.21f)
            curveTo(183.02f, 97.54f, 183.79f, 103.21f, 180.19f, 107.21f)
            curveTo(176.59f, 111.21f, 160.69f, 120.21f, 153.19f, 124.21f)
            curveTo(116.39f, 126.21f, 104.52f, 146.38f, 103.19f, 156.21f)
            verticalLineTo(191.71f)
            curveTo(96.39f, 198.91f, 93.02f, 234.04f, 92.19f, 250.71f)
            curveTo(90.35f, 253.21f, 84.79f, 260.71f, 77.19f, 270.71f)
            curveTo(67.69f, 283.21f, 65.19f, 296.21f, 59.19f, 316.21f)
            curveTo(54.39f, 332.21f, 42.19f, 349.21f, 36.69f, 355.71f)
            curveTo(33.49f, 355.31f, 30.02f, 356.21f, 28.69f, 356.71f)
            lineTo(1.19f, 375.71f)
            curveTo(0.69f, 378.21f, 0.89f, 383.01f, 5.69f, 382.21f)
            curveTo(11.69f, 381.21f, 21.69f, 374.21f, 23.19f, 373.71f)
            curveTo(24.39f, 373.31f, 24.02f, 373.88f, 23.69f, 374.21f)
            lineTo(19.69f, 384.71f)
            curveTo(16.69f, 392.21f, 10.29f, 408.61f, 8.69f, 414.21f)
            curveTo(7.09f, 419.81f, 10.69f, 419.21f, 12.69f, 418.21f)
            lineTo(24.19f, 395.21f)
            curveTo(25.79f, 393.21f, 26.19f, 394.71f, 26.19f, 395.71f)
            curveTo(22.52f, 403.21f, 14.69f, 419.31f, 12.69f, 423.71f)
            curveTo(10.69f, 428.11f, 15.52f, 428.21f, 18.19f, 427.71f)
            lineTo(30.19f, 401.21f)
            curveTo(32.59f, 398.41f, 32.19f, 400.71f, 31.69f, 402.21f)
            curveTo(28.85f, 409.21f, 22.89f, 423.51f, 21.69f, 424.71f)
            curveTo(20.19f, 426.21f, 23.19f, 431.71f, 26.19f, 428.71f)
            curveTo(28.59f, 426.31f, 34.19f, 411.71f, 36.69f, 404.71f)
            curveTo(38.29f, 402.71f, 38.69f, 403.88f, 38.69f, 404.71f)
            curveTo(38.85f, 405.04f, 38.29f, 407.71f, 34.69f, 415.71f)
            curveTo(31.09f, 423.71f, 35.52f, 422.71f, 38.19f, 421.21f)
            curveTo(48.59f, 407.21f, 53.52f, 384.71f, 54.69f, 375.21f)
            lineTo(61.19f, 357.71f)
            curveTo(61.69f, 356.38f, 68.19f, 347.41f, 90.19f, 322.21f)
            curveTo(112.19f, 297.01f, 119.02f, 271.38f, 119.69f, 261.71f)
            curveTo(126.49f, 256.51f, 132.85f, 234.21f, 135.19f, 223.71f)
            curveTo(134.79f, 226.91f, 147.69f, 252.04f, 154.19f, 264.21f)
            curveTo(154.19f, 270.71f, 154.19f, 285.91f, 154.19f, 294.71f)
            curveTo(154.19f, 303.51f, 152.5f, 327.78f, 150f, 333.94f)
            curveTo(150f, 333.94f, 164f, 340.44f, 173.5f, 348.44f)
            curveTo(185.97f, 358.95f, 195.72f, 373.71f, 195.72f, 373.71f)
            horizontalLineTo(218f)
            curveTo(235.97f, 348.44f, 237.31f, 351.74f, 262.5f, 330.44f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(174.69f, 291.71f)
            curveTo(174.29f, 320.11f, 185.52f, 347.54f, 191.19f, 357.71f)
            curveTo(196.39f, 361.71f, 199.35f, 357.71f, 200.19f, 355.21f)
            lineTo(198.69f, 302.71f)
            curveTo(193.89f, 289.51f, 180.69f, 289.88f, 174.69f, 291.71f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(172.69f, 281.21f)
            verticalLineTo(268.21f)
            curveTo(189.89f, 257.01f, 198.19f, 262.54f, 200.19f, 266.71f)
            curveTo(200.69f, 274.21f, 201.39f, 288.91f, 200.19f, 287.71f)
            curveTo(198.99f, 286.51f, 192.02f, 284.54f, 188.69f, 283.71f)
            curveTo(178.29f, 284.11f, 173.69f, 282.21f, 172.69f, 281.21f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(173.69f, 256.71f)
            lineTo(172.69f, 245.71f)
            curveTo(181.09f, 230.11f, 195.19f, 230.88f, 201.19f, 233.21f)
            curveTo(201.19f, 238.41f, 199.52f, 249.71f, 198.69f, 254.71f)
            curveTo(184.29f, 253.11f, 176.02f, 255.38f, 173.69f, 256.71f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(188.69f, 209.21f)
            curveTo(173.89f, 212.01f, 171.85f, 226.38f, 172.69f, 233.21f)
            curveTo(182.29f, 224.81f, 195.02f, 223.71f, 200.19f, 224.21f)
            curveTo(201.02f, 219.88f, 202.19f, 210.81f, 200.19f, 209.21f)
            curveTo(198.19f, 207.61f, 191.69f, 208.54f, 188.69f, 209.21f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(156.69f, 271.21f)
            curveTo(154.69f, 276.01f, 155.85f, 310.38f, 156.69f, 327.71f)
            curveTo(157.89f, 330.11f, 164.85f, 332.38f, 168.19f, 333.21f)
            lineTo(169.69f, 327.71f)
            lineTo(166.19f, 278.71f)
            curveTo(163.85f, 273.71f, 158.69f, 266.41f, 156.69f, 271.21f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(162.69f, 251.71f)
            lineTo(162.19f, 262.71f)
            curveTo(158.99f, 264.31f, 153.19f, 258.04f, 150.69f, 254.71f)
            curveTo(149.02f, 247.88f, 146.29f, 235.21f, 148.69f, 239.21f)
            curveTo(151.09f, 243.21f, 159.02f, 249.21f, 162.69f, 251.71f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(159.19f, 241.71f)
            lineTo(149.69f, 229.21f)
            verticalLineTo(224.71f)
            curveTo(152.09f, 223.91f, 158.69f, 228.71f, 161.69f, 231.21f)
            curveTo(161.69f, 233.38f, 161.59f, 238.31f, 161.19f, 240.71f)
            curveTo(160.79f, 243.11f, 159.69f, 242.38f, 159.19f, 241.71f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(159.19f, 224.71f)
            lineTo(150.19f, 214.21f)
            curveTo(149.19f, 211.21f, 151.69f, 211.71f, 154.69f, 211.71f)
            curveTo(157.09f, 211.71f, 161.35f, 214.04f, 163.19f, 215.21f)
            curveTo(163.85f, 216.54f, 165.09f, 220.01f, 164.69f, 223.21f)
            curveTo(164.29f, 226.41f, 160.85f, 225.54f, 159.19f, 224.71f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(163.69f, 210.21f)
            lineTo(149.69f, 200.21f)
            curveTo(148.69f, 196.21f, 152.69f, 197.21f, 155.69f, 197.71f)
            curveTo(158.09f, 198.11f, 164.35f, 200.54f, 167.19f, 201.71f)
            curveTo(168.19f, 201.88f, 169.89f, 203.11f, 168.69f, 206.71f)
            curveTo(167.49f, 210.31f, 164.85f, 210.54f, 163.69f, 210.21f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(237.29f, 292.2f)
            curveTo(237.69f, 320.6f, 226.46f, 348.03f, 220.79f, 358.2f)
            curveTo(215.59f, 362.2f, 212.62f, 358.2f, 211.79f, 355.7f)
            lineTo(213.29f, 303.2f)
            curveTo(218.09f, 290f, 231.29f, 290.36f, 237.29f, 292.2f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(239.29f, 281.7f)
            verticalLineTo(268.7f)
            curveTo(222.09f, 257.5f, 213.79f, 263.03f, 211.79f, 267.2f)
            curveTo(211.29f, 274.7f, 210.59f, 289.4f, 211.79f, 288.2f)
            curveTo(212.99f, 287f, 219.96f, 285.03f, 223.29f, 284.2f)
            curveTo(233.69f, 284.6f, 238.29f, 282.7f, 239.29f, 281.7f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(238.29f, 257.2f)
            lineTo(239.29f, 246.2f)
            curveTo(230.89f, 230.6f, 216.79f, 231.36f, 210.79f, 233.7f)
            curveTo(210.79f, 238.9f, 212.46f, 250.2f, 213.29f, 255.2f)
            curveTo(227.69f, 253.6f, 235.96f, 255.86f, 238.29f, 257.2f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(223.29f, 209.7f)
            curveTo(238.09f, 212.5f, 240.12f, 226.86f, 239.29f, 233.7f)
            curveTo(229.69f, 225.3f, 216.96f, 224.2f, 211.79f, 224.7f)
            curveTo(210.96f, 220.36f, 209.79f, 211.3f, 211.79f, 209.7f)
            curveTo(213.79f, 208.1f, 220.29f, 209.03f, 223.29f, 209.7f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(255.29f, 271.7f)
            curveTo(257.29f, 276.5f, 256.12f, 310.86f, 255.29f, 328.2f)
            curveTo(254.09f, 330.6f, 247.12f, 332.86f, 243.79f, 333.7f)
            lineTo(242.29f, 328.2f)
            lineTo(245.79f, 279.2f)
            curveTo(248.12f, 274.2f, 253.29f, 266.9f, 255.29f, 271.7f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(249.29f, 252.2f)
            lineTo(249.79f, 263.2f)
            curveTo(252.99f, 264.8f, 258.79f, 258.53f, 261.29f, 255.2f)
            curveTo(262.96f, 248.36f, 265.69f, 235.7f, 263.29f, 239.7f)
            curveTo(260.89f, 243.7f, 252.96f, 249.7f, 249.29f, 252.2f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(252.79f, 242.2f)
            lineTo(262.29f, 229.7f)
            verticalLineTo(225.2f)
            curveTo(259.89f, 224.4f, 253.29f, 229.2f, 250.29f, 231.7f)
            curveTo(250.29f, 233.86f, 250.39f, 238.8f, 250.79f, 241.2f)
            curveTo(251.19f, 243.6f, 252.29f, 242.86f, 252.79f, 242.2f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(252.79f, 225.2f)
            lineTo(261.79f, 214.7f)
            curveTo(262.79f, 211.7f, 260.29f, 212.2f, 257.29f, 212.2f)
            curveTo(254.89f, 212.2f, 250.62f, 214.53f, 248.79f, 215.7f)
            curveTo(248.12f, 217.03f, 246.89f, 220.5f, 247.29f, 223.7f)
            curveTo(247.69f, 226.9f, 251.12f, 226.03f, 252.79f, 225.2f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(248.29f, 210.7f)
            lineTo(262.29f, 200.7f)
            curveTo(263.29f, 196.7f, 259.29f, 197.7f, 256.29f, 198.2f)
            curveTo(253.89f, 198.6f, 247.62f, 201.03f, 244.79f, 202.2f)
            curveTo(243.79f, 202.36f, 242.09f, 203.6f, 243.29f, 207.2f)
            curveTo(244.49f, 210.8f, 247.12f, 211.03f, 248.29f, 210.7f)
            close()
        }
        path(fill = SolidColor(lateralDeltoid)) {
            moveTo(137.69f, 132.71f)
            curveTo(108.49f, 130.71f, 105.52f, 160.21f, 107.69f, 175.21f)
            lineTo(108.69f, 176.71f)
            curveTo(109.49f, 163.51f, 128.35f, 141.88f, 137.69f, 132.71f)
            close()
        }
        path(fill = SolidColor(anteriorDeltoid)) {
            moveTo(113.19f, 180.71f)
            curveTo(116.69f, 167.54f, 129.69f, 140.11f, 153.69f, 135.71f)
            curveTo(151.35f, 148.88f, 139.99f, 176.31f, 113.19f, 180.71f)
            close()
        }
        path(fill = SolidColor(lateralDeltoid)) {
            moveTo(273.69f, 132.81f)
            curveTo(302.89f, 130.81f, 305.85f, 160.31f, 303.69f, 175.31f)
            lineTo(302.69f, 176.81f)
            curveTo(301.89f, 163.61f, 283.02f, 141.97f, 273.69f, 132.81f)
            close()
        }
        path(fill = SolidColor(anteriorDeltoid)) {
            moveTo(298.19f, 180.81f)
            curveTo(294.69f, 167.64f, 281.69f, 140.21f, 257.69f, 135.81f)
            curveTo(260.02f, 148.97f, 271.39f, 176.41f, 298.19f, 180.81f)
            close()
        }
        path(fill = SolidColor(biceps)) {
            moveTo(311.19f, 251.21f)
            curveTo(276.79f, 226.01f, 277.19f, 196.38f, 281.69f, 184.71f)
            curveTo(304.69f, 181.71f, 313.19f, 205.21f, 313.19f, 214.21f)
            curveTo(313.19f, 221.41f, 314.19f, 232.21f, 314.69f, 236.71f)
            curveTo(317.49f, 248.71f, 313.52f, 251.38f, 311.19f, 251.21f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(346.69f, 311.71f)
            curveTo(336.29f, 273.31f, 321.02f, 259.04f, 314.69f, 256.71f)
            curveTo(313.89f, 261.11f, 315.69f, 270.54f, 316.69f, 274.71f)
            curveTo(320.85f, 283.38f, 330.09f, 301.31f, 333.69f, 303.71f)
            curveTo(338.19f, 306.71f, 358.19f, 343.21f, 359.69f, 346.21f)
            curveTo(360.89f, 348.61f, 361.19f, 347.21f, 361.19f, 346.21f)
            lineTo(346.69f, 311.71f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(299.69f, 281.71f)
            verticalLineTo(268.71f)
            curveTo(300.49f, 266.31f, 302.35f, 267.38f, 303.19f, 268.21f)
            curveTo(309.19f, 274.71f, 319.19f, 286.71f, 321.69f, 291.71f)
            curveTo(323.69f, 295.71f, 321.19f, 295.38f, 319.69f, 294.71f)
            curveTo(314.85f, 291.54f, 304.59f, 285.11f, 302.19f, 284.71f)
            curveTo(299.79f, 284.31f, 299.52f, 282.54f, 299.69f, 281.71f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(355.69f, 347.71f)
            curveTo(353.29f, 344.51f, 328.02f, 313.04f, 315.69f, 297.71f)
            curveTo(315.02f, 296.71f, 315.69f, 296.01f, 323.69f, 301.21f)
            curveTo(331.69f, 306.41f, 348.35f, 332.38f, 355.69f, 344.71f)
            curveTo(356.69f, 347.04f, 358.09f, 350.91f, 355.69f, 347.71f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(351.69f, 346.21f)
            curveTo(333.69f, 331.81f, 314.52f, 306.21f, 307.19f, 295.21f)
            curveTo(305.19f, 294.01f, 306.35f, 297.38f, 307.19f, 299.21f)
            curveTo(319.69f, 323.21f, 346.69f, 344.71f, 350.19f, 346.71f)
            curveTo(352.99f, 348.31f, 352.35f, 347.04f, 351.69f, 346.21f)
            close()
        }
        path(fill = SolidColor(biceps)) {
            moveTo(101.69f, 250.47f)
            curveTo(136.09f, 225.27f, 135.69f, 195.64f, 131.19f, 183.97f)
            curveTo(108.19f, 180.97f, 99.69f, 204.47f, 99.69f, 213.47f)
            curveTo(99.69f, 220.67f, 98.69f, 231.47f, 98.19f, 235.97f)
            curveTo(95.39f, 247.97f, 99.35f, 250.64f, 101.69f, 250.47f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(66.19f, 310.97f)
            curveTo(76.59f, 272.57f, 91.85f, 258.3f, 98.19f, 255.97f)
            curveTo(98.99f, 260.37f, 97.19f, 269.8f, 96.19f, 273.97f)
            curveTo(92.02f, 282.64f, 82.79f, 300.57f, 79.19f, 302.97f)
            curveTo(74.69f, 305.97f, 54.69f, 342.47f, 53.19f, 345.47f)
            curveTo(51.99f, 347.87f, 51.69f, 346.47f, 51.69f, 345.47f)
            lineTo(66.19f, 310.97f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(113.19f, 280.97f)
            verticalLineTo(267.97f)
            curveTo(112.39f, 265.57f, 110.52f, 266.64f, 109.69f, 267.47f)
            curveTo(103.69f, 273.97f, 93.69f, 285.97f, 91.19f, 290.97f)
            curveTo(89.19f, 294.97f, 91.69f, 294.64f, 93.19f, 293.97f)
            curveTo(98.02f, 290.8f, 108.29f, 284.37f, 110.69f, 283.97f)
            curveTo(113.09f, 283.57f, 113.35f, 281.8f, 113.19f, 280.97f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(57.19f, 346.97f)
            curveTo(59.59f, 343.77f, 84.85f, 312.3f, 97.19f, 296.97f)
            curveTo(97.85f, 295.97f, 97.19f, 295.27f, 89.19f, 300.47f)
            curveTo(81.19f, 305.67f, 64.52f, 331.64f, 57.19f, 343.97f)
            curveTo(56.19f, 346.3f, 54.79f, 350.17f, 57.19f, 346.97f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(61.19f, 345.47f)
            curveTo(79.19f, 331.07f, 98.35f, 305.47f, 105.69f, 294.47f)
            curveTo(107.69f, 293.27f, 106.52f, 296.64f, 105.69f, 298.47f)
            curveTo(93.19f, 322.47f, 66.19f, 343.97f, 62.69f, 345.97f)
            curveTo(59.89f, 347.57f, 60.52f, 346.3f, 61.19f, 345.47f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(40.19f, 396.21f)
            lineTo(28.19f, 383.21f)
            curveTo(26.59f, 382.01f, 26.52f, 380.04f, 26.69f, 379.21f)
            lineTo(33.69f, 368.21f)
            curveTo(39.52f, 361.21f, 51.79f, 349.81f, 54.19f, 360.21f)
            curveTo(57.19f, 373.21f, 49.19f, 388.21f, 47.19f, 394.21f)
            curveTo(45.59f, 399.01f, 41.85f, 397.54f, 40.19f, 396.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(35.69f, 362.21f)
            curveTo(18.09f, 376.21f, 6.69f, 378.71f, 3.19f, 378.21f)
            curveTo(2.79f, 377.01f, 3.69f, 376.38f, 4.19f, 376.21f)
            lineTo(31.69f, 358.21f)
            curveTo(37.69f, 356.61f, 36.85f, 360.21f, 35.69f, 362.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(11.69f, 410.21f)
            lineTo(22.69f, 386.21f)
            curveTo(24.02f, 385.88f, 26.69f, 385.81f, 26.69f, 388.21f)
            curveTo(26.69f, 391.21f, 16.69f, 408.21f, 14.19f, 413.71f)
            curveTo(12.19f, 418.11f, 11.69f, 413.21f, 11.69f, 410.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(30.19f, 398.71f)
            curveTo(31.79f, 392.71f, 29.19f, 393.54f, 27.69f, 394.71f)
            curveTo(26.92f, 395.21f, 17.69f, 418.21f, 16.69f, 421.71f)
            curveTo(15.89f, 424.51f, 18.35f, 424.88f, 19.69f, 424.71f)
            curveTo(22.52f, 418.54f, 28.59f, 404.71f, 30.19f, 398.71f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.69f, 403.71f)
            curveTo(37.89f, 400.91f, 35.52f, 399.54f, 34.19f, 399.21f)
            lineTo(32.69f, 400.21f)
            curveTo(30.19f, 405.71f, 25.09f, 417.51f, 24.69f, 420.71f)
            curveTo(24.29f, 423.91f, 26.85f, 423.71f, 28.19f, 423.21f)
            curveTo(30.52f, 417.88f, 35.49f, 406.51f, 36.69f, 403.71f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.69f, 413.21f)
            lineTo(42.69f, 401.71f)
            curveTo(45.49f, 400.11f, 45.52f, 403.38f, 45.19f, 405.21f)
            curveTo(44.35f, 407.38f, 42.09f, 412.61f, 39.69f, 416.21f)
            curveTo(37.29f, 419.81f, 36.69f, 415.71f, 36.69f, 413.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(129.19f, 230.71f)
            curveTo(123.99f, 240.71f, 109.69f, 253.88f, 103.19f, 259.21f)
            curveTo(103.19f, 262.01f, 105.52f, 261.38f, 106.69f, 260.71f)
            curveTo(113.02f, 256.54f, 126.39f, 246.41f, 129.19f, 239.21f)
            curveTo(131.99f, 232.01f, 130.35f, 230.54f, 129.19f, 230.71f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(372.35f, 396.9f)
            lineTo(384.35f, 383.9f)
            curveTo(385.95f, 382.7f, 386.02f, 380.73f, 385.85f, 379.9f)
            lineTo(378.85f, 368.9f)
            curveTo(373.02f, 361.9f, 360.75f, 350.5f, 358.35f, 360.9f)
            curveTo(355.35f, 373.9f, 363.35f, 388.9f, 365.35f, 394.9f)
            curveTo(366.95f, 399.7f, 370.69f, 398.23f, 372.35f, 396.9f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(376.85f, 362.9f)
            curveTo(394.45f, 376.9f, 405.85f, 379.4f, 409.35f, 378.9f)
            curveTo(409.75f, 377.7f, 408.85f, 377.06f, 408.35f, 376.9f)
            lineTo(380.85f, 358.9f)
            curveTo(374.85f, 357.3f, 375.69f, 360.9f, 376.85f, 362.9f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(400.85f, 410.9f)
            lineTo(389.85f, 386.9f)
            curveTo(388.52f, 386.56f, 385.85f, 386.5f, 385.85f, 388.9f)
            curveTo(385.85f, 391.9f, 395.85f, 408.9f, 398.35f, 414.4f)
            curveTo(400.35f, 418.8f, 400.85f, 413.9f, 400.85f, 410.9f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(382.35f, 399.4f)
            curveTo(380.75f, 393.4f, 383.35f, 394.23f, 384.85f, 395.4f)
            curveTo(385.62f, 395.9f, 394.85f, 418.9f, 395.85f, 422.4f)
            curveTo(396.65f, 425.2f, 394.19f, 425.56f, 392.85f, 425.4f)
            curveTo(390.02f, 419.23f, 383.95f, 405.4f, 382.35f, 399.4f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(375.85f, 404.4f)
            curveTo(374.65f, 401.6f, 377.02f, 400.23f, 378.35f, 399.9f)
            lineTo(379.85f, 400.9f)
            curveTo(382.35f, 406.4f, 387.45f, 418.2f, 387.85f, 421.4f)
            curveTo(388.25f, 424.6f, 385.69f, 424.4f, 384.35f, 423.9f)
            curveTo(382.02f, 418.56f, 377.05f, 407.2f, 375.85f, 404.4f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(375.85f, 413.9f)
            lineTo(369.85f, 402.4f)
            curveTo(367.05f, 400.8f, 367.02f, 404.06f, 367.35f, 405.9f)
            curveTo(368.19f, 408.06f, 370.45f, 413.3f, 372.85f, 416.9f)
            curveTo(375.25f, 420.5f, 375.85f, 416.4f, 375.85f, 413.9f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(308.19f, 259.21f)
            curveTo(301.39f, 255.61f, 288.69f, 239.04f, 283.19f, 231.21f)
            curveTo(279.99f, 228.01f, 280.52f, 233.21f, 281.19f, 236.21f)
            curveTo(283.99f, 243.81f, 298.69f, 255.71f, 305.69f, 260.71f)
            curveTo(308.49f, 261.91f, 308.52f, 260.21f, 308.19f, 259.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(139.19f, 222.21f)
            lineTo(137.69f, 195.71f)
            curveTo(137.19f, 193.38f, 137.09f, 190.11f, 140.69f, 195.71f)
            curveTo(144.29f, 201.31f, 146.19f, 211.71f, 146.69f, 216.21f)
            curveTo(146.69f, 223.21f, 146.19f, 236.71f, 144.19f, 234.71f)
            curveTo(142.19f, 232.71f, 140.02f, 225.54f, 139.19f, 222.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(200.19f, 143.21f)
            lineTo(184.69f, 112.71f)
            curveTo(184.29f, 101.51f, 185.19f, 98.71f, 185.69f, 98.71f)
            curveTo(188.49f, 101.51f, 197.85f, 122.21f, 202.19f, 132.21f)
            curveTo(202.59f, 140.21f, 201.02f, 142.88f, 200.19f, 143.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(184.19f, 124.71f)
            lineTo(178.69f, 132.21f)
            curveTo(183.09f, 135.81f, 186.52f, 134.38f, 187.69f, 133.21f)
            lineTo(184.19f, 124.71f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(179.69f, 119.21f)
            lineTo(167.19f, 131.21f)
            curveTo(163.69f, 131.21f, 155.99f, 131.11f, 153.19f, 130.71f)
            curveTo(150.39f, 130.31f, 151.35f, 128.88f, 152.19f, 128.21f)
            curveTo(158.19f, 124.38f, 171.59f, 116.31f, 177.19f, 114.71f)
            curveTo(182.79f, 113.11f, 181.19f, 117.04f, 179.69f, 119.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(206.19f, 129.71f)
            lineTo(198.69f, 105.71f)
            horizontalLineTo(214.69f)
            lineTo(206.19f, 129.71f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(209.19f, 132.21f)
            curveTo(210.39f, 128.21f, 220.83f, 108.21f, 225.9f, 98.71f)
            curveTo(227.27f, 97.51f, 226.33f, 108.88f, 225.69f, 114.71f)
            lineTo(209.69f, 143.21f)
            curveTo(209.02f, 141.21f, 207.99f, 136.21f, 209.19f, 132.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(221.69f, 133.21f)
            lineTo(226.19f, 124.71f)
            curveTo(229.39f, 127.11f, 230.52f, 131.38f, 230.69f, 133.21f)
            curveTo(229.09f, 135.21f, 224.02f, 134.04f, 221.69f, 133.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(241.69f, 130.21f)
            lineTo(228.69f, 118.21f)
            curveTo(227.49f, 113.01f, 232.52f, 114.38f, 235.19f, 115.71f)
            curveTo(243.52f, 119.54f, 259.84f, 127.71f, 258.46f, 129.71f)
            curveTo(257.09f, 131.71f, 246.71f, 130.88f, 241.69f, 130.21f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(265.69f, 232.71f)
            verticalLineTo(211.71f)
            lineTo(274.69f, 191.71f)
            lineTo(274.19f, 213.21f)
            curveTo(273.85f, 216.71f, 272.59f, 225.41f, 270.19f, 232.21f)
            curveTo(267.79f, 239.01f, 266.19f, 235.38f, 265.69f, 232.71f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorSternocostal)) {
            moveTo(202.19f, 195.94f)
            curveTo(185.5f, 206.44f, 164f, 179.44f, 143f, 176.44f)
            curveTo(168.09f, 147.77f, 191.32f, 157.57f, 202.05f, 162.09f)
            lineTo(202.19f, 162.15f)
            verticalLineTo(195.94f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorAbdominal)) {
            moveTo(142.5f, 177.94f)
            curveTo(146f, 196.94f, 172.5f, 203.44f, 186f, 198.44f)
            curveTo(167.5f, 192.44f, 158f, 181.94f, 142.5f, 177.94f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorClavicular)) {
            moveTo(202.19f, 150.65f)
            curveTo(168.59f, 121.45f, 149.33f, 150.44f, 142f, 172.94f)
            verticalLineTo(174.94f)
            curveTo(165.6f, 145.34f, 190.35f, 155.49f, 202.19f, 160.15f)
            verticalLineTo(150.65f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorSternocostal)) {
            moveTo(209f, 195.94f)
            curveTo(225.69f, 206.44f, 247.19f, 179.44f, 268.19f, 176.44f)
            curveTo(243.09f, 147.77f, 219.87f, 157.57f, 209.14f, 162.09f)
            lineTo(209f, 162.15f)
            verticalLineTo(195.94f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorAbdominal)) {
            moveTo(268.69f, 177.94f)
            curveTo(265.19f, 196.94f, 238.69f, 203.44f, 225.19f, 198.44f)
            curveTo(243.69f, 192.44f, 253.19f, 181.94f, 268.69f, 177.94f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorClavicular)) {
            moveTo(209f, 150.65f)
            curveTo(242.6f, 121.45f, 261.85f, 150.44f, 269.19f, 172.94f)
            verticalLineTo(174.94f)
            curveTo(245.59f, 145.34f, 220.83f, 155.49f, 209f, 160.15f)
            verticalLineTo(150.65f)
            close()
        }
    }.build()
}
