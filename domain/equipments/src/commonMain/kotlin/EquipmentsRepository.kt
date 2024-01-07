import kotlinx.coroutines.flow.Flow
import models.EquipmentGroup
import models.Muscle
import models.MuscleGroup

public interface EquipmentsRepository {
    public fun observeEquipments(): Flow<List<EquipmentGroup>>
    public fun syncUserEquipments(): Flow<Unit>
    public fun syncPublicEquipments(): Flow<Unit>
    public fun clearCache()
}