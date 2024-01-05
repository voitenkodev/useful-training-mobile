package musclepickerpicker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
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

    other: Color = Colors.defaultBack,

    backgroundBack: Color = Colors.backgroundBack
): ImageVector {
    return ImageVector.Builder(
        name = "Back",
        defaultWidth = 411.dp,
        defaultHeight = 774.dp,
        viewportWidth = 411f,
        viewportHeight = 774f
    ).apply {
        path(
            fill = SolidColor(backgroundBack),
            fillAlpha = 1.0f,
            stroke = SolidColor(outlineColor),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(182.687f, 86.7665f)
            verticalLineTo(93.7665f)
            moveTo(182.687f, 93.7665f)
            verticalLineTo(104.766f)
            curveTo(178.853f, 110.933f, 163.487f, 124.466f, 132.687f, 129.266f)
            curveTo(101.887f, 134.066f, 101.187f, 172.266f, 104.687f, 190.766f)
            curveTo(94.2868f, 213.166f, 92.0202f, 241.766f, 92.1868f, 253.266f)
            curveTo(84.6868f, 260.1f, 68.5868f, 279.566f, 64.1868f, 302.766f)
            curveTo(59.7868f, 325.966f, 44.0202f, 348.433f, 36.6868f, 356.766f)
            curveTo(32.2868f, 356.766f, 29.5202f, 358.1f, 28.6868f, 358.766f)
            curveTo(20.3535f, 364.6f, 3.3868f, 376.366f, 2.1868f, 376.766f)
            curveTo(0.9868f, 377.166f, 1.0202f, 378.266f, 1.1868f, 378.766f)
            curveTo(2.7868f, 385.166f, 9.8535f, 383.433f, 13.1868f, 381.766f)
            curveTo(16.6868f, 379.1f, 23.6868f, 374.166f, 23.6868f, 375.766f)
            curveTo(23.6868f, 377.766f, 12.6868f, 405.766f, 9.1868f, 414.266f)
            curveTo(6.3868f, 421.066f, 11.3535f, 420.433f, 14.1868f, 419.266f)
            lineTo(25.1868f, 394.766f)
            curveTo(22.8535f, 399.933f, 17.2868f, 412.466f, 13.6868f, 421.266f)
            curveTo(10.0868f, 430.066f, 15.8535f, 429.6f, 19.1868f, 428.266f)
            lineTo(31.1868f, 400.266f)
            lineTo(21.1868f, 424.266f)
            curveTo(20.7868f, 431.866f, 25.6868f, 429.1f, 28.1868f, 426.766f)
            curveTo(30.6868f, 420.266f, 36.0868f, 406.466f, 37.6869f, 403.266f)
            curveTo(39.2869f, 400.066f, 39.6869f, 401.933f, 39.6868f, 403.266f)
            lineTo(34.1869f, 417.766f)
            curveTo(32.9869f, 424.166f, 36.0202f, 422.766f, 37.6869f, 421.266f)
            curveTo(44.8869f, 412.866f, 51.6869f, 390.433f, 54.1869f, 380.266f)
            lineTo(62.1869f, 358.266f)
            curveTo(112.587f, 299.066f, 121.854f, 270.266f, 120.187f, 263.266f)
            curveTo(126.987f, 257.666f, 133.687f, 234.933f, 136.187f, 224.266f)
            lineTo(154.687f, 266.266f)
            lineTo(154.187f, 305.267f)
            lineTo(152.687f, 309.767f)
            curveTo(144.687f, 324.967f, 144.354f, 338.1f, 145.187f, 342.767f)
            lineTo(141.187f, 368.767f)
            curveTo(140.52f, 388.6f, 139.087f, 433.467f, 138.687f, 454.267f)
            curveTo(138.287f, 475.067f, 147.187f, 511.6f, 151.687f, 527.267f)
            curveTo(150.887f, 530.867f, 153.02f, 540.767f, 154.187f, 545.267f)
            curveTo(153.187f, 552.933f, 150.587f, 571.667f, 148.187f, 585.267f)
            curveTo(145.187f, 602.267f, 154.687f, 635.266f, 155.187f, 636.266f)
            curveTo(155.587f, 637.066f, 162.02f, 658.6f, 165.187f, 669.266f)
            curveTo(166.853f, 677.933f, 170.587f, 696.166f, 172.187f, 699.766f)
            curveTo(173.787f, 703.366f, 172.854f, 717.266f, 172.187f, 723.766f)
            curveTo(168.587f, 726.966f, 169.354f, 733.766f, 170.187f, 736.766f)
            curveTo(169.687f, 738.6f, 168.187f, 742.366f, 166.187f, 742.766f)
            curveTo(164.187f, 743.166f, 160.353f, 751.933f, 158.687f, 756.266f)
            curveTo(157.02f, 758.6f, 152.887f, 763.666f, 149.687f, 765.266f)
            curveTo(146.487f, 766.866f, 149.354f, 770.6f, 151.187f, 772.266f)
            curveTo(160.354f, 772.933f, 180.287f, 773.966f, 186.687f, 772.766f)
            curveTo(193.087f, 771.566f, 194.02f, 767.266f, 193.687f, 765.266f)
            verticalLineTo(754.266f)
            curveTo(192.52f, 750.766f, 190.387f, 742.366f, 191.187f, 736.766f)
            curveTo(191.987f, 731.166f, 190.853f, 725.766f, 190.187f, 723.766f)
            curveTo(189.787f, 719.366f, 191.353f, 694.6f, 192.187f, 682.766f)
            curveTo(198.687f, 628.266f, 198.187f, 631.266f, 198.687f, 611.766f)
            curveTo(199.187f, 592.266f, 188.187f, 546.266f, 188.187f, 544.266f)
            curveTo(188.187f, 542.666f, 189.187f, 532.267f, 189.687f, 527.267f)
            lineTo(192.687f, 503.266f)
            curveTo(196.353f, 472.433f, 203.887f, 409.466f, 204.687f, 404.266f)
            curveTo(205.487f, 399.066f, 206.353f, 399.433f, 206.687f, 400.266f)
            lineTo(215.187f, 461.266f)
            curveTo(217.353f, 482.6f, 221.987f, 525.766f, 223.187f, 527.766f)
            curveTo(224.387f, 529.766f, 223.687f, 540.933f, 223.187f, 546.266f)
            lineTo(220.687f, 564.266f)
            lineTo(213.187f, 606.766f)
            curveTo(212.853f, 617.6f, 212.787f, 641.466f, 215.187f, 650.266f)
            curveTo(217.587f, 659.066f, 220.187f, 702.933f, 221.187f, 723.766f)
            curveTo(219.587f, 726.166f, 220.187f, 733.766f, 220.687f, 737.266f)
            curveTo(220.187f, 741.266f, 218.887f, 751.466f, 217.687f, 760.266f)
            curveTo(216.487f, 769.066f, 219.52f, 772.266f, 221.187f, 772.766f)
            curveTo(232.187f, 772.933f, 255.287f, 773.166f, 259.687f, 772.766f)
            curveTo(264.087f, 772.366f, 263.853f, 767.933f, 263.187f, 765.766f)
            curveTo(261.02f, 765.266f, 256.187f, 762.866f, 254.187f, 757.266f)
            curveTo(252.187f, 751.666f, 245.353f, 742.6f, 242.187f, 738.766f)
            verticalLineTo(735.266f)
            curveTo(242.587f, 730.066f, 240.687f, 724.766f, 239.687f, 722.766f)
            curveTo(239.52f, 719.766f, 239.287f, 711.766f, 239.687f, 703.766f)
            curveTo(240.087f, 695.766f, 247.52f, 666.433f, 251.187f, 652.766f)
            curveTo(252.687f, 650.1f, 256.887f, 639.366f, 261.687f, 617.766f)
            curveTo(266.487f, 596.166f, 260.687f, 561.1f, 257.187f, 546.266f)
            curveTo(259.587f, 542.666f, 260.187f, 534.433f, 260.187f, 530.766f)
            curveTo(264.987f, 519.166f, 270.52f, 480.266f, 272.687f, 462.266f)
            curveTo(272.353f, 442.6f, 271.387f, 395.666f, 270.187f, 365.266f)
            curveTo(268.987f, 334.866f, 261.353f, 310.933f, 257.687f, 302.766f)
            lineTo(257.187f, 264.766f)
            curveTo(263.987f, 259.166f, 272.687f, 233.433f, 276.187f, 221.266f)
            curveTo(277.387f, 236.866f, 287.353f, 256.766f, 292.187f, 264.766f)
            curveTo(289.787f, 277.166f, 304.52f, 300.933f, 312.187f, 311.266f)
            lineTo(352.187f, 361.766f)
            lineTo(352.687f, 365.266f)
            curveTo(354.287f, 380.066f, 367.687f, 408.766f, 374.187f, 421.266f)
            curveTo(377.787f, 424.466f, 377.687f, 420.6f, 377.187f, 418.266f)
            curveTo(376.02f, 414.433f, 373.487f, 406.166f, 372.687f, 403.766f)
            curveTo(371.887f, 401.366f, 373.353f, 402.433f, 374.187f, 403.266f)
            lineTo(383.187f, 426.766f)
            curveTo(389.187f, 431.966f, 390.353f, 426.933f, 390.187f, 423.766f)
            lineTo(379.187f, 397.266f)
            lineTo(391.187f, 425.266f)
            curveTo(398.787f, 432.066f, 397.687f, 422.766f, 396.187f, 417.266f)
            lineTo(384.187f, 390.766f)
            lineTo(397.187f, 418.266f)
            curveTo(402.787f, 423.066f, 403.187f, 417.933f, 402.687f, 414.766f)
            lineTo(387.687f, 374.766f)
            curveTo(390.853f, 376.933f, 398.687f, 381.466f, 404.687f, 382.266f)
            curveTo(410.687f, 383.066f, 410.187f, 378.933f, 409.187f, 376.766f)
            lineTo(390.187f, 364.266f)
            curveTo(382.987f, 355.866f, 376.52f, 354.766f, 374.187f, 355.266f)
            curveTo(362.987f, 346.866f, 354.187f, 325.1f, 351.187f, 315.266f)
            curveTo(343.987f, 283.666f, 326.52f, 259.1f, 318.687f, 250.766f)
            curveTo(321.087f, 235.966f, 312.02f, 204.6f, 307.187f, 190.766f)
            curveTo(314.387f, 144.366f, 290.52f, 129.766f, 277.687f, 128.266f)
            curveTo(256.487f, 129.066f, 238.187f, 112.933f, 231.687f, 104.766f)
            verticalLineTo(88.2665f)
            verticalLineTo(93.7665f)
            horizontalLineTo(233.687f)
            lineTo(238.187f, 71.7665f)
            horizontalLineTo(241.187f)
            curveTo(242.52f, 66.9331f, 245.387f, 56.6665f, 246.187f, 54.2665f)
            curveTo(246.987f, 51.8665f, 242.52f, 49.5998f, 240.187f, 48.7665f)
            curveTo(241.853f, 31.4331f, 237.087f, -2.3335f, 204.687f, 1.2665f)
            curveTo(172.287f, 4.8665f, 170.187f, 36.0998f, 173.187f, 51.2665f)
            curveTo(167.587f, 51.2665f, 166.853f, 53.2665f, 167.187f, 54.2665f)
            lineTo(173.187f, 72.7665f)
            horizontalLineTo(174.687f)
            lineTo(180.187f, 92.7665f)
            lineTo(182.687f, 93.7665f)
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
            moveTo(163.187f, 769.766f)
            curveTo(162.387f, 767.766f, 168.853f, 749.6f, 172.187f, 740.766f)
            verticalLineTo(761.766f)
            curveTo(172.853f, 763.933f, 175.287f, 767.466f, 179.687f, 764.266f)
            curveTo(185.187f, 760.266f, 181.687f, 734.766f, 186.687f, 743.266f)
            curveTo(190.687f, 750.066f, 190.02f, 763.766f, 189.187f, 769.766f)
            curveTo(180.853f, 770.6f, 163.987f, 771.766f, 163.187f, 769.766f)
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
            moveTo(222.687f, 769.766f)
            curveTo(221.087f, 766.966f, 224.353f, 750.933f, 226.187f, 743.266f)
            curveTo(227.187f, 751.433f, 230.487f, 767.466f, 235.687f, 766.266f)
            curveTo(240.887f, 765.066f, 239.52f, 748.766f, 238.187f, 740.766f)
            curveTo(242.587f, 743.166f, 247.02f, 761.1f, 248.687f, 769.766f)
            curveTo(240.687f, 770.933f, 224.287f, 772.566f, 222.687f, 769.766f)
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
            moveTo(166.687f, 663.766f)
            curveTo(172.687f, 674.966f, 176.187f, 712.766f, 177.187f, 730.266f)
            curveTo(181.687f, 736.267f, 180.187f, 730.266f, 180.687f, 727.766f)
            curveTo(181.087f, 725.766f, 178.52f, 695.6f, 177.187f, 680.766f)
            curveTo(175.353f, 673.433f, 171.087f, 655.466f, 168.687f, 642.266f)
            curveTo(166.287f, 629.066f, 163.02f, 631.766f, 161.687f, 634.766f)
            curveTo(160.853f, 639.766f, 160.687f, 652.566f, 166.687f, 663.766f)
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
            moveTo(187.187f, 729.266f)
            curveTo(185.987f, 734.066f, 184.687f, 730.933f, 184.187f, 728.766f)
            lineTo(186.187f, 698.766f)
            lineTo(188.187f, 664.766f)
            lineTo(189.187f, 644.266f)
            curveTo(190.02f, 640.1f, 191.987f, 632.066f, 193.187f, 633.266f)
            curveTo(194.387f, 634.466f, 193.687f, 647.1f, 193.187f, 653.266f)
            curveTo(192.353f, 660.266f, 190.587f, 674.866f, 190.187f, 677.266f)
            curveTo(189.787f, 679.666f, 188.353f, 697.266f, 187.687f, 705.766f)
            lineTo(187.187f, 729.266f)
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
            moveTo(226.187f, 729.266f)
            curveTo(225.387f, 733.266f, 224.52f, 731.6f, 224.187f, 730.266f)
            verticalLineTo(723.266f)
            curveTo(224.187f, 722.066f, 221.853f, 690.433f, 220.687f, 674.766f)
            curveTo(219.887f, 672.366f, 218.353f, 659.766f, 217.687f, 653.766f)
            lineTo(216.687f, 640.766f)
            curveTo(217.087f, 632.366f, 217.853f, 631.266f, 218.187f, 631.766f)
            lineTo(222.187f, 647.766f)
            curveTo(222.353f, 649.6f, 222.587f, 653.766f, 222.187f, 655.766f)
            curveTo(221.787f, 657.766f, 223.02f, 677.933f, 223.687f, 687.766f)
            lineTo(226.187f, 729.266f)
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
            moveTo(233.687f, 727.766f)
            curveTo(230.887f, 735.766f, 229.853f, 731.766f, 229.687f, 728.766f)
            curveTo(230.187f, 721.766f, 231.187f, 707.166f, 231.187f, 704.766f)
            curveTo(231.187f, 702.366f, 233.853f, 684.433f, 235.187f, 675.766f)
            curveTo(237.353f, 664.6f, 241.887f, 641.466f, 242.687f, 638.266f)
            curveTo(243.687f, 634.266f, 245.187f, 631.766f, 248.687f, 632.266f)
            curveTo(251.487f, 632.666f, 250.52f, 642.766f, 249.687f, 647.766f)
            curveTo(246.853f, 657.6f, 240.587f, 678.266f, 238.187f, 682.266f)
            curveTo(235.787f, 686.266f, 234.187f, 714.266f, 233.687f, 727.766f)
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
            moveTo(227.687f, 626.766f)
            curveTo(220.487f, 635.566f, 218.353f, 630.433f, 218.187f, 626.766f)
            curveTo(218.187f, 620.6f, 217.887f, 604.866f, 216.687f, 591.266f)
            curveTo(215.487f, 577.666f, 232.52f, 538.266f, 241.187f, 520.266f)
            verticalLineTo(558.266f)
            curveTo(240.187f, 565.1f, 238.187f, 582.266f, 238.187f, 596.266f)
            curveTo(238.187f, 610.266f, 236.187f, 617.1f, 235.187f, 618.766f)
            curveTo(235.687f, 617.766f, 234.887f, 617.966f, 227.687f, 626.766f)
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
            moveTo(240.187f, 618.766f)
            curveTo(245.787f, 608.366f, 245.853f, 547.766f, 245.187f, 518.766f)
            curveTo(249.987f, 511.166f, 251.853f, 515.6f, 252.187f, 518.766f)
            lineTo(256.687f, 549.266f)
            curveTo(258.353f, 562.6f, 261.687f, 590.666f, 261.687f, 596.266f)
            curveTo(261.687f, 601.866f, 251.687f, 619.933f, 246.687f, 628.266f)
            lineTo(240.187f, 618.766f)
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
            moveTo(170.187f, 551.266f)
            lineTo(171.187f, 521.266f)
            curveTo(185.187f, 542.866f, 192.353f, 575.266f, 194.187f, 588.766f)
            curveTo(194.687f, 598.766f, 195.387f, 620.366f, 194.187f, 626.766f)
            curveTo(192.987f, 633.166f, 187.02f, 630.433f, 184.187f, 628.266f)
            curveTo(180.853f, 625.1f, 174.387f, 618.266f, 175.187f, 616.266f)
            curveTo(175.987f, 614.266f, 172.187f, 572.1f, 170.187f, 551.266f)
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
            moveTo(166.687f, 518.766f)
            curveTo(161.887f, 511.966f, 160.687f, 515.266f, 160.687f, 517.766f)
            lineTo(156.687f, 542.766f)
            curveTo(154.52f, 556.6f, 150.087f, 585.966f, 149.687f, 592.766f)
            curveTo(149.287f, 599.566f, 159.52f, 619.266f, 164.687f, 628.266f)
            lineTo(171.187f, 618.766f)
            curveTo(165.587f, 609.166f, 165.853f, 548.1f, 166.687f, 518.766f)
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
            moveTo(161.187f, 502.766f)
            lineTo(152.687f, 521.766f)
            lineTo(147.187f, 481.266f)
            curveTo(146.353f, 466.766f, 145.787f, 435.366f, 150.187f, 425.766f)
            curveTo(154.587f, 416.166f, 163.02f, 410.766f, 166.687f, 409.266f)
            curveTo(153.087f, 442.066f, 157.353f, 485.266f, 161.187f, 502.766f)
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
            moveTo(178.687f, 498.266f)
            curveTo(177.087f, 501.466f, 178.02f, 520.266f, 178.687f, 529.266f)
            curveTo(159.187f, 501.766f, 163.187f, 481.266f, 161.187f, 465.266f)
            curveTo(159.587f, 452.466f, 169.187f, 418.6f, 174.187f, 403.266f)
            curveTo(176.187f, 404.066f, 179.02f, 432.6f, 180.187f, 446.766f)
            curveTo(180.353f, 462.6f, 180.287f, 495.066f, 178.687f, 498.266f)
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
            moveTo(182.687f, 536.766f)
            curveTo(183.02f, 512.766f, 183.887f, 463.466f, 184.687f, 458.266f)
            curveTo(188.187f, 482.766f, 192.687f, 532.766f, 182.687f, 536.766f)
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
            moveTo(190.507f, 482.172f)
            curveTo(190.568f, 482.542f, 190.628f, 482.907f, 190.687f, 483.266f)
            curveTo(190.608f, 482.949f, 190.548f, 482.583f, 190.507f, 482.172f)
            curveTo(186.132f, 455.484f, 178.214f, 403.528f, 180.187f, 400.766f)
            curveTo(182.187f, 397.966f, 192.353f, 391.6f, 197.187f, 388.766f)
            curveTo(200.046f, 400.266f, 203.549f, 429.566f, 194.687f, 454.766f)
            curveTo(192.975f, 461.771f, 189.925f, 476.364f, 190.507f, 482.172f)
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
            moveTo(231.187f, 400.766f)
            lineTo(214.187f, 388.766f)
            curveTo(207.787f, 410.366f, 216.853f, 460.766f, 222.187f, 483.266f)
            curveTo(220.987f, 478.066f, 225.687f, 450.1f, 228.187f, 436.766f)
            curveTo(232.987f, 416.366f, 232.187f, 404.266f, 231.187f, 400.766f)
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
            moveTo(231.187f, 494.266f)
            curveTo(227.587f, 467.866f, 234.353f, 422.6f, 238.187f, 403.266f)
            curveTo(260.987f, 473.666f, 244.353f, 516.6f, 233.187f, 529.266f)
            curveTo(235.987f, 523.266f, 233.02f, 503.433f, 231.187f, 494.266f)
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
            moveTo(250.187f, 502.766f)
            curveTo(261.787f, 471.966f, 251.353f, 427.6f, 244.687f, 409.266f)
            curveTo(248.187f, 408.6f, 256.787f, 412.666f, 263.187f, 434.266f)
            curveTo(269.587f, 455.866f, 262.187f, 501.6f, 257.687f, 521.766f)
            lineTo(250.187f, 502.766f)
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
            moveTo(222.187f, 515.766f)
            lineTo(227.187f, 458.266f)
            curveTo(228.626f, 462.666f, 228.453f, 512.433f, 228.187f, 536.766f)
            curveTo(225.787f, 536.766f, 223.187f, 522.766f, 222.187f, 515.766f)
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
            moveTo(263.187f, 421.266f)
            curveTo(264.346f, 414.466f, 268.003f, 401.1f, 269.687f, 395.266f)
            verticalLineTo(444.766f)
            lineTo(263.187f, 421.266f)
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
            moveTo(142.187f, 444.766f)
            verticalLineTo(395.266f)
            curveTo(144.987f, 398.466f, 148.02f, 414.6f, 149.187f, 422.266f)
            lineTo(142.187f, 444.766f)
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
            moveTo(151.187f, 410.266f)
            curveTo(144.387f, 396.266f, 146.02f, 369.433f, 147.687f, 357.766f)
            curveTo(159.687f, 336.266f, 198.687f, 336.266f, 201.687f, 337.766f)
            curveTo(204.087f, 338.966f, 202.687f, 361.6f, 201.687f, 372.766f)
            lineTo(194.187f, 382.766f)
            curveTo(189.187f, 385.933f, 176.687f, 393.266f, 166.687f, 397.266f)
            curveTo(156.687f, 401.266f, 152.187f, 407.6f, 151.187f, 410.266f)
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
            moveTo(208.187f, 372.766f)
            verticalLineTo(337.766f)
            curveTo(229.187f, 335.266f, 255.687f, 345.766f, 262.187f, 357.766f)
            curveTo(267.387f, 367.366f, 261.687f, 396.766f, 258.187f, 410.266f)
            curveTo(257.853f, 408.1f, 254.187f, 402.466f, 242.187f, 397.266f)
            curveTo(230.187f, 392.066f, 219.52f, 385.433f, 215.687f, 382.766f)
            lineTo(208.187f, 372.766f)
            close()
        }
        path(
            fill = SolidColor(rhomboids),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(235.708f, 300.914f)
            curveTo(235.308f, 304.914f, 219.542f, 322.58f, 211.708f, 330.914f)
            curveTo(207.708f, 325.414f, 210.708f, 265.414f, 211.708f, 268.914f)
            curveTo(212.508f, 271.714f, 228.042f, 291.414f, 235.708f, 300.914f)
            close()
        }
        path(
            fill = SolidColor(rhomboids),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(173.687f, 301.266f)
            curveTo(174.087f, 305.266f, 189.854f, 322.933f, 197.687f, 331.266f)
            curveTo(201.687f, 325.766f, 198.687f, 265.766f, 197.687f, 269.266f)
            curveTo(196.887f, 272.066f, 181.354f, 291.766f, 173.687f, 301.266f)
            close()
        }
        path(
            fill = SolidColor(latissimus),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(149.687f, 245.766f)
            curveTo(162.887f, 266.566f, 169.187f, 285.766f, 170.687f, 292.766f)
            curveTo(199.887f, 269.166f, 202.187f, 236.6f, 199.687f, 223.266f)
            curveTo(191.187f, 217.266f, 173.687f, 204.366f, 171.687f, 200.766f)
            curveTo(169.687f, 197.166f, 165.52f, 195.266f, 163.687f, 194.766f)
            lineTo(133.187f, 191.266f)
            curveTo(132.187f, 197.266f, 133.187f, 219.766f, 149.687f, 245.766f)
            close()
        }
        path(
            fill = SolidColor(latissimus),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(260.442f, 245.266f)
            curveTo(247.242f, 266.066f, 240.942f, 285.266f, 239.442f, 292.266f)
            curveTo(210.242f, 268.666f, 207.942f, 236.1f, 210.442f, 222.766f)
            curveTo(218.942f, 216.766f, 236.442f, 203.866f, 238.442f, 200.266f)
            curveTo(240.442f, 196.666f, 244.608f, 194.766f, 246.442f, 194.266f)
            lineTo(276.942f, 190.766f)
            curveTo(277.942f, 196.766f, 276.942f, 219.266f, 260.442f, 245.266f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(136.187f, 134.266f)
            curveTo(136.507f, 134.189f, 136.853f, 134.134f, 137.221f, 134.105f)
            lineTo(152.187f, 131.766f)
            curveTo(167.52f, 133.6f, 198.887f, 139.766f, 201.687f, 149.766f)
            curveTo(204.487f, 159.766f, 201.854f, 198.6f, 200.187f, 216.766f)
            curveTo(187.387f, 211.566f, 174.52f, 189.933f, 169.687f, 179.766f)
            curveTo(158.311f, 141.845f, 143.938f, 133.583f, 137.221f, 134.105f)
            lineTo(136.187f, 134.266f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(200.187f, 137.766f)
            curveTo(198.987f, 134.966f, 174.02f, 129.6f, 161.687f, 127.266f)
            horizontalLineTo(160.687f)
            curveTo(197.087f, 107.266f, 203.187f, 80.9331f, 201.687f, 70.2665f)
            lineTo(205.687f, 71.7665f)
            curveTo(203.187f, 78.7665f, 201.687f, 141.266f, 200.187f, 137.766f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(278.187f, 134.766f)
            curveTo(277.948f, 134.708f, 277.683f, 134.667f, 277.394f, 134.643f)
            lineTo(262.187f, 132.266f)
            curveTo(246.854f, 134.1f, 213.487f, 138.266f, 210.687f, 148.266f)
            curveTo(207.887f, 158.266f, 209.02f, 197.6f, 210.687f, 215.766f)
            curveTo(223.487f, 210.566f, 237.354f, 190.433f, 242.187f, 180.266f)
            curveTo(248.435f, 144.221f, 270.236f, 134.045f, 277.394f, 134.643f)
            lineTo(278.187f, 134.766f)
            close()
        }
        path(
            fill = SolidColor(trapezius),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(214.187f, 138.266f)
            curveTo(215.387f, 135.466f, 240.354f, 130.1f, 252.687f, 127.766f)
            horizontalLineTo(253.687f)
            curveTo(217.287f, 107.766f, 211.187f, 81.4331f, 212.687f, 70.7665f)
            lineTo(208.687f, 72.2665f)
            curveTo(211.187f, 79.2665f, 212.687f, 141.766f, 214.187f, 138.266f)
            close()
        }
        path(
            fill = SolidColor(posteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(111.187f, 186.266f)
            curveTo(117.987f, 183.066f, 139.02f, 157.266f, 148.687f, 144.766f)
            curveTo(147.187f, 142.266f, 120.187f, 135.266f, 112.187f, 149.766f)
            curveTo(105.787f, 161.366f, 108.854f, 178.933f, 111.187f, 186.266f)
            close()
        }
        path(
            fill = SolidColor(teresMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(151.687f, 152.766f)
            curveTo(145.687f, 154.366f, 134.52f, 171.433f, 129.687f, 179.766f)
            curveTo(136.087f, 186.966f, 156.687f, 187.766f, 166.187f, 187.266f)
            curveTo(163.854f, 175.1f, 157.687f, 151.166f, 151.687f, 152.766f)
            close()
        }
        path(
            fill = SolidColor(posteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(300.687f, 186.163f)
            curveTo(293.887f, 182.963f, 272.854f, 157.163f, 263.187f, 144.663f)
            curveTo(264.687f, 142.163f, 291.687f, 135.163f, 299.687f, 149.663f)
            curveTo(306.087f, 161.263f, 303.02f, 178.83f, 300.687f, 186.163f)
            close()
        }
        path(
            fill = SolidColor(teresMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(260.187f, 152.663f)
            curveTo(266.187f, 154.263f, 277.354f, 171.33f, 282.187f, 179.663f)
            curveTo(275.787f, 186.863f, 255.187f, 187.663f, 245.687f, 187.163f)
            curveTo(248.02f, 174.996f, 254.187f, 151.063f, 260.187f, 152.663f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(116.187f, 235.766f)
            curveTo(110.187f, 196.966f, 121.353f, 182.266f, 127.687f, 179.766f)
            curveTo(126.887f, 182.566f, 128.687f, 193.933f, 129.687f, 199.266f)
            curveTo(130.52f, 204.766f, 132.187f, 217.966f, 132.187f, 226.766f)
            curveTo(132.187f, 237.766f, 113.687f, 264.266f, 116.187f, 257.766f)
            curveTo(118.187f, 252.566f, 117.02f, 240.933f, 116.187f, 235.766f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(105.687f, 244.766f)
            curveTo(105.687f, 241.966f, 108.353f, 224.6f, 109.687f, 216.266f)
            lineTo(111.187f, 244.766f)
            curveTo(108.787f, 257.966f, 106.52f, 250.266f, 105.687f, 244.766f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(295.687f, 235.766f)
            curveTo(301.687f, 196.966f, 290.52f, 182.266f, 284.187f, 179.766f)
            curveTo(284.987f, 182.566f, 283.187f, 193.933f, 282.187f, 199.266f)
            curveTo(281.353f, 204.766f, 279.687f, 217.966f, 279.687f, 226.766f)
            curveTo(279.687f, 237.766f, 298.187f, 264.266f, 295.687f, 257.766f)
            curveTo(293.687f, 252.566f, 294.853f, 240.933f, 295.687f, 235.766f)
            close()
        }
        path(
            fill = SolidColor(triceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(306.187f, 244.766f)
            curveTo(306.187f, 241.966f, 303.52f, 224.6f, 302.187f, 216.266f)
            lineTo(300.687f, 244.766f)
            curveTo(303.087f, 257.966f, 305.353f, 250.266f, 306.187f, 244.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(308.687f, 280.266f)
            curveTo(303.887f, 280.666f, 298.02f, 278.1f, 295.687f, 276.766f)
            curveTo(302.887f, 299.566f, 327.353f, 327.6f, 338.687f, 338.766f)
            lineTo(332.187f, 326.266f)
            curveTo(326.353f, 310.766f, 313.487f, 279.866f, 308.687f, 280.266f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(322.187f, 269.766f)
            curveTo(324.353f, 287.433f, 332.187f, 326.266f, 346.187f, 340.266f)
            curveTo(345.187f, 329.266f, 338.987f, 299.766f, 322.187f, 269.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(353.687f, 353.766f)
            curveTo(353.687f, 346.166f, 337.353f, 292.266f, 329.187f, 266.266f)
            curveTo(330.187f, 266.266f, 357.687f, 339.766f, 360.187f, 347.766f)
            curveTo(362.187f, 354.166f, 356.687f, 354.433f, 353.687f, 353.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(103.614f, 280.766f)
            curveTo(108.414f, 281.166f, 114.281f, 278.6f, 116.614f, 277.266f)
            curveTo(109.414f, 300.066f, 84.9476f, 328.1f, 73.6143f, 339.266f)
            lineTo(80.1143f, 326.766f)
            curveTo(85.9476f, 311.266f, 98.8143f, 280.366f, 103.614f, 280.766f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(90.1143f, 270.266f)
            curveTo(87.9476f, 287.933f, 80.1143f, 326.766f, 66.1143f, 340.766f)
            curveTo(67.1143f, 329.766f, 73.3143f, 300.266f, 90.1143f, 270.266f)
            close()
        }
        path(
            fill = SolidColor(forearm),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(58.6143f, 354.266f)
            curveTo(58.6143f, 346.666f, 74.9476f, 292.766f, 83.1143f, 266.766f)
            curveTo(82.1143f, 266.766f, 54.6143f, 340.266f, 52.1143f, 348.266f)
            curveTo(50.1143f, 354.666f, 55.6143f, 354.933f, 58.6143f, 354.266f)
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
            moveTo(149.187f, 347.766f)
            curveTo(153.854f, 341.1f, 167.887f, 327.766f, 186.687f, 327.766f)
            curveTo(176.354f, 315.1f, 154.387f, 301.366f, 149.187f, 347.766f)
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
            moveTo(158.687f, 308.266f)
            verticalLineTo(275.266f)
            curveTo(161.887f, 275.266f, 167.354f, 292.933f, 169.687f, 301.766f)
            lineTo(158.687f, 308.266f)
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
            moveTo(250.687f, 275.266f)
            curveTo(246.287f, 279.666f, 242.52f, 293.766f, 241.187f, 300.266f)
            curveTo(241.187f, 303.466f, 247.52f, 306.933f, 250.687f, 308.266f)
            verticalLineTo(275.266f)
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
            moveTo(223.187f, 327.766f)
            curveTo(231.854f, 328.6f, 251.287f, 333.766f, 259.687f, 347.766f)
            curveTo(258.854f, 329.1f, 250.387f, 298.966f, 223.187f, 327.766f)
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
            moveTo(300.187f, 263.766f)
            curveTo(300.187f, 264.966f, 309.52f, 275.266f, 314.187f, 280.266f)
            curveTo(315.187f, 276.1f, 315.687f, 266.166f, 309.687f, 259.766f)
            curveTo(302.187f, 251.766f, 300.187f, 262.266f, 300.187f, 263.766f)
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
            moveTo(111.187f, 265.266f)
            lineTo(97.1869f, 279.766f)
            lineTo(100.187f, 263.766f)
            curveTo(101.02f, 261.433f, 104.087f, 256.866f, 109.687f, 257.266f)
            curveTo(115.287f, 257.666f, 113.02f, 262.766f, 111.187f, 265.266f)
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
            moveTo(41.6869f, 357.266f)
            lineTo(26.6869f, 380.766f)
            curveTo(27.1869f, 381.933f, 29.7869f, 385.766f, 36.1869f, 391.766f)
            curveTo(42.5869f, 397.766f, 44.8536f, 396.6f, 45.1869f, 395.266f)
            curveTo(55.5869f, 384.466f, 54.8536f, 365.433f, 53.1869f, 357.266f)
            horizontalLineTo(41.6869f)
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
            moveTo(44.6869f, 401.766f)
            curveTo(45.0869f, 399.766f, 43.8536f, 399.933f, 43.1869f, 400.266f)
            curveTo(42.6869f, 401.266f, 37.6869f, 410.766f, 36.6869f, 414.266f)
            curveTo(35.8869f, 417.066f, 38.0203f, 416.433f, 39.1869f, 415.766f)
            lineTo(41.1869f, 412.766f)
            curveTo(42.1869f, 409.933f, 44.2869f, 403.766f, 44.6869f, 401.766f)
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
            moveTo(36.6869f, 400.766f)
            curveTo(37.8869f, 396.766f, 35.1869f, 397.433f, 33.6869f, 398.266f)
            curveTo(32.8869f, 398.621f, 27.3536f, 413.081f, 24.6869f, 420.266f)
            curveTo(24.6869f, 424.266f, 27.0203f, 422.933f, 28.1869f, 421.766f)
            curveTo(30.5203f, 416.433f, 35.4869f, 404.766f, 36.6869f, 400.766f)
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
            moveTo(27.1869f, 394.266f)
            lineTo(16.6869f, 420.266f)
            curveTo(16.6869f, 424.666f, 19.0203f, 424.433f, 20.1869f, 423.766f)
            curveTo(23.3536f, 416.433f, 29.9869f, 400.666f, 31.1869f, 396.266f)
            curveTo(32.3869f, 391.866f, 29.0203f, 393.1f, 27.1869f, 394.266f)
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
            moveTo(14.6869f, 413.766f)
            curveTo(12.6869f, 416.966f, 12.1869f, 413.433f, 12.1869f, 411.266f)
            curveTo(14.3536f, 404.433f, 19.3869f, 389.966f, 22.1869f, 386.766f)
            curveTo(24.9869f, 383.566f, 25.6869f, 387.1f, 25.6869f, 389.266f)
            curveTo(22.8536f, 396.1f, 16.6869f, 410.566f, 14.6869f, 413.766f)
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
            moveTo(31.1869f, 360.266f)
            lineTo(11.1869f, 371.766f)
            curveTo(10.1869f, 372.6f, 7.2869f, 374.766f, 3.6869f, 376.766f)
            curveTo(0.0869f, 378.766f, 4.1869f, 379.933f, 6.6869f, 380.266f)
            horizontalLineTo(11.6869f)
            lineTo(17.6869f, 377.266f)
            curveTo(22.1869f, 373.933f, 31.8869f, 366.366f, 34.6869f, 362.766f)
            curveTo(37.4869f, 359.166f, 33.5203f, 359.6f, 31.1869f, 360.266f)
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
            moveTo(365.687f, 396.266f)
            curveTo(357.287f, 383.866f, 357.187f, 365.766f, 358.187f, 358.266f)
            curveTo(360.854f, 356.933f, 366.987f, 354.966f, 370.187f, 357.766f)
            curveTo(373.387f, 360.566f, 381.187f, 373.266f, 384.687f, 379.266f)
            curveTo(385.52f, 380.1f, 386.387f, 382.266f, 383.187f, 384.266f)
            curveTo(379.987f, 386.266f, 377.854f, 388.766f, 377.187f, 389.766f)
            curveTo(373.587f, 396.166f, 368.02f, 396.766f, 365.687f, 396.266f)
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
            moveTo(369.687f, 401.266f)
            curveTo(367.287f, 397.666f, 366.687f, 400.1f, 366.687f, 401.766f)
            curveTo(367.854f, 404.933f, 370.587f, 412.066f, 372.187f, 415.266f)
            curveTo(373.787f, 418.466f, 374.854f, 415.933f, 375.187f, 414.266f)
            curveTo(374.354f, 411.433f, 372.087f, 404.866f, 369.687f, 401.266f)
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
            moveTo(378.687f, 398.766f)
            curveTo(375.887f, 393.166f, 374.854f, 398.1f, 374.687f, 401.266f)
            lineTo(383.187f, 421.266f)
            curveTo(387.187f, 424.866f, 387.187f, 421.1f, 386.687f, 418.766f)
            curveTo(385.187f, 414.433f, 381.487f, 404.366f, 378.687f, 398.766f)
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
            moveTo(384.687f, 395.266f)
            curveTo(381.087f, 389.266f, 380.187f, 394.433f, 380.187f, 397.766f)
            lineTo(391.687f, 423.266f)
            curveTo(395.287f, 427.666f, 395.187f, 421.433f, 394.687f, 417.766f)
            curveTo(392.854f, 412.766f, 388.287f, 401.266f, 384.687f, 395.266f)
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
            moveTo(390.687f, 387.766f)
            curveTo(388.287f, 382.566f, 386.354f, 386.933f, 385.687f, 389.766f)
            lineTo(396.187f, 413.766f)
            curveTo(399.787f, 417.766f, 400.02f, 412.1f, 399.687f, 408.766f)
            curveTo(397.687f, 403.933f, 393.087f, 392.966f, 390.687f, 387.766f)
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
            moveTo(403.687f, 380.266f)
            curveTo(396.087f, 379.866f, 383.187f, 369.433f, 377.687f, 364.266f)
            curveTo(377.02f, 362.933f, 376.087f, 360.166f, 377.687f, 359.766f)
            curveTo(379.287f, 359.366f, 381.354f, 360.6f, 382.187f, 361.266f)
            lineTo(395.187f, 369.266f)
            lineTo(407.187f, 376.266f)
            curveTo(409.187f, 377.766f, 411.287f, 380.666f, 403.687f, 380.266f)
            close()
        }
    }.build()
}