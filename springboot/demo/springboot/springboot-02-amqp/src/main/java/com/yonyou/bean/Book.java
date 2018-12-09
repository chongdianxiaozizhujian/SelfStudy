package com.yonyou.bean;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Book {

    private String booName;
    private String author;

    public Book() {
    }

    public Book(String booName, String author) {
        this.booName = booName;
        this.author = author;
    }

    public String getBooName() {
        return booName;
    }

    public void setBooName(String booName) {
        this.booName = booName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
