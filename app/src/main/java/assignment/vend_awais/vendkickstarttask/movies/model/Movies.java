package assignment.vend_awais.vendkickstarttask.movies.model;

import java.util.List;

import assignment.vend_awais.vendkickstarttask.api.KickStartApi;
import assignment.vend_awais.vendkickstarttask.api.IKickStartApiICallback;
import assignment.vend_awais.vendkickstarttask.api.MoviesListResponseModel;
/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */
public class Movies {
  List<Movie> movies;
  public void getCategories(final Callback callback) {
    KickStartApi.getInstance().getMoviesList(new IKickStartApiICallback() {
      @Override
      public void onSuccess(Object object) {
        if(object!=null){
          MoviesListResponseModel moviesListResponseModel = (MoviesListResponseModel) object;
          movies = moviesListResponseModel.getMovies();
          callback.onLoadCategories(movies);
        }
      }

      @Override
      public void onFail(Object object) {
          callback.onLoadCategories(movies);
      }
    });
  }
}
