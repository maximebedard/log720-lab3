<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:layout>
    <jsp:body>
      <form:form method="POST" modelAttribute="infraction" class="form-horizontal">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="form-group">
          <label for="nom" class="col-sm-2 control-label">Description</label>
          <div class="col-sm-7">
            <form:input type="text" class="form-control" id="description" path="description" placeholder="Description" />
          </div>
          <div class="col-sm-3">
            <form:errors path="description" cssClass="error" class="has-errors" />
          </div>
        </div>


        <div class="form-group">
          <label for="gravite" class="col-sm-2 control-label">Severité</label>
          <div class="col-sm-7">
            <form:input type="text" class="form-control" id="gravite" path="gravite" placeholder="Séverité" />
          </div>
          <div class="col-sm-3">
            <form:errors path="gravite" cssClass="error" class="has-errors" />
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <sec:authorize access="hasAuthority('administrateur')">
              <button type="submit" class="btn btn-primary" name="btnSave">Sauvegarder</button>
              <a href="/infractions/${infraction.id}/delete" class="btn btn-danger">Supprimer</a>
            </sec:authorize>
            <a href="/infractions" class="btn btn-warning">Annuler</a>
          </div>
        </div>
      </form:form>
    </jsp:body>
</t:layout>
