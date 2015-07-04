package qdsl.visl.Controller;

import java.util.ArrayList;
import java.util.List;

import qdsl.visl.Model.MangaSeries;

/**
 * Created by Yao on 15-06-17.
 */
public class MangaController {
    List<MangaSeries> mangaSeries;
    Boolean hasSeries;

    public MangaController() {
        mangaSeries = new ArrayList<MangaSeries>();
        hasSeries = false;
    }

    public List<MangaSeries> getList() {
        return mangaSeries;
    }

    public void addManga(String imgURL, String name, String id) {
        MangaSeries tempSeries = new MangaSeries();
        tempSeries.title = name;
        tempSeries.image = imgURL;
        tempSeries.id = id;
        mangaSeries.add(tempSeries);

        if (hasSeries == false) {
            hasSeries = true;
        }
    }

    public Boolean hasSeries() {
        return hasSeries;
    }
}
