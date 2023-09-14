package dto.openai

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChoiceDTO(
    @SerialName("text")
    val text: String,
    @SerialName("finish_reason")
    val finishReason: String
)