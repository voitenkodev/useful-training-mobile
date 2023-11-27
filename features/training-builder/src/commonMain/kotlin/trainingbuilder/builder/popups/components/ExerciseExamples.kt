package trainingbuilder.builder.popups.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.brand.ExerciseCard
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.TextBody1
import trainingbuilder.builder.state.ExerciseExample

@Composable
internal fun ExerciseExamples(list: ImmutableList<ExerciseExample>) {

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
        pageSpacing = Design.dp.paddingS
    ) {
        val item = list.getOrNull(it) ?: return@HorizontalPager

        ExerciseCard(
            name = item.name,
            btn = "Select" to {},
            btn2 = "Details" to {},
            imageUrl = item.imageUrl
        )
    }
}