package models

data class Person(
    val id: String,
    val name: String,
    val imageUrl: String,
    val date: String
) {

    companion object {
        internal val MOCK = Person(
            id = "1",
            name = "Van Gogh",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg",
            date = "01.01.2008"
        )
    }
}