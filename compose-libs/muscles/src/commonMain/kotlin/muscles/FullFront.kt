package muscles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
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

    pectoralisMajor: Color = Colors.defaultFront,
    pectoralisMinor: Color = Colors.defaultFront,

    quadriceps: Color = Colors.defaultFront,

    other: Color = Colors.defaultFront,

    backgroundFront: Color = Colors.backgroundFront,
): ImageVector {
    return ImageVector.Builder(
        name = "Front",
        defaultWidth = 411.dp,
        defaultHeight = 773.dp,
        viewportWidth = 411f,
        viewportHeight = 773f
    ).apply {
        path(
            fill = SolidColor(backgroundFront),
            fillAlpha = 1.0f,
            stroke = SolidColor(outlineColor),
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(172.187f, 727.766f)
            lineTo(169.187f, 740.266f)
            lineTo(151.687f, 766.266f)
            curveTo(149.687f, 768.433f, 151.456f, 771.266f, 174.687f, 771.266f)
            curveTo(180.687f, 771.266f, 189.187f, 770.766f, 191.687f, 770.266f)
            lineTo(194.687f, 763.266f)
            lineTo(191.687f, 740.266f)
            verticalLineTo(710.766f)
            curveTo(190.687f, 699.933f, 189.287f, 677.466f, 191.687f, 674.266f)
            curveTo(194.087f, 671.066f, 197.353f, 639.6f, 198.687f, 624.266f)
            curveTo(199.02f, 614.433f, 197.587f, 586.466f, 189.187f, 553.266f)
            curveTo(187.853f, 543.933f, 186.587f, 521.766f, 192.187f, 507.766f)
            curveTo(195.02f, 473.933f, 201.487f, 405.166f, 204.687f, 400.766f)
            curveTo(207.887f, 396.366f, 211.02f, 427.266f, 212.187f, 443.266f)
            curveTo(215.52f, 471.6f, 222.287f, 528.566f, 222.687f, 529.766f)
            curveTo(223.087f, 530.966f, 222.853f, 544.6f, 222.687f, 551.266f)
            curveTo(219.02f, 569.766f, 211.887f, 608.666f, 212.687f, 616.266f)
            curveTo(213.687f, 625.766f, 217.687f, 671.266f, 220.187f, 688.766f)
            curveTo(222.187f, 702.766f, 221.02f, 726.933f, 220.187f, 737.266f)
            lineTo(218.687f, 752.266f)
            lineTo(217.687f, 766.266f)
            lineTo(223.687f, 772.266f)
            lineTo(260.187f, 771.345f)
            lineTo(263.687f, 769.766f)
            verticalLineTo(766.266f)
            lineTo(258.687f, 761.266f)
            lineTo(241.187f, 737.266f)
            lineTo(240.187f, 727.766f)
            lineTo(239.187f, 721.266f)
            curveTo(238.52f, 715.766f, 237.587f, 704.066f, 239.187f, 701.266f)
            curveTo(241.187f, 697.766f, 250.687f, 647.766f, 251.687f, 646.266f)
            curveTo(252.487f, 645.066f, 258.353f, 625.766f, 261.187f, 616.266f)
            curveTo(263.853f, 605.266f, 267.087f, 577.666f, 258.687f, 555.266f)
            curveTo(257.52f, 552.933f, 256.387f, 542.366f, 261.187f, 518.766f)
            curveTo(266.187f, 505.266f, 275.587f, 465.166f, 273.187f, 412.766f)
            curveTo(270.787f, 360.366f, 266.187f, 330.6f, 264.187f, 322.266f)
            lineTo(257.187f, 300.766f)
            lineTo(257.687f, 263.766f)
            curveTo(272.687f, 243.767f, 274.687f, 214.766f, 275.187f, 222.766f)
            curveTo(275.587f, 229.166f, 286.02f, 252.1f, 291.187f, 262.766f)
            curveTo(290.787f, 273.167f, 300.687f, 293.433f, 305.687f, 302.266f)
            curveTo(314.687f, 314.1f, 334.087f, 339.166f, 339.687f, 344.766f)
            curveTo(346.687f, 351.767f, 354.687f, 368.766f, 355.687f, 375.766f)
            curveTo(356.687f, 382.767f, 361.687f, 394.766f, 362.187f, 397.766f)
            curveTo(362.687f, 400.767f, 371.687f, 418.266f, 374.187f, 421.266f)
            curveTo(376.187f, 423.667f, 377.687f, 421.6f, 378.187f, 420.266f)
            curveTo(376.52f, 415.766f, 373.087f, 406.266f, 372.687f, 404.266f)
            curveTo(372.287f, 402.267f, 373.187f, 402.766f, 373.687f, 403.266f)
            lineTo(383.687f, 426.266f)
            curveTo(387.687f, 430.267f, 389.687f, 426.6f, 390.187f, 424.266f)
            curveTo(386.353f, 415.766f, 378.587f, 398.466f, 378.187f, 397.266f)
            curveTo(377.787f, 396.067f, 378.353f, 396.433f, 378.687f, 396.766f)
            lineTo(392.187f, 426.766f)
            curveTo(397.387f, 430.366f, 398.353f, 425.266f, 398.187f, 422.266f)
            lineTo(384.187f, 391.266f)
            curveTo(387.687f, 399.766f, 395.587f, 417.166f, 399.187f, 418.766f)
            curveTo(402.787f, 420.367f, 403.02f, 416.766f, 402.687f, 414.766f)
            lineTo(388.187f, 374.266f)
            curveTo(391.853f, 376.766f, 400.487f, 381.766f, 405.687f, 381.766f)
            curveTo(410.887f, 381.767f, 410.52f, 377.766f, 409.687f, 375.766f)
            curveTo(405.853f, 374.433f, 396.687f, 370.066f, 390.687f, 363.266f)
            curveTo(384.687f, 356.467f, 376.52f, 354.433f, 373.187f, 354.266f)
            curveTo(363.187f, 345.467f, 354.353f, 323.6f, 351.187f, 313.766f)
            curveTo(347.987f, 292.167f, 328.187f, 261.766f, 318.687f, 249.266f)
            curveTo(321.487f, 231.266f, 312.52f, 203.433f, 307.687f, 191.766f)
            verticalLineTo(156.766f)
            curveTo(301.187f, 123.766f, 259.687f, 124.266f, 257.187f, 124.266f)
            curveTo(254.687f, 124.266f, 238.187f, 112.766f, 233.187f, 107.266f)
            curveTo(229.187f, 102.866f, 229.52f, 97.4331f, 230.187f, 95.2665f)
            lineTo(234.187f, 89.7665f)
            lineTo(235.687f, 82.2665f)
            lineTo(236.187f, 74.7665f)
            curveTo(237.387f, 75.1665f, 238.02f, 74.2665f, 238.187f, 73.7665f)
            curveTo(239.52f, 69.5998f, 242.487f, 60.6665f, 243.687f, 58.2665f)
            curveTo(244.887f, 55.8665f, 240.853f, 53.5998f, 238.687f, 52.7665f)
            curveTo(243.187f, 15.7665f, 220.187f, -6.2335f, 194.187f, 3.2665f)
            curveTo(173.387f, 10.8665f, 170.853f, 40.0998f, 172.187f, 53.7665f)
            curveTo(166.987f, 54.9665f, 166.353f, 56.5998f, 166.687f, 57.2665f)
            curveTo(167.52f, 59.7665f, 169.587f, 65.9665f, 171.187f, 70.7665f)
            curveTo(172.787f, 75.5665f, 174.52f, 76.0998f, 175.187f, 75.7665f)
            lineTo(176.687f, 89.7665f)
            lineTo(182.187f, 95.2665f)
            curveTo(183.02f, 97.5998f, 183.787f, 103.266f, 180.187f, 107.266f)
            curveTo(176.587f, 111.266f, 160.687f, 120.266f, 153.187f, 124.266f)
            curveTo(116.387f, 126.266f, 104.52f, 146.433f, 103.187f, 156.266f)
            verticalLineTo(191.766f)
            curveTo(96.3868f, 198.966f, 93.0202f, 234.1f, 92.1868f, 250.766f)
            curveTo(90.3535f, 253.266f, 84.7868f, 260.766f, 77.1868f, 270.766f)
            curveTo(67.6868f, 283.266f, 65.1868f, 296.266f, 59.1868f, 316.266f)
            curveTo(54.3868f, 332.266f, 42.1868f, 349.266f, 36.6868f, 355.766f)
            curveTo(33.4868f, 355.366f, 30.0201f, 356.266f, 28.6868f, 356.766f)
            lineTo(1.18684f, 375.766f)
            curveTo(0.6868f, 378.266f, 0.8868f, 383.066f, 5.6868f, 382.266f)
            curveTo(11.6868f, 381.266f, 21.6868f, 374.266f, 23.1868f, 373.766f)
            curveTo(24.3869f, 373.366f, 24.0202f, 373.933f, 23.6868f, 374.266f)
            lineTo(19.6868f, 384.766f)
            curveTo(16.6868f, 392.266f, 10.2868f, 408.666f, 8.6868f, 414.266f)
            curveTo(7.0868f, 419.866f, 10.6868f, 419.266f, 12.6868f, 418.266f)
            lineTo(24.1868f, 395.266f)
            curveTo(25.7868f, 393.266f, 26.1868f, 394.766f, 26.1868f, 395.766f)
            curveTo(22.5201f, 403.266f, 14.6868f, 419.366f, 12.6868f, 423.766f)
            curveTo(10.6868f, 428.166f, 15.5201f, 428.266f, 18.1868f, 427.766f)
            lineTo(30.1868f, 401.266f)
            curveTo(32.5868f, 398.466f, 32.1868f, 400.766f, 31.6868f, 402.266f)
            curveTo(28.8535f, 409.266f, 22.8868f, 423.566f, 21.6868f, 424.766f)
            curveTo(20.1868f, 426.266f, 23.1868f, 431.766f, 26.1868f, 428.766f)
            curveTo(28.5868f, 426.366f, 34.1868f, 411.766f, 36.6868f, 404.766f)
            curveTo(38.2868f, 402.766f, 38.6868f, 403.933f, 38.6868f, 404.766f)
            curveTo(38.8534f, 405.1f, 38.2868f, 407.766f, 34.6868f, 415.766f)
            curveTo(31.0868f, 423.766f, 35.5201f, 422.766f, 38.1868f, 421.266f)
            curveTo(48.5868f, 407.266f, 53.5201f, 384.766f, 54.6868f, 375.266f)
            lineTo(61.1868f, 357.766f)
            curveTo(61.6868f, 356.433f, 68.1868f, 347.466f, 90.1868f, 322.266f)
            curveTo(112.187f, 297.066f, 119.02f, 271.433f, 119.687f, 261.766f)
            curveTo(126.487f, 256.566f, 132.853f, 234.266f, 135.187f, 223.766f)
            curveTo(134.787f, 226.966f, 147.687f, 252.1f, 154.187f, 264.266f)
            curveTo(154.187f, 270.766f, 154.187f, 285.966f, 154.187f, 294.766f)
            curveTo(154.187f, 303.566f, 149.187f, 318.1f, 146.687f, 324.266f)
            curveTo(139.687f, 364.433f, 130.487f, 458.666f, 149.687f, 514.266f)
            lineTo(153.687f, 545.766f)
            curveTo(149.353f, 563.933f, 144.32f, 609.533f, 151.687f, 624.266f)
            curveTo(159.687f, 640.266f, 167.687f, 677.6f, 171.187f, 698.266f)
            lineTo(172.187f, 727.766f)
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
            moveTo(178.187f, 754.266f)
            lineTo(169.187f, 746.266f)
            curveTo(163.354f, 752.6f, 152.187f, 765.766f, 154.187f, 767.766f)
            curveTo(156.187f, 769.766f, 169.354f, 769.6f, 175.687f, 769.266f)
            lineTo(178.187f, 754.266f)
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
            moveTo(179.687f, 769.266f)
            lineTo(180.687f, 758.266f)
            curveTo(181.487f, 755.066f, 183.687f, 756.933f, 184.687f, 758.266f)
            lineTo(188.187f, 763.266f)
            verticalLineTo(769.266f)
            horizontalLineTo(179.687f)
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
            moveTo(223.687f, 761.766f)
            verticalLineTo(767.766f)
            verticalLineTo(769.266f)
            horizontalLineTo(231.187f)
            verticalLineTo(759.766f)
            curveTo(228.787f, 752.166f, 225.187f, 757.933f, 223.687f, 761.766f)
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
            moveTo(235.687f, 769.266f)
            curveTo(234.487f, 766.466f, 233.854f, 758.1f, 233.687f, 754.266f)
            verticalLineTo(753.266f)
            lineTo(243.187f, 746.266f)
            curveTo(257.587f, 761.866f, 258.854f, 767.1f, 257.687f, 767.766f)
            lineTo(235.687f, 769.266f)
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
            moveTo(188.687f, 759.266f)
            curveTo(186.687f, 753.666f, 176.187f, 744.933f, 171.187f, 741.266f)
            curveTo(171.854f, 738.266f, 173.287f, 730.566f, 173.687f, 723.766f)
            curveTo(174.087f, 716.966f, 175.854f, 716.6f, 176.687f, 717.266f)
            curveTo(184.687f, 725.266f, 189.02f, 736.6f, 190.187f, 741.266f)
            curveTo(190.52f, 749.6f, 190.687f, 764.866f, 188.687f, 759.266f)
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
            moveTo(221.187f, 755.766f)
            lineTo(221.687f, 742.266f)
            curveTo(228.487f, 719.866f, 234.187f, 716.6f, 236.187f, 717.766f)
            lineTo(238.687f, 731.766f)
            lineTo(239.687f, 742.266f)
            curveTo(236.854f, 742.766f, 230.187f, 745.666f, 226.187f, 753.266f)
            curveTo(222.187f, 760.867f, 221.187f, 758.1f, 221.187f, 755.766f)
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
            moveTo(223.687f, 725.766f)
            verticalLineTo(710.266f)
            lineTo(232.687f, 703.766f)
            curveTo(233.854f, 705.1f, 235.787f, 708.066f, 234.187f, 709.266f)
            curveTo(232.587f, 710.466f, 226.52f, 720.766f, 223.687f, 725.766f)
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
            moveTo(187.187f, 725.766f)
            lineTo(176.687f, 708.266f)
            curveTo(176.287f, 705.866f, 178.52f, 704.266f, 179.687f, 703.766f)
            lineTo(187.687f, 710.766f)
            curveTo(188.887f, 717.966f, 187.854f, 723.766f, 187.187f, 725.766f)
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
            moveTo(185.187f, 690.266f)
            curveTo(193.02f, 662.933f, 204.687f, 601.866f, 188.687f, 576.266f)
            curveTo(182.354f, 581.933f, 172.787f, 612.666f, 185.187f, 690.266f)
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
            moveTo(177.687f, 663.766f)
            curveTo(177.687f, 622.566f, 162.687f, 576.6f, 155.187f, 558.766f)
            lineTo(154.187f, 576.266f)
            curveTo(155.187f, 583.766f, 158.587f, 602.566f, 164.187f, 617.766f)
            curveTo(169.787f, 632.966f, 172.853f, 654.766f, 173.687f, 663.766f)
            curveTo(176.187f, 675.266f, 177.687f, 677.766f, 180.187f, 693.266f)
            curveTo(182.187f, 705.666f, 184.354f, 704.1f, 185.187f, 701.766f)
            curveTo(181.987f, 696.166f, 178.854f, 674.1f, 177.687f, 663.766f)
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
            moveTo(166.187f, 635.266f)
            curveTo(166.187f, 632.066f, 156.853f, 598.933f, 152.187f, 582.766f)
            curveTo(150.358f, 591.966f, 152.758f, 609.933f, 154.187f, 617.766f)
            lineTo(159.187f, 638.266f)
            lineTo(167.187f, 667.266f)
            curveTo(168.687f, 673.433f, 172.387f, 687.566f, 175.187f, 694.766f)
            curveTo(178.687f, 703.766f, 179.187f, 696.266f, 177.687f, 694.766f)
            curveTo(176.487f, 693.566f, 172.52f, 672.6f, 170.687f, 662.266f)
            curveTo(169.187f, 654.6f, 166.187f, 638.466f, 166.187f, 635.266f)
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
            moveTo(223.187f, 574.266f)
            curveTo(229.187f, 586.266f, 238.287f, 626.266f, 226.687f, 690.266f)
            curveTo(219.02f, 665.433f, 207.587f, 607.466f, 223.187f, 574.266f)
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
            moveTo(244.687f, 629.266f)
            curveTo(256.687f, 595.975f, 257.353f, 568.395f, 256.187f, 558.766f)
            curveTo(251.02f, 571.766f, 240.187f, 605.066f, 238.187f, 634.266f)
            curveTo(236.187f, 663.466f, 230.02f, 688.433f, 227.187f, 697.266f)
            curveTo(226.787f, 704.866f, 229.02f, 703.433f, 230.187f, 701.766f)
            lineTo(244.687f, 629.266f)
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
            moveTo(258.687f, 617.766f)
            lineTo(260.187f, 583.266f)
            lineTo(249.187f, 622.766f)
            curveTo(246.853f, 631.433f, 242.187f, 650.866f, 242.187f, 659.266f)
            curveTo(242.187f, 667.666f, 236.52f, 685.433f, 233.687f, 693.266f)
            lineTo(234.687f, 697.266f)
            curveTo(238.02f, 690.766f, 244.687f, 675.466f, 244.687f, 666.266f)
            curveTo(244.687f, 657.066f, 254.02f, 630.1f, 258.687f, 617.766f)
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
            moveTo(234.687f, 582.766f)
            curveTo(235.887f, 577.566f, 229.52f, 544.266f, 226.187f, 528.266f)
            lineTo(224.687f, 552.266f)
            curveTo(227.52f, 564.6f, 233.487f, 587.966f, 234.687f, 582.766f)
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
            moveTo(185.187f, 538.266f)
            curveTo(180.787f, 547.466f, 177.687f, 571.766f, 176.687f, 582.766f)
            curveTo(189.487f, 554.766f, 187.687f, 534.766f, 185.187f, 528.266f)
            verticalLineTo(538.266f)
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
            moveTo(159.687f, 520.766f)
            curveTo(150.02f, 490.766f, 132.887f, 424.366f, 141.687f, 398.766f)
            curveTo(151.854f, 436.766f, 169.687f, 514.366f, 159.687f, 520.766f)
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
            moveTo(176.687f, 428.266f)
            curveTo(182.287f, 437.466f, 176.02f, 491.433f, 172.187f, 517.266f)
            curveTo(170.187f, 517.933f, 166.587f, 517.466f, 168.187f, 510.266f)
            curveTo(169.787f, 503.066f, 168.854f, 485.933f, 168.187f, 478.266f)
            curveTo(141.787f, 427.466f, 143.854f, 365.1f, 148.187f, 340.266f)
            curveTo(155.354f, 365.766f, 171.087f, 419.066f, 176.687f, 428.266f)
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
            moveTo(181.687f, 480.766f)
            curveTo(178.487f, 503.966f, 180.354f, 518.1f, 181.687f, 522.266f)
            curveTo(190.887f, 528.266f, 192.52f, 498.766f, 192.187f, 483.266f)
            curveTo(190.854f, 477.1f, 187.587f, 462.066f, 185.187f, 451.266f)
            curveTo(182.787f, 440.466f, 181.854f, 441.433f, 181.687f, 443.266f)
            curveTo(183.02f, 446.1f, 184.887f, 457.566f, 181.687f, 480.766f)
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
            moveTo(181.687f, 426.766f)
            curveTo(168.487f, 403.566f, 158.854f, 357.766f, 155.687f, 337.766f)
            curveTo(156.657f, 343.1f, 161.316f, 357.066f, 172.187f, 370.266f)
            curveTo(183.058f, 383.466f, 190.05f, 414.433f, 192.187f, 428.266f)
            curveTo(192.854f, 443.1f, 193.987f, 470.766f, 193.187f, 462.766f)
            curveTo(192.387f, 454.766f, 185.187f, 435.433f, 181.687f, 426.766f)
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
            moveTo(181.687f, 374.766f)
            lineTo(163.687f, 340.266f)
            curveTo(168.887f, 342.266f, 188.187f, 361.1f, 197.187f, 370.266f)
            curveTo(189.987f, 389.066f, 186.187f, 392.433f, 185.187f, 391.766f)
            lineTo(181.687f, 374.766f)
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
            moveTo(248.187f, 340.266f)
            lineTo(214.687f, 368.766f)
            curveTo(218.52f, 379.433f, 226.287f, 398.966f, 226.687f, 391.766f)
            curveTo(227.187f, 382.766f, 229.687f, 374.766f, 230.687f, 374.766f)
            curveTo(231.487f, 374.766f, 242.687f, 351.766f, 248.187f, 340.266f)
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
            moveTo(232.187f, 383.766f)
            curveTo(234.987f, 381.766f, 249.02f, 352.266f, 255.687f, 337.766f)
            curveTo(260.087f, 342.566f, 240.854f, 397.766f, 230.687f, 424.766f)
            lineTo(217.187f, 465.266f)
            lineTo(219.687f, 428.266f)
            curveTo(222.687f, 414.266f, 229.387f, 385.766f, 232.187f, 383.766f)
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
            moveTo(241.187f, 409.766f)
            lineTo(263.687f, 340.266f)
            curveTo(266.487f, 342.266f, 267.52f, 370.766f, 267.687f, 384.766f)
            curveTo(265.354f, 404.933f, 259.387f, 446.666f, 254.187f, 452.266f)
            curveTo(248.987f, 457.866f, 244.354f, 477.6f, 242.687f, 486.766f)
            verticalLineTo(514.266f)
            curveTo(242.687f, 521.066f, 238.354f, 519.1f, 236.187f, 517.266f)
            verticalLineTo(508.266f)
            curveTo(235.354f, 497.266f, 233.687f, 470.466f, 233.687f, 451.266f)
            curveTo(233.687f, 432.066f, 238.687f, 415.6f, 241.187f, 409.766f)
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
            moveTo(249.187f, 482.266f)
            curveTo(251.187f, 481.466f, 263.354f, 426.266f, 269.187f, 398.766f)
            curveTo(270.687f, 414.1f, 272.987f, 448.766f, 270.187f, 464.766f)
            curveTo(267.387f, 480.766f, 255.02f, 508.766f, 249.187f, 520.766f)
            curveTo(248.354f, 508.266f, 247.187f, 483.066f, 249.187f, 482.266f)
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
            moveTo(222.187f, 515.766f)
            curveTo(216.587f, 483.366f, 224.187f, 453.933f, 228.687f, 443.266f)
            curveTo(229.014f, 442.466f, 229.49f, 471.266f, 229.687f, 485.766f)
            lineTo(232.187f, 513.266f)
            curveTo(228.987f, 530.866f, 224.187f, 522.266f, 222.187f, 515.766f)
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
            moveTo(220.687f, 406.766f)
            curveTo(224.687f, 399.966f, 214.687f, 381.266f, 209.187f, 372.766f)
            curveTo(209.187f, 381.766f, 209.687f, 402.366f, 211.687f, 412.766f)
            curveTo(213.687f, 423.166f, 216.854f, 425.433f, 218.187f, 425.266f)
            curveTo(217.354f, 421.933f, 216.687f, 413.566f, 220.687f, 406.766f)
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
            moveTo(195.187f, 424.766f)
            curveTo(200.787f, 419.166f, 202.52f, 387.933f, 202.187f, 372.766f)
            curveTo(191.687f, 394.766f, 187.187f, 400.266f, 191.187f, 406.766f)
            curveTo(194.387f, 411.966f, 193.854f, 417.933f, 193.187f, 420.266f)
            curveTo(193.987f, 426.266f, 194.854f, 425.766f, 195.187f, 424.766f)
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
            moveTo(174.687f, 552.266f)
            lineTo(167.187f, 534.766f)
            verticalLineTo(530.766f)
            curveTo(175.187f, 523.966f, 179.52f, 529.933f, 180.687f, 533.766f)
            lineTo(174.687f, 552.266f)
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
            moveTo(165.687f, 543.266f)
            lineTo(155.187f, 517.766f)
            curveTo(155.187f, 526.966f, 156.854f, 542.933f, 157.687f, 549.766f)
            curveTo(167.687f, 556.166f, 169.187f, 555.766f, 168.687f, 554.766f)
            lineTo(165.687f, 543.266f)
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
            moveTo(237.687f, 552.266f)
            lineTo(245.187f, 534.766f)
            verticalLineTo(530.766f)
            curveTo(237.187f, 523.966f, 232.854f, 529.933f, 231.687f, 533.766f)
            lineTo(237.687f, 552.266f)
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
            moveTo(246.687f, 543.266f)
            lineTo(257.187f, 517.766f)
            curveTo(257.187f, 526.966f, 255.52f, 542.933f, 254.687f, 549.766f)
            curveTo(244.687f, 556.166f, 243.187f, 555.766f, 243.687f, 554.766f)
            lineTo(246.687f, 543.266f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(174.687f, 291.766f)
            curveTo(174.287f, 320.166f, 185.52f, 347.6f, 191.187f, 357.766f)
            curveTo(196.387f, 361.766f, 199.354f, 357.766f, 200.187f, 355.266f)
            lineTo(198.687f, 302.766f)
            curveTo(193.887f, 289.566f, 180.687f, 289.933f, 174.687f, 291.766f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(172.687f, 281.266f)
            verticalLineTo(268.266f)
            curveTo(189.887f, 257.066f, 198.187f, 262.6f, 200.187f, 266.766f)
            curveTo(200.687f, 274.266f, 201.387f, 288.966f, 200.187f, 287.766f)
            curveTo(198.987f, 286.566f, 192.02f, 284.6f, 188.687f, 283.766f)
            curveTo(178.287f, 284.166f, 173.687f, 282.266f, 172.687f, 281.266f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(173.687f, 256.766f)
            lineTo(172.687f, 245.766f)
            curveTo(181.087f, 230.166f, 195.187f, 230.933f, 201.187f, 233.266f)
            curveTo(201.187f, 238.466f, 199.52f, 249.766f, 198.687f, 254.766f)
            curveTo(184.287f, 253.166f, 176.02f, 255.433f, 173.687f, 256.766f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(188.687f, 209.266f)
            curveTo(173.887f, 212.066f, 171.854f, 226.433f, 172.687f, 233.266f)
            curveTo(182.287f, 224.866f, 195.02f, 223.766f, 200.187f, 224.266f)
            curveTo(201.02f, 219.933f, 202.187f, 210.866f, 200.187f, 209.266f)
            curveTo(198.187f, 207.666f, 191.687f, 208.6f, 188.687f, 209.266f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(156.687f, 271.266f)
            curveTo(154.687f, 276.066f, 155.854f, 310.433f, 156.687f, 327.767f)
            curveTo(157.887f, 330.167f, 164.854f, 332.433f, 168.187f, 333.266f)
            lineTo(169.687f, 327.767f)
            lineTo(166.187f, 278.766f)
            curveTo(163.854f, 273.767f, 158.687f, 266.466f, 156.687f, 271.266f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(162.687f, 251.766f)
            lineTo(162.187f, 262.766f)
            curveTo(158.987f, 264.366f, 153.187f, 258.1f, 150.687f, 254.766f)
            curveTo(149.02f, 247.933f, 146.287f, 235.266f, 148.687f, 239.266f)
            curveTo(151.087f, 243.266f, 159.02f, 249.266f, 162.687f, 251.766f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(159.187f, 241.766f)
            lineTo(149.687f, 229.266f)
            verticalLineTo(224.766f)
            curveTo(152.087f, 223.966f, 158.687f, 228.766f, 161.687f, 231.266f)
            curveTo(161.687f, 233.433f, 161.587f, 238.366f, 161.187f, 240.766f)
            curveTo(160.787f, 243.166f, 159.687f, 242.433f, 159.187f, 241.766f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(159.187f, 224.766f)
            lineTo(150.187f, 214.266f)
            curveTo(149.187f, 211.266f, 151.687f, 211.766f, 154.687f, 211.766f)
            curveTo(157.087f, 211.766f, 161.354f, 214.1f, 163.187f, 215.266f)
            curveTo(163.854f, 216.6f, 165.087f, 220.066f, 164.687f, 223.266f)
            curveTo(164.287f, 226.466f, 160.854f, 225.6f, 159.187f, 224.766f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(163.687f, 210.266f)
            lineTo(149.687f, 200.266f)
            curveTo(148.687f, 196.266f, 152.687f, 197.266f, 155.687f, 197.766f)
            curveTo(158.087f, 198.166f, 164.354f, 200.6f, 167.187f, 201.766f)
            curveTo(168.187f, 201.933f, 169.887f, 203.166f, 168.687f, 206.766f)
            curveTo(167.487f, 210.366f, 164.854f, 210.6f, 163.687f, 210.266f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(237.291f, 292.255f)
            curveTo(237.691f, 320.655f, 226.458f, 348.088f, 220.791f, 358.255f)
            curveTo(215.591f, 362.255f, 212.624f, 358.255f, 211.791f, 355.755f)
            lineTo(213.291f, 303.255f)
            curveTo(218.091f, 290.055f, 231.291f, 290.421f, 237.291f, 292.255f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(239.291f, 281.755f)
            verticalLineTo(268.755f)
            curveTo(222.091f, 257.555f, 213.791f, 263.088f, 211.791f, 267.255f)
            curveTo(211.291f, 274.755f, 210.591f, 289.455f, 211.791f, 288.255f)
            curveTo(212.991f, 287.055f, 219.958f, 285.088f, 223.291f, 284.255f)
            curveTo(233.691f, 284.655f, 238.291f, 282.755f, 239.291f, 281.755f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(238.291f, 257.255f)
            lineTo(239.291f, 246.255f)
            curveTo(230.891f, 230.655f, 216.791f, 231.421f, 210.791f, 233.755f)
            curveTo(210.791f, 238.955f, 212.458f, 250.255f, 213.291f, 255.255f)
            curveTo(227.691f, 253.655f, 235.958f, 255.921f, 238.291f, 257.255f)
            close()
        }
        path(
            fill = SolidColor(rectusAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(223.291f, 209.755f)
            curveTo(238.091f, 212.555f, 240.124f, 226.921f, 239.291f, 233.755f)
            curveTo(229.691f, 225.355f, 216.958f, 224.255f, 211.791f, 224.755f)
            curveTo(210.958f, 220.421f, 209.791f, 211.355f, 211.791f, 209.755f)
            curveTo(213.791f, 208.155f, 220.291f, 209.088f, 223.291f, 209.755f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(255.291f, 271.755f)
            curveTo(257.291f, 276.555f, 256.125f, 310.921f, 255.291f, 328.255f)
            curveTo(254.091f, 330.655f, 247.125f, 332.921f, 243.791f, 333.755f)
            lineTo(242.291f, 328.255f)
            lineTo(245.791f, 279.255f)
            curveTo(248.125f, 274.255f, 253.291f, 266.955f, 255.291f, 271.755f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(249.291f, 252.255f)
            lineTo(249.791f, 263.255f)
            curveTo(252.991f, 264.855f, 258.791f, 258.588f, 261.291f, 255.255f)
            curveTo(262.958f, 248.421f, 265.691f, 235.755f, 263.291f, 239.755f)
            curveTo(260.891f, 243.755f, 252.958f, 249.755f, 249.291f, 252.255f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(252.791f, 242.255f)
            lineTo(262.291f, 229.755f)
            verticalLineTo(225.255f)
            curveTo(259.891f, 224.455f, 253.291f, 229.255f, 250.291f, 231.755f)
            curveTo(250.291f, 233.921f, 250.391f, 238.855f, 250.791f, 241.255f)
            curveTo(251.191f, 243.655f, 252.291f, 242.921f, 252.791f, 242.255f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(252.791f, 225.255f)
            lineTo(261.791f, 214.755f)
            curveTo(262.791f, 211.755f, 260.291f, 212.255f, 257.291f, 212.255f)
            curveTo(254.891f, 212.255f, 250.625f, 214.588f, 248.791f, 215.755f)
            curveTo(248.125f, 217.088f, 246.891f, 220.555f, 247.291f, 223.755f)
            curveTo(247.691f, 226.955f, 251.125f, 226.088f, 252.791f, 225.255f)
            close()
        }
        path(
            fill = SolidColor(obliquesAbdominis),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(248.291f, 210.755f)
            lineTo(262.291f, 200.755f)
            curveTo(263.291f, 196.755f, 259.291f, 197.755f, 256.291f, 198.255f)
            curveTo(253.891f, 198.655f, 247.625f, 201.088f, 244.791f, 202.255f)
            curveTo(243.791f, 202.421f, 242.091f, 203.655f, 243.291f, 207.255f)
            curveTo(244.491f, 210.855f, 247.125f, 211.088f, 248.291f, 210.755f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(202.187f, 196.266f)
            curveTo(189.787f, 213.866f, 154.687f, 195.933f, 138.687f, 184.766f)
            curveTo(163.887f, 155.966f, 191.52f, 157.766f, 202.187f, 162.266f)
            verticalLineTo(196.266f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMinor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(202.187f, 150.766f)
            curveTo(168.587f, 121.566f, 145.02f, 158.766f, 137.687f, 181.266f)
            verticalLineTo(183.266f)
            curveTo(161.287f, 153.666f, 190.353f, 155.6f, 202.187f, 160.266f)
            verticalLineTo(150.766f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMajor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(207.687f, 196.002f)
            curveTo(220.087f, 213.602f, 255.187f, 195.669f, 271.187f, 184.502f)
            curveTo(245.987f, 155.702f, 218.353f, 157.502f, 207.687f, 162.002f)
            verticalLineTo(196.002f)
            close()
        }
        path(
            fill = SolidColor(pectoralisMinor),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(207.687f, 150.502f)
            curveTo(241.287f, 121.302f, 264.853f, 158.502f, 272.187f, 181.002f)
            verticalLineTo(183.002f)
            curveTo(248.587f, 153.402f, 219.52f, 155.336f, 207.687f, 160.002f)
            verticalLineTo(150.502f)
            close()
        }
        path(
            fill = SolidColor(lateralDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(137.687f, 132.766f)
            curveTo(108.487f, 130.766f, 105.52f, 160.266f, 107.687f, 175.266f)
            lineTo(108.687f, 176.766f)
            curveTo(109.487f, 163.566f, 128.353f, 141.933f, 137.687f, 132.766f)
            close()
        }
        path(
            fill = SolidColor(anteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(113.187f, 180.766f)
            curveTo(116.687f, 167.6f, 129.687f, 140.166f, 153.687f, 135.766f)
            curveTo(151.353f, 148.933f, 139.987f, 176.366f, 113.187f, 180.766f)
            close()
        }
        path(
            fill = SolidColor(lateralDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(273.687f, 132.863f)
            curveTo(302.887f, 130.863f, 305.853f, 160.363f, 303.687f, 175.363f)
            lineTo(302.687f, 176.863f)
            curveTo(301.887f, 163.663f, 283.02f, 142.03f, 273.687f, 132.863f)
            close()
        }
        path(
            fill = SolidColor(anteriorDeltoid),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(298.187f, 180.863f)
            curveTo(294.687f, 167.697f, 281.687f, 140.263f, 257.687f, 135.863f)
            curveTo(260.02f, 149.03f, 271.387f, 176.463f, 298.187f, 180.863f)
            close()
        }
        path(
            fill = SolidColor(biceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(311.187f, 251.266f)
            curveTo(276.787f, 226.066f, 277.187f, 196.433f, 281.687f, 184.766f)
            curveTo(304.687f, 181.766f, 313.187f, 205.266f, 313.187f, 214.266f)
            curveTo(313.187f, 221.466f, 314.187f, 232.266f, 314.687f, 236.766f)
            curveTo(317.487f, 248.766f, 313.52f, 251.433f, 311.187f, 251.266f)
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
            moveTo(346.687f, 311.766f)
            curveTo(336.287f, 273.366f, 321.02f, 259.1f, 314.687f, 256.766f)
            curveTo(313.887f, 261.166f, 315.687f, 270.6f, 316.687f, 274.766f)
            curveTo(320.853f, 283.433f, 330.087f, 301.366f, 333.687f, 303.766f)
            curveTo(338.187f, 306.766f, 358.187f, 343.266f, 359.687f, 346.266f)
            curveTo(360.887f, 348.666f, 361.187f, 347.266f, 361.187f, 346.266f)
            lineTo(346.687f, 311.766f)
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
            moveTo(299.687f, 281.766f)
            verticalLineTo(268.766f)
            curveTo(300.487f, 266.366f, 302.353f, 267.433f, 303.187f, 268.266f)
            curveTo(309.187f, 274.766f, 319.187f, 286.766f, 321.687f, 291.766f)
            curveTo(323.687f, 295.766f, 321.187f, 295.433f, 319.687f, 294.766f)
            curveTo(314.853f, 291.6f, 304.587f, 285.166f, 302.187f, 284.766f)
            curveTo(299.787f, 284.366f, 299.52f, 282.6f, 299.687f, 281.766f)
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
            moveTo(355.687f, 347.766f)
            curveTo(353.287f, 344.566f, 328.02f, 313.1f, 315.687f, 297.766f)
            curveTo(315.02f, 296.766f, 315.687f, 296.066f, 323.687f, 301.266f)
            curveTo(331.687f, 306.466f, 348.353f, 332.433f, 355.687f, 344.766f)
            curveTo(356.687f, 347.1f, 358.087f, 350.966f, 355.687f, 347.766f)
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
            moveTo(351.687f, 346.266f)
            curveTo(333.687f, 331.866f, 314.52f, 306.266f, 307.187f, 295.266f)
            curveTo(305.187f, 294.066f, 306.353f, 297.433f, 307.187f, 299.266f)
            curveTo(319.687f, 323.266f, 346.687f, 344.766f, 350.187f, 346.766f)
            curveTo(352.987f, 348.366f, 352.353f, 347.1f, 351.687f, 346.266f)
            close()
        }
        path(
            fill = SolidColor(biceps),
            fillAlpha = 1.0f,
            stroke = null,
            strokeAlpha = 1.0f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1.0f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(101.687f, 250.529f)
            curveTo(136.087f, 225.329f, 135.687f, 195.696f, 131.187f, 184.029f)
            curveTo(108.187f, 181.029f, 99.6869f, 204.529f, 99.6869f, 213.529f)
            curveTo(99.6869f, 220.729f, 98.6869f, 231.529f, 98.1869f, 236.029f)
            curveTo(95.3869f, 248.029f, 99.3535f, 250.696f, 101.687f, 250.529f)
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
            moveTo(66.1868f, 311.029f)
            curveTo(76.5868f, 272.629f, 91.8535f, 258.363f, 98.1868f, 256.029f)
            curveTo(98.9868f, 260.429f, 97.1868f, 269.863f, 96.1868f, 274.029f)
            curveTo(92.0201f, 282.696f, 82.7868f, 300.629f, 79.1868f, 303.029f)
            curveTo(74.6868f, 306.029f, 54.6868f, 342.529f, 53.1868f, 345.529f)
            curveTo(51.9868f, 347.929f, 51.6868f, 346.529f, 51.6868f, 345.529f)
            lineTo(66.1868f, 311.029f)
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
            moveTo(113.187f, 281.029f)
            verticalLineTo(268.029f)
            curveTo(112.387f, 265.629f, 110.52f, 266.696f, 109.687f, 267.529f)
            curveTo(103.687f, 274.029f, 93.6868f, 286.029f, 91.1868f, 291.029f)
            curveTo(89.1868f, 295.029f, 91.6868f, 294.696f, 93.1868f, 294.029f)
            curveTo(98.0201f, 290.863f, 108.287f, 284.429f, 110.687f, 284.029f)
            curveTo(113.087f, 283.629f, 113.353f, 281.863f, 113.187f, 281.029f)
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
            moveTo(57.1868f, 347.029f)
            curveTo(59.5868f, 343.829f, 84.8535f, 312.363f, 97.1868f, 297.029f)
            curveTo(97.8535f, 296.029f, 97.1868f, 295.329f, 89.1868f, 300.529f)
            curveTo(81.1868f, 305.729f, 64.5201f, 331.696f, 57.1868f, 344.029f)
            curveTo(56.1868f, 346.363f, 54.7868f, 350.229f, 57.1868f, 347.029f)
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
            moveTo(61.1868f, 345.529f)
            curveTo(79.1868f, 331.129f, 98.3535f, 305.529f, 105.687f, 294.529f)
            curveTo(107.687f, 293.329f, 106.52f, 296.696f, 105.687f, 298.529f)
            curveTo(93.1868f, 322.529f, 66.1868f, 344.029f, 62.6868f, 346.029f)
            curveTo(59.8868f, 347.629f, 60.5201f, 346.363f, 61.1868f, 345.529f)
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
            moveTo(40.1869f, 396.267f)
            lineTo(28.1869f, 383.267f)
            curveTo(26.5869f, 382.067f, 26.5202f, 380.1f, 26.6869f, 379.267f)
            lineTo(33.6869f, 368.267f)
            curveTo(39.5202f, 361.267f, 51.7869f, 349.867f, 54.1869f, 360.267f)
            curveTo(57.1869f, 373.267f, 49.1869f, 388.267f, 47.1869f, 394.267f)
            curveTo(45.5869f, 399.067f, 41.8535f, 397.6f, 40.1869f, 396.267f)
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
            moveTo(35.6868f, 362.267f)
            curveTo(18.0868f, 376.267f, 6.6868f, 378.767f, 3.1868f, 378.267f)
            curveTo(2.7868f, 377.067f, 3.6868f, 376.433f, 4.1868f, 376.267f)
            lineTo(31.6868f, 358.267f)
            curveTo(37.6868f, 356.667f, 36.8535f, 360.267f, 35.6868f, 362.267f)
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
            moveTo(11.6869f, 410.267f)
            lineTo(22.6869f, 386.267f)
            curveTo(24.0202f, 385.933f, 26.6869f, 385.867f, 26.6869f, 388.267f)
            curveTo(26.6869f, 391.267f, 16.6869f, 408.267f, 14.1869f, 413.767f)
            curveTo(12.1869f, 418.167f, 11.6869f, 413.267f, 11.6869f, 410.267f)
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
            moveTo(30.1869f, 398.767f)
            curveTo(31.7869f, 392.767f, 29.1869f, 393.6f, 27.6869f, 394.767f)
            curveTo(26.919f, 395.267f, 17.6869f, 418.267f, 16.6869f, 421.767f)
            curveTo(15.8869f, 424.567f, 18.3536f, 424.933f, 19.6869f, 424.767f)
            curveTo(22.5202f, 418.6f, 28.5869f, 404.767f, 30.1869f, 398.767f)
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
            moveTo(36.6869f, 403.767f)
            curveTo(37.8869f, 400.967f, 35.5202f, 399.6f, 34.1869f, 399.267f)
            lineTo(32.6869f, 400.267f)
            curveTo(30.1869f, 405.767f, 25.0869f, 417.567f, 24.6869f, 420.767f)
            curveTo(24.2869f, 423.967f, 26.8535f, 423.767f, 28.1869f, 423.267f)
            curveTo(30.5202f, 417.933f, 35.4869f, 406.567f, 36.6869f, 403.767f)
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
            moveTo(36.6869f, 413.267f)
            lineTo(42.6869f, 401.767f)
            curveTo(45.4869f, 400.167f, 45.5202f, 403.433f, 45.1869f, 405.267f)
            curveTo(44.3536f, 407.433f, 42.0869f, 412.667f, 39.6869f, 416.267f)
            curveTo(37.2869f, 419.867f, 36.6869f, 415.767f, 36.6869f, 413.267f)
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
            moveTo(129.187f, 230.766f)
            curveTo(123.987f, 240.766f, 109.687f, 253.933f, 103.187f, 259.266f)
            curveTo(103.187f, 262.066f, 105.52f, 261.433f, 106.687f, 260.766f)
            curveTo(113.02f, 256.6f, 126.387f, 246.466f, 129.187f, 239.266f)
            curveTo(131.987f, 232.066f, 130.354f, 230.6f, 129.187f, 230.766f)
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
            moveTo(372.352f, 396.953f)
            lineTo(384.352f, 383.953f)
            curveTo(385.952f, 382.753f, 386.019f, 380.787f, 385.852f, 379.953f)
            lineTo(378.852f, 368.953f)
            curveTo(373.019f, 361.953f, 360.752f, 350.553f, 358.352f, 360.953f)
            curveTo(355.352f, 373.953f, 363.352f, 388.953f, 365.352f, 394.953f)
            curveTo(366.952f, 399.753f, 370.686f, 398.287f, 372.352f, 396.953f)
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
            moveTo(376.852f, 362.953f)
            curveTo(394.452f, 376.953f, 405.852f, 379.453f, 409.352f, 378.953f)
            curveTo(409.752f, 377.753f, 408.852f, 377.12f, 408.352f, 376.953f)
            lineTo(380.852f, 358.953f)
            curveTo(374.852f, 357.353f, 375.686f, 360.953f, 376.852f, 362.953f)
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
            moveTo(400.852f, 410.953f)
            lineTo(389.852f, 386.953f)
            curveTo(388.519f, 386.62f, 385.852f, 386.553f, 385.852f, 388.953f)
            curveTo(385.852f, 391.953f, 395.852f, 408.953f, 398.352f, 414.453f)
            curveTo(400.352f, 418.853f, 400.852f, 413.953f, 400.852f, 410.953f)
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
            moveTo(382.352f, 399.453f)
            curveTo(380.752f, 393.453f, 383.352f, 394.287f, 384.852f, 395.453f)
            curveTo(385.62f, 395.953f, 394.852f, 418.953f, 395.852f, 422.453f)
            curveTo(396.652f, 425.253f, 394.186f, 425.62f, 392.852f, 425.453f)
            curveTo(390.019f, 419.287f, 383.952f, 405.453f, 382.352f, 399.453f)
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
            moveTo(375.852f, 404.453f)
            curveTo(374.652f, 401.653f, 377.019f, 400.287f, 378.352f, 399.953f)
            lineTo(379.852f, 400.953f)
            curveTo(382.352f, 406.453f, 387.452f, 418.253f, 387.852f, 421.453f)
            curveTo(388.252f, 424.653f, 385.686f, 424.453f, 384.352f, 423.953f)
            curveTo(382.019f, 418.62f, 377.052f, 407.253f, 375.852f, 404.453f)
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
            moveTo(375.852f, 413.953f)
            lineTo(369.852f, 402.453f)
            curveTo(367.052f, 400.853f, 367.019f, 404.12f, 367.352f, 405.953f)
            curveTo(368.186f, 408.12f, 370.452f, 413.353f, 372.852f, 416.953f)
            curveTo(375.252f, 420.553f, 375.852f, 416.453f, 375.852f, 413.953f)
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
            moveTo(308.187f, 259.266f)
            curveTo(301.387f, 255.666f, 288.687f, 239.1f, 283.187f, 231.266f)
            curveTo(279.987f, 228.066f, 280.52f, 233.266f, 281.187f, 236.266f)
            curveTo(283.987f, 243.866f, 298.687f, 255.766f, 305.687f, 260.766f)
            curveTo(308.487f, 261.966f, 308.52f, 260.266f, 308.187f, 259.266f)
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
            moveTo(139.187f, 222.266f)
            lineTo(137.687f, 195.766f)
            curveTo(137.187f, 193.433f, 137.087f, 190.166f, 140.687f, 195.766f)
            curveTo(144.287f, 201.366f, 146.187f, 211.766f, 146.687f, 216.266f)
            curveTo(146.687f, 223.266f, 146.187f, 236.766f, 144.187f, 234.766f)
            curveTo(142.187f, 232.766f, 140.02f, 225.6f, 139.187f, 222.266f)
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
            moveTo(200.187f, 143.266f)
            lineTo(184.687f, 112.766f)
            curveTo(184.287f, 101.566f, 185.187f, 98.7665f, 185.687f, 98.7665f)
            curveTo(188.487f, 101.566f, 197.853f, 122.266f, 202.187f, 132.266f)
            curveTo(202.587f, 140.266f, 201.02f, 142.933f, 200.187f, 143.266f)
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
            moveTo(184.187f, 124.766f)
            lineTo(178.687f, 132.266f)
            curveTo(183.087f, 135.866f, 186.52f, 134.433f, 187.687f, 133.266f)
            lineTo(184.187f, 124.766f)
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
            moveTo(179.687f, 119.266f)
            lineTo(167.187f, 131.266f)
            curveTo(163.687f, 131.266f, 155.987f, 131.166f, 153.187f, 130.766f)
            curveTo(150.387f, 130.366f, 151.353f, 128.933f, 152.187f, 128.266f)
            curveTo(158.187f, 124.433f, 171.587f, 116.366f, 177.187f, 114.766f)
            curveTo(182.787f, 113.166f, 181.187f, 117.1f, 179.687f, 119.266f)
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
            moveTo(206.187f, 129.766f)
            lineTo(198.687f, 105.766f)
            horizontalLineTo(214.687f)
            lineTo(206.187f, 129.766f)
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
            moveTo(209.187f, 132.266f)
            curveTo(210.387f, 128.266f, 220.829f, 108.266f, 225.901f, 98.7665f)
            curveTo(227.272f, 97.5665f, 226.329f, 108.933f, 225.687f, 114.766f)
            lineTo(209.687f, 143.266f)
            curveTo(209.02f, 141.266f, 207.987f, 136.266f, 209.187f, 132.266f)
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
            moveTo(221.687f, 133.266f)
            lineTo(226.187f, 124.766f)
            curveTo(229.387f, 127.166f, 230.52f, 131.433f, 230.687f, 133.266f)
            curveTo(229.087f, 135.266f, 224.02f, 134.1f, 221.687f, 133.266f)
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
            moveTo(241.687f, 130.266f)
            lineTo(228.687f, 118.266f)
            curveTo(227.487f, 113.066f, 232.52f, 114.433f, 235.187f, 115.766f)
            curveTo(243.52f, 119.6f, 259.842f, 127.766f, 258.464f, 129.766f)
            curveTo(257.086f, 131.766f, 246.705f, 130.933f, 241.687f, 130.266f)
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
            moveTo(265.687f, 232.766f)
            verticalLineTo(211.766f)
            lineTo(274.687f, 191.766f)
            lineTo(274.187f, 213.266f)
            curveTo(273.853f, 216.766f, 272.587f, 225.466f, 270.187f, 232.266f)
            curveTo(267.787f, 239.066f, 266.187f, 235.433f, 265.687f, 232.766f)
            close()
        }
    }.build()
}

