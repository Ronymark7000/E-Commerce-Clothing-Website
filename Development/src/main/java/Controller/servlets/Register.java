package Controller.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Controller.Dbconnection.Connections;
import Model.user;
import Resources.MyConstants;


@WebServlet( "/Register" )
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	maxFileSize = 1024 * 1024 * 10, // 10MB
	maxRequestSize = 1024 * 1024 * 50)
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Servlet page for Register.jsp page
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Number = request.getParameter("Number");
		String Email = request.getParameter("Email");
		String  Password = request.getParameter("Password");
		String  Role = request.getParameter("Role");
		Part ImageFile = request.getPart("Image");
		user userModel = new user(FirstName, LastName, Number, Email, Password, Role, ImageFile);
		
		//Storing image 
	    String savePath = request.getServletContext().getRealPath("/")+"userImage/";
	    System.out.print(savePath+ImageFile.getSubmittedFileName());
	    String fileName = userModel.getImage();
	    if(!fileName.isEmpty() && fileName != null) {
	    	Files.copy(ImageFile.getInputStream(), Paths.get(savePath+Email+"_"+ImageFile.getSubmittedFileName()), StandardCopyOption.REPLACE_EXISTING);
	    }
//ImageFile.write(savePath + fileName);
	    	//ImageFile.write(fileName);
		
		Connections dbconnection = new Connections();
		int result = dbconnection.registerUser(MyConstants.USER_REGISTER, userModel);
		if(result == 1) {
			request.setAttribute("registerMessage", "Successfully Registered");
			request.getRequestDispatcher("/Pages/Login.jsp").forward(request, response);
		}else if(result == -1) {
			request.setAttribute("registerMessage", "User Already Exists");
			request.getRequestDispatcher("/Pages/Register.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/Pages/Register.jsp").forward(request, response);
		}
		
	}

}
