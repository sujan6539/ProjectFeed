package com.sujan.code.newsfeed.baseobservable.callbacks

import com.sujan.code.newsfeed.baseobservable.HomeFragmentBaseObservable
import com.sujan.code.newsfeed.bindings.adapter.MultiTypeDataBoundAdapter

interface FeedActionCallback: MultiTypeDataBoundAdapter.ActionCallback {

    fun onFeedClick(observable: HomeFragmentBaseObservable)
}