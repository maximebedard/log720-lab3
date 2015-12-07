<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:layout>
    <jsp:body>
        <form action="/dossiers/${dossier.id}/infractions" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <c:forEach items="${allInfractions}" var="infraction">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="infractions[]" id="infractions" value="${infraction.id}" /> ${infraction.description} (${infraction.gravite})
                    </label>
                </div>
            </c:forEach>
            <button type="submit">Ajouter les infractions sélectionnés.</button>
        </form>
    </jsp:body>
</t:layout>