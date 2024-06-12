package com.praving.bareztechecom.poc.features.cart.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.praving.bareztechecom.R
import com.praving.bareztechecom.databinding.CartFragmentBinding
import com.praving.bareztechecom.poc.custom.ListItemClickListener
import com.praving.bareztechecom.poc.data.model.CartModel
import com.praving.bareztechecom.poc.data.model.CartProductModel
import com.praving.bareztechecom.poc.data.model.CartProducts
import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.poc.extension.showToast
import com.praving.bareztechecom.poc.features.cart.ui.CartViewModel
import com.praving.bareztechecom.poc.features.product.ui.ProductViewModel
import com.praving.bareztechecom.poc.features.product.ui.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CartFragment : Fragment() {

    private var _binding: CartFragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var cartVm: CartViewModel
    lateinit var productVm: ProductViewModel
    var cartItemsMap: HashMap<Int, CartProductModel> = HashMap()
    var idQtyMap: HashMap<Int, Int> = HashMap()



    val userId = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = CartFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cartVm = ViewModelProvider(this)[CartViewModel::class.java]
        productVm = ViewModelProvider(this)[ProductViewModel::class.java]
        cartVm.loadCartItems(userId)

        observers()

        return root
    }

    var itemCount = 0
    private fun observers(
    ) {
        cartVm.cartItems.observe(viewLifecycleOwner) {
            val dataResult = it.data
            if (dataResult?.isNotEmpty()!!) {

                dataResult.forEach { cartItem ->
                    iterateProducts(cartItem, productVm)
                }

                setAdapter()
                binding.tvItemCount.text = itemCount.toString()
            }

            if (it.error.isNotEmpty()) {
                showToast(getString(R.string.error_loading_products))
            }

            binding.progressBar.isVisible = it.isLoading
        }

        productVm.productDetail.observe(viewLifecycleOwner) {
            it.data?.let {

                val model = CartProductModel(
                    cartId = 0,
                    quantity = idQtyMap.get(it.id)!!,
                    productId = it.id,
                    userId = userId,
                    date = null,
                    product = it
                )
                cartItemsMap[it.id] = model

                Timber.d("CFT productDetail ${cartItemsMap.values}")

               setAdapter()
            }


            if (it.error.isNotEmpty()) {
                showToast(getString(R.string.error_loading_products))
            }

            binding.progressBar.isVisible = it.isLoading
        }
    }

    private fun iterateProducts(
        cartItem: CartModel,
        productVm: ProductViewModel
    ) {
        cartItem.products.forEach { pro ->
            itemCount += 1

            idQtyMap.put(pro.productId, pro.quantity)
            Timber.d("CFT Load product for id ${pro.productId}")
            productVm.loadProductDetails(pro.productId)
        }
    }

    private fun setAdapter() {
        val adapter =
            CartsAdapter(cartItemsMap.values.toList(), object : ListItemClickListener<CartProductModel> {
                override fun onItemClick(position: Int, item: CartProductModel) {
                    // nothing to do
                }
            })
        binding.cartAdapter = adapter
    }

}