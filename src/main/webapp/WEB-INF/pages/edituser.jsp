<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 1/14/2025
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="EditUser">
    <div class="col-md-7 col-lg-8">
    <h4 class="mb-3">Edit an User</h4>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
    <div class="row g-3">
        <div class="col-md-6 mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="" value="${user.name}" required>
            <div class="invalid-feedback">
                Valid name is required.
            </div>
        </div>

        <div class="col-md-6 mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="youremail@domain.com" value="${user.email}" required>
            <div class="invalid-feedback">
                Valid spot is required.
            </div>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label" for="user_groups">Groups</label>
            <select class="form-select" id="user_groups" name="user_groups" multiple>
                <option value="">Choose...</option>
                <c:forEach var="user_group" items="${userGroups}" varStatus="status">
                    <option value="${user_group}">${user_group}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">
                Please select a group.
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <label class="form-label" for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="" value="">
            <div class="invalid-feedback">
                Please provide a valid password.
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="user_id" value="${user.id}" />
        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
    </div>
</t:pageTemplate>
