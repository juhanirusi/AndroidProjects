package com.example.thirtytips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val tipTitleRes: Int,
    @StringRes val tipDescriptionRes: Int,
    @DrawableRes val tipImageRes: Int
)
