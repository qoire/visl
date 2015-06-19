package qdsl.visl.Utils;

import android.content.Context;
import android.location.GpsStatus;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import qdsl.visl.Controller.MangaController;

/**
 * Created by Yao on 15-06-19.
 */
public class MangaEdenClient {
    public static final String mangaEdenMainURL = "https://www.mangaeden.com/api/list/0/";
    public static final String mangaEdenImageURL = "https://cdn.mangaeden.com/mangasimg/";

    RequestQueue mRequestQueue;
    MangaController mangaController;

    public void loadMainJSON(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mRequestQueue.add(new JsonObjectRequest(mangaEdenMainURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mangaController = createMangaEdenSeries(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("loadMainJSON", error.toString());
                    }
                }));
    }

    private MangaController createMangaEdenSeries(JSONObject in) {
        MangaController mangaController;
        mangaController = null;
        try {
            mangaController = new MangaController();
            Log.i("createMangaEdenSeries", "initiate");

            JSONArray mangaJSONArray = null;
            if (in != null) {
                mangaJSONArray = in.getJSONArray("manga");

                for (int i = 0; i < mangaJSONArray.length(); i++) {
                    JSONObject mangaTitle = mangaJSONArray.getJSONObject(i);
                    mangaController.addManga(
                            mangaTitle.getString("t"),
                            mangaTitle.getString("im"),
                            mangaTitle.getString("i"));
                    Log.i("createMangaEdenSeries", mangaTitle.getString("t"));
                }
            }

        } catch (JSONException e){
            Log.d("createMangaEdenSeries", e.toString());
        }

        return (mangaController);
    }
}
