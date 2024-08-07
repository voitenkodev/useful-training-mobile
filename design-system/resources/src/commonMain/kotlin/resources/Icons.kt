package resources

import androidx.compose.ui.graphics.vector.ImageVector
import resources.icons.ArrowDown
import resources.icons.ArrowLeft
import resources.icons.ArrowRight
import resources.icons.ArrowUp
import resources.icons.Baby
import resources.icons.Card
import resources.icons.Charts
import resources.icons.CheckOff
import resources.icons.CheckOn
import resources.icons.Close
import resources.icons.Dumbbell
import resources.icons.Edit
import resources.icons.EyeOff
import resources.icons.EyeOn
import resources.icons.Filter
import resources.icons.FitnesCircle
import resources.icons.GymLifeOutline
import resources.icons.HighBattery
import resources.icons.Loading
import resources.icons.Logo
import resources.icons.LogoBackground
import resources.icons.Logout
import resources.icons.LowBattery
import resources.icons.MaleGym
import resources.icons.MediumBattery
import resources.icons.Search
import resources.icons.Timer
import resources.icons.Weight
import resources.icons.WeightGym
import resources.icons.WeightKg

public object Icons {
    // Product
    public val logo: ImageVector = Logo
    public val logoBackground: ImageVector = LogoBackground

    public val add: ImageVector = CheckOn
    public val close: ImageVector = Close
    public val save: ImageVector = CheckOn
    public val arrowLeft: ImageVector = ArrowLeft
    public val arrowUp: ImageVector = ArrowUp
    public val arrowDown: ImageVector = ArrowDown
    public val arrowRight: ImageVector = ArrowRight
    public val delete: ImageVector = Close
    public val done: ImageVector = CheckOn
    public val eye: ImageVector = EyeOn
    public val eyeOff: ImageVector = EyeOff
    public val filters: ImageVector = Filter
    public val loading: ImageVector = Loading
    public val search: ImageVector = Search
    public val checkOn: ImageVector = CheckOn
    public val checkOff: ImageVector = CheckOff

    // Trainings
    public val dumbbell: ImageVector = Dumbbell
    public val handWeight: ImageVector = WeightKg
    public val time: ImageVector = Timer
    public val weight: ImageVector = Weight
    public val weigher: ImageVector = WeightGym
    public val repetitions: ImageVector = MaleGym

    // Profile Menu
    public val edit: ImageVector = Edit
    public val equipment: ImageVector = Dumbbell
    public val muscles: ImageVector = MaleGym
    public val logout: ImageVector = Logout
    public val card: ImageVector = Card

    // Menu
    public val trainings: ImageVector = LowBattery
    public val statistics: ImageVector = Charts
    public val profile: ImageVector = MaleGym

    // Load
    public val lowBattery: ImageVector = LowBattery
    public val mediumBattery: ImageVector = MediumBattery
    public val highBattery: ImageVector = HighBattery

    // Experience
    public val beginner: ImageVector = Baby
    public val advanced: ImageVector = GymLifeOutline
    public val intermediate: ImageVector = FitnesCircle
    public val pro: ImageVector = WeightGym

    // Exercise data
    public val youtube: ImageVector = Search
    public val text: ImageVector = Search
}