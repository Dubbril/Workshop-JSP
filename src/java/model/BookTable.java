package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void update(Book book) {
        String sql = "update book "
                + " set title=?, authors=?, price=?, stock=? "
                + " where id=?";
        db.update(sql, book.getTitle(), book.getAuthors(), book.getPrice(), book.getStock(), book.getId());
    }

    public void remove(int id) {
        String sql = "delete from book "
                + " where id=?";
        db.remove(sql, id);
    }

    public Book findById(int id) {
        String sql = "select * from book where id=?";
        Map<String, Object> result = db.querrySingle(sql, id);
        return new Book(id, (String) result.get("title"),
                (String) result.get("authors"),
                (Integer) result.get("price"),
                (Integer) result.get("stock"));
    }

    public List<Book> findByKeyword(String keyword, int start, int size) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from book "
                + " where title like ? or authors like ? "
                + " order by title "
                + " limit " + start + "," + size;
        List<Map<String, Object>> result;
        result = db.querryList(sql, "%" + keyword + "%", "%" + keyword + "%");
        for (Map<String, Object> row : result) {
            Book book = new Book((Integer) row.get("id"),
                    (String) row.get("title"),
                    (String) row.get("authors"),
                    (Integer) row.get("price"),
                    (Integer) row.get("stock"));
            list.add(book);
        }
        return list;
    }

    public int getSize() {
        String sql = "select count(*) from book";
        Map<String, Object> result = db.querrySingle(sql);
        return ((Long) result.get("count(*)")).intValue();
    }

    public List<Book> findAll() {
        return findByKeyword("", 0, getSize());
    }
}
