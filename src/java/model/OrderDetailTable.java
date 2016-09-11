package model;

public class OrderDetailTable {
    private Database db;
    public OrderDetailTable(Database db){
        this.db = db;
    }
    public void add(OrderDetail orderDetail){
        String sql = "insert into order_detail "
                + " (order_id,book_id,amount) "
                + " values(?,?,?)";
        int id = db.add(sql, orderDetail.getOrder(),
                orderDetail.getBook(),
                orderDetail.getAmount());
        orderDetail.setId(id);
    }
    //public List<OrderDetail>findByOrderId(int)
}
