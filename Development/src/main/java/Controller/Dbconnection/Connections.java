package Controller.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.passwordEncrypt;
import Model.product;
import Model.user;
import Model.cart;
import Resources.MyConstants;

/*Initializing the connection */ 
public class Connections {	
	Connection dbconnection = getConnection();
	
	public Connection getConnection(){
		if(dbconnection!=null) {
			return dbconnection;
		}else {
		}
		try {
			Class.forName(MyConstants.DRIVER_NAME);
			Connection connection = DriverManager.getConnection(
					MyConstants.DB_URL,
					MyConstants.DB_USER_NAME,
					MyConstants.DB_USER_PASSWORD);
			return connection;
		}catch(SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			
		}
		return null;
	}
	
	//	Start region Read operation
	public List<user> getAllData(String query) {
        List<user> dataList = new ArrayList<user>();
		Connection dbConnection = getConnection();
		if(dbConnection != null) {
			try {
	            Statement stmt = dbConnection.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	user data = new user();
	                data.setFirstName(rs.getString("FirstName"));
	                data.setLastName(rs.getString("LastName"));
	                data.setNumber(rs.getString("Number"));
	                data.setEmail(rs.getString("Email"));
	                data.setPassword(rs.getString("Password"));
	                data.setRole(rs.getString("Role"));
	                dataList.add(data);
	            }
	            rs.close();
	            stmt.close();
	            dbConnection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
        return dataList;
	}
	
	//to use where and select query
	public ResultSet selectWhereQuery(String query, String id) {
		Connection dbConnection = getConnection();
		if(dbConnection != null) {
			try {
				PreparedStatement statement = dbConnection.prepareStatement(query);
				statement.setString(1, id);
				ResultSet result = statement.executeQuery();
				return result;
			} catch (SQLException e) {
				return null;
			}
		}else {
			return null;
		}
	}

	//checks wether the useris alreday registered or not
	public Boolean isUserAlreadyRegistered(String Email, String password) 
	{
		//Connection dbConnection = getConnection();
		if(dbconnection != null)
		{
			try {
				PreparedStatement statement = dbconnection.prepareStatement(MyConstants.CHECK_LOGIN_INFO);
				statement.setString(1, Email);
				statement.setString(2, password);

				ResultSet result = statement.executeQuery();
					if(result.next())
					{
					return true;		
					}
					else return false;
				}
			
			catch (SQLException e) {e.printStackTrace();}
		}
		
		else 
			{ return false; }	
			return null;
	}
						
	//checks if the user is registered for signup or not 
	public Boolean isUserRegistered(String query, String Email, String pwd) throws Exception {
		//Connection dbConnection = getConnection();
			try {
				if(dbconnection != null) {
				PreparedStatement statement = dbconnection.prepareStatement(query);
				statement.setString(1, Email);
				statement.setString(2, pwd);
				ResultSet result = statement.executeQuery();
				if(result.next()) {
					return true;
				}
			}
				else {
					return false;
			} 
				}catch (SQLException e) { 
				e.printStackTrace();	
				System.out.println(e.getMessage());
				}
			return false;
	}
	
	
	//checks wether the role is admin or not
	public int isAdmin(String Email) {
		//Connection dbconnection = getConnection();
		if(dbconnection != null) {
			try {
				PreparedStatement statement = dbconnection.prepareStatement(MyConstants.IS_USER);
				statement.setString(1, Email);
				statement.setString(2, "admin");
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					return 1;
				}
				else {
					return 0;
				}
			} catch (SQLException e) { return -2; }
		}else { return -3; }
	}
	//	End region Read operation

	//	to register the user to the database
	public int registerUser(String query, user userModel) {
		//Connection dbConnection = getConnection();
		if(dbconnection != null) {
			try {
				if(isUserAlreadyRegistered(userModel.getEmail(), passwordEncrypt.encrypt(
						userModel.getPassword(), "ourcourseworkkey"))) return -1;
				
				PreparedStatement statement = dbconnection.prepareStatement(query);
				statement.setString(1, userModel.getFirstName());
				statement.setString(2, userModel.getLastName());
				statement.setString(3, userModel.getNumber());
				statement.setString(4, userModel.getEmail());
				statement.setString(5, passwordEncrypt.encrypt(
						userModel.getPassword(), "ourcourseworkkey"));
				statement.setString(6, userModel.getRole());
				statement.setString(7, userModel.getImage());

				int result = statement.executeUpdate();
				if(result>=0) return 1;
				else return 0;
			} catch (Exception e) { e.printStackTrace();
			System.out.print(e.getMessage());}
		}else { return -3; }
		return 0;
	}
	//	End region Create operation
	
	
	
	
	
	//	updates user information in the database
	public Boolean updateUser(String query, String Email) {
		Connection dbConnection = getConnection();
		if(dbConnection != null) {
			try {
				PreparedStatement statement = dbConnection.prepareStatement(query);
				statement.setString(1, Email);
				int result = statement.executeUpdate();
				if(result>=0)return true;
				else return false;
			} catch (SQLException e) { return null; }
		}else { return null; }
	}
	//	End region Update operation
	
	//	deletes the users data from the database 
	public Boolean deleteUser(String query, String username) {
		Connection dbConnection = getConnection();
		if(dbConnection != null) {
			try {
				PreparedStatement statement = dbConnection.prepareStatement(query);
				statement.setString(1, username);
				int result = statement.executeUpdate();
				if(result>=0)return true;
				else return false;
			} catch (SQLException e) { return null; }
		}else { return null; }
	}
	//	End region Delete operation
	
	//to add the prodcut to the product page
	public int registerProduct(String query, product Products) {
		//Connection dbConnection = getConnection();
		if(dbconnection != null) {
			try {
				
				String name = Products.getProductName();
				System.out.println(name);
				
				if(ProductRegistered(Products.getProductName())) 
					return -1;
				
				PreparedStatement statement = dbconnection.prepareStatement(query);
				statement.setString(1, Products.getProductName());
				statement.setString(2, Products.getBrand());
				statement.setString(3, Products.getStock());
				statement.setString(4, Products.getPrice());
				statement.setString(5, Products.getImage());

				int result = statement.executeUpdate();
				if(result>=0) return 1;
				else return 0;
			} catch (Exception e) { e.printStackTrace();
			System.out.print(e.getMessage());}
		}else { return -3; }
		return 0;
	}
	
	//chekcs if the product is registerd or not
	private boolean ProductRegistered(String ProductName) {
        try {
            if (dbconnection != null) {
            PreparedStatement state = dbconnection.prepareStatement(MyConstants.check_products);
            state.setString(1, ProductName);
            ResultSet results = state.executeQuery();
            	if (results.next()) {
            		return true;
            		} 
            	
            		else {
            			return false;
            		}
           	}
            else {
            	return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
	}
	
	//deletes the prodcut form the database
	public Boolean deleteproduct(String query) {

        if(dbconnection != null) {
            try {
                PreparedStatement statement = dbconnection.prepareStatement(query);
                int result = statement.executeUpdate();
                if(result>=0)return true;
                else return false;
            } catch (SQLException e) { return null; }
        }else { return null; }
    }

	//updates the product details in the database
	public Boolean updateproduct(String query, String Product_Name) {

    if(dbconnection != null) {
        try {
            PreparedStatement statement = dbconnection.prepareStatement(query);
            statement.setString(1, Product_Name);
            int result = statement.executeUpdate();
            if(result>=0)return true;
            else return false;
        } catch (SQLException e) { e.printStackTrace(); }
    }else { return true; }
    	return false;
	}
	
	//adds product to the cart
	public int addCart(String query, cart cartModel) {
        Connection dbConnection = getConnection();
        int result = 0;
        try {
            PreparedStatement st= dbConnection.prepareStatement(query);
            //st.setString(1, cartModel.getEmail());
            st.setString(2, cartModel.getProductName());
            result = st.executeUpdate();

            return result;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return result;
        }

    }
	
	//
	public int cart(String query, cart Carts) {
		//Connection dbConnection = getConnection();
		if(dbconnection != null) {
			try {
				
				String name = Carts.getProductName();
				System.out.println(name);
				
		
				
				PreparedStatement statement = dbconnection.prepareStatement(query);
				
				statement.setString(3, Carts.getProductName());
		
				int result = statement.executeUpdate();
				if(result>=0) return 1;
				
			} catch (Exception e) { e.printStackTrace();
			System.out.print(e.getMessage());}
		}else { return -3; }
		return 0;
	}
	
}