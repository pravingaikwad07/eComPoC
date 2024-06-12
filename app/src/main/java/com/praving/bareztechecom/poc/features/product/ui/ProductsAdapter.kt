package com.praving.bareztechecom.poc.features.product.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.praving.bareztechecom.BR
import com.praving.bareztechecom.R
import com.praving.bareztechecom.poc.custom.ListItemClickListener
import com.praving.bareztechecom.poc.data.model.ProductModel
import com.praving.bareztechecom.databinding.ItemProductBinding


class ProductsAdapter(
    private val values: List<ProductModel>,
    private val clickListener: ListItemClickListener<ProductModel>
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val dataModel: ProductModel = values.get(position)
        holder.bind(dataModel)

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(position, item)
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding: ItemProductBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_product, parent, false
        )

        return ViewHolder(binding)
    }

    class ViewHolder(itemRowBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
        var itemRowBinding: ItemProductBinding = itemRowBinding

        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }

}
