package resources

import androidx.compose.ui.graphics.vector.ImageVector
import resources.icon.experience.Baby
import resources.icon.experience.FitnessCircle
import resources.icon.experience.GymLifeOutline
import resources.icon.experience.WeightGym
import resources.icon.menu.Charts
import resources.icon.menu.LoveGym
import resources.icon.menu.Profile
import resources.icon.outline.ArrowDown
import resources.icon.outline.ArrowLeft
import resources.icon.outline.ArrowRight
import resources.icon.outline.ArrowUp
import resources.icon.outline.Article
import resources.icon.outline.Close
import resources.icon.outline.Edit
import resources.icon.outline.EyeOff
import resources.icon.outline.EyeOn
import resources.icon.outline.Filter
import resources.icon.outline.Loading
import resources.icon.outline.Search
import resources.icon.outline.Youtube
import resources.icon.product.Logo
import resources.icon.product.LogoBackground
import resources.icon.load.HighBattery
import resources.icon.load.LowBattery
import resources.icon.load.MediumBattery
import resources.icons.Card
import resources.icons.CheckOff
import resources.icons.CheckOn
import resources.icons.Dumbbell
import resources.icons.Logout
import resources.icons.MaleGym
import resources.icons.Timer
import resources.icons.Weight
import resources.icons.WeightKg

public object Icons {
    // Product +
    public val logo: ImageVector = Logo
    public val logoBackground: ImageVector = LogoBackground

    public val add: ImageVector = CheckOn
    public val save: ImageVector = CheckOn
    public val delete: ImageVector = Close // minus
    public val checkOn: ImageVector = CheckOn
    public val checkOff: ImageVector = CheckOff

    // Interface +
    public val eye: ImageVector = EyeOn
    public val eyeOff: ImageVector = EyeOff
    public val close: ImageVector = Close
    public val arrowLeft: ImageVector = ArrowLeft
    public val arrowUp: ImageVector = ArrowUp
    public val arrowDown: ImageVector = ArrowDown
    public val arrowRight: ImageVector = ArrowRight
    public val loading: ImageVector = Loading
    public val filters: ImageVector = Filter
    public val search: ImageVector = Search

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
    public val trainings: ImageVector = LoveGym
    public val statistics: ImageVector = Charts
    public val profile: ImageVector = Profile

    // Load
    public val lowBattery: ImageVector = LowBattery
    public val mediumBattery: ImageVector = MediumBattery
    public val highBattery: ImageVector = HighBattery

    // Experience +
    public val beginner: ImageVector = Baby
    public val advanced: ImageVector = GymLifeOutline
    public val intermediate: ImageVector = FitnessCircle
    public val pro: ImageVector = WeightGym

    // Exercise data +
    public val youtube: ImageVector = Youtube
    public val text: ImageVector = Article
}