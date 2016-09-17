package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BookTable;
import model.Database;
import model.Item;
import model.Member;
import model.Order;
import model.OrderDetail;
import model.OrderDetailTable;
import model.OrderTable;
import model.ShoppingCart;
import model.Book;

public class ConfirmOrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String shippingAddress = (String) request.getParameter("address");
        boolean isOutOfStock = false;
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Member member = (Member) session.getAttribute("member");

        Database db = new Database();
        db.beginTransaction();
        OrderTable orderTable = new OrderTable(db);
        Order order = new Order(member, new Date(), shippingAddress);
        orderTable.add(order);
        OrderDetailTable orderDetailTable = new OrderDetailTable(db);
        BookTable bookTable = new BookTable(db);
        Collection<Item> col = cart.getItems();

        for (Item item : col) {
            OrderDetail orderDetail = new OrderDetail(order, item, item.getAmount());
            orderDetailTable.add(orderDetail);
            Book book = bookTable.findById(item.getId());
            item.setStock(book.getStock());
            if (book.getStock() < item.getAmount()) {
                isOutOfStock = true;
                break;
            }
            book.setStock(book.getStock() - item.getAmount());
            bookTable.update(book);
        }
        if (!isOutOfStock) {
            db.commit();
        } else {
            db.rollback();
        }
        db.close();
        if (!isOutOfStock) {
            String from = "no-replay@wannik.com";
            String to = member.getEmail();
            String subject = "ยืนยันการสั่ซื้อ";
            String body = "คุณได้สั่งซื้อหนังสือกับเรา";
            Utility.sendMail(from, to, subject, body);
        }
        if (!isOutOfStock) {
            session.removeAttribute("cart");
        }
        if (!isOutOfStock) {
            response.sendRedirect("thank_you.jsp");
        } else {
            response.sendRedirect("ShowCart");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
