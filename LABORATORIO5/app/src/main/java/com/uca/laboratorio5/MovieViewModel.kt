package com.uca.laboratorio5

import android.app.Application
import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uca.laboratorio5.data.model.MovieModel
import com.uca.laboratorio5.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository):ViewModel(){

    fun getMovies() = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                val repository = MovieRepository(app.movieRepository)
                MovieViewModel(repository)
            }
        }
    }

}