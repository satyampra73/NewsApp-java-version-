package com.satyam.newsappjavaclone;

public class Articles {
    String title;
    String author;
    String description;
    String urlToImage;
    String url;

    public Articles(String title, String author, String description, String urlToImage, String url) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.urlToImage = urlToImage;
        this.url = url;
    }

    public Articles() {
    }

    @Override
    public String toString() {
        return "Articles{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
