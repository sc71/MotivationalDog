package com.example.motivationaldog;

import java.lang.reflect.Array;

public class QuotesOnDesignResults {
    private int id, author, featured_media;
    private LevelTwoObjects guid, excerpt, content, title;
    private String date, date_gmt, modified, modified_gmt, slug, status,
                    type, link, comment_status, ping_status,
                    template, format;
    private boolean sticky;
    private Object[] meta, tags;
    private int[] categories;
    private Links _links;


    public QuotesOnDesignResults(int id, String date, String date_gmt, LevelTwoObjects guid,
                                 String modified, String modified_gmt, String slug,
                                 String status, String type, String link, LevelTwoObjects title,
                                 LevelTwoObjects content, LevelTwoObjects excerpt, int author,
                                 int featured_media, String comment_status, String ping_status,
                                 boolean sticky, String template, String format, Object[] meta,
                                 int[] categories, Object[] tags, Links _links) {
        this.id = id;
        this.date = date;
        this.date_gmt = date_gmt;
        this.guid = guid;
        this.modified = modified;
        this.modified_gmt = modified_gmt;
        this.slug = slug;
        this.status = status;
        this.type = type;
        this.link = link;
        this.title = title;
        this.content = content;
        this.excerpt = excerpt;
        this.author = author;
        this.featured_media = featured_media;
        this.comment_status = comment_status;
        this.ping_status = ping_status;
        this.sticky = sticky;
        this.template = template;
        this.format = format;
        this.meta = meta;
        this.categories = categories;
        this.tags = tags;
        this._links = _links;
    }

    public LevelTwoObjects getContent(){
       return content;
    }

}
