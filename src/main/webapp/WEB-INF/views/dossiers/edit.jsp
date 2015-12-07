<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:layout>
    <jsp:body>
      <form:form method="POST" modelAttribute="dossier" class="form-horizontal">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="form-group">
          <label for="nom" class="col-sm-2 control-label">Nom</label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="nom" path="nom" placeholder="Nom" />
          </div>
        </div>


        <div class="form-group">
          <label for="prenom" class="col-sm-2 control-label">Prenom</label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="prenom" path="prenom" placeholder="Prenom" />
          </div>
        </div>

        <div class="form-group">
          <label for="noPlaque" class="col-sm-2 control-label"># Plaque</label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="noPlaque" path="noPlaque" placeholder="# Plaque" />
          </div>
        </div>

        <div class="form-group">
          <label for="noPermis" class="col-sm-2 control-label"># Permis</label>
          <div class="col-sm-10">
            <form:input type="text" class="form-control" id="noPermis" path="noPermis" placeholder="# Permis" />
          </div>
        </div>

        <div class="form-group">
          <label for="infractions" class="col-sm-2 control-label">Infractions</label>
          <div class="col-sm-10">
            <c:choose>
              <c:when test="${dossier.infractionDossiers.size() > 0}">
                <ul class="list-group">
                  <table class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Description</th>
                        <sec:authorize access="hasAuthority('utilisateur')">
                          <th>Actions</th>
                        </sec:authorize>
                      </tr>
                    </thead>
                  <c:forEach items="${dossier.infractionDossiers}" var="infractionDossier">
                    <tr>
                      <td>
                        ${infractionDossier.infraction.description}
                        <span class="badge pull-right">${infractionDossier.infraction.gravite}</span>
                      </td>
                      <sec:authorize access="hasAuthority('utilisateur')">
                        <td>
                          <a href="/dossiers/${dossier.id}/infractions/${infractionDossier.id}/delete" class="btn btn-danger">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Supprimer
                          </a>
                        </td>
                      </sec:authorize>
                    </tr>
                  </c:forEach>
                  </table>
                </ul>
              </c:when>
              <c:otherwise>
                Aucune infractions attribués à ce dossier.
              </c:otherwise>
            </c:choose>
            <sec:authorize access="hasAuthority('utilisateur')">
              <a href="/dossiers/${dossier.id}/infractions" class="btn btn-primary">Ajouter des infractions à ce dossier</a>
            </sec:authorize>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <sec:authorize access="hasAuthority('administrateur')">
              <button type="submit" class="btn btn-primary" name="btnSave">Sauvegarder</button>
              <a href="/dossiers/${dossier.id}/delete" class="btn btn-danger">Supprimer</a>
            </sec:authorize>
            <a href="/dossiers" class="btn btn-warning">Annuler</a>
          </div>
        </div>

      </form:form>
    </jsp:body>
</t:layout>
