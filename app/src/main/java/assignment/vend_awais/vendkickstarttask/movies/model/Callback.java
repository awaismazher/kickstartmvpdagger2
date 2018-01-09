package assignment.vend_awais.vendkickstarttask.movies.model;

import java.util.List;
/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public interface Callback {
  void onLoadCategories(List<Movie> categories);
}
