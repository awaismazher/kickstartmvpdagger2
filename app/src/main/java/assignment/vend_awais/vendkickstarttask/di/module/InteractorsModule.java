package assignment.vend_awais.vendkickstarttask.di.module;

import assignment.vend_awais.vendkickstarttask.movies.model.Movies;
import dagger.Module;
import dagger.Provides;

@Module public class InteractorsModule {

  @Provides public Movies provideFindItemsInteractor() {
    return new Movies();
  }
}
