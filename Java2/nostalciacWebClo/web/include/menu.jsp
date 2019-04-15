<nav class="main-nav">
    <%--    <ul class="main-menu">
            <li class="menu-item"><a class="menu-link"href="${pageContext.request.contextPath}">HOME</a></li>
            <li class="menu-item"><a class="menu-link"href="${pageContext.request.contextPath}/modificaTag.jsp">Modifica TAG</a></li>
            <li class="menu-item"><a class="menu-link"href="${pageContext.request.contextPath}/modificaSede.jsp">Modifica Sede</a></li>
        </ul>
    --%>    
    <div class="pure-menu pure-menu-horizontal">
        <ul class="pure-menu-list">
            <li class="pure-menu-item pure-menu-selected"><a href="${pageContext.request.contextPath}" class="pure-menu-link">Home</a></li>
            <li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
                <a href="#" id="menuLink1" class="pure-menu-link">Amministratore</a>
                <ul class="pure-menu-children">
                    <li class="pure-menu-item"><a href="${pageContext.request.contextPath}/modificaTag.jsp" class="pure-menu-link">Tags</a></li>
                    <li class="pure-menu-item"><a href="${pageContext.request.contextPath}/modificaSede.jsp" class="pure-menu-link">Sedi</a></li>
                </ul>
            </li>
            <li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
                <a href="#" id="menuLink1" class="pure-menu-link">Studenti</a>
                <ul class="pure-menu-children">
                    <li class="pure-menu-item"><a href="${pageContext.request.contextPath}/corsiAnagrafica.jsp" class="pure-menu-link">Corsi frequentati</a></li>
                    <li class="pure-menu-item"><a href="#" class="pure-menu-link">Esperienze</a></li>
                </ul>
            </li>
            <li class="pure-menu-item pure-menu-selected"><a href="${pageContext.request.contextPath}/login.jsp" class="pure-menu-link">Login</a></li>
        </ul>
    </div>
    <hr>
</nav>
        <input type="hidden" id="utConnesso">