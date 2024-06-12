package com.praving.bareztechecom.poc.data.repository

import android.content.Context
import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.poc.data.network.ApiService
import com.praving.bareztechecom.poc.data.network.BaseApiResponse
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.product.domain.DashboardRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val apiService: ApiService
) : DashboardRepository, BaseApiResponse() {

    override suspend fun loadProducts(
        category: String?,
        sort: String?
    ): Flow<Result<List<ProductModel>>> =
        safeApiCall {
            var sortingOrder = "asc"
            if (!sort.isNullOrBlank()) {
                sortingOrder = sort
            }
            if (category == null || category.equals("all")) {
                apiService.getProducts(sortingOrder)
            } else {
                apiService.getProducts(category, sortingOrder)
            }
        }

    override suspend fun loadCategories(): Flow<Result<List<String>>> = safeApiCall {
        apiService.getCategories()
    }

    override suspend fun loadProductDetails(productId: Int): Flow<Result<ProductModel>> = safeApiCall {
        apiService.getProductDetails(productId)
    }

}

