package assignment.vend_awais.vendkickstarttask.application;

import android.app.Application;
import android.content.Context;

import assignment.vend_awais.vendkickstarttask.di.component.AppComponent;
import assignment.vend_awais.vendkickstarttask.di.component.DaggerAppComponent;

public class MovieApplication extends Application {

  private AppComponent component;

  public static MovieApplication get(Context context) {
    return (MovieApplication) context.getApplicationContext();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    setupGraph();
  }

  private void setupGraph() {
    component = DaggerAppComponent.builder().build();
    component.inject(this);
  }

  @Override
  public void onTerminate() {
    super.onTerminate();
  }

  public AppComponent component() {
    return component;
  }
}