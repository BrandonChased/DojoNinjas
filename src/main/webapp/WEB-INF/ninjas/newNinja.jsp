<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <h1 class="display-1 mt-5">New Ninja</h1>
        <form:form action="/ninjas" method="post" modelAttribute="ninja" class="w-50">
        <div class="form-control my-3">
            <form:label path="dojo">Dojo:</form:label>
            <form:select path="dojo">
                <c:forEach var="dojo" items="${dojos}"> 
                    <form:option value="${dojo.id}">
                        ${dojo.name}
                    </form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-control my-3">
            <form:label path="first">First Name:</form:label>
            <form:input path="first"/>
        </div>
        <div class="form-control my-3">
            <form:label path="last">Last Name:</form:label>
            <form:input path="last"/>
        </div>
        <div class="form-control my-3">
            <form:label path="age">Age:</form:label>
            <form:input path="age"/>
        </div>
        <button class="btn btn-primary">Create Dojo</button>
        </form:form>
    </div>
</body>
</html>