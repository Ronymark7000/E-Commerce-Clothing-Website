package Controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Dbconnection.Connections;
import Model.cart;
import Resources.MyConstants;

//Servlet page for Cart.jsp

@WebServlet( "/Cart" )
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	maxFileSize = 1024 * 1024 * 10, // 10MB
	maxRequestSize = 1024 * 1024 * 50)
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//
    	try (PrintWriter out = response.getWriter())
    		{
    	
    		// out.print("add to cart servlet");

    		ArrayList<cart> cartList = new ArrayList<>();

    		String name = request.getParameter("Product_Name");
    		cart cartModel = new cart();
    		cartModel.setProductName(name);
    		cartModel.setQuantity(1);

    		HttpSession session = request.getSession();
    		ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart-list");

    		if (cart_list == null) {

    			cartList.add(cartModel);

    			session.setAttribute("cart-list", cartList);

    			response.sendRedirect("index.jsp");

    		} else {

    			cartList = cart_list;

    			boolean exist = false;

    			for (cart c : cart_list) {

    				if (c.getProductName() == name) {

    					exist = true;

    					out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");

    				}	
    				
    			}

    			if (!exist) {

    				cartList.add(cartModel);

    				response.sendRedirect("../Pages/Home.jsp");

    			}
    		}
    		}
    }
}








