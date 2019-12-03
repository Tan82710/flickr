package com.example.flickr.main

import android.util.Log
import android.util.LogPrinter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.example.flickr.model.Photo
import com.example.flickr.model.SearchResult
import com.example.flickr.repository.Repository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class MainFragmentViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    lateinit var  listePhoto : List<Photo>
    val photo : MutableLiveData<Photo> = MutableLiveData()
    lateinit var currentPhoto: Photo


    init {
        Repository().getPhotos(object :Callback<SearchResult> {

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {

            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
               listePhoto = response.body()!!.photos.photo
                currentPhoto = listePhoto[0]
                photo.value = currentPhoto

            }

        })
    }



    fun nextPhoto(nextPic : Photo){
        photo.value = nextPic
    }
}
