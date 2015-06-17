package qdsl.visl.Model;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Yao on 15-06-17.
 */
public class MangaSeries {
    private static final String DESCRIPTION = "description";
    private static final String AUTHOR = "author";
    private static final String CHAPTERS = "chapters";
    private static final String ID = "i";
    private static final String IMAGE = "im";
    private static final String TITLE = "t";
    private static final String LAST_CHAPTER_RATA_DI = "last_chapter_date";
    private static final String CREATED_RATA_DI = "created";
    private static final String CATEGORIES = "categories";

    public String id;
    public String image;
    public String title;
    public String description;
    public List<String> categories;
    public String author;
    public int lastChapterRataDi;
    public int createdRataDi;
    public boolean isFavourite;
    public String service;
    public List<MangaChapter> chapters;

    public MangaSeries() {
        id = null;
        image = null;
        title = null;
        description = null;
        categories = null;
        author = null;
        lastChapterRataDi = -1;
        createdRataDi = -1;
        chapters = null;
        isFavourite = false;
        service = "mangaeden";
    }

}
