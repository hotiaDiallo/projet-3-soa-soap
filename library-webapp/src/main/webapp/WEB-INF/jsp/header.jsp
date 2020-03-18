
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link href="<c:url value='/css/main.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
<nav id="navbar">
    <div class="container">
      <ul>
        <li><a class="current" href="/">Home</a></li>
        <li><a href="${contextPath}/loan/my-loans">Prets</a></li>
        <li><a href="${contextPath}/ouvrages/all">Livres</a></li>
        <li><a href="${contextPath}/ouvrages/rechercher">Rechercher</a></li>
        <li><a href="${contextPath}/user/login">Connexion</a></li>
        <li><a href="${contextPath}/user/deconnexion">Deconnexion</a></li>
      </ul>
    </div>
</nav>