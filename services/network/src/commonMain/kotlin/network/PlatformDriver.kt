package network

import NativeContext
import io.ktor.client.HttpClient

internal expect fun NativeContext.driver(): HttpClient