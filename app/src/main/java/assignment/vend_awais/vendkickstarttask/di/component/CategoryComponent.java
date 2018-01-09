package assignment.vend_awais.vendkickstarttask.di.component;

import assignment.vend_awais.vendkickstarttask.di.ActivityScope;
import assignment.vend_awais.vendkickstarttask.di.module.MovieModule;
import assignment.vend_awais.vendkickstarttask.movies.view.activity.CategoryActivity;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MovieModule.class)
public interface CategoryComponent {
  void inject(CategoryActivity categoryActivity);

  Presenter
  getMainPresenter();
}
