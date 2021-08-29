package com.sujan.code.newsfeed.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.sujan.code.newsfeed.NewsFeedApplication
import com.sujan.code.newsfeed.network.NewsApi
import com.sujan.code.newsfeed.network.TopStoriesType
import com.sujan.code.newsfeed.network.model.TopStories
import com.sujan.code.newsfeed.network.model.TopStoriesBody
import com.sujan.code.newsfeed.utils.AndroidUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import timber.log.Timber

class AppRepository(private val context: Context, retrofit: Retrofit) : LifecycleObserver {

    private val _topStoriesMutableLiveData = MutableLiveData<List<TopStoriesBody>>()

    var topStoriesLiveData : LiveData<List<TopStoriesBody>> = Transformations.distinctUntilChanged(_topStoriesMutableLiveData)

    private var v:NewsApi = retrofit.create(NewsApi::class.java)

    init {
        fetchNews()
    }

     fun fetchNews(){
        val disposable = v.getTopStories(TopStoriesType.MOVIES.type, NewsFeedApplication.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResults) { error -> Timber.e(error) }
    }

    private fun handleResults(topStories: TopStories?) {
        topStories?.let { stories ->
            _topStoriesMutableLiveData.postValue(stories.results)
        }
    }



}