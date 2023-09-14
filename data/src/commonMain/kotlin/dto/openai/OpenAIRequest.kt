package dto.openai

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpenAIRequest(
    @SerialName("prompt")
    val prompt: String,
    @SerialName("max_tokens")
    val maxTokens: Int = 50,
    @SerialName("temperature")
    val temperature: Double = 0.7
)