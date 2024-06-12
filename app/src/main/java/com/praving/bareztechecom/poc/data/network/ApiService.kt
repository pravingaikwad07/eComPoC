package com.praving.bareztechecom.poc.data.network

import com.praving.bareztechecom.poc.data.model.CartModel
import com.praving.bareztechecom.poc.data.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("/products")
    suspend fun getProducts(@Query("sort") sort: String): Response<List<ProductModel>>

    @GET("/products/category/{categoryName}")
    suspend fun getProducts(@Path("categoryName") name: String, @Query("sort") sort: String): Response<List<ProductModel>>

    @GET("/products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("/products/{id}")
    suspend fun getProductDetails(@Path("id") productId: Int): Response<ProductModel>

    @GET("/carts/user/{userId}")
    suspend fun getCartItemsForUser(@Path("userId") userId: Int): Response<List<CartModel>>



}