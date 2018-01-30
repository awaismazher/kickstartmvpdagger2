package assignment.vend_awais.vendkickstarttask.di.module;

import android.app.Application;

import javax.inject.Singleton;

import assignment.vend_awais.vendkickstarttask.application.MovieApplication;
import dagger.Module;
import dagger.Provides;

@Module public class AppModule {

  private MovieApplication movieApplication;

  public AppModule(MovieApplication movieApplication) {
    this.movieApplication = movieApplication;
  }

  @Provides @Singleton public Application provideApplication() {
    return movieApplication;
  }
}
