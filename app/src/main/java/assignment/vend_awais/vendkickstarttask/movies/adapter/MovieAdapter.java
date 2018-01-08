package assignment.vend_awais.vendkickstarttask.movies.adapter;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {

    private List<Movie> categories;
    private ItemClickListener itemClickListener;

    public MovieAdapter() {
        categories = Collections.emptyList();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int position) {
        final Category category = categories.get(position);
        bind(holder, category);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(category, position);
                }
            }
        });
    }

    private void bind(CategoryViewHolder holder, Category category) {
        holder.textView.setText(category.getName());
        holder.textView.setBackgroundColor(
                getColor(holder.textView.getContext(), category.getPrimaryColor()));
        holder.imageView.setImageResource(category.getIcon());
        holder.imageView.setBackgroundColor(
                getColor(holder.imageView.getContext(), category.getBackgroundColor()));
    }

    private int getColor(Context context, @ColorRes int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Category category, int position);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_category_icon)
        ImageView imageView;

        @BindView(R.id.label_category_name)
        TextView textView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
