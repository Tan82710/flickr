package com.example.flickr.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.flickr.R
import com.example.flickr.model.Photo
import com.example.flickr.repository.Repository


class main_fragment : Fragment() {

    companion object {
        fun newInstance() = main_fragment()
    }

    private lateinit var viewModel: MainFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.main_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)


        val imageview = layout.findViewById<ImageView>(R.id.imageView2)
        //val title = layout.findViewById<TextView>(R.id.title)

        viewModel.photo.observe(this, Observer {photo ->
            // la photo est prête
            val url = "https://farm" + photo.farm + ".staticflickr.com/" +
                    photo.server + "/" + photo.id+"_"+photo.secret + ".jpg"

            Glide.with(activity!!).load(url).into(imageview)
        })


        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}
