package com.ricardocanales.moviesrcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.ricardocanales.moviesrcm.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getSerializableExtra("movieSelected") as Movie

        name_movie_detail_textView.text = movie.nameMovie
        type_movie_detail_textView.text = movie.typeMovie
        resume_movie_detail_textView.text = movie.resumeMovie

        when(movie.imageMovie){
            1 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bohemian))
            2 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.godzilla))
            3 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.adosmetros))
            4 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rapidos))
            5 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.it))
            6 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.doctor))
            7 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.vikingos))
            8 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.tres))
            9 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.jurasic))
            10 -> image_movie_detail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.elite))
        }

        Log.d("Tag","Name of movie is: ${movie.nameMovie} " + "Type of movie is ${movie.typeMovie} "+ "Resume of movie: ${movie.resumeMovie}")
    }
}