<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h2>Welcome to Private Cabinet</h2>

    <div class="infoSignInUser">You login as <c:out value="${client.getClientName()}"/> <c:out
            value="${client.getClientSurname()}"/></div>

    <table style="margin-top: 30px" class="table">

        <thead>
        <tr>
            <th>Available countries:</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="country" items="${visaCountryList}">
            <tr>
                <td>
                    <option value="${country.getCountryName()}">
                            ${country.getCountryName()}
                    </option>
                </td>
                <td><a href="/deleteVisa?idClient=<c:out value='${country.getIdCountry()}'/>"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <a href="${base}/visa" class="btn btn-primary">Add new Visa</a>

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

