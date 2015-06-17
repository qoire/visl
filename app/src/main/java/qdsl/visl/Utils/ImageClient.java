package qdsl.visl.Utils;

import android.graphics.Bitmap;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by Yao on 15-06-17.
 */
public class ImageClient {
    public static Bitmap retrieveImage(String url) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            Log.i("ImageClient", "IOException");
            e.printStackTrace();
        }
    }
}
