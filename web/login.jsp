<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.showName} - ลงชื่อเข้าใช้</title>
    </head>
    <body>
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
                            <td><input type="text" name="password" value="${param.password}"/> </td>
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
    </body>
</html>
