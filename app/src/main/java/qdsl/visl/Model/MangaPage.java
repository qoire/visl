package qdsl.visl.Model;


/**
 * Created by Yao on 15-06-17.
 */
public class MangaPage {
    public int pageNum;
    public String pageUrl;

    public MangaPage() {
        pageNum = -1;
        pageUrl = null;
    }

    public void setUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void setPage(int pageNum) {
        this.pageNum = pageNum;
    }
}
