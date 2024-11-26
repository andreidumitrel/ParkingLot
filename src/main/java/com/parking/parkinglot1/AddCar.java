package com.parking.parkinglot1;

import com.parking.parkinglot1.common.UserDto;
import com.parking.parkinglot1.ejb.CarsBean;
import com.parking.parkinglot1.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCar", value = "/AddCar")
public class AddCar extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<UserDto> users = userBean.findAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/addCar.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String licensePlate = request.getParameter("licensePlate");
        String parkingSpot = request.getParameter("parkingSpot");
        Long userId = Long.parseLong(request.getParameter("userId"));

        carsBean.createCar(licensePlate, parkingSpot, userId);

        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}