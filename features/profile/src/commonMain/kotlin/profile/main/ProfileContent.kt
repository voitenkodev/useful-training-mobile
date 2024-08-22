package profile.main

import DateTimeKtx
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import atom.Design
import components.Error
import components.cards.ValueCardAction
import components.cards.VerticalValueCard
import components.roots.ScreenRoot
import exercise.ExerciseExample
import exercise.component.ExerciseItem
import kg
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonText
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextBody4
import molecule.Toolbar
import profile.main.components.MenuItem
import resources.Icons
import trainings.Training
import user.User
import user.WeightHistory
import user.component.UserCardSmall

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
    toTraining: (id: String?) -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit,
    toExerciseExampleById: (id: String) -> Unit,
    toExerciseExampleBuilder: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        user = state.user,
        lastWeight = state.lastWeight,
        lastExerciseExample = state.lastExerciseExamples,
        lastTraining = state.lastTraining,
        toExerciseExamples = toExerciseExamples,
        toMuscles = toMuscles,
        toExerciseExampleById = toExerciseExampleById,
        toEquipment = toEquipment,
        toWeightHistory = toWeightHistory,
        toTraining = toTraining,
        toExerciseExampleBuilder = toExerciseExampleBuilder,
        logout = vm::logout
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    user: User?,
    lastWeight: WeightHistory?,
    lastExerciseExample: ImmutableList<ExerciseExample>,
    lastTraining: Training?,
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit,
    toExerciseExampleBuilder: () -> Unit,
    toTraining: (id: String?) -> Unit,
    toExerciseExampleById: (id: String) -> Unit,
    logout: () -> Unit
) {

    val listState = rememberLazyListState()

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {

            Toolbar(
                title = "Profile"
            )

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .animateContentSize(),
                contentPadding = PaddingValues(
                    horizontal = Design.dp.paddingL,
                    vertical = Design.dp.paddingM
                )
            ) {

                item {
                    UserCardSmall(
                        user = user,
                        edit = {}
                    )
                }

                item { PaddingM() }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                    ) {

                        val lastWeightValue = remember(lastWeight?.weight) {
                            lastWeight?.weight?.kg(allowUnit = true) ?: ""
                        }

                        val lastWeightLabel = remember(lastWeight?.createdAt) {
                            DateTimeKtx.convert(
                                lastWeight?.createdAt,
                                DateTimeKtx.Format.DD_MMM_YYYY
                            ) ?: ""
                        }

                        VerticalValueCard(
                            modifier = Modifier.weight(1f),
                            value = lastWeightValue,
                            title = "Last weight",
                            label = "At $lastWeightLabel",
                            icon = Icons.userWeight,
                            action = ValueCardAction(
                                title = "HISTORY",
                                onClick = toWeightHistory,
                                trailingIcon = Icons.arrowRight,
                                color = Design.colors.orange,
                                textDecoration = TextDecoration.None
                            )
                        )

                        val lastTrainingValue = remember(lastTraining?.volume) {
                            lastTraining?.volume?.kg(allowUnit = true) ?: ""
                        }

                        val lastTrainingLabel = remember(lastTraining?.createdAt) {
                            DateTimeKtx.convert(
                                lastTraining?.createdAt,
                                DateTimeKtx.Format.DD_MMM_YYYY
                            ) ?: ""
                        }

                        VerticalValueCard(
                            modifier = Modifier.weight(1f),
                            value = lastTrainingValue,
                            title = "Last training",
                            label = lastTrainingLabel,
                            icon = Icons.trainingWeight,
                            action = ValueCardAction(
                                title = "OVERVIEW",
                                onClick = {}, // TODO ADD
                                trailingIcon = Icons.arrowRight,
                                color = Design.colors.orange,
                                textDecoration = TextDecoration.None
                            )
                        )
                    }
                }

                item { PaddingM() }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                shape = Design.shape.large,
                                color = Design.colors.secondary
                            ).padding(
                                vertical = Design.dp.paddingM
                            ).animateContentSize(),
                        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = Design.dp.paddingM),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                        ) {

                            TextBody4(
                                modifier = Modifier.weight(1f),
                                provideText = { "LAST EXERCISES" },
                            )

                            ButtonText(
                                text = "ALL",
                                trailingIcon = Icons.arrowRight,
                                onClick = toExerciseExamples,
                                color = Design.colors.orange,
                                textDecoration = TextDecoration.None
                            )
                        }

                        lastExerciseExample.forEach { ex ->

                            val onDetailsClick = remember(ex.id) {
                                {
                                    toExerciseExampleById.invoke(ex.id)
                                }
                            }

                            ExerciseItem(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(horizontal = Design.dp.paddingM)
                                    .animateItemPlacement(),
                                exerciseExample = ex,
                                viewDetails = onDetailsClick
                            )
                        }
                    }
                }

                item { PaddingM() }

                item {
                    Column(
                        modifier = Modifier
                            .clip(
                                shape = Design.shape.large
                            ).background(
                                color = Design.palette.secondary
                            ).fillMaxWidth()
                    ) {

                        PaddingM()

                        TextBody4(
                            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                            provideText = { "USER SETTINGS" },
                        )

                        PaddingS()

                        MenuItem(
                            icon = Icons.profile,
                            text = "Muscles",
                            onClick = toMuscles,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingS,
                                horizontal = Design.dp.paddingM
                            )
                        )

                        MenuItem(
                            icon = Icons.equipment,
                            text = "Equipment",
                            onClick = toEquipment,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingS,
                                horizontal = Design.dp.paddingM
                            )
                        )

                        MenuItem(
                            icon = Icons.logout,
                            text = "Logout",
                            contentColor = Design.colors.orange,
                            onClick = logout,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingS,
                                horizontal = Design.dp.paddingM
                            )
                        )

                        PaddingS()
                    }
                }

                item { PaddingM() }


                item {
                    Column(
                        modifier = Modifier
                            .clip(
                                shape = Design.shape.large
                            ).background(
                                color = Design.palette.secondary
                            ).fillMaxWidth()
                    ) {

                        PaddingM()

                        TextBody4(
                            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                            provideText = { "ADMIN SETTINGS" },
                        )

                        PaddingS()

                        MenuItem(
                            icon = Icons.add,
                            text = "Exercise Builder",
                            onClick = toExerciseExampleBuilder,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingS,
                                horizontal = Design.dp.paddingM
                            )
                        )

                        PaddingS()
                    }
                }
            }
        }
    }
}