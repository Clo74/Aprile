<%-- 
    Document   : prodotti
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
                    <div  class="pure-control-group">
                        <label for="tipo">Tipo prodotto: </label>
                        <input id="tipo" type="text"/>
                    </div>                    
                    <div  class="pure-control-group">
                        <label for="desc">Descrizione: </label>
                        <input id="desc" type="text"/>
                    </div>
                    <div class="pure-control-group">                    
                        <label for="przAcq">Prezzo di acquisto: </label>
                        <input id="przAcq" type="number"/>
                    </div>
                    <div  class="pure-control-group">                    
                        <label for="przVendN">Prezzo di vendita netto: </label>
                        <input id="przVendN" type="number"/>
                    </div>
                    <div  class="pure-control-group">
                        <label for="iva">Iva: </label>
                        <input id="iva" type="number"/>
                    </div>
                    <div  class="pure-control-group">                    
                        <label for="przVendL">Prezzo di vendita lordo: </label>
                        <input id="przVendL" type="number"/>
                    </div>                    
                    <div  class="pure-control-group">                    
                        <label for="qta">Quantità: </label>
                        <input id="qta" type="number"/>
                    </div>   
                    <div class="pure-control-group">
                        <input type="button" value="Conferma" class="pure-button" id="btConfirm">
                        <input type="reset" value="Inserisci nuovo" class="pure-button" >
                    </div>
                </fieldset>
            </form>
        </article>

        <script src="js/prodotti.js" type="module"></script>
    </body>
</html>
