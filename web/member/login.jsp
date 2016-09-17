<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.showname} - ลงชื่อเข้าใช้</title>
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
            <b>ลงชื่อเข้าใช้</b>
            <form action="Login" method="POST">
                <table width="400">
                    <tbody>
                        <tr>
                            <td>ลงชื่อเข้าใช้</td>
                            <td><input type="text" name="username" value="${param.username}"/></td>
                        </tr>
                        <tr>
                            <td>รหัสผ่าน</td>
                            <td><input type="password" name="password" value="${param.password}"/> </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center" ><input type="submit" value="ลงชื่อเข้าใช้"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <c:if test="${not empty loginIncorrect}">
                <font color="#FF0000">${loginIncorrect}</font>
            </c:if>          
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
