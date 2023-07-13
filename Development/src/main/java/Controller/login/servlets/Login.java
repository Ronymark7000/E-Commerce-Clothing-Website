package Controller.login.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Dbconnection.Connections;
import Model.passwordEncrypt;
import Model.user;
import Resources.MyConstants;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("Email");
		String pwd = request.getParameter("Password");
		
		Connections connection = new Connections();
		
		
		Boolean isUserRegistered;
		try {
			isUserRegistered = connection.isUserRegistered(MyConstants.CHECK_LOGIN_INFO, Email, passwordEncrypt.encrypt( pwd, "ourcourseworkkey"));
		
			
			
			if(isUserRegistered != null && isUserRegistered){
				int isAdmin = connection.isAdmin(Email);
				HttpSession session = request.getSession();
				session.setAttribute("user", Email);
				//setting session to expiry in 30 mins
				session.setMaxInactiveInterval(30*60);

				Cookie userName = new Cookie("user", Email);
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				
				if(isAdmin==1) {
					response.sendRedirect(request.getContextPath()+"/Pages/Admin.jsp" );
				}
				else {
					response.sendRedirect(request.getContextPath()+"/Pages/Home.jsp");
					//System.out.println("pugiyo");	
				}
				
			}else{
				// set error message
				request.setAttribute("errorMessage", "Invalid Email or password");
				// forward request to login page
				RequestDispatcher dispatcher = request.getRequestDispatcher("Pages/Login.jsp");
				dispatcher.include(request, response);
				//System.out.println("pugiyena");
			}
		} catch (Exception e) 	
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
