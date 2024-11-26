<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/26/2024
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Add Car">
    <h1>Add Car</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label class="form-label" for="licensePlate">License Plate</label>
                <input type="text" class="form-control" id="licensePlate" name="licensePlate" required>
                <div class="invalid-feedback">
                    Please provide a valid license plate.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label" for="parkingSpot">Parking Spot</label>
                <input type="text" class="form-control" id="parkingSpot" name="parkingSpot" required>
                <div class="invalid-feedback">
                    Please provide a valid parking spot.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label class="form-label" for="userId">Owner</label>
                <select class="form-select" id="userId" name="userId" required>
                    <option value="">Choose...</option>
                    <c:forEach var="user" items="${users}" varStatus="status">
                        <option value="${user.id}">${user.name}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select an owner.
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>

</t:pageTemplate>
