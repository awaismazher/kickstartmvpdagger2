package assignment.vend_awais.vendkickstarttask.di.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import assignment.vend_awais.vendkickstarttask.movies.adapter.MovieAdapter;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.MoviesPresenter;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import dagger.Module;
import dagger.Provides;

@Module public class MovieModule {

  private Context mContext;
  private MoviesPresenter.PresenterView presenterView;

  public MovieModule(MoviesPresenter.PresenterView presenterView, Context context) {
    this.mContext = context;
    this.presenterView = presenterView;
  }

  @Provides
  public RecyclerView.LayoutManager provideLayoutManager(){
     return new LinearLayoutManager(mContext);
  }
  @Provides public MoviesPresenter.PresenterView provideView() {
    return presenterView;
  }

  @Provides
  public Presenter providePresenter(MoviesPresenter moviesPresenterView) {
    return moviesPresenterView;
  }

  @Provides
  public MovieAdapter provideMovieAdapter(){
    return new MovieAdapter();
  }
}
