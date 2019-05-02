<nav class="main-nav">
 
    <div class="pure-menu pure-menu-horizontal">
        <ul class="pure-menu-list">
            <li class="pure-menu-item pure-menu-selected"><a href="${pageContext.request.contextPath}" class="pure-menu-link">Home</a></li>
            <li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
                <a href="#" id="menuLink1" class="pure-menu-link">Amministratore</a>
                <ul class="pure-menu-children">
                    <li class="pure-menu-item"><a href="${pageContext.request.contextPath}/anagNegozi.jsp" class="pure-menu-link">Negozi</a></li>
                    <li class="pure-menu-item"><a href="${pageContext.request.contextPath}/prodotti.jsp" class="pure-menu-link">Prodotti</a></li>
                </ul>
            </li>
            <li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
                <a href="#" id="menuLink1" class="pure-menu-link">Gestione</a>
                <ul class="pure-menu-children">
                    <li class="pure-menu-item"><a href="#" class="pure-menu-link">Prodotti</a></li>
                    <li class="pure-menu-item"><a href="#" class="pure-menu-link">Esperienze</a></li>
                </ul>
            </li>
            <li class="pure-menu-item pure-menu-selected"><a href="${pageContext.request.contextPath}/login.jsp" class="pure-menu-link">Login</a></li>
        </ul>
    </div>
    <hr>
</nav>
