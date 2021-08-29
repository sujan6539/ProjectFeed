package com.sujan.code.newsfeed.bindings.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.sujan.code.newsfeed.R;

import androidx.databinding.BindingAdapter;

/**
 * Custom bindings for XML attributes using data binding. (http://developer.android.com/tools/data-binding/guide.html)
 */
public class Bindings {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
        } else {
            Picasso.with(imageView.getContext()).cancelRequest(imageView);
        }
    }
}