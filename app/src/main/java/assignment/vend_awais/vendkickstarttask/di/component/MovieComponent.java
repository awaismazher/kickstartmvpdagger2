package assignment.vend_awais.vendkickstarttask.di.component;

import assignment.vend_awais.vendkickstarttask.di.module.NetModule;
import assignment.vend_awais.vendkickstarttask.di.scope.ActivityScope;
import assignment.vend_awais.vendkickstarttask.di.module.MovieModule;
import assignment.vend_awais.vendkickstarttask.movies.view.activity.MovieActivity;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {MovieModule.class, NetModule.class})
public interface MovieComponent {
  void inject(MovieActivity movieActivity);

}
