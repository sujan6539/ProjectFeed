package com.sujan.code.newsfeed.dagger

import android.content.Context
import com.squareup.picasso.Picasso
import com.sujan.code.newsfeed.repository.AppRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule(private var context: Context) {

    private var API_BASE_URL = "https://api.nytimes.com/"

    @Provides
    @Singleton
    fun providePicasso(context: Context): Picasso = Picasso.with(context)

    @Provides
    @Singleton
    fun provideHTTPClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideAppRepository(retrofit: Retrofit): AppRepository {
        return AppRepository(context, retrofit)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        callAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(callAdapterFactory)

        return builder
            .client(okHttpClient)
            .build()
    }
}