package com.praving.bareztechecom.poc.custom


interface ListItemClickListener<T> {
    fun onItemClick(position: Int, item: T)
}