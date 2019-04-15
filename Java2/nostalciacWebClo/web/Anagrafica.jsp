<%-- 
    Document   : form
    Created on : 1-apr-2019, 8.40.34
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="include/imports.jsp"></c:import>  
    <title>FORM</title>
</head>
<body>
    <header>

        <c:import url="include/menu.jsp"></c:import>
    </header>        
    <form class="corpo pure-form pure-form-aligned">
        <div class="pure-control-group">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="" placeholder="scrivi il nome">
        </div>

        <div class="pure-control-group">
            <label for="cognome">Cognome:</label>
            <input type="text" id="cognome" name="cognome" value="" placeholder="scrivi il cognome">
        </div>
        <div class="pure-control-group">
            <label for="indirizzo">Indirizzo:</label>
            <input type="text" id="indirizzo" 
                   name="indirizzo" value="" placeholder="scrivi il tuo indirizzo">
        </div>             
        <div class="pure-control-group">
            <label for="citta">Città:</label>
            <input type="text" id="citta" 
                   name="citta" value="" placeholder="scrivi la città"
                   list="elencoCitta">
        </div>             
        <datalist id="elencoCitta">
            <option value="Torino"/>
            <option value="Milano"/>
            <option value="Roma"/>
        </datalist>
        <div class="pure-control-group">
            <label for="mail">E-Mail:</label>
            <input type="text" id="mail" name="mail" value="" placeholder="scrivi la mail">
        </div>            
        <div class="pure-control-group">
            <label for="telefono">Telefono:</label>
            <input type="text" id="telefono" name="telefono" value="" placeholder="scrivi il telefono">
        </div>            

        <div class="pure-control-group">
            <label for="username">User Name:</label>
            <input type="text" id="username" name="username" value="" placeholder="scegli uno user name">
        </div>            
        <div class="pure-control-group">
            <label for="password">Scegli una password: </label>
            <input title="inserire almeno un numero e una lettera"
                   type="password" id="password" name="password" value="" placeholder="scegli una password">
        </div>
        <div class="pure-control-group">
            <label for="password2">Conferma la password: </label>
            <input type="password" id="password2" name="password2" value="" placeholder="conferma la password">
        </div>
        <div class="pure-control-group">
            <label for="privacy">Accetti policy: </label>
            <input type="checkbox" id="privacy" name="privacy" >
        </div>
        <div class="pure-control-group">
            <label for="dataNas">Data di nascita:</label>
            <input type="date" id="dataNas" name="dataNas" value="" placeholder="scrivi la tua data di nascita">
        </div> 
        <div class="pure-control-group">
            <label>Sesso: </label>
            <label for="sesso_M">M:</label>
            <input type="radio" name="sesso" id="sesso_M" value="Maschio">
            &nbsp;&nbsp;&nbsp;
            <label for="sesso_F">F:</label>
            <input type="radio" name="sesso" id="sesso_F" value="Femmina">
        </div>
        <div class="pure-control-group">
            <label for="note">Note:</label>
            <textarea name="note" id="note" placeholder="scrivi un commento.."></textarea>
        </div>

        <div class="pure-control-group">
            <input type="reset" value="Cancella i dati" id="pReset">
            <input type="button" value="Invia le modifiche" id="pSubmit">
        </div>

    </form>
    <script src="Anagrafica.js" type="text/javascript"></script>
    <script src="libreria.js" type="text/javascript"></script>
</body>
</html>
