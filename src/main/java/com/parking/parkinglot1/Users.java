package com.parking.parkinglot1;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.common.UserDto;
import com.parking.parkinglot1.ejb.CarsBean;
import com.parking.parkinglot1.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    UserBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = usersBean.findAllUsers();
        request.setAttribute("users", users);
        request.setAttribute("activePage", "Users");
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
    }
}
