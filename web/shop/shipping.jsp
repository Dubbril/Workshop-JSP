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
            <b>สถานที่จัดส่ง</b><br/><br/>
            <form action="ConfirmOrder" method="POST">
                ที่อยู่<br/>
                <textarea name="address" rows="4" cols="30"></textarea><br/>
                <input type="submit" value="ยืนยันการสั่งซื้อ"/>
            </form>
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
