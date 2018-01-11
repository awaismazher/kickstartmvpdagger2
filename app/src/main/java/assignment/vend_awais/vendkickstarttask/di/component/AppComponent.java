package assignment.vend_awais.vendkickstarttask.di.component;

import javax.inject.Singleton;

import assignment.vend_awais.vendkickstarttask.application.MovieApplication;
import assignment.vend_awais.vendkickstarttask.di.module.AppModule;
import dagger.Component;

@Singleton @Component(modules = {
    AppModule.class
}) public interface AppComponent {
  void inject(MovieApplication movieApplication);

  //Movies getFindItemsInteractor();
}
