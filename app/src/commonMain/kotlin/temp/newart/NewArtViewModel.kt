package temp.newart//package com.voitenko.dev.galleryspace.newart
//
//import android.graphics.Bitmap
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.voitenko.dev.galleryspace.temp.ImageSaver
//import com.voitenko.dev.galleryspace.db.AppDataSource
//import kotlinx.coroutines.flow.*
//import kotlinx.datetime.toLocalDateTime
//
//class NewArtViewModel(
//    private val source: AppDataSource,
//    private val imageSaver: temp.ImageSaver,
//) : ViewModel() {
//
//    private val _state = MutableStateFlow(NewArt())
//    val state: StateFlow<NewArt> = _state
//
//    data class NewArt(
//        val image: Bitmap? = null,
//        val title: TextFieldValue = TextFieldValue(""),
//        val description: TextFieldValue = TextFieldValue(""),
//        val price: String = "",
//        val createAt: String = "",
//    )
//
//    fun set(
//        image: Bitmap? = null,
//        title: TextFieldValue? = null,
//        description: TextFieldValue? = null,
//        price: String? = null,
//        date: String? = null
//    ) {
//        _state.value = _state.value.copy(
//            image = image ?: _state.value.image,
//            title = title ?: _state.value.title,
//            description = description ?: _state.value.description,
//            price = price ?: _state.value.price,
//            createAt = date ?: _state.value.createAt
//        )
//    }
//
//    fun save(success: () -> Unit, error: () -> Unit) = source
//        .setArt(
//        url = imageSaver.saveToFile(state.value.image).toString(),
//        title = state.value.title.text,
//        description = state.value.description.text,
//        price = state.value.price,
//        createdAt = state.value.createAt.toLocalDateTime(),
//        proprietors = emptyList()
//    )
//        .onEach { success.invoke() }
//        .catch { error.invoke() }
//        .launchIn(viewModelScope)
//}