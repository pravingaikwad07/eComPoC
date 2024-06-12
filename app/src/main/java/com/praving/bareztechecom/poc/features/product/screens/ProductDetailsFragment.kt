package com.praving.bareztechecom.poc.features.product.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.praving.bareztechecom.R
import com.praving.bareztechecom.databinding.FragmentProductBinding
import com.praving.bareztechecom.poc.extension.showToast
import com.praving.bareztechecom.poc.features.product.ui.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val productVm = ViewModelProvider(this)[ProductViewModel::class.java]
        productVm.loadProductDetails(arguments?.getInt("id") ?: 1)

        productVm.productDetail.observe(viewLifecycleOwner) {
            it.data?.let {
                binding.model = it
            }


            if (it.error.isNotEmpty()) {
                showToast(getString(R.string.error_loading_products))
            }

            binding.progressBar.isVisible = it.isLoading
        }


        binding.btnGoToCart.setOnClickListener {
            findNavController().navigate(R.id.action_productDetailsFragment_to_cartFragment)
        }


        return root

    }

}