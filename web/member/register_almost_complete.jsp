<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${initParam.showname} - ลงทะเบียนเกือบสำเร็จ</title>
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
            <b>ลงทะเบียนเกือบจะสำเร็จแล้ว</b><br/><br/>
            เราได้ส่งเมลที่มีลิงค์การเปิดใช้บริการไปที่<b>${param.email}</b>แล้ว<br/>
            ขอให้คุณ<b>${param.name}</b> ตรวจสอบเมลและคลิ๊กที่ลิงค์ดังกล่าวเพื่อยืนยันการลงทะเบียนด้วยครับ
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
