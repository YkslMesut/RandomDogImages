package com.myu.randomdogpictures.ui.feeddogimages

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myu.randomdogpictures.data.entities.AllBreedsList
import com.myu.randomdogpictures.data.entities.MultipleImageResponse
import com.myu.randomdogpictures.data.entities.SingleImageResponse
import com.myu.randomdogpictures.data.repository.DogImageRepository
import kotlinx.coroutines.launch

class FeedDogImagesViewModel @ViewModelInject constructor(
    private val repository: DogImageRepository
) : ViewModel() {
    private val TAG = "FeedDogImagesViewModel"
    private val _response = MutableLiveData<MultipleImageResponse>()
    val responseDogBreeds : LiveData<MultipleImageResponse>
        get() = _response

    init {
        getAllDogImages()
    }

    fun getAllDogImages() = viewModelScope.launch {
        repository.getMultipleRandomImage().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG, "getAllTvShows: ")
            }
        }
    }

}