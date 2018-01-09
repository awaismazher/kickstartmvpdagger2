package assignment.vend_awais.vendkickstarttask.di.module;

import android.app.Application;

import javax.inject.Singleton;

import assignment.vend_awais.vendkickstarttask.CategoryApplication;
import dagger.Module;
import dagger.Provides;

@Module public class AppModule {

  private CategoryApplication categoryApplication;

  public AppModule(CategoryApplication categoryApplication) {
    this.categoryApplication = categoryApplication;
  }

  @Provides @Singleton public Application provideApplication() {
    return categoryApplication;
  }
}
