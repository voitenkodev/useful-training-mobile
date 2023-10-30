import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

@Parcelize
public data class NavStringParam(
    public val param: String?
) : Parcelable