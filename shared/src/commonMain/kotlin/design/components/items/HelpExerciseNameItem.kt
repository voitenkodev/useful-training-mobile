package design.components.items

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import design.Design
import design.components.labels.ChipLabel
import utils.recomposeHighlighter

@Composable
fun HelpExerciseNameItem(
    options: () -> List<String>,
    querySort: () -> String,
    visibility: () -> Boolean,
    select: (String) -> Unit
) {

    val opts by remember(querySort(), options()) {
        mutableStateOf(options().sortedByDescending { it.contains(querySort()) })
    }

    AnimatedVisibility(
        visible = visibility(),
        enter = fadeIn() + expandVertically(),
        exit = shrinkVertically() + fadeOut(),
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
        ) {
            items(opts) {
                ChipLabel(
                    modifier = Modifier.recomposeHighlighter(),
                    provideText = { it },
                    onClick = select,
                )
            }
        }
    }
}