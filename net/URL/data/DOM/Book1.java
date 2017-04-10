package com.newer.net.URL.data.DOM;

/**
 * Created by json on 2017/3/11.
 */
public class Book1 {

        private int id;
        private String title;
        private String author;

    public Book1() {
    }

    public Book1(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book1 doMapp = (Book1) o;

        if (id != doMapp.id) return false;
        if (title != null ? !title.equals(doMapp.title) : doMapp.title != null) return false;
        return author != null ? author.equals(doMapp.author) : doMapp.author == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
