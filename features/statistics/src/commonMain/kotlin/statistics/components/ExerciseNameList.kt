package statistics.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.labels.ChipLabel
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun ExerciseNameList(
    options: ImmutableList<String>,
    querySort: String,
    visible: Boolean,
    select: (String) -> Unit,
    remove: (String) -> Unit
) {

    val opts by remember(querySort, options) {
        mutableStateOf(options.sortedByDescending { it.contains(querySort) })
    }

    if (opts.isEmpty()) return

    AnimatedVisibility(
        modifier = Modifier,
        visible = visible,
        enter = fadeIn() + expandVertically(),
        exit = shrinkVertically() + fadeOut(),
    ) {
        LazyRow(
            modifier = Modifier.padding(top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            items(opts) {
                ChipLabel(
                    provideText = { it },
                    onClick = select,
                    remove = remove
                )
            }
        }
    }
}