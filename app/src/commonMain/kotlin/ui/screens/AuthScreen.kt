package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import co.touchlab.kermit.Logger
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.launch
import ui.designsystem.controls.ButtonPrimary

@Composable
fun AuthScreen() {
    val scope = rememberCoroutineScope()
    Column {
        ButtonPrimary(
            text = "Auth",
            onClick = {
                scope.launch {
                    val res = Firebase.auth.signInWithEmailAndPassword(
                        email = "voitenko.dev@gmail.com",
                        password = "qwerty123"
                    )
                    Logger.i { res.toString() }
                }
            }
        )
    }
}