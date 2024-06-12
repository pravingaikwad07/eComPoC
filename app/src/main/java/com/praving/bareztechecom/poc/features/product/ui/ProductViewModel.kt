package com.praving.bareztechecom.poc.features.product.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.product.usecase.CategoryUseCase
import com.praving.bareztechecom.poc.features.product.usecase.ProductUseCase
import com.praving.bareztechecom.poc.features.product.usecase.ProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productListUseCase: ProductsListUseCase,
    private val categoryUseCase: CategoryUseCase,
    private val productUseCase: ProductUseCase,

    ) : ViewModel() {

    private val _products: MutableLiveData<ProductsState> = MutableLiveData(ProductsState())
    val products: LiveData<ProductsState> = _products

    private val _productDetail: MutableLiveData<ProductDetailsState> = MutableLiveData(ProductDetailsState())
    val productDetail: LiveData<ProductDetailsState> = _productDetail

    private val _categories: MutableLiveData<CategoryState> = MutableLiveData(CategoryState())
    val categories: LiveData<CategoryState> = _categories

    val currentCategory: MutableLiveData<String> = MutableLiveData("all")


    init {
        loadCategories()
        loadProducts()
    }



    fun loadProducts(category: String? = null, sortOrder: String? = "asc") = viewModelScope.launch {
        currentCategory.value = category ?: "all"
        productListUseCase(category, sortOrder).collect {
            when (it) {
                is Result.Failure -> {
                    _products.value = ProductsState(error = "Something went wrong")
                }

                is Result.Loading -> {
                    _products.value = ProductsState(isLoading = true)
                }

                is Result.Success -> {
                    _products.value = ProductsState(data = it.data)
                }
            }
        }
    }

 fun loadProductDetails(productId: Int) = viewModelScope.launch {
     productUseCase(productId).collect {
            when (it) {
                is Result.Failure -> {
                    _productDetail.value = ProductDetailsState(error = "Something went wrong")
                }

                is Result.Loading -> {
                    _productDetail.value = ProductDetailsState(isLoading = true)
                }

                is Result.Success -> {
                    _productDetail.value = ProductDetailsState(data = it.data)
                }
            }
        }
    }



    fun loadCategories() = viewModelScope.launch {
        categoryUseCase().collect {
            when (it) {
                is Result.Failure -> {
                    _categories.value = CategoryState(error = "Something went wrong")
                }

                is Result.Loading -> {
                    _categories.value = CategoryState(isLoading = true)
                }

                is Result.Success -> {
                    _categories.value = CategoryState(data = it.data)
                }
            }

        }
    }

    fun clearProducts() {
        _products.value = ProductsState()
    }


}