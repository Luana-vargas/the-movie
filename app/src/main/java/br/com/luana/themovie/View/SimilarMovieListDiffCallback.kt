package br.com.luana.themovie.View

import androidx.recyclerview.widget.DiffUtil
import br.com.luana.themovie.Model.SimilarMovie

class SimilarMovieListDiffCallback(
    private val oldList: List<SimilarMovie>,
    private val newList: List<SimilarMovie>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title.equals(newList[newItemPosition].title)
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}