package qdsl.visl.Model;
import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

import java.util.List;

public class MangaChapter {
    public String id;
    public String title;
    public int releaseRataDi;
    public int sequenceId;
    public List<MangaPage> pages;

    public MangaChapter() {
        id = null;
        title = null;
        releaseRataDi = -1;
        pages = null;
    }


}
