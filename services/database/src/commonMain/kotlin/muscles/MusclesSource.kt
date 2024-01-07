package muscles

import AlienWorkoutDatabase
import NativeContext
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import muscles.mapping.mapToDao
import muscles.models.MuscleDao
import muscles.models.MuscleGroupDao

public class MusclesSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val muscleApi by lazy { database.muscleQueries }

    public fun getMuscleGroups(): Flow<List<MuscleGroupDao>> {
        return muscleApi
            .getMuscleGroups()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .transform { emit(it.mapToDao()) }
    }

    public fun getMusclesByIds(ids: List<String>): Flow<List<MuscleDao>> {
        return muscleApi
            .getMusclesById(ids)
            .asFlow()
            .mapToList(Dispatchers.Default)
            .map { it.map { item -> item.mapToDao() } }
    }

    public fun setMuscleGroupsWithMuscles(groups: List<MuscleGroupDao>) {
        muscleApi.transaction {
            groups.forEach { group ->
                muscleApi.setMuscleGroup(
                    id = group.id,
                    name = group.name,
                    createdAt = group.createdAt,
                    updatedAt = group.updatedAt,
                    type = group.type
                )

                group.muscles.forEach { muscle ->
                    muscleApi.setMuscle(
                        id = muscle.id,
                        name = muscle.name,
                        createdAt = muscle.createdAt,
                        updatedAt = muscle.updatedAt,
                        muscleGroupId = muscle.muscleGroupId,
                        type = muscle.type,
                        status = muscle.status
                    )
                }
            }
        }
    }

    public fun setMuscle(muscle: MuscleDao) {
        muscleApi.setMuscle(
            id = muscle.id,
            name = muscle.name,
            createdAt = muscle.createdAt,
            updatedAt = muscle.updatedAt,
            muscleGroupId = muscle.muscleGroupId,
            type = muscle.type,
            status = muscle.status
        )
    }

    public fun clearTables() {
        muscleApi.deleteTableMuscle()
        muscleApi.deleteTableMuscleGroup()
    }
}