package com.example.dmedia.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.dmedia.R

@BindingAdapter("loadImageFromSource")
fun ImageView.loadImageFromSource(source : Any) {
        var str = source.toString().split(".")
        Glide.with(this.context).load(getResources()
            .getIdentifier(str[0], "drawable",this.context.packageName))
            .placeholder(R.drawable.placeholder_for_missing_posters)
            .error(R.drawable.placeholder_for_missing_posters)
            .into(this);

}