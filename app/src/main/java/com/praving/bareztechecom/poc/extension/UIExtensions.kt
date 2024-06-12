package com.praving.bareztechecom.poc.extension

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Context.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(msg: String){
    this.requireContext().showToast(msg)
}