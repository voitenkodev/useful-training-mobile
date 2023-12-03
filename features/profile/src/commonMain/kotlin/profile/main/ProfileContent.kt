package profile.main

import Icons
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atom.Design
import components.Error
import components.animation.Levitating
import components.brand.UserCard
import components.roots.ScreenRoot
import molecule.PaddingL
import molecule.PaddingS
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextH3
import molecule.secondaryBackground
import platformTopInset
import profile.main.components.Header
import profile.main.components.MenuItem
import profile.main.state.User

@Composable
internal fun ProfileContent(
    vm: ProfileViewModel,
    toExerciseExamples: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        user = state.user,
        updateUser = {},
        toExerciseExamples = toExerciseExamples,
        toWeightHistory = {},
        toSupport = {},
        logout = vm::logout
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,

    user: User,
    updateUser: () -> Unit,

    toExerciseExamples: () -> Unit,
    toSupport: () -> Unit,
    toWeightHistory: () -> Unit,
    logout: () -> Unit
) {

    val listState = rememberLazyListState()


    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth().animateContentSize().fillMaxSize()
        ) {

            item {
                Spacer(
                    modifier = Modifier
                        .platformTopInset()
                        .size(Design.dp.paddingXL + Design.dp.componentL)
                )
            }

            item {
                Levitating { modifier ->
                    UserCard(
                        modifier = modifier.padding(horizontal = Design.dp.paddingL),
                        name = user.name,
                        weight = user.weight,
                        height = user.height,
                        btn = "Upgrade" to updateUser
                    )
                }
            }

            item { PaddingL() }

            item { PaddingXL() }

            item {
                TextH3(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Menu" }
                )
            }

            item { PaddingS() }

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
                        text = "Exercise",
                        onClick = toExerciseExamples
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

            item { PaddingS() }

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

        Header()
    }
}