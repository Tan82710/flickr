package com.example.flickr.main

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
    val photo = MutableLiveData<Photo>()

    init {
        Repository().getPhotos(object :Callback<SearchResult> {

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }



    fun nextPhoto(nextPic : Photo){
        photo.value = nextPic
    }
}
