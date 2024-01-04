package musclepickerpicker

import androidx.compose.ui.graphics.Color
import atom.Design

internal object Colors {
    val muscle = Design.palette.content
    val bg = Design.palette.secondary

    val defaultFront = muscle.copy(alpha = 0.3f)
    val defaultBack = muscle.copy(alpha = 0.3f)

    val backgroundFront = bg
    val backgroundBack = bg

    val outline = Color.Transparent
}