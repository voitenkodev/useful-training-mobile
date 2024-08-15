package authentication.register.models

import androidx.compose.runtime.Immutable

@Immutable
internal enum class RegistrationSteps {
    Name,
    WeightHeight,
    Experience,
    MusclePicker,
    EquipmentPicker,
    EmailPassword
}