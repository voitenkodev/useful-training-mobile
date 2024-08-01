package authentication.register

import androidx.compose.runtime.Immutable
import authentication.register.models.RegistrationStatus
import authentication.register.models.RegistrationSteps
import equipment.EquipmentGroup
import heightpicker.DEFAULT_INITIAL_HEIGHT
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import muscles.MuscleGroup
import user.ExperienceEnum
import weightpicker.DEFAULT_INITIAL_WEIGHT

@Immutable
internal data class State(
    val name: String = "",
    val weight: Int = DEFAULT_INITIAL_WEIGHT,
    val height: Int = DEFAULT_INITIAL_HEIGHT,
    val email: String = "",
    val password: String = "",
    val passwordRepeat: String = "",

    val selectedStep: RegistrationSteps = RegistrationSteps.Name,
    val steps: ImmutableList<RegistrationSteps> = RegistrationSteps.entries.toPersistentList(),

    val selectedExperience: ExperienceEnum? = null,
    val experiences: ImmutableList<ExperienceEnum> = ExperienceEnum.entries.toPersistentList(),

    val muscleGroups: ImmutableList<MuscleGroup> = persistentListOf(),
    val equipmentGroups: ImmutableList<EquipmentGroup> = persistentListOf(),

    val registrationStatus: RegistrationStatus = RegistrationStatus.Unavailable,
    val error: String? = null,
    val loading: Boolean = false
)