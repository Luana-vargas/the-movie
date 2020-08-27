package br.com.luana.themovie.View

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.luana.themovie.Model.SimilarMovie
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_movie.view.*

class SimilarMovieListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(similarMovie: SimilarMovie) {
        itemView.txt_title.text = similarMovie.title
        itemView.release_date.text = similarMovie.releaseDate
        Picasso.get()
            .load(similarMovie.imageLink)
            .into(itemView.picture, object : Callback {
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {
                }
            })
    }
}