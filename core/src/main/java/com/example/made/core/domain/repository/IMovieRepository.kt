package com.example.made.core.domain.repository

import com.example.made.core.data.Resource
import com.example.made.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getSearchMovie(query: String): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun checkFavorite(movieId: String): Flow<Int>

    fun insertFavorite(movie: Movie)

    fun deleteFavorite(movie: Movie)
}