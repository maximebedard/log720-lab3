<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:layout>
    <jsp:body>
        <h1>Accès refusé</h1>
        <a href="/auth/login">Me connecter avec un autre compte...</a>
    </jsp:body>
</t:layout>