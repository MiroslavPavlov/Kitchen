package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.dao.IUserDAO;
import model.dao.IUserDAO.DataSource;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			if(username!=null && password!=null){
				for(User u : IUserDAO.getDAO(DataSource.DB).getAllUsers()){
					if(u.getUsername().equals(username) && u.getPassword().equals(password)){
						request.getSession().setAttribute("loggedUser", u);
					    RequestDispatcher rd = request.getRequestDispatcher("/main_pages/main.html");
						rd.forward(request, response);
					}
				}
			}
			request.setAttribute("dataError", "Wrong username or password");
			request.getRequestDispatcher("/login/LoginForm.jsp").forward(request, response);
	    } catch (SQLException e) {
	    	e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

	

}
