package components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import controls.ButtonIconBrand
import controls.TextFieldH2
import recomposeHighlighter

@Composable
internal fun TrainingTitle(
    mainTitle: () -> String,
    click: () -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        TextFieldH2(
            modifier = Modifier
                .wrapContentHeight()
                .recomposeHighlighter(),
            provideText = mainTitle,
        )

        ButtonIconBrand(
            backgroundColor = Design.colors.tertiary,
            imageVector = Icons.Default.KeyboardArrowRight,
            onClick = click
        )
    }
}