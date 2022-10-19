sealed class Graph(val link: String) {
    object Auth : Graph("auth_screen")

    object Trainings : Graph("trainings_screen")

    object Training : Graph("training_screen")

    object Review : Graph("review_screen")
}