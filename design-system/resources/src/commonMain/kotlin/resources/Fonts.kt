package resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import com.voitenko.alienworkout.designsystem.resources.MulishBlack
import com.voitenko.alienworkout.designsystem.resources.MulishBlackItalic
import com.voitenko.alienworkout.designsystem.resources.MulishBold
import com.voitenko.alienworkout.designsystem.resources.MulishBoldItalic
import com.voitenko.alienworkout.designsystem.resources.MulishExtraBold
import com.voitenko.alienworkout.designsystem.resources.MulishExtraBoldItalic
import com.voitenko.alienworkout.designsystem.resources.MulishExtraLight
import com.voitenko.alienworkout.designsystem.resources.MulishExtraLightItalic
import com.voitenko.alienworkout.designsystem.resources.MulishItalic
import com.voitenko.alienworkout.designsystem.resources.MulishLight
import com.voitenko.alienworkout.designsystem.resources.MulishLightItalic
import com.voitenko.alienworkout.designsystem.resources.MulishMedium
import com.voitenko.alienworkout.designsystem.resources.MulishMediumItalic
import com.voitenko.alienworkout.designsystem.resources.MulishRegular
import com.voitenko.alienworkout.designsystem.resources.MulishSemiBold
import com.voitenko.alienworkout.designsystem.resources.MulishSemiBoldItalic
import com.voitenko.alienworkout.designsystem.resources.Res
import org.jetbrains.compose.resources.Font

public object Fonts {

    @Composable
    public fun Primary(): FontFamily {
        return FontFamily(
            Font(Res.font.MulishBlack),
            Font(Res.font.MulishBlackItalic),
            Font(Res.font.MulishBold),
            Font(Res.font.MulishBoldItalic),
            Font(Res.font.MulishExtraBold),
            Font(Res.font.MulishExtraBoldItalic),
            Font(Res.font.MulishExtraLight),
            Font(Res.font.MulishExtraLightItalic),
            Font(Res.font.MulishItalic),
            Font(Res.font.MulishLight),
            Font(Res.font.MulishLightItalic),
            Font(Res.font.MulishMedium),
            Font(Res.font.MulishMediumItalic),
            Font(Res.font.MulishRegular),
            Font(Res.font.MulishSemiBold),
            Font(Res.font.MulishSemiBoldItalic),
        )
    }
}