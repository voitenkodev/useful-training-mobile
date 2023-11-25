package components.brand

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.ButtonSecondarySmall
import molecule.PaddingM
import molecule.TextBody1
import molecule.TextBody3
import molecule.TextH4
import molecule.secondaryDefaultBackground
import percents
import pie.PieChart
import pie.PieChartData

@Composable
public fun ExerciseCard(
    modifier: Modifier = Modifier,
    name: String,
    btn: Pair<String, () -> Unit>,
    btn2: Pair<String, () -> Unit>,
    musclesWithPercent: List<Pair<String, Float>> = emptyList()
) {

    Box(
        modifier
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = "https://barbend.com/wp-content/uploads/2023/01/Barbend-Featured-Image-1200x675-A-person-doing-bench-press-exercises.jpg",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(
            modifier = modifier
                .padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingL)
        ) {
            Row(modifier = Modifier.weight(1f)) {

                TextH4(
                    modifier = Modifier.weight(1f),
                    provideText = { name },
                    maxLines = 2,
                    color = Design.colors.content
                )


                PieChart(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f),
                    data = listOf(
                        PieChartData(
                            value = 30f,
                            title = "Triceps",
                            color = Design.colors.purple
                        ),
                        PieChartData(
                            value = 55f,
                            title = "Pectoralis Minor",
                            color = Design.colors.yellow
                        ),
                        PieChartData(
                            value = 10f,
                            title = "Biceps",
                            color = Design.colors.blue
                        ),
                        PieChartData(
                            value = 5f,
                            title = "Legs",
                            color = Design.colors.red
                        )
                    ),
                    selectionView = {
                        if (it == null) return@PieChart

                        Column(
                            modifier = Modifier.padding(Design.dp.paddingM),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            TextBody1(
                                provideText = { it.value.toInt().percents() },
                                textAlign = TextAlign.Center
                            )

                            TextBody3(
                                provideText = { it.title },
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }

            PaddingM()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                ButtonPrimarySmall(
                    text = btn.first,
                    onClick = btn.second
                )

                ButtonSecondarySmall(
                    text = btn2.first,
                    onClick = btn2.second
                )
            }
        }
    }
}