package com.praving.bareztechecom.poc.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartModel(
    val id: Int,
    val userId: Int,
    val date: String,
    val products: List<CartProducts> = emptyList(),
) : Parcelable

@Parcelize
data class CartProducts(
    val productId: Int,
    val quantity: Int,
) : Parcelable


@Parcelize
data class CartProductModel(
    val cartId: Int,
    val quantity: Int,
    val productId: Int,
    val userId: Int? = null,
    val date: String? = null,
    val product: ProductModel? = null,
) : Parcelable