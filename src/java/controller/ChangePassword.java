package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Database;
import model.Member;
import model.MemberTable;

public class ChangePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String oldPassword = request.getParameter("old");
        String newPassword = request.getParameter("new");
        String confirmPassword = request.getParameter("confirm");

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("confirmIncorrect", "รหัสผ่านไม่ตรงกัน");
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("change_password.jsp");
            rd.forward(request, response);
            return;
        }
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        boolean oldMatch = (member.getPassword().endsWith(oldPassword));
        if (oldMatch) {
            Database db = new Database();
            MemberTable memberTable = new MemberTable(db);
            member.setPassword(newPassword);
            memberTable.update(member);
            db.close();
        }
        if (oldMatch) {
            response.sendRedirect("change_password_complete.jsp");
        } else {
            request.setAttribute("oldIncorrect", "รหัสสมาชิก");
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("chage_password.jsp");
            rd.forward(request, response);
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
