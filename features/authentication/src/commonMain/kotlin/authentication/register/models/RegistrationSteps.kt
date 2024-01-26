package authentication.register.models

import androidx.compose.runtime.Immutable

@Immutable
internal enum class RegistrationSteps {
    Name,
    Weight,
    Height,
    Experience,
    MusclePicker,
    EquipmentPicker,
    EmailPassword
}