<%-- 
    Document   : show_all_orders
    Created on : Sep 10, 2016, 11:48:57 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>รายการจัดซื้อ</title>
    </head>
    <body>
        <b>รายการสั่งซื้อ</b><br/>
        <a href="index.jsp">กลับไป</a>
        <table border="1" width="760">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>ชื่อบัญชีผู้ใช้</th>
                    <th>วันที่-เวลา</th>
                    <th>สถานที่จัดส่ง</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${result}" var="order">
                    <tr>
                        <td align="center">
                            <a href="ShowOrderDetail?id=${order.id}">${order.id}</a>
                        </td>
                        <td>${order.member.username}</td>
                        <td>${order.date}</td>
                        <td>${order.shippingAddress}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
