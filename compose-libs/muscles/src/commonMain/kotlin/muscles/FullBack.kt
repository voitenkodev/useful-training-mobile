package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public fun fullBack(
    outlineColor: Color = Colors.outline,

    rhomboids: Color = Colors.defaultBack,
    latissimus: Color = Colors.defaultBack,
    triceps: Color = Colors.defaultBack,
    trapezius: Color = Colors.defaultBack,
    forearm: Color = Colors.defaultBack,

    teresMajor: Color = Colors.defaultBack,
    posteriorDeltoid: Color = Colors.defaultBack,

    gluteal: Color = Colors.defaultBack,
    hamstrings: Color = Colors.defaultBack,
    calf: Color = Colors.defaultBack,

    adductors: Color = Colors.defaultBack,
    abductors: Color = Colors.defaultBack,

    other: Color = Colors.defaultBack,

    backgroundBack: Color = Colors.backgroundBack
): ImageVector {
    return ImageVector.Builder(
        name = "Fullback",
        defaultWidth = 411.dp,
        defaultHeight = 774.dp,
        viewportWidth = 411f,
        viewportHeight = 774f
    ).apply {
        path(
            stroke = SolidColor(outlineColor),
            fill = SolidColor(backgroundBack),
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
            curveTo(144.59f, 324.97f, 144.25f, 338.1f, 145.09f, 342.77f)
            lineTo(141.09f, 368.77f)
            curveTo(140.42f, 388.6f, 138.99f, 433.47f, 138.59f, 454.27f)
            curveTo(138.18f, 475.07f, 147.09f, 511.6f, 151.59f, 527.27f)
            curveTo(150.79f, 530.87f, 152.92f, 540.77f, 154.09f, 545.27f)
            curveTo(153.09f, 552.93f, 150.49f, 571.67f, 148.09f, 585.27f)
            curveTo(145.09f, 602.27f, 154.59f, 635.27f, 155.09f, 636.27f)
            curveTo(155.49f, 637.07f, 161.92f, 658.6f, 165.09f, 669.27f)
            curveTo(166.75f, 677.93f, 170.49f, 696.17f, 172.09f, 699.77f)
            curveTo(173.68f, 703.37f, 172.75f, 717.27f, 172.09f, 723.77f)
            curveTo(168.49f, 726.97f, 169.25f, 733.77f, 170.09f, 736.77f)
            curveTo(169.59f, 738.6f, 168.09f, 742.37f, 166.09f, 742.77f)
            curveTo(164.09f, 743.17f, 160.25f, 751.93f, 158.59f, 756.27f)
            curveTo(156.92f, 758.6f, 152.79f, 763.67f, 149.59f, 765.27f)
            curveTo(146.38f, 766.87f, 149.25f, 770.6f, 151.09f, 772.27f)
            curveTo(160.25f, 772.93f, 180.18f, 773.97f, 186.59f, 772.77f)
            curveTo(192.99f, 771.57f, 193.92f, 767.27f, 193.59f, 765.27f)
            verticalLineTo(754.27f)
            curveTo(192.42f, 750.77f, 190.29f, 742.37f, 191.09f, 736.77f)
            curveTo(191.88f, 731.17f, 190.75f, 725.77f, 190.09f, 723.77f)
            curveTo(189.68f, 719.37f, 191.25f, 694.6f, 192.09f, 682.77f)
            curveTo(198.59f, 628.27f, 198.09f, 631.27f, 198.59f, 611.77f)
            curveTo(199.09f, 592.27f, 188.09f, 546.27f, 188.09f, 544.27f)
            curveTo(188.09f, 542.67f, 189.09f, 532.27f, 189.59f, 527.27f)
            lineTo(192.59f, 503.27f)
            curveTo(196.25f, 472.43f, 203.79f, 409.47f, 204.59f, 404.27f)
            curveTo(205.38f, 399.07f, 206.25f, 399.43f, 206.59f, 400.27f)
            lineTo(215.09f, 461.27f)
            curveTo(217.25f, 482.6f, 221.88f, 525.77f, 223.09f, 527.77f)
            curveTo(224.29f, 529.77f, 223.59f, 540.93f, 223.09f, 546.27f)
            lineTo(220.59f, 564.27f)
            lineTo(213.09f, 606.77f)
            curveTo(212.75f, 617.6f, 212.68f, 641.47f, 215.09f, 650.27f)
            curveTo(217.49f, 659.07f, 220.09f, 702.93f, 221.09f, 723.77f)
            curveTo(219.49f, 726.17f, 220.09f, 733.77f, 220.59f, 737.27f)
            curveTo(220.09f, 741.27f, 218.79f, 751.47f, 217.59f, 760.27f)
            curveTo(216.38f, 769.07f, 219.42f, 772.27f, 221.09f, 772.77f)
            curveTo(232.09f, 772.93f, 255.18f, 773.17f, 259.58f, 772.77f)
            curveTo(263.98f, 772.37f, 263.75f, 767.93f, 263.08f, 765.77f)
            curveTo(260.92f, 765.27f, 256.08f, 762.87f, 254.09f, 757.27f)
            curveTo(252.09f, 751.67f, 245.25f, 742.6f, 242.09f, 738.77f)
            verticalLineTo(735.27f)
            curveTo(242.49f, 730.07f, 240.59f, 724.77f, 239.59f, 722.77f)
            curveTo(239.42f, 719.77f, 239.18f, 711.77f, 239.59f, 703.77f)
            curveTo(239.99f, 695.77f, 247.42f, 666.43f, 251.09f, 652.77f)
            curveTo(252.59f, 650.1f, 256.79f, 639.37f, 261.58f, 617.77f)
            curveTo(266.39f, 596.17f, 260.58f, 561.1f, 257.08f, 546.27f)
            curveTo(259.48f, 542.67f, 260.08f, 534.43f, 260.08f, 530.77f)
            curveTo(264.89f, 519.17f, 270.42f, 480.27f, 272.58f, 462.27f)
            curveTo(272.25f, 442.6f, 271.29f, 395.67f, 270.08f, 365.27f)
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
        path(fill = SolidColor(other)) {
            moveTo(163.09f, 769.77f)
            curveTo(162.29f, 767.77f, 168.75f, 749.6f, 172.09f, 740.77f)
            verticalLineTo(761.77f)
            curveTo(172.75f, 763.93f, 175.18f, 767.47f, 179.59f, 764.27f)
            curveTo(185.09f, 760.27f, 181.59f, 734.77f, 186.59f, 743.27f)
            curveTo(190.59f, 750.07f, 189.92f, 763.77f, 189.09f, 769.77f)
            curveTo(180.75f, 770.6f, 163.88f, 771.77f, 163.09f, 769.77f)
            close()
        }
        path(fill = SolidColor(other)) {
            moveTo(222.59f, 769.77f)
            curveTo(220.99f, 766.97f, 224.25f, 750.93f, 226.09f, 743.27f)
            curveTo(227.09f, 751.43f, 230.38f, 767.47f, 235.59f, 766.27f)
            curveTo(240.79f, 765.07f, 239.42f, 748.77f, 238.09f, 740.77f)
            curveTo(242.49f, 743.17f, 246.92f, 761.1f, 248.59f, 769.77f)
            curveTo(240.59f, 770.93f, 224.18f, 772.57f, 222.59f, 769.77f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(166.59f, 663.77f)
            curveTo(172.59f, 674.97f, 176.09f, 712.77f, 177.09f, 730.27f)
            curveTo(181.59f, 736.27f, 180.09f, 730.27f, 180.59f, 727.77f)
            curveTo(180.99f, 725.77f, 178.42f, 695.6f, 177.09f, 680.77f)
            curveTo(175.25f, 673.43f, 170.99f, 655.47f, 168.59f, 642.27f)
            curveTo(166.18f, 629.07f, 162.92f, 631.77f, 161.59f, 634.77f)
            curveTo(160.75f, 639.77f, 160.59f, 652.57f, 166.59f, 663.77f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(187.09f, 729.27f)
            curveTo(185.88f, 734.07f, 184.59f, 730.93f, 184.09f, 728.77f)
            lineTo(186.09f, 698.77f)
            lineTo(188.09f, 664.77f)
            lineTo(189.09f, 644.27f)
            curveTo(189.92f, 640.1f, 191.88f, 632.07f, 193.09f, 633.27f)
            curveTo(194.29f, 634.47f, 193.59f, 647.1f, 193.09f, 653.27f)
            curveTo(192.25f, 660.27f, 190.49f, 674.87f, 190.09f, 677.27f)
            curveTo(189.68f, 679.67f, 188.25f, 697.27f, 187.59f, 705.77f)
            lineTo(187.09f, 729.27f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(226.09f, 729.27f)
            curveTo(225.29f, 733.27f, 224.42f, 731.6f, 224.09f, 730.27f)
            verticalLineTo(723.27f)
            curveTo(224.09f, 722.07f, 221.75f, 690.43f, 220.59f, 674.77f)
            curveTo(219.79f, 672.37f, 218.25f, 659.77f, 217.59f, 653.77f)
            lineTo(216.59f, 640.77f)
            curveTo(216.99f, 632.37f, 217.75f, 631.27f, 218.09f, 631.77f)
            lineTo(222.09f, 647.77f)
            curveTo(222.25f, 649.6f, 222.49f, 653.77f, 222.09f, 655.77f)
            curveTo(221.68f, 657.77f, 222.92f, 677.93f, 223.59f, 687.77f)
            lineTo(226.09f, 729.27f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(233.59f, 727.77f)
            curveTo(230.79f, 735.77f, 229.75f, 731.77f, 229.59f, 728.77f)
            curveTo(230.09f, 721.77f, 231.09f, 707.17f, 231.09f, 704.77f)
            curveTo(231.09f, 702.37f, 233.75f, 684.43f, 235.09f, 675.77f)
            curveTo(237.25f, 664.6f, 241.79f, 641.47f, 242.59f, 638.27f)
            curveTo(243.59f, 634.27f, 245.09f, 631.77f, 248.59f, 632.27f)
            curveTo(251.38f, 632.67f, 250.42f, 642.77f, 249.59f, 647.77f)
            curveTo(246.75f, 657.6f, 240.49f, 678.27f, 238.09f, 682.27f)
            curveTo(235.68f, 686.27f, 234.09f, 714.27f, 233.59f, 727.77f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(227.59f, 626.77f)
            curveTo(220.38f, 635.57f, 218.25f, 630.43f, 218.09f, 626.77f)
            curveTo(218.09f, 620.6f, 217.79f, 604.87f, 216.59f, 591.27f)
            curveTo(215.38f, 577.67f, 232.42f, 538.27f, 241.09f, 520.27f)
            verticalLineTo(558.27f)
            curveTo(240.09f, 565.1f, 238.09f, 582.27f, 238.09f, 596.27f)
            curveTo(238.09f, 610.27f, 236.09f, 617.1f, 235.09f, 618.77f)
            curveTo(235.59f, 617.77f, 234.79f, 617.97f, 227.59f, 626.77f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(240.09f, 618.77f)
            curveTo(245.68f, 608.37f, 245.75f, 547.77f, 245.09f, 518.77f)
            curveTo(249.88f, 511.17f, 251.75f, 515.6f, 252.09f, 518.77f)
            lineTo(256.58f, 549.27f)
            curveTo(258.25f, 562.6f, 261.58f, 590.67f, 261.58f, 596.27f)
            curveTo(261.58f, 601.87f, 251.59f, 619.93f, 246.59f, 628.27f)
            lineTo(240.09f, 618.77f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(170.09f, 551.27f)
            lineTo(171.09f, 521.27f)
            curveTo(185.09f, 542.87f, 192.25f, 575.27f, 194.09f, 588.77f)
            curveTo(194.59f, 598.77f, 195.29f, 620.37f, 194.09f, 626.77f)
            curveTo(192.88f, 633.17f, 186.92f, 630.43f, 184.09f, 628.27f)
            curveTo(180.75f, 625.1f, 174.29f, 618.27f, 175.09f, 616.27f)
            curveTo(175.88f, 614.27f, 172.09f, 572.1f, 170.09f, 551.27f)
            close()
        }
        path(fill = SolidColor(calf)) {
            moveTo(166.59f, 518.77f)
            curveTo(161.79f, 511.97f, 160.59f, 515.27f, 160.59f, 517.77f)
            lineTo(156.59f, 542.77f)
            curveTo(154.42f, 556.6f, 149.99f, 585.97f, 149.59f, 592.77f)
            curveTo(149.18f, 599.57f, 159.42f, 619.27f, 164.59f, 628.27f)
            lineTo(171.09f, 618.77f)
            curveTo(165.49f, 609.17f, 165.75f, 548.1f, 166.59f, 518.77f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(161.09f, 502.77f)
            lineTo(152.59f, 521.77f)
            lineTo(147.9f, 479.5f)
            curveTo(147.06f, 465f, 148.18f, 438.1f, 152.59f, 428.5f)
            curveTo(156.99f, 418.9f, 162.92f, 410.77f, 166.59f, 409.27f)
            curveTo(152.99f, 442.07f, 157.25f, 485.27f, 161.09f, 502.77f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(183.4f, 525.5f)
            curveTo(181.8f, 528.7f, 182.9f, 533.5f, 178.59f, 529.27f)
            curveTo(159.09f, 501.77f, 163.09f, 481.27f, 161.09f, 465.27f)
            curveTo(159.49f, 452.47f, 169.09f, 418.6f, 174.09f, 403.27f)
            curveTo(176.09f, 404.07f, 179.73f, 434.83f, 180.9f, 449f)
            curveTo(188.4f, 485.5f, 191.4f, 509.5f, 183.4f, 525.5f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(227.63f, 463.17f)
            curveTo(231.29f, 440.68f, 235.39f, 416.88f, 238.09f, 403.27f)
            curveTo(260.89f, 473.67f, 244.25f, 516.6f, 233.09f, 529.27f)
            curveTo(231.02f, 529.27f, 229.41f, 528.5f, 228.17f, 527.17f)
            curveTo(222.1f, 520.67f, 224.64f, 500.6f, 223.4f, 490f)
            curveTo(224.64f, 481.86f, 226.1f, 472.63f, 227.63f, 463.17f)
            close()
        }
        path(fill = SolidColor(hamstrings)) {
            moveTo(250.09f, 502.77f)
            curveTo(257.58f, 471f, 251.25f, 427.6f, 244.59f, 409.27f)
            curveTo(248.09f, 408.6f, 253f, 408.9f, 259.4f, 430.5f)
            curveTo(265.8f, 452.1f, 262.08f, 501.6f, 257.58f, 521.77f)
            lineTo(250.09f, 502.77f)
            close()
        }
        path(fill = SolidColor(adductors)) {
            moveTo(190.4f, 482.17f)
            curveTo(190.46f, 482.54f, 190.52f, 482.91f, 190.59f, 483.27f)
            curveTo(190.51f, 482.95f, 190.45f, 482.58f, 190.4f, 482.17f)
            curveTo(186.03f, 455.48f, 178.11f, 403.53f, 180.09f, 400.77f)
            curveTo(182.09f, 397.97f, 192.25f, 391.6f, 197.09f, 388.77f)
            curveTo(199.94f, 400.27f, 203.45f, 429.57f, 194.59f, 454.77f)
            curveTo(192.87f, 461.77f, 189.82f, 476.36f, 190.4f, 482.17f)
            close()
        }
        path(fill = SolidColor(adductors)) {
            moveTo(231.09f, 400.77f)
            lineTo(214.09f, 388.77f)
            curveTo(207.68f, 410.37f, 216.75f, 460.77f, 222.09f, 483.27f)
            curveTo(220.88f, 478.07f, 225.59f, 450.1f, 228.09f, 436.77f)
            curveTo(232.88f, 416.37f, 232.09f, 404.27f, 231.09f, 400.77f)
            close()
        }
        path(fill = SolidColor(abductors)) {
            moveTo(142.09f, 395.27f)
            curveTo(144.88f, 398.47f, 152.4f, 418.53f, 151.9f, 421.27f)
            curveTo(151.4f, 424f, 148.82f, 433.86f, 146.9f, 442f)
            curveTo(144.73f, 451.18f, 143.9f, 463f, 143.9f, 463f)
            lineTo(140.9f, 459f)
            lineTo(142.09f, 429.5f)
            verticalLineTo(395.27f)
            close()
        }
        path(fill = SolidColor(abductors)) {
            moveTo(268.73f, 395f)
            curveTo(265.93f, 398.2f, 258.42f, 418.27f, 258.92f, 421f)
            curveTo(259.42f, 423.73f, 262f, 433.6f, 263.92f, 441.73f)
            curveTo(266.09f, 450.92f, 266.92f, 462.73f, 266.92f, 462.73f)
            lineTo(269.92f, 458.73f)
            lineTo(268.73f, 429.23f)
            verticalLineTo(395f)
            close()
        }
        path(fill = SolidColor(gluteal)) {
            moveTo(151.09f, 410.27f)
            curveTo(144.29f, 396.27f, 145.92f, 369.43f, 147.59f, 357.77f)
            curveTo(159.59f, 336.27f, 198.59f, 336.27f, 201.59f, 337.77f)
            curveTo(203.99f, 338.97f, 202.59f, 361.6f, 201.59f, 372.77f)
            lineTo(194.09f, 382.77f)
            curveTo(189.09f, 385.93f, 176.59f, 393.27f, 166.59f, 397.27f)
            curveTo(156.59f, 401.27f, 152.09f, 407.6f, 151.09f, 410.27f)
            close()
        }
        path(fill = SolidColor(gluteal)) {
            moveTo(208.09f, 372.77f)
            verticalLineTo(337.77f)
            curveTo(229.09f, 335.27f, 255.59f, 345.77f, 262.08f, 357.77f)
            curveTo(267.29f, 367.37f, 261.58f, 396.77f, 258.08f, 410.27f)
            curveTo(257.75f, 408.1f, 254.09f, 402.47f, 242.09f, 397.27f)
            curveTo(230.09f, 392.07f, 219.42f, 385.43f, 215.59f, 382.77f)
            lineTo(208.09f, 372.77f)
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