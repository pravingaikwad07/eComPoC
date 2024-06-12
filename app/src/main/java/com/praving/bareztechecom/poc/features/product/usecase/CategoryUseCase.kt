package com.praving.bareztechecom.poc.features.product.usecase

import com.praving.bareztechecom.poc.data.network.BaseApiResponse
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.product.domain.DashboardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: DashboardRepository
) : BaseApiResponse() {

    suspend operator fun invoke(): Flow<Result<List<String>>> {
        return repository.loadCategories()
    }


}