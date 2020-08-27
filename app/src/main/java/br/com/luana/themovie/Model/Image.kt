package br.com.luana.themovie.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageItem(
    @SerializedName("file_path") var img: String
) : Parcelable

@Parcelize
data class ImageResponse(
    @SerializedName("posters") val posters: List<ImageItem>
) : Parcelable