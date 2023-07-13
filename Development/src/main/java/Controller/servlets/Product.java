package Controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import Model.product;
import Resources.MyConstants;

@WebServlet("/Product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class Product extends HttpServlet {
	
	//Servlet page for Product.jsp page
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductName = request.getParameter("ProductName");
        String Brand = request.getParameter("Brand");
        String Stock = request.getParameter("Stock");
        String Price = request.getParameter("Price");
        Part Image= request.getPart("Image");

        //Storing the image 
        product Products= new product(ProductName,Brand,Stock,Price,Image);
        String savePath = request.getServletContext().getRealPath("/")+"productImage/";
	    System.out.print(savePath+Image.getSubmittedFileName());
	    String fileName = Products.getImage();
	    if(fileName != null && !fileName.isEmpty()) {
	    	Files.copy(Image.getInputStream(), Paths.get(savePath+ProductName+"_"+Image.getSubmittedFileName()), StandardCopyOption.REPLACE_EXISTING);
	    }
	    
        Connections con = new Connections();
        int result = con.registerProduct(MyConstants.products, Products);
        System.out.print(con.registerProduct(MyConstants.products, Products));
        if(result == 1) {
            //request.setAttribute("registerMessage", "Successfully Registered");
        	PrintWriter out = response.getWriter();
            request.getRequestDispatcher("/Pages/Admin.jsp").forward(request, response);
        }else if(result == -1) {
            request.setAttribute("registerMessage", "User Already Exists");
            PrintWriter out = response.getWriter();
            out.print("out");
            //request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
        }else {
            //request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
            PrintWriter out = response.getWriter();
            out.print("hghidsfigs");
        }
            }
}
