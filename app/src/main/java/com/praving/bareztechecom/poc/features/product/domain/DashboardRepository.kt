package com.praving.bareztechecom.poc.features.product.domain

import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.poc.data.network.Result
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    suspend fun loadProducts(category: String?, sort: String?=null): Flow<Result<List<ProductModel>>>
    suspend fun loadCategories(): Flow<Result<List<String>>>
    suspend fun loadProductDetails(productId: Int): Flow<Result<ProductModel>>
}