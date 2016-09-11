package model;

public class OrderDetail {

    private int id;
    private Order order;
    private Book book;
    private int amount;

    public OrderDetail(Order order, Book book, int amount) {
        this(0, order, book, amount);
    }

    public OrderDetail(int id, Order order, Book book, int amount) {
        this.id = id;
        this.order = order;
        this.book = book;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
