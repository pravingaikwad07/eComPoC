package com.praving.bareztechecom.poc.utils

import androidx.databinding.InverseMethod

class DataBindingConverters {
    companion object {

        @InverseMethod("convertFloatToInt")
        @JvmStatic
        fun convertIntegerToFloat(value: Int?): Float {
            value?.let {
                return it.toFloat()
            }
            return 0f
        }

        @JvmStatic
        fun convertFloatToInt(value: Float?): Int {
            value?.let {
                return it.toInt()
            }
            return 0
        }

    }
}