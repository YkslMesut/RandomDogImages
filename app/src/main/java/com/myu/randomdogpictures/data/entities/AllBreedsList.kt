package com.myu.randomdogpictures.data.entities

import com.google.gson.annotations.SerializedName

data class AllBreedsList(
    @SerializedName("message")
    val breedsResponse: BreedsResponse,
    val status: String
)