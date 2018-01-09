package assignment.vend_awais.vendkickstarttask.movies.view.presenter;

import java.util.List;

import assignment.vend_awais.vendkickstarttask.movies.model.Callback;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import assignment.vend_awais.vendkickstarttask.movies.model.Movies;

public class MoviesPresenter implements Presenter, Callback {

  private View view;
  private Movies movies;

  public MoviesPresenter(View view, Movies movies) {
    this.view = view;
    this.movies = movies;
  }

  @Override
  public void onResume() {
    view.showProgress();
    movies.getCategories(this);
  }

  @Override
  public void onItemSelected(Movie movie, int position) {
    view.showMessage(String.format(movie.getTitle() + " ->" + " Position %d clicked", position));
  }

  @Override
  public void onLoadCategories(List<Movie> movies) {
    view.showCategories(movies);
    view.hideProgress();
  }

  public interface View {

    void showProgress();

    void hideProgress();

    void showCategories(List<Movie> categories);

    void showMessage(String message);
  }
}
