package com.praving.bareztechecom.poc.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingModel,
) : Parcelable

@Parcelize
data class RatingModel(
    val rate: Float,
    val count: Int,
) : Parcelable