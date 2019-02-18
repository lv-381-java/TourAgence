<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%--<script> function change(obj) {--%>
    <%--let selected = obj.options[obj.selectedIndex].value;--%>
    <%--let city = document.getElementById("city");--%>

    <%--if (selected != null) {--%>
    <%--city.style.visibility = "visible";--%>
    <%--city.reload();--%>
    <%--}--%>
    <%--else {--%>
    <%--city.style.display = "none";--%>
    <%--}--%>
    <%--}--%>
    <%--</script>--%>

    <%--<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js">--%>
    <%--$("#countrySelect").change(function() {--%>
    <%--$("select option:selected").first().each(function() {--%>
    <%--// Get and convert the data for sending--%>
    <%--// Example: This variable contains the selected option-text--%>
    <%--var outdata = $(this).text();--%>
    <%--// Send the data as an ajax POST request--%>
    <%--$.ajax({--%>
    <%--url: "hotelInfo",--%>
    <%--type: 'POST',--%>
    <%--dataType: 'json',--%>
    <%--data: JSON.stringify(outdata),--%>
    <%--contentType: 'application/json',--%>
    <%--mimeType: 'application/json',--%>
    <%--success: function(data) {--%>
    <%--// Remove old select options from the DOM--%>
    <%--$('#citySelect')--%>
    <%--.find('option')--%>
    <%--.remove()--%>
    <%--.end();--%>
    <%--// Parse data and append new select options--%>
    <%--//(omitted here; e.g. $('#byCollege').append($("<option>").attr(...))--%>
    <%--},--%>
    <%--error: function(data, status, er) {--%>
    <%--alert("error: " + data + " status: " + status + " er:" + er);--%>
    <%--}--%>
    <%--});--%>
    <%--});--%>
    <%--});--%>
    <%--</script>--%>

    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js">
        // $country = $("#countrySelect");

        $(document).ready(function () {
            $(document).on("change", "#countrySelect", (function () {
                    let countryName = $(this).text();
                    console.log("SELECTED !!!!!!!!!!!!!")
                    getCities(countryName);

                    // $.ajax({
                    //     type: "POST",
                    //     url: "/hotelInfo",
                    //     data: {city: $country.attr("selectedIndex")},
                    //     success: function (data) {
                    //         console.log("ajax success");
                    //         alert(data);
                    //         $("#countrySelect").html(data)
                    //     },
                    //     error: function () {
                    //         console.log("ajax error");
                    //         alert('error in ajax !!!');
                    //     }
                    // });
                })
            )
        });

        function getCountry() {
            $.ajax({
                url: "/hotelInfo",
                data: {countryName: countryName},
                dataType: "json",
                type: "POST",
                error: function () {
                    alert("An error ocurred.");
                },
                success: function (data) {
                    let items = "";
                    $.each(data, function (i, item) {
                        items += "<option value=\"" + item.Value + "\">" + item.Text + "</option>";
                    });
                    $("#countrySelect").html(items);
                }

            });
        }


        function getCities(countryName) {
            $.ajax({
                url: "/hotelInfo",
                data: {countryName: countryName},
                dataType: "json",
                type: "POST",
                error: function () {
                    alert("An error ocurred.");
                },
                success: function (data) {
                    let items = "";
                    $.each(data, function (i, item) {
                        items += "<option value=\"" + item.Value + "\">" + item.Text + "</option>";
                    });
                    $("#citySelect").html(items);
                }

            });
        }
    </script>
</head>

<div class="row">
    <div class="col-md-2 col-xs-12">
        <%--<form method="post" action="hotelInfo">--%>

            <div class="form-group">
                <label class="control-lavel col-sm-12">Country</label>

                <select id="countrySelect" class="form-control" name="country" title="Country"
                        onchange="getCountry()"> <%--onchange="change(this)"--%>
                    <option value="All">All</option>
                    <c:forEach var="countryList" items="${country}">
                        <option value="${countryList.getCountryName()}">
                                ${countryList.getCountryName()}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label class="contol-label col-sm-12">City</label>
                <select id="citySelect" class="form-control" name="city" title="City" style="visibility: visible">
                    <option value="All">All</option>
                    <c:forEach var="cityList" items="${city}">
                        <option value="${cityList.getCityName()}">
                                ${cityList.getCityName()}
                        </option>
                    </c:forEach>
                </select>
            </div>


            <button type="submit" class="btn btn-primary">Ok</button>
            <a href="/hotelInfo" class="btn btn-primary">Reset</a>
        </form>
    </div>
</div>


<div class="container">
    <h1 style="color: #0A0B0D">List of Hotels: </h1>
    <table class="table">
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
                <td><c:out value="${hotelList.getHotelName()}"/></td>
                <td><c:out value="${hotelList.getCity().getCityName()}"/></td>
                <td><c:out value="${hotelList.getCity().getCountry().getCountryName()}"/></td>
                <td><c:out value="${hotelList.getAvailableCount()}"/></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

