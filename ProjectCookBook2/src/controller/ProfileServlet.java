package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.User;
import model.dao.IUserDAO;
import model.dao.IUserDAO.DataSource;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login/changeProfile.jsp");
		rd.forward(request, response);
	}
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String passConf=request.getParameter("passConf");
		if(password.equals("Password") || email.equals("Email Address") || firstname.equals("First Name")|| lastname.equals("Last Name")){
			return;
		}
		if(passConf.equals(password)){
			loggedUser.setPassword(password);
			loggedUser.setEmail(email);
			loggedUser.setFirstname(firstname);
			loggedUser.setLastname(lastname);
			IUserDAO.getDAO(DataSource.DB).updateUser(loggedUser);
			RequestDispatcher rd = request.getRequestDispatcher("/main_pages/main.html");
			rd.forward(request, response);
			
		}
		else
			return;
	}

}
