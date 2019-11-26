package com.example.tmdbfinalapp1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbfinalapp.TMDbClass.TMDbClass

class RecyclerViewAdapter(
    private val tmdbClass: TMDbClass,
    private val activityFunction: (String) -> Unit
) : RecyclerView.Adapter<RecyclerItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_recycler_adapter5, parent, false)
        return RecyclerItemViewHolder(view)
    }

    override fun getItemCount(): Int = tmdbClass.results!!.size

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.onBind(tmdbClass.results!![position], activityFunction)
    }
}