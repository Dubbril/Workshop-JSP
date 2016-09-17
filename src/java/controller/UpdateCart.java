package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ShoppingCart;

public class UpdateCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] removes = request.getParameterValues("remove");
        String[] amounts = request.getParameterValues("amount");
        String[] ids = request.getParameterValues("id");
        if (removes == null) {
            removes = new String[0];
        }
        Map<Integer, String> errors = new HashMap<Integer, String>();

        for (int i = 0; i < ids.length; i++) {
            if (!Utility.isNumber(amounts[i])) {
                errors.put(Integer.parseInt(ids[i]), "เลขจำนวนเต็ม");
            }
        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("shopping_cart.jsp");
            rd.forward(request, response);
            return;
        }
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);
            int amount = Integer.parseInt(amounts[i]);
            cart.update(id, amount);
        }
        for (int i = 0; i < removes.length; i++) {
            int id = Integer.parseInt(removes[i]);
            cart.remove(id);
        }
        response.sendRedirect("ShowCart");

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
