<%-- 
    Document   : customerSearch
    Created on : 15-mar-2019, 14.59.31
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerca clienti con JSP</title>
    </head>
    <body>
        <h1>Cerca clienti con JSP</h1>
        <form method="POST">
            <label for="search">Cerca: </label>

            <input type="text" name="search" value="${param.search}"/>
            <input type="submit" name="invia" value="Invia">
        </form>
        <br>
        <hr/>
        <c:if test="${not empty param.invia}">

            <c:set var="customers" value="${db.searchCustormer(param.search)}"></c:set>
            <c:choose>
                <c:when test="${not empty customers}">
                    <table>
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${customers}" var="cust">
                                <tr>
                                    <td>${cust.id}</td>
                                    <td>${cust.name}</td>
                                </tr>
                            </c:forEach>

                        </tbody>

                    </table>
                </c:when>
                <c:otherwise>
                    <h3>Nessun cliente trovato</h3>
                </c:otherwise>
            </c:choose>
        </c:if>
    </body>
</html>
