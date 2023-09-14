package dto.openai

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpenAIResponse(
    @SerialName("choices")
    val choices: List<ChoiceDTO>
)