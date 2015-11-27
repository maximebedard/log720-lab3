<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:layout>
    <jsp:body>
        <form class="form-signin" method="post" action="${loginUrl}">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
            <h2 class="form-signin-heading">Veuillez vous authentifier</h2>

            <label for="j_username" class="sr-only">Email address</label>
            <input type="text" id="j_username" name="j_username" class="form-control" placeholder="Email address" required="" autofocus="">

            <label for="j_password" class="sr-only">Password</label>
            <input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" required="">

            <button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>

            <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
            <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
        </form>
    </jsp:body>
</t:layout>