package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun fullFront(
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

    quadriceps: Color = Colors.defaultFront,

    other: Color = Colors.defaultFront,

    backgroundFront: Color = Colors.backgroundFront,
): ImageVector {
    return ImageVector.Builder(
        name = "Fullfront",
        defaultWidth = 411.dp,
        defaultHeight = 773.dp,
        viewportWidth = 411f,
        viewportHeight = 773f
    ).apply {
        path(
            stroke = SolidColor(outlineColor),
            fill = SolidColor(backgroundFront),
            strokeLineWidth = 1f
        ) {
            moveTo(172.19f, 727.77f)
            lineTo(169.19f, 740.27f)
            lineTo(151.69f, 766.27f)
            curveTo(149.69f, 768.43f, 151.46f, 771.27f, 174.69f, 771.27f)
            curveTo(180.69f, 771.27f, 189.19f, 770.77f, 191.69f, 770.27f)
            lineTo(194.69f, 763.27f)
            lineTo(191.69f, 740.27f)
            verticalLineTo(710.77f)
            curveTo(190.69f, 699.93f, 189.29f, 677.47f, 191.69f, 674.27f)
            curveTo(194.09f, 671.07f, 197.35f, 639.6f, 198.69f, 624.27f)
            curveTo(199.02f, 614.43f, 197.59f, 586.47f, 189.19f, 553.27f)
            curveTo(188f, 538f, 189.19f, 522f, 192.19f, 507.77f)
            curveTo(195.02f, 473.93f, 201.49f, 405.17f, 204.69f, 400.77f)
            curveTo(207.89f, 396.37f, 211.02f, 427.27f, 212.19f, 443.27f)
            curveTo(215.52f, 471.6f, 222.29f, 528.57f, 222.69f, 529.77f)
            curveTo(223.09f, 530.97f, 222.85f, 544.6f, 222.69f, 551.27f)
            curveTo(219.02f, 569.77f, 211.89f, 608.67f, 212.69f, 616.27f)
            curveTo(213.69f, 625.77f, 217.69f, 671.27f, 220.19f, 688.77f)
            curveTo(222.19f, 702.77f, 221.02f, 726.93f, 220.19f, 737.27f)
            lineTo(218.69f, 752.27f)
            lineTo(217.69f, 766.27f)
            lineTo(223.69f, 772.27f)
            lineTo(260.19f, 771.34f)
            lineTo(263.69f, 769.77f)
            verticalLineTo(766.27f)
            lineTo(258.69f, 761.27f)
            lineTo(241.19f, 737.27f)
            lineTo(240.19f, 727.77f)
            lineTo(239.19f, 721.27f)
            curveTo(238.52f, 715.77f, 237.59f, 704.07f, 239.19f, 701.27f)
            curveTo(241.19f, 697.77f, 250.69f, 647.77f, 251.69f, 646.27f)
            curveTo(252.49f, 645.07f, 258.35f, 625.77f, 261.19f, 616.27f)
            curveTo(263.85f, 605.27f, 267.09f, 577.67f, 258.69f, 555.27f)
            curveTo(257.52f, 552.93f, 256.39f, 542.37f, 261.19f, 518.77f)
            curveTo(266.19f, 505.27f, 275.59f, 465.17f, 273.19f, 412.77f)
            curveTo(270.79f, 360.37f, 266.19f, 330.6f, 264.19f, 322.27f)
            lineTo(257.19f, 300.77f)
            lineTo(257.69f, 263.77f)
            curveTo(272.69f, 243.77f, 274.69f, 214.77f, 275.19f, 222.77f)
            curveTo(275.59f, 229.17f, 286.02f, 252.1f, 291.19f, 262.77f)
            curveTo(290.79f, 273.17f, 300.69f, 293.43f, 305.69f, 302.27f)
            curveTo(314.69f, 314.1f, 334.09f, 339.17f, 339.69f, 344.77f)
            curveTo(346.69f, 351.77f, 354.69f, 368.77f, 355.69f, 375.77f)
            curveTo(356.69f, 382.77f, 361.69f, 394.77f, 362.19f, 397.77f)
            curveTo(362.69f, 400.77f, 371.69f, 418.27f, 374.19f, 421.27f)
            curveTo(376.19f, 423.67f, 377.69f, 421.6f, 378.19f, 420.27f)
            curveTo(376.52f, 415.77f, 373.09f, 406.27f, 372.69f, 404.27f)
            curveTo(372.29f, 402.27f, 373.19f, 402.77f, 373.69f, 403.27f)
            lineTo(383.69f, 426.27f)
            curveTo(387.69f, 430.27f, 389.69f, 426.6f, 390.19f, 424.27f)
            curveTo(386.35f, 415.77f, 378.59f, 398.47f, 378.19f, 397.27f)
            curveTo(377.79f, 396.07f, 378.35f, 396.43f, 378.69f, 396.77f)
            lineTo(392.19f, 426.77f)
            curveTo(397.39f, 430.37f, 398.35f, 425.27f, 398.19f, 422.27f)
            lineTo(384.19f, 391.27f)
            curveTo(387.69f, 399.77f, 395.59f, 417.17f, 399.19f, 418.77f)
            curveTo(402.79f, 420.37f, 403.02f, 416.77f, 402.69f, 414.77f)
            lineTo(388.19f, 374.27f)
            curveTo(391.85f, 376.77f, 400.49f, 381.77f, 405.69f, 381.77f)
            curveTo(410.89f, 381.77f, 410.52f, 377.77f, 409.69f, 375.77f)
            curveTo(405.85f, 374.43f, 396.69f, 370.07f, 390.69f, 363.27f)
            curveTo(384.69f, 356.47f, 376.52f, 354.43f, 373.19f, 354.27f)
            curveTo(363.19f, 345.47f, 354.35f, 323.6f, 351.19f, 313.77f)
            curveTo(347.99f, 292.17f, 328.19f, 261.77f, 318.69f, 249.27f)
            curveTo(321.49f, 231.27f, 312.52f, 203.43f, 307.69f, 191.77f)
            verticalLineTo(156.77f)
            curveTo(301.19f, 123.77f, 259.69f, 124.27f, 257.19f, 124.27f)
            curveTo(254.69f, 124.27f, 238.19f, 112.77f, 233.19f, 107.27f)
            curveTo(229.19f, 102.87f, 229.52f, 97.43f, 230.19f, 95.27f)
            lineTo(234.19f, 89.77f)
            lineTo(235.69f, 82.27f)
            lineTo(236.19f, 74.77f)
            curveTo(237.39f, 75.17f, 238.02f, 74.27f, 238.19f, 73.77f)
            curveTo(239.52f, 69.6f, 242.49f, 60.67f, 243.69f, 58.27f)
            curveTo(244.89f, 55.87f, 240.85f, 53.6f, 238.69f, 52.77f)
            curveTo(243.19f, 15.77f, 220.19f, -6.23f, 194.19f, 3.27f)
            curveTo(173.39f, 10.87f, 170.85f, 40.1f, 172.19f, 53.77f)
            curveTo(166.99f, 54.97f, 166.35f, 56.6f, 166.69f, 57.27f)
            curveTo(167.52f, 59.77f, 169.59f, 65.97f, 171.19f, 70.77f)
            curveTo(172.79f, 75.57f, 174.52f, 76.1f, 175.19f, 75.77f)
            lineTo(176.69f, 89.77f)
            lineTo(182.19f, 95.27f)
            curveTo(183.02f, 97.6f, 183.79f, 103.27f, 180.19f, 107.27f)
            curveTo(176.59f, 111.27f, 160.69f, 120.27f, 153.19f, 124.27f)
            curveTo(116.39f, 126.27f, 104.52f, 146.43f, 103.19f, 156.27f)
            verticalLineTo(191.77f)
            curveTo(96.39f, 198.97f, 93.02f, 234.1f, 92.19f, 250.77f)
            curveTo(90.35f, 253.27f, 84.79f, 260.77f, 77.19f, 270.77f)
            curveTo(67.69f, 283.27f, 65.19f, 296.27f, 59.19f, 316.27f)
            curveTo(54.39f, 332.27f, 42.19f, 349.27f, 36.69f, 355.77f)
            curveTo(33.49f, 355.37f, 30.02f, 356.27f, 28.69f, 356.77f)
            lineTo(1.19f, 375.77f)
            curveTo(0.69f, 378.27f, 0.89f, 383.07f, 5.69f, 382.27f)
            curveTo(11.69f, 381.27f, 21.69f, 374.27f, 23.19f, 373.77f)
            curveTo(24.39f, 373.37f, 24.02f, 373.93f, 23.69f, 374.27f)
            lineTo(19.69f, 384.77f)
            curveTo(16.69f, 392.27f, 10.29f, 408.67f, 8.69f, 414.27f)
            curveTo(7.09f, 419.87f, 10.69f, 419.27f, 12.69f, 418.27f)
            lineTo(24.19f, 395.27f)
            curveTo(25.79f, 393.27f, 26.19f, 394.77f, 26.19f, 395.77f)
            curveTo(22.52f, 403.27f, 14.69f, 419.37f, 12.69f, 423.77f)
            curveTo(10.69f, 428.17f, 15.52f, 428.27f, 18.19f, 427.77f)
            lineTo(30.19f, 401.27f)
            curveTo(32.59f, 398.47f, 32.19f, 400.77f, 31.69f, 402.27f)
            curveTo(28.85f, 409.27f, 22.89f, 423.57f, 21.69f, 424.77f)
            curveTo(20.19f, 426.27f, 23.19f, 431.77f, 26.19f, 428.77f)
            curveTo(28.59f, 426.37f, 34.19f, 411.77f, 36.69f, 404.77f)
            curveTo(38.29f, 402.77f, 38.69f, 403.93f, 38.69f, 404.77f)
            curveTo(38.85f, 405.1f, 38.29f, 407.77f, 34.69f, 415.77f)
            curveTo(31.09f, 423.77f, 35.52f, 422.77f, 38.19f, 421.27f)
            curveTo(48.59f, 407.27f, 53.52f, 384.77f, 54.69f, 375.27f)
            lineTo(61.19f, 357.77f)
            curveTo(61.69f, 356.43f, 68.19f, 347.47f, 90.19f, 322.27f)
            curveTo(112.19f, 297.07f, 119.02f, 271.43f, 119.69f, 261.77f)
            curveTo(126.49f, 256.57f, 132.85f, 234.27f, 135.19f, 223.77f)
            curveTo(134.79f, 226.97f, 147.69f, 252.1f, 154.19f, 264.27f)
            curveTo(154.19f, 270.77f, 154.19f, 285.97f, 154.19f, 294.77f)
            curveTo(154.19f, 303.57f, 149.19f, 318.1f, 146.69f, 324.27f)
            curveTo(139.69f, 364.43f, 130.49f, 458.67f, 149.69f, 514.27f)
            lineTo(153.69f, 545.77f)
            curveTo(149.35f, 563.93f, 144.32f, 609.53f, 151.69f, 624.27f)
            curveTo(159.69f, 640.27f, 167.69f, 677.6f, 171.19f, 698.27f)
            lineTo(172.19f, 727.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(178.19f, 754.27f)
            lineTo(169.19f, 746.27f)
            curveTo(163.35f, 752.6f, 152.19f, 765.77f, 154.19f, 767.77f)
            curveTo(156.19f, 769.77f, 169.35f, 769.6f, 175.69f, 769.27f)
            lineTo(178.19f, 754.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(179.69f, 769.27f)
            lineTo(180.69f, 758.27f)
            curveTo(181.49f, 755.07f, 183.69f, 756.93f, 184.69f, 758.27f)
            lineTo(188.19f, 763.27f)
            verticalLineTo(769.27f)
            horizontalLineTo(179.69f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(223.69f, 761.77f)
            verticalLineTo(767.77f)
            verticalLineTo(769.27f)
            horizontalLineTo(231.19f)
            verticalLineTo(759.77f)
            curveTo(228.79f, 752.17f, 225.19f, 757.93f, 223.69f, 761.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(235.69f, 769.27f)
            curveTo(234.49f, 766.47f, 233.85f, 758.1f, 233.69f, 754.27f)
            verticalLineTo(753.27f)
            lineTo(243.19f, 746.27f)
            curveTo(257.59f, 761.87f, 258.85f, 767.1f, 257.69f, 767.77f)
            lineTo(235.69f, 769.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(188.69f, 759.27f)
            curveTo(186.69f, 753.67f, 176.19f, 744.93f, 171.19f, 741.27f)
            curveTo(171.85f, 738.27f, 173.29f, 730.57f, 173.69f, 723.77f)
            curveTo(174.09f, 716.97f, 175.85f, 716.6f, 176.69f, 717.27f)
            curveTo(184.69f, 725.27f, 189.02f, 736.6f, 190.19f, 741.27f)
            curveTo(190.52f, 749.6f, 190.69f, 764.87f, 188.69f, 759.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(221.19f, 755.77f)
            lineTo(221.69f, 742.27f)
            curveTo(228.49f, 719.87f, 234.19f, 716.6f, 236.19f, 717.77f)
            lineTo(238.69f, 731.77f)
            lineTo(239.69f, 742.27f)
            curveTo(236.85f, 742.77f, 230.19f, 745.67f, 226.19f, 753.27f)
            curveTo(222.19f, 760.87f, 221.19f, 758.1f, 221.19f, 755.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(223.69f, 725.77f)
            verticalLineTo(710.27f)
            lineTo(232.69f, 703.77f)
            curveTo(233.85f, 705.1f, 235.79f, 708.07f, 234.19f, 709.27f)
            curveTo(232.59f, 710.47f, 226.52f, 720.77f, 223.69f, 725.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(187.19f, 725.77f)
            lineTo(176.69f, 708.27f)
            curveTo(176.29f, 705.87f, 178.52f, 704.27f, 179.69f, 703.77f)
            lineTo(187.69f, 710.77f)
            curveTo(188.89f, 717.97f, 187.85f, 723.77f, 187.19f, 725.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(185.19f, 690.27f)
            curveTo(193.02f, 662.93f, 204.69f, 601.87f, 188.69f, 576.27f)
            curveTo(182.35f, 581.93f, 172.79f, 612.67f, 185.19f, 690.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(177.69f, 663.77f)
            curveTo(177.69f, 622.57f, 162.69f, 576.6f, 155.19f, 558.77f)
            lineTo(154.19f, 576.27f)
            curveTo(155.19f, 583.77f, 158.59f, 602.57f, 164.19f, 617.77f)
            curveTo(169.79f, 632.97f, 172.85f, 654.77f, 173.69f, 663.77f)
            curveTo(176.19f, 675.27f, 177.69f, 677.77f, 180.19f, 693.27f)
            curveTo(182.19f, 705.67f, 184.35f, 704.1f, 185.19f, 701.77f)
            curveTo(181.99f, 696.17f, 178.85f, 674.1f, 177.69f, 663.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(166.19f, 635.27f)
            curveTo(166.19f, 632.07f, 156.85f, 598.93f, 152.19f, 582.77f)
            curveTo(150.36f, 591.97f, 152.76f, 609.93f, 154.19f, 617.77f)
            lineTo(159.19f, 638.27f)
            lineTo(167.19f, 667.27f)
            curveTo(168.69f, 673.43f, 172.39f, 687.57f, 175.19f, 694.77f)
            curveTo(178.69f, 703.77f, 179.19f, 696.27f, 177.69f, 694.77f)
            curveTo(176.49f, 693.57f, 172.52f, 672.6f, 170.69f, 662.27f)
            curveTo(169.19f, 654.6f, 166.19f, 638.47f, 166.19f, 635.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(223.19f, 574.27f)
            curveTo(229.19f, 586.27f, 238.29f, 626.27f, 226.69f, 690.27f)
            curveTo(219.02f, 665.43f, 207.59f, 607.47f, 223.19f, 574.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(244.69f, 629.27f)
            curveTo(256.69f, 595.97f, 257.35f, 568.4f, 256.19f, 558.77f)
            curveTo(251.02f, 571.77f, 240.19f, 605.07f, 238.19f, 634.27f)
            curveTo(236.19f, 663.47f, 230.02f, 688.43f, 227.19f, 697.27f)
            curveTo(226.79f, 704.87f, 229.02f, 703.43f, 230.19f, 701.77f)
            lineTo(244.69f, 629.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(258.69f, 617.77f)
            lineTo(260.19f, 583.27f)
            lineTo(249.19f, 622.77f)
            curveTo(246.85f, 631.43f, 242.19f, 650.87f, 242.19f, 659.27f)
            curveTo(242.19f, 667.67f, 236.52f, 685.43f, 233.69f, 693.27f)
            lineTo(234.69f, 697.27f)
            curveTo(238.02f, 690.77f, 244.69f, 675.47f, 244.69f, 666.27f)
            curveTo(244.69f, 657.07f, 254.02f, 630.1f, 258.69f, 617.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(234.69f, 582.77f)
            curveTo(235.89f, 577.57f, 229.52f, 544.27f, 226.19f, 528.27f)
            lineTo(224.69f, 552.27f)
            curveTo(227.52f, 564.6f, 233.49f, 587.97f, 234.69f, 582.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(185.19f, 538.27f)
            curveTo(180.79f, 547.47f, 177.69f, 571.77f, 176.69f, 582.77f)
            curveTo(189.49f, 554.77f, 187.69f, 534.77f, 185.19f, 528.27f)
            verticalLineTo(538.27f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(251.77f, 521f)
            curveTo(261.44f, 491f, 278.58f, 424.6f, 269.77f, 399f)
            curveTo(259.61f, 437f, 241.77f, 514.6f, 251.77f, 521f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(234.77f, 428.5f)
            curveTo(229.18f, 437.7f, 235.44f, 491.67f, 239.27f, 517.5f)
            curveTo(241.27f, 518.17f, 245.46f, 519.11f, 245.46f, 511.73f)
            curveTo(245.46f, 504.47f, 247.23f, 487f, 248.96f, 478.5f)
            curveTo(259.46f, 427f, 271.96f, 386.73f, 263.27f, 340.5f)
            curveTo(256.11f, 366f, 240.38f, 419.3f, 234.77f, 428.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(231.96f, 478.5f)
            curveTo(233.59f, 501.86f, 235.96f, 514.5f, 230.77f, 519.27f)
            curveTo(221.57f, 525.27f, 218.94f, 499f, 219.27f, 483.5f)
            curveTo(220.61f, 477.33f, 220.56f, 467.03f, 222.96f, 456.23f)
            curveTo(225.36f, 445.43f, 229.61f, 441.67f, 229.77f, 443.5f)
            curveTo(230.93f, 456.23f, 230.46f, 457f, 231.96f, 478.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(230.5f, 431.5f)
            curveTo(243.7f, 408.3f, 261.5f, 338f, 255.77f, 338f)
            curveTo(254f, 338f, 243.19f, 355.5f, 237f, 371f)
            curveTo(230.66f, 386.88f, 218.64f, 424.17f, 216.5f, 438f)
            curveTo(215.83f, 452.83f, 214.37f, 462.02f, 218f, 459f)
            curveTo(224f, 454f, 223.5f, 440.5f, 230.5f, 431.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(159.08f, 521f)
            curveTo(149.41f, 491f, 132.28f, 424.6f, 141.08f, 399f)
            curveTo(151.24f, 437f, 169.08f, 514.6f, 159.08f, 521f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(176.08f, 428.5f)
            curveTo(181.68f, 437.7f, 175.41f, 491.67f, 171.58f, 517.5f)
            curveTo(169.58f, 518.17f, 165.39f, 519.11f, 165.39f, 511.73f)
            curveTo(165.39f, 504.47f, 163.62f, 487f, 161.89f, 478.5f)
            curveTo(151.39f, 427f, 138.89f, 386.73f, 147.58f, 340.5f)
            curveTo(154.74f, 366f, 170.48f, 419.3f, 176.08f, 428.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(178.89f, 478.5f)
            curveTo(177.26f, 501.86f, 174.89f, 514.5f, 180.08f, 519.27f)
            curveTo(189.28f, 525.27f, 191.91f, 499f, 191.58f, 483.5f)
            curveTo(190.24f, 477.33f, 190.29f, 467.03f, 187.89f, 456.23f)
            curveTo(185.49f, 445.43f, 181.24f, 441.67f, 181.08f, 443.5f)
            curveTo(179.92f, 456.23f, 180.39f, 457f, 178.89f, 478.5f)
            close()
        }
        path(fill = SolidColor(quadriceps)) {
            moveTo(180.35f, 431.5f)
            curveTo(167.15f, 408.3f, 149.35f, 338f, 155.08f, 338f)
            curveTo(156.85f, 338f, 167.67f, 355.5f, 173.85f, 371f)
            curveTo(180.19f, 386.88f, 192.22f, 424.17f, 194.35f, 438f)
            curveTo(195.02f, 452.83f, 196.48f, 462.02f, 192.85f, 459f)
            curveTo(186.85f, 454f, 187.35f, 440.5f, 180.35f, 431.5f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(181.69f, 374.77f)
            lineTo(163.69f, 340.27f)
            curveTo(168.89f, 342.27f, 188.19f, 361.1f, 197.19f, 370.27f)
            curveTo(189.99f, 389.07f, 186.19f, 392.43f, 185.19f, 391.77f)
            curveTo(184.19f, 391.1f, 181.69f, 374.77f, 181.69f, 374.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(248.19f, 340.27f)
            lineTo(214.69f, 368.77f)
            curveTo(218.52f, 379.43f, 226.29f, 398.97f, 226.69f, 391.77f)
            curveTo(227.19f, 382.77f, 229.69f, 374.77f, 230.69f, 374.77f)
            curveTo(231.49f, 374.77f, 242.69f, 351.77f, 248.19f, 340.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(220.69f, 406.77f)
            curveTo(224.69f, 399.97f, 214.69f, 381.27f, 209.19f, 372.77f)
            curveTo(209.19f, 381.77f, 209.69f, 402.37f, 211.69f, 412.77f)
            curveTo(213.69f, 423.17f, 216.85f, 425.43f, 218.19f, 425.27f)
            curveTo(217.35f, 421.93f, 216.69f, 413.57f, 220.69f, 406.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(195.19f, 424.77f)
            curveTo(200.79f, 419.17f, 202.52f, 387.93f, 202.19f, 372.77f)
            curveTo(191.69f, 394.77f, 187.19f, 400.27f, 191.19f, 406.77f)
            curveTo(194.39f, 411.97f, 193.85f, 417.93f, 193.19f, 420.27f)
            curveTo(193.99f, 426.27f, 194.85f, 425.77f, 195.19f, 424.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(174.69f, 552.27f)
            lineTo(167.19f, 534.77f)
            verticalLineTo(530.77f)
            curveTo(175.19f, 523.97f, 179.52f, 529.93f, 180.69f, 533.77f)
            lineTo(174.69f, 552.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(165.69f, 543.27f)
            lineTo(155.19f, 517.77f)
            curveTo(155.19f, 526.97f, 156.85f, 542.93f, 157.69f, 549.77f)
            curveTo(167.69f, 556.17f, 169.19f, 555.77f, 168.69f, 554.77f)
            lineTo(165.69f, 543.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(237.69f, 552.27f)
            lineTo(245.19f, 534.77f)
            verticalLineTo(530.77f)
            curveTo(237.19f, 523.97f, 232.85f, 529.93f, 231.69f, 533.77f)
            lineTo(237.69f, 552.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(246.69f, 543.27f)
            lineTo(257.19f, 517.77f)
            curveTo(257.19f, 526.97f, 255.52f, 542.93f, 254.69f, 549.77f)
            curveTo(244.69f, 556.17f, 243.19f, 555.77f, 243.69f, 554.77f)
            lineTo(246.69f, 543.27f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(174.69f, 291.77f)
            curveTo(174.29f, 320.17f, 185.52f, 347.6f, 191.19f, 357.77f)
            curveTo(196.39f, 361.77f, 199.35f, 357.77f, 200.19f, 355.27f)
            lineTo(198.69f, 302.77f)
            curveTo(193.89f, 289.57f, 180.69f, 289.93f, 174.69f, 291.77f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(172.69f, 281.27f)
            verticalLineTo(268.27f)
            curveTo(189.89f, 257.07f, 198.19f, 262.6f, 200.19f, 266.77f)
            curveTo(200.69f, 274.27f, 201.39f, 288.97f, 200.19f, 287.77f)
            curveTo(198.99f, 286.57f, 192.02f, 284.6f, 188.69f, 283.77f)
            curveTo(178.29f, 284.17f, 173.69f, 282.27f, 172.69f, 281.27f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(173.69f, 256.77f)
            lineTo(172.69f, 245.77f)
            curveTo(181.09f, 230.17f, 195.19f, 230.93f, 201.19f, 233.27f)
            curveTo(201.19f, 238.47f, 199.52f, 249.77f, 198.69f, 254.77f)
            curveTo(184.29f, 253.17f, 176.02f, 255.43f, 173.69f, 256.77f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(188.69f, 209.27f)
            curveTo(173.89f, 212.07f, 171.85f, 226.43f, 172.69f, 233.27f)
            curveTo(182.29f, 224.87f, 195.02f, 223.77f, 200.19f, 224.27f)
            curveTo(201.02f, 219.93f, 202.19f, 210.87f, 200.19f, 209.27f)
            curveTo(198.19f, 207.67f, 191.69f, 208.6f, 188.69f, 209.27f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(156.69f, 271.27f)
            curveTo(154.69f, 276.07f, 155.85f, 310.43f, 156.69f, 327.77f)
            curveTo(157.89f, 330.17f, 164.85f, 332.43f, 168.19f, 333.27f)
            lineTo(169.69f, 327.77f)
            lineTo(166.19f, 278.77f)
            curveTo(163.85f, 273.77f, 158.69f, 266.47f, 156.69f, 271.27f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(162.69f, 251.77f)
            lineTo(162.19f, 262.77f)
            curveTo(158.99f, 264.37f, 153.19f, 258.1f, 150.69f, 254.77f)
            curveTo(149.02f, 247.93f, 146.29f, 235.27f, 148.69f, 239.27f)
            curveTo(151.09f, 243.27f, 159.02f, 249.27f, 162.69f, 251.77f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(159.19f, 241.77f)
            lineTo(149.69f, 229.27f)
            verticalLineTo(224.77f)
            curveTo(152.09f, 223.97f, 158.69f, 228.77f, 161.69f, 231.27f)
            curveTo(161.69f, 233.43f, 161.59f, 238.37f, 161.19f, 240.77f)
            curveTo(160.79f, 243.17f, 159.69f, 242.43f, 159.19f, 241.77f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(159.19f, 224.77f)
            lineTo(150.19f, 214.27f)
            curveTo(149.19f, 211.27f, 151.69f, 211.77f, 154.69f, 211.77f)
            curveTo(157.09f, 211.77f, 161.35f, 214.1f, 163.19f, 215.27f)
            curveTo(163.85f, 216.6f, 165.09f, 220.07f, 164.69f, 223.27f)
            curveTo(164.29f, 226.47f, 160.85f, 225.6f, 159.19f, 224.77f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(163.69f, 210.27f)
            lineTo(149.69f, 200.27f)
            curveTo(148.69f, 196.27f, 152.69f, 197.27f, 155.69f, 197.77f)
            curveTo(158.09f, 198.17f, 164.35f, 200.6f, 167.19f, 201.77f)
            curveTo(168.19f, 201.93f, 169.89f, 203.17f, 168.69f, 206.77f)
            curveTo(167.49f, 210.37f, 164.85f, 210.6f, 163.69f, 210.27f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(237.29f, 292.26f)
            curveTo(237.69f, 320.65f, 226.46f, 348.09f, 220.79f, 358.26f)
            curveTo(215.59f, 362.26f, 212.62f, 358.26f, 211.79f, 355.76f)
            lineTo(213.29f, 303.26f)
            curveTo(218.09f, 290.05f, 231.29f, 290.42f, 237.29f, 292.26f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(239.29f, 281.76f)
            verticalLineTo(268.76f)
            curveTo(222.09f, 257.55f, 213.79f, 263.09f, 211.79f, 267.26f)
            curveTo(211.29f, 274.76f, 210.59f, 289.45f, 211.79f, 288.26f)
            curveTo(212.99f, 287.05f, 219.96f, 285.09f, 223.29f, 284.26f)
            curveTo(233.69f, 284.65f, 238.29f, 282.76f, 239.29f, 281.76f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(238.29f, 257.26f)
            lineTo(239.29f, 246.26f)
            curveTo(230.89f, 230.65f, 216.79f, 231.42f, 210.79f, 233.76f)
            curveTo(210.79f, 238.96f, 212.46f, 250.26f, 213.29f, 255.26f)
            curveTo(227.69f, 253.65f, 235.96f, 255.92f, 238.29f, 257.26f)
            close()
        }
        path(fill = SolidColor(rectusAbdominis)) {
            moveTo(223.29f, 209.76f)
            curveTo(238.09f, 212.55f, 240.12f, 226.92f, 239.29f, 233.76f)
            curveTo(229.69f, 225.35f, 216.96f, 224.26f, 211.79f, 224.76f)
            curveTo(210.96f, 220.42f, 209.79f, 211.35f, 211.79f, 209.76f)
            curveTo(213.79f, 208.15f, 220.29f, 209.09f, 223.29f, 209.76f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(255.29f, 271.76f)
            curveTo(257.29f, 276.55f, 256.12f, 310.92f, 255.29f, 328.26f)
            curveTo(254.09f, 330.65f, 247.12f, 332.92f, 243.79f, 333.76f)
            lineTo(242.29f, 328.26f)
            lineTo(245.79f, 279.26f)
            curveTo(248.12f, 274.26f, 253.29f, 266.95f, 255.29f, 271.76f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(249.29f, 252.26f)
            lineTo(249.79f, 263.26f)
            curveTo(252.99f, 264.86f, 258.79f, 258.59f, 261.29f, 255.26f)
            curveTo(262.96f, 248.42f, 265.69f, 235.76f, 263.29f, 239.76f)
            curveTo(260.89f, 243.76f, 252.96f, 249.76f, 249.29f, 252.26f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(252.79f, 242.26f)
            lineTo(262.29f, 229.76f)
            verticalLineTo(225.26f)
            curveTo(259.89f, 224.46f, 253.29f, 229.26f, 250.29f, 231.76f)
            curveTo(250.29f, 233.92f, 250.39f, 238.85f, 250.79f, 241.26f)
            curveTo(251.19f, 243.65f, 252.29f, 242.92f, 252.79f, 242.26f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(252.79f, 225.26f)
            lineTo(261.79f, 214.76f)
            curveTo(262.79f, 211.76f, 260.29f, 212.26f, 257.29f, 212.26f)
            curveTo(254.89f, 212.26f, 250.62f, 214.59f, 248.79f, 215.76f)
            curveTo(248.12f, 217.09f, 246.89f, 220.55f, 247.29f, 223.76f)
            curveTo(247.69f, 226.96f, 251.12f, 226.09f, 252.79f, 225.26f)
            close()
        }
        path(fill = SolidColor(obliquesAbdominis)) {
            moveTo(248.29f, 210.76f)
            lineTo(262.29f, 200.76f)
            curveTo(263.29f, 196.76f, 259.29f, 197.76f, 256.29f, 198.26f)
            curveTo(253.89f, 198.65f, 247.62f, 201.09f, 244.79f, 202.26f)
            curveTo(243.79f, 202.42f, 242.09f, 203.65f, 243.29f, 207.26f)
            curveTo(244.49f, 210.85f, 247.12f, 211.09f, 248.29f, 210.76f)
            close()
        }
        path(fill = SolidColor(lateralDeltoid)) {
            moveTo(137.69f, 132.77f)
            curveTo(108.49f, 130.77f, 105.52f, 160.27f, 107.69f, 175.27f)
            lineTo(108.69f, 176.77f)
            curveTo(109.49f, 163.57f, 128.35f, 141.93f, 137.69f, 132.77f)
            close()
        }
        path(fill = SolidColor(anteriorDeltoid)) {
            moveTo(113.19f, 180.77f)
            curveTo(116.69f, 167.6f, 129.69f, 140.17f, 153.69f, 135.77f)
            curveTo(151.35f, 148.93f, 139.99f, 176.37f, 113.19f, 180.77f)
            close()
        }
        path(fill = SolidColor(lateralDeltoid)) {
            moveTo(273.69f, 132.86f)
            curveTo(302.89f, 130.86f, 305.85f, 160.36f, 303.69f, 175.36f)
            lineTo(302.69f, 176.86f)
            curveTo(301.89f, 163.66f, 283.02f, 142.03f, 273.69f, 132.86f)
            close()
        }
        path(fill = SolidColor(anteriorDeltoid)) {
            moveTo(298.19f, 180.86f)
            curveTo(294.69f, 167.7f, 281.69f, 140.26f, 257.69f, 135.86f)
            curveTo(260.02f, 149.03f, 271.39f, 176.46f, 298.19f, 180.86f)
            close()
        }
        path(fill = SolidColor(biceps)) {
            moveTo(311.19f, 251.27f)
            curveTo(276.79f, 226.07f, 277.19f, 196.43f, 281.69f, 184.77f)
            curveTo(304.69f, 181.77f, 313.19f, 205.27f, 313.19f, 214.27f)
            curveTo(313.19f, 221.47f, 314.19f, 232.27f, 314.69f, 236.77f)
            curveTo(317.49f, 248.77f, 313.52f, 251.43f, 311.19f, 251.27f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(346.69f, 311.77f)
            curveTo(336.29f, 273.37f, 321.02f, 259.1f, 314.69f, 256.77f)
            curveTo(313.89f, 261.17f, 315.69f, 270.6f, 316.69f, 274.77f)
            curveTo(320.85f, 283.43f, 330.09f, 301.37f, 333.69f, 303.77f)
            curveTo(338.19f, 306.77f, 358.19f, 343.27f, 359.69f, 346.27f)
            curveTo(360.89f, 348.67f, 361.19f, 347.27f, 361.19f, 346.27f)
            lineTo(346.69f, 311.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(299.69f, 281.77f)
            verticalLineTo(268.77f)
            curveTo(300.49f, 266.37f, 302.35f, 267.43f, 303.19f, 268.27f)
            curveTo(309.19f, 274.77f, 319.19f, 286.77f, 321.69f, 291.77f)
            curveTo(323.69f, 295.77f, 321.19f, 295.43f, 319.69f, 294.77f)
            curveTo(314.85f, 291.6f, 304.59f, 285.17f, 302.19f, 284.77f)
            curveTo(299.79f, 284.37f, 299.52f, 282.6f, 299.69f, 281.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(355.69f, 347.77f)
            curveTo(353.29f, 344.57f, 328.02f, 313.1f, 315.69f, 297.77f)
            curveTo(315.02f, 296.77f, 315.69f, 296.07f, 323.69f, 301.27f)
            curveTo(331.69f, 306.47f, 348.35f, 332.43f, 355.69f, 344.77f)
            curveTo(356.69f, 347.1f, 358.09f, 350.97f, 355.69f, 347.77f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(351.69f, 346.27f)
            curveTo(333.69f, 331.87f, 314.52f, 306.27f, 307.19f, 295.27f)
            curveTo(305.19f, 294.07f, 306.35f, 297.43f, 307.19f, 299.27f)
            curveTo(319.69f, 323.27f, 346.69f, 344.77f, 350.19f, 346.77f)
            curveTo(352.99f, 348.37f, 352.35f, 347.1f, 351.69f, 346.27f)
            close()
        }
        path(fill = SolidColor(biceps)) {
            moveTo(101.69f, 250.53f)
            curveTo(136.09f, 225.33f, 135.69f, 195.7f, 131.19f, 184.03f)
            curveTo(108.19f, 181.03f, 99.69f, 204.53f, 99.69f, 213.53f)
            curveTo(99.69f, 220.73f, 98.69f, 231.53f, 98.19f, 236.03f)
            curveTo(95.39f, 248.03f, 99.35f, 250.7f, 101.69f, 250.53f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(66.19f, 311.03f)
            curveTo(76.59f, 272.63f, 91.85f, 258.36f, 98.19f, 256.03f)
            curveTo(98.99f, 260.43f, 97.19f, 269.86f, 96.19f, 274.03f)
            curveTo(92.02f, 282.7f, 82.79f, 300.63f, 79.19f, 303.03f)
            curveTo(74.69f, 306.03f, 54.69f, 342.53f, 53.19f, 345.53f)
            curveTo(51.99f, 347.93f, 51.69f, 346.53f, 51.69f, 345.53f)
            lineTo(66.19f, 311.03f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(113.19f, 281.03f)
            verticalLineTo(268.03f)
            curveTo(112.39f, 265.63f, 110.52f, 266.7f, 109.69f, 267.53f)
            curveTo(103.69f, 274.03f, 93.69f, 286.03f, 91.19f, 291.03f)
            curveTo(89.19f, 295.03f, 91.69f, 294.7f, 93.19f, 294.03f)
            curveTo(98.02f, 290.86f, 108.29f, 284.43f, 110.69f, 284.03f)
            curveTo(113.09f, 283.63f, 113.35f, 281.86f, 113.19f, 281.03f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(57.19f, 347.03f)
            curveTo(59.59f, 343.83f, 84.85f, 312.36f, 97.19f, 297.03f)
            curveTo(97.85f, 296.03f, 97.19f, 295.33f, 89.19f, 300.53f)
            curveTo(81.19f, 305.73f, 64.52f, 331.7f, 57.19f, 344.03f)
            curveTo(56.19f, 346.36f, 54.79f, 350.23f, 57.19f, 347.03f)
            close()
        }
        path(fill = SolidColor(forearm)) {
            moveTo(61.19f, 345.53f)
            curveTo(79.19f, 331.13f, 98.35f, 305.53f, 105.69f, 294.53f)
            curveTo(107.69f, 293.33f, 106.52f, 296.7f, 105.69f, 298.53f)
            curveTo(93.19f, 322.53f, 66.19f, 344.03f, 62.69f, 346.03f)
            curveTo(59.89f, 347.63f, 60.52f, 346.36f, 61.19f, 345.53f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(40.19f, 396.27f)
            lineTo(28.19f, 383.27f)
            curveTo(26.59f, 382.07f, 26.52f, 380.1f, 26.69f, 379.27f)
            lineTo(33.69f, 368.27f)
            curveTo(39.52f, 361.27f, 51.79f, 349.87f, 54.19f, 360.27f)
            curveTo(57.19f, 373.27f, 49.19f, 388.27f, 47.19f, 394.27f)
            curveTo(45.59f, 399.07f, 41.85f, 397.6f, 40.19f, 396.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(35.69f, 362.27f)
            curveTo(18.09f, 376.27f, 6.69f, 378.77f, 3.19f, 378.27f)
            curveTo(2.79f, 377.07f, 3.69f, 376.43f, 4.19f, 376.27f)
            lineTo(31.69f, 358.27f)
            curveTo(37.69f, 356.67f, 36.85f, 360.27f, 35.69f, 362.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(11.69f, 410.27f)
            lineTo(22.69f, 386.27f)
            curveTo(24.02f, 385.93f, 26.69f, 385.87f, 26.69f, 388.27f)
            curveTo(26.69f, 391.27f, 16.69f, 408.27f, 14.19f, 413.77f)
            curveTo(12.19f, 418.17f, 11.69f, 413.27f, 11.69f, 410.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(30.19f, 398.77f)
            curveTo(31.79f, 392.77f, 29.19f, 393.6f, 27.69f, 394.77f)
            curveTo(26.92f, 395.27f, 17.69f, 418.27f, 16.69f, 421.77f)
            curveTo(15.89f, 424.57f, 18.35f, 424.93f, 19.69f, 424.77f)
            curveTo(22.52f, 418.6f, 28.59f, 404.77f, 30.19f, 398.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.69f, 403.77f)
            curveTo(37.89f, 400.97f, 35.52f, 399.6f, 34.19f, 399.27f)
            lineTo(32.69f, 400.27f)
            curveTo(30.19f, 405.77f, 25.09f, 417.57f, 24.69f, 420.77f)
            curveTo(24.29f, 423.97f, 26.85f, 423.77f, 28.19f, 423.27f)
            curveTo(30.52f, 417.93f, 35.49f, 406.57f, 36.69f, 403.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(36.69f, 413.27f)
            lineTo(42.69f, 401.77f)
            curveTo(45.49f, 400.17f, 45.52f, 403.43f, 45.19f, 405.27f)
            curveTo(44.35f, 407.43f, 42.09f, 412.67f, 39.69f, 416.27f)
            curveTo(37.29f, 419.87f, 36.69f, 415.77f, 36.69f, 413.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(129.19f, 230.77f)
            curveTo(123.99f, 240.77f, 109.69f, 253.93f, 103.19f, 259.27f)
            curveTo(103.19f, 262.07f, 105.52f, 261.43f, 106.69f, 260.77f)
            curveTo(113.02f, 256.6f, 126.39f, 246.47f, 129.19f, 239.27f)
            curveTo(131.99f, 232.07f, 130.35f, 230.6f, 129.19f, 230.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(372.35f, 396.95f)
            lineTo(384.35f, 383.95f)
            curveTo(385.95f, 382.75f, 386.02f, 380.79f, 385.85f, 379.95f)
            lineTo(378.85f, 368.95f)
            curveTo(373.02f, 361.95f, 360.75f, 350.55f, 358.35f, 360.95f)
            curveTo(355.35f, 373.95f, 363.35f, 388.95f, 365.35f, 394.95f)
            curveTo(366.95f, 399.75f, 370.69f, 398.29f, 372.35f, 396.95f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(376.85f, 362.95f)
            curveTo(394.45f, 376.95f, 405.85f, 379.45f, 409.35f, 378.95f)
            curveTo(409.75f, 377.75f, 408.85f, 377.12f, 408.35f, 376.95f)
            lineTo(380.85f, 358.95f)
            curveTo(374.85f, 357.35f, 375.69f, 360.95f, 376.85f, 362.95f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(400.85f, 410.95f)
            lineTo(389.85f, 386.95f)
            curveTo(388.52f, 386.62f, 385.85f, 386.55f, 385.85f, 388.95f)
            curveTo(385.85f, 391.95f, 395.85f, 408.95f, 398.35f, 414.45f)
            curveTo(400.35f, 418.85f, 400.85f, 413.95f, 400.85f, 410.95f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(382.35f, 399.45f)
            curveTo(380.75f, 393.45f, 383.35f, 394.29f, 384.85f, 395.45f)
            curveTo(385.62f, 395.95f, 394.85f, 418.95f, 395.85f, 422.45f)
            curveTo(396.65f, 425.25f, 394.19f, 425.62f, 392.85f, 425.45f)
            curveTo(390.02f, 419.29f, 383.95f, 405.45f, 382.35f, 399.45f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(375.85f, 404.45f)
            curveTo(374.65f, 401.65f, 377.02f, 400.29f, 378.35f, 399.95f)
            lineTo(379.85f, 400.95f)
            curveTo(382.35f, 406.45f, 387.45f, 418.25f, 387.85f, 421.45f)
            curveTo(388.25f, 424.65f, 385.69f, 424.45f, 384.35f, 423.95f)
            curveTo(382.02f, 418.62f, 377.05f, 407.25f, 375.85f, 404.45f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(375.85f, 413.95f)
            lineTo(369.85f, 402.45f)
            curveTo(367.05f, 400.85f, 367.02f, 404.12f, 367.35f, 405.95f)
            curveTo(368.19f, 408.12f, 370.45f, 413.35f, 372.85f, 416.95f)
            curveTo(375.25f, 420.55f, 375.85f, 416.45f, 375.85f, 413.95f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(308.19f, 259.27f)
            curveTo(301.39f, 255.67f, 288.69f, 239.1f, 283.19f, 231.27f)
            curveTo(279.99f, 228.07f, 280.52f, 233.27f, 281.19f, 236.27f)
            curveTo(283.99f, 243.87f, 298.69f, 255.77f, 305.69f, 260.77f)
            curveTo(308.49f, 261.97f, 308.52f, 260.27f, 308.19f, 259.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(139.19f, 222.27f)
            lineTo(137.69f, 195.77f)
            curveTo(137.19f, 193.43f, 137.09f, 190.17f, 140.69f, 195.77f)
            curveTo(144.29f, 201.37f, 146.19f, 211.77f, 146.69f, 216.27f)
            curveTo(146.69f, 223.27f, 146.19f, 236.77f, 144.19f, 234.77f)
            curveTo(142.19f, 232.77f, 140.02f, 225.6f, 139.19f, 222.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(200.19f, 143.27f)
            lineTo(184.69f, 112.77f)
            curveTo(184.29f, 101.57f, 185.19f, 98.77f, 185.69f, 98.77f)
            curveTo(188.49f, 101.57f, 197.85f, 122.27f, 202.19f, 132.27f)
            curveTo(202.59f, 140.27f, 201.02f, 142.93f, 200.19f, 143.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(184.19f, 124.77f)
            lineTo(178.69f, 132.27f)
            curveTo(183.09f, 135.87f, 186.52f, 134.43f, 187.69f, 133.27f)
            lineTo(184.19f, 124.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(179.69f, 119.27f)
            lineTo(167.19f, 131.27f)
            curveTo(163.69f, 131.27f, 155.99f, 131.17f, 153.19f, 130.77f)
            curveTo(150.39f, 130.37f, 151.35f, 128.93f, 152.19f, 128.27f)
            curveTo(158.19f, 124.43f, 171.59f, 116.37f, 177.19f, 114.77f)
            curveTo(182.79f, 113.17f, 181.19f, 117.1f, 179.69f, 119.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(206.19f, 129.77f)
            lineTo(198.69f, 105.77f)
            horizontalLineTo(214.69f)
            lineTo(206.19f, 129.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(209.19f, 132.27f)
            curveTo(210.39f, 128.27f, 220.83f, 108.27f, 225.9f, 98.77f)
            curveTo(227.27f, 97.57f, 226.33f, 108.93f, 225.69f, 114.77f)
            lineTo(209.69f, 143.27f)
            curveTo(209.02f, 141.27f, 207.99f, 136.27f, 209.19f, 132.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(221.69f, 133.27f)
            lineTo(226.19f, 124.77f)
            curveTo(229.39f, 127.17f, 230.52f, 131.43f, 230.69f, 133.27f)
            curveTo(229.09f, 135.27f, 224.02f, 134.1f, 221.69f, 133.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(241.69f, 130.27f)
            lineTo(228.69f, 118.27f)
            curveTo(227.49f, 113.07f, 232.52f, 114.43f, 235.19f, 115.77f)
            curveTo(243.52f, 119.6f, 259.84f, 127.77f, 258.46f, 129.77f)
            curveTo(257.09f, 131.77f, 246.71f, 130.93f, 241.69f, 130.27f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(265.69f, 232.77f)
            verticalLineTo(211.77f)
            lineTo(274.69f, 191.77f)
            lineTo(274.19f, 213.27f)
            curveTo(273.85f, 216.77f, 272.59f, 225.47f, 270.19f, 232.27f)
            curveTo(267.79f, 239.07f, 266.19f, 235.43f, 265.69f, 232.77f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorSternocostal)) {
            moveTo(202.19f, 196f)
            curveTo(185.5f, 206.5f, 164f, 179.5f, 143f, 176.5f)
            curveTo(168.09f, 147.82f, 191.32f, 157.62f, 202.05f, 162.15f)
            lineTo(202.19f, 162.21f)
            verticalLineTo(196f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorAbdominal)) {
            moveTo(142.5f, 178f)
            curveTo(146f, 197f, 172.5f, 203.5f, 186f, 198.5f)
            curveTo(167.5f, 192.5f, 158f, 182f, 142.5f, 178f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorClavicular)) {
            moveTo(202.19f, 150.71f)
            curveTo(168.59f, 121.51f, 149.33f, 150.5f, 142f, 173f)
            verticalLineTo(175f)
            curveTo(165.6f, 145.4f, 190.35f, 155.54f, 202.19f, 160.21f)
            verticalLineTo(150.71f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorSternocostal)) {
            moveTo(209f, 196f)
            curveTo(225.69f, 206.5f, 247.19f, 179.5f, 268.19f, 176.5f)
            curveTo(243.09f, 147.82f, 219.87f, 157.62f, 209.14f, 162.15f)
            lineTo(209f, 162.21f)
            verticalLineTo(196f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorAbdominal)) {
            moveTo(268.69f, 178f)
            curveTo(265.19f, 197f, 238.69f, 203.5f, 225.19f, 198.5f)
            curveTo(243.69f, 192.5f, 253.19f, 182f, 268.69f, 178f)
            close()
        }
        path(fill = SolidColor(pectoralisMajorClavicular)) {
            moveTo(209f, 150.71f)
            curveTo(242.6f, 121.51f, 261.85f, 150.5f, 269.19f, 173f)
            verticalLineTo(175f)
            curveTo(245.59f, 145.4f, 220.83f, 155.54f, 209f, 160.21f)
            verticalLineTo(150.71f)
            close()
        }
    }.build()
}