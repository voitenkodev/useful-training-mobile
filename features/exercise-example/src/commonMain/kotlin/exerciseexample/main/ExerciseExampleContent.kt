package exerciseexample.main

import AsyncImage
import ColorUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import atom.Design
import basic.LineChart
import basic.LineChartDotsStyle
import basic.LineChartLabelStyle
import basic.LineChartStyle
import components.Error
import components.chips.Chip
import components.chips.ChipState
import components.overlay.TopShadow
import components.roots.ScreenRoot
import exerciseexample.main.models.ExerciseExample
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextBody1
import molecule.TextH2
import molecule.TextLabel
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground
import percents
import pie.PieChart
import pie.PieChartData

@Composable
internal fun ExerciseExampleContent(
    vm: ExerciseExampleViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        exerciseExample = state.exerciseExample,
        fullFrontImage = state.fullFrontImageVector,
        fullBackImage = state.fullBackImageVector
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    exerciseExample: ExerciseExample?,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector
) {

    val pieData = remember(exerciseExample) {
        exerciseExample?.muscleExerciseBundles
            ?.map { PieChartData(value = it.percentage, color = ColorUtils.randomColor(), title = it.muscle.name) }
            ?.sortedByDescending { it.value }
            ?.toPersistentList()
            ?: persistentListOf()
    }

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            Box(modifier = Modifier.height(IntrinsicSize.Min)) {

                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    url = exerciseExample?.imageUrl,
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

                Column(modifier = Modifier.statusBarsPadding()) {

                    PaddingXL()

                    TextH2(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        provideText = { exerciseExample?.name },
                    )

                    PaddingM()

                    TextBody1(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        provideText = {
                            "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                                    "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum"
                        }
                    )

                    PaddingXL()
                }

                Shadow(modifier = Modifier.align(Alignment.BottomCenter))
            }

//            PaddingXL()
//
//            TextLabel(
//                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
//                provideText = { "Video tutorial" }
//            )
//
//            PaddingS()
//
//            VideoPlayer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(2f)
//                    .padding(horizontal = Design.dp.paddingM)
//                    .secondaryDefaultBackground(),
//                url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
//            )

            PaddingXL()

            TextLabel(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Muscle Pack" }
            )

            PaddingS()

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.paddingM),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                Column(
                    modifier = Modifier.weight(0.6f),
                    verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    repeat(pieData.size) {

                        val item = pieData.getOrNull(it) ?: return@repeat

                        Chip(
                            chipState = ChipState.Colored(
                                backgroundColor = item.color.copy(alpha = 0.2f),
                                borderColor = item.color,
                                contentColor = Design.colors.content
                            ),
                            text = buildString {
                                append(item.title)
                                append(" ")
                                append(item.value.percents())
                            }
                        )
                    }
                }

                PieChart(
                    modifier = Modifier.padding(Design.dp.paddingM).weight(0.4f).aspectRatio(1f),
                    data = pieData
                )
            }

            PaddingXL()

            TextLabel(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Heap Map" }
            )

            PaddingS()

            Column(modifier = Modifier.secondaryBackground()) {

                Shadow()

                Row(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingXL, vertical = Design.dp.paddingM),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                ) {

                    Image(
                        modifier = Modifier.weight(1f).aspectRatio(0.8f),
                        contentDescription = null,
                        imageVector = fullFrontImage
                    )

                    Image(
                        modifier = Modifier.weight(1f).aspectRatio(0.8f),
                        contentDescription = null,
                        imageVector = fullBackImage
                    )
                }

                Shadow()
            }

            PaddingXL()

            TextLabel(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Last 5 volumes" }
            )

            PaddingS()

            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .secondaryDefaultBackground()
                    .padding(Design.dp.paddingM)
                    .height(140.dp)
                    .padding(start = Design.dp.paddingM, end = Design.dp.paddingM),
                values = listOf(1000f, 6900f, 2000f, 3000f, 5000f),
                chartStyle = LineChartStyle(
                    lineColor = Design.colors.content,
                    labelStyle = LineChartLabelStyle(
                        backgroundColor = Design.colors.toxic.copy(alpha = 0.2f),
                        borderColor = Design.colors.toxic,
                        paddings = Design.dp.paddingXS,
                        textColor = Design.colors.content,
                        spaceTillLine = 26.dp,
                        borderWidth = 1.dp
                    ),
                    dotsStyle = LineChartDotsStyle(
                        backgroundColor = Design.colors.orange,
                        width = 6.dp,
                        type = LineChartDotsStyle.DotsType.START_END
                    )
                )
            )

            PaddingXL()
        }



        Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            TopShadow(modifier = Modifier.fillMaxSize())
            Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingXL))
        }
    }
}