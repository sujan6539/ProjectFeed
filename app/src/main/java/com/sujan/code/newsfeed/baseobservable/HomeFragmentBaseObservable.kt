package com.sujan.code.newsfeed.baseobservable

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sujan.code.newsfeed.BR
import com.sujan.code.newsfeed.bindings.adapter.MultiTypeDataBoundAdapter

class HomeFragmentBaseObservable(actionCallback: MultiTypeDataBoundAdapter.ActionCallback) :
    BaseObservable() {

    @Bindable
    val adapter = MultiTypeDataBoundAdapter(actionCallback)

    @Bindable
    var refreshing : Boolean = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.refreshing)
    }

    fun addItems(itemNewsFeedBaseObservable: ItemNewsFeedBaseObservable){
        adapter.addItem(itemNewsFeedBaseObservable)
    }

}