<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : show_all_books
    Created on : Sep 5, 2016, 4:20:06 PM
    Author     : DUBBRIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ร้านหนังสือ สมปอง</title>
    </head>
    <body>
        <b>หลังร้าน</b><br/><br/>
        <a href="ShowAllBooks">หนังสือ</a><br/>
        <a href="add_book.jsp">เพิ่มหนังสือใหม่</a><br/><br/>
        <table border="1" width="760">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>รูปภาพ</th>
                    <th>ชื่อ</th>
                    <th>ผู้แต่ง</th>
                    <th>ราคา</th>
                    <th>จำนวน</th>
                    <th>แก้ไข</th>
                    <th>ลบ</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${result}">
                    <tr>
                        <td align="center">
                            ${book.id}
                        </td>
                        <td>
                            <img src="./images/${book.id}.gif?time=${time}" width="100" />
                        </td>
                        <td>
                            ${book.title}
                        </td>
                        <td>
                            ${book.authors}
                        </td>
                        <td align="right">
                            <fmt:formatNumber value="${book.price}" pattern="#,###.00" />
                        </td>
                        <td align="right">
                            ${book.stock}
                        </td>
                        <td align="center">
                            <a href="GetBookDetail?id=${book.id}">แก้ไข</a>
                        </td>
                        <td align="center">
                            <a href="DeleteBook?id=${book.id}">ลบ</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
