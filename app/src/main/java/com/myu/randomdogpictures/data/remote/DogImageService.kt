package com.myu.randomdogpictures.data.remote

import com.myu.randomdogpictures.data.entities.AllBreedsList
import com.myu.randomdogpictures.data.entities.AllSubBreedsList
import com.myu.randomdogpictures.data.entities.MultipleImageResponse
import com.myu.randomdogpictures.data.entities.SingleImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogImageService {

    @GET("breeds/list/all")
    suspend fun getAllBreeds() : Response<AllBreedsList>

    @GET("breed/{breed_name}/list")
    suspend fun getAllSubBreeds(
        @Path("breed_name") breedName : String) : Response<AllSubBreedsList>

    @GET("breeds/image/random")
    suspend fun getSingleRandomImage() : Response<SingleImageResponse>

    @GET("breeds/image/random/{number_of_photos}")
    suspend fun getMultipleRandomImage(
        @Path("number_of_photos") numberOfPhotos : String) : Response<MultipleImageResponse>

    @GET("breed/{breed_name}/images")
    suspend fun getAllImagesByBreed(
        @Path("breed_name") breedName : String) : Response<MultipleImageResponse>

    @GET("breed/{breed_name}/images/random")
    suspend fun getSingleRandomImageByBreed(
        @Path("breed_name") breedName : String
    ) : Response<SingleImageResponse>


    @GET("breed/{breed_name}/images/random/{number_of_photos}")
    suspend fun getMultipleRandomImageByBreed(
        @Path("breed_name") breedName : String,
        @Path("number_of_photos") numberOfPhotos : String) : Response<MultipleImageResponse>


    @GET("breed/{breed_name}/{sub_breed_name}/images/random")
    suspend fun getSingleRandomImageBySubBreed(
        @Path("breed_name") breedName : String,
        @Path("sub_breed_name") subBreedName : String,
    ) : Response<SingleImageResponse>


    @GET("breed/{breed_name}/{sub_breed_name}/images/random/{number_of_photos}")
    suspend fun getMultipleRandomImageBySubBreed(
        @Path("breed_name") breedName : String,
        @Path("sub_breed_name") subBreedName : String,
        @Path("number_of_photos") numberOfPhotos : String) : Response<MultipleImageResponse>


}