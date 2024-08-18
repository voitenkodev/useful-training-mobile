package profile.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import atom.Design
import components.Error
import components.cards.UserCard
import components.cards.ValueCard
import components.roots.ScreenRoot
import molecule.ButtonPrimary
import molecule.PaddingM
import molecule.Shadow
import molecule.Toolbar
import profile.main.components.MenuItem
import resources.Icons
import user.User

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
    toTraining: (id: String?) -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit,
    toExerciseExampleBuilder: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        user = state.user,
        toExerciseExamples = toExerciseExamples,
        toMuscles = toMuscles,
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
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
    toEquipment: () -> Unit,
    toWeightHistory: () -> Unit,
    toExerciseExampleBuilder: () -> Unit,
    toTraining: (id: String?) -> Unit,
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
                contentPadding = PaddingValues(horizontal = Design.dp.paddingL)
            ) {

                item {
                    if (user != null) {
                        UserCard(
                            name = user.name,
                            weight = user.weight,
                            height = user.height,
                            email = user.email,
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.72f)
                        )
                    }
                }

                item { PaddingM() }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                    ) {

                        ValueCard(
                            modifier = Modifier.weight(1f),
                            value = "123 KG",
                            title = "Last weight",
                            label = "At 16 jan, 2024",
                            icon = Icons.userWeight
                        )

                        ValueCard(
                            modifier = Modifier.weight(1f),
                            value = "15K KG",
                            title = "Last training",
                            label = "At 16 jan, 2024",
                            icon = Icons.trainingWeight
                        )

                    }
                }

                item { PaddingM() }

                item {
                    val toTrainingProvider = remember {
                        {
                            toTraining.invoke(null)
                        }
                    }

                    ButtonPrimary(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Start training",
                        onClick = toTrainingProvider
                    )
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

                        MenuItem(
                            icon = Icons.userWeight,
                            text = "Weight",
                            onClick = toWeightHistory,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingM,
                                horizontal = Design.dp.paddingL
                            )
                        )

                        Shadow()

                        MenuItem(
                            icon = Icons.handWeight,
                            text = "Exercises",
                            onClick = toExerciseExamples,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingM,
                                horizontal = Design.dp.paddingL
                            )
                        )

                        Shadow()

                        MenuItem(
                            icon = Icons.profile,
                            text = "Muscles",
                            onClick = toMuscles,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingM,
                                horizontal = Design.dp.paddingL
                            )
                        )

                        Shadow()

                        MenuItem(
                            icon = Icons.equipment,
                            text = "Equipment",
                            onClick = toEquipment,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingM,
                                horizontal = Design.dp.paddingL
                            )
                        )
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

                        MenuItem(
                            icon = Icons.add,
                            text = "Exercise Builder",
                            onClick = toExerciseExampleBuilder,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingM,
                                horizontal = Design.dp.paddingL
                            )
                        )

                        Shadow()

                        MenuItem(
                            icon = Icons.logout,
                            text = "Logout",
                            contentColor = Design.colors.red,
                            onClick = logout,
                            paddingValues = PaddingValues(
                                vertical = Design.dp.paddingM,
                                horizontal = Design.dp.paddingL
                            )
                        )
                    }
                }

                item { PaddingM() }
            }
        }
    }
}