package com.utmarckus.plantshandbook

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Plant(
    @DrawableRes val imgId: Int,
    @StringRes val title: Int,
)
