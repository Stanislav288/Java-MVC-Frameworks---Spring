package app.entities;

import java.util.Date;

/**
 * Created by Galin on 16.2.2017 г..
 */
public class Book {

    private long id;

    private String title;

    private String author;

    private int pages;

    private Date creationDate;

    public Book() {
        this.setCreationDate(new Date());
    }

    public Book(long id, String title, String author, int pages, Date creationDate){
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
        this.setCreationDate(creationDate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
