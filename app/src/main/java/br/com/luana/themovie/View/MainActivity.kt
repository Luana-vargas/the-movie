package br.com.luana.themovie.View

import br.com.luana.themovie.Model.ImageItem
import br.com.luana.themovie.Model.Movie
import br.com.luana.themovie.Model.MovieService
import br.com.luana.themovie.Presenter.MoviePresenter
import br.com.luana.themovie.Presenter.MovieViewInterface
import br.com.luana.themovie.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_movie.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.luana.themovie.Model.SimilarMovie


class MainActivity : AppCompatActivity(R.layout.activity_main), MovieViewInterface {

    private lateinit var adapter: SimilarMoviesListAdapter
    private lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = SimilarMoviesListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        presenter = MoviePresenter(this, MovieService())

        presenter.getMovieDetails()
        presenter.getMainPicture()
        presenter.getSimilarMovies()

    }

    override fun showMovie(movie: Movie) {
        txtMainPopularity.text = movie.popularity.toString()
        txtMainTitle.text = movie.title
        txtMainLikes.text = movie.voteCount.toString()
    }

    override fun showError() {
        val message = getString(R.string.error)
        recyclerView.visibility = View.GONE

        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
            .show()
    }

    override fun showMainPicture(img: ImageItem) {
        Picasso
            .get()
            .load(img.img)
            .fit()
            .into(moviePoster, object : Callback {
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {
                }
            })
    }

    override fun showSimilarMovies(similarMovies: List<SimilarMovie>) {
        adapter.similarMovies = similarMovies
    }

}
