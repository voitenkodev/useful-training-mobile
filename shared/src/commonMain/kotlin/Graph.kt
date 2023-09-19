import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
sealed class Graph : Parcelable {
    object Splash : Graph()
    object Auth : Graph()
    object Trainings : Graph()
    data class Training(val id: String? = null) : Graph()
    data class Review(val id: String) : Graph()
}
