package assignment.vend_awais.vendkickstarttask.di.component;

import android.support.v7.widget.RecyclerView;

import assignment.vend_awais.vendkickstarttask.di.scope.ActivityScope;
import assignment.vend_awais.vendkickstarttask.di.module.MovieModule;
import assignment.vend_awais.vendkickstarttask.movies.adapter.MovieAdapter;
import assignment.vend_awais.vendkickstarttask.movies.view.activity.MovieActivity;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MovieModule.class)
public interface MovieComponent {
  void inject(MovieActivity movieActivity);

  Presenter
  getMainPresenter();
  RecyclerView.LayoutManager getLinearLayoutManager();
  MovieAdapter getMovieAdapter();
}
