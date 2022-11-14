package com.myu.randomdogpictures.data.repository

import com.myu.randomdogpictures.data.remote.DogImageService
import javax.inject.Inject
import javax.inject.Named

class DogImageRepository @Inject constructor(private val api : DogImageService, @Named("NUMBER_OF_PHOTOS") private val numberOfPhotos: String) {

    suspend fun getAllBreeds ()  = api.getAllBreeds()

    suspend fun getAllSubBreeds ( breedName : String)  = api.getAllSubBreeds(breedName)

    suspend fun getSingleRandomImage ()  = api.getSingleRandomImage()

    suspend fun getMultipleRandomImage ()  = api.getMultipleRandomImage(numberOfPhotos)

    suspend fun getAllImagesByBreed (breedName : String)  = api.getAllImagesByBreed(breedName)

    suspend fun getSingleRandomImageByBreed (breedName : String)  = api.getSingleRandomImageByBreed(breedName)

    suspend fun getMultipleRandomImageByBreed (breedName : String)  = api.getMultipleRandomImageByBreed(breedName,numberOfPhotos)

    suspend fun getSingleRandomImageBySubBreed (breedName : String,subBreedName : String)  = api.getSingleRandomImageBySubBreed(breedName,subBreedName)

    suspend fun getMultipleRandomImageBySubBreed (breedName : String,subBreedName : String)  = api.getMultipleRandomImageBySubBreed(breedName,subBreedName,numberOfPhotos)
}