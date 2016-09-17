<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.showname}</title>
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
            <b>รายละเอียดหนังสือ</b>
            <table width="500">
                <tr>
                    <td rowspan="3"><img src="../images/${book.id}.gif" /> </td>
                </tr>
                <tr>
                    <td>${book.authors}</td>
                </tr>
                <tr>
                    <td>${book.price}</td>
                </tr>
            </table>
            <br/>
            <form method="POST">
                <input type="text" name="amount" value="1" size="2" style="text-align: right" />เล่ม
                <input type="hidden" name="id" value="${book.id}" />
                <input type="submit" value="ใส่ตะกร้า" />
            </form>
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
