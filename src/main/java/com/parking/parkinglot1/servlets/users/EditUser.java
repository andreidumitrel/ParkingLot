package com.parking.parkinglot1.servlets.users;

import com.parking.parkinglot1.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/edituser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        userBean.updateUser(Long.valueOf(request.getParameter("id")),request.getParameter("username"), request.getParameter("email"), request.getParameter("password"));

    }
}