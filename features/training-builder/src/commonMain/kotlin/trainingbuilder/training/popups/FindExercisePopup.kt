package trainingbuilder.training.popups

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Density
import atom.Design
import components.EmptyData
import components.LoadingData
import components.chips.Chip
import components.chips.ChipState
import components.inputs.InputSearch
import components.roots.PopupRoot
import components.states.animateScrollAndCentralizeItem
import exercise.ExerciseExample
import exercise.component.ExerciseCardSmall
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import molecule.ButtonPrimary
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.SmallToolbar
import molecule.TextBody5
import muscles.Muscle
import resources.Icons

@Composable
internal fun FindExercisePopup(
    close: () -> Unit,
    loading: Boolean,
    selectedMuscle: Muscle?,
    muscles: ImmutableList<Muscle>,
    exerciseExamples: ImmutableList<ExerciseExample>,
    setMuscleTarget: (id: String) -> Unit,
    createExercise: () -> Unit,
    selectExercise: (ExerciseExample) -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit,
    search: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    PopupRoot {

        PaddingS()

        SmallToolbar(
            title = "Find Exercise",
            icon = Icons.close to close
        )

        PaddingM()

        InputSearch(
            modifier = Modifier.padding(horizontal = Design.dp.paddingL),
            provideName = { "" },
            update = {},
            onClick = {
                coroutineScope.launch {
                    close.invoke()
                    delay(POPUP_ANIM_DURATION_MS)
                    search.invoke()
                }
            }
        )

        PaddingL()

        if (muscles.isNotEmpty()) {

            Muscles(
                list = muscles,
                setMuscleTarget = setMuscleTarget,
                selectedMuscle = selectedMuscle
            )

            PaddingL()
        }

        ExerciseExamples(
            modifier = Modifier.animateContentSize(),
            list = exerciseExamples,
            loading = loading,
            select = {
                coroutineScope.launch {
                    close.invoke()
                    delay(POPUP_ANIM_DURATION_MS)
                    selectExercise.invoke(it)
                }
            },
            details = {
                coroutineScope.launch {
                    close.invoke()
                    delay(POPUP_ANIM_DURATION_MS)
                    toExerciseExampleDetails.invoke(it)
                }
            }
        )

        Row(
            modifier = Modifier.padding(Design.dp.paddingL),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = "Create by own",
                onClick = {
                    coroutineScope.launch {
                        close.invoke()
                        delay(POPUP_ANIM_DURATION_MS)
                        createExercise.invoke()
                    }
                }
            )
        }
    }
}

@Composable
internal fun ExerciseExamples(
    modifier: Modifier = Modifier,
    loading: Boolean,
    list: ImmutableList<ExerciseExample>,
    select: (exerciseExample: ExerciseExample) -> Unit,
    details: (id: String) -> Unit
) {

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingL),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextBody5(
                provideText = { "RECOMMENDED" },
            )
        }

        PaddingM()

        val pager = rememberPagerState(
            pageCount = { list.size }
        )

        when {
            loading -> LoadingData(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Design.dp.componentL)
                    .padding(horizontal = Design.dp.paddingL)
            )

            list.isEmpty() -> EmptyData(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Design.dp.componentL)
                    .padding(horizontal = Design.dp.paddingL),
                title = "Not found",
                description = "We cannon find recommended exercises"
            )

            else -> HorizontalPager(
                modifier = Modifier.height(Design.dp.componentL),
                state = pager,
                contentPadding = PaddingValues(horizontal = Design.dp.paddingL),
                pageSpacing = Design.dp.paddingM,
                pageSize = object : PageSize {
                    override fun Density.calculateMainAxisPageSize(
                        availableSpace: Int,
                        pageSpacing: Int
                    ): Int {
                        return ((availableSpace - 2 * pageSpacing) * 0.96f).toInt()
                    }
                }
            ) {

                val item = list.getOrNull(it)

                when {
                    item != null -> ExerciseCardSmall(
                        modifier = Modifier,
                        exerciseExample = item,
                        onClick = { select.invoke(item) },
                        viewDetails = { details.invoke(item.id) },
                    )
                }
            }
        }
    }
}

@Composable
internal fun Muscles(
    selectedMuscle: Muscle?,
    list: ImmutableList<Muscle>,
    setMuscleTarget: (id: String) -> Unit
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.green,
        borderColor = Color.Transparent,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.tertiary,
        borderColor = Color.Transparent,
        contentColor = Design.colors.content
    )

    val lazyListState = rememberLazyListState()

    val selectedIndex = remember(list) { list.indexOfFirst { it.id == selectedMuscle?.id } }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyListState.animateScrollAndCentralizeItem(selectedIndex)
    }

    TextBody5(
        modifier = Modifier.padding(horizontal = Design.dp.paddingL),
        provideText = { "MUSCLE" },
    )

    PaddingM()

    LazyRow(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        contentPadding = PaddingValues(horizontal = Design.dp.paddingL)
    ) {
        items(list, key = { it.id }) {
            Chip(
                chipState = if (it.id == selectedMuscle?.id) selectedChipState else unSelectedChipState,
                text = it.name,
                onClick = { setMuscleTarget.invoke(it.id) }
            )
        }
    }
}