package assignment.vend_awais.vendkickstarttask.stubs;

import assignment.vend_awais.vendkickstarttask.api.IWebServiceKickStart;
import assignment.vend_awais.vendkickstarttask.api.MoviesListResponseModel;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import retrofit2.Call;
import rx.Observable;
import rx.Observer;

/**
 * Created by syed.awais.mazhar on 1/15/2018.
 */

public class MoviesListStub implements IWebServiceKickStart {
    @Override
    public Call<MoviesListResponseModel> getMoviesList(String api_key) {
        return null;
    }

    @Override
    public Observable<MoviesListResponseModel> getMovieList(String api_key) {
        MoviesListResponseModel moviesListResponseModel = new MoviesListResponseModel();
        Movie movie = new Movie();
        moviesListResponseModel.getMovies().add(movie);
        moviesListResponseModel.getMovies().add(movie);
        return Observable.just(moviesListResponseModel);
    }
}
