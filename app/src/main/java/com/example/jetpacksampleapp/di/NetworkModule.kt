package com.example.jetpacksampleapp.di

import com.example.jetpacksampleapp.api.SampleAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//module for api
@Module
@Singleton
class NetworkModule{

    //provides retrofit object
    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    //provide api object
    @Singleton
    @Provides
    fun providerSampleAPI(retrofit: Retrofit):SampleAPI{
        return retrofit.create(SampleAPI::class.java)
    }
}