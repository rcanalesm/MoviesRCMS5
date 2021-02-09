package com.ricardocanales.moviesrcm

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ricardocanales.moviesrcm.model.Movie
import java.util.ArrayList

class CustomAdapter(private val movies: ArrayList<Movie>,
                    private val movieSelectionListener: MovieSelectionListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_movie_cell, parent, false)
        return ViewHolder(view,movieSelectionListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movies[position]
        holder.bindCell(currentMovie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(itemView: View,
                     private val movieSelectionListener: MovieSelectionListener) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            movieSelectionListener.onMovieSelected(this.adapterPosition)
        }

        fun bindCell(movie : Movie){
            val nameMovieTextView = itemView.findViewById(R.id.name_movie_text_view) as TextView
            val typeMovieTextView = itemView.findViewById(R.id.type_movie_text_view) as TextView
            val resumeMovieTextView = itemView.findViewById(R.id.resume_movie_text_view) as TextView
            val imageMovie = itemView.findViewById(R.id.image_movie) as ImageView
            nameMovieTextView.text = movie.nameMovie
            typeMovieTextView.text = movie.typeMovie
            resumeMovieTextView.text = movie.resumeMovie
            when(movie.imageMovie){
                1 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.bohemian))
                2 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.godzilla))
                3 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.adosmetros))
                4 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.rapidos))
                5 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.it))
                6 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.doctor))
                7 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.vikingos))
                8 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.tres))
                9 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.jurasic))
                10 -> imageMovie.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.elite))
            }
        }
    }
}