<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h2 style="color: #0A0B0D"> Hotels: </h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Hotel</th>
            <th>City</th>
            <th>Country</th>
            <th>Available Count</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="hotelList" items="${hotel}">
            <tr>
                <td><c:out value="${hotelList.getHotelName()}" /></td>
                <td><c:out value="${hotelList.getCity().getCityName()}" /></td>
                <td><c:out value="${hotelList.getCity().getCountry().getCountryName()}" /></td>
                <td><c:out value="${hotelList.getAvailableCount()}" /></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>