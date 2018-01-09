package assignment.vend_awais.vendkickstarttask.movies.view.presenter;


import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */


public interface Presenter {

  void onResume();

  void onItemSelected(Movie movie, int position);
}
