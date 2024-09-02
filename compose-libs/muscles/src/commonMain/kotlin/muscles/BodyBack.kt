package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun bodyBack(
    outlineColor: Color = Colors.outline,

    rhomboids: Color = Colors.defaultBack,
    latissimus: Color = Colors.defaultBack,
    trapezius: Color = Colors.defaultBack,
    triceps: Color = Colors.defaultBack,
    forearm: Color = Colors.defaultBack,

    teresMajor: Color = Colors.defaultBack,
    posteriorDeltoid: Color = Colors.defaultBack,

    other: Color = Colors.defaultBack,

    backgroundBack: Color = Colors.backgroundBack
): ImageVector {
    return ImageVector.Builder(
        name = "Bodyback",
        defaultWidth = 411.dp,
        defaultHeight = 430.dp,
        viewportWidth = 411f,
        viewportHeight = 430f
    ).apply {
        path(
            fill = SolidColor(backgroundBack),
            stroke = SolidColor(outlineColor),
            strokeLineWidth = 1f
        ) {
            moveTo(182.59f, 86.77f)
            verticalLineTo(93.77f)
            moveTo(182.59f, 93.77f)
            verticalLineTo(104.77f)
            curveTo(178.75f, 110.93f, 163.38f, 124.47f, 132.59f, 129.27f)
            curveTo(101.79f, 134.07f, 101.08f, 172.27f, 104.58f, 190.77f)
            curveTo(94.18f, 213.17f, 91.92f, 241.77f, 92.08f, 253.27f)
            curveTo(84.58f, 260.1f, 68.48f, 279.57f, 64.08f, 302.77f)
            curveTo(59.68f, 325.97f, 43.92f, 348.43f, 36.58f, 356.77f)
            curveTo(32.18f, 356.77f, 29.42f, 358.1f, 28.58f, 358.77f)
            curveTo(20.25f, 364.6f, 3.28f, 376.37f, 2.08f, 376.77f)
            curveTo(0.88f, 377.17f, 0.92f, 378.27f, 1.08f, 378.77f)
            curveTo(2.68f, 385.17f, 9.75f, 383.43f, 13.08f, 381.77f)
            curveTo(16.58f, 379.1f, 23.58f, 374.17f, 23.58f, 375.77f)
            curveTo(23.58f, 377.77f, 12.58f, 405.77f, 9.08f, 414.27f)
            curveTo(6.28f, 421.07f, 11.25f, 420.43f, 14.08f, 419.27f)
            lineTo(25.08f, 394.77f)
            curveTo(22.75f, 399.93f, 17.18f, 412.47f, 13.58f, 421.27f)
            curveTo(9.98f, 430.07f, 15.75f, 429.6f, 19.08f, 428.27f)
            lineTo(31.08f, 400.27f)
            lineTo(21.08f, 424.27f)
            curveTo(20.68f, 431.87f, 25.58f, 429.1f, 28.08f, 426.77f)
            curveTo(30.58f, 420.27f, 35.98f, 406.47f, 37.58f, 403.27f)
            curveTo(39.18f, 400.07f, 39.58f, 401.93f, 39.58f, 403.27f)
            lineTo(34.08f, 417.77f)
            curveTo(32.88f, 424.17f, 35.92f, 422.77f, 37.58f, 421.27f)
            curveTo(44.78f, 412.87f, 51.58f, 390.43f, 54.08f, 380.27f)
            lineTo(62.08f, 358.27f)
            curveTo(112.49f, 299.07f, 121.75f, 270.27f, 120.08f, 263.27f)
            curveTo(126.89f, 257.67f, 133.59f, 234.93f, 136.09f, 224.27f)
            lineTo(154.59f, 266.27f)
            lineTo(154.09f, 305.27f)
            lineTo(152.59f, 309.77f)
            curveTo(148.5f, 325f, 146f, 337.5f, 145.09f, 342.77f)
            lineTo(141f, 365.27f)
            lineTo(196f, 395.5f)
            horizontalLineTo(214f)
            lineTo(270.08f, 365.27f)
            curveTo(268.89f, 334.87f, 261.25f, 310.93f, 257.58f, 302.77f)
            lineTo(257.08f, 264.77f)
            curveTo(263.89f, 259.17f, 272.58f, 233.43f, 276.08f, 221.27f)
            curveTo(277.29f, 236.87f, 287.25f, 256.77f, 292.08f, 264.77f)
            curveTo(289.68f, 277.17f, 304.42f, 300.93f, 312.08f, 311.27f)
            lineTo(352.08f, 361.77f)
            lineTo(352.58f, 365.27f)
            curveTo(354.18f, 380.07f, 367.58f, 408.77f, 374.08f, 421.27f)
            curveTo(377.68f, 424.47f, 377.58f, 420.6f, 377.08f, 418.27f)
            curveTo(375.92f, 414.43f, 373.39f, 406.17f, 372.58f, 403.77f)
            curveTo(371.79f, 401.37f, 373.25f, 402.43f, 374.08f, 403.27f)
            lineTo(383.08f, 426.77f)
            curveTo(389.08f, 431.97f, 390.25f, 426.93f, 390.08f, 423.77f)
            lineTo(379.08f, 397.27f)
            lineTo(391.08f, 425.27f)
            curveTo(398.68f, 432.07f, 397.58f, 422.77f, 396.08f, 417.27f)
            lineTo(384.08f, 390.77f)
            lineTo(397.08f, 418.27f)
            curveTo(402.68f, 423.07f, 403.08f, 417.93f, 402.58f, 414.77f)
            lineTo(387.58f, 374.77f)
            curveTo(390.75f, 376.93f, 398.58f, 381.47f, 404.58f, 382.27f)
            curveTo(410.58f, 383.07f, 410.08f, 378.93f, 409.08f, 376.77f)
            lineTo(390.08f, 364.27f)
            curveTo(382.89f, 355.87f, 376.42f, 354.77f, 374.08f, 355.27f)
            curveTo(362.89f, 346.87f, 354.08f, 325.1f, 351.08f, 315.27f)
            curveTo(343.89f, 283.67f, 326.42f, 259.1f, 318.58f, 250.77f)
            curveTo(320.98f, 235.97f, 311.92f, 204.6f, 307.08f, 190.77f)
            curveTo(314.29f, 144.37f, 290.42f, 129.77f, 277.58f, 128.27f)
            curveTo(256.39f, 129.07f, 238.09f, 112.93f, 231.59f, 104.77f)
            verticalLineTo(88.27f)
            verticalLineTo(93.77f)
            horizontalLineTo(233.59f)
            lineTo(238.09f, 71.77f)
            horizontalLineTo(241.09f)
            curveTo(242.42f, 66.93f, 245.29f, 56.67f, 246.09f, 54.27f)
            curveTo(246.88f, 51.87f, 242.42f, 49.6f, 240.09f, 48.77f)
            curveTo(241.75f, 31.43f, 236.99f, -2.33f, 204.59f, 1.27f)
            curveTo(172.18f, 4.87f, 170.09f, 36.1f, 173.09f, 51.27f)
            curveTo(167.49f, 51.27f, 166.75f, 53.27f, 167.09f, 54.27f)
            lineTo(173.09f, 72.77f)
            horizontalLineTo(174.59f)
            lineTo(180.09f, 92.77f)
            lineTo(182.59f, 93.77f)
            close()
        }
        path(fill = SolidColor(rhomboids)) {
            moveTo(235.61f, 300.91f)
            curveTo(235.21f, 304.91f, 219.44f, 322.58f, 211.61f, 330.91f)
            curveTo(207.61f, 325.41f, 210.61f, 265.41f, 211.61f, 268.91f)
            curveTo(212.41f, 271.71f, 227.94f, 291.41f, 235.61f, 300.91f)
            close()
        }
        path(fill = SolidColor(rhomboids)) {
            moveTo(173.59f, 301.27f)
            curveTo(173.99f, 305.27f, 189.75f, 322.93f, 197.59f, 331.27f)
            curveTo(201.59f, 325.77f, 198.59f, 265.77f, 197.59f, 269.27f)
            curveTo(196.79f, 272.07f, 181.25f, 291.77f, 173.59f, 301.27f)
            close()
        }
        path(fill = SolidColor(latissimus)) {
            moveTo(149.59f, 245.77f)
            curveTo(162.79f, 266.57f, 169.09f, 285.77f, 170.59f, 292.77f)
            curveTo(199.79f, 269.17f, 202.09f, 236.6f, 199.59f, 223.27f)
            curveTo(191.09f, 217.27f, 173.59f, 204.37f, 171.59f, 200.77f)
            curveTo(169.59f, 197.17f, 165.42f, 195.27f, 163.59f, 194.77f)
            lineTo(133.09f, 191.27f)
            curveTo(132.09f, 197.27f, 133.09f, 219.77f, 149.59f, 245.77f)
            close()
        }
        path(fill = SolidColor(latissimus)) {
            moveTo(260.34f, 245.27f)
            curveTo(247.14f, 266.07f, 240.84f, 285.27f, 239.34f, 292.27f)
            curveTo(210.14f, 268.67f, 207.84f, 236.1f, 210.34f, 222.77f)
            curveTo(218.84f, 216.77f, 236.34f, 203.87f, 238.34f, 200.27f)
            curveTo(240.34f, 196.67f, 244.51f, 194.77f, 246.34f, 194.27f)
            lineTo(276.84f, 190.77f)
            curveTo(277.84f, 196.77f, 276.84f, 219.27f, 260.34f, 245.27f)
            close()
        }
        path(fill = SolidColor(trapezius)) {
            moveTo(136.09f, 134.27f)
            curveTo(136.4f, 134.19f, 136.75f, 134.13f, 137.12f, 134.1f)
            lineTo(152.09f, 131.77f)
            curveTo(167.42f, 133.6f, 198.79f, 139.77f, 201.59f, 149.77f)
            curveTo(204.38f, 159.77f, 201.75f, 198.6f, 200.09f, 216.77f)
            curveTo(187.29f, 211.57f, 174.42f, 189.93f, 169.59f, 179.77f)
            curveTo(158.21f, 141.85f, 143.84f, 133.58f, 137.12f, 134.1f)
            lineTo(136.09f, 134.27f)
            close()
        }
        path(fill = SolidColor(trapezius)) {
            moveTo(200.09f, 137.77f)
            curveTo(198.88f, 134.97f, 173.92f, 129.6f, 161.59f, 127.27f)
            horizontalLineTo(160.59f)
            curveTo(196.99f, 107.27f, 203.09f, 80.93f, 201.59f, 70.27f)
            lineTo(205.59f, 71.77f)
            curveTo(203.09f, 78.77f, 201.59f, 141.27f, 200.09f, 137.77f)
            close()
        }
        path(fill = SolidColor(trapezius)) {
            moveTo(278.08f, 134.77f)
            curveTo(277.85f, 134.71f, 277.58f, 134.67f, 277.29f, 134.64f)
            lineTo(262.08f, 132.27f)
            curveTo(246.75f, 134.1f, 213.38f, 138.27f, 210.59f, 148.27f)
            curveTo(207.79f, 158.27f, 208.92f, 197.6f, 210.59f, 215.77f)
            curveTo(223.38f, 210.57f, 237.25f, 190.43f, 242.09f, 180.27f)
            curveTo(248.33f, 144.22f, 270.13f, 134.05f, 277.29f, 134.64f)
            lineTo(278.08f, 134.77f)
            close()
        }
        path(fill = SolidColor(trapezius)) {
            moveTo(214.09f, 138.27f)
            curveTo(215.29f, 135.47f, 240.25f, 130.1f, 252.59f, 127.77f)
            horizontalLineTo(253.59f)
            curveTo(217.18f, 107.77f, 211.09f, 81.43f, 212.59f, 70.77f)
            lineTo(208.59f, 72.27f)
            curveTo(211.09f, 79.27f, 212.59f, 141.77f, 214.09f, 138.27f)
            close()
        }
        path(fill = SolidColor(posteriorDeltoid)) {
            moveTo(111.08f, 186.27f)
            curveTo(117.89f, 183.07f, 138.92f, 157.27f, 148.59f, 144.77f)
            curveTo(147.09f, 142.27f, 120.08f, 135.27f, 112.08f, 149.77f)
            curveTo(105.68f, 161.37f, 108.75f, 178.93f, 111.08f, 186.27f)
            close()
        }
        path(fill = SolidColor(posteriorDeltoid)) {
            moveTo(300.58f, 186.16f)
            curveTo(293.79f, 182.96f, 272.75f, 157.16f, 263.08f, 144.66f)
            curveTo(264.58f, 142.16f, 291.58f, 135.16f, 299.58f, 149.66f)
            curveTo(305.98f, 161.26f, 302.92f, 178.83f, 300.58f, 186.16f)
            close()
        }
        path(fill = SolidColor(teresMajor)) {
            moveTo(151.59f, 152.77f)
            curveTo(145.59f, 154.37f, 134.42f, 171.43f, 129.59f, 179.77f)
            curveTo(135.99f, 186.97f, 156.59f, 187.77f, 166.09f, 187.27f)
            curveTo(163.75f, 175.1f, 157.59f, 151.17f, 151.59f, 152.77f)
            close()
        }
        path(fill = SolidColor(teresMajor)) {
            moveTo(260.08f, 152.66f)
            curveTo(266.08f, 154.26f, 277.25f, 171.33f, 282.08f, 179.66f)
            curveTo(275.68f, 186.86f, 255.09f, 187.66f, 245.59f, 187.16f)
            curveTo(247.92f, 175f, 254.09f, 151.06f, 260.08f, 152.66f)
            close()
        }
        path(fill = SolidColor(triceps)) {
            moveTo(116.08f, 235.77f)
            curveTo(110.08f, 196.97f, 121.25f, 182.27f, 127.58f, 179.77f)
            curveTo(126.79f, 182.57f, 128.59f, 193.93f, 129.59f, 199.27f)
            curveTo(130.42f, 204.77f, 132.09f, 217.97f, 132.09f, 226.77f)
            curveTo(132.09f, 237.77f, 113.58f, 264.27f, 116.08f, 257.77f)
            curveTo(118.08f, 252.57f, 116.92f, 240.93f, 116.08f, 235.77f)
            close()
        }
        path(fill = SolidColor(triceps)) {
            moveTo(105.58f, 244.77f)
            curveTo(105.58f, 241.97f, 108.25f, 224.6f, 109.58f, 216.27f)
            lineTo(111.08f, 244.77f)
            curveTo(108.68f, 257.97f, 106.42f, 250.27f, 105.58f, 244.77f)
            close()
        }
        path(fill = SolidColor(triceps)) {
            moveTo(295.58f, 235.77f)
            curveTo(301.58f, 196.97f, 290.42f, 182.27f, 284.08f, 179.77f)
            curveTo(284.89f, 182.57f, 283.08f, 193.93f, 282.08f, 199.27f)
            curveTo(281.25f, 204.77f, 279.58f, 217.97f, 279.58f, 226.77f)
            curveTo(279.58f, 237.77f, 298.08f, 264.27f, 295.58f, 257.77f)
            curveTo(293.58f, 252.57f, 294.75f, 240.93f, 295.58f, 235.77f)
            close()
        }
        path(fill = SolidColor(triceps)) {
            moveTo(306.08f, 244.77f)
            curveTo(306.08f, 241.97f, 303.42f, 224.6f, 302.08f, 216.27f)
            lineTo(300.58f, 244.77f)
            curveTo(302.98f, 257.97f, 305.25f, 250.27f, 306.08f, 244.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(308.58f, 280.27f)
            curveTo(303.79f, 280.67f, 297.92f, 278.1f, 295.58f, 276.77f)
            curveTo(302.79f, 299.57f, 327.25f, 327.6f, 338.58f, 338.77f)
            lineTo(332.08f, 326.27f)
            curveTo(326.25f, 310.77f, 313.39f, 279.87f, 308.58f, 280.27f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(322.08f, 269.77f)
            curveTo(324.25f, 287.43f, 332.08f, 326.27f, 346.08f, 340.27f)
            curveTo(345.08f, 329.27f, 338.89f, 299.77f, 322.08f, 269.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(353.58f, 353.77f)
            curveTo(353.58f, 346.17f, 337.25f, 292.27f, 329.08f, 266.27f)
            curveTo(330.08f, 266.27f, 357.58f, 339.77f, 360.08f, 347.77f)
            curveTo(362.08f, 354.17f, 356.58f, 354.43f, 353.58f, 353.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(103.51f, 280.77f)
            curveTo(108.31f, 281.17f, 114.18f, 278.6f, 116.51f, 277.27f)
            curveTo(109.31f, 300.07f, 84.85f, 328.1f, 73.51f, 339.27f)
            lineTo(80.01f, 326.77f)
            curveTo(85.85f, 311.27f, 98.71f, 280.37f, 103.51f, 280.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(90.01f, 270.27f)
            curveTo(87.85f, 287.93f, 80.01f, 326.77f, 66.01f, 340.77f)
            curveTo(67.01f, 329.77f, 73.21f, 300.27f, 90.01f, 270.27f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(58.51f, 354.27f)
            curveTo(58.51f, 346.67f, 74.85f, 292.77f, 83.01f, 266.77f)
            curveTo(82.01f, 266.77f, 54.51f, 340.27f, 52.01f, 348.27f)
            curveTo(50.01f, 354.67f, 55.51f, 354.93f, 58.51f, 354.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(149.09f, 347.77f)
            curveTo(153.75f, 341.1f, 167.79f, 327.77f, 186.59f, 327.77f)
            curveTo(176.25f, 315.1f, 154.29f, 301.37f, 149.09f, 347.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(158.59f, 308.27f)
            verticalLineTo(275.27f)
            curveTo(161.79f, 275.27f, 167.25f, 292.93f, 169.59f, 301.77f)
            lineTo(158.59f, 308.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(250.59f, 275.27f)
            curveTo(246.18f, 279.67f, 242.42f, 293.77f, 241.09f, 300.27f)
            curveTo(241.09f, 303.47f, 247.42f, 306.93f, 250.59f, 308.27f)
            verticalLineTo(275.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(223.09f, 327.77f)
            curveTo(231.75f, 328.6f, 251.18f, 333.77f, 259.58f, 347.77f)
            curveTo(258.75f, 329.1f, 250.29f, 298.97f, 223.09f, 327.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(300.08f, 263.77f)
            curveTo(300.08f, 264.97f, 309.42f, 275.27f, 314.08f, 280.27f)
            curveTo(315.08f, 276.1f, 315.58f, 266.17f, 309.58f, 259.77f)
            curveTo(302.08f, 251.77f, 300.08f, 262.27f, 300.08f, 263.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(111.08f, 265.27f)
            lineTo(97.08f, 279.77f)
            lineTo(100.08f, 263.77f)
            curveTo(100.92f, 261.43f, 103.99f, 256.87f, 109.58f, 257.27f)
            curveTo(115.18f, 257.67f, 112.92f, 262.77f, 111.08f, 265.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(41.58f, 357.27f)
            lineTo(26.58f, 380.77f)
            curveTo(27.08f, 381.93f, 29.68f, 385.77f, 36.08f, 391.77f)
            curveTo(42.48f, 397.77f, 44.75f, 396.6f, 45.08f, 395.27f)
            curveTo(55.48f, 384.47f, 54.75f, 365.43f, 53.08f, 357.27f)
            horizontalLineTo(41.58f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(44.58f, 401.77f)
            curveTo(44.98f, 399.77f, 43.75f, 399.93f, 43.08f, 400.27f)
            curveTo(42.58f, 401.27f, 37.58f, 410.77f, 36.58f, 414.27f)
            curveTo(35.78f, 417.07f, 37.92f, 416.43f, 39.08f, 415.77f)
            lineTo(41.08f, 412.77f)
            curveTo(42.08f, 409.93f, 44.18f, 403.77f, 44.58f, 401.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.58f, 400.77f)
            curveTo(37.78f, 396.77f, 35.08f, 397.43f, 33.58f, 398.27f)
            curveTo(32.78f, 398.62f, 27.25f, 413.08f, 24.58f, 420.27f)
            curveTo(24.58f, 424.27f, 26.92f, 422.93f, 28.08f, 421.77f)
            curveTo(30.42f, 416.43f, 35.38f, 404.77f, 36.58f, 400.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(27.08f, 394.27f)
            lineTo(16.58f, 420.27f)
            curveTo(16.58f, 424.67f, 18.92f, 424.43f, 20.08f, 423.77f)
            curveTo(23.25f, 416.43f, 29.88f, 400.67f, 31.08f, 396.27f)
            curveTo(32.28f, 391.87f, 28.92f, 393.1f, 27.08f, 394.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(14.58f, 413.77f)
            curveTo(12.58f, 416.97f, 12.08f, 413.43f, 12.08f, 411.27f)
            curveTo(14.25f, 404.43f, 19.28f, 389.97f, 22.08f, 386.77f)
            curveTo(24.88f, 383.57f, 25.58f, 387.1f, 25.58f, 389.27f)
            curveTo(22.75f, 396.1f, 16.58f, 410.57f, 14.58f, 413.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(31.08f, 360.27f)
            lineTo(11.08f, 371.77f)
            curveTo(10.08f, 372.6f, 7.18f, 374.77f, 3.58f, 376.77f)
            curveTo(-0.02f, 378.77f, 4.08f, 379.93f, 6.58f, 380.27f)
            horizontalLineTo(11.58f)
            lineTo(17.58f, 377.27f)
            curveTo(22.08f, 373.93f, 31.78f, 366.37f, 34.58f, 362.77f)
            curveTo(37.38f, 359.17f, 33.42f, 359.6f, 31.08f, 360.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(365.58f, 396.27f)
            curveTo(357.18f, 383.87f, 357.08f, 365.77f, 358.08f, 358.27f)
            curveTo(360.75f, 356.93f, 366.89f, 354.97f, 370.08f, 357.77f)
            curveTo(373.29f, 360.57f, 381.08f, 373.27f, 384.58f, 379.27f)
            curveTo(385.42f, 380.1f, 386.29f, 382.27f, 383.08f, 384.27f)
            curveTo(379.89f, 386.27f, 377.75f, 388.77f, 377.08f, 389.77f)
            curveTo(373.48f, 396.17f, 367.92f, 396.77f, 365.58f, 396.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(369.58f, 401.27f)
            curveTo(367.18f, 397.67f, 366.58f, 400.1f, 366.58f, 401.77f)
            curveTo(367.75f, 404.93f, 370.48f, 412.07f, 372.08f, 415.27f)
            curveTo(373.68f, 418.47f, 374.75f, 415.93f, 375.08f, 414.27f)
            curveTo(374.25f, 411.43f, 371.98f, 404.87f, 369.58f, 401.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(378.58f, 398.77f)
            curveTo(375.79f, 393.17f, 374.75f, 398.1f, 374.58f, 401.27f)
            lineTo(383.08f, 421.27f)
            curveTo(387.08f, 424.87f, 387.08f, 421.1f, 386.58f, 418.77f)
            curveTo(385.08f, 414.43f, 381.39f, 404.37f, 378.58f, 398.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(384.58f, 395.27f)
            curveTo(380.98f, 389.27f, 380.08f, 394.43f, 380.08f, 397.77f)
            lineTo(391.58f, 423.27f)
            curveTo(395.18f, 427.67f, 395.08f, 421.43f, 394.58f, 417.77f)
            curveTo(392.75f, 412.77f, 388.18f, 401.27f, 384.58f, 395.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(390.58f, 387.77f)
            curveTo(388.18f, 382.57f, 386.25f, 386.93f, 385.58f, 389.77f)
            lineTo(396.08f, 413.77f)
            curveTo(399.68f, 417.77f, 399.92f, 412.1f, 399.58f, 408.77f)
            curveTo(397.58f, 403.93f, 392.98f, 392.97f, 390.58f, 387.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(403.58f, 380.27f)
            curveTo(395.98f, 379.87f, 383.08f, 369.43f, 377.58f, 364.27f)
            curveTo(376.92f, 362.93f, 375.98f, 360.17f, 377.58f, 359.77f)
            curveTo(379.18f, 359.37f, 381.25f, 360.6f, 382.08f, 361.27f)
            lineTo(395.08f, 369.27f)
            lineTo(407.08f, 376.27f)
            curveTo(409.08f, 377.77f, 411.18f, 380.67f, 403.58f, 380.27f)
            close()
        }
    }.build()
}