package br.com.luana.themovie.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimilarMovie(
    @SerializedName("original_title") val title: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("id") val id: String,
    @SerializedName("poster_path") var imageLink: String
) : Parcelable

@Parcelize
data class SimilarMoviesResponse(
    @SerializedName("results") val similarMovies: List<SimilarMovie>
) : Parcelable