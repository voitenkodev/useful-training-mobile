package profile.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.ShadowHeader
import components.ShadowHeaderSpace
import components.cards.UserCard
import components.roots.ScreenRoot
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextH4
import molecule.secondaryDefaultBackground
import profile.main.components.MenuItem
import resources.Icons
import user.User

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
    toExerciseExamples: () -> Unit,
    toMuscles: () -> Unit,
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
        toExerciseExampleBuilder = toExerciseExampleBuilder,
        toSupport = {},
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
    toSupport: () -> Unit,
    toWeightHistory: () -> Unit,
    toExerciseExampleBuilder: () -> Unit,
    logout: () -> Unit
) {

    val listState = rememberLazyListState()

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth().animateContentSize().fillMaxSize()
        ) {

            item("shadow_header_space") {
                ShadowHeaderSpace()
                PaddingM()
            }

            item {
                PaddingM()
            }

            item {
                if (user != null) {
                    UserCard(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        name = user.name,
                        weight = user.weight,
                        height = user.height,
                        email = user.email,
                        experienceIcon = user.experience.icon
                    )
                } else {
                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = Design.dp.paddingM)
                            .fillMaxWidth()
                            .aspectRatio(1.72f)
                    )
                }
            }

//            item { PaddingXL() }
//
//            item {
//                TextH4(
//                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
//                    provideText = { "Admin panel" },
//                    color = Design.colors.yellow
//                )
//            }
//
//            item { PaddingS() }
//
//            item {
//                Column(
//                    modifier = Modifier
//                        .padding(horizontal = Design.dp.paddingM)
//                        .secondaryDefaultBackground()
//                        .fillMaxWidth()
//                ) {
//                    MenuItem(
//                        icon = Icons.person,
//                        text = "Exercise Builder",
//                        onClick = toExerciseExampleBuilder
//                    )
//                }
//            }

            item { PaddingM() }

            item {
                TextH4(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "User Data" },
                    color = Design.colors.caption
                )
            }

            item { PaddingS() }

            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingM)
                        .secondaryDefaultBackground()
                        .fillMaxWidth()
                ) {

                    MenuItem(
                        icon = Icons.weight,
                        text = "Weight",
                        onClick = toWeightHistory,
                        paddingValues = PaddingValues(
                            vertical = Design.dp.paddingM,
                            horizontal = Design.dp.paddingL
                        )
                    )

                    Shadow()

                    MenuItem(
                        icon = Icons.exercises,
                        text = "Exercises",
                        onClick = toExerciseExamples,
                        paddingValues = PaddingValues(
                            vertical = Design.dp.paddingM,
                            horizontal = Design.dp.paddingL
                        )
                    )

                    Shadow()

                    MenuItem(
                        icon = Icons.exercises,
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
                TextH4(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingL),
                    provideText = { "Settings" },
                    color = Design.colors.caption
                )
            }

            item { PaddingS() }

            item {

                Column(
                    modifier = Modifier
                        .padding(horizontal = Design.dp.paddingM)
                        .secondaryDefaultBackground()
                        .fillMaxWidth()
                ) {

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

            item { PaddingXL() }
        }

        ShadowHeader(
            title = "Profile",
        )
    }
}
