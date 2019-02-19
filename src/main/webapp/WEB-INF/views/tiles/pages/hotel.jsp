<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%--<script> function change(obj) {--%>
    <%--let selected = obj.options[obj.selectedIndex].value;--%>
    <%--let city = document.getElementById("city");--%>

    <%--if (selected != null) {--%>
    <%--city.style.visibility = "visible";--%>
    <%--}--%>
    <%--else {--%>
    <%--city.style.display = "none";--%>
    <%--}--%>
    <%--}--%>
    <%--</script>--%>

    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">

        $country = $("#countrySelect");
        $(document).ready(function () {
            $(document).on("#countrySelect", "change", (function () {
                $("select option:selected").first().each(function () {

                    let country = $(this).text();
                    $.ajax({
                        url: "/hotelInfo",
                        type: 'POST',
                        dataType: 'json',
                        data: JSON.stringify({country: [JSON.stringify(country)], city: ["All"]}),
                        contentType: 'application/json',
                        mimeType: 'application/json',
                        success: function (data) {
                            $country
                                .find('option')
                                .remove()
                                .end();
                            $country.append($("<option>").attr(data))
                        },
                        error: function (data, status, er) {
                            alert("error: " + data + " status: " + status + " er:" + er);
                        }
                    });
                });
            }));
        });

        // $country = $("#countrySelect");

        $(document).on("#countrySelect", "change", (function () {
                let countryName = $(this).text();
                console.log("SELECTED !!!!!!!!!!!!!");

                getCities(countryName);

                $.ajax({
                    type: "POST",
                    url: "/hotelInfo",
                    data: {country: countryName, city: "All"},
                    success: function (data) {
                        console.log("ajax success: on select country");
                        alert("data: " + data + "status: " + status);
                        $country.text(data)
                    },
                    error: function () {
                        console.log("ajax error: on select country");
                        alert("error: " + data + " status: " + status + " er:" + er);
                    }
                });
            })
        );

        function getCountry(obj) {
            let countryName = obj.options[obj.selectedIndex].value;
            $.ajax({
                url: "/hotelInfo",
                dataType: "json",
                // data: JSON.stringify({country: [JSON.stringify(countryName)], city: ["All"]}),
                data: {country : countryName, city : "All", hotel : Object},
                type: "POST",
                // contentType: 'application/json',
                success: function (data) {
                    //alert("getCountry(): " + data);
                    console.log(data.city);
                    let items = "";
                    items += '<option value="All"> All</option>';
                    for (let i = 0; i < data.city.length; i++) {
                        items += '<option value="' + data.city[i] + '">' + data.city[i] + '</option>';
                    }
                    $("#citySelect").html(items);

                },
                error: function () {
                    alert("An error occurred in getCountry(): ");
                }
            });
        }

        function getCities(obj) {
            let city = obj.options[obj.selectedIndex].value;
            let country = document.getElementById("countrySelect").value;
            $.ajax({
                url: "hotelInfo",
                data: {country: country, city: city, hotel : Object},
                type: "POST",
                success: function (data) {
                    console.log("getCities success");
                    // let country = document.getElementById("countrySelect").value;
                    let items = "";
                    for (let i = 0; i < data.hotel.length; i++) {
                        items += '<td>' + data.hotel[i] + '</td>';
                    }
                    $("#hotelBody").html(items);
                    console.log(country)
                },
                error: function () {
                    console.log("An error occurred in getCities(): ");
                }
            });
        }
    </script>
</head>


<div class="row">
    <div class="col-md-2 col-xs-12">
        <form action="hotelInfo" method="post">
            <div class="form-group">
                <label class="control-lavel col-sm-12">Country</label>

                <select id="countrySelect" class="form-control" name="country" title="Country" onchange="getCountry(this)">
                    <option value="All">All</option>
                    <c:forEach var="countryList" items="${country}">
                        <option id="countryOption" value="${countryList.getCountryName()}">
                                ${countryList.getCountryName()}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label class="contol-label col-sm-12">City</label>
                <select id="citySelect" class="form-control" name="city" title="City" style="visibility: visible" onchange="getCities(this)">
                    <option value="All">All</option>
                    <c:forEach var="cityList" items="${city}">
                        <option id="cityOptions" value="${cityList.getCityName()}">
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
    <table class="table" id="hotelTable">
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
            <tr id="hotelBody">
                <td><c:out value="${hotelList.getHotelName()}"/></td>
                <td><c:out value="${hotelList.getCity().getCityName()}"/></td>
                <td><c:out value="${hotelList.getCity().getCountry().getCountryName()}"/></td>
                <td><c:out value="${hotelList.getAvailableCount()}"/></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

