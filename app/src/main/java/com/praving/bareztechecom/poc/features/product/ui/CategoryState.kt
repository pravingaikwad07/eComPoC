package com.praving.bareztechecom.poc.features.product.ui


data class CategoryState(
    val data:List<String>? = emptyList(),
    val error:String = "",
    val isLoading:Boolean = false
)