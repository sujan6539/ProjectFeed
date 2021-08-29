package com.sujan.code.newsfeed.baseobservable

import androidx.databinding.Bindable
import com.sujan.code.newsfeed.R
import com.sujan.code.newsfeed.bindings.adapter.BaseObservableWithLayoutItem
import com.sujan.code.newsfeed.bindings.adapter.MultiTypeDataBoundAdapter

class ItemHorizontalSwimLaneBaseObservable : BaseObservableWithLayoutItem() {

    @field:Bindable
    val adapter: MultiTypeDataBoundAdapter = MultiTypeDataBoundAdapter(null)

    fun addItems(itemList: List<ItemNewsFeedBaseObservable>){
        adapter.addItems(itemList.subList(0,7))
    }

    override fun getLayoutId(): Int {
        return R.layout.item_horizontal_swim_lane
    }
}