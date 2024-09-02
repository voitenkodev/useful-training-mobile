package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun legsSplit(
    outlineColor: Color = Colors.outline,
    quadriceps: Color = Colors.defaultFront,
    gluteal: Color = Colors.defaultBack,
    hamstrings: Color = Colors.defaultBack,
    calf: Color = Colors.defaultBack,
    adductors: Color = Colors.defaultBack,
    abductors: Color = Colors.defaultBack,
    other: Color = Colors.defaultFront,
    backgroundFront: Color = Colors.backgroundFront,
    backgroundBack: Color = Colors.backgroundBack,
): ImageVector {
    return ImageVector.Builder(
        name = "Legssplit",
        defaultWidth = 332.dp,
        defaultHeight = 447.dp,
        viewportWidth = 332f,
        viewportHeight = 447f
    ).apply {
        path(
            fill = SolidColor(backgroundFront),
            stroke = SolidColor(outlineColor),
            strokeLineWidth = 1f
        ) {
            moveTo(32.25f, 413.81f)
            lineTo(35.25f, 401.31f)
            lineTo(34.25f, 371.81f)
            curveTo(30.75f, 351.14f, 22.75f, 313.81f, 14.75f, 297.81f)
            curveTo(7.38f, 283.08f, 12.42f, 237.48f, 16.75f, 219.31f)
            lineTo(12.75f, 187.81f)
            curveTo(-6.45f, 132.21f, 2.06f, 53.21f, 9.06f, 13.04f)
            curveTo(54.7f, -1.38f, 81.98f, -3.01f, 128.06f, 9.04f)
            curveTo(130.06f, 17.38f, 133.85f, 33.91f, 136.25f, 86.31f)
            curveTo(138.65f, 138.71f, 129.25f, 178.81f, 124.25f, 192.31f)
            curveTo(119.45f, 215.91f, 120.58f, 226.48f, 121.75f, 228.81f)
            curveTo(130.15f, 251.21f, 126.92f, 278.81f, 124.25f, 289.81f)
            curveTo(121.42f, 299.31f, 115.55f, 318.61f, 114.75f, 319.81f)
            curveTo(113.75f, 321.31f, 104.25f, 371.31f, 102.25f, 374.81f)
            curveTo(100.65f, 377.61f, 101.58f, 389.31f, 102.25f, 394.81f)
            lineTo(103.25f, 401.31f)
            lineTo(104.25f, 410.81f)
            lineTo(121.75f, 434.81f)
            lineTo(126.75f, 439.81f)
            verticalLineTo(443.31f)
            lineTo(123.25f, 444.89f)
            lineTo(86.75f, 445.81f)
            lineTo(80.75f, 439.81f)
            lineTo(81.75f, 425.81f)
            lineTo(83.25f, 410.81f)
            curveTo(84.08f, 400.48f, 85.25f, 376.31f, 83.25f, 362.31f)
            curveTo(80.75f, 344.81f, 76.75f, 299.31f, 75.75f, 289.81f)
            curveTo(74.95f, 282.21f, 82.08f, 243.31f, 85.75f, 224.81f)
            curveTo(85.92f, 218.14f, 86.15f, 204.51f, 85.75f, 203.31f)
            curveTo(85.35f, 202.11f, 78.58f, 145.14f, 75.25f, 116.81f)
            curveTo(74.08f, 100.81f, 70.95f, 69.91f, 67.75f, 74.31f)
            curveTo(64.55f, 78.71f, 58.08f, 147.48f, 55.25f, 181.31f)
            curveTo(49.65f, 195.31f, 50.92f, 217.48f, 52.25f, 226.81f)
            curveTo(60.65f, 260.01f, 62.08f, 287.98f, 61.75f, 297.81f)
            curveTo(60.42f, 313.14f, 57.15f, 344.61f, 54.75f, 347.81f)
            curveTo(52.35f, 351.01f, 53.75f, 373.48f, 54.75f, 384.31f)
            verticalLineTo(413.81f)
            lineTo(57.75f, 436.81f)
            lineTo(54.75f, 443.81f)
            curveTo(52.25f, 444.31f, 43.75f, 444.81f, 37.75f, 444.81f)
            curveTo(14.52f, 444.81f, 12.75f, 441.98f, 14.75f, 439.81f)
            lineTo(32.25f, 413.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(41.25f, 427.81f)
            lineTo(32.25f, 419.81f)
            curveTo(26.42f, 426.14f, 15.25f, 439.31f, 17.25f, 441.31f)
            curveTo(19.25f, 443.31f, 32.42f, 443.14f, 38.75f, 442.81f)
            lineTo(41.25f, 427.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(42.75f, 442.81f)
            lineTo(43.75f, 431.81f)
            curveTo(44.55f, 428.61f, 46.75f, 430.48f, 47.75f, 431.81f)
            lineTo(51.25f, 436.81f)
            verticalLineTo(442.81f)
            horizontalLineTo(42.75f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(86.75f, 435.31f)
            verticalLineTo(441.31f)
            verticalLineTo(442.81f)
            horizontalLineTo(94.25f)
            verticalLineTo(433.31f)
            curveTo(91.85f, 425.71f, 88.25f, 431.48f, 86.75f, 435.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(98.75f, 442.81f)
            curveTo(97.55f, 440.01f, 96.92f, 431.64f, 96.75f, 427.81f)
            verticalLineTo(426.81f)
            lineTo(106.25f, 419.81f)
            curveTo(120.65f, 435.41f, 121.92f, 440.64f, 120.75f, 441.31f)
            lineTo(98.75f, 442.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(51.75f, 432.81f)
            curveTo(49.75f, 427.21f, 39.25f, 418.48f, 34.25f, 414.81f)
            curveTo(34.92f, 411.81f, 36.35f, 404.11f, 36.75f, 397.31f)
            curveTo(37.15f, 390.51f, 38.92f, 390.14f, 39.75f, 390.81f)
            curveTo(47.75f, 398.81f, 52.08f, 410.14f, 53.25f, 414.81f)
            curveTo(53.58f, 423.14f, 53.75f, 438.41f, 51.75f, 432.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(84.25f, 429.31f)
            lineTo(84.75f, 415.81f)
            curveTo(91.55f, 393.41f, 97.25f, 390.14f, 99.25f, 391.31f)
            lineTo(101.75f, 405.31f)
            lineTo(102.75f, 415.81f)
            curveTo(99.92f, 416.31f, 93.25f, 419.21f, 89.25f, 426.81f)
            curveTo(85.25f, 434.41f, 84.25f, 431.64f, 84.25f, 429.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(86.75f, 399.31f)
            verticalLineTo(383.81f)
            lineTo(95.75f, 377.31f)
            curveTo(96.92f, 378.64f, 98.85f, 381.61f, 97.25f, 382.81f)
            curveTo(95.65f, 384.01f, 89.58f, 394.31f, 86.75f, 399.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(50.25f, 399.31f)
            lineTo(39.75f, 381.81f)
            curveTo(39.35f, 379.41f, 41.58f, 377.81f, 42.75f, 377.31f)
            lineTo(50.75f, 384.31f)
            curveTo(51.95f, 391.51f, 50.92f, 397.31f, 50.25f, 399.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(48.25f, 363.81f)
            curveTo(56.08f, 336.48f, 67.75f, 275.41f, 51.75f, 249.81f)
            curveTo(45.42f, 255.48f, 35.85f, 286.21f, 48.25f, 363.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(40.75f, 337.31f)
            curveTo(40.75f, 296.11f, 25.75f, 250.14f, 18.25f, 232.31f)
            lineTo(17.25f, 249.81f)
            curveTo(18.25f, 257.31f, 21.65f, 276.11f, 27.25f, 291.31f)
            curveTo(32.85f, 306.51f, 35.92f, 328.31f, 36.75f, 337.31f)
            curveTo(39.25f, 348.81f, 40.75f, 351.31f, 43.25f, 366.81f)
            curveTo(45.25f, 379.21f, 47.42f, 377.64f, 48.25f, 375.31f)
            curveTo(45.05f, 369.71f, 41.92f, 347.64f, 40.75f, 337.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(29.25f, 308.81f)
            curveTo(29.25f, 305.61f, 19.92f, 272.48f, 15.25f, 256.31f)
            curveTo(13.42f, 265.51f, 15.82f, 283.48f, 17.25f, 291.31f)
            lineTo(22.25f, 311.81f)
            lineTo(30.25f, 340.81f)
            curveTo(31.75f, 346.98f, 35.45f, 361.11f, 38.25f, 368.31f)
            curveTo(41.75f, 377.31f, 42.25f, 369.81f, 40.75f, 368.31f)
            curveTo(39.55f, 367.11f, 35.58f, 346.14f, 33.75f, 335.81f)
            curveTo(32.25f, 328.14f, 29.25f, 312.01f, 29.25f, 308.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(86.25f, 247.81f)
            curveTo(92.25f, 259.81f, 101.35f, 299.81f, 89.75f, 363.81f)
            curveTo(82.08f, 338.98f, 70.65f, 281.01f, 86.25f, 247.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(107.75f, 302.81f)
            curveTo(119.75f, 269.52f, 120.42f, 241.94f, 119.25f, 232.31f)
            curveTo(114.08f, 245.31f, 103.25f, 278.61f, 101.25f, 307.81f)
            curveTo(99.25f, 337.01f, 93.08f, 361.98f, 90.25f, 370.81f)
            curveTo(89.85f, 378.41f, 92.08f, 376.98f, 93.25f, 375.31f)
            lineTo(107.75f, 302.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(121.75f, 291.31f)
            lineTo(123.25f, 256.81f)
            lineTo(112.25f, 296.31f)
            curveTo(109.92f, 304.98f, 105.25f, 324.41f, 105.25f, 332.81f)
            curveTo(105.25f, 341.21f, 99.58f, 358.98f, 96.75f, 366.81f)
            lineTo(97.75f, 370.81f)
            curveTo(101.08f, 364.31f, 107.75f, 349.01f, 107.75f, 339.81f)
            curveTo(107.75f, 330.61f, 117.08f, 303.64f, 121.75f, 291.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(97.75f, 256.31f)
            curveTo(98.95f, 251.11f, 92.58f, 217.81f, 89.25f, 201.81f)
            lineTo(87.75f, 225.81f)
            curveTo(90.58f, 238.14f, 96.55f, 261.51f, 97.75f, 256.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(48.25f, 211.81f)
            curveTo(43.85f, 221.01f, 40.75f, 245.31f, 39.75f, 256.31f)
            curveTo(52.55f, 228.31f, 50.75f, 208.31f, 48.25f, 201.81f)
            verticalLineTo(211.81f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(115.78f, 194f)
            curveTo(125.44f, 164f, 142.57f, 97.6f, 133.77f, 72f)
            curveTo(123.61f, 110f, 105.78f, 187.6f, 115.78f, 194f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(98.78f, 101.5f)
            curveTo(93.18f, 110.7f, 99.44f, 164.67f, 103.28f, 190.5f)
            curveTo(105.28f, 191.17f, 109.46f, 192.11f, 109.46f, 184.73f)
            curveTo(109.46f, 177.47f, 111.23f, 160f, 112.96f, 151.5f)
            curveTo(123.46f, 100f, 135.96f, 59.73f, 127.28f, 13.5f)
            curveTo(120.11f, 39f, 104.38f, 92.3f, 98.78f, 101.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(95.96f, 151.5f)
            curveTo(97.59f, 174.86f, 99.96f, 187.5f, 94.78f, 192.27f)
            curveTo(85.58f, 198.27f, 82.94f, 172f, 83.28f, 156.5f)
            curveTo(84.61f, 150.33f, 84.56f, 140.03f, 86.96f, 129.23f)
            curveTo(89.36f, 118.43f, 93.61f, 114.67f, 93.78f, 116.5f)
            curveTo(94.93f, 129.23f, 94.46f, 130f, 95.96f, 151.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(94.5f, 104.5f)
            curveTo(107.7f, 81.3f, 125.5f, 11f, 119.78f, 11f)
            curveTo(118f, 11f, 107.19f, 28.5f, 101f, 44f)
            curveTo(94.66f, 59.88f, 82.64f, 97.17f, 80.5f, 111f)
            curveTo(79.83f, 125.83f, 78.37f, 135.02f, 82f, 132f)
            curveTo(88f, 127f, 87.5f, 113.5f, 94.5f, 104.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(22.08f, 194f)
            curveTo(12.41f, 164f, -4.72f, 97.6f, 4.08f, 72f)
            curveTo(14.24f, 110f, 32.08f, 187.6f, 22.08f, 194f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(39.08f, 101.5f)
            curveTo(44.68f, 110.7f, 38.41f, 164.67f, 34.58f, 190.5f)
            curveTo(32.58f, 191.17f, 28.39f, 192.11f, 28.39f, 184.73f)
            curveTo(28.39f, 177.47f, 26.62f, 160f, 24.89f, 151.5f)
            curveTo(14.39f, 100f, 1.89f, 59.73f, 10.58f, 13.5f)
            curveTo(17.74f, 39f, 33.48f, 92.3f, 39.08f, 101.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(41.89f, 151.5f)
            curveTo(40.26f, 174.86f, 37.89f, 187.5f, 43.08f, 192.27f)
            curveTo(52.28f, 198.27f, 54.91f, 172f, 54.58f, 156.5f)
            curveTo(53.24f, 150.33f, 53.29f, 140.03f, 50.89f, 129.23f)
            curveTo(48.49f, 118.43f, 44.24f, 114.67f, 44.08f, 116.5f)
            curveTo(42.92f, 129.23f, 43.39f, 130f, 41.89f, 151.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(43.35f, 104.5f)
            curveTo(30.15f, 81.3f, 12.35f, 11f, 18.08f, 11f)
            curveTo(19.85f, 11f, 30.67f, 28.5f, 36.85f, 44f)
            curveTo(43.19f, 59.88f, 55.22f, 97.17f, 57.35f, 111f)
            curveTo(58.02f, 125.83f, 59.48f, 135.02f, 55.85f, 132f)
            curveTo(49.85f, 127f, 50.35f, 113.5f, 43.35f, 104.5f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(44.75f, 48.31f)
            lineTo(26.75f, 13.81f)
            curveTo(31.95f, 15.81f, 51.25f, 34.64f, 60.25f, 43.81f)
            curveTo(53.05f, 62.61f, 49.25f, 65.98f, 48.25f, 65.31f)
            curveTo(47.25f, 64.64f, 44.75f, 48.31f, 44.75f, 48.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(111.25f, 13.81f)
            lineTo(77.75f, 42.31f)
            curveTo(81.58f, 52.98f, 89.35f, 72.51f, 89.75f, 65.31f)
            curveTo(90.25f, 56.31f, 92.75f, 48.31f, 93.75f, 48.31f)
            curveTo(94.55f, 48.31f, 105.75f, 25.31f, 111.25f, 13.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(83.75f, 80.31f)
            curveTo(87.75f, 73.51f, 77.75f, 54.81f, 72.25f, 46.31f)
            curveTo(72.25f, 55.31f, 72.75f, 75.91f, 74.75f, 86.31f)
            curveTo(76.75f, 96.71f, 79.92f, 98.98f, 81.25f, 98.81f)
            curveTo(80.42f, 95.48f, 79.75f, 87.11f, 83.75f, 80.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(58.25f, 98.31f)
            curveTo(63.85f, 92.71f, 65.58f, 61.48f, 65.25f, 46.31f)
            curveTo(54.75f, 68.31f, 50.25f, 73.81f, 54.25f, 80.31f)
            curveTo(57.45f, 85.51f, 56.92f, 91.48f, 56.25f, 93.81f)
            curveTo(57.05f, 99.81f, 57.92f, 99.31f, 58.25f, 98.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(37.75f, 225.81f)
            lineTo(30.25f, 208.31f)
            verticalLineTo(204.31f)
            curveTo(38.25f, 197.51f, 42.58f, 203.48f, 43.75f, 207.31f)
            lineTo(37.75f, 225.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(28.75f, 216.81f)
            lineTo(18.25f, 191.31f)
            curveTo(18.25f, 200.51f, 19.92f, 216.48f, 20.75f, 223.31f)
            curveTo(30.75f, 229.71f, 32.25f, 229.31f, 31.75f, 228.31f)
            lineTo(28.75f, 216.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(100.75f, 225.81f)
            lineTo(108.25f, 208.31f)
            verticalLineTo(204.31f)
            curveTo(100.25f, 197.51f, 95.92f, 203.48f, 94.75f, 207.31f)
            lineTo(100.75f, 225.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(109.75f, 216.81f)
            lineTo(120.25f, 191.31f)
            curveTo(120.25f, 200.51f, 118.58f, 216.48f, 117.75f, 223.31f)
            curveTo(107.75f, 229.71f, 106.25f, 229.31f, 106.75f, 228.31f)
            lineTo(109.75f, 216.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(45.06f, 6.04f)
            curveTo(54.56f, 32.04f, 50.06f, 22.54f, 54.25f, 31.31f)
            curveTo(59.45f, 35.31f, 62.42f, 31.31f, 63.25f, 28.81f)
            verticalLineTo(3.54f)
            curveTo(52.06f, 3.54f, 50.56f, 5.04f, 45.06f, 6.04f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(93.06f, 4.54f)
            curveTo(83.56f, 30.54f, 87.25f, 22.54f, 83.06f, 31.31f)
            curveTo(77.86f, 35.31f, 74.9f, 31.31f, 74.06f, 28.81f)
            verticalLineTo(3.04f)
            curveTo(85.25f, 3.04f, 87.56f, 3.54f, 93.06f, 4.54f)
            close()
        }
        path(
            stroke = SolidColor(outlineColor),
            strokeLineWidth = 1f
        ) {
            moveTo(207.65f, 437.81f)
            curveTo(204.45f, 439.41f, 207.31f, 443.14f, 209.15f, 444.81f)
            curveTo(218.31f, 445.48f, 238.25f, 446.51f, 244.65f, 445.31f)
            curveTo(251.05f, 444.11f, 251.98f, 439.81f, 251.65f, 437.81f)
            verticalLineTo(426.81f)
            curveTo(250.48f, 423.31f, 248.35f, 414.91f, 249.15f, 409.31f)
            curveTo(249.95f, 403.71f, 248.81f, 398.31f, 248.15f, 396.31f)
            curveTo(247.75f, 391.91f, 249.31f, 367.14f, 250.15f, 355.31f)
            curveTo(256.65f, 300.81f, 256.15f, 303.81f, 256.65f, 284.31f)
            curveTo(257.15f, 264.81f, 246.15f, 218.81f, 246.15f, 216.81f)
            curveTo(246.15f, 215.21f, 247.15f, 204.81f, 247.65f, 199.81f)
            lineTo(250.65f, 175.81f)
            curveTo(254.31f, 144.98f, 261.85f, 82.01f, 262.65f, 76.81f)
            curveTo(263.45f, 71.61f, 264.31f, 71.98f, 264.65f, 72.81f)
            lineTo(273.15f, 133.81f)
            curveTo(275.31f, 155.14f, 279.95f, 198.31f, 281.15f, 200.31f)
            curveTo(282.35f, 202.31f, 281.65f, 213.48f, 281.15f, 218.81f)
            lineTo(278.65f, 236.81f)
            lineTo(271.15f, 279.31f)
            curveTo(270.81f, 290.14f, 270.75f, 314.01f, 273.15f, 322.81f)
            curveTo(275.55f, 331.61f, 278.15f, 375.48f, 279.15f, 396.31f)
            curveTo(277.55f, 398.71f, 278.15f, 406.31f, 278.65f, 409.81f)
            curveTo(278.15f, 413.81f, 276.85f, 424.01f, 275.65f, 432.81f)
            curveTo(274.45f, 441.61f, 277.48f, 444.81f, 279.15f, 445.31f)
            curveTo(290.15f, 445.48f, 313.25f, 445.71f, 317.65f, 445.31f)
            curveTo(322.05f, 444.91f, 321.81f, 440.48f, 321.15f, 438.31f)
            curveTo(318.98f, 437.81f, 314.15f, 435.41f, 312.15f, 429.81f)
            curveTo(310.15f, 424.21f, 303.31f, 415.14f, 300.15f, 411.31f)
            verticalLineTo(407.81f)
            curveTo(300.55f, 402.61f, 298.65f, 397.31f, 297.65f, 395.31f)
            curveTo(297.48f, 392.31f, 297.25f, 384.31f, 297.65f, 376.31f)
            curveTo(298.05f, 368.31f, 305.48f, 338.98f, 309.15f, 325.31f)
            curveTo(310.65f, 322.64f, 314.85f, 311.91f, 319.65f, 290.31f)
            curveTo(324.45f, 268.71f, 318.65f, 233.64f, 315.15f, 218.81f)
            curveTo(317.55f, 215.21f, 318.15f, 206.98f, 318.15f, 203.31f)
            curveTo(322.95f, 191.71f, 328.48f, 152.81f, 330.65f, 134.81f)
            curveTo(330.31f, 115.14f, 328.15f, 37.81f, 328.15f, 37.81f)
            curveTo(317.06f, -5.46f, 206.56f, -11.46f, 199.15f, 41.31f)
            curveTo(199.15f, 41.31f, 197.05f, 106.01f, 196.65f, 126.81f)
            curveTo(196.25f, 147.61f, 205.15f, 184.14f, 209.65f, 199.81f)
            curveTo(208.85f, 203.41f, 210.98f, 213.31f, 212.15f, 217.81f)
            curveTo(211.15f, 225.48f, 208.55f, 244.21f, 206.15f, 257.81f)
            curveTo(203.15f, 274.81f, 212.65f, 307.81f, 213.15f, 308.81f)
            curveTo(213.55f, 309.61f, 219.98f, 331.14f, 223.15f, 341.81f)
            curveTo(224.81f, 350.48f, 228.55f, 368.71f, 230.15f, 372.31f)
            curveTo(231.75f, 375.91f, 230.81f, 389.81f, 230.15f, 396.31f)
            curveTo(226.55f, 399.51f, 227.31f, 406.31f, 228.15f, 409.31f)
            curveTo(227.65f, 411.14f, 226.15f, 414.91f, 224.15f, 415.31f)
            curveTo(222.15f, 415.71f, 218.31f, 424.48f, 216.65f, 428.81f)
            curveTo(214.98f, 431.14f, 210.85f, 436.21f, 207.65f, 437.81f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(221.25f, 442.31f)
            curveTo(220.45f, 440.31f, 226.92f, 422.14f, 230.25f, 413.31f)
            verticalLineTo(434.31f)
            curveTo(230.92f, 436.48f, 233.35f, 440.01f, 237.75f, 436.81f)
            curveTo(243.25f, 432.81f, 239.75f, 407.31f, 244.75f, 415.81f)
            curveTo(248.75f, 422.61f, 248.08f, 436.31f, 247.25f, 442.31f)
            curveTo(238.92f, 443.14f, 222.05f, 444.31f, 221.25f, 442.31f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(280.75f, 442.31f)
            curveTo(279.15f, 439.51f, 282.42f, 423.48f, 284.25f, 415.81f)
            curveTo(285.25f, 423.98f, 288.55f, 440.01f, 293.75f, 438.81f)
            curveTo(298.95f, 437.61f, 297.58f, 421.31f, 296.25f, 413.31f)
            curveTo(300.65f, 415.71f, 305.08f, 433.64f, 306.75f, 442.31f)
            curveTo(298.75f, 443.48f, 282.35f, 445.11f, 280.75f, 442.31f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(224.75f, 336.31f)
            curveTo(230.75f, 347.51f, 234.25f, 385.31f, 235.25f, 402.81f)
            curveTo(239.75f, 408.81f, 238.25f, 402.81f, 238.75f, 400.31f)
            curveTo(239.15f, 398.31f, 236.58f, 368.14f, 235.25f, 353.31f)
            curveTo(233.42f, 345.98f, 229.15f, 328.01f, 226.75f, 314.81f)
            curveTo(224.35f, 301.61f, 221.08f, 304.31f, 219.75f, 307.31f)
            curveTo(218.92f, 312.31f, 218.75f, 325.11f, 224.75f, 336.31f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(245.25f, 401.81f)
            curveTo(244.05f, 406.61f, 242.75f, 403.48f, 242.25f, 401.31f)
            lineTo(244.25f, 371.31f)
            lineTo(246.25f, 337.31f)
            lineTo(247.25f, 316.81f)
            curveTo(248.08f, 312.64f, 250.05f, 304.61f, 251.25f, 305.81f)
            curveTo(252.45f, 307.01f, 251.75f, 319.64f, 251.25f, 325.81f)
            curveTo(250.42f, 332.81f, 248.65f, 347.41f, 248.25f, 349.81f)
            curveTo(247.85f, 352.21f, 246.42f, 369.81f, 245.75f, 378.31f)
            lineTo(245.25f, 401.81f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(284.25f, 401.81f)
            curveTo(283.45f, 405.81f, 282.58f, 404.14f, 282.25f, 402.81f)
            verticalLineTo(395.81f)
            curveTo(282.25f, 394.61f, 279.92f, 362.98f, 278.75f, 347.31f)
            curveTo(277.95f, 344.91f, 276.42f, 332.31f, 275.75f, 326.31f)
            lineTo(274.75f, 313.31f)
            curveTo(275.15f, 304.91f, 275.92f, 303.81f, 276.25f, 304.31f)
            lineTo(280.25f, 320.31f)
            curveTo(280.42f, 322.14f, 280.65f, 326.31f, 280.25f, 328.31f)
            curveTo(279.85f, 330.31f, 281.08f, 350.48f, 281.75f, 360.31f)
            lineTo(284.25f, 401.81f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(291.75f, 400.31f)
            curveTo(288.95f, 408.31f, 287.92f, 404.31f, 287.75f, 401.31f)
            curveTo(288.25f, 394.31f, 289.25f, 379.71f, 289.25f, 377.31f)
            curveTo(289.25f, 374.91f, 291.92f, 356.98f, 293.25f, 348.31f)
            curveTo(295.42f, 337.14f, 299.95f, 314.01f, 300.75f, 310.81f)
            curveTo(301.75f, 306.81f, 303.25f, 304.31f, 306.75f, 304.81f)
            curveTo(309.55f, 305.21f, 308.58f, 315.31f, 307.75f, 320.31f)
            curveTo(304.92f, 330.14f, 298.65f, 350.81f, 296.25f, 354.81f)
            curveTo(293.85f, 358.81f, 292.25f, 386.81f, 291.75f, 400.31f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(285.75f, 299.31f)
            curveTo(278.55f, 308.11f, 276.42f, 302.98f, 276.25f, 299.31f)
            curveTo(276.25f, 293.14f, 275.95f, 277.41f, 274.75f, 263.81f)
            curveTo(273.55f, 250.21f, 290.58f, 210.81f, 299.25f, 192.81f)
            verticalLineTo(230.81f)
            curveTo(298.25f, 237.64f, 296.25f, 254.81f, 296.25f, 268.81f)
            curveTo(296.25f, 282.81f, 294.25f, 289.64f, 293.25f, 291.31f)
            curveTo(293.75f, 290.31f, 292.95f, 290.51f, 285.75f, 299.31f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(298.25f, 291.31f)
            curveTo(303.85f, 280.91f, 303.92f, 220.31f, 303.25f, 191.31f)
            curveTo(308.05f, 183.71f, 309.92f, 188.14f, 310.25f, 191.31f)
            lineTo(314.75f, 221.81f)
            curveTo(316.42f, 235.14f, 319.75f, 263.21f, 319.75f, 268.81f)
            curveTo(319.75f, 274.41f, 309.75f, 292.48f, 304.75f, 300.81f)
            lineTo(298.25f, 291.31f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(228.25f, 223.81f)
            lineTo(229.25f, 193.81f)
            curveTo(243.25f, 215.41f, 250.42f, 247.81f, 252.25f, 261.31f)
            curveTo(252.75f, 271.31f, 253.45f, 292.91f, 252.25f, 299.31f)
            curveTo(251.05f, 305.71f, 245.08f, 302.98f, 242.25f, 300.81f)
            curveTo(238.92f, 297.64f, 232.45f, 290.81f, 233.25f, 288.81f)
            curveTo(234.05f, 286.81f, 230.25f, 244.64f, 228.25f, 223.81f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(224.75f, 191.31f)
            curveTo(219.95f, 184.51f, 218.75f, 187.81f, 218.75f, 190.31f)
            lineTo(214.75f, 215.31f)
            curveTo(212.58f, 229.14f, 208.15f, 258.51f, 207.75f, 265.31f)
            curveTo(207.35f, 272.11f, 217.58f, 291.81f, 222.75f, 300.81f)
            lineTo(229.25f, 291.31f)
            curveTo(223.65f, 281.71f, 223.92f, 220.64f, 224.75f, 191.31f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(219.25f, 175.31f)
            lineTo(210.75f, 194.31f)
            lineTo(206.06f, 152.04f)
            curveTo(205.23f, 137.54f, 206.35f, 110.64f, 210.75f, 101.04f)
            curveTo(215.15f, 91.44f, 221.08f, 83.31f, 224.75f, 81.81f)
            curveTo(211.15f, 114.61f, 215.42f, 157.81f, 219.25f, 175.31f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(241.56f, 198.04f)
            curveTo(239.96f, 201.24f, 241.06f, 206.04f, 236.75f, 201.81f)
            curveTo(217.25f, 174.31f, 221.25f, 153.81f, 219.25f, 137.81f)
            curveTo(217.65f, 125.01f, 227.25f, 91.14f, 232.25f, 75.81f)
            curveTo(234.25f, 76.61f, 237.9f, 107.38f, 239.06f, 121.54f)
            curveTo(246.56f, 158.04f, 249.56f, 182.04f, 241.56f, 198.04f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(285.8f, 135.71f)
            curveTo(289.45f, 113.22f, 293.55f, 89.42f, 296.25f, 75.81f)
            curveTo(319.05f, 146.21f, 302.42f, 189.14f, 291.25f, 201.81f)
            curveTo(289.18f, 201.81f, 287.58f, 201.05f, 286.34f, 199.72f)
            curveTo(280.26f, 193.21f, 282.81f, 173.14f, 281.56f, 162.54f)
            curveTo(282.8f, 154.4f, 284.26f, 145.17f, 285.8f, 135.71f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(308.25f, 175.31f)
            curveTo(315.75f, 143.54f, 309.42f, 100.14f, 302.75f, 81.81f)
            curveTo(306.25f, 81.14f, 311.16f, 81.44f, 317.56f, 103.04f)
            curveTo(323.96f, 124.64f, 320.25f, 174.14f, 315.75f, 194.31f)
            lineTo(308.25f, 175.31f)
            close()
        }
        path(fill = SolidColor(adductors)) {
            moveTo(248.57f, 154.71f)
            curveTo(248.63f, 155.09f, 248.69f, 155.45f, 248.75f, 155.81f)
            curveTo(248.67f, 155.49f, 248.61f, 155.13f, 248.57f, 154.71f)
            curveTo(244.19f, 128.03f, 236.28f, 76.07f, 238.25f, 73.31f)
            curveTo(240.25f, 70.51f, 250.42f, 64.14f, 255.25f, 61.31f)
            curveTo(258.11f, 72.81f, 261.61f, 102.11f, 252.75f, 127.31f)
            curveTo(251.04f, 134.31f, 247.99f, 148.91f, 248.57f, 154.71f)
            close()
        }
        path(fill = SolidColor(adductors)) {
            moveTo(289.25f, 73.31f)
            lineTo(272.25f, 61.31f)
            curveTo(265.85f, 82.91f, 274.92f, 133.31f, 280.25f, 155.81f)
            curveTo(279.05f, 150.61f, 283.75f, 122.64f, 286.25f, 109.31f)
            curveTo(291.05f, 88.91f, 290.25f, 76.81f, 289.25f, 73.31f)
            close()
        }
        path(fill = SolidColor(abductors)) {
            moveTo(200.25f, 67.81f)
            curveTo(203.05f, 71.01f, 210.56f, 91.08f, 210.06f, 93.81f)
            curveTo(209.56f, 96.54f, 206.98f, 106.4f, 205.06f, 114.54f)
            curveTo(202.9f, 123.73f, 202.06f, 135.54f, 202.06f, 135.54f)
            lineTo(199.06f, 131.54f)
            lineTo(200.25f, 102.04f)
            verticalLineTo(67.81f)
            close()
        }
        path(fill = SolidColor(abductors)) {
            moveTo(326.9f, 67.54f)
            curveTo(324.1f, 70.74f, 316.59f, 90.81f, 317.09f, 93.54f)
            curveTo(317.59f, 96.28f, 320.17f, 106.14f, 322.09f, 114.28f)
            curveTo(324.25f, 123.46f, 325.09f, 135.28f, 325.09f, 135.28f)
            lineTo(328.09f, 131.28f)
            lineTo(326.9f, 101.78f)
            verticalLineTo(67.54f)
            close()
        }
        path(fill = SolidColor(gluteal)) {
            moveTo(209.25f, 82.81f)
            curveTo(202.45f, 68.81f, 204.08f, 41.98f, 205.75f, 30.31f)
            curveTo(217.75f, 8.81f, 256.75f, 8.81f, 259.75f, 10.31f)
            curveTo(262.15f, 11.51f, 260.75f, 34.14f, 259.75f, 45.31f)
            lineTo(252.25f, 55.31f)
            curveTo(247.25f, 58.48f, 234.75f, 65.81f, 224.75f, 69.81f)
            curveTo(214.75f, 73.81f, 210.25f, 80.14f, 209.25f, 82.81f)
            close()
        }
        path(fill = SolidColor(gluteal)) {
            moveTo(266.25f, 45.31f)
            verticalLineTo(10.31f)
            curveTo(287.25f, 7.81f, 313.75f, 18.31f, 320.25f, 30.31f)
            curveTo(325.45f, 39.91f, 319.75f, 69.31f, 316.25f, 82.81f)
            curveTo(315.92f, 80.64f, 312.25f, 75.01f, 300.25f, 69.81f)
            curveTo(288.25f, 64.61f, 277.58f, 57.98f, 273.75f, 55.31f)
            lineTo(266.25f, 45.31f)
            close()
        }
    }.build()
}