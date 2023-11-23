package trainingbuilder.popups.components

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
import androidx.compose.ui.unit.dp
import atom.Design
import components.brand.ExerciseCard
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.TextH4
import trainingbuilder.state.ExerciseExample

@Composable
internal fun ExerciseExamples(
    list: ImmutableList<ExerciseExample>
) {

    val pager = rememberPagerState(
        pageCount = { 5 }
    )

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextH4(
            provideText = { "Exercise examples" }
        )

        ButtonTextLink(
            modifier = Modifier.padding(bottom = 4.dp),
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
        ExerciseCard(
            modifier = Modifier,
            name = "Bench press",
            btn = "take" to {},
            btn2 = "details" to {}
        )
    }
}