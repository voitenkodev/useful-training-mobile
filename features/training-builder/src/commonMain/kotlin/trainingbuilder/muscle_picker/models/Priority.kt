package trainingbuilder.muscle_picker.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import atom.Design

@Immutable
internal sealed class PriorityEnum {
    data class High(
        val borderColors: List<Color> = listOf(
            Design.palette.toxic.copy(alpha = 0.6f),
            Design.palette.toxic.copy(alpha = 0.4f)
        ),
        val textColor: Color = Design.palette.content
    ) : PriorityEnum()

    data class Medium(
        val borderColor: Color = Design.palette.caption,
        val textColor: Color = Design.palette.content
    ) : PriorityEnum()

    data class Low(
        val borderColor: Color = Design.palette.white10,
        val textColor: Color = Design.palette.caption
    ) : PriorityEnum()
}

