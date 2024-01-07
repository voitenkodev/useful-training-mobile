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
import muscles.models.MuscleTypeDao

public class MusclesSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val muscleApi by lazy { database.muscleQueries }

    public fun getMuscleTypes(): Flow<List<MuscleTypeDao>> {
        return muscleApi
            .getMuscleTypes()
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

    public fun setMuscleTypesWithMuscles(muscleTypes: List<MuscleTypeDao>) {
        muscleApi.transaction {
            muscleTypes.forEach { muscleType ->
                muscleApi.setMuscleType(
                    id = muscleType.id,
                    name = muscleType.name,
                    createdAt = muscleType.createdAt,
                    updatedAt = muscleType.updatedAt,
                    type = muscleType.type
                )

                muscleType.muscles.forEach { muscle ->
                    muscleApi.setMuscle(
                        id = muscle.id,
                        name = muscle.name,
                        createdAt = muscle.createdAt,
                        updatedAt = muscle.updatedAt,
                        muscleTypeId = muscle.muscleTypeId,
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
            muscleTypeId = muscle.muscleTypeId,
            type = muscle.type,
            status = muscle.status
        )
    }

    public fun clearTables() {
        muscleApi.deleteTableMuscle()
        muscleApi.deleteTableMuscleType()
    }
}