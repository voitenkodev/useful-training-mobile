package musclepickerpicker

import androidx.compose.ui.graphics.Color
import atom.Design

internal object Colors {
    val muscle = Color.White
    val bg = Design.palette.secondary
//    (0xffd4b296)


    val defaultFront = muscle.copy(alpha = 0.3f)
    val defaultBack = muscle.copy(alpha = 0.4f)

    val backgroundFront = bg
    val backgroundBack = bg

    val outline = Color.White.copy(alpha = 0.3f)
}