package Model;

//Model page for user.
import java.io.File;

import javax.servlet.http.Part;

import Resources.MyConstants;

public class user {
	String FirstName, LastName, Number, Email, Password, Role, Image;

	public user() {}
	
	public user(String FirstName, String LastName, String Number, String Email, String Password, String Role, Part Image)
	{
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Number = Number;
		this.Email = Email;
		this.Password = Password;
		this.Role = Role;
		this.Image = getImageURL(Image);
	}
	
	public String getImage() {
		return Image;
	}
	public void setImage(Part Image) {
		this.Image = getImageURL(Image);
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	
	public String getNumber() {
		return Number	;
	}
	public void setNumber(String Number) {
		this.Number = Number;
	}
	
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	
	public String getRole() {
		return Role;
	}
	public void setRole(String Role) {
		this.Role = Role;
	}
	
	
	public String getImageURL(Part Image) {
		String savePath = MyConstants.IMAGE_DIR_SAVE_PATH;
		File fileSaveDir = new File(savePath);
		String ImageURL = null;
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
