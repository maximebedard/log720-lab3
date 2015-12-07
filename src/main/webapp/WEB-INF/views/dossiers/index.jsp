<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<t:layout>
      <jsp:attribute name="scripts">
        <script type="text/javascript">
          $(document).ready(function(){
            $('tbody tr').click(function(){
              id = $(this).find('td:first').html();
              window.location = "/dossiers/" + id + "/edit";
            })
          });
        </script>
      </jsp:attribute>
    <jsp:body>
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nom</th>
              <th>Prenom</th>
              <th>NoPermis</th>
              <th>NoPlaque</th>
            </tr>
          </thead>
          <tbody>
              <c:forEach items="${dossiers}" var="d">
                <tr>
                  <td>${d.id}</td>
                  <td>${d.nom}</td>
                  <td>${d.prenom}</td>
                  <td>${d.noPermis}</td>
                  <td>${d.noPlaque}</td>
                </tr>
              </c:forEach>
          </tbody>
        </table>

        <sec:authorize access="hasAuthority('administrateur')">
          <form:form method="POST" modelAttribute="dossier" class="form-inline">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group">
              <label class="sr-only" for="nom">Nom</label>
              <form:input class="form-control" id="nom" path="nom" placeholder="Nom" />
              <br /><form:errors path="nom" cssClass="error" class="has-errors" />
            </div>
            <div class="form-group">
              <label class="sr-only" for="prenom">Prenom</label>
              <form:input class="form-control" id="prenom" path="prenom" placeholder="Prenom" />
              <br /><form:errors path="prenom" cssClass="error" class="has-errors" />
            </div>
            <div class="form-group">
              <label class="sr-only" for="noPlaque"># Plaque</label>
              <form:input class="form-control" id="noPlaque" path="noPlaque" placeholder="# Plaque" />
              <br /><form:errors path="noPlaque" cssClass="error" class="has-errors" />
            </div>
            <div class="form-group">
              <label class="sr-only" for="noPermis"># Permis</label>
              <form:input class="form-control" id="noPermis" path="noPermis" placeholder="# Permis" />
              <br /><form:errors path="noPermis" cssClass="error" class="has-errors" />
            </div>
            <button type="submit" class="btn btn-default btn-primary" name="create">Ajouter</button>
          </form:form>
        </sec:authorize>
    </jsp:body>
</t:layout>