package com.ricardocanales.moviesrcm.model

import android.graphics.drawable.Drawable
import android.media.Image
import java.io.Serializable

data class Movie(val nameMovie: String, val typeMovie: String, val resumeMovie: String, val imageMovie: Int) : Serializable