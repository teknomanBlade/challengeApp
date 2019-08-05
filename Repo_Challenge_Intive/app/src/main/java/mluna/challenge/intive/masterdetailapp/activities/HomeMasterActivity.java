package mluna.challenge.intive.masterdetailapp.activities;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mluna.challenge.intive.masterdetailapp.R;
import mluna.challenge.intive.masterdetailapp.adapter.RecyclerViewProfileImagesAdapter;
import mluna.challenge.intive.masterdetailapp.asynctask.AsyncTaskRandomUser;
import mluna.challenge.intive.masterdetailapp.entities.ProfileUser;
import mluna.challenge.intive.masterdetailapp.entities.Result;
import mluna.challenge.intive.masterdetailapp.interfaces.CustomCallback;

public class HomeMasterActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView _recyclerView;
    private AsyncTaskRandomUser asyncTask;
    private RecyclerViewProfileImagesAdapter _adapter;
    private ArrayList<Result> listResults = new ArrayList<Result>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_master);
        progressBar = findViewById(R.id.progressBar);
        if (android.os.Build.VERSION.SDK_INT > 15)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        overridePendingTransition(R.anim.enter, R.anim.exit);
        performApiCallJSON();

    }

    private void generateDataList(ArrayList<Result> results) {
        _recyclerView = findViewById(R.id.customRecyclerView);
        _recyclerView.setHasFixedSize(true);
        _adapter = new RecyclerViewProfileImagesAdapter(getApplicationContext(),results);
        _recyclerView.setAdapter(_adapter);
        _recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
    }



    public void performApiCallJSON(){
        asyncTask = new AsyncTaskRandomUser(getApplicationContext(), this,
                getResources().getString(R.string.endpoint_url), new CustomCallback() {
            @Override
            public String initiatingRequest(String[] params) {
                String resp = "";


                return resp;
            }

            @Override
            public void completed(String result) {
                progressBar.setVisibility(View.GONE);
                readJSON(result);
            }

            @Override
            public void starting() {

            }

            @Override
            public void update() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        asyncTask.execute();
    }

    public void readJSON(String ret){
        try{
            JSONObject jsonObject = new JSONObject(ret);
            ProfileUser profileUser = new ProfileUser(jsonObject);
            listResults = profileUser.getResults();
            generateDataList(listResults);

        }catch (JSONException jsone){
            jsone.printStackTrace();
            Toast.makeText(getApplicationContext(), jsone.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        asyncTask.cancel(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        asyncTask.cancel(true);
    }


}
