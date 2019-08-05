package mluna.challenge.intive.masterdetailapp.asynctask;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import mluna.challenge.intive.masterdetailapp.interfaces.CustomCallback;

public class AsyncTaskRandomUser extends AsyncTask<String,String,String> {
    String resp;
    ProgressBar progressBar;
    Context context;
    Activity activity;
    String method = null;
    String url = "";
    CustomCallback callback;
    private String param;
    private int responseCode;
    private StringBuilder sb;
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PUT = "PUT";

    public AsyncTaskRandomUser(Context context, Activity activity, String url, CustomCallback callback) {
        sb = new StringBuilder();
        param = "&results=60";
        this.context = context;
        this.activity = activity;
        this.url = url;
        sb.append(this.url);
        sb.append(param);
        this.callback = callback;
    }
    public String doConnection() {
        String ret = null;
        method = GET;

        try {
            URL url = new URL(sb.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");
            responseCode = conn.getResponseCode();
            InputStream is;
            if (responseCode == 200) {
                is = conn.getInputStream();
            } else {
                is = conn.getErrorStream();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }


            br.close();
            is.close();
            conn.disconnect();
            ret = sb.toString();
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }


        return ret;
    }



    @Override
    protected String doInBackground(String... strings) {
        return doConnection();
    }
    @Override
    protected void onPostExecute(String result) {
        callback.completed(result);
    }
    @Override
    protected void onPreExecute() { callback.update(); }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }
}
