package assignment.vend_awais.vendkickstarttask.movies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

data class Movie(
        @SerializedName("vote_count") val voteCount: Int = 0, //1023
        @SerializedName("id") val id: Int = 0, //19404
        @SerializedName("video") val video: Boolean = false, //false
        @SerializedName("vote_average") val voteAverage: Double = 0.0, //9.1
        @SerializedName("title") val title: String = "", //Dilwale Dulhania Le Jayenge
        @SerializedName("popularity") val popularity: Double = 0.0, //36.337606
        @SerializedName("poster_path") val posterPath: String = "", ///uC6TTUhPpQCmgldGyYveKRAu8JN.jpg
        @SerializedName("original_language") val originalLanguage: String = "", //hi
        @SerializedName("original_title") val originalTitle: String = "", //Dilwale Dulhania Le Jayenge
        @SerializedName("genre_ids") val genreIds: List<Int> = listOf(),
        @SerializedName("backdrop_path") val backdropPath: String = "", ///nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg
        @SerializedName("adult") val adult: Boolean = false, //false
        @SerializedName("overview") val overview: String = "", //Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.
        @SerializedName("release_date") val releaseDate: String = "" //1995-10-20
)
