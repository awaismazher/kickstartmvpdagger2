package assignment.vend_awais.vendkickstarttask.movies.view.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import assignment.vend_awais.vendkickstarttask.R;
import assignment.vend_awais.vendkickstarttask.common.BaseActivity;
import assignment.vend_awais.vendkickstarttask.di.component.AppComponent;
import assignment.vend_awais.vendkickstarttask.di.component.DaggerCategoryComponent;
import assignment.vend_awais.vendkickstarttask.di.module.MovieModule;
import assignment.vend_awais.vendkickstarttask.movies.adapter.MovieAdapter;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.MoviesPresenter;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryActivity extends BaseActivity
        implements MoviesPresenter.View, MovieAdapter.ItemClickListener {

    @Inject
    Presenter presenter;
    @BindView(R.id.pb_loading)
    ProgressBar progressBar;
    @BindView(R.id.rv_movies)
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void setupComponent(AppComponent appComponent) {

        DaggerCategoryComponent.builder()
                .appComponent(appComponent)
                .movieModule(new MovieModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCategories(List<Movie> items) {

        MovieAdapter categoryAdapter = new MovieAdapter();
        categoryAdapter.setMovies(items);
        categoryAdapter.setItemClickListener(this);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(categoryAdapter);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Movie movie, int position) {
        presenter.onItemSelected(movie, position);
    }
}
