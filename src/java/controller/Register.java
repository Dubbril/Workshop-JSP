package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Database;
import model.Member;
import model.MemberTable;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        Map<String, String> errors = new HashMap<String, String>();
        if (username.trim().length() == 0) {
            errors.put("username", "กรุณากรอกชื่อผู้ใช้");
        }
        if (password.trim().length() == 0) {
            errors.put("password", "กรุณากรอกรหัสผ่าน");
        }
        if (!password.equals(confirm)) {
            errors.put("confirm", "รหัสผ่านไม่ตรงกัน");
        }
        if (name.trim().length() == 0) {
            errors.put("name", "กรุณากรอกชื่อนามสกุล");
        }
        if (address.trim().length() == 0) {
            errors.put("address", "กรุณากรอกที่อยู่");
        }
//        if (!email.matches("\\s+@\\s+\\.\\s{2,3}")) {
//            errors.put("email", "กรุณากรอกอีเมลให้ถูกต้อง");
//        }
        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        }
        boolean activated = false;
        String activateCode = Utility.randomText(32);
        Date date = new Date();
        Member member = new Member(username, password, name, address, email, activated, activateCode, date);
        Database db = new Database();
        MemberTable memberTable = new MemberTable(db);
        if (memberTable.add(member)) {
            memberTable.deleteUnactivated();
        } else {
            errors.put("username", "ชื่อผู้ใช้ซ้ำ");
        }
        db.close();
        if (errors.size() == 0) {
            String from = "mail.dubbril.com";
            String to = member.getEmail();
            String subject = "ยืนยันการลงทะเบียน";
            String body = "คุณได้ลงทะเบียนกับเรา<br/>"
                    + "โปรดยืนยันการลงทะเบียนโดยคลิ๊ก"
                    + "<b><a href='"
                    + "http://localhost:8080"
                    + "BookShop/member/Active"
                    + "?id=" + member.getId()
                    + "&activate_code=" + member.getActivatedCode()
                    + "'>ที่นี่</a></b>";
            Utility.sendMail(from,to,subject,body);
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
