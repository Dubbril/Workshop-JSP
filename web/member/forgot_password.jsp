<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.shopname} - ลืมรหัสผ่าน</title>
    </head>
    <body>
        <div id="content">
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
    </body>
</html>
