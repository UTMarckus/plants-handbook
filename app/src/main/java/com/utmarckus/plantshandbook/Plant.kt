package com.utmarckus.plantshandbook

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.Serial
import java.io.Serializable

data class Plant(
    @DrawableRes val imgId: Int,
    val title: String,
    val description: String,
) : Serializable
