package statistics.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import atom.Design
import statistics.state.Exercise
import statistics.state.Info

@Composable
internal fun Exercises(
    modifier: Modifier = Modifier,
    exercises: Map<Info, List<Exercise>>
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        contentPadding = PaddingValues(Design.dp.paddingS)
    ) {
        exercises.forEach { item ->

            item {
                ExerciseHeader(
                    modifier = Modifier.padding(top = Design.dp.paddingS),
                    weekDay = item.key.weekDay,
                    date = item.key.dateTime
                )
            }

            itemsIndexed(item.value) { index, exercise ->
                val number by rememberUpdatedState(index + 1)
                Exercise(
                    modifier = Modifier,
                    provideNumber = { number },
                    exercise = { exercise }
                )
            }
        }
    }
}