package model;

public class BookTable {

    private Database db;

    public BookTable(Database db) {
        this.db = db;
    }

    public void add(Book book) {
        String sql = "insert into book "
                + " (title,authors,price,stock) "
                + " values(?,?,?,?) ";
        int id = db.add(sql, book.getTitle(), book.getAuthors(), book.getPrice(), book.getStock());
        book.setId(id);
    }
    public void update(Book book){
        String sql = "update book "
                + " set title=?, authors=?, price=?, stock=? "
                + " where id=?";
        db.update(sql, book.getTitle(), book.getAuthors(), book.getPrice(), book.getStock(),book.getId());
    }
    public void remove(int id){
        String sql = "delete from book "
                + " where id=?";
        db.remove(sql, id);
    }
}
