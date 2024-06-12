package com.praving.bareztechecom.poc.features.cart.usecase

import com.praving.bareztechecom.poc.data.model.CartModel
import com.praving.bareztechecom.poc.data.network.BaseApiResponse
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.cart.domain.CartRepository
import com.praving.bareztechecom.poc.features.product.domain.DashboardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCase @Inject constructor(
    private val repository: CartRepository
) : BaseApiResponse() {

    suspend operator fun invoke(userId: Int): Flow<Result<List<CartModel>>> {
        return repository.loadCartItems(userId)
    }


}