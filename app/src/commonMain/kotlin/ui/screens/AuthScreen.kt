package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.designsystem.controls.ButtonPrimary
import ui.designsystem.controls.InputFieldPrimary

@Composable
fun AuthScreen(
    registration: (String, String) -> Unit,
    login: (String, String) -> Unit
) {
    val email = rememberSaveable { mutableStateOf("voitenko.dev@gmail.com") }
    val password = rememberSaveable { mutableStateOf("qwerty123") }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Spacer(Modifier.height(80.dp))

        InputFieldPrimary(
            modifier = Modifier.fillMaxWidth(),
            value = email.value,
            onValueChange = { email.value = it },
            leadingIcon = Icons.Outlined.Person,
            placeholder = "Email"
        )

        InputFieldPrimary(
            modifier = Modifier.fillMaxWidth(),
            value = password.value,
            onValueChange = { password.value = it },
            leadingIcon = Icons.Outlined.Lock,
            placeholder = "Password"
        )

        Spacer(Modifier.weight(1f))

        ButtonPrimary(
            modifier = Modifier.fillMaxWidth(),
            text = "Login",
            onClick = { login.invoke(email.value, password.value) }
        )

        ButtonPrimary(
            modifier = Modifier.fillMaxWidth(),
            text = "Registration",
            onClick = { registration.invoke(email.value, password.value) }
        )

        Spacer(Modifier.height(20.dp))
    }
}