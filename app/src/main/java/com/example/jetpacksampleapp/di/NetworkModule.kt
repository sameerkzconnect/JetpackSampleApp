package com.example.jetpacksampleapp.di

import android.os.Build
import com.example.jetpacksampleapp.api.SampleAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//module for api
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule{

    //provides retrofit object
    @Provides
    @Singleton
    fun providerRetrofit():Retrofit{

       val httpLogger= HttpLoggingInterceptor()

        httpLogger.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient().newBuilder().addInterceptor(httpLogger).build()
        return Retrofit.Builder().baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    //provide api object
    @Provides
    @Singleton
    fun providerSampleAPI(retrofit: Retrofit):SampleAPI{
        return retrofit.create(SampleAPI::class.java)
    }
}