package com.praving.bareztechecom.poc.features.cart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praving.bareztechecom.poc.data.network.Result
import com.praving.bareztechecom.poc.features.cart.usecase.CartUseCase
import com.praving.bareztechecom.poc.features.product.ui.ProductsState
import com.praving.bareztechecom.poc.features.product.usecase.CategoryUseCase
import com.praving.bareztechecom.poc.features.product.usecase.ProductUseCase
import com.praving.bareztechecom.poc.features.product.usecase.ProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCase: CartUseCase,

    ) : ViewModel() {

    private val _cartItems: MutableLiveData<CarItemsState> = MutableLiveData(CarItemsState())
    val cartItems: LiveData<CarItemsState> = _cartItems



    fun loadCartItems(user: Int) = viewModelScope.launch {
        cartUseCase(user).collect {
            when (it) {
                is Result.Failure -> {
                    _cartItems.value = CarItemsState(error = "Something went wrong")
                }

                is Result.Loading -> {
                    _cartItems.value = CarItemsState(isLoading = true)
                }

                is Result.Success -> {
                    _cartItems.value = CarItemsState(data = it.data)
                }
            }
        }
    }


}