package co.edu.uniandes.misw4302.viajasinestres.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import co.edu.uniandes.misw4302.viajasinestres.R

private val defaultTypography = Typography()

object AppFont {
    val FiraSans = FontFamily(
        Font(R.font.firasans_light, FontWeight.Light),
        Font(R.font.firasans_lightitalic, FontWeight.Light, style = FontStyle.Italic),
        Font(R.font.firasans_regular),
        Font(R.font.firasans_italic, style = FontStyle.Italic),
        Font(R.font.firasans_medium, FontWeight.Medium),
        Font(R.font.firasans_mediumitalic, FontWeight.Medium, style = FontStyle.Italic),
        Font(R.font.firasans_semibold, FontWeight.SemiBold),
        Font(R.font.firasans_semibolditalic, FontWeight.SemiBold, style = FontStyle.Italic),
        Font(R.font.firasans_bold, FontWeight.Bold),
        Font(R.font.firasans_bolditalic, FontWeight.Bold, style = FontStyle.Italic)
    )
}

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = AppFont.FiraSans),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = AppFont.FiraSans),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = AppFont.FiraSans),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = AppFont.FiraSans),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = AppFont.FiraSans),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = AppFont.FiraSans),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = AppFont.FiraSans),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = AppFont.FiraSans),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = AppFont.FiraSans),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = AppFont.FiraSans),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = AppFont.FiraSans),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = AppFont.FiraSans),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = AppFont.FiraSans),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = AppFont.FiraSans),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = AppFont.FiraSans)
)