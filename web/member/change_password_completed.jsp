<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.shopname} - ลืมรัหสผ่านสำเร็จ</title>
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
            <b>เปลี่ยนรหัสผ่านสำเร็จ</b><br/><br/>
            เราได้ทำการเปลี่ยนรหัสผ่านของผู้ใช้สำเร็จ ${member.username} เป็น ${member.password} แล้ว
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
