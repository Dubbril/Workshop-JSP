<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <b>ตะกร้าสินค้า</b>
            <form action="UpdateCart" method="POST">
                <table border="1" width="600">
                    <tr>
                        <th width="40" >ลบ</th>
                        <th width="80">ลำดับที่</th>
                        <th>ชือหนังสือ</th>
                        <th width="80" >ราคา</th>
                        <th width="80">จำนวน</th>
                        <th width="80">ราคารวม</th>
                    </tr>
                    <c:forEach var="item" items="${cart.items}" varStatus="status">
                        <tr>
                            <%-- ลบ --%>
                            <td align="center" >
                                <input type="checkbox" name="remove" value="${item.id}"
                                       <c:forEach var="id" items="${paramValues.remove}">
                                           <c:if test="${id==item.id}">
                                               checked="checked"
                                           </c:if>
                                       </c:forEach> 
                                       />
                            </td>
                            <%-- ลำดับที่ --%>
                            <td align="center" >
                                ${status.index+1}
                            </td>
                            <%-- ชื่อหนังสือ --%>
                            <td>
                                ${item.title}
                            </td>
                            <%-- ราคา --%>
                            <td align="right">
                                <fmt:formatNumber value="${item.price}" pattern="#,###.00"/>
                            </td>
                            <%-- จำนวน --%>
                            <td align="center" >
                                <input type="text" 
                                       name="amount" 
                                       size="2" 
                                       style="text-align: right" 
                                       <c:choose>
                                           <c:when test="${not empty paramValues.amount}">
                                               value="${paramValues.amount[status.index]}"
                                       </c:when>
                                       <c:otherwise>
                                           value="${item.amount}"
                                       </c:otherwise>
                                </c:choose>
                                />
                                <input type="hidden" name="id" value="${item.id}" />
                                <c:choose>
                                    <c:when test="${not empty errors[item.id]}">
                                        <br/><font color="#FF0000" >${errors[item.id]}</font>
                                    </c:when>
                                    <c:when test="${item.stock < item.amount}">
                                        <br/><font color="#FF0000" >ไม่พอ</font>
                                    </c:when>
                                </c:choose>
                            </td>
                            <%-- ราคารวม --%>
                            <td align="right" >
                                <fmt:formatNumber value="${item.price * item.amount}" pattern="#,###.00"/>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" align="right" > 
                            ราคารวมทั้งหมด
                        </td>
                        <td align="right" >
                            <fmt:formatNumber value="${cart.totalPrice}" pattern="#,###.00"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" colspan="6" > 
                            <input type="button" value="กลับไปที่ผลการค้นหา" 
                                   onclick="window.location = 'SearchResult?keyword=${keyword}&page_no=${pageNo}';"/>
                            <input type="submit" value="อัพเดทตะกร้า" />
                            <input type="button" value="ดำเนินการสั่งซื้อ" onclick="window.location = 'Shipping';"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="footer">
            <%@include file="../templates/footer.jsp" %>
        </div>
    </body>
</html>
