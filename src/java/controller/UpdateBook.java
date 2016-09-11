/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import model.Book;
import model.BookTable;
import model.Database;

/**
 *
 * @author Administrator
 */
public class UpdateBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            MultipartFormDataRequest mrequest;
            mrequest = new MultipartFormDataRequest(request);
            int id = Integer.parseInt(mrequest.getParameter("id"));
            String title = Utility.convetThai(mrequest.getParameter("title"));
            String authors = Utility.convetThai(mrequest.getParameter("authors"));
            int price = Integer.parseInt(mrequest.getParameter("price"));
            int stock = Integer.parseInt(mrequest.getParameter("stock"));
            UploadFile pic = (UploadFile) mrequest.getFiles().get("picture");
            if (pic.getFileSize() != 1) {
                String error = "";
                if (pic.getFileSize() > 50 * 1024) {
                    error = "ขนาดไฟล์รูปภาพต้องไม่เกิน 50 กิโลไบต์";
                } else if (!pic.getContentType().equals("image/gif")) {
                    error = "ไฟล์รูปภาพต้องเป็นไฟล์ gif";
                }
                if (error.length() > 0) {
                    Book book = new Book(id, title, authors, price, stock);
                    request.setAttribute("invalidPicture", error);
                    request.setAttribute("book", book);
                    RequestDispatcher rd = request.getRequestDispatcher("edit_book.jsp");
                    rd.forward(request, response);
                    return;
                }
            }
            Database db = new Database();
            BookTable bookTable = new BookTable((db));
            Book book = new Book(id, title, authors, price, stock);
            bookTable.update(book);
            db.close();

            if (pic.getFileSize() != -1) {
                UploadBean upBean = new UploadBean();
                pic.setFileName(book.getId() + ".gif");
                upBean.setFolderstore(getServletContext().getRealPath("/images"));
                upBean.setOverwrite(true);
                upBean.store(mrequest);
            }
            response.sendRedirect("ShowAllBooks");
        } catch (UploadException ex) {
            throw new RuntimeException(ex.getMessage());
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
