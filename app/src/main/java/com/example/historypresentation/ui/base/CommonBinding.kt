package com.example.historypresentation.ui.base
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

@BindingConversion
fun convertBooleanToVisibility(visible: Boolean): Int {
    return if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("bindInvisibility")
fun bindBooleanToInvisibility(v: View, b: Boolean) {
    v.visibility = if (b) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("bindImageUrl")
fun bindImageUrl(view: ImageView, url: String?) {
    if (url.isNullOrEmpty()) return
    Glide.with(view).load(url).into(view)
}