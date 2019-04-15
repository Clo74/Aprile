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
        <c:import url="include/imports.jsp"></c:import>       

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="shortcut icon" href="">
            <title>modifica SEDI</title>
        </head>
        <body>
            <header>

            <c:import url="include/menu.jsp"></c:import>
            </header>
            <div id="contenitore"></div>
            <br>
            <div class="navigazione" id="navigazione">
                <button class="p_navig" id="primo">&Ll;</button>
                <button class="p_navig" id="prec">&DoubleLongLeftArrow;</button>
                <button class="p_navig" id="succ">&DoubleLongRightArrow;</button>
                <button class="p_navig" id="ultimo">&Gg;</button>
            </div>
            <br>
            <div>

                <select id="sel_sedi">
                    <option value="-1">Scegli la Sede</option>
                </select>            
            </div>
            <br>
            <br>
            <form class="corpo pure-form pure-form-aligned">
    <fieldset>                
                <div class="pure-control-group">
                    <label for="nome">Nome sede: </label>
                    <input type="text" id="nome"><br/>

                </div>
                <div class="pure-control-group">
                    <label for="indirizzo">Indirizzo: </label>
                    <input type="text" id="indirizzo"><br/>
                </div>
                <div class="pure-control-group">

                    <label for="tel">Tel: </label>
                    <input type="text" id="tel"><br/>
                </div>
                <div class="pure-control-group">
                    <label for="citta">Città: </label>
                    <input type="text" id="citta" ><br/>
                </div>
                <div class="pure-control-group">
                    <label for="mail">Mail: </label>
                    <input type="text" id="mail" ><br/>
                </div>
                <div class="pure-control-group">
                    <label for="note">Note: </label>
                    <input type="text" id="note"><br/>
                </div>

                <input type="hidden" id="id_rec">

                <input type="button" id="b_modSede" value="Conferma modifica">
                <input type="button" id="b_insSede" value="Inserisci una nuova sede">                
                <br>
    </fieldset>
            </form>
            <footer>
            <c:import url="include/footer.jsp"></c:import>

        </footer>        
        <script src="modificaSede.js" type="text/javascript"></script>
        <script src="libreria.js" type="text/javascript"></script>
    </body>
</html>