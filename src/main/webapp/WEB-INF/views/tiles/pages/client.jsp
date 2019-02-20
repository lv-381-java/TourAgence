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
                <td><a href="/deleteVisa?idClient=<c:out value='${country.getIdCountry()}'/>"><span
                        class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${base}/visa" class="btn btn-primary">Add new Visa</a>

    <table class="table" style="margin-top: 30px;">
        <thead>
        <tr>
            <th>Orders from user</th>
        </tr>
        </thead>
        <thead>
        <tr>
            <th>Hotel</th>
            <th>Begin Date</th>
            <th>End Date</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="ordersList" items="${orderdetails}">
            <tr>
                <td><c:out value="${ordersList.getHotel().getHotelName()}"/></td>
                <td><c:out value="${ordersList.getBeginDate()}"/></td>
                <td><c:out value="${ordersList.getEndDate()}"/></td>
                <td><a href="${pageContext.request.contextPath}/orderDelete?idOrder=<c:out
                value='${ordersList.getId()}'/>"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

