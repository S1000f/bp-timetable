package controller;

import model.data.LoginDao;
import model.data.LoginDto;

public class LoginController {
	private LoginDto loginDto;
	private LoginDao loginDB;
	
	public LoginController(String user, String password) {
		this.loginDto = new LoginDto(user, password, 0, 0);
		this.loginDB = new LoginDao();
	}
	
	public int loginUser() {
		LoginDto result = loginDB.loginUser(loginDto);
		if(result != null && result.getUser().equals(loginDto.getUser()) && result.getPassword().equals(loginDto.getPassword())) {
			loginDto = result;
			return 1;
		} else if(result == null) {
			return 2;
		}
		
		return 3;
	}
	
	public int signUp() {
		
		return 2;
	}
	
}
