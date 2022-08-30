package models

data class Art(
    val id: String,
    val url: String,
    val title: String,
    val description: String,
    val price: String,
    val createdAt: String,
    val creator: Person,
    val owner: Person,
) {

    companion object {
        internal val MOCK = Art(
            id = "4",
            url = "https://html5css.ru/css/img_forest.jpg",
            title = "Armor\n1891",
            description = "This fantastical drawing of a helmeted woman in profile is one of four similar charcoal drawings Redon executed during the last decade of the nineteenth century. The sitter, rendered strangely mute by her helmetlike covering and untouchable by its thorny needles, varies slightly from sheet to sheet. While the exact meaning of Redon's image is unclear, it has been thought that the bizarre bondage imposed on his sitter expresses subconscious fear of female sexuality or, conversely, serves as a symbol of female fecundity. Equally important, however, is Redon's virtuoso handling of charcoal and his ability to capture its full range of tones, from the dark velvet quality of the helmet to the pallor of the woman's skin.",
            creator = Person.MOCK,
            owner = Person.MOCK,
            price = "199 $",
            createdAt = "19 May, 1891",
        )
    }
}