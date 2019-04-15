<%-- 
    Document   : login
    Created on : 10-apr-2019, 15.02.00
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <c:import url="include/imports.jsp"></c:import>     
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Loggati</title>
</head>
<body>
    <form class="pure-form" action="http://localhost:8080/nostalciac/resources/auth" method="POST">
        <fieldset>
            <legend>Esegui il log prima di cominciare...</legend>

            <input type="user" placeholder="Utente" name="usr">
            <input type="password" placeholder="Password" name="pwd">

            <label for="remember">
                <input id="remember" type="checkbox"> Remember me
            </label>


            <button type="submit" class="pure-button pure-button-primary">Sign in</button>
            <br>
            <br>
            Se non sei ancora registrato: <a href="Anagrafica.jsp" id="b_reg" class="" >Registrati</a>

        </fieldset>
    </form>
</body>
</html>
