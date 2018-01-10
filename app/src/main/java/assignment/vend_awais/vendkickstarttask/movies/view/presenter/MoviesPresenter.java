package assignment.vend_awais.vendkickstarttask.movies.view.presenter;

import java.util.List;

import assignment.vend_awais.vendkickstarttask.movies.model.Callback;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import assignment.vend_awais.vendkickstarttask.movies.model.Movies;

public class MoviesPresenter implements Presenter, Callback {

  private PresenterView presenterView;
  private Movies movies;

  public MoviesPresenter(PresenterView presenterView, Movies movies) {
    this.presenterView = presenterView;
    this.movies = movies;
  }

  @Override
  public void onResume() {
    presenterView.showProgress();
    movies.getCategories(this);
  }

  @Override
  public void onItemSelected(Movie movie, int position) {
    presenterView.showMessage(String.format(movie.getTitle() + " ->" + " Position %d clicked", position));
  }

  @Override
  public void onLoadCategories(List<Movie> movies) {
    presenterView.showCategories(movies);
    presenterView.hideProgress();
  }

  public interface PresenterView {

    void showProgress();

    void hideProgress();

    void showCategories(List<Movie> categories);

    void showMessage(String message);
  }
}
