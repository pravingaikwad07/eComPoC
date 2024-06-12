package com.praving.bareztechecom.poc.features.product.ui

import com.praving.bareztechecom.poc.data.model.ProductModel

data class ProductsState(
    val data:List<ProductModel>? = emptyList(),
    val error:String = "",
    val isLoading:Boolean = false
)

data class ProductDetailsState(
    val data:ProductModel? = null,
    val error:String = "",
    val isLoading:Boolean = false
)