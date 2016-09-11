<%-- 
    Document   : show_order_detail
    Created on : Sep 11, 2016, 11:32:58 PM
    Author     : DUBBRIL
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>รายละเอียดการสั่งหนังสือ</title>
    </head>
    <body>
        <b>รายละเอียดการสั่งซื้อของคุณ ${result[0].order.member.username} ในวันที่ ${result[0].order.date}</b><br/><br/>
        <a href="ShowAllOrders">กลับไป</a><br/><br/>
        <table border="1" width="760">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>ซื้อ</th>
                    <th>ราคา</th>
                    <th>จำนวน</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${result}" var="orderDetail">
                    <tr>
                        <td align="center">
                            ${orderDetail.id}
                        </td>
                        <td>
                            ${orderDetail.book.title}
                        </td>
                        <td align="right">
                            <fmt:formatNumber value="${orderDetail.book.price}" pattern="#,###.00"/>
                        </td>
                        <td align="right">
                            ${orderDetail.amount}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
