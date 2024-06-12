package com.praving.bareztechecom.poc.features.cart.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.praving.bareztechecom.BR
import com.praving.bareztechecom.R
import com.praving.bareztechecom.databinding.ItemCartBinding
import com.praving.bareztechecom.poc.custom.ListItemClickListener
import com.praving.bareztechecom.poc.data.model.CartModel
import com.praving.bareztechecom.poc.data.model.CartProductModel


class CartsAdapter(
    private val values: List<CartProductModel>, private val clickListener: ListItemClickListener<CartProductModel>
) : RecyclerView.Adapter<CartsAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val dataModel: CartProductModel = values.get(position)
        holder.bind(dataModel)

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(position, item)
        }
    }

    override fun getItemCount(): Int = values.size

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding: ItemCartBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_cart, parent, false
        )

        return ViewHolder(binding)
    }

    class ViewHolder(itemRowBinding: ItemCartBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
        var itemRowBinding: ItemCartBinding = itemRowBinding

        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }

}
