package qdsl.visl;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Yao on 15-06-10.
 */
public class AsyncTopRetrieverTask extends AsyncTask<Void, Void, Void> {
    private static String mangaEdenListUrl = "https://www.mangaeden.com/api/list/0/";
    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void ...arg0) {
        Log.i("AsyncTopRetrieverTask", "Executing now");
        RestClient.connect(mangaEdenListUrl);
        return null;
    }
}
