package Model;

//Model page for Product

import java.io.File;

import javax.servlet.http.Part;

import Resources.MyConstants;

public class product {
	String ProductName, Brand, Stock, Price, Image;

	public product() {}
	
	public product(String ProductName, String Brand, String Stock, String Price, Part Image)
	{
		this.ProductName = ProductName;
		this.Brand = Brand;
		this.Stock = Stock;
		this.Price = Price;
		this.Image = getImageURL(Image);
	}
	
	public String getImage() {
		return Image;
	}
	public void setImage(Part Image) {
		this.Image = getImageURL(Image);
	}
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}
	
	
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String Brand) {
		this.Brand = Brand;
	}
	
	
	public String getStock() {
		return Stock	;
	}
	public void getStock(String Stock) {
		this.Stock = Stock;
	}
	
	
	public String getPrice() {
		return Price;
	}
	public void setPrice(String Price) {
		this.Price = Price;
	}
		
	public String getImageURL(Part Image) {
		String savePath = MyConstants.IMAGE_DIR_SAVE_PATH;
		File fileSaveDir = new File(savePath);
		String ImageURL = "";
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String contentDisp = Image.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				ImageURL = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return ImageURL;
	}

}
