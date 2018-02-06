package assignment.vend_awais.vendkickstarttask.api

import assignment.vend_awais.vendkickstarttask.Result
import com.google.gson.annotations.SerializedName

import java.io.Serializable

import assignment.vend_awais.vendkickstarttask.movies.model.Movie

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */
data class MoviesListResponseModel(
        @SerializedName("page") val page: Int = 0, //1
        @SerializedName("total_results") val totalResults: Int = 0, //7851
        @SerializedName("total_pages") val totalPages: Int = 0, //393
        @SerializedName("results") val movies: List<Movie> = listOf()
)
