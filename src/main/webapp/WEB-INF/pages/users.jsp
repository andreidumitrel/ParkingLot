<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <form method="POST" action="${pageContext.request.contextPath}/Users">
    <h1>Users</h1>
    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">

        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser">Add User</a>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/EditUser">Edit User</a>

        <c:if test="${pageContext.request.isUserInRole('INVOICE')}">
            <button type="submit" class="btn btn-secondary btn-lg">Invoice</button>
        </c:if>
    </c:if>
    <div class="container text-center">
        <c:forEach var="user" items="${users}">
            <div class="row">
                <div class="col">
                        <input type="checkbox" name="user_ids" value="${user.id}">
                </div>
                <div class="col">
                        ${user.name}
                </div>
                <div class="col">
                        ${user.email}
                </div>
            </div>
        </c:forEach>
    </div>
    </form>
    <c:if test="${not empty invoices}">
        <h2>Invoices</h2>
        <c:forEach var="username" items="${invoices}">
            ${status.index + 1}. ${username}
            <br/>
        </c:forEach>
    </c:if>
</t:pageTemplate>