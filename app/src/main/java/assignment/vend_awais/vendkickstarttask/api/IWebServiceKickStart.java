package assignment.vend_awais.vendkickstarttask.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public interface IWebServiceKickStart {
    @GET("/3/movie/top_rated")
    Call<MoviesListResponseModel> getMoviesList(@Query("api_key") String api_key);
}
