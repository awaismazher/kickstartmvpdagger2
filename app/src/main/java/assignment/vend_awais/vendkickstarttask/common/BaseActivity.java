package assignment.vend_awais.vendkickstarttask.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import assignment.vend_awais.vendkickstarttask.application.MovieApplication;
import assignment.vend_awais.vendkickstarttask.di.component.AppComponent;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupComponent(((MovieApplication) this.getApplicationContext()).component());
  }

  protected abstract void setupComponent(AppComponent appComponent);
}
