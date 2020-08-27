package br.com.luana.themovie.Model

import br.com.luana.themovie.Presenter.MovieServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieService : MovieServiceInterface {

    private val retrofit = RetrofitConfig().getRetrofitInstance()

    private val serviceRetrofit: MovieInterface by lazy {
        retrofit.create(MovieInterface::class.java)
    }

    override fun getMovieDetails(onSuccess: (Movie) -> Unit, onFailure: () -> Unit) {
        serviceRetrofit.getMovieDetails().enqueue(object : Callback<Movie> {

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                onFailure()
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.errorBody() != null) {
                    onFailure()
                    return
                }
                val movie = response.body()!!
                onSuccess(movie)
            }
        })
    }

    override fun getMainPicture(onSuccess: (ImageItem) -> Unit, onFailure: () -> Unit) {
        serviceRetrofit.getMainPicture().enqueue(object : Callback<ImageResponse> {
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
                val pictureResponse = response.body()!!
                val mainPicture = pictureResponse.posters[0]
                mainPicture.img = "$IMAGE_BASE_URL${mainPicture.img}"
                onSuccess(mainPicture)
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                onFailure()
            }

        })
    }

    override fun getSimilarMoviesDetails(
        onSuccess: (List<SimilarMovie>) -> Unit,
        onFailure: () -> Unit
    ) {
        serviceRetrofit.getSimilarMoviesDetails().enqueue(object : Callback<SimilarMoviesResponse> {
            override fun onResponse(
                call: Call<SimilarMoviesResponse>,
                response: Response<SimilarMoviesResponse>
            ) {
                if (response.errorBody() != null) {
                    onFailure()
                    return
                }
                val body = response.body()!!
                val movies = body.similarMovies
                for (movie in movies) {
                    movie.imageLink = "$IMAGE_BASE_URL${movie.imageLink}"
                }
                onSuccess(movies)
            }

            override fun onFailure(call: Call<SimilarMoviesResponse>, t: Throwable) {
                onFailure()
            }
        })
    }

    companion object {
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w300_and_h450_bestv2"
    }
}