package com.example.acer.volleytutorial.volley;

public class BookModel
{
    public String author;
    public String title;
    public String img;
    public String desc;

    public BookModel(String author, String title, String img, String desc) {
        this.author = author;
        this.title = title;
        this.img = img;
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }
}
