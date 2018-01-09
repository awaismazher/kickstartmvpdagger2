package assignment.vend_awais.vendkickstarttask.movies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import assignment.vend_awais.vendkickstarttask.R;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

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
        bind(holder, movie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(movie, position);
                }
            }
        });
    }

    private void bind(MovieViewHolder holder, Movie movie) {
        holder.tv_tile.setText(holder.tv_tile.getContext().getString(R.string.title, movie.getTitle()));
        holder.tv_rating.setText(holder.tv_rating.getContext().getString(R.string.rating, movie.getVoteAverage()));
        Picasso.with(holder.iv_poster.getContext())
                .load(holder.iv_poster.getContext().getString(R.string.image_base_path, movie.getPosterPath()))
                .into(holder.iv_poster);
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

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_movie_poster)
        ImageView iv_poster;

        @BindView(R.id.tv_title)
        TextView tv_tile;

        @BindView(R.id.tv_rating)
        TextView tv_rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
