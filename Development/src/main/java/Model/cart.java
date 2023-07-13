package Model;

// Model page for cart 
public class cart extends product{
    private int quantity;




    public cart() {
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int deletCartItem(int cartItemID) {
        // TODO Auto-generated method stub
        return 0;
    }
    
  //for product name
  	public String getProductName() {
  		return ProductName;
  	}

  	public void setProductName(String ProductName) {
  		this.ProductName = ProductName;
  	}
  	
  	


}