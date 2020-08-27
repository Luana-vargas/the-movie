package br.com.luana.themovie.Presenter

import br.com.luana.themovie.Model.ImageItem
import br.com.luana.themovie.Model.Movie
import br.com.luana.themovie.Model.SimilarMovie

interface MovieViewInterface {
    fun showMovie(movie: Movie)
    fun showError()
    fun showMainPicture(img: ImageItem)
    fun showSimilarMovies(similarMovies: List<SimilarMovie>)
}