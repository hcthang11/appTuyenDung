package com.hcthang.apptuyendung.ui.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.hcthang.apptuyendung.R
import com.hcthang.apptuyendung.ui.customview.GlideApp

object LoadDataBinding {
    @JvmStatic
    @BindingAdapter("urlImage")
    fun AppCompatImageView.setUrlImage(urlImage: String?){
        if (!StringUtils.isBlank(urlImage)){
            GlideApp.with(this)
                .load(urlImage)
                .placeholder(R.drawable.ic_photo)
                .error(R.drawable.ic_error)
                .into(this)
        }
    }
}