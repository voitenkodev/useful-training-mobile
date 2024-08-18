package resources

import androidx.compose.ui.graphics.vector.ImageVector
import resources.icon.experience.Baby
import resources.icon.experience.FitnessCircle
import resources.icon.experience.GymLifeOutline
import resources.icon.experience.WeightGym
import resources.icon.filled.Card
import resources.icon.filled.CheckOn
import resources.icon.filled.Dumbbell
import resources.icon.filled.Kg
import resources.icon.filled.Logout
import resources.icon.filled.MaleGym
import resources.icon.filled.Minus
import resources.icon.filled.Plus
import resources.icon.filled.Timer
import resources.icon.filled.Weight
import resources.icon.load.HighBattery
import resources.icon.load.LowBattery
import resources.icon.load.MediumBattery
import resources.icon.menu.Charts
import resources.icon.menu.LoveGym
import resources.icon.menu.Profile
import resources.icon.outline.ArrowDown
import resources.icon.outline.ArrowDownDouble
import resources.icon.outline.ArrowLeft
import resources.icon.outline.ArrowRight
import resources.icon.outline.ArrowUp
import resources.icon.outline.Article
import resources.icon.outline.CheckOff
import resources.icon.outline.Close
import resources.icon.outline.Edit
import resources.icon.outline.EmptyTraining
import resources.icon.outline.EyeOff
import resources.icon.outline.EyeOn
import resources.icon.outline.Filter
import resources.icon.outline.Height
import resources.icon.outline.Loading
import resources.icon.outline.Search
import resources.icon.outline.TrainingWeight
import resources.icon.outline.UserWeight
import resources.icon.outline.Youtube
import resources.icon.product.Logo
import resources.icon.product.LogoBackground

public object Icons {

    // Product
    public val logo: ImageVector = Logo
    public val logoBackground: ImageVector = LogoBackground

    // Interface
    public val eye: ImageVector = EyeOn
    public val eyeOff: ImageVector = EyeOff
    public val close: ImageVector = Close
    public val arrowLeft: ImageVector = ArrowLeft
    public val arrowUp: ImageVector = ArrowUp
    public val arrowDown: ImageVector = ArrowDown
    public val arrowDownDouble: ImageVector = ArrowDownDouble
    public val arrowRight: ImageVector = ArrowRight
    public val loading: ImageVector = Loading
    public val filters: ImageVector = Filter
    public val search: ImageVector = Search
    public val checkOn: ImageVector = CheckOn
    public val checkOff: ImageVector = CheckOff
    public val add: ImageVector = Plus
    public val save: ImageVector = CheckOn
    public val delete: ImageVector = Minus

    // Trainings
    public val handWeight: ImageVector = Kg
    public val time: ImageVector = Timer
    public val weight: ImageVector = Weight
    public val weigher: ImageVector = WeightGym
    public val repetitions: ImageVector = Dumbbell
    public val emptyTraining: ImageVector = EmptyTraining
    public val height: ImageVector = Height

    // Profile
    public val edit: ImageVector = Edit
    public val equipment: ImageVector = Dumbbell
    public val exercises: ImageVector = MaleGym
    public val logout: ImageVector = Logout
    public val card: ImageVector = Card
    public val userWeight: ImageVector = UserWeight
    public val trainingWeight: ImageVector = TrainingWeight

    // Menu
    public val trainings: ImageVector = LoveGym
    public val statistics: ImageVector = Charts
    public val profile: ImageVector = Profile

    // Load
    public val lowBattery: ImageVector = LowBattery
    public val mediumBattery: ImageVector = MediumBattery
    public val highBattery: ImageVector = HighBattery

    // Experience
    public val beginner: ImageVector = Baby
    public val advanced: ImageVector = GymLifeOutline
    public val intermediate: ImageVector = FitnessCircle
    public val pro: ImageVector = WeightGym

    // Exercise
    public val youtube: ImageVector = Youtube
    public val text: ImageVector = Article
}