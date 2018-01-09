package assignment.vend_awais.vendkickstarttask.di.module;

import assignment.vend_awais.vendkickstarttask.movies.model.Movies;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.MoviesPresenter;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import dagger.Module;
import dagger.Provides;

@Module public class MovieModule {

  private MoviesPresenter.View view;

  public MovieModule(MoviesPresenter.View view) {
    this.view = view;
  }

  @Provides public MoviesPresenter.View provideView() {
    return view;
  }

  @Provides
  public Presenter providePresenter(MoviesPresenter.View categoryView, Movies movies) {
    return new MoviesPresenter(categoryView, movies);
  }
}
