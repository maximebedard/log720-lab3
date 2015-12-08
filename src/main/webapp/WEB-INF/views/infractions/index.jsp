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
              window.location = "/infractions/" + id + "/edit";
            })
          });
        </script>
      </jsp:attribute>
    <jsp:body>
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>ID</th>
              <th>Description</th>
              <th>Sévérité</th>
            </tr>
          </thead>
          <tbody>
              <c:forEach items="${infractions}" var="d">
                <tr>
                  <td>${d.id}</td>
                  <td>${d.description}</td>
                  <td>${d.gravite}</td>
                </tr>
              </c:forEach>
          </tbody>
        </table>
        <sec:authorize access="hasAuthority('administrateur')">
            <form:form method="POST" modelAttribute="infraction" class="form-inline">
                <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
                <div class="form-group">
                  <label class="sr-only" for="description">description</label>
                  <form:input class="form-control" id="description" path="description" placeholder="Description" />
                  <br /><form:errors path="description" cssClass="error" class="has-errors" />
                </div>
                <div class="form-group">
                  <label class="sr-only" for="gravite">Sévérité</label>
                  <form:input class="form-control" id="gravite" path="gravite" placeholder="Sévérité" />
                  <br /><form:errors path="gravite" cssClass="error" class="has-errors" />
                </div>
                <button type="submit" class="btn btn-default btn-primary" name="create">Ajouter</button>
            </form:form>
        </sec:authorize>
    </jsp:body>
</t:layout>