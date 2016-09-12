<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table width="100%">
    <tr>
        <td rowspan="2">
            <h1 style="float: left"; width:16em >${initParam.shopname}</h1>
        </td>
        <td align="right">
            <c:choose>
                <c:when test="${empty number}">
                    <a href="../number/login.jsp">ลงชื่อเข้าใช้</a>
                    <a href="../number/register.jsp">สมัครสมาชิก</a>
                    <a href="../number/forgot_password.jsp">ลืมรหัสผ่าน</a>
                </c:when>
                <c:otherwise>
                    คุณ ${Number.name}
                    <a href="../number/change_password.jsp">เปลี่ยนรหัสผ่าน</a>
                    <a href="../number/Logout">ลงชื่อออก</a>
                </c:otherwise>
            </c:choose>      
        </td>
    </tr>
    <tr>
        <td align="right">
            <form action="../shop/SearchResult">
                <input type="text" name="keyword" value="${keyword}"/>
                <input type="submit" value="ค้นหาหนังสือ" />
                <input type="button" value="ตะกร้าสินค้า" onclick="window.location = '..shop/ShowCart'" />
            </form>
        </td>
    </tr>
</table>
<hr/>
