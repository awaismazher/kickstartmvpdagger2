package assignment.vend_awais.vendkickstarttask.movies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import assignment.vend_awais.vendkickstarttask.R;
import assignment.vend_awais.vendkickstarttask.movies.holder.MovieViewHolder;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movies;
    private ItemClickListener itemClickListener;

    public MovieAdapter() {
        movies = Collections.emptyList();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        final Movie movie = movies.get(position);
        holder.bind(movie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(movie, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Movie movie, int position);
    }
}
