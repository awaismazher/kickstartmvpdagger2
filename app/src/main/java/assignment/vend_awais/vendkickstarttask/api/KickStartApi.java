package assignment.vend_awais.vendkickstarttask.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import assignment.vend_awais.vendkickstarttask.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static assignment.vend_awais.vendkickstarttask.util.Constants.API_KEY;

/**
 * Created by syed.awais.mazhar on 1/8/2018.
 */

public class KickStartApi {

    private static final String YYYY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String IMAGE = "image/*";
    private static KickStartApi kickStartApi;

    private final Gson mGson;
    private final IWebServiceKickStart mApiService;

    private final int STATUS_OK = 200;

    private KickStartApi() {
        String BASE_URL;
        if (BuildConfig.DEBUG) {
            //TODO Add base URL
            BASE_URL = "https://api.themoviedb.org/";
        } else {
            //TODO ADD LIVE
            BASE_URL = "https://api.themoviedb.org/";
        }
        mGson = new GsonBuilder()
                .setDateFormat(YYYY_MM_DD_T_HH_MM_SS_Z)
                .setLenient()
                .create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                //.addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();
        mApiService = mRetrofit.create(IWebServiceKickStart.class);
    }

    /**
     * Returns the singleton instance of API class
     */
    public static KickStartApi getInstance() {
        if (kickStartApi == null) {
            kickStartApi = new KickStartApi();
        }
        return kickStartApi;
    }

    /**
     * Get moviesList
     *
     * @param iKickStartApiICallback
     */
    public void getMoviesList(final IKickStartApiICallback iKickStartApiICallback) {
        Call<MoviesListResponseModel> openTokSessionCall = mApiService.getMoviesList(API_KEY);
        openTokSessionCall.enqueue(new Callback<MoviesListResponseModel>() {
            @Override
            public void onResponse(Call<MoviesListResponseModel> call, Response<MoviesListResponseModel> response) {
                if (response != null) {
                    int statusCode = response.code();
                    if (statusCode == STATUS_OK) {
                        iKickStartApiICallback.onSuccess(response.body());
                    } else {
                        iKickStartApiICallback.onFail(response.errorBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<MoviesListResponseModel> call, Throwable t) {
                call.isCanceled();
                //showApiErrorDialog(t.getMessage());
                iKickStartApiICallback.onFail(t.getMessage());
            }
        });
    }

}
