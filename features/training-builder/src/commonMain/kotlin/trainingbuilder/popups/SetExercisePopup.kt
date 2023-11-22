package trainingbuilder.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.brand.ExerciseCard
import components.roots.PopupRoot
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.Shadow
import molecule.TextH4
import molecule.secondaryRoundBackground
import platformBottomInset
import trainingbuilder.components.EditExercise
import trainingbuilder.state.Iteration

@Composable
internal fun SetExercisePopup(
    // Common
    close: () -> Unit,

    // Exercise
    number: () -> Int,
    iterations: () -> List<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    updateWeight: (Int, String) -> Unit,
    updateRepeat: (Int, String) -> Unit,
    remove: () -> Unit

    // Examples
) {

    val pager = rememberPagerState(
        pageCount = { 5 }
    )

    PopupRoot(
        modifier = Modifier.fillMaxHeight(0.9f),
        title = "Add Exercise",
        close = close
    ) {

        EditExercise(
            modifier = Modifier.weight(1f).verticalScroll(rememberScrollState()),
            number = number,
            name = name,
            updateName = updateName,
            updateWeight = updateWeight,
            updateRepeat = updateRepeat,
            iterations = iterations,
            remove = remove
        )

        Shadow()

        PaddingM()

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

        PaddingM()

        SetExerciseFooter(
            cancel = {},
            set = {}
        )
    }
}

@Composable
private fun SetExerciseFooter(
    cancel: () -> Unit,
    set: () -> Unit,
) {

    Column(modifier = Modifier.fillMaxWidth().secondaryRoundBackground()) {

        Shadow()

        Row(
            modifier = Modifier
                .padding(Design.dp.paddingM)
                .platformBottomInset(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "cancel",
                onClick = cancel
            )

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = "Set",
                onClick = set
            )
        }
    }
}