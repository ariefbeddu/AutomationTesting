package qaautomation.traindec022.pages.api;

public class LoginAPI {
	
	public String loginAPIpayload(String email, String password) {
		String payload = "{\"email\":\""+email+"\",\"password\":\""+password+"\"}";
		return payload;
		
	}
	
	public String loginAPIpath() {
		String path = "/users/sign_in";
		return path;
	}

}