package com.example.tmdbfinalapp1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbfinalapp.TMDbClass.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_recycler_adapter5.view.*

class RecyclerItemViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

    fun onBind(result: Result, activityFunction: (String) -> Unit) {
//        Glide
//            .with(itemView)
//            .load(result.posterPath)
//            .into(itemView.imgPosterSearchResult)
        itemView.txtMovieNameSearchResult.text = result.title
//        itemView.txtMovieOverViewSearchResult.text = result.overview
        itemView.btnSaveToFavorites.setOnClickListener { activityFunction(result.posterPath!!) }

        val posterBaseUrl = "https://image.tmdb.org/t/p/original"
        Picasso.get().load(posterBaseUrl + result.backdropPath).into(itemView.imgPosterSearchResult)
//        itemView.txtMovieTitle.text = title
//        itemView.txtOverView.text = overview
    }
}