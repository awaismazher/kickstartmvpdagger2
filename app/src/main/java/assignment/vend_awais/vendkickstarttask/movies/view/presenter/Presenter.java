package assignment.vend_awais.vendkickstarttask.movies.view.presenter;


import assignment.vend_awais.vendkickstarttask.api.MoviesListResponseModel;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */


public interface Presenter {

  void onLoadMovies();
  void setView(MoviesPresenter.PresenterView presenterView);
  void onItemSelected(Movie movie, int position);
  default void subscribe(Observable<MoviesListResponseModel> observable, Observer<MoviesListResponseModel> observer) {
    observable.subscribeOn(Schedulers.newThread())
            .toSingle()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
  }

}
