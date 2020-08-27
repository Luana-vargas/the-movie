package br.com.luana.themovie.Presenter

import br.com.luana.themovie.Model.ImageItem
import br.com.luana.themovie.Model.Movie
import br.com.luana.themovie.Model.SimilarMovie


interface MovieServiceInterface {

    fun getMovieDetails(onSuccess: (Movie) -> Unit, onFailure: () -> Unit)

    fun getMainPicture(onSuccess: (ImageItem) -> Unit, onFailure: () -> Unit)

    fun getSimilarMoviesDetails(onSuccess: (List<SimilarMovie>) -> Unit, onFailure: () -> Unit)

}