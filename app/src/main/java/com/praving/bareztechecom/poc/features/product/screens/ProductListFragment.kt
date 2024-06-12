package com.praving.bareztechecom.poc.features.product.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.praving.bareztechecom.R
import com.praving.bareztechecom.poc.custom.ListItemClickListener
import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.poc.extension.showToast
import com.praving.bareztechecom.poc.features.product.ui.ProductViewModel
import com.praving.bareztechecom.poc.features.product.ui.ProductsAdapter
import com.praving.bareztechecom.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

/* Dashboard class and home destination of navigation graph*/
@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    lateinit var productVm: ProductViewModel
    var products = mutableListOf<ProductModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        productVm = ViewModelProvider(this)[ProductViewModel::class.java]
        observers()
        clickListeners()
        return root
    }

    /* Sort button click listeners*/
    private fun clickListeners() {
        binding.btnSortAsc.setOnClickListener {
            productVm.loadProducts(productVm.currentCategory.value, "asc")
        }

        binding.btnSortDesc.setOnClickListener {
            productVm.loadProducts(productVm.currentCategory.value, "desc")
        }
    }

    /* observers will be called when livedata will post data*/
    private fun observers() {
        productVm.products.observe(viewLifecycleOwner) {
            if (it.data?.isNotEmpty()!!) {
                products = it.data.toMutableList()
                setAdapter()
            } else {
                products.clear()
                // TODO: optimize this will itemSetChanged
                binding.productAdapter?.notifyDataSetChanged()
            }


            if (it.error.isNotEmpty()) {
                showToast(getString(R.string.error_loading_products))
            }

            binding.progressBar.isVisible = it.isLoading

        }

        productVm.categories.observe(viewLifecycleOwner) {
            if (it.data?.isNotEmpty()!!) {
                setCategoryChipData(it.data)
            }

            if (it.error.isNotEmpty()) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_loading_categories), Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setCategoryChipData(data: List<String>) {
        addCategoryChip(getString(R.string.all).lowercase(), true)
        data.forEach {
            addCategoryChip(it, false)
        }
    }

    /* update the products adatper once the items are fethced from the api*/
    private fun setAdapter() {
        val adapter =
            ProductsAdapter(products, object : ListItemClickListener<ProductModel> {
                override fun onItemClick(position: Int, item: ProductModel) {
                    val bundle = Bundle()
                    bundle.putInt("id", item.id)
                    findNavController().navigate(
                        R.id.action_productListFragment_to_productDetailsFragment,
                        bundle
                    )
                }
            })
        binding.productAdapter = adapter
    }

    /**
     * TODO:  add chip dynamically
     *
     * @param name : Name of the category
     * @param isSelectedByDefault: by default selection.  Note: All is selected by default
     */
    private fun addCategoryChip(name: String, isSelectedByDefault: Boolean) {
        val chip = Chip(requireContext())
        chip.text = name
        chip.isSelected = isSelectedByDefault
        binding.cgCategories.addView(chip)

        chip.setOnClickListener {
            productVm.clearProducts()
            productVm.loadProducts(name)
            updateChipSelection(chip)
        }
    }


    /**
     * TODO - toggle chip selection ui
     *
     * @param chip: Chip that has been clicked
     */
    private fun updateChipSelection(chip: Chip) {
        binding.cgCategories.children.forEach {
            val catChip = (it as Chip)
            catChip.isSelected = catChip.id == chip.id
        }
    }

}