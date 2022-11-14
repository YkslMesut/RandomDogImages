package com.myu.randomdogpictures.data.entities

import androidx.room.Entity

@Entity(tableName = "sub_breeds")
data class AllSubBreedsList(
    val message: List<String>,
    val status: String
)