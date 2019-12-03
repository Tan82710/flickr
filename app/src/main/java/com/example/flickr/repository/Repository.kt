package com.example.flickr.repository

import com.example.flickr.model.SearchResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Repository {
        fun getPhotos(callback : Callback<SearchResult>) {
            val url = "https://www.flickr.com"
            val retrofit =
                Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
            val service = retrofit.create(FlickrAPI::class.java)
            service.getInterestingPhotos(
                "flickr.photo.search",
                "e7a9de83e4df5591f45385efba9a7e39",
                "20"
            ).enqueue(callback)
        }
}