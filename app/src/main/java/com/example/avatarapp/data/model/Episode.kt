package com.example.avatarapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Episode(
    val id: Int,
    @Json(name = "Season") val season: String,
    @Json(name = "NumInSeason") val numInSeason: String,
    @Json(name = "Title") val title: String,
    @Json(name = "AnimatedBy") val animatedBy: String,
    @Json(name = "DirectedBy") val directedBy: String,
    @Json(name = "WrittenBy") val writtenBy: List<String>,
    @Json(name = "OriginalAirDate") val originalAirDate: String,
    @Json(name = "ProductionCode") val productionCode: String?,
    @Json(name = "Viewers") val viewers: String?
)
/*

package com.example.avatarapp.data.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

 //For GSONCoverter
data class Episode(
    val id: Int,
    @SerializedName("Season") val season: String,
    @SerializedName("NumInSeason") val numInSeason: String,
    @SerializedName("Title") val title: String,
    @SerializedName("AnimatedBy") val animatedBy: String,
    @SerializedName("DirectedBy") val directedBy: String,
    @SerializedName("WrittenBy") val writtenBy: List<String>,
    @SerializedName("OriginalAirDate") val originalAirDate: String,
    @SerializedName("ProductionCode ") val productionCode: String?,
    @SerializedName("Viewers") val viewers: String?
)

/*

kotlinx.serialization.MissingFieldException: Field 'Viewers' is required for type with serial name 'com.example.avatarapp.data.model.Episode', but it was missing
 */

//@OptIn(InternalSerializationApi::class)
//@Serializable
//data class Episode(
//    val id: Int,
//    @SerialName("Season") val season: String,
//    @SerialName("NumInSeason") val numInSeason: String,
//    @SerialName("Title") val title: String,
//    @SerialName("AnimatedBy") val animatedBy: String,
//    @SerialName("DirectedBy") val directedBy: String,
//    @SerialName("WrittenBy") val writtenBy: List<String>,
//    @SerialName("OriginalAirDate") val originalAirDate: String,
//    @SerialName("ProductionCode") val productionCode: String? = null,
//    @SerialName("Viewers") val viewers: String? = null
//)


// //  Moshi
//@JsonClass(generateAdapter = true)
//data class Episode(
//    val id: Int,
//    @Json(name = "Season") val season: String,
//    @Json(name = "NumInSeason") val numInSeason: String,
//    @Json(name = "Title") val title: String,
//    @Json(name = "AnimatedBy") val animatedBy: String,
//    @Json(name = "DirectedBy") val directedBy: String,
//    @Json(name = "WrittenBy") val writtenBy: List<String>,
//    @Json(name = "OriginalAirDate")val originalAirDate: String,
//    @Json(name = "ProductionCode") val productionCode: String?,
//    @Json(name = "Viewers") val viewers: String?
)
 */