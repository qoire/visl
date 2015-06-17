package qdsl.visl;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import qdsl.visl.Controller.MangaController;
import qdsl.visl.Model.MangaSeries;
import qdsl.visl.Utils.RestClient;

/**
 * Created by Yao on 15-06-10.
 */
public class AsyncTopRetrieverTask extends AsyncTask<Object, Void, Void> {
    private static String mangaEdenListUrl = "https://www.mangaeden.com/api/list/0/";
    private static String mangaEdenImageUrl = "https://cdn.mangaeden.com/mangasimg/";

    public MangaController mangaController;

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Object ...arg0) {
        Log.i("AsyncTopRetrieverTask", "Executing now");
        int serviceCode = (int)arg0[0];

        if (serviceCode == 0) {
            JSONObject seriesJSONObject = RestClient.connect(mangaEdenListUrl);
            mangaController = createMangaEdenSeries(seriesJSONObject);
        }
        return null;
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
                    mangaController.addManga(mangaTitle.getString("t"),
                            mangaTitle.getString("im"));
                    Log.i("createMangaEdenSeries", mangaTitle.getString("t"));
                }
            }

        } catch (JSONException e){
            Log.d("createMangaEdenSeries", e.toString());
        }

        return (mangaController);
    }

}
