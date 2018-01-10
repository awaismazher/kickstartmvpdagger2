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
import assignment.vend_awais.vendkickstarttask.di.component.DaggerMovieComponent;
import assignment.vend_awais.vendkickstarttask.di.module.MovieModule;
import assignment.vend_awais.vendkickstarttask.movies.adapter.MovieAdapter;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.MoviesPresenter;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieActivity extends BaseActivity
        implements MoviesPresenter.PresenterView, MovieAdapter.ItemClickListener {

    @Inject
    Presenter presenter;
    @BindView(R.id.pb_loading)
    ProgressBar progressBar;
    @BindView(R.id.rv_movies)
    RecyclerView recyclerView;
    @Inject
    RecyclerView.LayoutManager mLayoutManager;
    @Inject
    MovieAdapter categoryAdapter;

    @Override
    protected void setupComponent(AppComponent appComponent) {

        DaggerMovieComponent.builder()
                .appComponent(appComponent)
                .movieModule(new MovieModule(this, this))
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
        if(items==null)
            showMessage(getString(R.string.no_movies_available));
        categoryAdapter.setMovies(items);
        categoryAdapter.setItemClickListener(this);
        initRecyclerView();

        recyclerView.setAdapter(categoryAdapter);

    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
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
