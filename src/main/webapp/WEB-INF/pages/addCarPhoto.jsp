<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 12/28/2024
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Car Photo">
    <h1>Add Car</h1>
    <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddCarPhoto">
        <div class="row">
            <div class="col-md-6 mb-3">
                License Plate: ${car.licensePlate}
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="file">Photo</label>
                <input type="file" id="file" name="file" required>
                <div class="invalid-feedback">
                    Please provide a valid photo.
                </div>
            </div>
        </div>
        <input type="hidden" name="car_id" value="${car.id}"/>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
    </form>

</t:pageTemplate>
