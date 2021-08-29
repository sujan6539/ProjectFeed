package com.sujan.code.newsfeed.network

import com.sujan.code.newsfeed.network.model.TopStories
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewsApi {

    @GET("svc/topstories/v2/{section}.json")
    fun getTopStories(
        @Path("section") section: String?,
        @Query("api-key") key: String?
    ): Observable<TopStories?>
}