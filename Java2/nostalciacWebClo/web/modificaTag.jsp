<%-- 
    Document   : modificaTag
    Created on : 25-mar-2019, 11.11.31
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="include/imports.jsp"></c:import>        

        </head>
        <body>
            <header>

            <c:import url="include/menu.jsp"></c:import>
            </header>        

            <div id="contenitore"></div>
            <br><br>
            <form>

                <select id="sel_tags">
                    <option value="-1">Scegli il Tag</option>
                </select>

                <label for="tipo">Tipo: </label>
                <input type="text" id="tipo">
                <label for="tag">Tag: </label>
                <input type="text" id="tag">
                <input type="button" id="b_modTag" value="Conferma modifica">

                <br>

            </form>
            <footer>
            <c:import url="include/footer.jsp"></c:import>

        </footer>
        <script src="modificaTag.js" type="text/javascript"></script>
        <script src="libreria.js" type="text/javascript"></script>
    </body>
</html>