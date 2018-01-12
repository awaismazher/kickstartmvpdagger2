package assignment.vend_awais.vendkickstarttask.movies.presenter;

import android.os.Looper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import assignment.vend_awais.vendkickstarttask.api.IWebServiceKickStart;
import assignment.vend_awais.vendkickstarttask.api.MoviesListResponseModel;
import assignment.vend_awais.vendkickstarttask.movies.model.Movie;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.MoviesPresenter;
import assignment.vend_awais.vendkickstarttask.movies.view.presenter.Presenter;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


/**
 * Created by syed.awais.mazhar on 1/11/2018.
 */
@RunWith(PowerMockRunner.class)
public class MoviePresenterTest {
    static final String TEST_ERROR_MESSAGE = "error_message";
    @InjectMocks
    private MoviesPresenter moviesPresenter;
    @Mock
    private Presenter presenter;
    @Mock
    private MoviesPresenter.PresenterView presenterView;
    @Mock
    private IWebServiceKickStart iWebServiceKickStart;
    @Mock
    Observable<MoviesListResponseModel> moviesListResponseModelObservable;
    @Mock
    private MoviesListResponseModel moviesListResponseModel;

    private final RxJavaSchedulersHook mRxJavaSchedulersHook = new RxJavaSchedulersHook() {
        @Override
        public Scheduler getIOScheduler() {
            return Schedulers.immediate();
        }

        @Override
        public Scheduler getNewThreadScheduler() {
            return Schedulers.immediate();
        }
    };

    @Before
    public void setUp(){
        initMocks(this);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
//        when(moviesListResponseModel.getMovies()).thenReturn(movies);
        when(iWebServiceKickStart.getMovieList(anyString())).thenReturn(moviesListResponseModelObservable);

    }
    @Test
    public void onLoadMovies(){
        PowerMockito.mockStatic(Looper.class);
        when(AndroidSchedulers.mainThread()).thenReturn(mRxJavaSchedulersHook.getComputationScheduler());
        moviesPresenter.onLoadMovies();
        verify(presenterView, atLeastOnce()).showProgress();
    }

    @Test
    public void getCategoriesViaObservable(){
        PowerMockito.mockStatic(Looper.class);
        when(AndroidSchedulers.mainThread()).thenReturn(mRxJavaSchedulersHook.getComputationScheduler());
        moviesPresenter.onLoadMovies();
        verify(presenterView, atLeastOnce()).showProgress();
        verify(iWebServiceKickStart.getMovieList(anyString())).asObservable();
    }
    @Test
    public void onCompleted(){
        moviesPresenter.onCompleted();
        verify(presenterView).hideProgress();
    }
    @Test
    public void onNext(){
        verify(presenterView).showCategories(moviesListResponseModel.getMovies());
    }

    @Test
    public void onError() {

        moviesPresenter.onError(new Throwable(TEST_ERROR_MESSAGE));
        verify(presenterView, atLeastOnce()).showMessage(TEST_ERROR_MESSAGE);
    }

}
