package com.myu.randomdogpictures.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.myu.randomdogpictures.data.remote.DogImageService
import com.myu.randomdogpictures.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DogImageModule {
    @Provides
    @Named("BASE_URL")
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson,@Named("BASE_URL")BASE_URL : String) : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideDogImageService(retrofit: Retrofit): DogImageService = retrofit.create(DogImageService::class.java)

    @Provides
    @Named("NUMBER_OF_PHOTOS")
    fun provideNumberOfImages() = Constants.NUMBER_OF_PHOTOS


}