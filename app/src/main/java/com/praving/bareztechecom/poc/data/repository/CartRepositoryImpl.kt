package com.praving.bareztechecom.poc.data.repository

import android.content.Context
import com.praving.bareztechecom.poc.data.model.CartModel
import com.praving.bareztechecom.poc.data.network.ApiService
import com.praving.bareztechecom.poc.data.network.BaseApiResponse
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.cart.domain.CartRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CartRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context, private val apiService: ApiService
) : CartRepository, BaseApiResponse() {


    override suspend fun loadCartItems(userId: Int): Flow<Result<List<CartModel>>> = safeApiCall {
        apiService.getCartItemsForUser(userId)
    }

}

