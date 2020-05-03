package controller;

import model.data.LoginDB;
import model.data.LoginDto;

public class LoginController {
	private String user;
	private String password;
	private int hasSubject;
	private int hasPlan;
	private LoginDto loginDto;
	private LoginDB loginDB;
	
	
	public LoginController(String user, String password) {
		this.user = user;
		this.password = password;
		this.hasSubject = 0;
		this.hasPlan = 0;
		this.loginDto = new LoginDto(user, password);
		this.loginDB = new LoginDB();
	}
	
	public int loginUser() {
		LoginDto result = loginDB.loginUser(loginDto);
		if(result != null && result.getUser() == loginDto.getUser()) {
			return 0;
		} else if(result == null) {
			return 1;
		}
		
		return 2;
	}
}
