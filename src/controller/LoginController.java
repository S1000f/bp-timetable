package controller;

import model.data.LoginDao;
import model.data.LoginDto;

public class LoginController {
	private LoginDto loginDto;
	private LoginDao loginDao;
	
	public LoginController() {
		this.loginDto = new LoginDto("nouser", "nopassword", 0, 0);
		this.loginDao = new LoginDao();
	}
	
	public LoginDto getLoginDto() {
		return loginDto;
	}
	
	public int loginUser(String user, String password) {
		loginDto.setUser(user);
		loginDto.setPassword(password);
		LoginDto result = loginDao.loginUser(loginDto);
		if(result != null && result.getUser().equals(loginDto.getUser()) && result.getPassword().equals(loginDto.getPassword())) {
			loginDto = result;
			return 1; // login success
		} else if(result == null) {
			return 2; // no such a user or incorrect password
		}
		
		return 3;
	}
	
	public int signUp(String user, String password) {
		loginDto.setUser(user);
		loginDto.setPassword(password);
		int check = loginDao.checkUser(loginDto);
		if(check == 1) {
			check = loginDao.insertUser(loginDto);
			if(check == 0 || check == -1) {
				return 3; // SQL failed or DB connection error
			} else {
				return 1; // insert user success
			}
		} else if(check == 2) {
			return 2; // user exists
		} else {
			return 3; // DB connection error
		}
	}
	
}
