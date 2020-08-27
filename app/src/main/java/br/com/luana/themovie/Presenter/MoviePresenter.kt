package br.com.luana.themovie.Presenter

import br.com.luana.themovie.Model.ImageItem
import br.com.luana.themovie.Model.Movie
import br.com.luana.themovie.Model.SimilarMovie

class MoviePresenter(
    private val movieView: MovieViewInterface,
    private val movieService: MovieServiceInterface
) {

    fun getMovieDetails() {

        movieService.getMovieDetails(
            fun(movie: Movie) {
                movieView.showMovie(movie)
            },
            fun() {
                movieView.showError()
            }
        )
    }

    fun getMainPicture() {
        movieService.getMainPicture(
            fun(image: ImageItem) {
                movieView.showMainPicture(image)
            },
            fun() {
                movieView.showError()
            }
        )
    }

    fun getSimilarMovies() {
        movieService.getSimilarMoviesDetails(
            fun(similarMovie: List<SimilarMovie>) {
                movieView.showSimilarMovies(similarMovie)
            },
            fun() {
                movieView.showError()
            }
        )
    }
}