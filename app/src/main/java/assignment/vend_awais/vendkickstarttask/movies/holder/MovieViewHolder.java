package assignment.vend_awais.vendkickstarttask.movies.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import assignment.vend_awais.vendkickstarttask.R;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by syed.awais.mazhar on 1/9/2018.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

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

    public void bind(Movie movie) {
        tv_tile.setText(tv_tile.getContext().getString(R.string.title, movie.getTitle()));
        tv_rating.setText(tv_rating.getContext().getString(R.string.rating, (int) movie.getVoteAverage()));
        Picasso.with(iv_poster.getContext())
                .load(iv_poster.getContext().getString(R.string.image_base_path, movie.getPosterPath()))
                .into(iv_poster);
    }
}