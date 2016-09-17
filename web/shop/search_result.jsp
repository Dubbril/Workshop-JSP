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
            <b>ผลการค้นหา</b>
            <c:forEach var="i"  begin="0" end="${pageCount-1}">
                <c:choose>
                    <c:when test="${i==pageNo}">
                        ${i+1}
                    </c:when>
                    <c:otherwise>
                        <a href="SearchResult?keyword=${keyword}&page_no=${i}">${i+1}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <br/>
            <br/>
            <table width="600">
                <c:forEach var="book" items="${result}">
                    <tr>
                        <td>
                            <a href="ShowBook?id=${book.id}">
                                <img src="../images/${book.id}.gif" border="0"/>
                            </a>
                        </td>
                        <td>${book.title}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
