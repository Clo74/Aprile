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
             <form class="pure-form pure-form-aligned">
                <fieldset>      
                    <div  class="pure-control-group">
                        <span id="descNeg"></span><br>
                        <input type="date" id="dataScont">
                        <input type="button" id="btNew" value="Nuovo Scontrino">
                    </div>                    
                    <div  class="pure-control-group">
                        <label for="cmbProd">Seleziona il prodotto:</label>
                        <select id="cmbProd">
                        </select>
                    </div>
                    <div  class="pure-control-group">
                        <label for="przVendL">Prezzo di vendita:</label>
                        <input id="przVendL">
                    </div>
                    <div  class="pure-control-group">
                        <label for="qta">Quantità:</label>
                        <input id="qta">
                    </div>
                    <div  class="pure-control-group">
                        <input type="button" id="btConfProd" value="Conferma">
                    </div>
                </fieldset>
                <div id="contenitore">
                </div>
                <div class="pure-control-group">
                    <input type="button" value="Conferma scontrino" class="pure-button" id="btConfirm">
                    <input type="reset" value="Annulla scontrino" class="pure-button" >
                </div>                
            </form>
  
        <script src="js/scontrini.js" type="module"></script>
    </body>
</html>
