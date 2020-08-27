package br.com.luana.themovie.Model

import retrofit2.Call
import retrofit2.http.GET

interface MovieInterface {
    @GET("movie/11?api_key=cf853f287a83b469243822e8eefe8981")
    fun getMovieDetails(): Call<Movie>

    @GET("movie/11/images?api_key=cf853f287a83b469243822e8eefe8981")
    fun getMainPicture(): Call<ImageResponse>

    @GET("movie/11/similar?api_key=cf853f287a83b469243822e8eefe8981")
    fun getSimilarMoviesDetails(): Call<SimilarMoviesResponse>

}