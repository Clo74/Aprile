<%-- 
    Document   : corsiAnagrafica
    Created on : 11-apr-2019, 9.41.02
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="include/imports.jsp"></c:import> 
            <title>Corsi frequentati</title>
        </head>
        <body>
            <header>
            <c:import url="include/menu.jsp"></c:import>
        </header>          
        <form class="corpo pure-form pure-form-aligned">
            <div id="testata" class="">
                <div class="pure-control-group">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" readonly="readonly" >
                </div>

                <div class="pure-control-group">
                    <label for="cognome">Cognome:</label>
                    <input type="text" id="cognome" name="cognome" readonly="readonly" >
                </div>            
                <div id="contenitore">
                    <select multiple>
                        <option value="volvo">Volvo</option>
                        <option value="saab">Saab</option>
                        <option value="opel">Opel</option>
                        <option value="audi">Audi</option>
                    </select>

                </div> 
            </div>
        </form>
    </body>
</html>
