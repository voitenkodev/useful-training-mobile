package profile.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
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
import components.animation.Levitating
import components.cards.UserCard
import components.roots.ScreenRoot
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextH3
import molecule.secondaryBackground
import profile.main.components.MenuItem
import profile.main.models.User
import resources.Icons

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
    user: User,
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
                Levitating { modifier ->
                    UserCard(
                        modifier = modifier.padding(horizontal = Design.dp.paddingL),
                        name = user.name,
                        image = "https://static.vecteezy.com/system/resources/previews/017/067/906/original/ufo-seamless-background-free-vector.jpg",
                        weight = user.weight,
                        height = user.height
                    )
                }
            }

            item { PaddingXL() }

            item {
                TextH3(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Admin" }
                )
            }

            item { PaddingM() }

            item {
                Column(modifier = Modifier.secondaryBackground().fillMaxWidth()) {

                    Shadow()

                    PaddingS()

                    MenuItem(
                        icon = Icons.handWeight,
                        text = "Exercise Builder",
                        onClick = toExerciseExampleBuilder
                    )

                    PaddingS()

                    Shadow()
                }
            }

            item { PaddingXL() }

            item {
                TextH3(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Menu" }
                )
            }

            item { PaddingM() }

            item {
                Column(modifier = Modifier.secondaryBackground().fillMaxWidth()) {

                    Shadow()

                    PaddingS()

                    MenuItem(
                        icon = Icons.weigher,
                        text = "Weight History",
                        onClick = toWeightHistory
                    )

                    MenuItem(
                        icon = Icons.dumbbell,
                        text = "Exercises",
                        onClick = toExerciseExamples
                    )

                    MenuItem(
                        icon = Icons.biceps,
                        text = "Muscles",
                        onClick = toMuscles
                    )

                    MenuItem(
                        icon = Icons.equipment,
                        text = "Equipment",
                        onClick = toEquipment
                    )

                    PaddingS()

                    Shadow()
                }
            }

            item { PaddingXL() }

            item {
                TextH3(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Settings" }
                )
            }

            item { PaddingM() }

            item {

                Column(modifier = Modifier.secondaryBackground().fillMaxWidth()) {

                    Shadow()

                    PaddingS()

                    MenuItem(
                        icon = Icons.card,
                        text = "Subscriptions",
                        onClick = logout
                    )

                    MenuItem(
                        icon = Icons.support,
                        text = "Support",
                        onClick = toSupport
                    )

                    MenuItem(
                        icon = Icons.logout,
                        text = "Logout",
                        contentColor = Design.colors.red,
                        onClick = logout
                    )

                    PaddingS()

                    Shadow()
                }
            }
        }

        ShadowHeader(
            title = "Profile",
            icon = Icons.notifications to {}
        )
    }
}
