<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=UTF-8;>
    <title>Tour Agency</title>
</head>
<body bgcolor="#ff69b4">

// Test
<h1> Choose country: </h1>
<select value="Country" name="countrySelect" size="1">

    <c:forEach var="countryList" items="${list}">
        <option>${countryList.getCountryName()}</option>
    </c:forEach>

</select>

<h1> Choose city: </h1>
<select value="City" name="citySelect" size="1">
    <c:forEach var="cityList" items="${city}">
        <option>${cityList.getCityName()}</option>
    </c:forEach>
</select>



</body>
</html>
