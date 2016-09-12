<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${initParam.shopname} - ลงทะเบียนผู้เข้าใช้</title>
        <link rel="stylesheet" href="../css/view.css" type="text/css"/>
    </head>
    <body>
        <div id="header">
            <%@include file="/templates/header.jsp" %>
        </div>
        <div id="nav">
            <%@include file="/templates/navigation.jsp" %>
        </div>
        <div id="content" >
            <b>ลงทะเบียนผู้เข้าใช้</b>
            <form action="Register" method="POST">
                <table width="400">
                    <tbody>
                        <tr>
                            <td>ชื่อผู้ใช้</td>
                            <td>
                                <input type="text" name="username" value="${param.username}"/>
                                <c:if test="${not empty errors.username}">
                                    <br/>
                                    <font color="#ff0000">${errors.username}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>รหัสผ่าน</td>
                            <td>
                                <input type="password" name="password" value="${param.password}"/>
                                <c:if test="not empty errors.password">
                                    <br/>
                                    <font color="#ff0000">${param.password}</font>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>ชื่อ-นามสกุล</td>
                            <td>
                                <input type="text" name="name" value="${param.name}"/>
                                <c:if test="${not empty errors.name}">
                                    <br/>
                                    <font color="#ff0000">${param.name}</font>     
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>ที่อยู่</td>
                            <td>
                                <textarea name="address" rows="4" cols="20">${param.address}</textarea>
                                <c:if test="${not empty errors.address}">
                                    <br/>
                                    <font color="#ff0000">${param.address}</font>     
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>อีเมล</td>
                            <td>
                                <input type="text" name="email" value="${param.email}"/>
                                <c:if test="${not empty errors.email}">
                                    <br/>
                                    <font color="#ff0000">${param.email}</font>     
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="ลงทะเบียน"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div id="footer">
            <%@include file="/templates/footer.jsp" %>
        </div>
    </body>
</html>
