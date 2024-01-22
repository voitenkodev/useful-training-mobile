package data.exerciseexamples.mapping

import data.equipments.mapping.daoToDomain
import data.equipments.mapping.dtoToDomain
import exercise_examples.models.ExerciseExampleDao
import models.ExerciseExample
import network.models.ExerciseExampleDto

internal fun List<ExerciseExampleDao>.daoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.daoToDomain() }
}

internal fun ExerciseExampleDao.daoToDomain(): ExerciseExample {
    return ExerciseExample(
        id = id,
        name = name,
        description = description,
        exerciseExampleBundles = exerciseExampleBundles.daoToDomain(),
        equipments = equipments.map { it.equipment.daoToDomain() },
        imageUrl = imageUrl
    )
}

internal fun List<ExerciseExampleDto>.dtoToDao(): List<ExerciseExampleDao> {
    return mapNotNull { it.dtoToDao() }
}

internal fun ExerciseExampleDto.dtoToDao(): ExerciseExampleDao? {
    return ExerciseExampleDao(
        id = id ?: return null,
        name = name ?: return null,
        description = description,
        exerciseExampleBundles = exerciseExampleBundles.dtoToDao(),
        equipments = equipmentRefs.mapNotNull { it.dtoToDao() },
        createdAt = createdAt ?: return null,
        updatedAt = updatedAt ?: return null,
        imageUrl = imageUrl
    )
}

internal fun ExerciseExample.domainToDto(): ExerciseExampleDto {
    return ExerciseExampleDto(
        id = id,
        name = name,
        description = description,
        exerciseExampleBundles = exerciseExampleBundles.domainToDto()
    )
}

internal fun List<ExerciseExampleDto>.dtoToDomain(): List<ExerciseExample> {
    return mapNotNull { it.dtoToDomain() }
}

internal fun ExerciseExampleDto.dtoToDomain(): ExerciseExample? {
    return ExerciseExample(
        id = id ?: return null,
        name = name ?: return null,
        description = description,
        exerciseExampleBundles = exerciseExampleBundles.dtoToDomain(),
        equipments = equipmentRefs.mapNotNull { it.equipment?.dtoToDomain() },
        imageUrl = imageUrl
    )
}