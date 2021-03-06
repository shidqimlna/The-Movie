package com.example.made.core.domain.usecase

import com.example.made.core.data.Resource
import com.example.made.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {

    fun getPopularMovies(): Flow<Resource<List<Movie>>>

    fun getTopRatedMovies(): Flow<Resource<List<Movie>>>

    fun getUpcomingMovies(): Flow<Resource<List<Movie>>>

    fun getSearchMovie(query: String): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun checkFavorite(movieId: String): Flow<Int>

    fun insertFavorite(movie: Movie)

    fun deleteFavorite(movie: Movie)

}