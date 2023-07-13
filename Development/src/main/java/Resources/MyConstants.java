package Resources;

import java.io.File;

public class MyConstants {
	// Start Region: Database Configuration
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/coursework";
	public static final String DB_USER_NAME = "root"; 		
	public static final String DB_USER_PASSWORD= ""; 
	
	public static final String ADMIN = "admin";
	public static final String USER = "user";
	
	//For Image Directorys and save paths
	public static final String IMAGE_DIR = "Courswork\\Images\\";
	public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR;
	// End Region: Database Configuration
	
	public static final String PRO_IMAGE_DIR = "Courswork\\Images\\";
	public static final String PRO_IMAGE_DIR_SAVE_PATH = "C:" + File.separator + PRO_IMAGE_DIR;
	
	//For Login and Registers
	// Start Region: Select Query
	public static final String CHECK_LOGIN_INFO = "SELECT * FROM register WHERE Email = ? AND Password = ?";
	//public static final String GET_ALL_INFO = "SELECT * FROM register";
	//public static final String GET_ALL_INFO_BY_ID = "SELECT * FROM register WHERE id = ?";
	public static final String IS_USER = "SELECT * FROM register WHERE Email = ? and Role=?";
	
	//For Products and add products
	public static final String products = "INSERT INTO product"
			+ "(ProductName, Brand, Stock, Price, Image)"
			+ " VALUES(?,?,?,?,?)";
	public static final String check_products = "SELECT * FROM product WHERE ProductName = ?";
	
	public static final String cart = "INSERT INTO cart"
			+ "(order_id, Email, Product_Name)"
			+ " VALUES(?,?,?)";
	public static final String check_cart = "SELECT * FROM cart WHERE order_id = ?";
	
	// Start Region: Insert Query
	public static final String USER_REGISTER = "INSERT INTO register"
			+ "(FirstName, LastName, Number, Email, Password, Role, Image)"
			+ " VALUES(?,?,?,?,?,?,?)";
	
	// End Region: Insert Query
	
	// Start Region: Update Query
	public static final String UPDATE_USER_INFO = "UPDATE register SET FirstName=?, "
				+ "LastName=?, Email=?, role=? WHERE Email=?";
	// End Region: Update Query
		
	// Start Region: Delete Query
	public static final String DELETE_USER = "DELETE FROM register WHERE Email=?";
	// End Region: Delete Query 
	public static final String ADD_CART = "INSERT INTO cart"
			+ "(card_id,Email,Product_Name)"
			+ " VALUES(?,?,?)";

}
