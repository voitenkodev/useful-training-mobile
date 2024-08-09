package trainingbuilder.training_builder.popups

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import atom.Design
import components.EmptyData
import components.cards.ExerciseCardDefault
import components.cards.ExerciseCardDefaultLoading
import components.chips.Chip
import components.chips.ChipState
import components.inputs.InputSearch
import components.roots.PopupRoot
import components.states.animateScrollAndCentralizeItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import molecule.ButtonSecondary
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.SmallToolbar
import molecule.TextBody1
import resources.Icons
import trainingbuilder.training_builder.models.ExerciseExample
import trainingbuilder.training_builder.models.Muscle

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
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideName = { "" },
            backgroundColor = Design.colors.black10,
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

        PaddingM()

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
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
    loading: Boolean,
    list: ImmutableList<ExerciseExample>,
    select: (exerciseExample: ExerciseExample) -> Unit,
    details: (id: String) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextBody1(
            provideText = { "Recommended for you" },
            color = Design.colors.caption
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

    if (list.isEmpty()) {
        EmptyData(
            modifier = Modifier
                .padding(horizontal = Design.dp.paddingM)
                .aspectRatio(1.72f)
                .clipToBounds()
                .border(
                    width = 1.dp,
                    color = Design.colors.white10,
                    shape = Design.shape.default
                ),
            title = "Empty result",
            description = "No one recommended exercises for you"
        )
    } else if (list.isNotEmpty()) {
        HorizontalPager(
            state = pager,
            contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
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
                loading -> ExerciseCardDefaultLoading()
                item != null -> ExerciseCardDefault(
                    name = item.name,
                    btn = "Select" to { select.invoke(item) },
                    imageUrl = item.imageUrl,
                    viewDetails = { details.invoke(item.id) },
                    musclesWithPercent = item.exerciseExampleBundles.map { it.muscle.name to it.percentage }
                )
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
        backgroundColor = Design.colors.toxic.copy(alpha = 0.2f),
        borderColor = Design.colors.toxic,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.colors.caption,
        contentColor = Design.colors.content
    )

    val lazyListState = rememberLazyListState()

    val selectedIndex = remember(list) { list.indexOfFirst { it.id == selectedMuscle?.id } }

    LaunchedEffect(key1 = selectedIndex) {
        if (selectedIndex != -1) lazyListState.animateScrollAndCentralizeItem(selectedIndex)
    }

    TextBody1(
        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
        provideText = { "Target Muscle" },
        color = Design.colors.caption
    )

    PaddingM()

    LazyRow(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
        contentPadding = PaddingValues(horizontal = Design.dp.paddingM)
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