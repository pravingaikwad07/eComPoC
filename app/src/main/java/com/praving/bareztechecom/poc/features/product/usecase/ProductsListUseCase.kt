package com.praving.bareztechecom.poc.features.product.usecase

import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.poc.data.network.BaseApiResponse
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.product.domain.DashboardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsListUseCase @Inject constructor(
    private val repository: DashboardRepository
) : BaseApiResponse() {

   suspend operator fun invoke(category: String? = null, sortOrder: String? = null): Flow<Result<List<ProductModel>>> {
        return repository.loadProducts(category, sortOrder)
    }


}