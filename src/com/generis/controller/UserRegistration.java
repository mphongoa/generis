package com.generis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generis.model.User;
import com.generis.model.UserDAO;


@WebServlet("/users/registration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();

    public UserRegistration() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user = new User();
		user.setDisplayName(request.getParameter("display-name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		userDAO.save(user);
		response.sendRedirect("register-confirm.jsp?email="+user.getEmail());
	}

}
