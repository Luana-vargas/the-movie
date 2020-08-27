package br.com.luana.themovie.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("original_title") val title: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("id") val id: Int,
    @SerializedName("vote_count") val voteCount: Int
) : Parcelable