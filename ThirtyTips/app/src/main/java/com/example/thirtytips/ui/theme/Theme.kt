package com.example.thirtytips.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = DarkBlue,
    surface = DarkBlue2,
    onSurface = Flax,
    primary = IceBlue,
    onPrimary = DarkBlue,
    secondary = DarkBlue
)

private val LightColorPalette = lightColors(
    background = Flax,
    surface = IceBlue,
    onSurface = DarkBlue,
    primary = LightGreen2,
    onPrimary = MimiPink,
    secondary = LightGreen

    /* Other default colors to override
    onSecondary = Color.Black,
    onBackground = Color.Black,
    */
)

@Composable
fun ThirtyTipsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
