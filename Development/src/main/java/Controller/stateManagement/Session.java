package Controller.stateManagement;

public class Session {

	public Boolean checkUser(String userSession){
    	if(userSession != null && !userSession.isEmpty()) return true;
    	else return false;
    }
}
