package source.database.mappers

import data.Iteration
import dto.backend.IterationDTO

fun Iteration.toDto(): IterationDTO {
    return IterationDTO(
        id = this.id,
        weight = this.weight,
        repeat = this.repeat?.toInt()
    )
}