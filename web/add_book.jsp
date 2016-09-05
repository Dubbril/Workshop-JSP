<%-- 
    Document   : add_book
    Created on : Sep 6, 2016, 12:09:12 AM
    Author     : DUBBRIL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ร้านหนังสือ สมปอง</title>
    </head>
    <body>
        <form action="AddBook" method="POST" enctype="multipart/form-data">
            <table width="400">
                <tbody>
                    <tr>
                        <td>ชื่อ</td>
                        <td><input type="text" name="title" value="${book.title}" /></td>
                    </tr>
                    <tr>
                        <td>ผู้แต่ง</td>
                        <td><input type="text" name="authors" value="${book.authors}" /></td>
                    </tr>
                    <tr>
                        <td>ราคา</td>
                        <td><input type="text" name="price" value="${book.price}" /></td>
                    </tr>
                    <tr>
                        <td>จำนวน</td>
                        <td><input type="text" name="stock" value="${book.stock}"/></td>
                    </tr>
                    <tr>
                        <td>รูปภาพ</td>
                        <td><input type="file" name="picture"/>
                            <c:if test="${not empty invalidPicture}">
                                <br/>
                                <font color="#FF0000">${invalidPicture}</font>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="เพิ่ม"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
