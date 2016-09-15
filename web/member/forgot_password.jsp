<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.shopname} - ลืมรหัสผ่าน</title>
        <link rel="stylesheet" href="../css/view.css" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <%@include file="../templates/header.jsp" %>
        </div>
        <div id="nav">
            <%@include file="../templates/navigation.jsp" %>
        </div>
        <div id="content">
            <b>ลืมรหัสผ่าน</b><br/><br/>
            เราจะส่งลิ้งค์ที่สร้างรหัสผ่านใหม่ให้กับท่าน<br/><br/>
            <form action="ForgotPassword" method="post">
                <table width="400" >
                    <tbody>
                        <tr>
                            <td>ชื่อผู้ใช้</td>
                            <td>
                                <input type="text" name="username" value="${param.username}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="ขอรหัสผ่านใหม่" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <c:if test="${not empty usernameIncorrect}">
                <font color="FF0000" >${usernameIncorrect}</font>
            </c:if>             
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
