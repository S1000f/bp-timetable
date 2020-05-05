package model.data;

public class LoginDto {
	
	private String user;
	private String password;
	private int hasSubject;
	private int hasPlan;
	
	public LoginDto(String user, String password, int hasSub, int hasPlan) {
		this.user = user;
		this.password = password;
		this.hasSubject = hasSub;
		this.hasPlan = hasPlan;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
