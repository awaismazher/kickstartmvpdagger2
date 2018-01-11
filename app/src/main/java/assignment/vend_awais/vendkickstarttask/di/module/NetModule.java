package assignment.vend_awais.vendkickstarttask.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import assignment.vend_awais.vendkickstarttask.api.IWebServiceKickStart;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by syed.awais.mazhar on 1/10/2018.
 */

@Module
public class NetModule {

    private final String mBaseUrl;

    public NetModule(String baseUrl){
        this.mBaseUrl = baseUrl;
    }

    @Provides
    public RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    public GsonConverterFactory proivdeGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory, RxJavaCallAdapterFactory adapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();
    }

    @Provides
    public IWebServiceKickStart provideIWebServiceKickStart(Retrofit retrofit){
        return retrofit.create(IWebServiceKickStart.class);
    }
}
