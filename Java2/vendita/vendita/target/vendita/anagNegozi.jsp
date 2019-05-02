<%-- 
    Document   : anagNegozi
    Created on : 6-apr-2019, 20.12.42
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="include/imports.jsp"/>

    </head>
    <body>

        <header>
            <c:import url="include/menu.jsp"/>
        </header>
        <article>
            <div id="contenitore">
            </div>
            </br>
            <form class="pure-form pure-form-aligned">
                <fieldset>      
                    <input type="hidden" id="idRec">
                    <div class="pure-control-group">
                        <label for="descNeg">Descrizione: </label>
                        <input id="descNeg" type="text"/>
                    </div>
                    <div class="pure-control-group">                    
                        <label for="address">Indirizzo: </label>
                        <input id="address" type="text"/>
                    </div>
                    <div class="pure-control-group">                    
                        <label for="mail">E-mail: </label>
                        <input id="mail" type="text"/>
                    </div>
                    <div class="pure-control-group">
                        <label for="tel">Telefono: </label>
                        <input id="tel" type="text"/>
                    </div>
                    <div id="dati" class="pure-control-group">
                        <input type="button" value="Conferma" class="pure-button" id="btConfirm">
                        <input type="reset" value="Inserisci nuovo" class="pure-button" >
                    </div>
                </fieldset>
            </form>
        </article>

        <script src="js/anagNegozi.js" type="module"></script>
    </body>
</html>
