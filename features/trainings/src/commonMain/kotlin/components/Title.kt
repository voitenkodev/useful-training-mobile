package components

import Design
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1
import controls.TextFieldH1
import controls.TextFieldH2
import recomposeHighlighter

@Composable
internal fun TrainingTitle(
    modifier: Modifier = Modifier,
    mainTitle: () -> String,
    subTitle: () -> String,
    titleColor: Color = Design.colors.content
) {

    Box(
        modifier = modifier.height(44.dp)
    ) {

        TextFieldH2(
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentHeight()
                .recomposeHighlighter(),
            provideText = mainTitle,
            color = titleColor
        )

        TextFieldBody1(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .recomposeHighlighter(),
            provideText = subTitle,
        )
    }
}