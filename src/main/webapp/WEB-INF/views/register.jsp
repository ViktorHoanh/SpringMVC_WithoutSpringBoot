<%--
  Created by IntelliJ IDEA.
  User: 63200346
  Date: 6/25/2024
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register page</title>
    <link rel="stylesheet" type="text/css" href="/Mini-project-springmvc/getResource/css/register.css">
</head>
<body>
<div class="login-container">
    <form action="<c:url value="/checkRegister"/>" method="get">
        <fieldset>
            <legend>Sign Up</legend>
            <div class="login-info">
                <div class="login-info-component" id="namecomponent">
                    <div>
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                </div>
                <div class="login-info-component">
                    <div>
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                </div>
                <div class="login-info-component" id="passcomponent">
                    <div>
                        <label for="repassword">Confirm Password</label>
                        <input type="password" id="repassword" name="repasssword" required>
                    </div>
                </div>
            </div>
            <button type="submit" >SIGN UP
            </button>
            <a href="<c:url value="/login"/>">< LOG IN</a>
        </fieldset>
    </form>
</div>

<div class="popup-overlay"></div>
<div class="popup">
    <p>Your account has been successfully created</p>
    <button onclick="closePopup()">Confirm</button>
</div>
<script type="text/javascript" src="/Mini-project-springmvc/getResource/js/register.js" ></script>
<script>
    <c:if test="${error.equals('success')}">
    showPopup();
    </c:if>
    <c:if test="${usernameerror != null}">
    let namecomponent = document.getElementById("namecomponent")
    namecomponent.innerHTML = `<div>
                                    <label for="username">Username</label>
                                    <input type="text" id="username" name="username" required>
                                </div>
                                <p class="error-message">${usernameerror}</p>`;
    </c:if>
    <c:if test="${passworderror != null}">
    let passcomponent = document.getElementById("passcomponent")
    passcomponent.innerHTML = `<div>
                                    <label for="repassword">Confirm Password</label>
                                    <input type="password" id="repassword" name="repasssword" required>
                                </div>
                                <p class="error-message">${passworderror}</p>`;
    </c:if>
    function closePopup() {
        document.querySelector('.popup').classList.remove('active');
        document.querySelector('.popup-overlay').classList.remove('active');
        window.location.href = "<c:url value="/login"/>";
    }
</script>
</body>
</html>
