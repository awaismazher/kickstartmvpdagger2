package assignment.vend_awais.vendkickstarttask;

import android.app.Application;
import android.content.Context;

import assignment.vend_awais.vendkickstarttask.di.component.AppComponent;
import assignment.vend_awais.vendkickstarttask.di.component.DaggerAppComponent;
import assignment.vend_awais.vendkickstarttask.di.module.AppModule;

public class CategoryApplication extends Application {

  private AppComponent component;

  public static CategoryApplication get(Context context) {
    return (CategoryApplication) context.getApplicationContext();
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

  public AppComponent component() {
    return component;
  }
}