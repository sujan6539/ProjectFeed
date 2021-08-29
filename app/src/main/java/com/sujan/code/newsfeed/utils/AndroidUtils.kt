package com.sujan.code.newsfeed.utils

import android.content.Context
import android.widget.Toast
import timber.log.Timber

object AndroidUtils {

    fun showToast(context: Context?, message:String, duration: Int){
        context?.run {
            Toast.makeText(this, message, duration).show()
        }
    }
}