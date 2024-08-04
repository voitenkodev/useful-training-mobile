package resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val LogoBackground: ImageVector
    get() {
        if (_Logobackground != null) {
            return _Logobackground!!
        }
        _Logobackground = ImageVector.Builder(
            name = "Logobackground",
            defaultWidth = 767.dp,
            defaultHeight = 1102.dp,
            viewportWidth = 767f,
            viewportHeight = 1102f
        ).apply {
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(669.9f, 732.7f)
                moveToRelative(-61.4f, 13f)
                arcToRelative(
                    62.8f,
                    62.8f,
                    123.1f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    122.9f,
                    -26f
                )
                arcToRelative(
                    62.8f,
                    62.8f,
                    123.1f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -122.9f,
                    26f
                )
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(658.9f, 761.7f)
                curveTo(614.2f, 765.3f, 606.7f, 737.2f, 608.5f, 722.8f)
                curveTo(608.5f, 704.8f, 636f, 669.3f, 671.6f, 670.6f)
                curveTo(700.1f, 671.6f, 710f, 691.1f, 711.4f, 700.7f)
                curveTo(712.5f, 719.6f, 703.6f, 758.2f, 658.9f, 761.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(679.4f, 685.1f)
                curveTo(669.2f, 668.7f, 644.2f, 678.3f, 632.9f, 685.1f)
                curveTo(624.4f, 691f, 610f, 706.3f, 620.2f, 720.4f)
                curveTo(630.4f, 734.6f, 651.8f, 728.2f, 661.2f, 723.3f)
                curveTo(671.5f, 717.4f, 689.6f, 701.5f, 679.4f, 685.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2A3F))) {
                moveTo(601.6f, 767.9f)
                curveTo(588.3f, 757.3f, 599.2f, 740.1f, 606.9f, 732.7f)
                lineTo(608.1f, 722f)
                curveTo(594.7f, 732.7f, 586.7f, 743.7f, 584.1f, 747.9f)
                curveTo(579.9f, 754.4f, 572.3f, 769.6f, 575.6f, 778.6f)
                curveTo(578.9f, 787.6f, 587.3f, 793.3f, 591.2f, 795f)
                curveTo(596.8f, 799f, 620.4f, 803.5f, 669.2f, 789.5f)
                curveTo(718f, 775.4f, 749.4f, 742.1f, 759f, 727.1f)
                curveTo(764.1f, 720.5f, 771.5f, 703.4f, 760.1f, 688.7f)
                curveTo(748.7f, 674.1f, 717.6f, 676.3f, 703.2f, 679.4f)
                lineTo(712.1f, 686.2f)
                curveTo(718.6f, 686.2f, 722.6f, 687.2f, 724f, 687.7f)
                curveTo(735.3f, 690.9f, 751.4f, 703.6f, 725.8f, 728.9f)
                curveTo(700.2f, 754.2f, 666.7f, 767.4f, 653.1f, 770.9f)
                curveTo(641.5f, 774.3f, 615f, 778.5f, 601.6f, 767.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2A3F))) {
                moveTo(618.6f, 770.8f)
                curveTo(595.4f, 766.7f, 594.7f, 748.5f, 607.5f, 739.4f)
                lineTo(608f, 744.1f)
                curveTo(600.2f, 758.9f, 615f, 761.7f, 615f, 761.7f)
                curveTo(676.3f, 767.4f, 725.7f, 711.9f, 726.9f, 709f)
                curveTo(728.8f, 704.8f, 731.4f, 698.1f, 719.7f, 694.2f)
                lineTo(715.8f, 689f)
                curveTo(741.7f, 693.2f, 736.5f, 710f, 731.4f, 716.8f)
                curveTo(706.4f, 749.8f, 648.2f, 776f, 618.6f, 770.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(601.6f, 91.4f)
                moveToRelative(-51.6f, -51.6f)
                arcToRelative(
                    73f,
                    73f,
                    90f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    103.2f,
                    103.2f
                )
                arcToRelative(
                    73f,
                    73f,
                    90f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -103.2f,
                    -103.2f
                )
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(575.1f, 62.1f)
                curveTo(564.3f, 54.3f, 549.7f, 48.4f, 543.9f, 46.7f)
                curveTo(551.4f, 35.6f, 564.1f, 28.1f, 569.5f, 25.8f)
                curveTo(596.5f, 34.2f, 624.4f, 71.4f, 641.6f, 86.7f)
                curveTo(655.4f, 99f, 669.2f, 100.1f, 674.2f, 98.8f)
                curveTo(673.7f, 104.9f, 671.2f, 117.8f, 666.7f, 123f)
                curveTo(662.2f, 128.2f, 657.1f, 129.8f, 655.1f, 130f)
                curveTo(654.6f, 130.8f, 649f, 129.7f, 630.4f, 119.3f)
                curveTo(611.8f, 108.9f, 600.4f, 92.6f, 597f, 85.8f)
                curveTo(594.2f, 81.2f, 585.9f, 69.9f, 575.1f, 62.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(550.9f, 66f)
                curveTo(545.2f, 58.4f, 541.9f, 53.2f, 540.6f, 51.4f)
                curveTo(540.6f, 51.4f, 535.9f, 58.7f, 533.3f, 65.5f)
                curveTo(530.6f, 72.3f, 557.7f, 95.2f, 564.6f, 90.2f)
                curveTo(571.5f, 85.2f, 568.3f, 80.7f, 565.9f, 79f)
                curveTo(563.3f, 77.9f, 556.7f, 73.6f, 550.9f, 66f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(648.1f, 68.1f)
                curveTo(659.6f, 78.2f, 668.9f, 77.2f, 672.2f, 75.5f)
                lineTo(673.2f, 79.3f)
                lineTo(673.5f, 83.3f)
                curveTo(672.1f, 83.5f, 667.2f, 82.9f, 657.9f, 82.6f)
                curveTo(648.6f, 82.2f, 637.9f, 73.1f, 633.7f, 68.6f)
                curveTo(630.1f, 64.7f, 624.2f, 56.7f, 629f, 55.6f)
                curveTo(635.1f, 54.2f, 637.9f, 57.9f, 638.8f, 58.8f)
                lineTo(648.1f, 68.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(632.3f, 39.3f)
                curveTo(628.2f, 30.7f, 621.6f, 23.6f, 618.8f, 21.2f)
                curveTo(648.2f, 28.2f, 664.1f, 52.2f, 668.1f, 63f)
                curveTo(663.3f, 62.6f, 658.5f, 60.9f, 656.9f, 60.2f)
                curveTo(650.4f, 56.8f, 636.4f, 47.9f, 632.3f, 39.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(600.5f, 20.5f)
                curveTo(588.2f, 19.4f, 584.1f, 26.4f, 583.6f, 30.1f)
                curveTo(583.8f, 33.6f, 586.7f, 36.8f, 588.1f, 38f)
                curveTo(591.5f, 40.7f, 600.9f, 45.7f, 612f, 43.1f)
                curveTo(623.1f, 40.5f, 622.6f, 34f, 621f, 31.1f)
                curveTo(619.3f, 28f, 612.8f, 21.5f, 600.5f, 20.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(665.8f, 125.8f)
                curveTo(616.3f, 147.8f, 554.8f, 101.3f, 531.4f, 73.3f)
                curveTo(521f, 126.1f, 554.8f, 151.2f, 571.8f, 158.4f)
                curveTo(622.8f, 178.8f, 655.7f, 144.6f, 665.8f, 125.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(647.2f, 103.5f)
                curveTo(636.4f, 100.9f, 629.3f, 91.5f, 627.2f, 87.2f)
                curveTo(623.9f, 83.9f, 616.8f, 78.8f, 614.2f, 84.4f)
                curveTo(610.9f, 91.4f, 619.7f, 99.3f, 623.5f, 103f)
                curveTo(627.2f, 106.7f, 636.5f, 112.3f, 645.3f, 115.6f)
                curveTo(652.4f, 118.2f, 656f, 115.1f, 656.9f, 113.2f)
                curveTo(658.2f, 111.1f, 658f, 106.1f, 647.2f, 103.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2A2A3F))) {
                moveTo(523.9f, 47.2f)
                curveTo(525.8f, 27.5f, 549.5f, 27.2f, 561.6f, 30f)
                lineTo(572.8f, 24.4f)
                curveTo(553.8f, 18.1f, 538f, 17.3f, 532.3f, 17.4f)
                curveTo(523.3f, 17.4f, 503.7f, 19.7f, 497f, 28.6f)
                curveTo(490.3f, 37.5f, 490.1f, 49.4f, 490.9f, 54.2f)
                curveTo(490.6f, 62.2f, 501.1f, 88f, 545.8f, 126.7f)
                curveTo(590.4f, 165.4f, 642.8f, 174.8f, 663.5f, 174.6f)
                curveTo(673.2f, 175.4f, 694.5f, 171.8f, 701.6f, 151.4f)
                curveTo(708.7f, 130.9f, 686.7f, 102.1f, 674.6f, 90f)
                lineTo(673.7f, 103f)
                curveTo(677.8f, 109.3f, 679.3f, 113.9f, 679.7f, 115.6f)
                curveTo(683.8f, 128.6f, 681.6f, 152.4f, 640.7f, 143.5f)
                curveTo(599.7f, 134.5f, 565.6f, 110.3f, 553.7f, 99.3f)
                curveTo(543f, 90.1f, 522.1f, 66.9f, 523.9f, 47.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(244.2f, 146.9f)
                moveToRelative(-60.8f, 0f)
                arcToRelative(
                    60.8f,
                    60.8f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    121.6f,
                    0f
                )
                arcToRelative(
                    60.8f,
                    60.8f,
                    0f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -121.6f,
                    0f
                )
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(196.8f, 113.8f)
                arcToRelative(
                    47.3f,
                    55.8f,
                    112.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    103.3f,
                    42.1f
                )
                arcToRelative(
                    47.3f,
                    55.8f,
                    112.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -103.3f,
                    -42.1f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(218.7f, 111.1f)
                arcToRelative(
                    22.6f,
                    38.3f,
                    114.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    69.8f,
                    31.4f
                )
                arcToRelative(
                    22.6f,
                    38.3f,
                    114.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -69.8f,
                    -31.4f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(194.2f, 175.1f)
                curveTo(215.6f, 175.8f, 262.7f, 167.8f, 291.7f, 132.3f)
                curveTo(294.3f, 128.9f, 296.6f, 125.8f, 298.5f, 123f)
                curveTo(296.3f, 126.3f, 294.1f, 129.4f, 291.7f, 132.3f)
                curveTo(273.9f, 155.2f, 239.9f, 188.2f, 205.1f, 188.2f)
                curveTo(201.4f, 186f, 194.2f, 180.3f, 194.2f, 175.1f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(289.8f, 112.1f)
                curveTo(270.7f, 126f, 213.8f, 139.6f, 187.7f, 144.7f)
                curveTo(184.2f, 146.4f, 184.8f, 142.5f, 185.5f, 140.4f)
                curveTo(241.1f, 131.7f, 276.7f, 115f, 287.6f, 107.8f)
                lineTo(289.8f, 112.1f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(192f, 120.8f)
                curveTo(215.1f, 113.8f, 261.9f, 99.2f, 269.6f, 95.1f)
                curveTo(269.8f, 95f, 270f, 94.9f, 270.2f, 94.8f)
                curveTo(270.1f, 94.9f, 269.8f, 95f, 269.6f, 95.1f)
                curveTo(256.8f, 102.5f, 224.5f, 117.4f, 192f, 120.8f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(170f, 932f)
                moveToRelative(-150.8f, -77.3f)
                arcToRelative(
                    169.4f,
                    169.4f,
                    72.1f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    301.5f,
                    154.5f
                )
                arcToRelative(
                    169.4f,
                    169.4f,
                    72.1f,
                    isMoreThanHalf = true,
                    isPositiveArc = true,
                    -301.5f,
                    -154.5f
                )
            }
            path(fill = SolidColor(Color(0xFF373751))) {
                moveTo(29.6f, 839.5f)
                arcToRelative(
                    128.2f,
                    167.1f,
                    117.1f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    297.4f,
                    152.4f
                )
                arcToRelative(
                    128.2f,
                    167.1f,
                    117.1f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -297.4f,
                    -152.4f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(93.4f, 872.1f)
                arcToRelative(
                    38.8f,
                    39.9f,
                    92.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    57.3f,
                    54.3f
                )
                arcToRelative(
                    38.8f,
                    39.9f,
                    92.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -57.3f,
                    -54.3f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(91.5f, 874f)
                arcToRelative(
                    36.5f,
                    39.5f,
                    124.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    57.3f,
                    54.3f
                )
                arcToRelative(
                    36.5f,
                    39.5f,
                    124.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -57.3f,
                    -54.3f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(241.6f, 977.4f)
                arcToRelative(
                    26.7f,
                    24.2f,
                    83f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    48.5f,
                    4f
                )
                arcToRelative(
                    26.7f,
                    24.2f,
                    83f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -48.5f,
                    -4f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(241.5f, 979.3f)
                arcToRelative(
                    25f,
                    24f,
                    61f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    48.5f,
                    4f
                )
                arcToRelative(
                    25f,
                    24f,
                    61f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -48.5f,
                    -4f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF454560))) {
                moveTo(214.9f, 836.7f)
                arcToRelative(
                    17.4f,
                    19.7f,
                    99.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    33.9f,
                    18.8f
                )
                arcToRelative(
                    17.4f,
                    19.7f,
                    99.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -33.9f,
                    -18.8f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(214.2f, 837.7f)
                arcToRelative(
                    16.3f,
                    19.6f,
                    107.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    33.9f,
                    18.8f
                )
                arcToRelative(
                    16.3f,
                    19.6f,
                    107.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -33.9f,
                    -18.8f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF454560))) {
                moveTo(228.1f, 916.3f)
                arcToRelative(
                    5.2f,
                    6.7f,
                    101.8f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    11.7f,
                    6f
                )
                arcToRelative(
                    5.2f,
                    6.7f,
                    101.8f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -11.7f,
                    -6f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(227.2f, 917.9f)
                arcToRelative(
                    4.9f,
                    6.7f,
                    106f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    11.7f,
                    6f
                )
                arcToRelative(
                    4.9f,
                    6.7f,
                    106f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -11.7f,
                    -6f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(151.1f, 825.4f)
                arcToRelative(
                    4.8f,
                    6.2f,
                    101.8f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    10.8f,
                    5.6f
                )
                arcToRelative(
                    4.8f,
                    6.2f,
                    101.8f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -10.8f,
                    -5.6f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(150.2f, 826.8f)
                arcToRelative(
                    4.5f,
                    6.2f,
                    106f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    10.8f,
                    5.6f
                )
                arcToRelative(
                    4.5f,
                    6.2f,
                    106f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -10.8f,
                    -5.6f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(126.4f, 822.6f)
                arcToRelative(
                    3.5f,
                    4.6f,
                    90.7f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    8.6f,
                    2.5f
                )
                arcToRelative(
                    3.5f,
                    4.6f,
                    90.7f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -8.6f,
                    -2.5f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(126f, 823.8f)
                arcToRelative(
                    3.3f,
                    4.5f,
                    94.9f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    8.6f,
                    2.5f
                )
                arcToRelative(
                    3.3f,
                    4.5f,
                    94.9f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -8.6f,
                    -2.5f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(202.4f, 1038.4f)
                arcToRelative(
                    9.9f,
                    12.3f,
                    73.4f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    24.1f,
                    -0.1f
                )
                arcToRelative(
                    9.9f,
                    12.3f,
                    73.4f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -24.1f,
                    0.1f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(202.7f, 1040.7f)
                arcToRelative(
                    9.3f,
                    12.2f,
                    78.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    24.1f,
                    -0.1f
                )
                arcToRelative(
                    9.3f,
                    12.2f,
                    78.3f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -24.1f,
                    0.1f
                )
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 0.1f
            ) {
                moveTo(90.9f, 990.6f)
                arcToRelative(
                    26f,
                    38.6f,
                    111.5f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    61.9f,
                    42.4f
                )
                arcToRelative(
                    26f,
                    38.6f,
                    111.5f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -61.9f,
                    -42.4f
                )
                close()
            }
            path(fill = SolidColor(Color(0xFF1F1F2D))) {
                moveTo(87.9f, 996.1f)
                arcToRelative(
                    24.3f,
                    38.4f,
                    114.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    61.9f,
                    42.4f
                )
                arcToRelative(
                    24.3f,
                    38.4f,
                    114.2f,
                    isMoreThanHalf = true,
                    isPositiveArc = false,
                    -61.9f,
                    -42.4f
                )
                close()
            }
        }.build()

        return _Logobackground!!
    }

@Suppress("ObjectPropertyName")
private var _Logobackground: ImageVector? = null
