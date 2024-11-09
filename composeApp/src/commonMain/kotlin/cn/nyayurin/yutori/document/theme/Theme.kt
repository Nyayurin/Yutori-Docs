package cn.nyayurin.yutori.document.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val lightScheme =
    lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

private val darkScheme =
    darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

@Composable
fun Theme(
    darkMode: Boolean,
    typography: Typography,
    content: @Composable () -> Unit,
) {
    val color =
        when (darkMode) {
            true -> darkScheme
            else -> lightScheme
        }

    val animationSpec = remember { tween<Color>(600) }
    val colorScheme =
        ColorScheme(
            animateColorAsState(color.primary, animationSpec).value,
            animateColorAsState(color.onPrimary, animationSpec).value,
            animateColorAsState(color.primaryContainer, animationSpec).value,
            animateColorAsState(color.onPrimaryContainer, animationSpec).value,
            animateColorAsState(color.inversePrimary, animationSpec).value,
            animateColorAsState(color.secondary, animationSpec).value,
            animateColorAsState(color.onSecondary, animationSpec).value,
            animateColorAsState(color.secondaryContainer, animationSpec).value,
            animateColorAsState(color.onSecondaryContainer, animationSpec).value,
            animateColorAsState(color.tertiary, animationSpec).value,
            animateColorAsState(color.onTertiary, animationSpec).value,
            animateColorAsState(color.tertiaryContainer, animationSpec).value,
            animateColorAsState(color.onTertiaryContainer, animationSpec).value,
            animateColorAsState(color.background, animationSpec).value,
            animateColorAsState(color.onBackground, animationSpec).value,
            animateColorAsState(color.surface, animationSpec).value,
            animateColorAsState(color.onSurface, animationSpec).value,
            animateColorAsState(color.surfaceVariant, animationSpec).value,
            animateColorAsState(color.onSurfaceVariant, animationSpec).value,
            animateColorAsState(color.surfaceTint, animationSpec).value,
            animateColorAsState(color.inverseSurface, animationSpec).value,
            animateColorAsState(color.inverseOnSurface, animationSpec).value,
            animateColorAsState(color.error, animationSpec).value,
            animateColorAsState(color.onError, animationSpec).value,
            animateColorAsState(color.errorContainer, animationSpec).value,
            animateColorAsState(color.onErrorContainer, animationSpec).value,
            animateColorAsState(color.outline, animationSpec).value,
            animateColorAsState(color.outlineVariant, animationSpec).value,
            animateColorAsState(color.scrim, animationSpec).value,
            animateColorAsState(color.surfaceBright, animationSpec).value,
            animateColorAsState(color.surfaceDim, animationSpec).value,
            animateColorAsState(color.surfaceContainer, animationSpec).value,
            animateColorAsState(color.surfaceContainerHigh, animationSpec).value,
            animateColorAsState(color.surfaceContainerHighest, animationSpec).value,
            animateColorAsState(color.surfaceContainerLow, animationSpec).value,
            animateColorAsState(color.surfaceContainerLowest, animationSpec).value,
        )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            content()
        }
    }
}
