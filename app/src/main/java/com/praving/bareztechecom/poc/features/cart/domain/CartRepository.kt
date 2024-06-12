package com.praving.bareztechecom.poc.features.cart.domain

import com.praving.bareztechecom.poc.data.model.CartModel
import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.poc.data.network.Result
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun loadCartItems(userId: Int): Flow<Result<List<CartModel>>>
}