package Controller.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.passwordEncrypt;
import Resources.MyConstants;

@WebServlet("/delProduct")

public class delProduct extends HttpServlet {
	
	//Delete and update servlet page for Admin.jsp

/**
*
*/
private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		switch (method) {

			case ("update"):
				doPut(request, response);
			return;
			
			case ("delete"):
				doDelete(request,response);
			return;
			
			case ("insert"):
				
			return;

		}
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection conn = null;
PreparedStatement stmt = null;

try {
// Establish a connection to the database
String diver = MyConstants.DRIVER_NAME;
try {
Class.forName(diver);
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
conn = DriverManager.getConnection(MyConstants.DB_URL, MyConstants.DB_USER_NAME, MyConstants.DB_USER_PASSWORD);
	String productname = request.getParameter("ProductName");
	String productbrand = request.getParameter("Brand");
	String productprice = request.getParameter("Price");
// Retrieve the user's current password from the database
	String query = "SELECT Brand,Price FROM product WHERE ProductName = ?";
		stmt = conn.prepareStatement(query);
		stmt.setString(1, productname);
	ResultSet rs = stmt.executeQuery();

	if (rs.next()) {
	
	// Update the user's password in the database
	String updateQuery = "UPDATE product SET Product_Price=?,Stock=? WHERE Product_Name = ?";
		stmt = conn.prepareStatement(updateQuery);
		stmt.setString(1, productname);
		stmt.setString(2, productbrand);
		stmt.setString(3, productprice);
	stmt.executeUpdate();
	
		System.out.println("Product updated successfully.");
		} else {
		System.out.println("User not found.");
		}
	} catch (SQLException e) {
	e.printStackTrace();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} finally {
	try {
	if (stmt != null) {
	stmt.close();
	}
	if (conn != null) {
	conn.close();
	}
	} catch (SQLException e) {
	e.printStackTrace();
}
}
}

protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	// Retrieve the ID of the product to be deleted from the request parameters
	String productname = request.getParameter("Product_Name");
	
	// Delete the product from the database
	deleteProductFromDatabase(productname);
	
	// Redirect to the products page
	response.sendRedirect(request.getContextPath()+"/admin_pannel/dashboard/edit_product.jsp");
	//response.sendRedirect("${pageContext.request.contextPath}/admin_pannel/product/product.jsp");
	}
	
	// This method deletes the product with the given ID from the database
	private void deleteProductFromDatabase(String productname) {
	       Connection conn = null;
	       PreparedStatement stmt = null;
	        try {
	    // Establish a connection to the database
	    String diver = MyConstants.DRIVER_NAME;
	    try {
	    Class.forName(diver);
	    } catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    }
	           // Initialize database connection
	       
	    conn = DriverManager.getConnection(MyConstants.DB_URL, MyConstants.DB_USER_NAME, MyConstants.DB_USER_PASSWORD);
	           // Prepare SQL statementString query = "SELECT Password FROM registers WHERE User_name = ?";
	   
	           String sql = "DELETE FROM product WHERE ProductName = ?";
	           stmt = conn.prepareStatement(sql);
	           stmt.setString(1, productname);
	
	           // Execute SQL statement
	           stmt.executeUpdate();
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           // Close database resources
	           try {
	               if (stmt != null) {
	                   stmt.close();
	               }
	               if (conn != null) {
	                   conn.close();
	               }
	           } catch (SQLException e) {
	               e.printStackTrace();
           }
     


}
}
}
