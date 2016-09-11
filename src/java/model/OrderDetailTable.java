package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDetailTable {

    private Database db;

    public OrderDetailTable(Database db) {
        this.db = db;
    }

    public void add(OrderDetail orderDetail) {
        String sql = "insert into order_detail "
                + " (order_id,book_id,amount) "
                + " values(?,?,?)";
        int id = db.add(sql, orderDetail.getOrder(),
                orderDetail.getBook(),
                orderDetail.getAmount());
        orderDetail.setId(id);
    }

    public List<OrderDetail> findByOrderId(int order_id) {

        List<OrderDetail> list = new ArrayList<OrderDetail>();
        String sql = "select *, order_detail.id as order_detail_id "
                + " from order_detail "
                + " inner join `order` "
                + " on order_detail.order_id=`order`.id "
                + " inner join member "
                + " on `order`.member_id=member_id "
                + " inner join book "
                + " on order_detail.book_id = book.id "
                + " where order_detail.order_id=? "
                + " order by `order`.id";
        List<Map<String, Object>> result;
        result = db.querryList(sql, order_id);

        for (Map<String, Object> row : result) {
            Book book = new Book((Integer) row.get("book_id"),
                    (String) row.get("title"),
                    (String) row.get("authors"),
                    (Integer) row.get("price"),
                    (Integer) row.get("stock"));
            Member member;
            member = new Member((Integer) row.get("member_id"),
                    (String) row.get("username"),
                    (String) row.get("password"),
                    (String) row.get("name"),
                    (String) row.get("address"),
                    (String) row.get("email"),
                    (Boolean) row.get("activated"),
                    (String) row.get("activated_code"),
                    (Date) row.get("register_date"));
            Order order;
            order = new Order((Integer) row.get("order_id"),
                    member,
                    (Date) row.get("date"),
                    (String) row.get("shipping_address"));
            OrderDetail orderDetail;
            orderDetail = new OrderDetail((Integer) row.get("order_detail_id"),
                    order,
                    book,
                    (Integer) row.get("amount"));
            list.add(orderDetail);
        }

        return list;
    }
}
