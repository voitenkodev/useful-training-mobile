package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.rememberCoroutineScope
import co.touchlab.kermit.Logger
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import datasource.Auth
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ui.designsystem.DesignComponent
import ui.designsystem.common.DesignTheme
import ui.screens.AuthScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesignTheme {
                Surface(color = DesignComponent.colors.primary) {
                    val auth = Auth()
                    val scope = rememberCoroutineScope()

                    AuthScreen(
                        login = { email, password ->
                            scope.launch {
                                auth.login(email, password)
                                    .onEach { Logger.i("success -> $it") }
                                    .catch { Logger.i("error -> $it") }
                                    .launchIn(scope)
                            }
                        },
                        registration = { email, password ->
                            scope.launch {
                                auth.registration(email, password)
                                    .onEach { Logger.i("success -> $it") }
                                    .catch { Logger.i("error -> $it") }
                                    .launchIn(scope)
                            }
                        }
                    )
                }
            }
        }
    }
}
