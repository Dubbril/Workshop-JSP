<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.shopname} - เปลี่ยนรหัสผ่าน</title>
    </head>
    <body>
        <div id="content">
            <b>เปลี่ยนรหัสผ่าน</b><br/><br/>
            <form action="ChangePassword" method="POST">
                <table width="400" >
                    <tbody>
                        <tr>
                            <td>รหัสผ่านเดิม</td>
                            <td>
                                <input type="password" name="old" value="${param.old}" />
                                <c:if test="${not empty oldIncorrect}">
                                    <br/><font color="#FF0000">${oldIncorrect}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>รหัสผ่านใหม่</td>
                            <td>
                                <input type="password" name="new" value="${param.new}" />
                            </td>
                        </tr>
                        <tr>
                            <td>ยืนยันรหัสผ่านใหม่</td>
                            <td>
                                <input type="password" name="confirm" value="${param.confirm}" />
                                <c:if test="${not empty confirmIncorrect}">
                                    <br/><font color="#FF0000">${confirmIncorrect}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center" >
                                <input type="submit" value="เปลี่ยนรหัสผ่าน"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
