package com.sujan.code.newsfeed.baseobservable

import androidx.databinding.Bindable
import com.sujan.code.newsfeed.R
import com.sujan.code.newsfeed.bindings.adapter.BaseObservableWithLayoutItem

class ItemNewsFeedBaseObservable(
    @field: Bindable val header: String,
    @field: Bindable val description:String,
    @field: Bindable val image: String
) : BaseObservableWithLayoutItem() {


    override fun getLayoutId(): Int {
        return R.layout.item_news_feed
    }
}