<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h2>Welcome to Private Cabinet</h2>

    <div>You login as <c:out value="${client.getClientName()}" /> <c:out value="${client.getClientSurname()}" /> </div>
    <%--<table class="table table-striped">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Name</th>--%>
            <%--<th>Surname</th>--%>
            <%--<th>Phone number</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>

        <%--<tbody>--%>
            <%--<tr>--%>
                <%--<td><c:out value="${client.getClientName()}" /></td>--%>
                <%--<td><c:out value="${client.getClientSurname()}" /></td>--%>
                <%--<td><c:out value="${client.getPhoneNumber()}" /></td>--%>
            <%--</tr>--%>
        <%--</tbody>--%>
    <%--</table>--%>
</div>

