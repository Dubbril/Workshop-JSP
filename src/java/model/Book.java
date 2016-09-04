package model;

public class Book {

    private int id;
    private String title;
    private String authors;
    private int stock;
    private int price;

    public Book(String title, String authors, int price, int stock) {
        this(0, title, authors, price, stock);
    }

    public Book(int id, String title, String authors, int price, int stock) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.stock = stock;
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
