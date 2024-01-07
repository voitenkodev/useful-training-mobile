package equipments

import AlienWorkoutDatabase
import NativeContext
import database

public class EquipmentsSource(nativeContext: NativeContext) {

    private val database: AlienWorkoutDatabase = nativeContext.database()
    private val muscleApi by lazy { database.muscleQueries }

}