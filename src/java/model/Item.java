package model;

public class Item extends Book {

    private int amount;

    public Item(Book book, int amount) {
        this(book.getId(),
                book.getTitle(),
                book.getAuthors(),
                book.getPrice(),
                book.getStock(),
                amount);
    }

    public Item(int id, String title, String authors, int price, int stock, int amount) {
        super(title, authors, price, stock);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
