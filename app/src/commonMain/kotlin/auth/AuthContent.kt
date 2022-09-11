package auth

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.controls.ButtonPrimary
import designsystem.controls.InputFieldPrimary

@Composable
fun AuthContent(
    state: AuthState,
    update: (AuthState) -> Unit,
    registration: (AuthState) -> Unit,
    login: (AuthState) -> Unit
) = Column(
    modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(12.dp)
) {

    Spacer(Modifier.height(60.dp))

    InputFieldPrimary(
        modifier = Modifier.padding(12.dp).fillMaxWidth(),
        value = state.email,
        onValueChange = { update(state.copy(email = it)) },
//            leadingIcon = Icons.Outlined.Person,
        placeholder = "Email"
    )

    InputFieldPrimary(
        modifier = Modifier.padding(12.dp).fillMaxWidth(),
        value = state.password,
        onValueChange = { update(state.copy(password = it)) },
//            leadingIcon = Icons.Outlined.Lock,
        placeholder = "Password"
    )

    Spacer(Modifier.weight(1f))

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Login",
        onClick = { login.invoke(state) }
    )

    ButtonPrimary(
        modifier = Modifier.fillMaxWidth(),
        text = "Registration",
        onClick = { registration.invoke(state) }
    )

    Spacer(Modifier.height(20.dp))
}