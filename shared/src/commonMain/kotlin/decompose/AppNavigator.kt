package decompose

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
sealed class AppNavigator : Parcelable {
    object ScreenOne : AppNavigator()
    data class ScreenTwo(val name: String) : AppNavigator()
}
