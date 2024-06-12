package com.praving.bareztechecom.poc.di

import android.content.Context
import com.praving.bareztechecom.poc.features.product.domain.DashboardRepository
import com.praving.bareztechecom.poc.data.repository.ProductRepositoryImpl
import com.praving.bareztechecom.poc.data.network.ApiService
import com.praving.bareztechecom.poc.data.repository.CartRepositoryImpl
import com.praving.bareztechecom.poc.features.cart.domain.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesProductRepository(@ApplicationContext context: Context, apiService: ApiService): DashboardRepository {
        return ProductRepositoryImpl(context, apiService)
    }

     @Provides
    @Singleton
    fun providesCartRepository(@ApplicationContext context: Context, apiService: ApiService): CartRepository {
        return CartRepositoryImpl(context, apiService)
    }


}