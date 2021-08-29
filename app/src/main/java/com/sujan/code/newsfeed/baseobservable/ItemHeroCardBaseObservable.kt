package com.sujan.code.newsfeed.baseobservable

import com.sujan.code.newsfeed.R
import com.sujan.code.newsfeed.bindings.adapter.BaseObservableWithLayoutItem

class ItemHeroCardBaseObservable: BaseObservableWithLayoutItem() {
    override fun getLayoutId(): Int {
        return R.layout.item_hero_card
    }

}