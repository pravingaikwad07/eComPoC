package com.praving.bareztechecom.poc.features.cart.ui

import com.praving.bareztechecom.poc.data.model.CartModel

data class CarItemsState(
    val data:List<CartModel>? = emptyList(),
    val error:String = "",
    val isLoading:Boolean = false
)

