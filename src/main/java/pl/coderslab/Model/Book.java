package pl.coderslab.Model;

public class Book {

    private int id;
    private String author;
    private String title;
    private String isbn;

    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(int id, String author, String title, String isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() { return isbn; }

    public int getId() { return id; }


}
