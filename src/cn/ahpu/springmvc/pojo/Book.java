package cn.ahpu.springmvc.pojo;

import java.util.Date;

public class Book {
    String isbn;//图书编号，主键
    String title;
    String author;
    double price;
    String press;
    Integer edition;
    java.util.Date published;
    Integer pages;
    Integer words;
    String packaging;
    String format;
    String form;
    public Book() {}
    public Book(String isbn, String title, String author, double price, String press, Integer edition, Date published,
                Integer pages, Integer words, String packaging, String format, String form) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.press = press;
        this.edition = edition;
        this.published = published;
        this.pages = pages;
        this.words = words;
        this.packaging = packaging;
        this.format = format;
        this.form = form;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPress() {
        return press;
    }
    public void setPress(String press) {
        this.press = press;
    }
    public Integer getEdition() {
        return edition;
    }
    public void setEdition(Integer edition) {
        this.edition = edition;
    }
    public Date getPublished() {
        return published;
    }
    public void setPublished(Date published) {
        this.published = published;
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public Integer getWords() {
        return words;
    }
    public void setWords(Integer words) {
        this.words = words;
    }
    public String getPackaging() {
        return packaging;
    }
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }

}
