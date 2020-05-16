package controller;

import model.data.LoginDao;
import model.data.LoginDto;

public class LoginController {
	private LoginDto loginDto;
	private LoginDao loginDao;
	private int hasSub;
	private int hasPlan;
	
	public LoginController() {
		this.loginDto = new LoginDto("nouser", "nopassword", 0, 0);
		this.loginDao = new LoginDao();
		this.hasSub = 0;
		this.hasPlan = 0;
	}
	
	public int loginUser(String user, String password) {
		loginDto.setUser(user);
		loginDto.setPassword(password);
		LoginDto result = loginDao.loginUser(loginDto);
		if(result != null && result.getUser().equals(loginDto.getUser()) && result.getPassword().equals(loginDto.getPassword())) {
			loginDto = result;
			hasSub = result.getHasSubject();
			hasPlan = result.getHasPlan();
			return 1; // success
		} else if(result == null) {
			return 2; // no such a user or incorrect password error
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
				return 1; // success
			}
		} else if(check == 2) {
			return 2; // user exists error
		} else {
			return 3; // DB connection error
		}
	}
	
}
