package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.dao.IUserDAO;
import model.dao.IUserDAO.DataSource;
import sun.rmi.transport.proxy.HttpReceiveSocket;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String passConf=request.getParameter("passConf");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
	    validateData(username,password,passConf,firstname,lastname,email,request,response);
				 
	}



	private void validateData(String username,String password, String passConf, String firstname, String lastname,String email, HttpServletRequest request,HttpServletResponse response) {
		Boolean isUsernameAvailable=true;
		try{
		if(!username.equals("User Name")&& !password.equals("Password") &&  !passConf.equals("Confirm Password") && !firstname.equals("First Name") && !lastname.equals("Last Name")&& !email.equals("Email Address")){
			for(User u : IUserDAO.getDAO(DataSource.DB).getAllUsers()){
				System.out.println(u.getUsername());
				  if(request.getParameter("username").equals(u.getUsername())){
					  isUsernameAvailable=false;
					   break;
				   }
				}
		
		    if(!isUsernameAvailable){
				request.setAttribute("usernameError", "Username is not available. Please enter another username.");
				request.getRequestDispatcher("/login/RegisterForm.jsp").forward(request, response);
		    }
			else if(!password.equals(passConf)){
					 request.setAttribute("passConfirmation", "Your second password is different. Please try again");
					 request.getRequestDispatcher("/login/RegisterForm.jsp").forward(request, response);
				}
			
			else{
				IUserDAO.getDAO(DataSource.DB).addUser(new User(username,password,firstname,lastname,email));
				request.getRequestDispatcher("/main_pages/main.html").forward(request, response);	
			}
		}
		else{
			request.setAttribute("emptyFieldError", "There are empty fields");
			request.getRequestDispatcher("/login/RegisterForm.jsp").forward(request, response);
		}
		
			
		}catch(SQLException|IOException|ServletException e){
			try {
				e.printStackTrace();
			    response.sendRedirect("error.html");
			}catch (IOException e1) {
			    e1.printStackTrace();
		  }
		}
			
					
		}
		

		
	}


