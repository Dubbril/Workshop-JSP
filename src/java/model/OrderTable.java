package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderTable {

    private Database db;

    public OrderTable(Database db) {
        this.db = db;
    }

    public void add(Order order) {
        String sql = "insert into `order` "
                + " (member_id,date,shipping_address) "
                + " values(?,?,?)";
        int id = db.add(sql, order.getMember().getId(), order.getDate(), order.getShippingAddress());
        order.setId(id);
    }

    public List<Order> findAll() {
        List<Order> list = new ArrayList<Order>();
        String sql = "select *,`order`.id  as 'order-id' from `order` "
                + " inner join member "
                + " on `order`.member_id = member.id "
                + " order by date desc";

        List<Map<String, Object>> result = db.querryList(sql);
        for (Map<String, Object> row : result) {
            Member m;
            m = new Member((Integer) row.get("member_id"),
                    (String) row.get("username"),
                    (String) row.get("password"),
                    (String) row.get("name"),
                    (String) row.get("address"),
                    (String) row.get("email"),
                    (Boolean) row.get("activated"),
                    (String) row.get("activate_code"),
                    (Date) row.get("register_date"));
            Order order;
            order = new Order((Integer) row.get("id"),
                    m,
                    (Date) row.get("date"),
                    (String) row.get("shipping_address"));
            list.add(order);
        }
        return list;

    }
}
