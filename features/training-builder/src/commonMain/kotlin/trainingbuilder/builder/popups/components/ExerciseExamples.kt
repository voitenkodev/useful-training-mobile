package trainingbuilder.builder.popups.components

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
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.TextBody1
import trainingbuilder.builder.state.ExerciseExample

@Composable
internal fun ExerciseExamples(
    list: ImmutableList<ExerciseExample>,
    select: (ExerciseExample) -> Unit
) {

    val pager = rememberPagerState(pageCount = { list.size })

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextBody1(
            provideText = { "Recommended for you" }
        )

        ButtonTextLink(
            text = "See all",
            onClick = {}
        )
    }

    PaddingM()

    HorizontalPager(
        state = pager,
        contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
        pageSpacing = Design.dp.paddingM,
        pageSize = object : PageSize {
            override fun Density.calculateMainAxisPageSize(availableSpace: Int, pageSpacing: Int): Int {
                return ((availableSpace - 2 * pageSpacing) * 0.96f).toInt()
            }
        },
    ) {
        val item = list.getOrNull(it) ?: return@HorizontalPager

        ExerciseCardDefault(
            modifier = Modifier,
            name = item.name,
            btn = "Select" to { select.invoke(item) },
            imageUrl = item.imageUrl,
            musclesWithPercent = item.muscleExerciseBundles.map { it.muscle.name to it.percentage }
        )
    }
}