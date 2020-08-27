package br.com.luana.themovie.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.luana.themovie.Model.SimilarMovie
import br.com.luana.themovie.R

class SimilarMoviesListAdapter : RecyclerView.Adapter<SimilarMovieListItemViewHolder>() {

    var similarMovies = emptyList<SimilarMovie>()
        set(value) {
            val similarMovieListCallback = SimilarMovieListDiffCallback(
                field,
                value
            )
            val result = DiffUtil.calculateDiff(similarMovieListCallback)
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SimilarMovieListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie, parent, false)

        return SimilarMovieListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimilarMovieListItemViewHolder, position: Int) {
        holder.bind(similarMovies[position])
    }

    override fun getItemCount(): Int = similarMovies.size
}