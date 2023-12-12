package trainingbuilder.training_builder.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import atom.Design
import components.Error
import components.overlay.BottomShadow
import components.roots.ScreenRoot
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextH3
import molecule.TextLabel
import molecule.primaryBackground
import trainingbuilder.training_builder.state.Exercise

@Composable
internal fun ExercisesPage(
    error: String?,
    loading: Boolean,
    volume: Double,
    clearError: () -> Unit,
    exercises: ImmutableList<Exercise>,
    addExercise: () -> Unit,
    selectExercise: (index: Int) -> Unit,
    finish: () -> Unit,

    fullFront: ImageVector,
    fullBack: ImageVector
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize()) {

            Header(
                finish = finish,
                loading = loading,
                finishEnabled = exercises.isNotEmpty()
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f).primaryBackground(),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                item(key = "overview") {

                    TextLabel(provideText = { "Overview" })

                    PaddingM()

                    TrainingOverview(
                        fullFrontImage = fullFront,
                        fullBackImage = fullBack,
                        volume = volume
                    )
                }

                item("exercise_title") {
                    TextLabel(provideText = { "Exercises" })
                }

                if (exercises.isEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    shape = Design.shape.default,
                                    color = Design.colors.caption
                                ).padding(Design.dp.paddingL),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            TextH3(
                                provideText = { "Let's start workout" },
                                color = Design.colors.content
                            )

                            PaddingXS()

                            TextBody1(
                                provideText = { "Add your first exercise" },
                                color = Design.colors.content
                            )

                            PaddingL()

                            ButtonPrimary(
                                modifier = Modifier.padding(horizontal = Design.dp.paddingXL),
                                text = "New exercise",
                                textColor = Design.colors.primary,
                                backgroundColor = Design.colors.toxic,
                                onClick = addExercise
                            )
                        }
                    }
                }

                itemsIndexed(exercises) { index, item ->
                    Exercise(
                        number = index + 1,
                        exercise = item,
                        onClick = { selectExercise.invoke(index) }
                    )
                }

                item("add_exercise") {
                    Spacer(
                        modifier = Modifier
                            .navigationBarsPadding()
                            .size(Design.dp.componentM + Design.dp.paddingS)
                    )
                }
            }
        }

        if (exercises.isNotEmpty()) {
            BottomShadow(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                    .navigationBarsPadding()
                    .size(Design.dp.componentM + Design.dp.paddingM)
            )

            ButtonPrimary(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .navigationBarsPadding()
                    .padding(Design.dp.paddingM),
                text = "New exercise",
                textColor = Design.colors.primary,
                backgroundColor = Design.colors.toxic,
                onClick = addExercise
            )
        }
    }
}