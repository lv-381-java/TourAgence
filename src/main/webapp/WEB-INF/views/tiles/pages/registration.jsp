<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Register-login-form Website Template | Home :: w3layouts</title>

    <style>
        <%@include file='/css/registration.css' %>
    </style>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfonts-->
    <link href='http://fonts.googleapis.com/css?family=Lobster|Pacifico:400,700,300|Roboto:400,100,100italic,300,300italic,400italic,500italic,500' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,300' rel='stylesheet' type='text/css'>
    <!--webfonts-->
</head>
<body>
<!--start-login-form-->
<div class="main">
    <div  class="wrap">
        <div class="Regisration">
            <div class="Regisration-head">
                <h2><span></span>Register</h2>
            </div>
            <form method="post">
                <input name="name" type="text" placeholder="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'First Name';}" >
                <input name="surname" type="text" placeholder="Surname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Last Name';}" >
                <input name="phone" type="text" placeholder="Your phone number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email Address';}" >
                <input name="login" type="text" placeholder="Login" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}" >
                <input name="password" type="password" placeholder="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" >
                <input type="password" placeholder="Confirm your password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = ' Confirm Password';}" >
                <div class="Remember-me">

                    <div class="submit">
                        <input type="submit" onclick="myFunction()" value="Sign Me Up >" >
                    </div>
                    <div class="clear"> </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>