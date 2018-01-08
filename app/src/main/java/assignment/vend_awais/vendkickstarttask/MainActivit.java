package assignment.vend_awais.vendkickstarttask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import assignment.vend_awais.vendkickstarttask.api.KickStartApi;
import assignment.vend_awais.vendkickstarttask.callbacks.IKickStartApiICallback;
import assignment.vend_awais.vendkickstarttask.models.MoviesListResponseModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by VenD-Urooj on 1/5/2018.
 */

public class MainActivit extends AppCompatActivity {
    @BindView(R.id.tv_hello_world)
    TextView tv_hello_world;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_hello_world)
    void onTVClick(){
        KickStartApi.getInstance().getMoviesList(new IKickStartApiICallback() {
            @Override
            public void onSuccess(Object object) {
                if(object!=null){
                    MoviesListResponseModel model = (MoviesListResponseModel) object;
                    Toast.makeText(getApplicationContext(),model.getTotalPages()+" ",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFail(Object object) {
                Toast.makeText(getApplicationContext(),"Call Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
