package trainings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import controls.TextFieldBody1
import controls.TextFieldH1
import recomposeHighlighter

@Composable
internal fun TrainingTitle(
    modifier: Modifier = Modifier,
    weekDay: () -> String,
    date: () -> String,
    titleColor: Color
) = Column(
    modifier = modifier.recomposeHighlighter()
) {

    TextFieldH1(
        modifier = Modifier
            .wrapContentHeight()
            .recomposeHighlighter(),
        provideText = weekDay,
        color = titleColor
    )

    TextFieldBody1(
        modifier = Modifier
            .recomposeHighlighter(),
        provideText = date,
    )
}