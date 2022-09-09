package auth

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.controls.ButtonPrimary
import designsystem.controls.InputFieldBody1

@Composable
fun AuthContent(
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

        Spacer(Modifier.height(60.dp))

        InputFieldBody1(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            value = email.value,
            onValueChange = { email.value = it },
//            leadingIcon = Icons.Outlined.Person,
            placeholder = "Email"
        )

        InputFieldBody1(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            value = password.value,
            onValueChange = { password.value = it },
//            leadingIcon = Icons.Outlined.Lock,
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