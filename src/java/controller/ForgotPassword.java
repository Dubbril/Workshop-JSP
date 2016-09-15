package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Database;
import model.Member;
import model.MemberTable;

public class ForgotPassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        Database db = new Database();
        MemberTable memberTable = new MemberTable(db);
        Member member = memberTable.findByUsername(username);
        if (member != null) {
            String from = "no-reply@wannik.com";
            String to = member.getEmail();
            String subject = "ลืมรหัสผ่าน";
            String body = "คุณได้แจ้งว่าลืมรหัสผ่านกับเรา<br/>"
                    + "โปรดยืนยันการเปลี่ยนแปลงรหัสผ่านใหม่โดยคลิ๊ก"
                    + "<b><a href='http://localhost:8080/member/RandomPassword"
                    + "?id=" + member.getId()
                    + "&activate_code=" + member.getActivatedCode()
                    + "'>ที่นี่</a></b>";
            Utility.sendMail(from, to, subject, body);
            if (member != null) {
                RequestDispatcher rd = request.getRequestDispatcher("forgot_password_almost_complete.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("usernameIncorrect", "ไม่พบชื่อผู้ใช้");
                RequestDispatcher rd = request.getRequestDispatcher("forgot_password.jsp");
                rd.forward(request, response);
            }
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
