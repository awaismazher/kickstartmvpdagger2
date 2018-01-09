package assignment.vend_awais.vendkickstarttask.di.component;

import javax.inject.Singleton;

import assignment.vend_awais.vendkickstarttask.CategoryApplication;
import assignment.vend_awais.vendkickstarttask.di.module.AppModule;
import assignment.vend_awais.vendkickstarttask.di.module.InteractorsModule;
import assignment.vend_awais.vendkickstarttask.movies.model.Movies;
import dagger.Component;

@Singleton @Component(modules = {
    AppModule.class, InteractorsModule.class
}) public interface AppComponent {
  void inject(CategoryApplication categoryApplication);

  Movies getFindItemsInteractor();
}
