<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.ss.touragency.entity.City" %>
<%@ page import="com.ss.touragency.entity.Country" %>
<%@ page import="com.ss.touragency.dao.CountryDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tour Agency</title>
</head>
<body bgcolor="#ffc0cb">
<h1>Welcome in our Tour Agency</h1>
<p>If you want to book hotel you may select the country, the city(in this country) and the hotel!</p>

<select value="Country" name="countrySelect" size="1" >

    <c:forEach var="countryList" items="${list}">
        <option>${countryList.getCountryName()}</option>
    </c:forEach>

</select>

<button>Submit</button>

</body>
</html>