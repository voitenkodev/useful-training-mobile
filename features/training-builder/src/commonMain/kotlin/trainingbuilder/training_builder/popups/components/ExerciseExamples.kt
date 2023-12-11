package trainingbuilder.training_builder.popups.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import atom.Design
import components.brand.ExerciseCardDefault
import components.brand.ExerciseCardDefaultEmpty
import components.brand.ExerciseCardDefaultLoading
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.TextBody1
import trainingbuilder.training_builder.state.ExerciseExample

@Composable
internal fun ExerciseExamples(
    loading: Boolean,
    list: ImmutableList<ExerciseExample>,
    select: (ExerciseExample) -> Unit
) {


    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextBody1(
            provideText = { "Recommended for you" }
        )
    }

    PaddingM()

    val pager = rememberPagerState(
        pageCount = {
            when {
                loading -> 3
                list.isEmpty() -> 1
                else -> list.size
            }
        }
    )

    HorizontalPager(
        state = pager,
        contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
        pageSpacing = Design.dp.paddingM,
        pageSize = object : PageSize {
            override fun Density.calculateMainAxisPageSize(availableSpace: Int, pageSpacing: Int): Int {
                return ((availableSpace - 2 * pageSpacing) * 0.96f).toInt()
            }
        }
    ) {

        val item = list.getOrNull(it)

        when {
            loading -> ExerciseCardDefaultLoading()
            list.isEmpty() -> ExerciseCardDefaultEmpty()
            item != null -> ExerciseCardDefault(
                name = item.name,
                btn = "Select" to { select.invoke(item) },
                imageUrl = item.imageUrl,
                musclesWithPercent = item.muscleExerciseBundles.map { it.muscle.name to it.percentage }
            )
        }
    }


}