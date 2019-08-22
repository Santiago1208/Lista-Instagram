package com.mocte.listainstagram;

public class Post {

    private long id;

    private int photo;

    private String publishDate;

    private String description;

    private int views;

    private boolean liked;

    public Post() {
        // Required empty constructor
    }

    public Post(long id, int photo, String publishDate, String description, int views, boolean liked) {
        this.id = id;
        this.photo = photo;
        this.publishDate = publishDate;
        this.description = description;
        this.views = views;
        this.liked = liked;
    }

    public int getPhoto() {
        return photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
