package decompose

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
sealed class AppGraph : Parcelable {
    object Splash : AppGraph()
    object Auth : AppGraph()
    object Trainings : AppGraph()
    data class Training(val id: String? = null) : AppGraph()
    data class Review(val id: String) : AppGraph()
}
